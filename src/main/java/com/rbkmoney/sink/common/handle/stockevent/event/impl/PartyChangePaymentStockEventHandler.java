package com.rbkmoney.sink.common.handle.stockevent.event.impl;

import com.rbkmoney.damsel.event_stock.StockEvent;
import com.rbkmoney.damsel.payment_processing.Event;
import com.rbkmoney.damsel.payment_processing.PartyChange;
import com.rbkmoney.sink.common.handle.stockevent.event.PaymentEventHandler;
import com.rbkmoney.sink.common.handle.stockevent.event.change.PartyChangeEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PartyChangePaymentStockEventHandler implements PaymentEventHandler {

    private final List<PartyChangeEventHandler> eventHandlers;

    @Override
    public boolean accept(Event payload) {
        return payload.getPayload().isSetPartyChanges();
    }

    @Override
    public void handle(Event payload, StockEvent baseEvent) {
        for (int i = 0; i < payload.getPayload().getPartyChanges().size(); i++) {
            PartyChange change = payload.getPayload().getPartyChanges().get(i);
            for (PartyChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent);
                }
            }
        }
    }
}
