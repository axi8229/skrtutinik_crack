package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.h4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1633h4 extends Lambda implements Function1 {
    public final /* synthetic */ C1807o4 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1633h4(C1807o4 c1807o4) {
        super(1);
        this.a = c1807o4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.a.e = ((Number) obj).longValue();
        return Unit.INSTANCE;
    }
}
