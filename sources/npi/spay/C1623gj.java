package npi.spay;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/gj;", "Lnpi/spay/Z7;", "Lnpi/spay/Tk;", "Lnpi/spay/Ge;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.gj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1623gj extends Z7<Tk, Ge> {
    public static final void a(C1623gj this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Jh) ((Tk) this$0.b()).c).a(C1975un.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return Tk.class;
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).r0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        Intrinsics.checkNotNullExpressionValue(requireContext(), "requireContext()");
    }

    @Override // npi.spay.Z7
    public final void g() {
        h();
    }

    public final void h() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((Ge) viewBinding).b.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.gj$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1623gj.a(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_otp_error, (ViewGroup) null, false);
        int i = R$id.spay_sloe_actv_subtitle;
        if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
            i = R$id.spay_sloe_actv_title;
            if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                int i2 = R$id.spay_sloe_lottie_failure;
                if (((LottieAnimationView) ViewBindings.findChildViewById(viewInflate, i2)) != null) {
                    i2 = R$id.spay_sloe_mb_to_payment_methods_button;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i2);
                    if (materialButton != null) {
                        Ge ge = new Ge(constraintLayout, materialButton);
                        Intrinsics.checkNotNullExpressionValue(ge, "inflate(layoutInflater)");
                        return ge;
                    }
                }
                i = i2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
