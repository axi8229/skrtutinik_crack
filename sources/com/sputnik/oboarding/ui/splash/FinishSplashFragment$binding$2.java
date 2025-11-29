package com.sputnik.oboarding.ui.splash;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentFinishSplashBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FinishSplashFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class FinishSplashFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentFinishSplashBinding> {
    public static final FinishSplashFragment$binding$2 INSTANCE = new FinishSplashFragment$binding$2();

    FinishSplashFragment$binding$2() {
        super(1, FragmentFinishSplashBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentFinishSplashBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentFinishSplashBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentFinishSplashBinding.bind(p0);
    }
}
