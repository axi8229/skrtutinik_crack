package npi.spay;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.hd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1642hd implements FlowCollector {
    public final /* synthetic */ C1790nc a;
    public final /* synthetic */ Context b;

    public C1642hd(C1790nc c1790nc, Context context) {
        this.a = c1790nc;
        this.b = context;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.g.setText(AbstractC1550dl.a((Bk) obj, this.b));
        return Unit.INSTANCE;
    }
}
