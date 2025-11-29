package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.do, reason: invalid class name */
/* loaded from: classes4.dex */
public final class Cdo implements FlowCollector {
    public final /* synthetic */ mo a;

    public Cdo(mo moVar) {
        this.a = moVar;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.setCancelable(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }
}
