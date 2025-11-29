package sputnik.axmor.com.sputnik.ui.main;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.MainHostFragmentBinding;

/* compiled from: MainHostFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class MainHostFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, MainHostFragmentBinding> {
    public static final MainHostFragment$binding$2 INSTANCE = new MainHostFragment$binding$2();

    MainHostFragment$binding$2() {
        super(1, MainHostFragmentBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/MainHostFragmentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final MainHostFragmentBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return MainHostFragmentBinding.bind(p0);
    }
}
