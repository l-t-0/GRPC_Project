// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Storage.proto

package ds.Storage;

public interface FileDownloadResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Storage.FileDownloadResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * ID of the downloaded file
   * </pre>
   *
   * <code>int32 file_id = 1;</code>
   */
  int getFileId();

  /**
   * <pre>
   * Name of the downloaded file
   * </pre>
   *
   * <code>string filename = 2;</code>
   */
  java.lang.String getFilename();
  /**
   * <pre>
   * Name of the downloaded file
   * </pre>
   *
   * <code>string filename = 2;</code>
   */
  com.google.protobuf.ByteString
      getFilenameBytes();

  /**
   * <pre>
   * Message indicating if the download was successful
   * </pre>
   *
   * <code>string message = 3;</code>
   */
  java.lang.String getMessage();
  /**
   * <pre>
   * Message indicating if the download was successful
   * </pre>
   *
   * <code>string message = 3;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}
