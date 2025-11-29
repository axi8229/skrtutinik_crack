package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegCheckAddressBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfirmAddressFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ConfirmAddressFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegCheckAddressBinding> {
    public static final ConfirmAddressFragment$binding$2 INSTANCE = new ConfirmAddressFragment$binding$2();

    ConfirmAddressFragment$binding$2() {
        super(1, FragmentRegCheckAddressBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegCheckAddressBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegCheckAddressBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegCheckAddressBinding.bind(p0);
    }
}
