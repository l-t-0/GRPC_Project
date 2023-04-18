package ds.Lighting;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

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


    @Override
    public void setRoomLighting(RoomLightingRequest request, StreamObserver<RoomLightingResponse> responseObserver) {
        // Implementation logic to set the lighting of a room based on the request
        // ...
        // Send a response back to the client
        responseObserver.onNext(RoomLightingResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<LightingSettingsRequest> timeBasedLightingAutomation(StreamObserver<TimeBasedLightingResponse> responseObserver) {
        // Implementation logic to handle a stream of time-based lighting requests from the client
        // ...
        // Send a response back to the client
        responseObserver.onNext(TimeBasedLightingResponse.newBuilder().build());
        responseObserver.onCompleted();
        return new StreamObserver<TimeBasedLightingRequest>() {
            @Override
            public void onNext(TimeBasedLightingRequest value) {
                // Handle each incoming request from the client
                // ...
            }

            @Override
            public void onError(Throwable t) {
                // Handle any errors that occur during the streaming process
                // ...
            }

            @Override
            public void onCompleted() {
                // Handle completion of the streaming process
                // ...
            }
        };
    }

    @Override
    public void lightingStatusRequest(LightingStatusRequest request, StreamObserver<LightingStatusResponse> responseObserver) {
        // Implementation logic to retrieve the status of all lights in the building
        // ...
        // Send a stream of data back to the client
        responseObserver.onNext(LightingStatusResponse.newBuilder().build());
        responseObserver.onCompleted();
    }
}
