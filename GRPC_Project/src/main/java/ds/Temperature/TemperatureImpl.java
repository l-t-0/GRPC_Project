// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Temperature.proto

package ds.Temperature;

public final class TemperatureImpl {
  private TemperatureImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Temperature_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Temperature_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Temperature_TemperatureReadoutResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Temperature_TemperatureReadoutResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Temperature_TemperatureAutomationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Temperature_TemperatureAutomationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Temperature_TemperatureAutomationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Temperature_TemperatureAutomationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Temperature_SetRoomTemperatureRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Temperature_SetRoomTemperatureRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Temperature_SetRoomTemperatureResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Temperature_SetRoomTemperatureResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021Temperature.proto\022\013Temperature\"\007\n\005Empt" +
      "y\"B\n\032TemperatureReadoutResponse\022\017\n\007room_" +
      "id\030\001 \001(\005\022\023\n\013temperature\030\002 \001(\002\"R\n\034Tempera" +
      "tureAutomationRequest\022\017\n\007room_id\030\001 \001(\005\022\014" +
      "\n\004hour\030\002 \001(\005\022\023\n\013temperature\030\003 \001(\002\"A\n\035Tem" +
      "peratureAutomationResponse\022\017\n\007success\030\001 " +
      "\001(\010\022\017\n\007message\030\002 \001(\t\"A\n\031SetRoomTemperatu" +
      "reRequest\022\017\n\007room_id\030\001 \001(\005\022\023\n\013temperatur" +
      "e\030\002 \001(\002\">\n\032SetRoomTemperatureResponse\022\017\n" +
      "\007success\030\001 \001(\010\022\017\n\007message\030\002 \001(\t2\302\002\n\013Temp" +
      "erature\022Z\n\031TemperatureReadoutRequest\022\022.T" +
      "emperature.Empty\032\'.Temperature.Temperatu" +
      "reReadoutResponse0\001\022p\n\025TemperatureAutoma" +
      "tion\022).Temperature.TemperatureAutomation" +
      "Request\032*.Temperature.TemperatureAutomat" +
      "ionResponse(\001\022e\n\022SetRoomTemperature\022&.Te" +
      "mperature.SetRoomTemperatureRequest\032\'.Te" +
      "mperature.SetRoomTemperatureResponseB#\n\016" +
      "ds.TemperatureB\017TemperatureImplP\001b\006proto" +
      "3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Temperature_Empty_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Temperature_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Temperature_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_Temperature_TemperatureReadoutResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Temperature_TemperatureReadoutResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Temperature_TemperatureReadoutResponse_descriptor,
        new java.lang.String[] { "RoomId", "Temperature", });
    internal_static_Temperature_TemperatureAutomationRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Temperature_TemperatureAutomationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Temperature_TemperatureAutomationRequest_descriptor,
        new java.lang.String[] { "RoomId", "Hour", "Temperature", });
    internal_static_Temperature_TemperatureAutomationResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Temperature_TemperatureAutomationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Temperature_TemperatureAutomationResponse_descriptor,
        new java.lang.String[] { "Success", "Message", });
    internal_static_Temperature_SetRoomTemperatureRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Temperature_SetRoomTemperatureRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Temperature_SetRoomTemperatureRequest_descriptor,
        new java.lang.String[] { "RoomId", "Temperature", });
    internal_static_Temperature_SetRoomTemperatureResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Temperature_SetRoomTemperatureResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Temperature_SetRoomTemperatureResponse_descriptor,
        new java.lang.String[] { "Success", "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}