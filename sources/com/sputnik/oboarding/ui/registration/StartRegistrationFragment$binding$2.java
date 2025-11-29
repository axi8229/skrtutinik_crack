package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentStartRegistrationBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StartRegistrationFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class StartRegistrationFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentStartRegistrationBinding> {
    public static final StartRegistrationFragment$binding$2 INSTANCE = new StartRegistrationFragment$binding$2();

    StartRegistrationFragment$binding$2() {
        super(1, FragmentStartRegistrationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentStartRegistrationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentStartRegistrationBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentStartRegistrationBinding.bind(p0);
    }
}
