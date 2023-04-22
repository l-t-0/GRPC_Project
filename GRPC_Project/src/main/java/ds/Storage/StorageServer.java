package ds.Storage;

import java.io.FileInputStream;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.Storage.StorageGrpc.StorageImplBase;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Random;


public class StorageServer extends StorageImplBase{

    String[] systemFileNames = createFileNameArray(100);
    Integer[] systemData = createSystemData(100);
    String[] uploadedFileNames = new String[100];
    Integer[] uploadedData = new Integer[100];


    public static String[] createFileNameArray(int total) {
        String[] fileNames = new String[total];
        for (int i = 0; i < 100; i++) {
            fileNames[i] = generateRandomString();
        }
        return fileNames;
    }

    public static Integer[] createSystemData(int total) {
        Integer[] data = new Integer[total];
        for (int i = 0; i < 100; i++) {
            data[i] = randomInt();
        }
        return data;
    }

    public static int randomInt() {
        Random random = new Random();
        return random.nextInt(10000 - 1 + 1) + 1;
    }

    public static String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 5;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }




    public static void main(String[] args) throws InterruptedException, IOException {
        StorageServer service1 = new StorageServer();

        Properties prop = service1.getProperties();

        service1.registerService(prop);

        int port = Integer.valueOf(prop.getProperty("service_port"));


        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(service1)
                    .build()
                    .start();

            System.out.println("Storage Server started, listening on " + port);

            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    // Method 1
    public StreamObserver<FileUploadRequest> uploadFiles(StreamObserver<FileUploadResponse> responseObserver) {

        return new StreamObserver<FileUploadRequest> () {

            @Override
            public void onNext(FileUploadRequest msg) {
                int id = msg.getFileId();
                System.out.println("Receiving file upload request for file: " + systemFileNames[id] + " with ID of " + id);

                uploadedFileNames[id] = systemFileNames[id];
                uploadedData[id] = systemData[id];

                systemFileNames[id] = null;
                systemData[id] = null;

                FileUploadResponse reply = FileUploadResponse.newBuilder().setFileId(id).setFilename(uploadedFileNames[id]).setMessage("Success").build();

                responseObserver.onNext(reply);

            }

            @Override
            public void onError(Throwable t) {

                t.printStackTrace();

            }

            @Override
            public void onCompleted() {
                System.out.println("File upload complete!");

                responseObserver.onCompleted();
            }

        };
    }

    // Method 2
    public StreamObserver<FileDownloadRequest> downloadFiles(StreamObserver<FileDownloadResponse> responseObserver) {

        return new StreamObserver<FileDownloadRequest> () {

            @Override
            public void onNext(FileDownloadRequest msg) {
                int id = msg.getFileId();
                System.out.println("Receiving file download request for file: " + uploadedFileNames[id]);

                systemFileNames[id] = uploadedFileNames[id];
                systemData[id] = uploadedData[id];

                uploadedFileNames[id] = null;
                uploadedData[id] = null;

                FileDownloadResponse reply = FileDownloadResponse.newBuilder().setFileId(id).setFilename(systemFileNames[id]).setMessage("Success").build();

                responseObserver.onNext(reply);

            }

            @Override
            public void onError(Throwable t) {

                t.printStackTrace();

            }

            @Override
            public void onCompleted() {
                System.out.println("File download complete!");
                responseObserver.onCompleted();
            }

        };
    }

    // Method 3
    @Override
    public void deleteFile(FileDeleteRequest request, StreamObserver<FileDeleteResponse> responseObserver) {

        int id = request.getFileId();

        uploadedFileNames[id] = null;
        uploadedData[id] = null;

        // Create and set the response message
        FileDeleteResponse response = FileDeleteResponse.newBuilder()
                .setSuccess(true)
                .setMessage("File ID: " + request.getFileId() + " has been deleted!")
                .build();

        if (response.getSuccess()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete file");
        }


        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }



    // Method 4
    @Override
    public void requestFileList(Empty request, StreamObserver<FileListResponse> responseObserver) {

        for (int i = 0; i < uploadedFileNames.length; i++) {
            if (uploadedFileNames[i] != null) {
                FileListResponse response = FileListResponse.newBuilder()
                        .setFileId(i)
                        .setFilename(uploadedFileNames[i])
                        .setContent(uploadedData[i])
                        .build();
                responseObserver.onNext(response);
                System.out.println("Result " + i + " sent!");
            }
        }

        responseObserver.onCompleted();
        System.out.println("All uploaded file information sent!");

    }

    private Properties getProperties() {

        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/Storage.properties")) {

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
