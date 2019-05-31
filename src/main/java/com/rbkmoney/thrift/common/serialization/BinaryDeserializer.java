package com.rbkmoney.thrift.common.serialization;

public interface BinaryDeserializer<T> {

    T deserialize(byte[] bin);

}
