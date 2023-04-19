package ds.Lighting;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Lighting.proto")
public final class LightingServiceGrpc {

  private LightingServiceGrpc() {}

  public static final String SERVICE_NAME = "Lighting.LightingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.Lighting.SetRoomLightingRequest,
      ds.Lighting.SetRoomLightingResponse> getSetRoomLightingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetRoomLighting",
      requestType = ds.Lighting.SetRoomLightingRequest.class,
      responseType = ds.Lighting.SetRoomLightingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.Lighting.SetRoomLightingRequest,
      ds.Lighting.SetRoomLightingResponse> getSetRoomLightingMethod() {
    io.grpc.MethodDescriptor<ds.Lighting.SetRoomLightingRequest, ds.Lighting.SetRoomLightingResponse> getSetRoomLightingMethod;
    if ((getSetRoomLightingMethod = LightingServiceGrpc.getSetRoomLightingMethod) == null) {
      synchronized (LightingServiceGrpc.class) {
        if ((getSetRoomLightingMethod = LightingServiceGrpc.getSetRoomLightingMethod) == null) {
          LightingServiceGrpc.getSetRoomLightingMethod = getSetRoomLightingMethod = 
              io.grpc.MethodDescriptor.<ds.Lighting.SetRoomLightingRequest, ds.Lighting.SetRoomLightingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Lighting.LightingService", "SetRoomLighting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Lighting.SetRoomLightingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Lighting.SetRoomLightingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingServiceMethodDescriptorSupplier("SetRoomLighting"))
                  .build();
          }
        }
     }
     return getSetRoomLightingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.Lighting.LightingAutomationRequest,
      ds.Lighting.LightingAutomationResponse> getLightingAutomationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LightingAutomation",
      requestType = ds.Lighting.LightingAutomationRequest.class,
      responseType = ds.Lighting.LightingAutomationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.Lighting.LightingAutomationRequest,
      ds.Lighting.LightingAutomationResponse> getLightingAutomationMethod() {
    io.grpc.MethodDescriptor<ds.Lighting.LightingAutomationRequest, ds.Lighting.LightingAutomationResponse> getLightingAutomationMethod;
    if ((getLightingAutomationMethod = LightingServiceGrpc.getLightingAutomationMethod) == null) {
      synchronized (LightingServiceGrpc.class) {
        if ((getLightingAutomationMethod = LightingServiceGrpc.getLightingAutomationMethod) == null) {
          LightingServiceGrpc.getLightingAutomationMethod = getLightingAutomationMethod = 
              io.grpc.MethodDescriptor.<ds.Lighting.LightingAutomationRequest, ds.Lighting.LightingAutomationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Lighting.LightingService", "LightingAutomation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Lighting.LightingAutomationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Lighting.LightingAutomationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingServiceMethodDescriptorSupplier("LightingAutomation"))
                  .build();
          }
        }
     }
     return getLightingAutomationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.Lighting.Empty,
      ds.Lighting.LightingStatusResponse> getLightingStatusRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LightingStatusRequest",
      requestType = ds.Lighting.Empty.class,
      responseType = ds.Lighting.LightingStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.Lighting.Empty,
      ds.Lighting.LightingStatusResponse> getLightingStatusRequestMethod() {
    io.grpc.MethodDescriptor<ds.Lighting.Empty, ds.Lighting.LightingStatusResponse> getLightingStatusRequestMethod;
    if ((getLightingStatusRequestMethod = LightingServiceGrpc.getLightingStatusRequestMethod) == null) {
      synchronized (LightingServiceGrpc.class) {
        if ((getLightingStatusRequestMethod = LightingServiceGrpc.getLightingStatusRequestMethod) == null) {
          LightingServiceGrpc.getLightingStatusRequestMethod = getLightingStatusRequestMethod = 
              io.grpc.MethodDescriptor.<ds.Lighting.Empty, ds.Lighting.LightingStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Lighting.LightingService", "LightingStatusRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Lighting.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Lighting.LightingStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LightingServiceMethodDescriptorSupplier("LightingStatusRequest"))
                  .build();
          }
        }
     }
     return getLightingStatusRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LightingServiceStub newStub(io.grpc.Channel channel) {
    return new LightingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LightingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LightingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LightingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LightingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LightingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Method 1
     * Single Room Set Lighting
     * </pre>
     */
    public void setRoomLighting(ds.Lighting.SetRoomLightingRequest request,
        io.grpc.stub.StreamObserver<ds.Lighting.SetRoomLightingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetRoomLightingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Method 2
     * Automate Lighting time based
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.Lighting.LightingAutomationRequest> lightingAutomation(
        io.grpc.stub.StreamObserver<ds.Lighting.LightingAutomationResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getLightingAutomationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Method 3
     * Checks to see if light is on or off
     * </pre>
     */
    public void lightingStatusRequest(ds.Lighting.Empty request,
        io.grpc.stub.StreamObserver<ds.Lighting.LightingStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLightingStatusRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetRoomLightingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.Lighting.SetRoomLightingRequest,
                ds.Lighting.SetRoomLightingResponse>(
                  this, METHODID_SET_ROOM_LIGHTING)))
          .addMethod(
            getLightingAutomationMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.Lighting.LightingAutomationRequest,
                ds.Lighting.LightingAutomationResponse>(
                  this, METHODID_LIGHTING_AUTOMATION)))
          .addMethod(
            getLightingStatusRequestMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.Lighting.Empty,
                ds.Lighting.LightingStatusResponse>(
                  this, METHODID_LIGHTING_STATUS_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class LightingServiceStub extends io.grpc.stub.AbstractStub<LightingServiceStub> {
    private LightingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method 1
     * Single Room Set Lighting
     * </pre>
     */
    public void setRoomLighting(ds.Lighting.SetRoomLightingRequest request,
        io.grpc.stub.StreamObserver<ds.Lighting.SetRoomLightingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetRoomLightingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Method 2
     * Automate Lighting time based
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.Lighting.LightingAutomationRequest> lightingAutomation(
        io.grpc.stub.StreamObserver<ds.Lighting.LightingAutomationResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getLightingAutomationMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Method 3
     * Checks to see if light is on or off
     * </pre>
     */
    public void lightingStatusRequest(ds.Lighting.Empty request,
        io.grpc.stub.StreamObserver<ds.Lighting.LightingStatusResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLightingStatusRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LightingServiceBlockingStub extends io.grpc.stub.AbstractStub<LightingServiceBlockingStub> {
    private LightingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method 1
     * Single Room Set Lighting
     * </pre>
     */
    public ds.Lighting.SetRoomLightingResponse setRoomLighting(ds.Lighting.SetRoomLightingRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetRoomLightingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Method 3
     * Checks to see if light is on or off
     * </pre>
     */
    public java.util.Iterator<ds.Lighting.LightingStatusResponse> lightingStatusRequest(
        ds.Lighting.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getLightingStatusRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LightingServiceFutureStub extends io.grpc.stub.AbstractStub<LightingServiceFutureStub> {
    private LightingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LightingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LightingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LightingServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method 1
     * Single Room Set Lighting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.Lighting.SetRoomLightingResponse> setRoomLighting(
        ds.Lighting.SetRoomLightingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetRoomLightingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_ROOM_LIGHTING = 0;
  private static final int METHODID_LIGHTING_STATUS_REQUEST = 1;
  private static final int METHODID_LIGHTING_AUTOMATION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LightingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LightingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_ROOM_LIGHTING:
          serviceImpl.setRoomLighting((ds.Lighting.SetRoomLightingRequest) request,
              (io.grpc.stub.StreamObserver<ds.Lighting.SetRoomLightingResponse>) responseObserver);
          break;
        case METHODID_LIGHTING_STATUS_REQUEST:
          serviceImpl.lightingStatusRequest((ds.Lighting.Empty) request,
              (io.grpc.stub.StreamObserver<ds.Lighting.LightingStatusResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIGHTING_AUTOMATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.lightingAutomation(
              (io.grpc.stub.StreamObserver<ds.Lighting.LightingAutomationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LightingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LightingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.Lighting.LightingImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LightingService");
    }
  }

  private static final class LightingServiceFileDescriptorSupplier
      extends LightingServiceBaseDescriptorSupplier {
    LightingServiceFileDescriptorSupplier() {}
  }

  private static final class LightingServiceMethodDescriptorSupplier
      extends LightingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LightingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (LightingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LightingServiceFileDescriptorSupplier())
              .addMethod(getSetRoomLightingMethod())
              .addMethod(getLightingAutomationMethod())
              .addMethod(getLightingStatusRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
