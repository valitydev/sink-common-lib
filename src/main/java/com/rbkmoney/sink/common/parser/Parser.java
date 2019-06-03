package com.rbkmoney.sink.common.parser;

public interface Parser<F, T> {

    T parse(F data);
}
