package sputnik.axmor.com.sputnik.ui.main.profile;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentSettingsProfileBinding;

/* compiled from: ProfileFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ProfileFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentSettingsProfileBinding> {
    public static final ProfileFragment$binding$2 INSTANCE = new ProfileFragment$binding$2();

    ProfileFragment$binding$2() {
        super(1, FragmentSettingsProfileBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentSettingsProfileBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentSettingsProfileBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentSettingsProfileBinding.bind(p0);
    }
}
