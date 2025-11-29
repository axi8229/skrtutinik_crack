package sputnik.axmor.com.sputnik.ui.main.profile.manage_cameras;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentSettingsCamerasBinding;

/* compiled from: ManageCamerasDetails.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ManageCamerasDetails$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentSettingsCamerasBinding> {
    public static final ManageCamerasDetails$binding$2 INSTANCE = new ManageCamerasDetails$binding$2();

    ManageCamerasDetails$binding$2() {
        super(1, FragmentSettingsCamerasBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentSettingsCamerasBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentSettingsCamerasBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentSettingsCamerasBinding.bind(p0);
    }
}
