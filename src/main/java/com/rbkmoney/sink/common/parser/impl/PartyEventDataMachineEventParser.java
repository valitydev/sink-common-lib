package com.rbkmoney.sink.common.parser.impl;

import com.rbkmoney.damsel.payment_processing.PartyEventData;
import com.rbkmoney.sink.common.serialization.BinaryDeserializer;

public class PartyEventDataMachineEventParser extends MachineEventParser<PartyEventData> {

    public PartyEventDataMachineEventParser(BinaryDeserializer<PartyEventData> deserializer) {
        super(deserializer);
    }
}
