package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.x, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2026x implements FlowCollector {
    public final /* synthetic */ C1960u8 a;

    public C2026x(C1960u8 c1960u8) {
        this.a = c1960u8;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.b.setText((String) obj);
        return Unit.INSTANCE;
    }
}
