// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Lighting.proto

package ds.Lighting;

public interface LightingAutomationRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Lighting.LightingAutomationRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string room_id = 1;</code>
   */
  java.lang.String getRoomId();
  /**
   * <code>string room_id = 1;</code>
   */
  com.google.protobuf.ByteString
      getRoomIdBytes();

  /**
   * <code>int32 hour = 2;</code>
   */
  int getHour();

  /**
   * <code>int32 minute = 3;</code>
   */
  int getMinute();

  /**
   * <code>bool turn_on = 4;</code>
   */
  boolean getTurnOn();
}