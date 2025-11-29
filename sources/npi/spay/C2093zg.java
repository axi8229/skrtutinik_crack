package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.zg, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2093zg implements FlowCollector {
    public final /* synthetic */ C1882r5 a;

    public C2093zg(C1882r5 c1882r5) {
        this.a = c1882r5;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Sj sj = (Sj) obj;
        this.a.d.setText(sj.a);
        this.a.c.setText(sj.b);
        this.a.f.setText(sj.d);
        this.a.e.setText(sj.e);
        this.a.b.setText(sj.f);
        return Unit.INSTANCE;
    }
}
