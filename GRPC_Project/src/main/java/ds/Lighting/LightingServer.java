package ds.Lighting;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.Lighting.LightingServiceGrpc.LightingServiceImplBase;

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

        LightingStatusResponse response1 = LightingStatusResponse.newBuilder()
                .setRoomId("Room 1")
                .setIsOn(true)
                .build();

        LightingStatusResponse response2 = LightingStatusResponse.newBuilder()
                .setRoomId("Room 2")
                .setIsOn(false)
                .build();

        responseObserver.onNext(response1);
        responseObserver.onNext(response2);

        responseObserver.onCompleted();
    }



}
