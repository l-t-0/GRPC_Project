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
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();

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
                String s = "";
                LightingStatusResponse temp = response.next();
                s += temp.getRoomId() + " lights are ";
                if(temp.getIsOn()) {
                    s += "on.";
                } else {
                    s+= "off.";
                }
                System.out.println(s);
            }

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
        }
    }

}
