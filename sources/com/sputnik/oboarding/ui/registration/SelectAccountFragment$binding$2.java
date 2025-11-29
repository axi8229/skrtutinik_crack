package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentSelectAccountBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectAccountFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class SelectAccountFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentSelectAccountBinding> {
    public static final SelectAccountFragment$binding$2 INSTANCE = new SelectAccountFragment$binding$2();

    SelectAccountFragment$binding$2() {
        super(1, FragmentSelectAccountBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentSelectAccountBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentSelectAccountBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentSelectAccountBinding.bind(p0);
    }
}
