package com.rbkmoney.thrift.common.parser.impl;

import com.rbkmoney.damsel.payment_processing.EventPayload;
import com.rbkmoney.thrift.common.serialization.BinaryDeserializer;

public class PaymentEventPayloadMachineEventParser extends MachineEventParser<EventPayload> {

    public PaymentEventPayloadMachineEventParser(BinaryDeserializer<EventPayload> deserializer) {
        super(deserializer);
    }
}
