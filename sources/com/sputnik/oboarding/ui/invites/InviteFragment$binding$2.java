package com.sputnik.oboarding.ui.invites;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentInviteBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InviteFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class InviteFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentInviteBinding> {
    public static final InviteFragment$binding$2 INSTANCE = new InviteFragment$binding$2();

    InviteFragment$binding$2() {
        super(1, FragmentInviteBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentInviteBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentInviteBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentInviteBinding.bind(p0);
    }
}
