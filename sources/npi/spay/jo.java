package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class jo implements FlowCollector {
    public final /* synthetic */ mo a;

    public jo(mo moVar) {
        this.a = moVar;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        ((C2064yc) obj).a(new C1753m0(this.a));
        return Unit.INSTANCE;
    }
}
