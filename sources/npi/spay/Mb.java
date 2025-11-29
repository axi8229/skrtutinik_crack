package npi.spay;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ru.yoomoney.sdk.kassa.payments.R$id;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import spay.sdk.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnpi/spay/Mb;", "Lnpi/spay/Z7;", "Lnpi/spay/G8;", "Lnpi/spay/C2;", "<init>", "()V", "SPaySDK_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class Mb extends Z7<G8, C2> {
    @Override // npi.spay.Z7
    public final ViewBinding a() {
        View viewInflate = getLayoutInflater().inflate(R$layout.spay_layout_fake_bank, (ViewGroup) null, false);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) viewInflate;
        int i = R$id.spay_slfb_tv_fake_bank_description;
        if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
            i = R$id.spay_slfb_tv_fake_bank_title;
            if (((AppCompatTextView) ViewBindings.findChildViewById(viewInflate, i)) != null) {
                C2 c2 = new C2(linearLayoutCompat);
                Intrinsics.checkNotNullExpressionValue(c2, "inflate(layoutInflater)");
                return c2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // npi.spay.Z7
    /* renamed from: c */
    public final Class getE() {
        return G8.class;
    }

    @Override // npi.spay.Z7
    public final void e() {
        N9 n9 = b.a.b;
        if (n9 != null) {
            this.a = (Ql) ((Pj) n9).h0.get();
        }
    }

    @Override // npi.spay.Z7
    public final void f() {
        Flow flowFilterNotNull = FlowKt.filterNotNull(((G8) b()).f);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new Lb(this, Lifecycle.State.STARTED, flowFilterNotNull, null, this), 3, null);
    }
}
