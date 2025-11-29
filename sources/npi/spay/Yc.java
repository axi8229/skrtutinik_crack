package npi.spay;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Yc implements FlowCollector {
    public final /* synthetic */ C1790nc a;
    public final /* synthetic */ Context b;

    public Yc(C1790nc c1790nc, Context context) {
        this.a = c1790nc;
        this.b = context;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.m.setText(AbstractC1550dl.a(((Bf) obj).a, this.b));
        return Unit.INSTANCE;
    }
}
