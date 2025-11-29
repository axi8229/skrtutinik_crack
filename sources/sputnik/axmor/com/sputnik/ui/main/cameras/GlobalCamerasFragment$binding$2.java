package sputnik.axmor.com.sputnik.ui.main.cameras;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.GlobalCamerasFragmentBinding;

/* compiled from: GlobalCamerasFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class GlobalCamerasFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, GlobalCamerasFragmentBinding> {
    public static final GlobalCamerasFragment$binding$2 INSTANCE = new GlobalCamerasFragment$binding$2();

    GlobalCamerasFragment$binding$2() {
        super(1, GlobalCamerasFragmentBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/GlobalCamerasFragmentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final GlobalCamerasFragmentBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return GlobalCamerasFragmentBinding.bind(p0);
    }
}
