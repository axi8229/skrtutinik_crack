package sputnik.axmor.com.sputnik.ui.main.help;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentAboutCustomCompaniesBinding;

/* compiled from: AboutCompanyFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class AboutCompanyFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentAboutCustomCompaniesBinding> {
    public static final AboutCompanyFragment$binding$2 INSTANCE = new AboutCompanyFragment$binding$2();

    AboutCompanyFragment$binding$2() {
        super(1, FragmentAboutCustomCompaniesBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentAboutCustomCompaniesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentAboutCustomCompaniesBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentAboutCustomCompaniesBinding.bind(p0);
    }
}
