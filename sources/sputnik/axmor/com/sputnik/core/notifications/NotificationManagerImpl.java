package sputnik.axmor.com.sputnik.core.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.axmor.ash.toolset.service.impl.CompositeService$$ExternalSyntheticApiModelOutline3;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.l$$ExternalSyntheticApiModelOutline1;
import com.sputnik.common.entities.notifications.PushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity;

/* compiled from: NotificationManagerImpl.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0003J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lsputnik/axmor/com/sputnik/core/notifications/NotificationManagerImpl;", "Lsputnik/axmor/com/sputnik/core/notifications/INotificationsManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cancel", "", "id", "", "createNotificationChannel", "info", "Lsputnik/axmor/com/sputnik/core/notifications/NotificationManagerImpl$ChannelInfo;", "notifyPush", CrashHianalyticsData.MESSAGE, "Lcom/sputnik/common/entities/notifications/PushMessage;", "ChannelInfo", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationManagerImpl implements INotificationsManager {
    private final Context context;

    /* compiled from: NotificationManagerImpl.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PushMessage.Types.values().length];
            try {
                iArr[PushMessage.Types.promo.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PushMessage.Types.unknown.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NotificationManagerImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* compiled from: NotificationManagerImpl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\f¨\u0006\u0016"}, d2 = {"Lsputnik/axmor/com/sputnik/core/notifications/NotificationManagerImpl$ChannelInfo;", "", "", "id", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "importance", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getName", "I", "getImportance", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ChannelInfo {
        private final String id;
        private final int importance;
        private final String name;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelInfo)) {
                return false;
            }
            ChannelInfo channelInfo = (ChannelInfo) other;
            return Intrinsics.areEqual(this.id, channelInfo.id) && Intrinsics.areEqual(this.name, channelInfo.name) && this.importance == channelInfo.importance;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.importance);
        }

        public String toString() {
            return "ChannelInfo(id=" + this.id + ", name=" + this.name + ", importance=" + this.importance + ")";
        }

        public ChannelInfo(String id, String name, int i) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            this.id = id;
            this.name = name;
            this.importance = i;
        }

        public /* synthetic */ ChannelInfo(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i2 & 4) != 0 ? 3 : i);
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final int getImportance() {
            return this.importance;
        }
    }

    @Override // sputnik.axmor.com.sputnik.core.notifications.INotificationsManager
    public void notifyPush(PushMessage message) {
        ChannelInfo channelInfo;
        String str;
        Intrinsics.checkNotNullParameter(message, "message");
        int i = WhenMappings.$EnumSwitchMapping$0[message.getType().ordinal()];
        if (i == 1) {
            SputnikApp.Companion companion = SputnikApp.INSTANCE;
            channelInfo = new ChannelInfo(companion.applicationContext().getString(R.string.app_name) + "CallId", companion.applicationContext().getString(R.string.app_name) + " Smart Home", 0, 4, null);
        } else if (i == 2) {
            SputnikApp.Companion companion2 = SputnikApp.INSTANCE;
            channelInfo = new ChannelInfo(companion2.applicationContext().getString(R.string.app_name) + "CallId", companion2.applicationContext().getString(R.string.app_name) + " Smart Home", 0, 4, null);
        } else {
            SputnikApp.Companion companion3 = SputnikApp.INSTANCE;
            channelInfo = new ChannelInfo(companion3.applicationContext().getString(R.string.app_name) + "CallId", companion3.applicationContext().getString(R.string.app_name) + " Smart Home", 0, 4, null);
        }
        Intent intent = new Intent(this.context, (Class<?>) SputnikRootActivity.class);
        intent.addFlags(536870912);
        String string = PushMessage.Arguments.deeplink.toString();
        String deeplink = message.getDeeplink();
        if (message.getDataId() != null) {
            str = "/" + message.getDataId();
        } else {
            str = "";
        }
        intent.putExtra(string, deeplink + str);
        intent.putExtra(PushMessage.Arguments.id.toString(), message.getDataId());
        int i2 = Build.VERSION.SDK_INT;
        PendingIntent activity = PendingIntent.getActivity(this.context, message.getId(), intent, 301989888);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this.context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(...)");
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this.context, channelInfo.getId()).setSmallIcon(R.drawable.ourhome).setContentTitle(message.getTitle()).setContentText(message.getBody()).setStyle(new NotificationCompat.BigTextStyle().bigText(message.getBody())).setPriority(0).setContentIntent(activity).setAutoCancel(true);
        Intrinsics.checkNotNullExpressionValue(autoCancel, "setAutoCancel(...)");
        if (i2 >= 26) {
            createNotificationChannel(channelInfo);
        }
        notificationManagerCompatFrom.notify(message.getId(), autoCancel.build());
    }

    @Override // sputnik.axmor.com.sputnik.core.notifications.INotificationsManager
    public void cancel(int id) {
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this.context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(...)");
        notificationManagerCompatFrom.cancel(id);
    }

    private final void createNotificationChannel(ChannelInfo info) {
        l$$ExternalSyntheticApiModelOutline1.m();
        NotificationChannel notificationChannelM = CompositeService$$ExternalSyntheticApiModelOutline3.m(info.getId(), info.getName(), info.getImportance());
        Object systemService = this.context.getSystemService(RemoteMessageConst.NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannelM);
    }
}
