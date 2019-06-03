package com.rbkmoney.sink.common.handle.machineevent.eventpayload.impl;

import com.rbkmoney.damsel.payment_processing.EventPayload;
import com.rbkmoney.damsel.payment_processing.InvoiceChange;
import com.rbkmoney.machinegun.eventsink.MachineEvent;
import com.rbkmoney.sink.common.handle.machineevent.eventpayload.PaymentEventHandler;
import com.rbkmoney.sink.common.handle.machineevent.eventpayload.change.InvoiceChangeEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class InvoiceChangePaymentMachineEventHandler implements PaymentEventHandler {

    private final List<InvoiceChangeEventHandler> eventHandlers;

    @Override
    public boolean accept(EventPayload payload) {
        return payload.isSetInvoiceChanges();
    }

    @Override
    public void handle(EventPayload payload, MachineEvent baseEvent) {
        for (InvoiceChange change : payload.getInvoiceChanges()) {
            for (InvoiceChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent);
                }
            }
        }
    }
}
