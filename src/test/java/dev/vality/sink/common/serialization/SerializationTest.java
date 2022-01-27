package dev.vality.sink.common.serialization;

import dev.vality.damsel.payment_processing.EventPayload;
import dev.vality.sink.common.serialization.impl.PaymentEventPayloadDeserializer;
import dev.vality.sink.common.serialization.impl.PaymentEventPayloadSerializer;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SerializationTest {

    @Test
    public void serializationTest() {
        EventPayload expectedEventPayload = EventPayload.invoice_changes(Collections.emptyList());

        PaymentEventPayloadSerializer serializer = new PaymentEventPayloadSerializer();
        byte[] serializeEventPayload = serializer.serialize(expectedEventPayload);

        PaymentEventPayloadDeserializer deserializer = new PaymentEventPayloadDeserializer();
        EventPayload actualEventPayload = deserializer.deserialize(serializeEventPayload);

        assertEquals(expectedEventPayload, actualEventPayload);
    }
}
