package sputnik.axmor.com.sputnik.core.notifications;

import android.content.Context;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.sputnik.common.entities.notifications.PushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INotificationsManager.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lsputnik/axmor/com/sputnik/core/notifications/INotificationsManager;", "", "Lcom/sputnik/common/entities/notifications/PushMessage;", CrashHianalyticsData.MESSAGE, "", "notifyPush", "(Lcom/sputnik/common/entities/notifications/PushMessage;)V", "", "id", "cancel", "(I)V", "Companion", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface INotificationsManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void cancel(int id);

    void notifyPush(PushMessage message);

    /* compiled from: INotificationsManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/core/notifications/INotificationsManager$Companion;", "", "()V", "instance", "Lsputnik/axmor/com/sputnik/core/notifications/INotificationsManager;", "clearInstance", "", "getInstance", "context", "Landroid/content/Context;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static INotificationsManager instance;

        private Companion() {
        }

        public final INotificationsManager getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (instance == null) {
                instance = new NotificationManagerImpl(context);
            }
            INotificationsManager iNotificationsManager = instance;
            Intrinsics.checkNotNull(iNotificationsManager);
            return iNotificationsManager;
        }

        public final void clearInstance() {
            instance = null;
        }
    }
}
