package dev.vality.sink.common.parser;

import dev.vality.damsel.payment_processing.EventPayload;
import dev.vality.machinegun.eventsink.MachineEvent;
import dev.vality.machinegun.msgpack.Value;
import dev.vality.sink.common.parser.impl.PaymentEventPayloadMachineEventParser;
import dev.vality.sink.common.serialization.impl.PaymentEventPayloadDeserializer;
import dev.vality.sink.common.serialization.impl.PaymentEventPayloadSerializer;
import org.junit.Test;

import java.util.Collections;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void parserTest() {
        EventPayload expectedEventPayload = EventPayload.invoice_changes(Collections.emptyList());

        PaymentEventPayloadSerializer serializer = new PaymentEventPayloadSerializer();
        byte[] serializeEventPayload = serializer.serialize(expectedEventPayload);

        MachineEvent machineEvent = random(MachineEvent.class, "data");
        machineEvent.setData(Value.bin(serializeEventPayload));

        PaymentEventPayloadMachineEventParser parser =
                new PaymentEventPayloadMachineEventParser(new PaymentEventPayloadDeserializer());
        EventPayload actualEventPayload = parser.parse(machineEvent);

        assertEquals(expectedEventPayload, actualEventPayload);
    }
}
