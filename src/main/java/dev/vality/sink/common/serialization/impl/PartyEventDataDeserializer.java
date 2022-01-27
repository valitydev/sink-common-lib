package dev.vality.sink.common.serialization.impl;

import dev.vality.damsel.payment_processing.PartyEventData;

public class PartyEventDataDeserializer extends AbstractThriftBinaryDeserializer<PartyEventData> {

    @Override
    public PartyEventData deserialize(byte[] bin) {
        return deserialize(bin, new PartyEventData());
    }
}
