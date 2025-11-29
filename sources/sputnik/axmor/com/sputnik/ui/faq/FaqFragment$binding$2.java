package sputnik.axmor.com.sputnik.ui.faq;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentFaqBinding;

/* compiled from: FaqFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class FaqFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentFaqBinding> {
    public static final FaqFragment$binding$2 INSTANCE = new FaqFragment$binding$2();

    FaqFragment$binding$2() {
        super(1, FragmentFaqBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentFaqBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentFaqBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentFaqBinding.bind(p0);
    }
}
