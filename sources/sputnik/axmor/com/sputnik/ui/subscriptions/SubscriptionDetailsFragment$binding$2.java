package sputnik.axmor.com.sputnik.ui.subscriptions;

import android.view.View;
import com.sputnik.subscriptions.databinding.FragmentSubscriptionDetailsBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubscriptionDetailsFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class SubscriptionDetailsFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentSubscriptionDetailsBinding> {
    public static final SubscriptionDetailsFragment$binding$2 INSTANCE = new SubscriptionDetailsFragment$binding$2();

    SubscriptionDetailsFragment$binding$2() {
        super(1, FragmentSubscriptionDetailsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/subscriptions/databinding/FragmentSubscriptionDetailsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentSubscriptionDetailsBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentSubscriptionDetailsBinding.bind(p0);
    }
}
