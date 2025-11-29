package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class Optional<T> implements Serializable {
    public abstract T get();

    public abstract boolean isPresent();

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> of(T t) {
        return new Present(Preconditions.checkNotNull(t));
    }

    Optional() {
    }
}
