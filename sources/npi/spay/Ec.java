package npi.spay;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ec implements Qb {
    public final Context a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;

    public Ec(Context context, C1993vg featuresHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        this.a = context;
    }

    public final void a(boolean z) {
        this.a.getSharedPreferences("USER_TOGGLE", 0).edit().putString("UserBiometricToggleKey", String.valueOf(z)).apply();
    }
}
