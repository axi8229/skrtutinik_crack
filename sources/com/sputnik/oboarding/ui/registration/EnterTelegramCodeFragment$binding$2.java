package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegEnterTelegramCodeBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterTelegramCodeFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class EnterTelegramCodeFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegEnterTelegramCodeBinding> {
    public static final EnterTelegramCodeFragment$binding$2 INSTANCE = new EnterTelegramCodeFragment$binding$2();

    EnterTelegramCodeFragment$binding$2() {
        super(1, FragmentRegEnterTelegramCodeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegEnterTelegramCodeBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegEnterTelegramCodeBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegEnterTelegramCodeBinding.bind(p0);
    }
}
