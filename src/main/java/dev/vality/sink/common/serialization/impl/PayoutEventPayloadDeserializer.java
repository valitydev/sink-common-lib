package dev.vality.sink.common.serialization.impl;

import dev.vality.damsel.payout_processing.EventPayload;

public class PayoutEventPayloadDeserializer extends AbstractThriftBinaryDeserializer<EventPayload> {

    @Override
    public EventPayload deserialize(byte[] bin) {
        return deserialize(bin, new EventPayload());
    }
}
