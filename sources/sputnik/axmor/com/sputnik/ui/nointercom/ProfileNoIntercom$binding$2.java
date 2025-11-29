package sputnik.axmor.com.sputnik.ui.nointercom;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentProfileNoIntercomBinding;

/* compiled from: ProfileNoIntercom.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class ProfileNoIntercom$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentProfileNoIntercomBinding> {
    public static final ProfileNoIntercom$binding$2 INSTANCE = new ProfileNoIntercom$binding$2();

    ProfileNoIntercom$binding$2() {
        super(1, FragmentProfileNoIntercomBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentProfileNoIntercomBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentProfileNoIntercomBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentProfileNoIntercomBinding.bind(p0);
    }
}
