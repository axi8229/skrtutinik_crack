package sputnik.axmor.com.sputnik.ui.main.cameras;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentNoneCamerasBinding;

/* compiled from: NoCamerasFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class NoCamerasFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentNoneCamerasBinding> {
    public static final NoCamerasFragment$binding$2 INSTANCE = new NoCamerasFragment$binding$2();

    NoCamerasFragment$binding$2() {
        super(1, FragmentNoneCamerasBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentNoneCamerasBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentNoneCamerasBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentNoneCamerasBinding.bind(p0);
    }
}
