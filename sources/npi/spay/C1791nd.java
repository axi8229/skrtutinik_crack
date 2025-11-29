package npi.spay;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.nd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1791nd implements FlowCollector {
    public final /* synthetic */ C1790nc a;
    public final /* synthetic */ C1940td b;

    public C1791nd(C1790nc c1790nc, C1940td c1940td) {
        this.a = c1790nc;
        this.b = c1940td;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Set set = (Set) obj;
        RecyclerView observeViewModel$lambda$26$lambda$23$lambda$22 = this.a.i;
        Intrinsics.checkNotNullExpressionValue(observeViewModel$lambda$26$lambda$23$lambda$22, "observeViewModel$lambda$26$lambda$23$lambda$22");
        observeViewModel$lambda$26$lambda$23$lambda$22.setVisibility(set.isEmpty() ? 4 : 0);
        Ch ch = this.b.e;
        if (ch == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintsAdapter");
            ch = null;
        }
        ch.submitList(CollectionsKt.toMutableList((Collection) set));
        return Unit.INSTANCE;
    }
}
