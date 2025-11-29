package ru.yoomoney.sdk.kassa.payments.metrics;

import com.yandex.metrica.IReporter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j0 implements N {
    public final IReporter a;

    public j0(IReporter metrica) {
        Intrinsics.checkNotNullParameter(metrica, "metrica");
        this.a = metrica;
    }
}
