package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.t5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1932t5 extends Lambda implements Function0 {
    public final /* synthetic */ InterfaceC1859q6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1932t5(InterfaceC1859q6 interfaceC1859q6) {
        super(0);
        this.a = interfaceC1859q6;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.b().invoke();
        return Unit.INSTANCE;
    }
}
