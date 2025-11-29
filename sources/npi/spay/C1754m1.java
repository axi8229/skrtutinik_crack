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

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/m1;", "Lnpi/spay/Z7;", "Lnpi/spay/h3;", "Lnpi/spay/J3;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.m1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1754m1 extends Z7<C1632h3, J3> {
    public static final void a(C1754m1 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((C1632h3) this$0.b()).a(C2027x0.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return C1632h3.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((J3) viewBinding).d.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.m1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1754m1.a(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).x0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        Flow flowFilterNotNull = FlowKt.filterNotNull(((C1632h3) b()).g);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1729l1(this, state, flowFilterNotNull, null, (J3) viewBinding), 3, null);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((C1632h3) b()).a(C2052y0.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ((C1632h3) b()).a(C2077z0.a);
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_fraud_deny, (ViewGroup) null, false);
        int i = R$id.spay_fd_actv_message;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_fd_actv_title;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatTextView2 != null) {
                i = R$id.spay_fd_llc_container;
                if (((LinearLayoutCompat) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate;
                    int i2 = R$id.spay_fdb_mb_to_payment_methods;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i2);
                    if (materialButton != null) {
                        J3 j3 = new J3(linearLayoutCompat, appCompatTextView, appCompatTextView2, materialButton);
                        Intrinsics.checkNotNullExpressionValue(j3, "inflate(layoutInflater)");
                        return j3;
                    }
                    i = i2;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
