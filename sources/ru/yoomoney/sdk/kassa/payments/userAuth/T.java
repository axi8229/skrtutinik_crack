package ru.yoomoney.sdk.kassa.payments.userAuth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.YooMoneyAuth;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.kassa.payments.R$layout;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.march.CodeKt;
import ru.yoomoney.sdk.march.RuntimeViewModel;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/userAuth/T;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class T extends Fragment {
    public static final /* synthetic */ int $r8$clinit = 0;
    public ViewModelProvider.Factory a;
    public ru.yoomoney.sdk.kassa.payments.metrics.F b;
    public PaymentParameters c;
    public TestParameters d;
    public ru.yoomoney.sdk.kassa.payments.http.a e;
    public final Lazy f = LazyKt.lazy(new S(this));
    public final Lazy g = LazyKt.lazy(new P(this, new Q(this)));

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if ((intent != null ? intent.getStringExtra(YooMoneyAuth.KEY_ACCESS_TOKEN) : null) == null) {
                FragmentKt.setFragmentResult(this, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.MONEY_AUTH_RESULT_KEY", BundleKt.bundleOf(TuplesKt.to("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.MONEY_AUTH_RESULT_EXTRA", ru.yoomoney.sdk.kassa.payments.navigation.f.b)));
                return;
            } else {
                ((RuntimeViewModel) this.g.getValue()).handleAction(new C2543f(intent.getStringExtra(YooMoneyAuth.KEY_ACCESS_TOKEN), (UserAccount) intent.getParcelableExtra(YooMoneyAuth.KEY_USER_ACCOUNT), intent.getStringExtra(YooMoneyAuth.KEY_TMX_SESSION_ID), new ru.yoomoney.sdk.kassa.payments.metrics.A()));
                return;
            }
        }
        if (i != 317) {
            return;
        }
        String stringExtra = intent != null ? intent.getStringExtra(YooMoneyAuth.KEY_CRYPTOGRAM) : null;
        if (stringExtra == null) {
            FragmentKt.setFragmentResult(this, "ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.MONEY_AUTH_RESULT_KEY", BundleKt.bundleOf(TuplesKt.to("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.MONEY_AUTH_RESULT_EXTRA", ru.yoomoney.sdk.kassa.payments.navigation.f.b)));
        } else {
            ((RuntimeViewModel) this.g.getValue()).handleAction(new C2544g(stringExtra));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(this, "fragment");
        ru.yoomoney.sdk.kassa.payments.di.component.a aVar = ru.yoomoney.sdk.kassa.payments.di.a.b;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkoutComponent");
            aVar = null;
        }
        this.a = aVar.a();
        this.b = (ru.yoomoney.sdk.kassa.payments.metrics.F) aVar.d.m.get();
        this.c = aVar.c;
        ru.yoomoney.sdk.kassa.payments.di.component.c cVar = aVar.d;
        this.d = cVar.b;
        this.e = (ru.yoomoney.sdk.kassa.payments.http.a) cVar.z.get();
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R$layout.ym_fragment_money_auth, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        RuntimeViewModel runtimeViewModel = (RuntimeViewModel) this.g.getValue();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        CodeKt.observe(runtimeViewModel, viewLifecycleOwner, new M(this), N.a, O.a);
    }
}
