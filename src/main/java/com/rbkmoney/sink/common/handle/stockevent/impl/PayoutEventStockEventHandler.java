package com.rbkmoney.sink.common.handle.stockevent.impl;

import com.rbkmoney.damsel.event_stock.StockEvent;
import com.rbkmoney.damsel.payout_processing.Event;
import com.rbkmoney.sink.common.handle.stockevent.StockEventHandler;
import com.rbkmoney.sink.common.handle.stockevent.event.PayoutEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PayoutEventStockEventHandler implements StockEventHandler<StockEvent> {

    private final List<PayoutEventHandler> eventHandlers;

    @Override
    public boolean accept(StockEvent payload) {
        return payload.getSourceEvent().isSetPayoutEvent();
    }

    @Override
    public void handle(StockEvent payload, StockEvent baseEvent) {
        Event event = payload.getSourceEvent().getPayoutEvent();
        for (PayoutEventHandler eventHandler : eventHandlers) {
            if (eventHandler.accept(event)) {
                eventHandler.handle(event, baseEvent);
            }
        }
    }
}
