package sputnik.axmor.com.sputnik.ui.popups;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentPopupStoryBinding;

/* compiled from: PopupStoryFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class PopupStoryFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentPopupStoryBinding> {
    public static final PopupStoryFragment$binding$2 INSTANCE = new PopupStoryFragment$binding$2();

    PopupStoryFragment$binding$2() {
        super(1, FragmentPopupStoryBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentPopupStoryBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentPopupStoryBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentPopupStoryBinding.bind(p0);
    }
}
