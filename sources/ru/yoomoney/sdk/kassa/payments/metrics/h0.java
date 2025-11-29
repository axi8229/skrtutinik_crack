package ru.yoomoney.sdk.kassa.payments.metrics;

import android.content.Context;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.o0;

/* loaded from: classes5.dex */
public final class h0 implements InterfaceC2308q {
    public final boolean a;
    public final r b;

    public h0(boolean z, Context context, f0 errorReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        this.a = z;
        this.b = errorReporter;
    }

    public final void a(o0 e) {
        Intrinsics.checkNotNullParameter(e, "e");
        ((f0) this.b).a(e);
        if (this.a && ru.yoomoney.sdk.kassa.payments.utils.d.b()) {
            Log.d("ERROR", e.toString());
        }
    }
}
