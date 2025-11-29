package sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentDigitalKeysActiveBinding;

/* compiled from: DigitalKeysServiceFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class DigitalKeysServiceFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentDigitalKeysActiveBinding> {
    public static final DigitalKeysServiceFragment$binding$2 INSTANCE = new DigitalKeysServiceFragment$binding$2();

    DigitalKeysServiceFragment$binding$2() {
        super(1, FragmentDigitalKeysActiveBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentDigitalKeysActiveBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentDigitalKeysActiveBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentDigitalKeysActiveBinding.bind(p0);
    }
}
