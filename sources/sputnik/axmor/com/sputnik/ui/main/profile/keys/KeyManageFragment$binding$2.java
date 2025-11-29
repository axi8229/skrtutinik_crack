package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentKeyManageBinding;

/* compiled from: KeyManageFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class KeyManageFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentKeyManageBinding> {
    public static final KeyManageFragment$binding$2 INSTANCE = new KeyManageFragment$binding$2();

    KeyManageFragment$binding$2() {
        super(1, FragmentKeyManageBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentKeyManageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentKeyManageBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentKeyManageBinding.bind(p0);
    }
}
