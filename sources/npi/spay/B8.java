package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class B8 extends Lambda implements Function1 {
    public final /* synthetic */ InterfaceC1738la a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B8(InterfaceC1738la interfaceC1738la) {
        super(1);
        this.a = interfaceC1738la;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((C2081z4) this.a).n.invoke(Long.valueOf(((Number) obj).longValue()));
        return Unit.INSTANCE;
    }
}
