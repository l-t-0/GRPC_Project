package ds.Storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import ds.Storage.Empty;
import io.grpc.stub.StreamObserver;



public class StorageClient {

    private static  Logger logger = Logger.getLogger(StorageClient.class.getName());

    private static StorageGrpc.StorageBlockingStub blockingStub;
    private static StorageGrpc.StorageStub asyncStub;


    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        //stubs -- generate from proto
        blockingStub = StorageGrpc.newBlockingStub(channel);
        asyncStub = StorageGrpc.newStub(channel);

        requestFileList();
        uploadFiles();
        requestFileList();
        deleteFile(5);
        deleteFile(3);
        downloadFiles();
        requestFileList();
        channel.shutdown();

    }

    // Method 1
    public static void uploadFiles() {


        StreamObserver<FileUploadResponse> responseObserver = new StreamObserver<FileUploadResponse>() {

            int count = 0 ;

            @Override
            public void onNext(FileUploadResponse msg) {
                System.out.println("Receiving confirmation of upload of file ID: " + msg.getFileId());
                count++;
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();

            }

            @Override
            public void onCompleted() {
                System.out.println("Upload is completed. " + count + " files successfully uploaded");
            }

        };



        StreamObserver<FileUploadRequest> requestObserver = asyncStub.uploadFiles(responseObserver);

        try {

            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(1).build());
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(2).build());
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(3).build());
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(4).build());
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(5).build());
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(6).build());
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(7).build());
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(8).build());
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(9).build());
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(10).build());



            // Mark the end of requests
            requestObserver.onCompleted();


            // Sleep for a bit before sending the next one.
            Thread.sleep(new Random().nextInt(1000) + 500);


        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // Method 2
    public static void downloadFiles() {


        StreamObserver<FileDownloadResponse> responseObserver = new StreamObserver<FileDownloadResponse>() {

            int count = 0 ;

            @Override
            public void onNext(FileDownloadResponse msg) {
                System.out.println("Receiving confirmation of download of file ID: " + msg.getFileId());
                count++;
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();

            }

            @Override
            public void onCompleted() {
                System.out.println("Download is completed. " + count + " files successfully downloaded");
            }

        };

        StreamObserver<FileDownloadRequest> requestObserver = asyncStub.downloadFiles(responseObserver);

        try {

            requestObserver.onNext(FileDownloadRequest.newBuilder().setFileId(1).build());
            requestObserver.onNext(FileDownloadRequest.newBuilder().setFileId(2).build());
            requestObserver.onNext(FileDownloadRequest.newBuilder().setFileId(9).build());

            // Mark the end of requests
            requestObserver.onCompleted();


            // Sleep for a bit before sending the next one.
            Thread.sleep(new Random().nextInt(1000) + 500);


        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }




    // Method 3
    private static void deleteFile(int id) {

        FileDeleteRequest request = FileDeleteRequest.newBuilder()
                .setFileId(id)
                .build();

        FileDeleteResponse response = blockingStub.deleteFile(request);
        System.out.println(response.getMessage());

    }

    // Method 4
    public static void requestFileList(){
        Empty request = Empty.newBuilder().build();

        try {
            Iterator<FileListResponse> response = blockingStub.requestFileList(request);

            while(response.hasNext()) {
                FileListResponse temporary = response.next();
                System.out.println("The file at index " + temporary.getFileId() + " is named " + temporary.getFilename() + " and contains the data: " + temporary.getContent());
            }

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        }
    }



}
