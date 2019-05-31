package com.rbkmoney.thrift.common.serialization.impl;

import com.rbkmoney.damsel.payout_processing.EventPayload;

public class PayoutEventPayloadDeserializer extends AbstractThriftBinaryDeserializer<EventPayload> {

    @Override
    public EventPayload deserialize(byte[] bin) {
        return deserialize(bin, new EventPayload());
    }
}
