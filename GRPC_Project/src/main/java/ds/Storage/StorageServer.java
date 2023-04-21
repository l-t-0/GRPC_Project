package ds.Storage;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import ds.Storage.StorageGrpc.StorageImplBase;
import java.util.ArrayList;
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

        int port = 50051;

        Server server = ServerBuilder.forPort(port)
                .addService(service1)
                .build()
                .start();

        System.out.println("Storage Server started, listening on " + port);

        server.awaitTermination();
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


}
