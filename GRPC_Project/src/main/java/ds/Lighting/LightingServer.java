package ds.Lighting;

import java.io.FileInputStream;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.Lighting.LightingServiceGrpc.LightingServiceImplBase;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;


import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;


public class LightingServer extends LightingServiceImplBase{

    // Creating two arrays to represent the rooms and their lighting statuses
    // Using methods to fill the arrays with data
    ArrayList<Integer> roomIds = createRoomArrayList();
    ArrayList<Boolean> statuses = createStatusArrayList();

    // Method used to create the roomIds array with 10 rooms
    public static ArrayList<Integer> createRoomArrayList() {
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            rooms.add(i);
        }
        return rooms;
    }

    // Method used to create the array of random boolean values to represent the lighting status of the rooms
    public static ArrayList<Boolean> createStatusArrayList() {
        Random rd = new Random();
        ArrayList<Boolean> status = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            status.add(rd.nextBoolean());
        }
        return status;
    }



    public static void main(String[] args) throws InterruptedException, IOException {

        //Creating a new LightingServer object, getting the properties from the .properties file, and registering the service

        LightingServer service1 = new LightingServer();
        Properties prop = service1.getProperties();
        service1.registerService(prop);
        int port = Integer.valueOf(prop.getProperty("service_port"));

        // Building the server
        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(service1)
                    .build()
                    .start();

            System.out.println("Lighting Server started, listening on " + port);

            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // Method 1 which utilises unary rpc to set the lighting status of a single room
    @Override
    public void setRoomLighting(SetRoomLightingRequest request, StreamObserver<SetRoomLightingResponse> responseObserver) {

        // Declaring a string which will be printed later
        String s = "";
        if (request.getIsOn()){
            s = "on.";
        } else {
            s = "off.";
        }

        // Setting the lighting status of the requested room
        statuses.set(request.getRoomId()-1, request.getIsOn());

        // Create and set the response message
        SetRoomLightingResponse response = SetRoomLightingResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Lighting set successfully, the lights in Room " + request.getRoomId() + " are now: " + s)
                .build();

        // Conditional to report success or failure
        if (response.getSuccess()) {
            System.out.println("Lighting set successfully");
        } else {
            System.out.println("Failed to set lighting");
        }


        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // Method 2, which utilises client streaming rpc to receive a stream of lighting automation requests from the client
    @Override
    public StreamObserver<LightingAutomationRequest> lightingAutomation(StreamObserver<LightingAutomationResponse> responseObserver) {

        return new StreamObserver<LightingAutomationRequest>() {
            // Initialising string for return message
            String s = "";

            // Error handling for invalid room number or hour input
            @Override
            public void onNext(LightingAutomationRequest value) {
                if (value.getRoomId() < 1 || value.getRoomId() > 10){
                    s += "Error: " + value.getRoomId() + " is an invalid room number!\n";
                    System.out.println("Error: Invalid lighting automation request received!");
                } else if (value.getHour() < 0 || value.getHour() > 24){
                    s += "Error: " + value.getHour() + " is an invalid hour!\n";
                    System.out.println("Error: Invalid lighting automation request received!");
                } else {
                    String x;
                    System.out.println("Received automation request received for room: " + value.getRoomId());
                    if (value.getTurnOn()) {
                        x = "on";
                    } else {
                        x = "off";
                    }
                    s += "Room " + value.getRoomId() + " set to turn lights " + x + " at " + value.getHour() + " hours.\n";
                }
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                // Returning the message containing information about the automation request
                LightingAutomationResponse response = LightingAutomationResponse.newBuilder().setMessage(s).setSuccess(true).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };
    }

    // Method 3 which utilizes server streaming rpc to return a list of the status of all the room lights
    @Override
    public void lightingStatusRequest(Empty request, StreamObserver<LightingStatusResponse> responseObserver) {

        // Iterating through all the rooms and reporting their id and lighting status
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

    // Method used to retrieve properties from .properties file
    private Properties getProperties() {

        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/Lighting.properties")) {

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

    // Method used to register service using properties retrieved using getProperties method
    private  void registerService(Properties prop) {

        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            String service_type = prop.getProperty("service_type") ;
            String service_name = prop.getProperty("service_name")  ;
            int service_port = Integer.valueOf( prop.getProperty("service_port") );
            String service_description_properties = prop.getProperty("service_description")  ;

            // Register the service
            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
            jmdns.registerService(serviceInfo);

            // Printing out the confirmation of registration
            System.out.printf("Registering service with type %s and name %s \n", service_type, service_name);

            // Wait a bit
            Thread.sleep(1000);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}
