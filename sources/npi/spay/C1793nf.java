package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.nf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1793nf implements FlowCollector {
    public final /* synthetic */ C2017wf a;

    public C1793nf(C2017wf c2017wf) {
        this.a = c2017wf;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ((C2064yc) obj).a(new Ig(this.a));
        return Unit.INSTANCE;
    }
}
