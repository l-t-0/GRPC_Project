package ds.OfficeLightingControl;

import java.io.IOException;

import ds.service2.Service2Grpc.Service2ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class OfficeLightingControl extends OfficeLightingControlImpl{



    public static void main(String[] args) throws InterruptedException, IOException {
        OfficeLightingControl service1 = new OfficeLightingControl();

        int port = 50052;

        Server server = ServerBuilder.forPort(port)
                .addService(service1)
                .build()
                .start();

        System.out.println("Service-2 started, listening on " + port);

        server.awaitTermination();
    }


    @Override
    public void service2Do(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {

        //prepare the value to be set back
        int length = request.getText().length();

        //preparing the response message
        ResponseMessage reply = ResponseMessage.newBuilder().setLength(length).build();

        responseObserver.onNext( reply );

        responseObserver.onCompleted();

    }
}