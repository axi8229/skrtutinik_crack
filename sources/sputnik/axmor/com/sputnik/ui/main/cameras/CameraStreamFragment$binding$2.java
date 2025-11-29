package sputnik.axmor.com.sputnik.ui.main.cameras;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentCameraStreamPreviewBinding;

/* compiled from: CameraStreamFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class CameraStreamFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentCameraStreamPreviewBinding> {
    public static final CameraStreamFragment$binding$2 INSTANCE = new CameraStreamFragment$binding$2();

    CameraStreamFragment$binding$2() {
        super(1, FragmentCameraStreamPreviewBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentCameraStreamPreviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentCameraStreamPreviewBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentCameraStreamPreviewBinding.bind(p0);
    }
}
