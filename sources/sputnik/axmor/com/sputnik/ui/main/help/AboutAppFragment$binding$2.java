package sputnik.axmor.com.sputnik.ui.main.help;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentAboutBinding;

/* compiled from: AboutAppFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class AboutAppFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentAboutBinding> {
    public static final AboutAppFragment$binding$2 INSTANCE = new AboutAppFragment$binding$2();

    AboutAppFragment$binding$2() {
        super(1, FragmentAboutBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentAboutBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentAboutBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentAboutBinding.bind(p0);
    }
}
