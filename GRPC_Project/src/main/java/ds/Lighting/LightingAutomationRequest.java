// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Lighting.proto

package ds.Lighting;

/**
 * Protobuf type {@code Lighting.LightingAutomationRequest}
 */
public  final class LightingAutomationRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Lighting.LightingAutomationRequest)
    LightingAutomationRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LightingAutomationRequest.newBuilder() to construct.
  private LightingAutomationRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LightingAutomationRequest() {
    roomId_ = "";
    hour_ = 0;
    minute_ = 0;
    turnOn_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LightingAutomationRequest(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            roomId_ = s;
            break;
          }
          case 16: {

            hour_ = input.readInt32();
            break;
          }
          case 24: {

            minute_ = input.readInt32();
            break;
          }
          case 32: {

            turnOn_ = input.readBool();
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
    return ds.Lighting.LightingImpl.internal_static_Lighting_LightingAutomationRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.Lighting.LightingImpl.internal_static_Lighting_LightingAutomationRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.Lighting.LightingAutomationRequest.class, ds.Lighting.LightingAutomationRequest.Builder.class);
  }

  public static final int ROOM_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object roomId_;
  /**
   * <code>string room_id = 1;</code>
   */
  public java.lang.String getRoomId() {
    java.lang.Object ref = roomId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      roomId_ = s;
      return s;
    }
  }
  /**
   * <code>string room_id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getRoomIdBytes() {
    java.lang.Object ref = roomId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      roomId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HOUR_FIELD_NUMBER = 2;
  private int hour_;
  /**
   * <code>int32 hour = 2;</code>
   */
  public int getHour() {
    return hour_;
  }

  public static final int MINUTE_FIELD_NUMBER = 3;
  private int minute_;
  /**
   * <code>int32 minute = 3;</code>
   */
  public int getMinute() {
    return minute_;
  }

  public static final int TURN_ON_FIELD_NUMBER = 4;
  private boolean turnOn_;
  /**
   * <code>bool turn_on = 4;</code>
   */
  public boolean getTurnOn() {
    return turnOn_;
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
    if (!getRoomIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, roomId_);
    }
    if (hour_ != 0) {
      output.writeInt32(2, hour_);
    }
    if (minute_ != 0) {
      output.writeInt32(3, minute_);
    }
    if (turnOn_ != false) {
      output.writeBool(4, turnOn_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getRoomIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, roomId_);
    }
    if (hour_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, hour_);
    }
    if (minute_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, minute_);
    }
    if (turnOn_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(4, turnOn_);
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
    if (!(obj instanceof ds.Lighting.LightingAutomationRequest)) {
      return super.equals(obj);
    }
    ds.Lighting.LightingAutomationRequest other = (ds.Lighting.LightingAutomationRequest) obj;

    boolean result = true;
    result = result && getRoomId()
        .equals(other.getRoomId());
    result = result && (getHour()
        == other.getHour());
    result = result && (getMinute()
        == other.getMinute());
    result = result && (getTurnOn()
        == other.getTurnOn());
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
    hash = (53 * hash) + getRoomId().hashCode();
    hash = (37 * hash) + HOUR_FIELD_NUMBER;
    hash = (53 * hash) + getHour();
    hash = (37 * hash) + MINUTE_FIELD_NUMBER;
    hash = (53 * hash) + getMinute();
    hash = (37 * hash) + TURN_ON_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getTurnOn());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.Lighting.LightingAutomationRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.Lighting.LightingAutomationRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.Lighting.LightingAutomationRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.Lighting.LightingAutomationRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.Lighting.LightingAutomationRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.Lighting.LightingAutomationRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.Lighting.LightingAutomationRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.Lighting.LightingAutomationRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.Lighting.LightingAutomationRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.Lighting.LightingAutomationRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.Lighting.LightingAutomationRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.Lighting.LightingAutomationRequest parseFrom(
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
  public static Builder newBuilder(ds.Lighting.LightingAutomationRequest prototype) {
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
   * Protobuf type {@code Lighting.LightingAutomationRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Lighting.LightingAutomationRequest)
      ds.Lighting.LightingAutomationRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.Lighting.LightingImpl.internal_static_Lighting_LightingAutomationRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.Lighting.LightingImpl.internal_static_Lighting_LightingAutomationRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.Lighting.LightingAutomationRequest.class, ds.Lighting.LightingAutomationRequest.Builder.class);
    }

    // Construct using ds.Lighting.LightingAutomationRequest.newBuilder()
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
      roomId_ = "";

      hour_ = 0;

      minute_ = 0;

      turnOn_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.Lighting.LightingImpl.internal_static_Lighting_LightingAutomationRequest_descriptor;
    }

    @java.lang.Override
    public ds.Lighting.LightingAutomationRequest getDefaultInstanceForType() {
      return ds.Lighting.LightingAutomationRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.Lighting.LightingAutomationRequest build() {
      ds.Lighting.LightingAutomationRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.Lighting.LightingAutomationRequest buildPartial() {
      ds.Lighting.LightingAutomationRequest result = new ds.Lighting.LightingAutomationRequest(this);
      result.roomId_ = roomId_;
      result.hour_ = hour_;
      result.minute_ = minute_;
      result.turnOn_ = turnOn_;
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
      if (other instanceof ds.Lighting.LightingAutomationRequest) {
        return mergeFrom((ds.Lighting.LightingAutomationRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.Lighting.LightingAutomationRequest other) {
      if (other == ds.Lighting.LightingAutomationRequest.getDefaultInstance()) return this;
      if (!other.getRoomId().isEmpty()) {
        roomId_ = other.roomId_;
        onChanged();
      }
      if (other.getHour() != 0) {
        setHour(other.getHour());
      }
      if (other.getMinute() != 0) {
        setMinute(other.getMinute());
      }
      if (other.getTurnOn() != false) {
        setTurnOn(other.getTurnOn());
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
      ds.Lighting.LightingAutomationRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.Lighting.LightingAutomationRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object roomId_ = "";
    /**
     * <code>string room_id = 1;</code>
     */
    public java.lang.String getRoomId() {
      java.lang.Object ref = roomId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        roomId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string room_id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getRoomIdBytes() {
      java.lang.Object ref = roomId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        roomId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string room_id = 1;</code>
     */
    public Builder setRoomId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      roomId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string room_id = 1;</code>
     */
    public Builder clearRoomId() {
      
      roomId_ = getDefaultInstance().getRoomId();
      onChanged();
      return this;
    }
    /**
     * <code>string room_id = 1;</code>
     */
    public Builder setRoomIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      roomId_ = value;
      onChanged();
      return this;
    }

    private int hour_ ;
    /**
     * <code>int32 hour = 2;</code>
     */
    public int getHour() {
      return hour_;
    }
    /**
     * <code>int32 hour = 2;</code>
     */
    public Builder setHour(int value) {
      
      hour_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 hour = 2;</code>
     */
    public Builder clearHour() {
      
      hour_ = 0;
      onChanged();
      return this;
    }

    private int minute_ ;
    /**
     * <code>int32 minute = 3;</code>
     */
    public int getMinute() {
      return minute_;
    }
    /**
     * <code>int32 minute = 3;</code>
     */
    public Builder setMinute(int value) {
      
      minute_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 minute = 3;</code>
     */
    public Builder clearMinute() {
      
      minute_ = 0;
      onChanged();
      return this;
    }

    private boolean turnOn_ ;
    /**
     * <code>bool turn_on = 4;</code>
     */
    public boolean getTurnOn() {
      return turnOn_;
    }
    /**
     * <code>bool turn_on = 4;</code>
     */
    public Builder setTurnOn(boolean value) {
      
      turnOn_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool turn_on = 4;</code>
     */
    public Builder clearTurnOn() {
      
      turnOn_ = false;
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


    // @@protoc_insertion_point(builder_scope:Lighting.LightingAutomationRequest)
  }

  // @@protoc_insertion_point(class_scope:Lighting.LightingAutomationRequest)
  private static final ds.Lighting.LightingAutomationRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.Lighting.LightingAutomationRequest();
  }

  public static ds.Lighting.LightingAutomationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LightingAutomationRequest>
      PARSER = new com.google.protobuf.AbstractParser<LightingAutomationRequest>() {
    @java.lang.Override
    public LightingAutomationRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LightingAutomationRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LightingAutomationRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LightingAutomationRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.Lighting.LightingAutomationRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
