package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* renamed from: npi.spay.oj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1822oj implements Ei {
    public final MutableStateFlow a;
    public final StateFlow b;

    public C1822oj() {
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(new C1604g0());
        this.a = MutableStateFlow;
        this.b = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow a() {
        return this.b;
    }

    public final C1604g0 b() {
        return (C1604g0) this.b.getValue();
    }

    public final void a(AbstractC1855q2 income) {
        Intrinsics.checkNotNullParameter(income, "income");
        MutableStateFlow mutableStateFlow = this.a;
        mutableStateFlow.setValue(C1604g0.a((C1604g0) mutableStateFlow.getValue(), income, null, false, 6));
    }
}
