package com.rbkmoney.sink.common.serialization.impl;

import com.rbkmoney.damsel.payment_processing.PartyEventData;

public class PartyEventDataDeserializer extends AbstractThriftBinaryDeserializer<PartyEventData> {

    @Override
    public PartyEventData deserialize(byte[] bin) {
        return deserialize(bin, new PartyEventData());
    }
}
