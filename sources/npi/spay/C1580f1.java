package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.f1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1580f1 extends Lambda implements Function0 {
    public final /* synthetic */ C1655i1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1580f1(C1655i1 c1655i1) {
        super(0);
        this.a = c1655i1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.e = null;
        return Unit.INSTANCE;
    }
}
