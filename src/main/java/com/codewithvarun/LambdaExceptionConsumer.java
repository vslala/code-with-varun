package com.codewithvarun;

import java.util.function.Consumer;

@FunctionalInterface
public interface LambdaExceptionConsumer<T, E extends Exception> {
    void accept(T t) throws E;

    static <T> Consumer<T> wrapEx(
            LambdaExceptionConsumer<T, Exception> throwingConsumer) {

        return input -> {
            try {
                throwingConsumer.accept(input);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
