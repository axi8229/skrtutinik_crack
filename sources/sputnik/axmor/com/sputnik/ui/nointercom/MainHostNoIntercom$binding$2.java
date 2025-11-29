package sputnik.axmor.com.sputnik.ui.nointercom;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.MainHostNoIntercomFragmentBinding;

/* compiled from: MainHostNoIntercom.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class MainHostNoIntercom$binding$2 extends FunctionReferenceImpl implements Function1<View, MainHostNoIntercomFragmentBinding> {
    public static final MainHostNoIntercom$binding$2 INSTANCE = new MainHostNoIntercom$binding$2();

    MainHostNoIntercom$binding$2() {
        super(1, MainHostNoIntercomFragmentBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/MainHostNoIntercomFragmentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final MainHostNoIntercomFragmentBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return MainHostNoIntercomFragmentBinding.bind(p0);
    }
}
