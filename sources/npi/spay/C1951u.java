package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* renamed from: npi.spay.u, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1951u {
    public final InterfaceC1997vk a;
    public final OkHttpClient.Builder b;
    public final C1993vg c;
    public InterfaceC1712k9 d;
    public InterfaceC2030x3 e;
    public OkHttpClient f;
    public C1552dn g;

    public C1951u(InterfaceC1997vk sslInteractor, OkHttpClient.Builder okHttpBuilder, C1993vg featuresHandler) {
        Intrinsics.checkNotNullParameter(sslInteractor, "sslInteractor");
        Intrinsics.checkNotNullParameter(okHttpBuilder, "okHttpBuilder");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        this.a = sslInteractor;
        this.b = okHttpBuilder;
        this.c = featuresHandler;
    }

    public final InterfaceC1712k9 a() {
        InterfaceC1712k9 interfaceC1712k9 = this.d;
        if (interfaceC1712k9 != null) {
            return interfaceC1712k9;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentFlowSPayApi");
        return null;
    }
}
