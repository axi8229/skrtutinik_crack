package sputnik.axmor.com.sputnik.ui.main.profile.family;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentSettingsFamilyBinding;

/* compiled from: FamilyListFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class FamilyListFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentSettingsFamilyBinding> {
    public static final FamilyListFragment$binding$2 INSTANCE = new FamilyListFragment$binding$2();

    FamilyListFragment$binding$2() {
        super(1, FragmentSettingsFamilyBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentSettingsFamilyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentSettingsFamilyBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentSettingsFamilyBinding.bind(p0);
    }
}
