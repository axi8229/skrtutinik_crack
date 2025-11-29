package npi.spay;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.dh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1546dh {
    public final Context a;
    public final Qh b;
    public final C1736l8 c;
    public final C1725km d;

    public C1546dh(Context appContext, Qh batteryLevelProvider, C1736l8 locationProvider, C1725km networkProvider) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(batteryLevelProvider, "batteryLevelProvider");
        Intrinsics.checkNotNullParameter(locationProvider, "locationProvider");
        Intrinsics.checkNotNullParameter(networkProvider, "networkProvider");
        this.a = appContext;
        this.b = batteryLevelProvider;
        this.c = locationProvider;
        this.d = networkProvider;
    }
}
