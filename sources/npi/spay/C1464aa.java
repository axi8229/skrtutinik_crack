package npi.spay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/aa;", "Lnpi/spay/Z7;", "Lnpi/spay/rc;", "Lnpi/spay/yk;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.aa, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1464aa extends Z7<C1889rc, C2072yk> {
    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_user_profile, (ViewGroup) null, false);
        int i = R$id.spay_slup_mb_btn_pay;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
        if (materialButton != null) {
            i = R$id.spay_slup_mb_btn_quit;
            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
            if (materialButton2 != null) {
                i = R$id.spay_slup_siv_user_icon;
                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(viewInflate, i);
                if (shapeableImageView != null) {
                    i = R$id.spay_slup_tv_user_mail;
                    TextView textView = (TextView) ViewBindings.findChildViewById(viewInflate, i);
                    if (textView != null) {
                        i = R$id.spay_slup_tv_user_name;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(viewInflate, i);
                        if (textView2 != null) {
                            i = R$id.spay_slup_tv_user_phone;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(viewInflate, i);
                            if (textView3 != null) {
                                C2072yk c2072yk = new C2072yk((ConstraintLayout) viewInflate, materialButton, materialButton2, shapeableImageView, textView, textView2, textView3);
                                Intrinsics.checkNotNullExpressionValue(c2072yk, "inflate(layoutInflater)");
                                return c2072yk;
                            }
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
        return C1889rc.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        MaterialButton materialButton = ((C2072yk) viewBinding).c;
        Intrinsics.checkNotNullExpressionValue(materialButton, "binding.spaySlupMbBtnQuit");
        materialButton.setOnClickListener(new V9(new Ref$LongRef(), this));
        ViewBinding viewBinding2 = this.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        MaterialButton materialButton2 = ((C2072yk) viewBinding2).b;
        Intrinsics.checkNotNullExpressionValue(materialButton2, "binding.spaySlupMbBtnPay");
        materialButton2.setOnClickListener(new W9(new Ref$LongRef(), this));
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            Pj pj = (Pj) n9;
            this.a = (Ql) pj.s0.get();
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
        Flow flowFilterNotNull = FlowKt.filterNotNull(((C1889rc) b()).g);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Z9(this, state, flowFilterNotNull, null, (C2072yk) viewBinding, contextRequireContext), 3, null);
    }

    @Override // npi.spay.Z7
    public final void g() {
        d();
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ((C1889rc) b()).a(Ra.a);
    }

    @Override // npi.spay.Z7, androidx.fragment.app.Fragment
    public final void onStop() {
        ((C1889rc) b()).a(Sa.a);
        super.onStop();
    }
}
