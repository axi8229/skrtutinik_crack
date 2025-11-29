package com.sputnik.oboarding.ui.registration;

import android.view.View;
import com.sputnik.oboarding.databinding.FragmentRegNotMyAddressBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotMyAddressFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class NotMyAddressFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentRegNotMyAddressBinding> {
    public static final NotMyAddressFragment$binding$2 INSTANCE = new NotMyAddressFragment$binding$2();

    NotMyAddressFragment$binding$2() {
        super(1, FragmentRegNotMyAddressBinding.class, "bind", "bind(Landroid/view/View;)Lcom/sputnik/oboarding/databinding/FragmentRegNotMyAddressBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentRegNotMyAddressBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentRegNotMyAddressBinding.bind(p0);
    }
}
