package com.sputnik.oboarding.ui.localization;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentStartSplashLanguageBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadingLanguageSplashFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class LoadingLanguageSplashFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentStartSplashLanguageBinding> {
    public static final LoadingLanguageSplashFragment$binding$2 INSTANCE = new LoadingLanguageSplashFragment$binding$2();

    LoadingLanguageSplashFragment$binding$2() {
        super(1, FragmentStartSplashLanguageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentStartSplashLanguageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentStartSplashLanguageBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentStartSplashLanguageBinding.bind(p0);
    }
}
