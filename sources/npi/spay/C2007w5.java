package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.w5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2007w5 extends Lambda implements Function0 {
    public final /* synthetic */ AbstractC2032x5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2007w5(AbstractC2032x5 abstractC2032x5) {
        super(0);
        this.a = abstractC2032x5;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.dismiss();
        return Unit.INSTANCE;
    }
}
