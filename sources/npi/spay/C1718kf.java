package npi.spay;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.kf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1718kf implements FlowCollector {
    public final /* synthetic */ C1586f7 a;
    public final /* synthetic */ Context b;

    public C1718kf(C1586f7 c1586f7, Context context) {
        this.a = c1586f7;
        this.b = context;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        C1616gc c1616gc = (C1616gc) obj;
        this.a.c.setText(AbstractC1550dl.a(c1616gc.a, this.b));
        this.a.b.setText(AbstractC1550dl.a(c1616gc.b, this.b));
        return Unit.INSTANCE;
    }
}
