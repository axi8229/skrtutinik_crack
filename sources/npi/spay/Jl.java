package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Jl implements FlowCollector {
    public final /* synthetic */ C1896rj a;

    public Jl(C1896rj c1896rj) {
        this.a = c1896rj;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.e.setBonusCount(((Number) obj).intValue());
        return Unit.INSTANCE;
    }
}
