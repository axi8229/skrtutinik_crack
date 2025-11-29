package sputnik.axmor.com.sputnik.ui.gorserv;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentGorservFeatureBinding;

/* compiled from: GorservFeatureFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class GorservFeatureFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentGorservFeatureBinding> {
    public static final GorservFeatureFragment$binding$2 INSTANCE = new GorservFeatureFragment$binding$2();

    GorservFeatureFragment$binding$2() {
        super(1, FragmentGorservFeatureBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentGorservFeatureBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentGorservFeatureBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentGorservFeatureBinding.bind(p0);
    }
}
