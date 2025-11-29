package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentFrCameraBinding;

/* compiled from: ShotFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ShotFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentFrCameraBinding> {
    public static final ShotFragment$binding$2 INSTANCE = new ShotFragment$binding$2();

    ShotFragment$binding$2() {
        super(1, FragmentFrCameraBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentFrCameraBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentFrCameraBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentFrCameraBinding.bind(p0);
    }
}
