package npi.spay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;
import spay.sdk.view.SpayDotsLoaderView;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/t3;", "Lnpi/spay/Z7;", "Lnpi/spay/o4;", "Lnpi/spay/V7;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* renamed from: npi.spay.t3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1930t3 extends Z7<C1807o4, V7> {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_loading, (ViewGroup) null, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
        int i = R$id.spay_sll_actv_local_session_id;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
        if (appCompatTextView != null) {
            i = R$id.spay_sll_gl_vertical_middle;
            if (((Guideline) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                i = R$id.spay_sll_group_spinner;
                Group group = (Group) ViewBindings.findChildViewById(viewInflate, i);
                if (group != null) {
                    i = R$id.spay_sll_lottie_spay_logo;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(viewInflate, i);
                    if (lottieAnimationView != null) {
                        i = R$id.spay_sll_sdlv_progress;
                        if (((SpayDotsLoaderView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                            i = R$id.spay_sll_tv_loading_text;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i);
                            if (appCompatTextView2 != null) {
                                V7 v7 = new V7(constraintLayout, appCompatTextView, group, lottieAnimationView, appCompatTextView2);
                                Intrinsics.checkNotNullExpressionValue(v7, "inflate(layoutInflater)");
                                return v7;
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
        return C1807o4.class;
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).e0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Flow flowFilterNotNull = FlowKt.filterNotNull(((C1807o4) b()).l);
        Lifecycle.State state = Lifecycle.State.STARTED;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1831p3(this, state, flowFilterNotNull, null, this, contextRequireContext), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C1905s3(this, state, ((C1807o4) b()).j, null, this), 3, null);
    }
}
