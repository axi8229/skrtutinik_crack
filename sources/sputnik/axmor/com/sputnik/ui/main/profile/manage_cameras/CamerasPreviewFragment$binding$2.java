package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentCamerasPreviewBinding;

/* compiled from: CamerasPreviewFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class CamerasPreviewFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentCamerasPreviewBinding> {
    public static final CamerasPreviewFragment$binding$2 INSTANCE = new CamerasPreviewFragment$binding$2();

    CamerasPreviewFragment$binding$2() {
        super(1, FragmentCamerasPreviewBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentCamerasPreviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentCamerasPreviewBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentCamerasPreviewBinding.bind(p0);
    }
}
