package npi.spay;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes4.dex */
public final class H implements FlowCollector {
    public final /* synthetic */ Na a;
    public final /* synthetic */ Context b;

    public H(Na na, Context context) {
        this.a = na;
        this.b = context;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.f.setText(AbstractC1550dl.a((Bk) obj, this.b));
        return Unit.INSTANCE;
    }
}
