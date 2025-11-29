package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.uf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1967uf extends Lambda implements Function1 {
    public final /* synthetic */ C2017wf a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1967uf(C2017wf c2017wf) {
        super(1);
        this.a = c2017wf;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        InterfaceC2020wi it = (InterfaceC2020wi) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        ((C2094zh) this.a.b()).a(new C1668ie(it));
        return Unit.INSTANCE;
    }
}
