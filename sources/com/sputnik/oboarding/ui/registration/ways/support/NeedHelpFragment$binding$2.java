package com.sputnik.oboarding.ui.registration.ways.support;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentNeedHelpBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NeedHelpFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class NeedHelpFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentNeedHelpBinding> {
    public static final NeedHelpFragment$binding$2 INSTANCE = new NeedHelpFragment$binding$2();

    NeedHelpFragment$binding$2() {
        super(1, FragmentNeedHelpBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentNeedHelpBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentNeedHelpBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentNeedHelpBinding.bind(p0);
    }
}
