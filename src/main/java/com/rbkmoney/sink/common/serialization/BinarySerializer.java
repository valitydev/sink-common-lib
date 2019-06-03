package com.rbkmoney.sink.common.serialization;

public interface BinarySerializer<T> {

    byte[] serialize(T data);

}
