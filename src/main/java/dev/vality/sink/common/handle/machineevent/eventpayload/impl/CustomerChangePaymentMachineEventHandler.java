package dev.vality.sink.common.handle.machineevent.eventpayload.impl;

import dev.vality.damsel.payment_processing.CustomerChange;
import dev.vality.damsel.payment_processing.EventPayload;
import dev.vality.machinegun.eventsink.MachineEvent;
import dev.vality.sink.common.handle.machineevent.eventpayload.PaymentEventHandler;
import dev.vality.sink.common.handle.machineevent.eventpayload.change.CustomerChangeEventHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CustomerChangePaymentMachineEventHandler implements PaymentEventHandler {

    private final List<CustomerChangeEventHandler> eventHandlers;

    @Override
    public boolean accept(EventPayload payload) {
        return payload.isSetCustomerChanges();
    }

    @Override
    public void handle(EventPayload payload, MachineEvent baseEvent) {
        for (int i = 0; i < payload.getCustomerChanges().size(); i++) {
            CustomerChange change = payload.getCustomerChanges().get(i);
            for (CustomerChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent, i);
                }
            }
        }
    }
}
