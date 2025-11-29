package sputnik.axmor.com.sputnik.ui.main.cameras;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.GlobalCameraFragmentBinding;

/* compiled from: GlobalCameraFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class GlobalCameraFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, GlobalCameraFragmentBinding> {
    public static final GlobalCameraFragment$binding$2 INSTANCE = new GlobalCameraFragment$binding$2();

    GlobalCameraFragment$binding$2() {
        super(1, GlobalCameraFragmentBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/GlobalCameraFragmentBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final GlobalCameraFragmentBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return GlobalCameraFragmentBinding.bind(p0);
    }
}
