package dev.vality.sink.common.handle.machineevent.eventpayload.change.impl;

import dev.vality.damsel.payment_processing.ClaimEffect;
import dev.vality.damsel.payment_processing.PartyChange;
import dev.vality.machinegun.eventsink.MachineEvent;
import dev.vality.sink.common.handle.machineevent.eventpayload.change.PartyChangeEventHandler;
import dev.vality.sink.common.handle.machineevent.eventpayload.change.claimeffect.ClaimEffectEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClaimEffectStatusAcceptedChangeMachineEventHandler implements PartyChangeEventHandler {

    private final List<ClaimEffectEventHandler> eventsHandlers;

    @Override
    public boolean accept(PartyChange payload) {
        return payload.isSetClaimStatusChanged()
                && payload.getClaimStatusChanged().getStatus().isSetAccepted()
                && payload.getClaimStatusChanged().getStatus().getAccepted().isSetEffects();
    }

    @Override
    public void handle(PartyChange payload, MachineEvent baseEvent) {
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
