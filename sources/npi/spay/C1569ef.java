package npi.spay;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: npi.spay.ef, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1569ef implements FlowCollector {
    public final /* synthetic */ C2017wf a;

    public C1569ef(C2017wf c2017wf) {
        this.a = c2017wf;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        List list = (List) obj;
        C2017wf c2017wf = this.a;
        int i = C2017wf.$r8$clinit;
        ViewBinding viewBinding = c2017wf.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        RecyclerView recyclerView = ((C1586f7) viewBinding).f;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.spaySlhRvHintHelper");
        recyclerView.setVisibility(list.isEmpty() ? 4 : 0);
        Ch ch = this.a.d;
        if (ch == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintsAdapter");
            ch = null;
        }
        ch.submitList(list);
        return Unit.INSTANCE;
    }
}
