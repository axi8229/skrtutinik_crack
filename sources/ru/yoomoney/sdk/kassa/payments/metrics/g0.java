package ru.yoomoney.sdk.kassa.payments.metrics;

import com.yandex.metrica.IReporter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g0 implements InterfaceC2311u {
    public final IReporter a;

    public g0(IReporter metrica) {
        Intrinsics.checkNotNullParameter(metrica, "metrica");
        this.a = metrica;
    }
}
