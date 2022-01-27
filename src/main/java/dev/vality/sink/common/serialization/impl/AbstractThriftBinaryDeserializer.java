package dev.vality.sink.common.serialization.impl;

import dev.vality.sink.common.exception.ThriftBinaryDeserializationException;
import dev.vality.sink.common.serialization.BinaryDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

@Slf4j
public abstract class AbstractThriftBinaryDeserializer<T extends TBase> implements BinaryDeserializer<T> {

    private final ThreadLocal<TDeserializer> thriftDeserializer = ThreadLocal.withInitial(() -> {
        try {
            return new TDeserializer();
        } catch (TTransportException e) {
            throw new RuntimeException(e);
        }
    });

    protected T deserialize(byte[] bin, T t) {
        log.debug("Deserialize, bin[]: {}", bin.length);
        try {
            thriftDeserializer.get().deserialize(t, bin);
        } catch (TException e) {
            log.error("Error when deserialize data", e);
            throw new ThriftBinaryDeserializationException(e);
        }
        return t;
    }
}
