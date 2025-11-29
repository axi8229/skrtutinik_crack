package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.yb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2063yb extends Lambda implements Function1 {
    public final /* synthetic */ Ab a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2063yb(Ab ab) {
        super(1);
        this.a = ab;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        M3 it = (M3) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        ((C1869qg) this.a.b()).a(new H0(it));
        return Unit.INSTANCE;
    }
}
