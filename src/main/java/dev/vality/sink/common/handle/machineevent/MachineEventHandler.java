package dev.vality.sink.common.handle.machineevent;

import dev.vality.machinegun.eventsink.MachineEvent;
import dev.vality.sink.common.handle.EventHandler;

public interface MachineEventHandler<T> extends EventHandler<T, MachineEvent> {

}
