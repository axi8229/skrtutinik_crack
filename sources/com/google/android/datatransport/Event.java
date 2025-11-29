package com.google.android.datatransport;

/* loaded from: classes2.dex */
public abstract class Event<T> {
    public abstract Integer getCode();

    public abstract EventContext getEventContext();

    public abstract T getPayload();

    public abstract Priority getPriority();

    public abstract ProductData getProductData();

    public static <T> Event<T> ofData(T t, ProductData productData) {
        return new AutoValue_Event(null, t, Priority.DEFAULT, productData, null);
    }

    public static <T> Event<T> ofData(T t) {
        return new AutoValue_Event(null, t, Priority.DEFAULT, null, null);
    }

    public static <T> Event<T> ofUrgent(T t) {
        return new AutoValue_Event(null, t, Priority.HIGHEST, null, null);
    }
}
