package npi.spay;

import android.content.Intent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.wg, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2018wg implements FlowCollector {
    public final /* synthetic */ Cg a;

    public C2018wg(Cg cg) {
        this.a = cg;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.a.startActivity((Intent) obj);
        return Unit.INSTANCE;
    }
}
