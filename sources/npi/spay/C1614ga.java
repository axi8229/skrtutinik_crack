package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.ga, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1614ga extends AbstractC1664ia {
    public final int a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1614ga(int i, String uri) {
        super(0);
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.a = i;
        this.b = uri;
    }
}
