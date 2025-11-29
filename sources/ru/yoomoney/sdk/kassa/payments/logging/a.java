package ru.yoomoney.sdk.kassa.payments.logging;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.metrics.i0;
import ru.yoomoney.sdk.kassa.payments.utils.d;

/* loaded from: classes5.dex */
public final class a implements F {
    public final F a;
    public final boolean b;

    public a(i0 reporter, boolean z, Context context) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = reporter;
        this.b = z;
    }

    @Override // ru.yoomoney.sdk.kassa.payments.metrics.F
    public final void a(String name, String arg) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(arg, "arg");
        if (this.b && d.b()) {
            Log.d("ANALYTICS_EVENT", name + " - " + arg);
        }
        this.a.a(name, arg);
    }

    @Override // ru.yoomoney.sdk.kassa.payments.metrics.F
    public final void a(String name, List list) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.b && d.b()) {
            if (list == null) {
                Log.d("ANALYTICS_EVENT", name);
            } else {
                Log.d("ANALYTICS_EVENT", name + " " + CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null));
            }
        }
        this.a.a(name, list);
    }

    @Override // ru.yoomoney.sdk.kassa.payments.metrics.F
    public final void a(boolean z) {
        Intrinsics.checkNotNullParameter("close3dsScreen", AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (this.b && d.b()) {
            Log.d("ANALYTICS_EVENT", "close3dsScreen - " + z);
        }
        this.a.a(z);
    }
}
