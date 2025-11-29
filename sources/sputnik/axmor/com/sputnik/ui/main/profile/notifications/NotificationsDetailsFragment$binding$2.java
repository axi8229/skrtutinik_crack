package sputnik.axmor.com.sputnik.ui.main.profile.notifications;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.databinding.FragmentNotificationDetailsBinding;

/* compiled from: NotificationsDetailsFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class NotificationsDetailsFragment$binding$2 extends FunctionReferenceImpl implements Function1<View, FragmentNotificationDetailsBinding> {
    public static final NotificationsDetailsFragment$binding$2 INSTANCE = new NotificationsDetailsFragment$binding$2();

    NotificationsDetailsFragment$binding$2() {
        super(1, FragmentNotificationDetailsBinding.class, "bind", "bind(Landroid/view/View;)Lsputnik/axmor/com/databinding/FragmentNotificationDetailsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FragmentNotificationDetailsBinding invoke(View p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return FragmentNotificationDetailsBinding.bind(p0);
    }
}
