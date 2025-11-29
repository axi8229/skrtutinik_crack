package ru.yoomoney.sdk.kassa.payments.metrics;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.metrics.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2310t implements InterfaceC2309s {
    public final Function0 a;
    public final Function0 b;
    public final F c;

    public C2310t(e0 getAuthType, V getTokenizeScheme, F reporter) {
        Intrinsics.checkNotNullParameter(getAuthType, "getAuthType");
        Intrinsics.checkNotNullParameter(getTokenizeScheme, "getTokenizeScheme");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.a = getAuthType;
        this.b = getTokenizeScheme;
        this.c = reporter;
    }
}
