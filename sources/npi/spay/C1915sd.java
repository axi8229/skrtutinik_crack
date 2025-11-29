package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.sd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1915sd extends Lambda implements Function1 {
    public final /* synthetic */ C1940td a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1915sd(C1940td c1940td) {
        super(1);
        this.a = c1940td;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C2012wa it = (C2012wa) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        ((Xf) this.a.b()).a(new C1867qe(it));
        return Unit.INSTANCE;
    }
}
