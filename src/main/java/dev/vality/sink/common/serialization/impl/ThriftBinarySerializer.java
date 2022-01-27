package dev.vality.sink.common.serialization.impl;

import dev.vality.sink.common.exception.ThriftBinarySerializationException;
import dev.vality.sink.common.serialization.BinarySerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.transport.TTransportException;

@Slf4j
public class ThriftBinarySerializer<T extends TBase> implements BinarySerializer<T> {

    private final ThreadLocal<TSerializer> thriftSerializer = ThreadLocal.withInitial(() -> {
        try {
            return new TSerializer();
        } catch (TTransportException e) {
            throw new RuntimeException(e);
        }
    });

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
