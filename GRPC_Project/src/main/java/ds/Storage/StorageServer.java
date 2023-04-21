package ds.Storage;

import java.io.IOException;

import ds.Temperature.SetRoomTemperatureRequest;
import ds.Temperature.SetRoomTemperatureResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.Storage.StorageGrpc.StorageImplBase;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.Random;


public class StorageServer extends StorageImplBase{

    ArrayList<String> systemFileNames = createFileNameArrayList();
    ArrayList<Integer> systemData = createSystemData();
    ArrayList<String> uploadedFileNames = new ArrayList<>();
    ArrayList<Integer> uploadedData = new ArrayList<>();


    Random rd = new Random();

    public static ArrayList<String> createFileNameArrayList() {
        ArrayList<String> fileNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            fileNames.add(generateRandomString());
        }
        return fileNames;
    }

    public static ArrayList<Integer> createSystemData() {
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(randomInt());
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

        int port = 50053;

        Server server = ServerBuilder.forPort(port)
                .addService(service1)
                .build()
                .start();

        System.out.println("Storage Server started, listening on " + port);

        server.awaitTermination();
    }

    public static float rTemp() {
        return (new Random().nextFloat() * (32 - 5)) + 5;
    }

    

    // Method 3
    @Override
    public void deleteFile(FileDeleteRequest request, StreamObserver<FileDeleteResponse> responseObserver) {

        uploadedFileNames.remove(request.getFileId());
        uploadedData.remove(request.getFileId());


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

        for (int i = 0; i < uploadedFileNames.size(); i++) {
            FileListResponse response = FileListResponse.newBuilder()
                    .setFileId(i)
                    .setFilename(uploadedFileNames.get(i))
                    .setContent(uploadedData.get(i))
                    .build();
            responseObserver.onNext(response);
            System.out.println("Result " + i + " sent!");
        }

        responseObserver.onCompleted();
        System.out.println("All uploaded file information sent!");

    }


}
