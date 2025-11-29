package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.ie, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1668ie extends AbstractC1742le {
    public final InterfaceC2020wi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1668ie(InterfaceC2020wi bannerData) {
        super(0);
        Intrinsics.checkNotNullParameter(bannerData, "bannerData");
        this.a = bannerData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1668ie) && Intrinsics.areEqual(this.a, ((C1668ie) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "OnHelperBannerClickedEvent(bannerData=" + this.a + ')';
    }
}
