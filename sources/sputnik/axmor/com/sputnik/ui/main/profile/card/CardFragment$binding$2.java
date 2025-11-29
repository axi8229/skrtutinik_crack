package sputnik.axmor.com.sputnik.ui.main.profile.card;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentCardBinding;

/* compiled from: CardFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class CardFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentCardBinding> {
    public static final CardFragment$binding$2 INSTANCE = new CardFragment$binding$2();

    CardFragment$binding$2() {
        super(1, FragmentCardBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentCardBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentCardBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentCardBinding.bind(p0);
    }
}
