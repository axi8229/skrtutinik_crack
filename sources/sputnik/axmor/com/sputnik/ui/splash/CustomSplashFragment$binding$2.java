package sputnik.axmor.com.sputnik.ui.splash;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentSplashCustomScreenBinding;

/* compiled from: CustomSplashFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class CustomSplashFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentSplashCustomScreenBinding> {
    public static final CustomSplashFragment$binding$2 INSTANCE = new CustomSplashFragment$binding$2();

    CustomSplashFragment$binding$2() {
        super(1, FragmentSplashCustomScreenBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentSplashCustomScreenBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentSplashCustomScreenBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentSplashCustomScreenBinding.bind(p0);
    }
}
