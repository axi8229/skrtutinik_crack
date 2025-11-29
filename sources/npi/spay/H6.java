package npi.spay;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
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
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.StateFlow;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.R$raw;
import ru.yoomoney.sdk.kassa.payments.R$string;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/H6;", "Lnpi/spay/si;", "Lnpi/spay/x7;", "Lnpi/spay/Q0;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class H6 extends AbstractC1920si<C2034x7, Q0> {
    public static final /* synthetic */ int $r8$clinit = 0;

    public static final void a(H6 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((C2034x7) this$0.b()).a(C1571eh.a);
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return C2034x7.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((Q0) viewBinding).e.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.H6$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                H6.a(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).p0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        StateFlow stateFlow = ((C2034x7) b()).e;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new G6(this, Lifecycle.State.STARTED, stateFlow, null, this), 3, null);
    }

    @Override // npi.spay.Z7
    public final void g() throws IllegalStateException {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        AppCompatTextView appCompatTextView = ((Q0) viewBinding).d;
        Resources resources = getResources();
        Bundle arguments = getArguments();
        appCompatTextView.setText(resources.getString(arguments != null ? arguments.getInt(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE) : R$string.spay_default_client_exception_message_error_title_text));
        ViewBinding viewBinding2 = this.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        AppCompatTextView appCompatTextView2 = ((Q0) viewBinding2).c;
        Resources resources2 = getResources();
        Bundle arguments2 = getArguments();
        appCompatTextView2.setText(resources2.getString(arguments2 != null ? arguments2.getInt("subTitle") : R$string.spay_default_client_exception_message_error_subtitle_text));
        Context context = requireContext();
        Intrinsics.checkNotNullExpressionValue(context, "requireContext()");
        Intrinsics.checkNotNullParameter(context, "context");
        MediaPlayer.create(context, R$raw.failure_payment_sound).start();
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_failure_payment, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
        int i = R$id.spay_slfp_actv_local_session_id;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_slfp_actv_subtitle;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
            if (appCompatTextView2 != null) {
                i = R$id.spay_slfp_actv_title;
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                if (appCompatTextView3 != null) {
                    i = R$id.spay_slfp_lottie_failure;
                    if (((LottieAnimationView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                        i = R$id.spay_slfp_mb_to_payment_methods;
                        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                        if (materialButton != null) {
                            Q0 q0 = new Q0(constraintLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, materialButton);
                            Intrinsics.checkNotNullExpressionValue(q0, "inflate(layoutInflater)");
                            return q0;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
