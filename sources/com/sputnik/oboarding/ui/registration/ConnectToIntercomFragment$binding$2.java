package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegConnectIntercomBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectToIntercomFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class ConnectToIntercomFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegConnectIntercomBinding> {
    public static final ConnectToIntercomFragment$binding$2 INSTANCE = new ConnectToIntercomFragment$binding$2();

    ConnectToIntercomFragment$binding$2() {
        super(1, FragmentRegConnectIntercomBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegConnectIntercomBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegConnectIntercomBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegConnectIntercomBinding.bind(p0);
    }
}
