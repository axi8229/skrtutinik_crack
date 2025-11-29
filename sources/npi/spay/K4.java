package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class K4 extends Lambda implements Function1 {
    public final /* synthetic */ InterfaceC1859q6 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K4(InterfaceC1859q6 interfaceC1859q6) {
        super(1);
        this.a = interfaceC1859q6;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.a.a().invoke(Long.valueOf(((Number) obj).longValue()));
        return Unit.INSTANCE;
    }
}
