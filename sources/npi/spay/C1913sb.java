package npi.spay;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.sb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1913sb implements FlowCollector {
    public final /* synthetic */ oo a;
    public final /* synthetic */ Context b;

    public C1913sb(oo ooVar, Context context) {
        this.a = ooVar;
        this.b = context;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.b.setText(AbstractC1550dl.a((Bk) obj, this.b));
        return Unit.INSTANCE;
    }
}
