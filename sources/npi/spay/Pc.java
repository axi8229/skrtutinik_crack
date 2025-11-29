package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Pc implements FlowCollector {
    public final /* synthetic */ C1790nc a;

    public Pc(C1790nc c1790nc) {
        this.a = c1790nc;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.k.setBonusCount(((Number) obj).intValue());
        return Unit.INSTANCE;
    }
}
