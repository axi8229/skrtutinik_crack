package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegSmtWrongBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SomethingWentWrongFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class SomethingWentWrongFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegSmtWrongBinding> {
    public static final SomethingWentWrongFragment$binding$2 INSTANCE = new SomethingWentWrongFragment$binding$2();

    SomethingWentWrongFragment$binding$2() {
        super(1, FragmentRegSmtWrongBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegSmtWrongBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegSmtWrongBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegSmtWrongBinding.bind(p0);
    }
}
