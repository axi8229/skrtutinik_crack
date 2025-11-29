package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.z9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2086z9 extends Lambda implements Function0 {
    public final /* synthetic */ InterfaceC1738la a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2086z9(InterfaceC1738la interfaceC1738la) {
        super(0);
        this.a = interfaceC1738la;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ((C2081z4) this.a).o.invoke();
        return Unit.INSTANCE;
    }
}
