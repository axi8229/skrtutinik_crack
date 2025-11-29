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
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ru.yoomoney.sdk.kassa.payments.R$dimen;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;
import spay.sdk.view.SpayUserDataCompositeView;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/wf;", "Lnpi/spay/Z7;", "Lnpi/spay/zh;", "Lnpi/spay/f7;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.wf, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2017wf extends Z7<C2094zh, C1586f7> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public Ch d;
    public C1989vc e;

    public static final void a(C2017wf this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((C2094zh) this$0.b()).a(C1593fe.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return C2094zh.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((C1586f7) viewBinding).d.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.wf$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2017wf.a(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            Pj pj = (Pj) n9;
            this.a = (Ql) pj.A0.get();
            pj.d.a();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        C1586f7 c1586f7 = (C1586f7) viewBinding;
        Flow flowFilterNotNull = FlowKt.filterNotNull(((C2094zh) b()).j);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1544df(this, state, flowFilterNotNull, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1843pf(this, state, FlowKt.filterNotNull(((C2094zh) b()).n), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1619gf(this, state, FlowKt.filterNotNull(((C2094zh) b()).l), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1693jf(this, state, FlowKt.filterNotNull(((C2094zh) b()).o), null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1768mf(this, state, ((C2094zh) b()).p, null, c1586f7, contextRequireContext), 3, null);
    }

    @Override // npi.spay.Z7
    public final void g() throws IllegalStateException {
        Ch ch = new Ch(new C1568ee(), new C1868qf(this));
        this.d = ch;
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        RecyclerView recyclerView = ((C1586f7) viewBinding).f;
        recyclerView.setAdapter(ch);
        recyclerView.addOnItemTouchListener(new C1892rf());
        C1989vc c1989vc = new C1989vc(new C1700jm(new C1917sf(this)), new Q8(new C1942tf(this)), new S9(new C1967uf(this)));
        this.e = c1989vc;
        ViewBinding viewBinding2 = this.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        RecyclerView recyclerView2 = ((C1586f7) viewBinding2).e;
        recyclerView2.setAdapter(c1989vc);
        Context context = recyclerView2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int i = R$dimen.spay_8dp;
        Intrinsics.checkNotNullParameter(context, "<this>");
        recyclerView2.addItemDecoration(new Ze(context.getResources().getDimensionPixelSize(i)));
        C1992vf snapListener = new C1992vf();
        Intrinsics.checkNotNullParameter(snapListener, "snapListener");
        new Xj(snapListener).attachToRecyclerView(recyclerView2);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((C2094zh) b()).a(C1692je.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ((C2094zh) b()).a(C1717ke.a);
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_heplers, (ViewGroup) null, false);
        int i = R$id.spay_slh_actv_merchant_name;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_slh_actv_order_amount;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatTextView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                i = R$id.spay_slh_mb_cancel;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                if (materialButton != null) {
                    i = R$id.spay_slh_rv_helpers;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(viewInflate, i);
                    if (recyclerView != null) {
                        i = R$id.spay_slh_rv_hint_helper;
                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(viewInflate, i);
                        if (recyclerView2 != null) {
                            i = R$id.spay_slh_sudcv_user_data;
                            SpayUserDataCompositeView spayUserDataCompositeView = (SpayUserDataCompositeView) ViewBindings.findChildViewById(viewInflate, i);
                            if (spayUserDataCompositeView != null) {
                                C1586f7 c1586f7 = new C1586f7(constraintLayout, appCompatTextView, appCompatTextView2, materialButton, recyclerView, recyclerView2, spayUserDataCompositeView);
                                Intrinsics.checkNotNullExpressionValue(c1586f7, "inflate(layoutInflater)");
                                return c1586f7;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
