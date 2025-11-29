package sputnik.axmor.com.sputnik.ui.main.market;

import android.view.View;
import com.sputnik.subscriptions.databinding.FragmentNewMarketBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewMarketFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class NewMarketFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentNewMarketBinding> {
    public static final NewMarketFragment$binding$2 INSTANCE = new NewMarketFragment$binding$2();

    NewMarketFragment$binding$2() {
        super(1, FragmentNewMarketBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/subscriptions/databinding/FragmentNewMarketBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentNewMarketBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentNewMarketBinding.bind(p0);
    }
}
