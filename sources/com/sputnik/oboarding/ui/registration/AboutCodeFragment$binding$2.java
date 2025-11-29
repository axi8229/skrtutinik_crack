package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegAboutCodeBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AboutCodeFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class AboutCodeFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegAboutCodeBinding> {
    public static final AboutCodeFragment$binding$2 INSTANCE = new AboutCodeFragment$binding$2();

    AboutCodeFragment$binding$2() {
        super(1, FragmentRegAboutCodeBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegAboutCodeBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegAboutCodeBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegAboutCodeBinding.bind(p0);
    }
}
