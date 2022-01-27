package dev.vality.sink.common.parser.impl;

import dev.vality.damsel.payment_processing.PartyEventData;
import dev.vality.sink.common.serialization.BinaryDeserializer;

public class PartyEventDataMachineEventParser extends MachineEventParser<PartyEventData> {

    public PartyEventDataMachineEventParser(BinaryDeserializer<PartyEventData> deserializer) {
        super(deserializer);
    }
}
