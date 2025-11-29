package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentLimitExceededBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LimitExceededFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class LimitExceededFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentLimitExceededBinding> {
    public static final LimitExceededFragment$binding$2 INSTANCE = new LimitExceededFragment$binding$2();

    LimitExceededFragment$binding$2() {
        super(1, FragmentLimitExceededBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentLimitExceededBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentLimitExceededBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentLimitExceededBinding.bind(p0);
    }
}
