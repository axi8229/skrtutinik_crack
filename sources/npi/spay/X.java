package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class X implements FlowCollector {
    public final /* synthetic */ Na a;

    public X(Na na) {
        this.a = na;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ((C2064yc) obj).a(new B1(this.a));
        return Unit.INSTANCE;
    }
}
