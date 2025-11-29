package sputnik.axmor.com.sputnik.ui.popups;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentPopupStoriesBinding;

/* compiled from: PopupStoriesFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class PopupStoriesFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentPopupStoriesBinding> {
    public static final PopupStoriesFragment$binding$2 INSTANCE = new PopupStoriesFragment$binding$2();

    PopupStoriesFragment$binding$2() {
        super(1, FragmentPopupStoriesBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentPopupStoriesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentPopupStoriesBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentPopupStoriesBinding.bind(p0);
    }
}
