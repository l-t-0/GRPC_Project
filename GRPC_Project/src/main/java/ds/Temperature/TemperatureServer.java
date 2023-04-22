package ds.Temperature;

import java.io.FileInputStream;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.Temperature.TemperatureGrpc.TemperatureImplBase;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
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

        Properties prop = service1.getProperties();

        service1.registerService(prop);

        int port = Integer.valueOf(prop.getProperty("service_port"));


        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(service1)
                    .build()
                    .start();

            System.out.println("Temperature Server started, listening on " + port);

            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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

    private Properties getProperties() {

        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/Temperature.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("Lighting Service properties:");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
            System.out.println("\t service_port: " +prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }


    private  void registerService(Properties prop) {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
            String service_name = prop.getProperty("service_name")  ;// "example";
            // int service_port = 1234;
            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);


            System.out.printf("Registering service with type %s and name %s \n", service_type, service_name);

            // Wait a bit
            Thread.sleep(1000);

            // Unregister all services
            //jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
