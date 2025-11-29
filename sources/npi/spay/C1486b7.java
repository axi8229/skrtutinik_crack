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

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/b7;", "Lnpi/spay/Z7;", "Lnpi/spay/M7;", "Lnpi/spay/Mh;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.b7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1486b7 extends Z7<M7, Mh> {
    public static final void a(C1486b7 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        M7 m7 = (M7) this$0.b();
        m7.getClass();
        C1560e6 event = new C1560e6(EnumC1595fg.TOUCH_TOP_BUTTON, EnumC1877r0.STATUS_VIEW, C0.TOUCH, null, null, null, null, 120);
        Intrinsics.checkNotNullParameter(event, "event");
        m7.a.a(event);
    }

    public static final void b(C1486b7 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        M7 m7 = (M7) this$0.b();
        m7.getClass();
        C1560e6 event = new C1560e6(EnumC1595fg.TOUCH_BOTTOM_BUTTON, EnumC1877r0.STATUS_VIEW, C0.TOUCH, null, null, null, null, 120);
        Intrinsics.checkNotNullParameter(event, "event");
        m7.a.a(event);
        ((Jh) m7.d).a(new C2050xn(C1825om.a, false));
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return M7.class;
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).m0.get();
        }
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
        ((Mh) viewBinding).c.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.b7$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1486b7.a(this.f$0, view);
            }
        });
        ViewBinding viewBinding2 = this.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        ((Mh) viewBinding2).b.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.b7$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1486b7.b(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_retry_without_bnpl, (ViewGroup) null, false);
        int i = R$id.spay_lrwb_actv_subtitle;
        if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
            i = R$id.spay_lrwb_actv_title;
            if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                i = R$id.spay_lrwb_lottie_failure;
                if (((LottieAnimationView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                    i = R$id.spay_lrwb_mb_leave;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                    if (materialButton != null) {
                        i = R$id.spay_lrwb_mb_pay;
                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                        if (materialButton2 != null) {
                            Mh mh = new Mh((ConstraintLayout) viewInflate, materialButton, materialButton2);
                            Intrinsics.checkNotNullExpressionValue(mh, "inflate(layoutInflater)");
                            return mh;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
