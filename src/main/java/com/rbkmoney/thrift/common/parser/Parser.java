package com.rbkmoney.thrift.common.parser;

public interface Parser<F, T> {

    T parse(F data);
}
