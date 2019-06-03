package com.rbkmoney.sink.common.handle.machineevent;

import com.rbkmoney.machinegun.eventsink.MachineEvent;
import com.rbkmoney.sink.common.handle.EventHandler;

public interface MachineEventHandler<T> extends EventHandler<T, MachineEvent> {

}
