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

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/S5;", "Lnpi/spay/Z7;", "Lnpi/spay/K6;", "Lnpi/spay/o6;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class S5 extends Z7<K6, C1809o6> {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static final void a(S5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((K6) this$0.b()).a(T4.a);
    }

    public static final void b(S5 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((K6) this$0.b()).a(U4.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return K6.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        C1809o6 c1809o6 = (C1809o6) viewBinding;
        c1809o6.e.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.S5$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                S5.a(this.f$0, view);
            }
        });
        c1809o6.d.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.S5$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                S5.b(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).v0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        Flow flowFilterNotNull = FlowKt.filterNotNull(((K6) b()).g);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new R5(this, Lifecycle.State.STARTED, flowFilterNotNull, null, this), 3, null);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((K6) b()).a(V4.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ((K6) b()).a(W4.a);
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_fraud_review_otp, (ViewGroup) null, false);
        int i = R$id.spay_fro_actv_message;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_fro_actv_title;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatTextView2 != null) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate;
                i = R$id.spay_fro_mb_cancel;
                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                if (materialButton != null) {
                    i = R$id.spay_fro_mb_confirm;
                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                    if (materialButton2 != null) {
                        C1809o6 c1809o6 = new C1809o6(linearLayoutCompat, appCompatTextView, appCompatTextView2, materialButton, materialButton2);
                        Intrinsics.checkNotNullExpressionValue(c1809o6, "inflate(layoutInflater)");
                        return c1809o6;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
