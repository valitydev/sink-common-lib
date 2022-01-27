package dev.vality.sink.common.handle.machineevent.impl;

import dev.vality.damsel.payment_processing.EventPayload;
import dev.vality.machinegun.eventsink.MachineEvent;
import dev.vality.sink.common.handle.machineevent.MachineEventHandler;
import dev.vality.sink.common.handle.machineevent.eventpayload.PaymentEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PaymentEventMachineEventHandler implements MachineEventHandler<EventPayload> {

    private final List<PaymentEventHandler> eventHandlers;

    @Override
    public void handle(EventPayload payload, MachineEvent baseEvent) {
        for (PaymentEventHandler eventHandler : eventHandlers) {
            if (eventHandler.accept(payload)) {
                eventHandler.handle(payload, baseEvent);
            }
        }
    }
}
