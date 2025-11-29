package ru.yoomoney.sdk.kassa.payments.api;

import com.fasterxml.jackson.databind.ObjectMapper;

/* loaded from: classes5.dex */
public final class l {
    public static YooKassaJacksonConverterFactory a(ObjectMapper objectMapper) {
        if (objectMapper != null) {
            return new YooKassaJacksonConverterFactory(objectMapper, null);
        }
        throw new NullPointerException("mapper == null");
    }
}
