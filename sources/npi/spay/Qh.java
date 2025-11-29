package npi.spay;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Qh {
    public final Intent a;

    public Qh(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
