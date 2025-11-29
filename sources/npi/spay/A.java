package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class A implements FlowCollector {
    public final /* synthetic */ D a;

    public A(D d) {
        this.a = d;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ((C2064yc) obj).a(new J0(this.a));
        return Unit.INSTANCE;
    }
}
