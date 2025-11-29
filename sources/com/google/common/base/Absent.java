package com.google.common.base;

/* loaded from: classes2.dex */
final class Absent<T> extends Optional<T> {
    static final Absent<Object> INSTANCE = new Absent<>();

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    static <T> Optional<T> withType() {
        return INSTANCE;
    }

    private Absent() {
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public String toString() {
        return "Optional.absent()";
    }
}
