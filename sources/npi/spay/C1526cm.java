package npi.spay;

import android.os.Bundle;
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

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/cm;", "Lnpi/spay/Z7;", "Lnpi/spay/Ym;", "Lnpi/spay/I4;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.cm, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1526cm extends Z7<Ym, I4> {
    public static final void a(C1526cm this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Ym) this$0.b()).a(C1724kl.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return Ym.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((I4) viewBinding).d.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.cm$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1526cm.a(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).y0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        Flow flowFilterNotNull = FlowKt.filterNotNull(((Ym) b()).g);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1501bm(this, state, flowFilterNotNull, null, (I4) viewBinding), 3, null);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((Ym) b()).a(C1749ll.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ((Ym) b()).a(C1774ml.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        d();
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_fraud_deny_block, (ViewGroup) null, false);
        int i = R$id.spay_fdb_actv_message;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_fdb_actv_title;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatTextView2 != null) {
                i = R$id.spay_fdb_llc_container;
                if (((LinearLayoutCompat) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate;
                    int i2 = R$id.spay_fdb_mb_return_to_shop;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i2);
                    if (materialButton != null) {
                        I4 i4 = new I4(linearLayoutCompat, appCompatTextView, appCompatTextView2, materialButton);
                        Intrinsics.checkNotNullExpressionValue(i4, "inflate(layoutInflater)");
                        return i4;
                    }
                    i = i2;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
