package dev.vality.sink.common.serialization;

public interface BinarySerializer<T> {

    byte[] serialize(T data);

}
