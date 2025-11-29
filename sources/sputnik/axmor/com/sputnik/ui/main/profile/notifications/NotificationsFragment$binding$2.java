package sputnik.axmor.com.sputnik.ui.main.profile.notifications;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentNotificationsBinding;

/* compiled from: NotificationsFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class NotificationsFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentNotificationsBinding> {
    public static final NotificationsFragment$binding$2 INSTANCE = new NotificationsFragment$binding$2();

    NotificationsFragment$binding$2() {
        super(1, FragmentNotificationsBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentNotificationsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentNotificationsBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentNotificationsBinding.bind(p0);
    }
}
