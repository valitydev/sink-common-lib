package com.rbkmoney.sink.common.handle.stockevent;

import com.rbkmoney.damsel.event_stock.StockEvent;
import com.rbkmoney.sink.common.handle.EventHandler;

public interface StockEventHandler<T> extends EventHandler<T, StockEvent> {

}
