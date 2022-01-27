package dev.vality.sink.common.serialization;

public interface BinaryDeserializer<T> {

    T deserialize(byte[] bin);

}
