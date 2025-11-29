package com.sputnik.oboarding.ui.registration.ways.userSms;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegSendUserSmsBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SendUserSmsFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class SendUserSmsFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegSendUserSmsBinding> {
    public static final SendUserSmsFragment$binding$2 INSTANCE = new SendUserSmsFragment$binding$2();

    SendUserSmsFragment$binding$2() {
        super(1, FragmentRegSendUserSmsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegSendUserSmsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegSendUserSmsBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegSendUserSmsBinding.bind(p0);
    }
}
