package com.rbkmoney.sink.common.handle.stockevent.event.change.impl;

import com.rbkmoney.damsel.event_stock.StockEvent;
import com.rbkmoney.damsel.payment_processing.ClaimEffect;
import com.rbkmoney.damsel.payment_processing.PartyChange;
import com.rbkmoney.sink.common.handle.stockevent.event.change.PartyChangeEventHandler;
import com.rbkmoney.sink.common.handle.stockevent.event.change.claimeffect.ClaimEffectEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClaimEffectStatusAcceptedChangeStockEventHandler implements PartyChangeEventHandler {

    private final List<ClaimEffectEventHandler> eventsHandlers;

    @Override
    public boolean accept(PartyChange payload) {
        return payload.isSetClaimStatusChanged()
                && payload.getClaimStatusChanged().getStatus().isSetAccepted()
                && payload.getClaimStatusChanged().getStatus().getAccepted().isSetEffects();
    }

    @Override
    public void handle(PartyChange payload, StockEvent baseEvent) {
        for (int i = 0; i < payload.getClaimStatusChanged().getStatus().getAccepted().getEffects().size(); i++) {
            ClaimEffect effect = payload.getClaimStatusChanged().getStatus().getAccepted().getEffects().get(i);
            for (ClaimEffectEventHandler eventsHandler : eventsHandlers) {
                if (eventsHandler.accept(effect)) {
                    eventsHandler.handle(effect, baseEvent, i);
                }
            }
        }
    }
}
