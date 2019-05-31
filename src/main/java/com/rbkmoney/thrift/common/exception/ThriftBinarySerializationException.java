package com.rbkmoney.thrift.common.exception;

public class ThriftBinarySerializationException extends RuntimeException {

    public ThriftBinarySerializationException() {
    }

    public ThriftBinarySerializationException(String message) {
        super(message);
    }

    public ThriftBinarySerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThriftBinarySerializationException(Throwable cause) {
        super(cause);
    }

    public ThriftBinarySerializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
