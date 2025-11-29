package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.ji, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1696ji implements FlowCollector {
    public final /* synthetic */ C1570eg a;

    public C1696ji(C1570eg c1570eg) {
        this.a = c1570eg;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.l.setChecked(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }
}
