package dev.vality.sink.common.parser.impl;

import dev.vality.machinegun.eventsink.MachineEvent;
import dev.vality.sink.common.exception.ParseException;
import dev.vality.sink.common.parser.Parser;
import dev.vality.sink.common.serialization.BinaryDeserializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MachineEventParser<T> implements Parser<MachineEvent, T> {

    private final BinaryDeserializer<T> deserializer;

    @Override
    public T parse(MachineEvent data) {
        try {
            byte[] bin = data.getData().getBin();
            return deserializer.deserialize(bin);
        } catch (Exception e) {
            log.error("Exception when parse message e: ", e);
            throw new ParseException(e);
        }
    }
}
