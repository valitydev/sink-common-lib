package dev.vality.sink.common.parser;

public interface Parser<F, T> {

    T parse(F data);
}
