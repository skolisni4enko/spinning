package com.telegabot.spinning.handlers;

public interface Handler<T> {
    void choose(T t);
}
