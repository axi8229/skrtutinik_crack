package npi.spay;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/D;", "Lnpi/spay/Z7;", "Lnpi/spay/A1;", "Lnpi/spay/u8;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class D extends Z7<A1, C1960u8> {
    public static final void a(D this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        A1 a1 = (A1) this$0.b();
        C1857q4 event = C1857q4.a;
        a1.getClass();
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, event)) {
            ((Jh) a1.c).a(C1975un.a);
        }
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return A1.class;
    }

    @Override // npi.spay.Z7
    public final void d() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        ((C1960u8) viewBinding).c.setOnClickListener(new View.OnClickListener() { // from class: npi.spay.D$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                D.a(this.f$0, view);
            }
        });
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).g0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        ViewBinding viewBinding = this.c;
        if (viewBinding == null) {
            throw C2040xd.a;
        }
        C1960u8 c1960u8 = (C1960u8) viewBinding;
        StateFlow stateFlow = ((A1) b()).d;
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C(this, state, stateFlow, null, this), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C2076z(this, state, FlowKt.filterNotNull(((A1) b()).f), null, c1960u8), 3, null);
    }

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_no_card, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
        int i = R$id.spay_lnc_aciv_image;
        if (((AppCompatImageView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
            i = R$id.spay_lnc_actv_content;
            if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                i = R$id.spay_lnc_actv_header;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                if (appCompatTextView != null) {
                    i = R$id.spay_lnc_mb_cancel;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(viewInflate, i);
                    if (materialButton != null) {
                        C1960u8 c1960u8 = new C1960u8(appCompatTextView, constraintLayout, materialButton);
                        Intrinsics.checkNotNullExpressionValue(c1960u8, "inflate(layoutInflater)");
                        return c1960u8;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
