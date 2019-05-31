package com.rbkmoney.thrift.common.serialization.impl;

import com.rbkmoney.damsel.payment_processing.EventPayload;

public class PaymentEventPayloadDeserializer extends AbstractThriftBinaryDeserializer<EventPayload> {

    @Override
    public EventPayload deserialize(byte[] bin) {
        return deserialize(bin, new EventPayload());
    }
}
