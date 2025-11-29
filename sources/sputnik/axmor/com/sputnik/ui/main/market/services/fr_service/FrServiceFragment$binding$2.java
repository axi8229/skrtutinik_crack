package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentServicesFrBinding;

/* compiled from: FrServiceFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class FrServiceFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentServicesFrBinding> {
    public static final FrServiceFragment$binding$2 INSTANCE = new FrServiceFragment$binding$2();

    FrServiceFragment$binding$2() {
        super(1, FragmentServicesFrBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentServicesFrBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentServicesFrBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentServicesFrBinding.bind(p0);
    }
}
