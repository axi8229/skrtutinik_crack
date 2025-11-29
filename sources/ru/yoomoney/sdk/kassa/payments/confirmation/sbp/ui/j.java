package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.confirmation.sbp.s;
import ru.yoomoney.sdk.kassa.payments.ui.compose.FragmentComposeViewKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/confirmation/sbp/ui/j;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class j extends Fragment {
    public static final /* synthetic */ int $r8$clinit = 0;
    public s a;
    public ru.yoomoney.sdk.kassa.payments.errorFormatter.b b;
    public ru.yoomoney.sdk.kassa.payments.navigation.c c;
    public final Lazy d = LazyKt.lazy(new f(this));

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(this, "fragment");
        ru.yoomoney.sdk.kassa.payments.di.component.b bVar = ru.yoomoney.sdk.kassa.payments.di.a.c;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationSubcomponent");
            bVar = null;
        }
        this.a = (s) bVar.b.get();
        this.b = (ru.yoomoney.sdk.kassa.payments.errorFormatter.b) bVar.a.k.get();
        this.c = (ru.yoomoney.sdk.kassa.payments.navigation.c) bVar.a.h.get();
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return FragmentComposeViewKt.fragmentComposeView(contextRequireContext, ComposableLambdaKt.composableLambdaInstance(134646357, true, new i(this)));
    }
}
