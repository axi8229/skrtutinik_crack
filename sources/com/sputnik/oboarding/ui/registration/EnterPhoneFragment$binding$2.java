package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegNumberBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterPhoneFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class EnterPhoneFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegNumberBinding> {
    public static final EnterPhoneFragment$binding$2 INSTANCE = new EnterPhoneFragment$binding$2();

    EnterPhoneFragment$binding$2() {
        super(1, FragmentRegNumberBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegNumberBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegNumberBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegNumberBinding.bind(p0);
    }
}
