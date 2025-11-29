package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.j1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1679j1 implements FlowCollector {
    public final /* synthetic */ J3 a;

    public C1679j1(J3 j3) {
        this.a = j3;
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
