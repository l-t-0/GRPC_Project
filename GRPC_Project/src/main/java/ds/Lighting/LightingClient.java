package ds.Lighting;

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
import ds.Lighting.Empty;
import io.grpc.stub.StreamObserver;



public class LightingClient {

    private static  Logger logger = Logger.getLogger(LightingClient.class.getName());

    private static LightingServiceGrpc.LightingServiceBlockingStub blockingStub;
    private static LightingServiceGrpc.LightingServiceStub asyncStub;


    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

        //stubs -- generate from proto
        blockingStub = LightingServiceGrpc.newBlockingStub(channel);
        asyncStub = LightingServiceGrpc.newStub(channel);

        setRoomLighting(5, true);
        lightingStatusRequest();
        setRoomLighting(1, false);
        setRoomLighting(3, true);
        setRoomLighting(8, false);
        setRoomLighting(10, true);
        lightingStatusRequest();
        lightingAutomation();
        channel.shutdown();

    }

    public static void lightingAutomation() {

        // Handling the stream for client using onNext (logic for handling each message in stream), onError, onCompleted (logic will be executed after the completion of stream)
        StreamObserver<LightingAutomationResponse> responseObserver = new StreamObserver<LightingAutomationResponse>() {

            @Override
            public void onNext(LightingAutomationResponse value) {
                System.out.println(value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onCompleted() {
                System.out.println("Lighting automation completed.");
            }

        };

        StreamObserver<LightingAutomationRequest> requestObserver = asyncStub.lightingAutomation(responseObserver);

        try {

            requestObserver.onNext(LightingAutomationRequest.newBuilder().setRoomId(1).setHour(22).setTurnOn(true).build());
            requestObserver.onNext(LightingAutomationRequest.newBuilder().setRoomId(2).setHour(12).setTurnOn(true).build());
            requestObserver.onNext(LightingAutomationRequest.newBuilder().setRoomId(3).setHour(02).setTurnOn(false).build());
            requestObserver.onNext(LightingAutomationRequest.newBuilder().setRoomId(4).setHour(18).setTurnOn(false).build());
            requestObserver.onNext(LightingAutomationRequest.newBuilder().setRoomId(5).setHour(12).setTurnOn(true).build());

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

    public static void setRoomLighting(int roomId, boolean isOn) {

        SetRoomLightingRequest request = SetRoomLightingRequest.newBuilder()
                .setRoomId(roomId)
                .setIsOn(isOn)
                .build();

        SetRoomLightingResponse response = blockingStub.setRoomLighting(request);
        System.out.println(response.getMessage());

    }

    public static void lightingStatusRequest(){
        Empty request = Empty.newBuilder().build();

        try {
            Iterator<LightingStatusResponse> response = blockingStub.lightingStatusRequest(request);

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
