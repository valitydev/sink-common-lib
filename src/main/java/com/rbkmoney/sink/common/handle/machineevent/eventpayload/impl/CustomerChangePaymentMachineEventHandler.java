package com.rbkmoney.sink.common.handle.machineevent.eventpayload.impl;

import com.rbkmoney.damsel.payment_processing.CustomerChange;
import com.rbkmoney.damsel.payment_processing.EventPayload;
import com.rbkmoney.machinegun.eventsink.MachineEvent;
import com.rbkmoney.sink.common.handle.machineevent.eventpayload.PaymentEventHandler;
import com.rbkmoney.sink.common.handle.machineevent.eventpayload.change.CustomerChangeEventHandler;
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
        for (CustomerChange change : payload.getCustomerChanges()) {
            for (CustomerChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent);
                }
            }
        }
    }
}
