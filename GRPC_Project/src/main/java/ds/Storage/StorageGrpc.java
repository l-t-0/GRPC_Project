package ds.Storage;

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
    comments = "Source: Storage.proto")
public final class StorageGrpc {

  private StorageGrpc() {}

  public static final String SERVICE_NAME = "Storage.Storage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.Storage.FileUploadRequest,
      ds.Storage.FileUploadResponse> getUploadFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadFiles",
      requestType = ds.Storage.FileUploadRequest.class,
      responseType = ds.Storage.FileUploadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.Storage.FileUploadRequest,
      ds.Storage.FileUploadResponse> getUploadFilesMethod() {
    io.grpc.MethodDescriptor<ds.Storage.FileUploadRequest, ds.Storage.FileUploadResponse> getUploadFilesMethod;
    if ((getUploadFilesMethod = StorageGrpc.getUploadFilesMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getUploadFilesMethod = StorageGrpc.getUploadFilesMethod) == null) {
          StorageGrpc.getUploadFilesMethod = getUploadFilesMethod = 
              io.grpc.MethodDescriptor.<ds.Storage.FileUploadRequest, ds.Storage.FileUploadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Storage.Storage", "UploadFiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Storage.FileUploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Storage.FileUploadResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageMethodDescriptorSupplier("UploadFiles"))
                  .build();
          }
        }
     }
     return getUploadFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.Storage.FileDownloadRequest,
      ds.Storage.FileDownloadResponse> getDownloadFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DownloadFiles",
      requestType = ds.Storage.FileDownloadRequest.class,
      responseType = ds.Storage.FileDownloadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.Storage.FileDownloadRequest,
      ds.Storage.FileDownloadResponse> getDownloadFilesMethod() {
    io.grpc.MethodDescriptor<ds.Storage.FileDownloadRequest, ds.Storage.FileDownloadResponse> getDownloadFilesMethod;
    if ((getDownloadFilesMethod = StorageGrpc.getDownloadFilesMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getDownloadFilesMethod = StorageGrpc.getDownloadFilesMethod) == null) {
          StorageGrpc.getDownloadFilesMethod = getDownloadFilesMethod = 
              io.grpc.MethodDescriptor.<ds.Storage.FileDownloadRequest, ds.Storage.FileDownloadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Storage.Storage", "DownloadFiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Storage.FileDownloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Storage.FileDownloadResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageMethodDescriptorSupplier("DownloadFiles"))
                  .build();
          }
        }
     }
     return getDownloadFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.Storage.FileDeleteRequest,
      ds.Storage.FileDeleteResponse> getDeleteFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFile",
      requestType = ds.Storage.FileDeleteRequest.class,
      responseType = ds.Storage.FileDeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.Storage.FileDeleteRequest,
      ds.Storage.FileDeleteResponse> getDeleteFileMethod() {
    io.grpc.MethodDescriptor<ds.Storage.FileDeleteRequest, ds.Storage.FileDeleteResponse> getDeleteFileMethod;
    if ((getDeleteFileMethod = StorageGrpc.getDeleteFileMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getDeleteFileMethod = StorageGrpc.getDeleteFileMethod) == null) {
          StorageGrpc.getDeleteFileMethod = getDeleteFileMethod = 
              io.grpc.MethodDescriptor.<ds.Storage.FileDeleteRequest, ds.Storage.FileDeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Storage.Storage", "DeleteFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Storage.FileDeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Storage.FileDeleteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageMethodDescriptorSupplier("DeleteFile"))
                  .build();
          }
        }
     }
     return getDeleteFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.Storage.Empty,
      ds.Storage.FileListResponse> getRequestFileListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestFileList",
      requestType = ds.Storage.Empty.class,
      responseType = ds.Storage.FileListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.Storage.Empty,
      ds.Storage.FileListResponse> getRequestFileListMethod() {
    io.grpc.MethodDescriptor<ds.Storage.Empty, ds.Storage.FileListResponse> getRequestFileListMethod;
    if ((getRequestFileListMethod = StorageGrpc.getRequestFileListMethod) == null) {
      synchronized (StorageGrpc.class) {
        if ((getRequestFileListMethod = StorageGrpc.getRequestFileListMethod) == null) {
          StorageGrpc.getRequestFileListMethod = getRequestFileListMethod = 
              io.grpc.MethodDescriptor.<ds.Storage.Empty, ds.Storage.FileListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Storage.Storage", "RequestFileList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Storage.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.Storage.FileListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StorageMethodDescriptorSupplier("RequestFileList"))
                  .build();
          }
        }
     }
     return getRequestFileListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StorageStub newStub(io.grpc.Channel channel) {
    return new StorageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StorageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StorageBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StorageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StorageFutureStub(channel);
  }

  /**
   */
  public static abstract class StorageImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Method for uploading multiple files
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.Storage.FileUploadRequest> uploadFiles(
        io.grpc.stub.StreamObserver<ds.Storage.FileUploadResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUploadFilesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Method for downloading multiple files
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.Storage.FileDownloadRequest> downloadFiles(
        io.grpc.stub.StreamObserver<ds.Storage.FileDownloadResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getDownloadFilesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Method for deleting a single file
     * </pre>
     */
    public void deleteFile(ds.Storage.FileDeleteRequest request,
        io.grpc.stub.StreamObserver<ds.Storage.FileDeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFileMethod(), responseObserver);
    }

    /**
     * <pre>
     * Method for requesting the uploaded file list
     * </pre>
     */
    public void requestFileList(ds.Storage.Empty request,
        io.grpc.stub.StreamObserver<ds.Storage.FileListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRequestFileListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUploadFilesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.Storage.FileUploadRequest,
                ds.Storage.FileUploadResponse>(
                  this, METHODID_UPLOAD_FILES)))
          .addMethod(
            getDownloadFilesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.Storage.FileDownloadRequest,
                ds.Storage.FileDownloadResponse>(
                  this, METHODID_DOWNLOAD_FILES)))
          .addMethod(
            getDeleteFileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.Storage.FileDeleteRequest,
                ds.Storage.FileDeleteResponse>(
                  this, METHODID_DELETE_FILE)))
          .addMethod(
            getRequestFileListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.Storage.Empty,
                ds.Storage.FileListResponse>(
                  this, METHODID_REQUEST_FILE_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class StorageStub extends io.grpc.stub.AbstractStub<StorageStub> {
    private StorageStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method for uploading multiple files
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.Storage.FileUploadRequest> uploadFiles(
        io.grpc.stub.StreamObserver<ds.Storage.FileUploadResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getUploadFilesMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Method for downloading multiple files
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.Storage.FileDownloadRequest> downloadFiles(
        io.grpc.stub.StreamObserver<ds.Storage.FileDownloadResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getDownloadFilesMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Method for deleting a single file
     * </pre>
     */
    public void deleteFile(ds.Storage.FileDeleteRequest request,
        io.grpc.stub.StreamObserver<ds.Storage.FileDeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Method for requesting the uploaded file list
     * </pre>
     */
    public void requestFileList(ds.Storage.Empty request,
        io.grpc.stub.StreamObserver<ds.Storage.FileListResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getRequestFileListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StorageBlockingStub extends io.grpc.stub.AbstractStub<StorageBlockingStub> {
    private StorageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method for deleting a single file
     * </pre>
     */
    public ds.Storage.FileDeleteResponse deleteFile(ds.Storage.FileDeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFileMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Method for requesting the uploaded file list
     * </pre>
     */
    public java.util.Iterator<ds.Storage.FileListResponse> requestFileList(
        ds.Storage.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getRequestFileListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StorageFutureStub extends io.grpc.stub.AbstractStub<StorageFutureStub> {
    private StorageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StorageFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StorageFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Method for deleting a single file
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.Storage.FileDeleteResponse> deleteFile(
        ds.Storage.FileDeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFileMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE_FILE = 0;
  private static final int METHODID_REQUEST_FILE_LIST = 1;
  private static final int METHODID_UPLOAD_FILES = 2;
  private static final int METHODID_DOWNLOAD_FILES = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StorageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StorageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELETE_FILE:
          serviceImpl.deleteFile((ds.Storage.FileDeleteRequest) request,
              (io.grpc.stub.StreamObserver<ds.Storage.FileDeleteResponse>) responseObserver);
          break;
        case METHODID_REQUEST_FILE_LIST:
          serviceImpl.requestFileList((ds.Storage.Empty) request,
              (io.grpc.stub.StreamObserver<ds.Storage.FileListResponse>) responseObserver);
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
        case METHODID_UPLOAD_FILES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadFiles(
              (io.grpc.stub.StreamObserver<ds.Storage.FileUploadResponse>) responseObserver);
        case METHODID_DOWNLOAD_FILES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.downloadFiles(
              (io.grpc.stub.StreamObserver<ds.Storage.FileDownloadResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StorageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.Storage.StorageImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Storage");
    }
  }

  private static final class StorageFileDescriptorSupplier
      extends StorageBaseDescriptorSupplier {
    StorageFileDescriptorSupplier() {}
  }

  private static final class StorageMethodDescriptorSupplier
      extends StorageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StorageMethodDescriptorSupplier(String methodName) {
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
      synchronized (StorageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StorageFileDescriptorSupplier())
              .addMethod(getUploadFilesMethod())
              .addMethod(getDownloadFilesMethod())
              .addMethod(getDeleteFileMethod())
              .addMethod(getRequestFileListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
