package com.codesolt.springbootreactive.exception;

import org.springframework.lang.Nullable;

public class BookNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BookNotFoundException(@Nullable String s) {
        super(s);
    }

    public BookNotFoundException(@Nullable String s, @Nullable Throwable throwable) {
        super(s, throwable);
    }
}
