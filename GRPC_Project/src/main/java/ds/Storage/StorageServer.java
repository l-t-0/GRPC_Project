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

    // Creating two arrays, one for the offline file names, and one for the offline file data and filling them with mock data
    String[] systemFileNames = createFileNameArray(100);
    Integer[] systemData = createSystemData(100);

    // Creating two arrays, one for the uploaded file names and one for the uploaded file data
    String[] uploadedFileNames = new String[100];
    Integer[] uploadedData = new Integer[100];


    // Method to create an array containing 100 random file names
    public static String[] createFileNameArray(int total) {
        String[] fileNames = new String[total];
        for (int i = 0; i < 100; i++) {
            fileNames[i] = generateRandomString();
        }
        return fileNames;
    }

    // Method to create an array containing 100 random ints, to represent file data
    public static Integer[] createSystemData(int total) {
        Integer[] data = new Integer[total];
        for (int i = 0; i < 100; i++) {
            data[i] = randomInt();
        }
        return data;
    }

    // Method to generate a random int between 1 and 10000
    public static int randomInt() {
        Random random = new Random();
        return random.nextInt(10000 - 1 + 1) + 1;
    }

    // Method to generate a random string of length 5 to represent file names
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
        //Creating a new StorageServer object, getting the properties from the .properties file, and registering the service
        StorageServer service1 = new StorageServer();
        Properties prop = service1.getProperties();
        service1.registerService(prop);
        int port = Integer.valueOf(prop.getProperty("service_port"));

        // Building the server
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


    // Method 1, which utilizes bidirectional streaming to upload files to the cloud storage system
    public StreamObserver<FileUploadRequest> uploadFiles(StreamObserver<FileUploadResponse> responseObserver) {

        return new StreamObserver<FileUploadRequest> () {
            //Error handling to avoid invalid id input
            @Override
            public void onNext(FileUploadRequest msg) {
                int id = msg.getFileId();
                if (id < 0 || id > 99){
                    //Creating a reply and sending it to the client
                    FileUploadResponse reply = FileUploadResponse.newBuilder().setFileId(id).setMessage("Index " + id + " is out of bounds!").setSuccess(false).build();
                    responseObserver.onNext(reply);
                } else if (systemFileNames[id] == null){
                    //Creating a reply and sending it to the client
                    FileUploadResponse reply = FileUploadResponse.newBuilder().setFileId(id).setMessage("No file found at index " + id + "!").setSuccess(false).build();
                    responseObserver.onNext(reply);
                } else {
                    System.out.println("Receiving file upload request for file: " + systemFileNames[id] + " with ID of " + id);

                    // Copying the file to the uploaded arrays
                    uploadedFileNames[id] = systemFileNames[id];
                    uploadedData[id] = systemData[id];

                    //Deleting the files from the system arrays
                    systemFileNames[id] = null;
                    systemData[id] = null;

                    //Creating a reply and sending it to the client
                    FileUploadResponse reply = FileUploadResponse.newBuilder().setFileId(id).setFilename(uploadedFileNames[id]).setMessage("File uploaded Successfully").setSuccess(true).build();
                    responseObserver.onNext(reply);
                }
            }

            @Override
            public void onError(Throwable t) {

                t.printStackTrace();

            }

            // Printing a message upon completion
            @Override
            public void onCompleted() {
                System.out.println("File upload complete!");

                responseObserver.onCompleted();
            }

        };
    }

    // Method 2, which utilizes bidirectional streaming to download files from the cloud storage system
    public StreamObserver<FileDownloadRequest> downloadFiles(StreamObserver<FileDownloadResponse> responseObserver) {

        return new StreamObserver<FileDownloadRequest> () {
            // Error handling to avoid invalid id input
            @Override
            public void onNext(FileDownloadRequest msg) {
                int id = msg.getFileId();
                if (id < 0 || id > 99){
                    //Creating a reply and sending it to the client
                    FileDownloadResponse reply = FileDownloadResponse.newBuilder().setFileId(id).setMessage("Index " + id + " is out of bounds!").setSuccess(false).build();
                    responseObserver.onNext(reply);
                } else if (uploadedFileNames[id] == null){
                    //Creating a reply and sending it to the client
                    FileDownloadResponse reply = FileDownloadResponse.newBuilder().setFileId(id).setMessage("No file found at index " + id + "!").setSuccess(false).build();
                    responseObserver.onNext(reply);
                } else {
                    System.out.println("Receiving file download request for file: " + uploadedFileNames[id]);

                    // Copying the file to the downloaded array
                    systemFileNames[id] = uploadedFileNames[id];
                    systemData[id] = uploadedData[id];

                    // Deleting the files from the uploaded array
                    uploadedFileNames[id] = null;
                    uploadedData[id] = null;

                    //Creating a reply and sending it to the client
                    FileDownloadResponse reply = FileDownloadResponse.newBuilder().setFileId(id).setFilename(systemFileNames[id]).setSuccess(true).setMessage("File successfully downloaded").build();
                    responseObserver.onNext(reply);
                }

            }

            @Override
            public void onError(Throwable t) {

                t.printStackTrace();

            }

            // Printing a message upon completion
            @Override
            public void onCompleted() {
                System.out.println("File download complete!");
                responseObserver.onCompleted();
            }

        };
    }

    // Method 3, which utilizes unary rpc to receive a request from the client to delete a specific file that has been uploaded
    @Override
    public void deleteFile(FileDeleteRequest request, StreamObserver<FileDeleteResponse> responseObserver) {
        // Creating a variable for the file id
        int id = request.getFileId();
        // Creating a string variable to be sent to the client as a message
        String s = "";

        // Error handling to avoid invalid file id input
        if (uploadedFileNames[id] == null){
            s = "Error: No file found at index " + id + ".";
            System.out.println("Error: Index out of bounds!");
        } else if (id < 0 || id > 99) {
            s = "Error: Index out of bounds!";
            System.out.println("Error: Index out of bounds!");
        } else {
            // Deleting file from uploaded file arrays
            uploadedFileNames[id] = null;
            uploadedData[id] = null;

            s = "File ID: " + request.getFileId() + " has been deleted!";
            System.out.println("File deleted successfully");
        }
        // Create and set the response message
        FileDeleteResponse response = FileDeleteResponse.newBuilder()
                .setMessage(s)
                .build();
        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }




    // Method 4, which utilizes server streaming rpc to receive a request from the client and sends back a list of all of the uploaded files
    @Override
    public void requestFileList(Empty request, StreamObserver<FileListResponse> responseObserver) {

        // Looping through the uploaded arrays and data back as a response to the client
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

        // Printing a message upon completion
        responseObserver.onCompleted();
        System.out.println("All uploaded file information sent!");

    }

    // Method used to retrieve properties from .properties file
    private Properties getProperties() {

        Properties prop = null;

        try (InputStream input = new FileInputStream("src/main/resources/Storage.properties")) {

            prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println("Storage Service properties:");
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
