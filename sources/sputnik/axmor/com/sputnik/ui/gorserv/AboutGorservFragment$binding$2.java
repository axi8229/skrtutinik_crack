package sputnik.axmor.com.sputnik.ui.gorserv;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentAboutGorservBinding;

/* compiled from: AboutGorservFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class AboutGorservFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentAboutGorservBinding> {
    public static final AboutGorservFragment$binding$2 INSTANCE = new AboutGorservFragment$binding$2();

    AboutGorservFragment$binding$2() {
        super(1, FragmentAboutGorservBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentAboutGorservBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentAboutGorservBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentAboutGorservBinding.bind(p0);
    }
}
