package sputnik.axmor.com.sputnik.ui.main.profile.card;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentEmptyCardBinding;

/* compiled from: NewCardFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class NewCardFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentEmptyCardBinding> {
    public static final NewCardFragment$binding$2 INSTANCE = new NewCardFragment$binding$2();

    NewCardFragment$binding$2() {
        super(1, FragmentEmptyCardBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentEmptyCardBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentEmptyCardBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentEmptyCardBinding.bind(p0);
    }
}
