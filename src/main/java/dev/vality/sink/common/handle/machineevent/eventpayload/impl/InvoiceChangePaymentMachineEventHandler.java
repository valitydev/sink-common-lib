package dev.vality.sink.common.handle.machineevent.eventpayload.impl;

import dev.vality.damsel.payment_processing.EventPayload;
import dev.vality.damsel.payment_processing.InvoiceChange;
import dev.vality.machinegun.eventsink.MachineEvent;
import dev.vality.sink.common.handle.machineevent.eventpayload.PaymentEventHandler;
import dev.vality.sink.common.handle.machineevent.eventpayload.change.InvoiceChangeEventHandler;
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
        for (int i = 0; i < payload.getInvoiceChanges().size(); i++) {
            InvoiceChange change = payload.getInvoiceChanges().get(i);
            for (InvoiceChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent, i);
                }
            }
        }
    }
}
