package com.rbkmoney.sink.common.handle.stockevent.impl;

import com.rbkmoney.damsel.event_stock.StockEvent;
import com.rbkmoney.damsel.payment_processing.Event;
import com.rbkmoney.sink.common.handle.stockevent.StockEventHandler;
import com.rbkmoney.sink.common.handle.stockevent.event.PaymentEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PaymentEventStockEventHandler implements StockEventHandler<StockEvent> {

    private final List<PaymentEventHandler> eventHandlers;

    @Override
    public boolean accept(StockEvent payload) {
        return payload.getSourceEvent().isSetProcessingEvent();
    }

    @Override
    public void handle(StockEvent payload, StockEvent baseEvent) {
        Event event = payload.getSourceEvent().getProcessingEvent();
        for (PaymentEventHandler eventHandler : eventHandlers) {
            if (eventHandler.accept(event)) {
                eventHandler.handle(event, baseEvent);
            }
        }
    }
}
