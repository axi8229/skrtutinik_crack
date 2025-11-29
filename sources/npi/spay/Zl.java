package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Zl implements FlowCollector {
    public final /* synthetic */ I4 a;

    public Zl(I4 i4) {
        this.a = i4;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Sj sj = (Sj) obj;
        this.a.c.setText(sj.a);
        this.a.b.setText(sj.c);
        this.a.d.setText(sj.e);
        return Unit.INSTANCE;
    }
}
