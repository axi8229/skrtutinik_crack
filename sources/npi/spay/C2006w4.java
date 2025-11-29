package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.w4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2006w4 extends Lambda implements Function1 {
    public final /* synthetic */ C2081z4 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2006w4(C2081z4 c2081z4) {
        super(1);
        this.a = c2081z4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.a.j.setValue(Long.valueOf(((Number) obj).longValue()));
        return Unit.INSTANCE;
    }
}
