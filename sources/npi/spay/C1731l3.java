package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.l3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1731l3 extends Va {
    public final InterfaceC2073yl a;
    public final Ih b;

    public C1731l3(InterfaceC2073yl sPayRepository, Ih sPayDataContract) {
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        this.a = sPayRepository;
        this.b = sPayDataContract;
    }
}
