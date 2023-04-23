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

    // Creating two arrays to represent the rooms and their temperatures
    // Using methods to fill the arrays with data
    ArrayList<Integer> roomIds = createRoomArrayList();
    ArrayList<Float> temps = createTempArrayList();

    // Method used to create the roomIds array with 10 rooms
    public static ArrayList<Integer> createRoomArrayList() {
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            rooms.add(i);
        }
        return rooms;
    }

    // Method used to create the temps array with 10 random temperatures
    public static ArrayList<Float> createTempArrayList() {
        ArrayList<Float> temps = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            temps.add(rTemp());
        }
        return temps;
    }

    // Method used to generate realistic random temperatures
    public static float rTemp() {
        return (new Random().nextFloat() * (32 - 5)) + 5;
    }



    public static void main(String[] args) throws InterruptedException, IOException {

        //Creating a new TemperatureServer object, getting the properties from the .properties file, and registering the service
        TemperatureServer service1 = new TemperatureServer();
        Properties prop = service1.getProperties();
        service1.registerService(prop);
        int port = Integer.valueOf(prop.getProperty("service_port"));

        // Building the server
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



    // Method 1, which utilises server streaming rpc to return the temperature details of all the rooms
    @Override
    public void temperatureReadoutRequest(Empty request, StreamObserver<TemperatureReadoutResponse> responseObserver) {

        // Iterating through all the rooms and reporting their id and temperature
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

    // Method 2, which utilizes client streaming rpc to receive a stream of time based temperature automation requests from the client
    @Override
    public StreamObserver<TemperatureAutomationRequest> temperatureAutomation(StreamObserver<TemperatureAutomationResponse> responseObserver) {

        return new StreamObserver<TemperatureAutomationRequest>() {
            // Initialising a string for return message
            String s = "";

            // Error handling for invalid room number, temperature or hour input
            @Override
            public void onNext(TemperatureAutomationRequest value) {
                if (value.getRoomId() < 1 || value.getRoomId() > 10){
                    s += "Error: " + value.getRoomId() + " is an invalid room number!\n";
                    System.out.println("Error: Invalid temperature automation request received!");
                } else if (value.getHour() < 0 || value.getHour() > 24) {
                    s += "Error: " + value.getHour() + " is an invalid hour!\n";
                    System.out.println("Error: Invalid temperature automation request received!");
                }else if (value.getTemperature()< 5 || value.getTemperature() > 32){
                    s += "Error: " + value.getTemperature() + " is an invalid temperature!\n";
                    TemperatureAutomationResponse response = TemperatureAutomationResponse.newBuilder().setMessage(s).setSuccess(false).build();
                    responseObserver.onNext(response);
                    System.out.println("Error: Invalid temperature automation request received!");
                } else {
                    System.out.println("Received automation request received for room: " + value.getRoomId());
                    s += "Room " + value.getRoomId() + " temperature set to " + value.getTemperature() + " at " + value.getHour() + " o'clock.\n";
                }
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                TemperatureAutomationResponse response = TemperatureAutomationResponse.newBuilder().setMessage(s).setSuccess(true).build();
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

    // Method used to retrieve properties from .properties file
    private Properties getProperties() {

        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/Temperature.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("Temperature Service properties:");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
            System.out.println("\t service_port: " +prop.getProperty("service_port"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    // Method used to register service using properties retrieved using getProperties method
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
