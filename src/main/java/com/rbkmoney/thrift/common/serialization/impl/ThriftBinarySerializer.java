package com.rbkmoney.thrift.common.serialization.impl;

import com.rbkmoney.thrift.common.exception.ThriftBinarySerializationException;
import com.rbkmoney.thrift.common.serialization.BinarySerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

@Slf4j
public class ThriftBinarySerializer<T extends TBase> implements BinarySerializer<T> {

    private final ThreadLocal<TSerializer> thriftSerializer = ThreadLocal.withInitial(TSerializer::new);

    @Override
    public byte[] serialize(T data) {
        log.debug("Serialize, data: {}", data);
        try {
            return thriftSerializer.get().serialize(data);
        } catch (TException e) {
            log.error("Error when serialize data: {} ", data, e);
            throw new ThriftBinarySerializationException(e);
        }
    }
}
