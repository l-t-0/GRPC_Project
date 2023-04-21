package ds.Temperature;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.Temperature.TemperatureGrpc.TemperatureImplBase;
import java.util.ArrayList;
import java.util.Random;


public class TemperatureServer extends TemperatureImplBase{

    ArrayList<Integer> roomIds = createRoomArrayList();
    Random rd = new Random();
    ArrayList<Float> temps = createTempArrayList();

    public static ArrayList<Integer> createRoomArrayList() {
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rooms.add(i);
        }
        return rooms;
    }

    public static ArrayList<Float> createTempArrayList() {
        ArrayList<Float> temps = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            temps.add(rTemp());
        }
        return temps;
    }




    public static void main(String[] args) throws InterruptedException, IOException {
        TemperatureServer service1 = new TemperatureServer();

        int port = 50051;

        Server server = ServerBuilder.forPort(port)
                .addService(service1)
                .build()
                .start();

        System.out.println("Temperature Server started, listening on " + port);

        server.awaitTermination();
    }

    public static float rTemp() {
        return (new Random().nextFloat() * (32 - 5)) + 5;
    }


    // Method 1
    @Override
    public void temperatureReadoutRequest(Empty request, StreamObserver<TemperatureReadoutResponse> responseObserver) {

        for (int i = 0; i < roomIds.size(); i++) {
            TemperatureReadoutResponse response = TemperatureReadoutResponse.newBuilder()
                    .setRoomId(roomIds.get(i))
                    .setTemperature(temps.get(i))
                    .build();
            responseObserver.onNext(response);
            System.out.println("Result " + roomIds.get(i) + " sent!");
        }

        responseObserver.onCompleted();
    }

    // Method 2
    @Override
    public StreamObserver<TemperatureAutomationRequest> temperatureAutomation(StreamObserver<TemperatureAutomationResponse> responseObserver) {

        return new StreamObserver<TemperatureAutomationRequest>() {
            String s = "";
            @Override
            public void onNext(TemperatureAutomationRequest value) {
                String x;
                System.out.println("Received automation request received for room: " + value.getRoomId());
                s += "Room " + value.getRoomId() + " temperature set to " + value.getTemperature() + " at " + value.getHour() + " o'clock.\n";
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                TemperatureAutomationResponse response = TemperatureAutomationResponse.newBuilder().setMessage(s).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    // Method 3
    @Override
    public void setRoomTemperature(SetRoomTemperatureRequest request, StreamObserver<SetRoomTemperatureResponse> responseObserver) {

        temps.set(request.getRoomId()-1, request.getTemperature());

        // Create and set the response message
        SetRoomTemperatureResponse response = SetRoomTemperatureResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Temperature set successfully, the temperature in Room " + request.getRoomId() + " is now set to: " + request.getTemperature() + "°C")
                .build();

        if (response.getSuccess()) {
            System.out.println("Temperature set successfully");
        } else {
            System.out.println("Failed to set temperature");
        }


        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
