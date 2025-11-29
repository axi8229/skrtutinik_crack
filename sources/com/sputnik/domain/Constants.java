package com.sputnik.domain;

import kotlin.Metadata;

/* compiled from: Constants.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/sputnik/domain/Constants;", "", "<init>", "()V", "", "isDebug", "", "getYandexApiKey", "(Z)Ljava/lang/String;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Constants {
    public static final Constants INSTANCE = new Constants();

    private Constants() {
    }

    public final String getYandexApiKey(boolean isDebug) {
        return isDebug ? "8fdba6bc-f86a-4e3b-b3a6-e98d367ff8a1" : "6550ad05-89dc-4d1b-9e16-4a640a562ac7";
    }
}
