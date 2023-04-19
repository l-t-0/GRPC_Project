package ds.Lighting;

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
import ds.Lighting.Empty;
import io.grpc.stub.StreamObserver;



public class LightingClient {

    private static  Logger logger = Logger.getLogger(LightingClient.class.getName());

    private static LightingServiceGrpc.LightingServiceBlockingStub blockingStub;
    private static LightingServiceGrpc.LightingServiceStub asyncStub;


    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        //stubs -- generate from proto
        blockingStub = LightingServiceGrpc.newBlockingStub(channel);
        asyncStub = LightingServiceGrpc.newStub(channel);

        lightingStatusRequest();



    }

    public static void lightingStatusRequest(){
        Empty request = Empty.newBuilder().build();

        try {
            Iterator<LightingStatusResponse> response = blockingStub.lightingStatusRequest(request);

            while(response.hasNext()) {
                LightingStatusResponse temp = response.next();
                System.out.println("Room no. :");
                System.out.println(temp.getRoomId());
                System.out.println("Is it on? :");
                System.out.println(temp.getIsOn());

            }

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        }
    }

}
