package npi.spay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/Ab;", "Lnpi/spay/Z7;", "Lnpi/spay/qg;", "Lnpi/spay/oo;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class Ab extends Z7<C1869qg, oo> {
    public C1989vc d;

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_card_selection, (ViewGroup) null, false);
        int i = R$id.spay_slcs_actv_order_sum;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_slcs_actv_title;
            if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                int i2 = R$id.spay_slcs_rv_cards_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, i2);
                if (recyclerView != null) {
                    oo ooVar = new oo(constraintLayout, appCompatTextView, recyclerView);
                    Intrinsics.checkNotNullExpressionValue(ooVar, "inflate(layoutInflater)");
                    return ooVar;
                }
                i = i2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return C1869qg.class;
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            Pj pj = (Pj) n9;
            this.a = (Ql) pj.i0.get();
            pj.d.a();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Flow flowFilterNotNull = FlowKt.filterNotNull(((C1869qg) b()).h);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1963ub(this, state, flowFilterNotNull, null, (oo) viewBinding, contextRequireContext), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C2038xb(this, state, FlowKt.filterNotNull(((C1869qg) b()).i), null, this), 3, null);
    }

    @Override // npi.spay.Z7
    public final void g() {
        C1989vc c1989vc = new C1989vc(new C1487b8(new C2063yb(this)), new C1821oi(), new C1688ja(C2088zb.a));
        this.d = c1989vc;
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((oo) viewBinding).c.setAdapter(c1989vc);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((C1869qg) b()).a(F0.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ((C1869qg) b()).a(G0.a);
    }
}
