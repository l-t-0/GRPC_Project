package ds.Lighting;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.Lighting.LightingServiceGrpc.LightingServiceImplBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class LightingServer extends LightingServiceImplBase{



    public static void main(String[] args) throws InterruptedException, IOException {
        LightingServer service1 = new LightingServer();

        int port = 50052;

        Server server = ServerBuilder.forPort(port)
                .addService(service1)
                .build()
                .start();

        System.out.println("Lighting Server started, listening on " + port);

        server.awaitTermination();
    }

    // Method 1
    @Override
    public void setRoomLighting(SetRoomLightingRequest request, StreamObserver<SetRoomLightingResponse> responseObserver) {

        // Create and set the response message
        SetRoomLightingResponse response = SetRoomLightingResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Lighting set successfully")
                .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // Method 2
    @Override
    public StreamObserver<LightingAutomationRequest> lightingAutomation(StreamObserver<LightingAutomationResponse> responseObserver) {

        LightingAutomationResponse response = LightingAutomationResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Lighting automation set successfully")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        return new StreamObserver<LightingAutomationRequest>() {
            @Override
            public void onNext(LightingAutomationRequest value) {
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
            }
        };
    }

    // Method 3
    @Override
    public void lightingStatusRequest(Empty request, StreamObserver<LightingStatusResponse> responseObserver) {

        List<Integer> roomIds = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Random rd = new Random();

        for (int i = 0; i < roomIds.size(); i++) {
            LightingStatusResponse response = LightingStatusResponse.newBuilder()
                    .setRoomId("Room " + roomIds.get(i))
                    .setIsOn(rd.nextBoolean())
                    .build();
            responseObserver.onNext(response);
        }

        responseObserver.onCompleted();
    }



}
