package ds.OfficeLightingControl;

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
    comments = "Source: OfficeLightingControl.proto")
public final class OfficeLightingControlServiceGrpc {

  private OfficeLightingControlServiceGrpc() {}

  public static final String SERVICE_NAME = "OfficeLightingControl.OfficeLightingControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.OfficeLightingControl.RoomLightingRequest,
      ds.OfficeLightingControl.RoomLightingResponse> getSetRoomLightingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetRoomLighting",
      requestType = ds.OfficeLightingControl.RoomLightingRequest.class,
      responseType = ds.OfficeLightingControl.RoomLightingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.OfficeLightingControl.RoomLightingRequest,
      ds.OfficeLightingControl.RoomLightingResponse> getSetRoomLightingMethod() {
    io.grpc.MethodDescriptor<ds.OfficeLightingControl.RoomLightingRequest, ds.OfficeLightingControl.RoomLightingResponse> getSetRoomLightingMethod;
    if ((getSetRoomLightingMethod = OfficeLightingControlServiceGrpc.getSetRoomLightingMethod) == null) {
      synchronized (OfficeLightingControlServiceGrpc.class) {
        if ((getSetRoomLightingMethod = OfficeLightingControlServiceGrpc.getSetRoomLightingMethod) == null) {
          OfficeLightingControlServiceGrpc.getSetRoomLightingMethod = getSetRoomLightingMethod = 
              io.grpc.MethodDescriptor.<ds.OfficeLightingControl.RoomLightingRequest, ds.OfficeLightingControl.RoomLightingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "OfficeLightingControl.OfficeLightingControlService", "SetRoomLighting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.OfficeLightingControl.RoomLightingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.OfficeLightingControl.RoomLightingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OfficeLightingControlServiceMethodDescriptorSupplier("SetRoomLighting"))
                  .build();
          }
        }
     }
     return getSetRoomLightingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.OfficeLightingControl.LightingSettingsRequest,
      ds.OfficeLightingControl.LightingAutomationResponse> getTimeBasedLightingAutomationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TimeBasedLightingAutomation",
      requestType = ds.OfficeLightingControl.LightingSettingsRequest.class,
      responseType = ds.OfficeLightingControl.LightingAutomationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.OfficeLightingControl.LightingSettingsRequest,
      ds.OfficeLightingControl.LightingAutomationResponse> getTimeBasedLightingAutomationMethod() {
    io.grpc.MethodDescriptor<ds.OfficeLightingControl.LightingSettingsRequest, ds.OfficeLightingControl.LightingAutomationResponse> getTimeBasedLightingAutomationMethod;
    if ((getTimeBasedLightingAutomationMethod = OfficeLightingControlServiceGrpc.getTimeBasedLightingAutomationMethod) == null) {
      synchronized (OfficeLightingControlServiceGrpc.class) {
        if ((getTimeBasedLightingAutomationMethod = OfficeLightingControlServiceGrpc.getTimeBasedLightingAutomationMethod) == null) {
          OfficeLightingControlServiceGrpc.getTimeBasedLightingAutomationMethod = getTimeBasedLightingAutomationMethod = 
              io.grpc.MethodDescriptor.<ds.OfficeLightingControl.LightingSettingsRequest, ds.OfficeLightingControl.LightingAutomationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "OfficeLightingControl.OfficeLightingControlService", "TimeBasedLightingAutomation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.OfficeLightingControl.LightingSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.OfficeLightingControl.LightingAutomationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OfficeLightingControlServiceMethodDescriptorSupplier("TimeBasedLightingAutomation"))
                  .build();
          }
        }
     }
     return getTimeBasedLightingAutomationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.OfficeLightingControl.Empty,
      ds.OfficeLightingControl.LightingStatusResponse> getLightingStatusRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LightingStatusRequest",
      requestType = ds.OfficeLightingControl.Empty.class,
      responseType = ds.OfficeLightingControl.LightingStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.OfficeLightingControl.Empty,
      ds.OfficeLightingControl.LightingStatusResponse> getLightingStatusRequestMethod() {
    io.grpc.MethodDescriptor<ds.OfficeLightingControl.Empty, ds.OfficeLightingControl.LightingStatusResponse> getLightingStatusRequestMethod;
    if ((getLightingStatusRequestMethod = OfficeLightingControlServiceGrpc.getLightingStatusRequestMethod) == null) {
      synchronized (OfficeLightingControlServiceGrpc.class) {
        if ((getLightingStatusRequestMethod = OfficeLightingControlServiceGrpc.getLightingStatusRequestMethod) == null) {
          OfficeLightingControlServiceGrpc.getLightingStatusRequestMethod = getLightingStatusRequestMethod = 
              io.grpc.MethodDescriptor.<ds.OfficeLightingControl.Empty, ds.OfficeLightingControl.LightingStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "OfficeLightingControl.OfficeLightingControlService", "LightingStatusRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.OfficeLightingControl.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.OfficeLightingControl.LightingStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OfficeLightingControlServiceMethodDescriptorSupplier("LightingStatusRequest"))
                  .build();
          }
        }
     }
     return getLightingStatusRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OfficeLightingControlServiceStub newStub(io.grpc.Channel channel) {
    return new OfficeLightingControlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OfficeLightingControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OfficeLightingControlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OfficeLightingControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OfficeLightingControlServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class OfficeLightingControlServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void setRoomLighting(ds.OfficeLightingControl.RoomLightingRequest request,
        io.grpc.stub.StreamObserver<ds.OfficeLightingControl.RoomLightingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetRoomLightingMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.OfficeLightingControl.LightingSettingsRequest> timeBasedLightingAutomation(
        io.grpc.stub.StreamObserver<ds.OfficeLightingControl.LightingAutomationResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTimeBasedLightingAutomationMethod(), responseObserver);
    }

    /**
     */
    public void lightingStatusRequest(ds.OfficeLightingControl.Empty request,
        io.grpc.stub.StreamObserver<ds.OfficeLightingControl.LightingStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLightingStatusRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetRoomLightingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.OfficeLightingControl.RoomLightingRequest,
                ds.OfficeLightingControl.RoomLightingResponse>(
                  this, METHODID_SET_ROOM_LIGHTING)))
          .addMethod(
            getTimeBasedLightingAutomationMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.OfficeLightingControl.LightingSettingsRequest,
                ds.OfficeLightingControl.LightingAutomationResponse>(
                  this, METHODID_TIME_BASED_LIGHTING_AUTOMATION)))
          .addMethod(
            getLightingStatusRequestMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.OfficeLightingControl.Empty,
                ds.OfficeLightingControl.LightingStatusResponse>(
                  this, METHODID_LIGHTING_STATUS_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class OfficeLightingControlServiceStub extends io.grpc.stub.AbstractStub<OfficeLightingControlServiceStub> {
    private OfficeLightingControlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OfficeLightingControlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OfficeLightingControlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OfficeLightingControlServiceStub(channel, callOptions);
    }

    /**
     */
    public void setRoomLighting(ds.OfficeLightingControl.RoomLightingRequest request,
        io.grpc.stub.StreamObserver<ds.OfficeLightingControl.RoomLightingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetRoomLightingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.OfficeLightingControl.LightingSettingsRequest> timeBasedLightingAutomation(
        io.grpc.stub.StreamObserver<ds.OfficeLightingControl.LightingAutomationResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getTimeBasedLightingAutomationMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void lightingStatusRequest(ds.OfficeLightingControl.Empty request,
        io.grpc.stub.StreamObserver<ds.OfficeLightingControl.LightingStatusResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLightingStatusRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class OfficeLightingControlServiceBlockingStub extends io.grpc.stub.AbstractStub<OfficeLightingControlServiceBlockingStub> {
    private OfficeLightingControlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OfficeLightingControlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OfficeLightingControlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OfficeLightingControlServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.OfficeLightingControl.RoomLightingResponse setRoomLighting(ds.OfficeLightingControl.RoomLightingRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetRoomLightingMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.OfficeLightingControl.LightingStatusResponse> lightingStatusRequest(
        ds.OfficeLightingControl.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getLightingStatusRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class OfficeLightingControlServiceFutureStub extends io.grpc.stub.AbstractStub<OfficeLightingControlServiceFutureStub> {
    private OfficeLightingControlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OfficeLightingControlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OfficeLightingControlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OfficeLightingControlServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.OfficeLightingControl.RoomLightingResponse> setRoomLighting(
        ds.OfficeLightingControl.RoomLightingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetRoomLightingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_ROOM_LIGHTING = 0;
  private static final int METHODID_LIGHTING_STATUS_REQUEST = 1;
  private static final int METHODID_TIME_BASED_LIGHTING_AUTOMATION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OfficeLightingControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OfficeLightingControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_ROOM_LIGHTING:
          serviceImpl.setRoomLighting((ds.OfficeLightingControl.RoomLightingRequest) request,
              (io.grpc.stub.StreamObserver<ds.OfficeLightingControl.RoomLightingResponse>) responseObserver);
          break;
        case METHODID_LIGHTING_STATUS_REQUEST:
          serviceImpl.lightingStatusRequest((ds.OfficeLightingControl.Empty) request,
              (io.grpc.stub.StreamObserver<ds.OfficeLightingControl.LightingStatusResponse>) responseObserver);
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
        case METHODID_TIME_BASED_LIGHTING_AUTOMATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.timeBasedLightingAutomation(
              (io.grpc.stub.StreamObserver<ds.OfficeLightingControl.LightingAutomationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OfficeLightingControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OfficeLightingControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.OfficeLightingControl.OfficeLightingControlImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OfficeLightingControlService");
    }
  }

  private static final class OfficeLightingControlServiceFileDescriptorSupplier
      extends OfficeLightingControlServiceBaseDescriptorSupplier {
    OfficeLightingControlServiceFileDescriptorSupplier() {}
  }

  private static final class OfficeLightingControlServiceMethodDescriptorSupplier
      extends OfficeLightingControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OfficeLightingControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OfficeLightingControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OfficeLightingControlServiceFileDescriptorSupplier())
              .addMethod(getSetRoomLightingMethod())
              .addMethod(getTimeBasedLightingAutomationMethod())
              .addMethod(getLightingStatusRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
