package ds.Lighting;

import java.io.FileInputStream;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.Lighting.LightingServiceGrpc.LightingServiceImplBase;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;


import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;


public class LightingServer extends LightingServiceImplBase{


    ArrayList<Integer> roomIds = createRoomArrayList();
    ArrayList<Boolean> statuses = createStatusArrayList();

    public static ArrayList<Integer> createRoomArrayList() {
        ArrayList<Integer> rooms = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
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

        Properties prop = service1.getProperties();

        service1.registerService(prop);

        int port = Integer.valueOf(prop.getProperty("service_port"));


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


        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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

            // Error handling for invalid room number or hour input
            String s = "";
            @Override
            public void onNext(LightingAutomationRequest value) {
                if (value.getRoomId() < 1 || value.getRoomId() > 10){
                    s += value.getRoomId() + " is an invalid room number!\n";
                    LightingAutomationResponse response = LightingAutomationResponse.newBuilder().setMessage(s).setSuccess(false).build();
                    responseObserver.onNext(response);
                    System.out.println("Invalid lighting automation request received!");
                } else if (value.getHour() < 0 || value.getHour() > 24){
                    s += value.getHour() + " is an invalid hour!\n";
                    LightingAutomationResponse response = LightingAutomationResponse.newBuilder().setMessage(s).setSuccess(false).build();
                    responseObserver.onNext(response);
                    System.out.println("Invalid lighting automation request received!");
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
