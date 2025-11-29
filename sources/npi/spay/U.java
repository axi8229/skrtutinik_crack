package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class U implements FlowCollector {
    public final /* synthetic */ C1579f0 a;

    public U(C1579f0 c1579f0) {
        this.a = c1579f0;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ((C2064yc) obj).a(new K0(this.a));
        return Unit.INSTANCE;
    }
}
