package dev.vality.sink.common.parser.impl;

import dev.vality.damsel.payment_processing.EventPayload;
import dev.vality.sink.common.serialization.BinaryDeserializer;

public class PaymentEventPayloadMachineEventParser extends MachineEventParser<EventPayload> {

    public PaymentEventPayloadMachineEventParser(BinaryDeserializer<EventPayload> deserializer) {
        super(deserializer);
    }
}
