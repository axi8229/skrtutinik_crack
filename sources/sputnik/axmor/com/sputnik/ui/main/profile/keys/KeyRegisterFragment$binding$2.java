package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentKeyRegisterBinding;

/* compiled from: KeyRegisterFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class KeyRegisterFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentKeyRegisterBinding> {
    public static final KeyRegisterFragment$binding$2 INSTANCE = new KeyRegisterFragment$binding$2();

    KeyRegisterFragment$binding$2() {
        super(1, FragmentKeyRegisterBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentKeyRegisterBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentKeyRegisterBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentKeyRegisterBinding.bind(p0);
    }
}
