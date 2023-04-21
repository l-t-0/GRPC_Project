package ds.Lighting;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.Lighting.LightingServiceGrpc.LightingServiceImplBase;
import java.util.ArrayList;
import java.util.Random;


public class LightingServer extends LightingServiceImplBase{

    ArrayList<Integer> roomIds = createRoomArrayList();
    ArrayList<Boolean> statuses = createStatusArrayList();

    public static ArrayList<Integer> createRoomArrayList() {
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rooms.add(i);
        }
        return rooms;
    }

    public static ArrayList<Boolean> createStatusArrayList() {
        Random rd = new Random();
        ArrayList<Boolean> status = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            status.add(rd.nextBoolean());
        }
        return status;
    }



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

        String s = "";
        if (request.getIsOn()){
            s = "on.";
        } else {
            s = "off.";
        }

        statuses.set(request.getRoomId()-1, request.getIsOn());

        // Create and set the response message
        SetRoomLightingResponse response = SetRoomLightingResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Lighting set successfully, the lights in Room " + request.getRoomId() + " are now: " + s)
                .build();

        if (response.getSuccess()) {
            System.out.println("Lighting set successfully");
        } else {
            System.out.println("Failed to set lighting");
        }


        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // Method 2
    @Override
    public StreamObserver<LightingAutomationRequest> lightingAutomation(StreamObserver<LightingAutomationResponse> responseObserver) {

        return new StreamObserver<LightingAutomationRequest>() {
            String s = "";
            @Override
            public void onNext(LightingAutomationRequest value) {
                String x;
                System.out.println("Received automation request received for room: " + value.getRoomId());
                if (value.getTurnOn()){
                    x = "on";
                } else {
                    x = "off";
                }
                s += "Room " + value.getRoomId() + " set to turn lights " + x + " at " + value.getHour() + " o'clock.\n";
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                LightingAutomationResponse response = LightingAutomationResponse.newBuilder().setMessage(s).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    // Method 3
    @Override
    public void lightingStatusRequest(Empty request, StreamObserver<LightingStatusResponse> responseObserver) {


        for (int i = 0; i < roomIds.size(); i++) {
            LightingStatusResponse response = LightingStatusResponse.newBuilder()
                    .setRoomId(roomIds.get(i))
                    .setIsOn(statuses.get(i))
                    .build();
            responseObserver.onNext(response);
            System.out.println("Result " + roomIds.get(i) + " sent!");
        }

        responseObserver.onCompleted();
    }



}
