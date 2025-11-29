package npi.spay;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
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

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/Cg;", "Lnpi/spay/Z7;", "Lnpi/spay/kh;", "Lnpi/spay/r5;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class Cg extends Z7<C1720kh, C1882r5> {
    public static final void a(Cg this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((C1720kh) this$0.b()).a(Qe.a);
    }

    public static final void b(Cg this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((C1720kh) this$0.b()).a(Re.a);
    }

    public static final void c(Cg this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((C1720kh) this$0.b()).a(Se.a);
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        C1882r5 c1882r5 = (C1882r5) viewBinding;
        c1882r5.f.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.Cg$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Cg.a(this.f$0, view);
            }
        });
        c1882r5.e.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.Cg$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Cg.b(this.f$0, view);
            }
        });
        c1882r5.b.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.Cg$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Cg.c(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).w0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        Flow flowFilterNotNull = FlowKt.filterNotNull(((C1720kh) b()).g);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Bg(this, state, flowFilterNotNull, null, (C1882r5) viewBinding), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C2068yg(this, state, FlowKt.filterNotNull(((C1720kh) b()).j), null, this), 3, null);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((C1720kh) b()).a(Te.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ((C1720kh) b()).a(Ue.a);
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_fraud_review_hint, (ViewGroup) null, false);
        int i = R$id.spay_frh_actv_hyperlink;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_frh_actv_message;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatTextView2 != null) {
                i = R$id.spay_frh_actv_title;
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                if (appCompatTextView3 != null) {
                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate;
                    i = R$id.spay_frh_mb_cancel;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                    if (materialButton != null) {
                        i = R$id.spay_frh_mb_confirm;
                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                        if (materialButton2 != null) {
                            C1882r5 c1882r5 = new C1882r5(linearLayoutCompat, appCompatTextView, appCompatTextView2, appCompatTextView3, materialButton, materialButton2);
                            Intrinsics.checkNotNullExpressionValue(c1882r5, "inflate(layoutInflater)");
                            return c1882r5;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return C1720kh.class;
    }
}
