package ds.Lighting;

import java.util.Iterator;
import java.util.Random;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;



public class LightingClient {

    private static LightingServiceGrpc.LightingServiceBlockingStub blockingStub;
    private static LightingServiceGrpc.LightingServiceStub asyncStub;


    public static void main(String[] args) throws Exception {

        // Building a managed channel with the correct hostname and port number
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

        //stubs -- generate from proto
        blockingStub = LightingServiceGrpc.newBlockingStub(channel);
        asyncStub = LightingServiceGrpc.newStub(channel);

        //Demonstrating methods by calling them
        setRoomLighting(5, true);
        lightingStatusRequest();
        setRoomLighting(1, false);
        setRoomLighting(3, true);
        setRoomLighting(8, false);
        setRoomLighting(10, true);
        lightingStatusRequest();
        lightingAutomation();

        // Shutting down channel
        channel.shutdown();

    }

    // Method 1, which utilises unary rpc to turn the lights on or off in a specific room
    public static void setRoomLighting(int roomId, boolean isOn) {

        // Error handling to avoid nonexistent room numbers being used as input
        if (roomId >= 1 && roomId <= 10) {
            SetRoomLightingRequest request = SetRoomLightingRequest.newBuilder()
                    .setRoomId(roomId)
                    .setIsOn(isOn)
                    .build();

            SetRoomLightingResponse response = blockingStub.setRoomLighting(request);
            System.out.println(response.getMessage());
        } else {
            System.out.println("Room Number entered is invalid!");

        }

    }

    // Method 2 which utilises client streaming rpc to automate the lighting based on time
    public static void lightingAutomation() {

        // Handling the stream for client using onNext (logic for handling each message in stream) and onCompleted (logic will be executed after the completion of stream)
        StreamObserver<LightingAutomationResponse> responseObserver = new StreamObserver<LightingAutomationResponse>() {


            // If any of the inputs are invalid, the system will return an error message
            @Override
            public void onNext(LightingAutomationResponse value) {
                    System.out.println(value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub

            }

            // On completion, this message will be printed
            @Override
            public void onCompleted() {
                System.out.println("Lighting automation completed.");
            }

        };

        // Creating a StreamObserver object for the request in order to feed the requests to the server
        StreamObserver<LightingAutomationRequest> requestObserver = asyncStub.lightingAutomation(responseObserver);

        try {
            // Passing in automation requests
            requestObserver.onNext(LightingAutomationRequest.newBuilder().setRoomId(2).setHour(12).setTurnOn(true).build());
            requestObserver.onNext(LightingAutomationRequest.newBuilder().setRoomId(3).setHour(02).setTurnOn(false).build());
            requestObserver.onNext(LightingAutomationRequest.newBuilder().setRoomId(4).setHour(18).setTurnOn(false).build());
            requestObserver.onNext(LightingAutomationRequest.newBuilder().setRoomId(5).setHour(38).setTurnOn(true).build());
            requestObserver.onNext(LightingAutomationRequest.newBuilder().setRoomId(11).setHour(22).setTurnOn(true).build());

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


    // Method 3 which utilises server streaming rpc to acquire a lighting status readout of all the rooms in the building
    public static void lightingStatusRequest(){
        // Creating an empty request
        Empty request = Empty.newBuilder().build();

        try {
            Iterator<LightingStatusResponse> response = blockingStub.lightingStatusRequest(request);

            // Iterating through the responses and printing out the results
            while(response.hasNext()) {
                String s = "";
                LightingStatusResponse temp = response.next();
                s += "Room " + temp.getRoomId() + " lights are ";
                if(temp.getIsOn()) {
                    s += "on.";
                } else {
                    s+= "off.";
                }
                System.out.println(s);
            }

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        }
    }

}
