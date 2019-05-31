package com.rbkmoney.thrift.common.serialization;

public interface BinarySerializer<T> {

    byte[] serialize(T data);

}
