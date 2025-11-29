package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.cc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1516cc implements FlowCollector {
    public final /* synthetic */ C1591fc a;

    public C1516cc(C1591fc c1591fc) {
        this.a = c1591fc;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ((C2064yc) obj).a(new Kc(this.a));
        return Unit.INSTANCE;
    }
}
