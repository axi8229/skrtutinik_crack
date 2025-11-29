package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class S8 {
    public final T3 a;
    public final C1675im b;

    public S8(T3 settings, C1675im networkClient) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(networkClient, "networkClient");
        this.a = settings;
        this.b = networkClient;
    }
}
