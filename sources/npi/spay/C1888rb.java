package npi.spay;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/rb;", "Lnpi/spay/Z7;", "Lnpi/spay/Td;", "Lnpi/spay/Ed;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.rb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1888rb extends Z7<Td, Ed> {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static final void a(C1888rb this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Td) this$0.b()).a(C1514ca.a);
    }

    public static final void b(C1888rb this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Td) this$0.b()).a(C1539da.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return Td.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((Ed) viewBinding).c.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.rb$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1888rb.a(this.f$0, view);
            }
        });
        ViewBinding viewBinding2 = this.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        ((Ed) viewBinding2).d.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.rb$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1888rb.b(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).j0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        Flow flowFilterNotNull = FlowKt.filterNotNull(((Td) b()).h);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Ya(this, state, flowFilterNotNull, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1490bb(this, state, FlowKt.filterNotNull(((Td) b()).k), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1565eb(this, state, FlowKt.filterNotNull(((Td) b()).i), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1640hb(this, state, FlowKt.filterNotNull(((Td) b()).j), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1714kb(this, state, ((Td) b()).g, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1789nb(this, state, ((Td) b()).l, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1864qb(this, state, ((Td) b()).m, null, this), 3, null);
    }

    @Override // npi.spay.Z7
    public final void g() {
        h();
        d();
    }

    public final void h() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((Ed) viewBinding).h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: npi.spay.rb$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C1888rb.a(this.f$0, compoundButton, z);
            }
        });
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((Td) b()).a(C1564ea.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ((Td) b()).a(C1589fa.a);
    }

    public static final void a(C1888rb this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Td) this$0.b()).a(new C1639ha(z));
        ViewBinding viewBinding = this$0.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((Ed) viewBinding).c.setEnabled(z);
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_order_bnpl, (ViewGroup) null, false);
        int i = R$id.spay_commission;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_lob_mb_apply_payment_in_installments;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
            if (materialButton != null) {
                i = R$id.spay_lob_mb_decline_payment_in_installments;
                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                if (materialButton2 != null) {
                    i = R$id.spay_slob_actv_agreement_conditions;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                    if (appCompatTextView2 != null) {
                        i = R$id.spay_slob_actv_header;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                        if (appCompatTextView3 != null) {
                            i = R$id.spay_slob_actv_total;
                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                            if (appCompatTextView4 != null) {
                                i = R$id.spay_slob_chck_agreement_conditions;
                                AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(viewInflate, i);
                                if (appCompatCheckBox != null) {
                                    i = R$id.spay_slob_fl_total;
                                    if (((FrameLayout) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                                        i = R$id.spay_slob_root;
                                        if (((ConstraintLayout) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                                            i = R$id.spay_slob_rv_bnpl_payment_count;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, i);
                                            if (recyclerView != null) {
                                                Ed ed = new Ed((NestedScrollView) viewInflate, appCompatTextView, materialButton, materialButton2, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatCheckBox, recyclerView);
                                                Intrinsics.checkNotNullExpressionValue(ed, "inflate(layoutInflater)");
                                                return ed;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
