package npi.spay;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.R$raw;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/m8;", "Lnpi/spay/Z7;", "Lnpi/spay/f6;", "Lnpi/spay/s9;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.m8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1761m8 extends Z7<C1585f6, C1911s9> {
    public static final void a(C1761m8 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C1585f6 c1585f6 = (C1585f6) this$0.b();
        H7 event = H7.a;
        c1585f6.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, G7.a)) {
            ((Jh) c1585f6.d).a(C1975un.a);
        } else if (Intrinsics.areEqual(event, event)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(c1585f6), null, null, new C1559e5(c1585f6, null), 3, null);
        }
    }

    public static final void b(C1761m8 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        C1585f6 c1585f6 = (C1585f6) this$0.b();
        G7 event = G7.a;
        c1585f6.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, event)) {
            ((Jh) c1585f6.d).a(C1975un.a);
        } else if (Intrinsics.areEqual(event, H7.a)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(c1585f6), null, null, new C1559e5(c1585f6, null), 3, null);
        }
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return C1585f6.class;
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).f0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void g() throws IllegalStateException {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((C1911s9) viewBinding).c.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.m8$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1761m8.a(this.f$0, view);
            }
        });
        ViewBinding viewBinding2 = this.c;
        if (viewBinding2 == null) {
            throw C2040xd.a;
        }
        ((C1911s9) viewBinding2).b.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.m8$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1761m8.b(this.f$0, view);
            }
        });
        Context context = requireContext();
        Intrinsics.checkNotNullExpressionValue(context, "requireContext()");
        Intrinsics.checkNotNullParameter(context, "context");
        MediaPlayer.create(context, R$raw.failure_payment_sound).start();
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_no_internet, (ViewGroup) null, false);
        int i = R$id.spay_slni_actv_subtitle;
        if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
            i = R$id.spay_slni_actv_title;
            if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                i = R$id.spay_slni_lottie_failure;
                if (((LottieAnimationView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                    i = R$id.spay_slni_mb_to_payment_methods_button;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                    if (materialButton != null) {
                        i = R$id.spay_slni_mb_try_again_button;
                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                        if (materialButton2 != null) {
                            C1911s9 c1911s9 = new C1911s9((ConstraintLayout) viewInflate, materialButton, materialButton2);
                            Intrinsics.checkNotNullExpressionValue(c1911s9, "inflate(layoutInflater)");
                            return c1911s9;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
