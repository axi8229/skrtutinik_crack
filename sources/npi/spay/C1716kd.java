package npi.spay;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import spay.sdk.view.SpayBnplGraphCompositeView;

/* renamed from: npi.spay.kd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1716kd implements FlowCollector {
    public final /* synthetic */ C1940td a;
    public final /* synthetic */ C1790nc b;

    public C1716kd(C1790nc c1790nc, C1940td c1940td) {
        this.a = c1940td;
        this.b = c1790nc;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        List list = (List) obj;
        C1989vc c1989vc = this.a.d;
        C1866qd c1866qd = null;
        if (c1989vc == null) {
            Intrinsics.throwUninitializedPropertyAccessException("amountAdapter");
            c1989vc = null;
        }
        c1989vc.a(list);
        if (CollectionsKt.first(list) instanceof C1811o8) {
            RecyclerView recyclerView = this.b.h;
            C1866qd c1866qd2 = this.a.f;
            if (c1866qd2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disabledScrollOnItemTouchListener");
            } else {
                c1866qd = c1866qd2;
            }
            recyclerView.addOnItemTouchListener(c1866qd);
            SpayBnplGraphCompositeView spaySloSbgcvGraph = this.b.j;
            Intrinsics.checkNotNullExpressionValue(spaySloSbgcvGraph, "spaySloSbgcvGraph");
            spaySloSbgcvGraph.setVisibility(8);
        } else {
            RecyclerView recyclerView2 = this.b.h;
            C1866qd c1866qd3 = this.a.f;
            if (c1866qd3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disabledScrollOnItemTouchListener");
            } else {
                c1866qd = c1866qd3;
            }
            recyclerView2.removeOnItemTouchListener(c1866qd);
            SpayBnplGraphCompositeView spaySloSbgcvGraph2 = this.b.j;
            Intrinsics.checkNotNullExpressionValue(spaySloSbgcvGraph2, "spaySloSbgcvGraph");
            spaySloSbgcvGraph2.setVisibility(0);
            SpayBnplGraphCompositeView spaySloSbgcvGraph3 = this.b.j;
            Intrinsics.checkNotNullExpressionValue(spaySloSbgcvGraph3, "spaySloSbgcvGraph");
            int size = list.size();
            int i = SpayBnplGraphCompositeView.d;
            spaySloSbgcvGraph3.a(size, 0);
        }
        return Unit.INSTANCE;
    }
}
