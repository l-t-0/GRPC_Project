package ds.Storage;

import java.util.Iterator;
import java.util.Random;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;



public class StorageClient {

    private static StorageGrpc.StorageBlockingStub blockingStub;
    private static StorageGrpc.StorageStub asyncStub;


    public static void main(String[] args) throws Exception {
        // Building a managed channel with the correct hostname and port number
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        //stubs -- generate from proto
        blockingStub = StorageGrpc.newBlockingStub(channel);
        asyncStub = StorageGrpc.newStub(channel);

        //Demonstrating methods by calling them
        uploadFiles();
        requestFileList();
        deleteFile(5);
        deleteFile(3);
        deleteFile(95);
        downloadFiles();
        requestFileList();

        // Shutting down channel
        channel.shutdown();

    }

    // Method 1, which utilizes bidirectional rpc to upload multiple files to the cloud storage system
    public static void uploadFiles() {


        StreamObserver<FileUploadResponse> responseObserver = new StreamObserver<FileUploadResponse>() {
            // An int is used to count how many files are uploaded
            int count = 0 ;

            // If the response reports that it is unsuccessful, an error message will be printed
            @Override
            public void onNext(FileUploadResponse msg) {
                if (msg.getSuccess() == false){
                    System.out.println("Error: " + msg.getMessage());
                } else {
                    System.out.println("Receiving confirmation of upload of file ID: " + msg.getFileId());
                    count++;
                }
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();

            }

            // Printing a message upon completion
            @Override
            public void onCompleted() {
                System.out.println("Upload is completed. " + count + " files successfully uploaded.");
            }

        };


        // Creating a StreamObserver object for the request in order to feed the requests to the server
        StreamObserver<FileUploadRequest> requestObserver = asyncStub.uploadFiles(responseObserver);

        try {

            // Passing in upload requests
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
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(105).build());
            requestObserver.onNext(FileUploadRequest.newBuilder().setFileId(1).build());

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

    // Method 2, which utilizes bidirectional rpc to download multiple files from the cloud storage system
    public static void downloadFiles() {


        StreamObserver<FileDownloadResponse> responseObserver = new StreamObserver<FileDownloadResponse>() {
            // An int is used to count how many files are downloaded
            int count = 0 ;

            // If the response reports that it is unsuccessful, an error message will be printed
            public void onNext(FileDownloadResponse msg) {
                if (msg.getSuccess() == false){
                    System.out.println("Error: " + msg.getMessage());
                } else {
                    System.out.println("Receiving confirmation of download of file ID: " + msg.getFileId());
                    count++;
                }
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();

            }

            // Printing a message upon completion
            @Override
            public void onCompleted() {
                System.out.println("Download is completed. " + count + " files successfully downloaded.");
            }

        };

        // Creating a StreamObserver object for the request in order to feed the requests to the server
        StreamObserver<FileDownloadRequest> requestObserver = asyncStub.downloadFiles(responseObserver);

        try {
            // Passing in download requests
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




    // Method 3, which utilizes unary rpc to delete a file from the cloud storage system
    private static void deleteFile(int id) {

        // Creating a new request to pass to the server, containing the id of the file to be deleted
        FileDeleteRequest request = FileDeleteRequest.newBuilder()
                .setFileId(id)
                .build();

        // Receiving the response
        FileDeleteResponse response = blockingStub.deleteFile(request);

        // If an error occurs, it will be printed and the deletion won't be carried out
        System.out.println(response.getMessage());

    }

    // Method 4, which utilizes server streaming rpc to request a list of all of the uploaded files
    public static void requestFileList(){
        // Creating a new empty request
        Empty request = Empty.newBuilder().build();

        try {
            Iterator<FileListResponse> response = blockingStub.requestFileList(request);

            // Iterating through all the responses and printing the results
            while(response.hasNext()) {
                FileListResponse temporary = response.next();
                System.out.println("The file at index " + temporary.getFileId() + " is named " + temporary.getFilename() + " and contains the data: " + temporary.getContent());
            }

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        }
    }

}
