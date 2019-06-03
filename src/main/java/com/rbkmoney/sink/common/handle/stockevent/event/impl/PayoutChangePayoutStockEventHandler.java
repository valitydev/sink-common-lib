package com.rbkmoney.sink.common.handle.stockevent.event.impl;

import com.rbkmoney.damsel.event_stock.StockEvent;
import com.rbkmoney.damsel.payout_processing.Event;
import com.rbkmoney.damsel.payout_processing.PayoutChange;
import com.rbkmoney.sink.common.handle.stockevent.event.PayoutEventHandler;
import com.rbkmoney.sink.common.handle.stockevent.event.change.PayoutChangeEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PayoutChangePayoutStockEventHandler implements PayoutEventHandler {

    private final List<PayoutChangeEventHandler> eventHandlers;

    @Override
    public boolean accept(Event payload) {
        return payload.getPayload().isSetPayoutChanges();
    }

    @Override
    public void handle(Event payload, StockEvent baseEvent) {
        for (PayoutChange change : payload.getPayload().getPayoutChanges()) {
            for (PayoutChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent);
                }
            }
        }
    }
}
