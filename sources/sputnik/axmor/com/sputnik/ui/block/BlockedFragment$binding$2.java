package sputnik.axmor.com.sputnik.ui.block;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.BlockedFragmentBinding;

/* compiled from: BlockedFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class BlockedFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, BlockedFragmentBinding> {
    public static final BlockedFragment$binding$2 INSTANCE = new BlockedFragment$binding$2();

    BlockedFragment$binding$2() {
        super(1, BlockedFragmentBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/BlockedFragmentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BlockedFragmentBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return BlockedFragmentBinding.bind(p0);
    }
}
