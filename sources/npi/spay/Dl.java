package npi.spay;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class Dl implements FlowCollector {
    public final /* synthetic */ C1896rj a;
    public final /* synthetic */ Context b;

    public Dl(C1896rj c1896rj, Context context) {
        this.a = c1896rj;
        this.b = context;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.c.setText(AbstractC1550dl.a((Bk) obj, this.b));
        return Unit.INSTANCE;
    }
}
