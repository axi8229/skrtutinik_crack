package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class H0 extends I0 {
    public final M3 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H0(M3 selectedCardPosition) {
        super(0);
        Intrinsics.checkNotNullParameter(selectedCardPosition, "selectedCardPosition");
        this.a = selectedCardPosition;
    }
}
