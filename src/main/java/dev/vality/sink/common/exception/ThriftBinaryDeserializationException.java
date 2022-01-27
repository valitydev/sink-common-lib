package dev.vality.sink.common.exception;

public class ThriftBinaryDeserializationException extends RuntimeException {

    public ThriftBinaryDeserializationException() {
    }

    public ThriftBinaryDeserializationException(String message) {
        super(message);
    }

    public ThriftBinaryDeserializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThriftBinaryDeserializationException(Throwable cause) {
        super(cause);
    }

    public ThriftBinaryDeserializationException(String message, Throwable cause, boolean enableSuppression,
                                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
