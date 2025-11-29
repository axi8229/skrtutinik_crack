package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class B5 implements FlowCollector {
    public final /* synthetic */ I5 a;

    public B5(I5 i5) {
        this.a = i5;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ((C2064yc) obj).a(new H5(this.a));
        return Unit.INSTANCE;
    }
}
