package sputnik.axmor.com.sputnik.ui.main.profile.localization;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentSplashLanguageBinding;

/* compiled from: LocalizationSplash.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class LocalizationSplash$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentSplashLanguageBinding> {
    public static final LocalizationSplash$binding$2 INSTANCE = new LocalizationSplash$binding$2();

    LocalizationSplash$binding$2() {
        super(1, FragmentSplashLanguageBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentSplashLanguageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentSplashLanguageBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentSplashLanguageBinding.bind(p0);
    }
}
