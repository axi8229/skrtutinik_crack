package sputnik.axmor.com.sputnik.ui.gorserv;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentSelectGorservCategoryBinding;

/* compiled from: SelectGorservCategoryFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class SelectGorservCategoryFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentSelectGorservCategoryBinding> {
    public static final SelectGorservCategoryFragment$binding$2 INSTANCE = new SelectGorservCategoryFragment$binding$2();

    SelectGorservCategoryFragment$binding$2() {
        super(1, FragmentSelectGorservCategoryBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentSelectGorservCategoryBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentSelectGorservCategoryBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentSelectGorservCategoryBinding.bind(p0);
    }
}
