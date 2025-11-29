package ru.yoomoney.sdk.kassa.payments.metrics;

import com.yandex.metrica.IReporter;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2319c;
import ru.yoomoney.sdk.kassa.payments.model.C2320d;
import ru.yoomoney.sdk.kassa.payments.model.o0;
import ru.yoomoney.sdk.kassa.payments.model.p0;

/* loaded from: classes5.dex */
public final class f0 implements r {
    public final IReporter a;

    public f0(IReporter metrica) {
        Intrinsics.checkNotNullParameter(metrica, "metrica");
        this.a = metrica;
    }

    public final void a(o0 e) {
        IReporter iReporter;
        String str;
        Intrinsics.checkNotNullParameter(e, "e");
        if (e instanceof p0) {
            iReporter = this.a;
            str = "Selected option not found error";
        } else if (e instanceof ru.yoomoney.sdk.kassa.payments.model.L) {
            iReporter = this.a;
            str = "No internet error";
        } else if (e instanceof C2319c) {
            iReporter = this.a;
            str = "Api method error";
        } else if (e instanceof C2320d) {
            iReporter = this.a;
            str = "Auth check api method error";
        } else {
            iReporter = this.a;
            str = "Unknown sdk error";
        }
        iReporter.reportError(str, e);
    }
}
