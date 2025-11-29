package sputnik.axmor.com.sputnik.ui.main.market.items;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentMarketItemDetailsBinding;

/* compiled from: ItemDetailsFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ItemDetailsFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentMarketItemDetailsBinding> {
    public static final ItemDetailsFragment$binding$2 INSTANCE = new ItemDetailsFragment$binding$2();

    ItemDetailsFragment$binding$2() {
        super(1, FragmentMarketItemDetailsBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentMarketItemDetailsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentMarketItemDetailsBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentMarketItemDetailsBinding.bind(p0);
    }
}
