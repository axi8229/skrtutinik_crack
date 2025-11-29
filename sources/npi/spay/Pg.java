package npi.spay;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.R$raw;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/Pg;", "Lnpi/spay/si;", "Lnpi/spay/Eh;", "Lnpi/spay/Vg;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class Pg extends AbstractC1920si<Eh, Vg> {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static final void a(Pg this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((Jh) ((Eh) this$0.b()).c).a(C1975un.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return Eh.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((Vg) viewBinding).c.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.Pg$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Pg.a(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).o0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        Flow flowFilterNotNull = FlowKt.filterNotNull(((Eh) b()).f);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Og(this, Lifecycle.State.STARTED, flowFilterNotNull, null, this), 3, null);
    }

    @Override // npi.spay.Z7
    public final void g() throws IllegalStateException {
        d();
        Context context = requireContext();
        Intrinsics.checkNotNullExpressionValue(context, "requireContext()");
        Intrinsics.checkNotNullParameter(context, "context");
        MediaPlayer.create(context, R$raw.processing_payment_sound).start();
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_processing_payment, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
        int i = R$id.spay_slpp_actv_processing_message;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_slpp_actv_title;
            if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                i = R$id.spay_slpp_lottie_success;
                if (((LottieAnimationView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                    i = R$id.spay_slpp_mb_btn_close;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                    if (materialButton != null) {
                        Vg vg = new Vg(appCompatTextView, constraintLayout, materialButton);
                        Intrinsics.checkNotNullExpressionValue(vg, "inflate(layoutInflater)");
                        return vg;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
