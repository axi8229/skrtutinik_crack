package npi.spay;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
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

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/fc;", "Lnpi/spay/Z7;", "Lnpi/spay/U8;", "Lnpi/spay/T9;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.fc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1591fc extends Z7<U8, T9> {
    public C1884r7 d;

    public static final void a(C1591fc this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((U8) this$0.b()).a(C2087za.a);
    }

    public static final void b(C1591fc this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((U8) this$0.b()).a(C2062ya.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return U8.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        T9 t9 = (T9) viewBinding;
        t9.e.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.fc$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1591fc.a(this.f$0, view);
            }
        });
        t9.d.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.fc$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1591fc.b(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            Pj pj = (Pj) n9;
            this.a = (Ql) pj.z0.get();
            this.d = pj.d.a();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        T9 t9 = (T9) viewBinding;
        Flow flowFilterNotNull = FlowKt.filterNotNull(((U8) b()).j);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Yb(this, state, flowFilterNotNull, null, t9), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1491bc(this, state, FlowKt.filterNotNull(((U8) b()).l), null, t9, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1566ec(this, state, FlowKt.filterNotNull(((U8) b()).n), null, this), 3, null);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((U8) b()).a(Aa.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        ((U8) b()).a(Ba.a);
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_no_matching_cards, (ViewGroup) null, false);
        int i = R$id.spay_lnmc_aciv_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatImageView != null) {
            i = R$id.spay_lnmc_actv_content;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatTextView != null) {
                i = R$id.spay_lnmc_actv_header;
                if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                    i = R$id.spay_lnmc_fl_container;
                    if (((LinearLayoutCompat) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                        i = R$id.spay_lnmc_mb_cancel;
                        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                        if (materialButton != null) {
                            i = R$id.spay_lnmc_mb_issue_card;
                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                            if (materialButton2 != null) {
                                T9 t9 = new T9((ConstraintLayout) viewInflate, appCompatImageView, appCompatTextView, materialButton, materialButton2);
                                Intrinsics.checkNotNullExpressionValue(t9, "inflate(layoutInflater)");
                                return t9;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
