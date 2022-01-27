package dev.vality.sink.common.handle.machineevent.eventpayload.impl;

import dev.vality.damsel.payment_processing.EventPayload;
import dev.vality.damsel.payment_processing.PartyChange;
import dev.vality.machinegun.eventsink.MachineEvent;
import dev.vality.sink.common.handle.machineevent.eventpayload.PaymentEventHandler;
import dev.vality.sink.common.handle.machineevent.eventpayload.change.PartyChangeEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PartyChangePaymentMachineEventHandler implements PaymentEventHandler {

    private final List<PartyChangeEventHandler> eventHandlers;

    @Override
    public boolean accept(EventPayload payload) {
        return payload.isSetPartyChanges();
    }

    @Override
    public void handle(EventPayload payload, MachineEvent baseEvent) {
        for (int i = 0; i < payload.getPartyChanges().size(); i++) {
            PartyChange change = payload.getPartyChanges().get(i);
            for (PartyChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent, i);
                }
            }
        }
    }
}
