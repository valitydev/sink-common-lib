package dev.vality.sink.common.parser.impl;

import dev.vality.damsel.payout_processing.EventPayload;
import dev.vality.sink.common.serialization.BinaryDeserializer;

public class PayoutEventPayloadMachineEventParser extends MachineEventParser<EventPayload> {

    public PayoutEventPayloadMachineEventParser(BinaryDeserializer<EventPayload> deserializer) {
        super(deserializer);
    }
}
