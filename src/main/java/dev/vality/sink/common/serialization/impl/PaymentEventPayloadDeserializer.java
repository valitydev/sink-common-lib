package dev.vality.sink.common.serialization.impl;

import dev.vality.damsel.payment_processing.EventPayload;

public class PaymentEventPayloadDeserializer extends AbstractThriftBinaryDeserializer<EventPayload> {

    @Override
    public EventPayload deserialize(byte[] bin) {
        return deserialize(bin, new EventPayload());
    }
}
