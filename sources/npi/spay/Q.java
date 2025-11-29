package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Q implements FlowCollector {
    public final /* synthetic */ Na a;

    public Q(Na na) {
        this.a = na;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.d.setEnabled(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }
}
