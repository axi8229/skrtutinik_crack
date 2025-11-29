package sputnik.axmor.com.sputnik.ui.main.market.subscription;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.SubscriptionActivityBinding;

/* compiled from: SubscriptionFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class SubscriptionFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, SubscriptionActivityBinding> {
    public static final SubscriptionFragment$binding$2 INSTANCE = new SubscriptionFragment$binding$2();

    SubscriptionFragment$binding$2() {
        super(1, SubscriptionActivityBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/SubscriptionActivityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SubscriptionActivityBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return SubscriptionActivityBinding.bind(p0);
    }
}
