package com.khesam.inject.hello.writer.interceptor;

public interface Interceptor<I, O> {

    I before(I i);
    O around(I i);
    O after(O o);
}
