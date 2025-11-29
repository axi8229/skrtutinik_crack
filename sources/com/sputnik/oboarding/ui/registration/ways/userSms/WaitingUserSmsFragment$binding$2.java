package com.sputnik.oboarding.ui.registration.ways.userSms;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegWaitingUserSmsBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaitingUserSmsFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class WaitingUserSmsFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegWaitingUserSmsBinding> {
    public static final WaitingUserSmsFragment$binding$2 INSTANCE = new WaitingUserSmsFragment$binding$2();

    WaitingUserSmsFragment$binding$2() {
        super(1, FragmentRegWaitingUserSmsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegWaitingUserSmsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegWaitingUserSmsBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegWaitingUserSmsBinding.bind(p0);
    }
}
