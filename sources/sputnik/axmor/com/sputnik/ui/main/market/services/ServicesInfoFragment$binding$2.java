package sputnik.axmor.com.sputnik.ui.main.market.services;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.SettingsSubscriptionFragmentBinding;

/* compiled from: ServicesInfoFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ServicesInfoFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, SettingsSubscriptionFragmentBinding> {
    public static final ServicesInfoFragment$binding$2 INSTANCE = new ServicesInfoFragment$binding$2();

    ServicesInfoFragment$binding$2() {
        super(1, SettingsSubscriptionFragmentBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/SettingsSubscriptionFragmentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SettingsSubscriptionFragmentBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return SettingsSubscriptionFragmentBinding.bind(p0);
    }
}
