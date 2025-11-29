package sputnik.axmor.com.sputnik.ui.main.permissions;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentPermissionsBinding;

/* compiled from: PermissionsFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class PermissionsFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentPermissionsBinding> {
    public static final PermissionsFragment$binding$2 INSTANCE = new PermissionsFragment$binding$2();

    PermissionsFragment$binding$2() {
        super(1, FragmentPermissionsBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentPermissionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentPermissionsBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentPermissionsBinding.bind(p0);
    }
}
