package com.rbkmoney.sink.common.handle.stockevent.event.impl;

import com.rbkmoney.damsel.event_stock.StockEvent;
import com.rbkmoney.damsel.payment_processing.Event;
import com.rbkmoney.damsel.payment_processing.InvoiceChange;
import com.rbkmoney.sink.common.handle.stockevent.event.PaymentEventHandler;
import com.rbkmoney.sink.common.handle.stockevent.event.change.InvoiceChangeEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class InvoiceChangePaymentStockEventHandler implements PaymentEventHandler {

    private final List<InvoiceChangeEventHandler> eventHandlers;

    @Override
    public boolean accept(Event payload) {
        return payload.getPayload().isSetInvoiceChanges();
    }

    @Override
    public void handle(Event payload, StockEvent baseEvent) {
        for (InvoiceChange change : payload.getPayload().getInvoiceChanges()) {
            for (InvoiceChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent);
                }
            }
        }
    }
}
