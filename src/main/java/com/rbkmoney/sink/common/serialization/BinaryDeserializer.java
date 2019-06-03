package com.rbkmoney.sink.common.serialization;

public interface BinaryDeserializer<T> {

    T deserialize(byte[] bin);

}
