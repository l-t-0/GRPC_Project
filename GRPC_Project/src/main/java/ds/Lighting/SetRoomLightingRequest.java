// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Lighting.proto

package ds.Lighting;

/**
 * Protobuf type {@code Lighting.SetRoomLightingRequest}
 */
public  final class SetRoomLightingRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Lighting.SetRoomLightingRequest)
    SetRoomLightingRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SetRoomLightingRequest.newBuilder() to construct.
  private SetRoomLightingRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SetRoomLightingRequest() {
    roomId_ = 0;
    isOn_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SetRoomLightingRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            roomId_ = input.readInt32();
            break;
          }
          case 16: {

            isOn_ = input.readBool();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.Lighting.LightingImpl.internal_static_Lighting_SetRoomLightingRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.Lighting.LightingImpl.internal_static_Lighting_SetRoomLightingRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.Lighting.SetRoomLightingRequest.class, ds.Lighting.SetRoomLightingRequest.Builder.class);
  }

  public static final int ROOM_ID_FIELD_NUMBER = 1;
  private int roomId_;
  /**
   * <code>int32 room_id = 1;</code>
   */
  public int getRoomId() {
    return roomId_;
  }

  public static final int IS_ON_FIELD_NUMBER = 2;
  private boolean isOn_;
  /**
   * <code>bool is_on = 2;</code>
   */
  public boolean getIsOn() {
    return isOn_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (roomId_ != 0) {
      output.writeInt32(1, roomId_);
    }
    if (isOn_ != false) {
      output.writeBool(2, isOn_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (roomId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, roomId_);
    }
    if (isOn_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, isOn_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.Lighting.SetRoomLightingRequest)) {
      return super.equals(obj);
    }
    ds.Lighting.SetRoomLightingRequest other = (ds.Lighting.SetRoomLightingRequest) obj;

    boolean result = true;
    result = result && (getRoomId()
        == other.getRoomId());
    result = result && (getIsOn()
        == other.getIsOn());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ROOM_ID_FIELD_NUMBER;
    hash = (53 * hash) + getRoomId();
    hash = (37 * hash) + IS_ON_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsOn());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.Lighting.SetRoomLightingRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.Lighting.SetRoomLightingRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.Lighting.SetRoomLightingRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.Lighting.SetRoomLightingRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.Lighting.SetRoomLightingRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.Lighting.SetRoomLightingRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.Lighting.SetRoomLightingRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.Lighting.SetRoomLightingRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.Lighting.SetRoomLightingRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.Lighting.SetRoomLightingRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.Lighting.SetRoomLightingRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.Lighting.SetRoomLightingRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.Lighting.SetRoomLightingRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Lighting.SetRoomLightingRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Lighting.SetRoomLightingRequest)
      ds.Lighting.SetRoomLightingRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.Lighting.LightingImpl.internal_static_Lighting_SetRoomLightingRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.Lighting.LightingImpl.internal_static_Lighting_SetRoomLightingRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.Lighting.SetRoomLightingRequest.class, ds.Lighting.SetRoomLightingRequest.Builder.class);
    }

    // Construct using ds.Lighting.SetRoomLightingRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      roomId_ = 0;

      isOn_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.Lighting.LightingImpl.internal_static_Lighting_SetRoomLightingRequest_descriptor;
    }

    @java.lang.Override
    public ds.Lighting.SetRoomLightingRequest getDefaultInstanceForType() {
      return ds.Lighting.SetRoomLightingRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.Lighting.SetRoomLightingRequest build() {
      ds.Lighting.SetRoomLightingRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.Lighting.SetRoomLightingRequest buildPartial() {
      ds.Lighting.SetRoomLightingRequest result = new ds.Lighting.SetRoomLightingRequest(this);
      result.roomId_ = roomId_;
      result.isOn_ = isOn_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.Lighting.SetRoomLightingRequest) {
        return mergeFrom((ds.Lighting.SetRoomLightingRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.Lighting.SetRoomLightingRequest other) {
      if (other == ds.Lighting.SetRoomLightingRequest.getDefaultInstance()) return this;
      if (other.getRoomId() != 0) {
        setRoomId(other.getRoomId());
      }
      if (other.getIsOn() != false) {
        setIsOn(other.getIsOn());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.Lighting.SetRoomLightingRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.Lighting.SetRoomLightingRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int roomId_ ;
    /**
     * <code>int32 room_id = 1;</code>
     */
    public int getRoomId() {
      return roomId_;
    }
    /**
     * <code>int32 room_id = 1;</code>
     */
    public Builder setRoomId(int value) {
      
      roomId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 room_id = 1;</code>
     */
    public Builder clearRoomId() {
      
      roomId_ = 0;
      onChanged();
      return this;
    }

    private boolean isOn_ ;
    /**
     * <code>bool is_on = 2;</code>
     */
    public boolean getIsOn() {
      return isOn_;
    }
    /**
     * <code>bool is_on = 2;</code>
     */
    public Builder setIsOn(boolean value) {
      
      isOn_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool is_on = 2;</code>
     */
    public Builder clearIsOn() {
      
      isOn_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Lighting.SetRoomLightingRequest)
  }

  // @@protoc_insertion_point(class_scope:Lighting.SetRoomLightingRequest)
  private static final ds.Lighting.SetRoomLightingRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.Lighting.SetRoomLightingRequest();
  }

  public static ds.Lighting.SetRoomLightingRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SetRoomLightingRequest>
      PARSER = new com.google.protobuf.AbstractParser<SetRoomLightingRequest>() {
    @java.lang.Override
    public SetRoomLightingRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SetRoomLightingRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SetRoomLightingRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SetRoomLightingRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.Lighting.SetRoomLightingRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

