package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class E implements FlowCollector {
    public final /* synthetic */ Na a;

    public E(Na na) {
        this.a = na;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.c.setEnabled(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }
}
