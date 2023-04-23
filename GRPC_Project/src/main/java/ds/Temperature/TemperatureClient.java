package ds.Temperature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import ds.Temperature.Empty;
import io.grpc.stub.StreamObserver;



public class TemperatureClient {

    private static  Logger logger = Logger.getLogger(TemperatureClient.class.getName());

    private static TemperatureGrpc.TemperatureBlockingStub blockingStub;
    private static TemperatureGrpc.TemperatureStub asyncStub;


    public static void main(String[] args) throws Exception {

        // Building a managed channel with the correct hostname and port number
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

        //stubs -- generate from proto
        blockingStub = TemperatureGrpc.newBlockingStub(channel);
        asyncStub = TemperatureGrpc.newStub(channel);

        //Demonstrating methods by calling them
        setRoomTemperature(5, 5);
        temperatureReadoutRequest();
        setRoomTemperature(1, 11.5f);
        setRoomTemperature(3, 22);
        setRoomTemperature(8, 30);
        setRoomTemperature(10, 15);
        setRoomTemperature(11, 15);
        setRoomTemperature(5, 99);
        temperatureReadoutRequest();
        temperatureAutomation();

        // Shutting down channel
        channel.shutdown();

    }

    // Method 1, which utilises server streaming rpc to return the temperature details of all the rooms
    public static void temperatureReadoutRequest(){
        // Creating an empty request
        Empty request = Empty.newBuilder().build();

        try {
            Iterator<TemperatureReadoutResponse> response = blockingStub.temperatureReadoutRequest(request);

            // Iterating through the responses and printing out the results
            while(response.hasNext()) {
                TemperatureReadoutResponse temporary = response.next();
                System.out.println("The temperature in room " + temporary.getRoomId() + " is " + temporary.getTemperature() + "°C");
            }

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        }
    }

    // Method 2, which utilises client streaming rpc to automate the temperature based on time
    private static void temperatureAutomation() {

        // Handling the stream for client using onNext (logic for handling each message in stream), and onCompleted (logic will be executed after the completion of stream)
        StreamObserver<TemperatureAutomationResponse> responseObserver = new StreamObserver<TemperatureAutomationResponse>() {

            // If any of the inputs are invalid, the system will return an error message
            @Override
            public void onNext(TemperatureAutomationResponse value) {
                    System.out.println(value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub

            }

            // On completion, this message will be printed
            @Override
            public void onCompleted() {
                System.out.println("Temperature automation completed.");
            }

        };

        // Creating a StreamObserver object for the request in order to feed the requests to the server
        StreamObserver<TemperatureAutomationRequest> requestObserver = asyncStub.temperatureAutomation(responseObserver);

        try {
            // Passing in automation requests
            requestObserver.onNext(TemperatureAutomationRequest.newBuilder().setRoomId(1).setHour(22).setTemperature(100).build());
            requestObserver.onNext(TemperatureAutomationRequest.newBuilder().setRoomId(2).setHour(12).setTemperature(5).build());
            requestObserver.onNext(TemperatureAutomationRequest.newBuilder().setRoomId(3).setHour(02).setTemperature(23.5f).build());
            requestObserver.onNext(TemperatureAutomationRequest.newBuilder().setRoomId(4).setHour(18).setTemperature(11.5f).build());
            requestObserver.onNext(TemperatureAutomationRequest.newBuilder().setRoomId(15).setHour(12).setTemperature(10).build());

            // Mark the end of requests
            requestObserver.onCompleted();

            // Sleep for a bit before sending the next one.
            Thread.sleep(new Random().nextInt(1000) + 500);

        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Method 3, which utilizes unary rpc to set the temperature for a single room
    private static void setRoomTemperature(int roomId, float temp) {

        // Error handling, to avoid incorrect room or temperature inputs
        if (roomId < 1 || roomId > 10){
            System.out.println("The room number you entered is invalid, please enter a valid room number.");
        } else if (temp < 5 || temp > 32){
            System.out.println("The temperature you entered is invalid, please enter a temperature between 5 and 32.");
        } else {
            SetRoomTemperatureRequest request = SetRoomTemperatureRequest.newBuilder()
                    .setRoomId(roomId)
                    .setTemperature(temp)
                    .build();

            SetRoomTemperatureResponse response = blockingStub.setRoomTemperature(request);
            System.out.println(response.getMessage());
        }

    }



}
