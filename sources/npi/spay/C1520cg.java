package npi.spay;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/cg;", "Lnpi/spay/si;", "Lnpi/spay/Tg;", "Lnpi/spay/Hi;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.cg, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1520cg extends AbstractC1920si<Tg, Hi> {
    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_sdk_version_deprecated_error, (ViewGroup) null, false);
        int i = R$id.spay_slsvde_actv_to_payment_methods;
        if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
            i = R$id.spay_slsvde_cv_to_payment_methods;
            CardView cardView = (CardView) ViewBindings.findChildViewById(viewInflate, i);
            if (cardView != null) {
                FrameLayout frameLayout = (FrameLayout) viewInflate;
                int i2 = R$id.spay_slsvde_tv_otp_error;
                if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i2)) != null) {
                    Hi hi = new Hi(frameLayout, cardView);
                    Intrinsics.checkNotNullExpressionValue(hi, "inflate(layoutInflater)");
                    return hi;
                }
                i = i2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return Tg.class;
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).t0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void g() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        CardView cardView = ((Hi) viewBinding).b;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.spaySlsvdeCvToPaymentMethods");
        cardView.setOnClickListener(new Ee(new Ref$LongRef(), this));
    }
}
