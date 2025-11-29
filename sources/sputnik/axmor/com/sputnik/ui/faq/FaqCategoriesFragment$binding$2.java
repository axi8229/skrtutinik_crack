package sputnik.axmor.com.sputnik.ui.faq;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentFaqCategoriesBinding;

/* compiled from: FaqCategoriesFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class FaqCategoriesFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentFaqCategoriesBinding> {
    public static final FaqCategoriesFragment$binding$2 INSTANCE = new FaqCategoriesFragment$binding$2();

    FaqCategoriesFragment$binding$2() {
        super(1, FragmentFaqCategoriesBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentFaqCategoriesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentFaqCategoriesBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentFaqCategoriesBinding.bind(p0);
    }
}
