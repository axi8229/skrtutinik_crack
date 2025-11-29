package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.k6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1709k6 implements InterfaceC2089zc {
    public boolean a = true;

    @Override // npi.spay.InterfaceC2089zc
    public final Object a(Pe pe) {
        return Boolean.valueOf(this.a);
    }

    @Override // npi.spay.InterfaceC2089zc
    public final void a(Zd zd) {
        Intrinsics.checkNotNull(zd, "null cannot be cast to non-null type spay.sdk.utils.feature.ResultViewFeatureHandler.IsResultViewEnabledByMerchant");
        this.a = ((C1684j6) zd).a;
    }
}
