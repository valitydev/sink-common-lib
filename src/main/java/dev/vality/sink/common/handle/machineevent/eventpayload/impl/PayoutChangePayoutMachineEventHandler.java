package dev.vality.sink.common.handle.machineevent.eventpayload.impl;

import dev.vality.damsel.payout_processing.EventPayload;
import dev.vality.damsel.payout_processing.PayoutChange;
import dev.vality.machinegun.eventsink.MachineEvent;
import dev.vality.sink.common.handle.machineevent.eventpayload.PayoutEventHandler;
import dev.vality.sink.common.handle.machineevent.eventpayload.change.PayoutChangeEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PayoutChangePayoutMachineEventHandler implements PayoutEventHandler {

    private final List<PayoutChangeEventHandler> eventHandlers;

    @Override
    public boolean accept(EventPayload payload) {
        return payload.isSetPayoutChanges();
    }

    @Override
    public void handle(EventPayload payload, MachineEvent baseEvent) {
        for (int i = 0; i < payload.getPayoutChanges().size(); i++) {
            PayoutChange change = payload.getPayoutChanges().get(i);
            for (PayoutChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent, i);
                }
            }
        }
    }
}
