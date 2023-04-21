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
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();

        //stubs -- generate from proto
        blockingStub = TemperatureGrpc.newBlockingStub(channel);
        asyncStub = TemperatureGrpc.newStub(channel);

        setRoomTemperature(5, 5);
        temperatureReadoutRequest();
        setRoomTemperature(1, 11.5f);
        setRoomTemperature(3, 22);
        setRoomTemperature(8, 30);
        setRoomTemperature(10, 15);
        temperatureReadoutRequest();
        temperatureAutomation();
        channel.shutdown();

    }

    // Method 1
    public static void temperatureReadoutRequest(){
        Empty request = Empty.newBuilder().build();

        try {
            Iterator<TemperatureReadoutResponse> response = blockingStub.temperatureReadoutRequest(request);

            while(response.hasNext()) {
                String s = "";
                TemperatureReadoutResponse temporary = response.next();
                s += "Room " + temporary.getRoomId() + " lights are ";
                System.out.println("The temperature in room " + temporary.getRoomId() + " is " + temporary.getTemperature() + "°C");
            }

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        }
    }

    // Method 2
    private static void temperatureAutomation() {

        // Handling the stream for client using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
        StreamObserver<TemperatureAutomationResponse> responseObserver = new StreamObserver<TemperatureAutomationResponse>() {

            @Override
            public void onNext(TemperatureAutomationResponse value) {
                System.out.println(value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onCompleted() {
                System.out.println("Temperature automation completed.");
            }

        };

        StreamObserver<TemperatureAutomationRequest> requestObserver = asyncStub.temperatureAutomation(responseObserver);

        try {

            requestObserver.onNext(TemperatureAutomationRequest.newBuilder().setRoomId(1).setHour(22).setTemperature(23.2f).build());
            requestObserver.onNext(TemperatureAutomationRequest.newBuilder().setRoomId(2).setHour(12).setTemperature(5).build());
            requestObserver.onNext(TemperatureAutomationRequest.newBuilder().setRoomId(3).setHour(02).setTemperature(23.5f).build());
            requestObserver.onNext(TemperatureAutomationRequest.newBuilder().setRoomId(4).setHour(18).setTemperature(11.5f).build());
            requestObserver.onNext(TemperatureAutomationRequest.newBuilder().setRoomId(5).setHour(12).setTemperature(10).build());

            System.out.println("SENDING MESSAGES");

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

    // Method 3
    private static void setRoomTemperature(int roomId, float temp) {

        SetRoomTemperatureRequest request = SetRoomTemperatureRequest.newBuilder()
                .setRoomId(roomId)
                .setTemperature(temp)
                .build();

        SetRoomTemperatureResponse response = blockingStub.setRoomTemperature(request);
        System.out.println(response.getMessage());

    }



}
