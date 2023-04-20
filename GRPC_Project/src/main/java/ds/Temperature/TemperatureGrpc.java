package ds.Temperature;

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
    comments = "Source: Temperature.proto")
public final class TemperatureGrpc {

  private TemperatureGrpc() {}

  public static final String SERVICE_NAME = "Temperature.Temperature";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.Temperature.Empty,
      ds.Temperature.TemperatureReadoutResponse> getTemperatureReadoutRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TemperatureReadoutRequest",
      requestType = ds.Temperature.Empty.class,
      responseType = ds.Temperature.TemperatureReadoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.Temperature.Empty,
      ds.Temperature.TemperatureReadoutResponse> getTemperatureReadoutRequestMethod() {
    io.grpc.MethodDescriptor<ds.Temperature.Empty, ds.Temperature.TemperatureReadoutResponse> getTemperatureReadoutRequestMethod;
    if ((getTemperatureReadoutRequestMethod = TemperatureGrpc.getTemperatureReadoutRequestMethod) == null) {
      synchronized (TemperatureGrpc.class) {
        if ((getTemperatureReadoutRequestMethod = TemperatureGrpc.getTemperatureReadoutRequestMethod) == null) {
          TemperatureGrpc.getTemperatureReadoutRequestMethod = getTemperatureReadoutRequestMethod = 
              io.grpc.MethodDescriptor.<ds.Temperature.Empty, ds.Temperature.TemperatureReadoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Temperature.Temperature", "TemperatureReadoutRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Temperature.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Temperature.TemperatureReadoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TemperatureMethodDescriptorSupplier("TemperatureReadoutRequest"))
                  .build();
          }
        }
     }
     return getTemperatureReadoutRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.Temperature.TemperatureAutomationRequest,
      ds.Temperature.TemperatureAutomationResponse> getTemperatureAutomationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TemperatureAutomation",
      requestType = ds.Temperature.TemperatureAutomationRequest.class,
      responseType = ds.Temperature.TemperatureAutomationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.Temperature.TemperatureAutomationRequest,
      ds.Temperature.TemperatureAutomationResponse> getTemperatureAutomationMethod() {
    io.grpc.MethodDescriptor<ds.Temperature.TemperatureAutomationRequest, ds.Temperature.TemperatureAutomationResponse> getTemperatureAutomationMethod;
    if ((getTemperatureAutomationMethod = TemperatureGrpc.getTemperatureAutomationMethod) == null) {
      synchronized (TemperatureGrpc.class) {
        if ((getTemperatureAutomationMethod = TemperatureGrpc.getTemperatureAutomationMethod) == null) {
          TemperatureGrpc.getTemperatureAutomationMethod = getTemperatureAutomationMethod = 
              io.grpc.MethodDescriptor.<ds.Temperature.TemperatureAutomationRequest, ds.Temperature.TemperatureAutomationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Temperature.Temperature", "TemperatureAutomation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Temperature.TemperatureAutomationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Temperature.TemperatureAutomationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TemperatureMethodDescriptorSupplier("TemperatureAutomation"))
                  .build();
          }
        }
     }
     return getTemperatureAutomationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.Temperature.SetRoomTemperatureRequest,
      ds.Temperature.SetRoomTemperatureResponse> getSetRoomTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetRoomTemperature",
      requestType = ds.Temperature.SetRoomTemperatureRequest.class,
      responseType = ds.Temperature.SetRoomTemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.Temperature.SetRoomTemperatureRequest,
      ds.Temperature.SetRoomTemperatureResponse> getSetRoomTemperatureMethod() {
    io.grpc.MethodDescriptor<ds.Temperature.SetRoomTemperatureRequest, ds.Temperature.SetRoomTemperatureResponse> getSetRoomTemperatureMethod;
    if ((getSetRoomTemperatureMethod = TemperatureGrpc.getSetRoomTemperatureMethod) == null) {
      synchronized (TemperatureGrpc.class) {
        if ((getSetRoomTemperatureMethod = TemperatureGrpc.getSetRoomTemperatureMethod) == null) {
          TemperatureGrpc.getSetRoomTemperatureMethod = getSetRoomTemperatureMethod = 
              io.grpc.MethodDescriptor.<ds.Temperature.SetRoomTemperatureRequest, ds.Temperature.SetRoomTemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Temperature.Temperature", "SetRoomTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Temperature.SetRoomTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Temperature.SetRoomTemperatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TemperatureMethodDescriptorSupplier("SetRoomTemperature"))
                  .build();
          }
        }
     }
     return getSetRoomTemperatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TemperatureStub newStub(io.grpc.Channel channel) {
    return new TemperatureStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TemperatureBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TemperatureBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TemperatureFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TemperatureFutureStub(channel);
  }

  /**
   */
  public static abstract class TemperatureImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Method 1
     * Temperature Readout Request
     * </pre>
     */
    public void temperatureReadoutRequest(ds.Temperature.Empty request,
        io.grpc.stub.StreamObserver<ds.Temperature.TemperatureReadoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTemperatureReadoutRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Method 2
     * Time Based Temperature Automation
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.Temperature.TemperatureAutomationRequest> temperatureAutomation(
        io.grpc.stub.StreamObserver<ds.Temperature.TemperatureAutomationResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTemperatureAutomationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Method 3
     * Set Room Temperature
     * </pre>
     */
    public void setRoomTemperature(ds.Temperature.SetRoomTemperatureRequest request,
        io.grpc.stub.StreamObserver<ds.Temperature.SetRoomTemperatureResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetRoomTemperatureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTemperatureReadoutRequestMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.Temperature.Empty,
                ds.Temperature.TemperatureReadoutResponse>(
                  this, METHODID_TEMPERATURE_READOUT_REQUEST)))
          .addMethod(
            getTemperatureAutomationMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.Temperature.TemperatureAutomationRequest,
                ds.Temperature.TemperatureAutomationResponse>(
                  this, METHODID_TEMPERATURE_AUTOMATION)))
          .addMethod(
            getSetRoomTemperatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.Temperature.SetRoomTemperatureRequest,
                ds.Temperature.SetRoomTemperatureResponse>(
                  this, METHODID_SET_ROOM_TEMPERATURE)))
          .build();
    }
  }

  /**
   */
  public static final class TemperatureStub extends io.grpc.stub.AbstractStub<TemperatureStub> {
    private TemperatureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemperatureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemperatureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method 1
     * Temperature Readout Request
     * </pre>
     */
    public void temperatureReadoutRequest(ds.Temperature.Empty request,
        io.grpc.stub.StreamObserver<ds.Temperature.TemperatureReadoutResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getTemperatureReadoutRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Method 2
     * Time Based Temperature Automation
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.Temperature.TemperatureAutomationRequest> temperatureAutomation(
        io.grpc.stub.StreamObserver<ds.Temperature.TemperatureAutomationResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getTemperatureAutomationMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Method 3
     * Set Room Temperature
     * </pre>
     */
    public void setRoomTemperature(ds.Temperature.SetRoomTemperatureRequest request,
        io.grpc.stub.StreamObserver<ds.Temperature.SetRoomTemperatureResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetRoomTemperatureMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TemperatureBlockingStub extends io.grpc.stub.AbstractStub<TemperatureBlockingStub> {
    private TemperatureBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemperatureBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemperatureBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method 1
     * Temperature Readout Request
     * </pre>
     */
    public java.util.Iterator<ds.Temperature.TemperatureReadoutResponse> temperatureReadoutRequest(
        ds.Temperature.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getTemperatureReadoutRequestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Method 3
     * Set Room Temperature
     * </pre>
     */
    public ds.Temperature.SetRoomTemperatureResponse setRoomTemperature(ds.Temperature.SetRoomTemperatureRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetRoomTemperatureMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TemperatureFutureStub extends io.grpc.stub.AbstractStub<TemperatureFutureStub> {
    private TemperatureFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemperatureFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemperatureFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemperatureFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method 3
     * Set Room Temperature
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.Temperature.SetRoomTemperatureResponse> setRoomTemperature(
        ds.Temperature.SetRoomTemperatureRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetRoomTemperatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TEMPERATURE_READOUT_REQUEST = 0;
  private static final int METHODID_SET_ROOM_TEMPERATURE = 1;
  private static final int METHODID_TEMPERATURE_AUTOMATION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TemperatureImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TemperatureImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEMPERATURE_READOUT_REQUEST:
          serviceImpl.temperatureReadoutRequest((ds.Temperature.Empty) request,
              (io.grpc.stub.StreamObserver<ds.Temperature.TemperatureReadoutResponse>) responseObserver);
          break;
        case METHODID_SET_ROOM_TEMPERATURE:
          serviceImpl.setRoomTemperature((ds.Temperature.SetRoomTemperatureRequest) request,
              (io.grpc.stub.StreamObserver<ds.Temperature.SetRoomTemperatureResponse>) responseObserver);
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
        case METHODID_TEMPERATURE_AUTOMATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.temperatureAutomation(
              (io.grpc.stub.StreamObserver<ds.Temperature.TemperatureAutomationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TemperatureBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TemperatureBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.Temperature.TemperatureImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Temperature");
    }
  }

  private static final class TemperatureFileDescriptorSupplier
      extends TemperatureBaseDescriptorSupplier {
    TemperatureFileDescriptorSupplier() {}
  }

  private static final class TemperatureMethodDescriptorSupplier
      extends TemperatureBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TemperatureMethodDescriptorSupplier(String methodName) {
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
      synchronized (TemperatureGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TemperatureFileDescriptorSupplier())
              .addMethod(getTemperatureReadoutRequestMethod())
              .addMethod(getTemperatureAutomationMethod())
              .addMethod(getSetRoomTemperatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
