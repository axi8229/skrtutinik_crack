package sputnik.axmor.com.sputnik.services.notification_service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.axmor.ash.toolset.service.impl.CompositeService$$ExternalSyntheticApiModelOutline3;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.l$$ExternalSyntheticApiModelOutline1;
import com.mocklets.pluto.PlutoLog;
import com.sputnik.common.entities.localization.CallNotificationLocale;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.notifications.PushMessage;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.domain.utils.DateUtilsKt;
import com.sputnik.scancameraidentifiers.data.files.FileManager;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.services.call_service.CheckCallStateService;
import sputnik.axmor.com.sputnik.services.vibration.VibrationManager;
import sputnik.axmor.com.sputnik.ui.call.CallActivity;

/* compiled from: PushProcessorImpl.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ#\u0010\u0011\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u001c\u0010,\u001a\n +*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Lsputnik/axmor/com/sputnik/services/notification_service/PushProcessorImpl;", "Lsputnik/axmor/com/sputnik/services/notification_service/IPushProcessor;", "Landroid/content/Context;", "context", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/Lifecycle;)V", "", "createNotificationChannel", "()V", "", "", "map", "showNotification", "(Ljava/util/Map;)V", "turnOnScreen", "process", "cancel", "cancelNotification", "mute", "Landroid/content/Context;", "Landroidx/lifecycle/Lifecycle;", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationScreen", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationScreen", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationScreen", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Landroid/media/MediaPlayer;", "player", "Landroid/media/MediaPlayer;", "Lsputnik/axmor/com/sputnik/services/call_service/CheckCallStateService;", "checkCallStateService", "Lsputnik/axmor/com/sputnik/services/call_service/CheckCallStateService;", "Landroid/app/NotificationManager;", "notificationManager", "Landroid/app/NotificationManager;", "CHANNEL_ID", "Ljava/lang/String;", "CHANNEL_NAME", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "ringtone", "Landroid/net/Uri;", "Lsputnik/axmor/com/sputnik/services/vibration/VibrationManager;", "vibrator", "Lsputnik/axmor/com/sputnik/services/vibration/VibrationManager;", "", "lastNotificationId", "I", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/util/Timer;", "timer", "Ljava/util/Timer;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushProcessorImpl implements IPushProcessor {
    private final String CHANNEL_ID;
    private final String CHANNEL_NAME;
    private final CheckCallStateService checkCallStateService;
    private final Context context;
    private Handler handler;
    private int lastNotificationId;
    private final Lifecycle lifecycle;
    public LocalizationStorage localizationScreen;
    private NotificationManager notificationManager;
    private MediaPlayer player;
    private final Uri ringtone;
    private Timer timer;
    private final VibrationManager vibrator;

    public PushProcessorImpl(Context context, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.lifecycle = lifecycle;
        this.checkCallStateService = new CheckCallStateService(context, lifecycle);
        ContextKt.getAppComponent(context).inject(this);
        if (lifecycle != null) {
            lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: sputnik.axmor.com.sputnik.services.notification_service.PushProcessorImpl.1
                @Override // androidx.lifecycle.DefaultLifecycleObserver
                public void onDestroy(LifecycleOwner owner) throws IllegalStateException {
                    Intrinsics.checkNotNullParameter(owner, "owner");
                    super.onDestroy(owner);
                    PushProcessorImpl.this.cancel();
                }
            });
        }
        Object systemService = context.getSystemService(RemoteMessageConst.NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        this.notificationManager = (NotificationManager) systemService;
        SputnikApp.Companion companion = SputnikApp.INSTANCE;
        this.CHANNEL_ID = companion.applicationContext().getString(R.string.app_name) + "CallId";
        this.CHANNEL_NAME = companion.applicationContext().getString(R.string.app_name) + " Smart Home";
        this.ringtone = RingtoneManager.getDefaultUri(1);
        this.vibrator = new VibrationManager(context);
        this.lastNotificationId = 2000;
        this.handler = new Handler(context.getMainLooper());
        this.timer = new Timer();
    }

    public final LocalizationStorage getLocalizationScreen() {
        LocalizationStorage localizationStorage = this.localizationScreen;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationScreen");
        return null;
    }

    @Override // sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor
    public void process(Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(map, "map");
        PlutoLog.i$default(PlutoLog.INSTANCE, "Call", "Processing call push " + map, null, 4, null);
        FileManager.Companion companion = FileManager.INSTANCE;
        String absolutePath = this.context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        FileManager.Companion.getInstance$default(companion, absolutePath, null, 2, null).write(DateUtilsKt.convertMillisToTime(System.currentTimeMillis(), "yyyy.MM.dd HH:mm:ss.SSSS") + "\tProcessing push " + map + "\n");
        if (Build.VERSION.SDK_INT >= 26) {
            createNotificationChannel();
        }
        showNotification(map);
        String str = map.get(PushMessage.Arguments.call_id.toString());
        if (str != null) {
            this.checkCallStateService.startCheckingCallState(str, new Function0<Unit>() { // from class: sputnik.axmor.com.sputnik.services.notification_service.PushProcessorImpl$process$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() throws IllegalStateException {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() throws IllegalStateException {
                    this.this$0.cancelNotification();
                    this.this$0.mute();
                    SputnikApp.INSTANCE.changeCallState(new SputnikApp.Companion.CallState(false, null, null, null, 8, null));
                }
            });
        }
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.services.notification_service.PushProcessorImpl$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException {
                    PushProcessorImpl.process$lambda$2$lambda$1(this.f$0);
                }
            }, UtilsKt.UPDATE_INTERVAL);
            String absolutePath2 = this.context.getFilesDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
            FileManager.Companion.getInstance$default(companion, absolutePath2, null, 2, null).write(DateUtilsKt.convertMillisToTime(System.currentTimeMillis(), "yyyy.MM.dd HH:mm:ss.SSSS") + "\tCancel task launched\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void process$lambda$2$lambda$1(PushProcessorImpl this$0) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SputnikApp.INSTANCE.changeCallState(new SputnikApp.Companion.CallState(false, null, null, null, 8, null));
        FileManager.Companion companion = FileManager.INSTANCE;
        String absolutePath = this$0.context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        FileManager.Companion.getInstance$default(companion, absolutePath, null, 2, null).write(DateUtilsKt.convertMillisToTime(System.currentTimeMillis(), "yyyy.MM.dd HH:mm:ss.SSSS") + "\tCancel task end\n");
        this$0.cancel();
    }

    @Override // sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor
    public void cancel() throws IllegalStateException {
        FileManager.Companion companion = FileManager.INSTANCE;
        String absolutePath = this.context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        FileManager.Companion.getInstance$default(companion, absolutePath, null, 2, null).write(DateUtilsKt.convertMillisToTime(System.currentTimeMillis(), "yyyy.MM.dd HH:mm:ss.SSSS") + "\tInternal notification canceling\n");
        this.handler = null;
        try {
            this.timer.cancel();
            this.timer.purge();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            MediaPlayer mediaPlayer2 = this.player;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            this.player = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        cancelNotification();
        this.vibrator.cancel();
        FileManager.Companion companion2 = FileManager.INSTANCE;
        String absolutePath2 = this.context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
        FileManager.Companion.getInstance$default(companion2, absolutePath2, null, 2, null).write(DateUtilsKt.convertMillisToTime(System.currentTimeMillis(), "yyyy.MM.dd HH:mm:ss.SSSS") + "\tInternal notification canceling end\n");
    }

    @Override // sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor
    public void cancelNotification() {
        this.notificationManager.cancel(this.lastNotificationId);
    }

    public void mute() throws IllegalStateException {
        FileManager.Companion companion = FileManager.INSTANCE;
        String absolutePath = this.context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        FileManager.Companion.getInstance$default(companion, absolutePath, null, 2, null).write(DateUtilsKt.convertMillisToTime(System.currentTimeMillis(), "yyyy.MM.dd HH:mm:ss.SSSS") + "\tMuting\n");
        this.vibrator.cancel();
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
            MediaPlayer mediaPlayer2 = this.player;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
            }
            this.player = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            l$$ExternalSyntheticApiModelOutline1.m();
            NotificationChannel notificationChannelM = CompositeService$$ExternalSyntheticApiModelOutline3.m(this.CHANNEL_ID, this.CHANNEL_NAME, 4);
            notificationChannelM.setLockscreenVisibility(1);
            notificationChannelM.setDescription("Call Notifications");
            notificationChannelM.enableVibration(true);
            notificationChannelM.setSound(null, null);
            this.notificationManager.createNotificationChannel(notificationChannelM);
        }
    }

    private final void showNotification(Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str;
        CallNotificationLocale callNotification;
        CallNotificationLocale callNotification2;
        String title;
        CallNotificationLocale callNotification3;
        CallNotificationLocale callNotification4;
        List<String> actions;
        CallNotificationLocale callNotification5;
        List<String> actions2;
        CallNotificationLocale callNotification6;
        String title2;
        CallNotificationLocale callNotification7;
        CallNotificationLocale callNotification8;
        List<String> actions3;
        CallNotificationLocale callNotification9;
        List<String> actions4;
        String str2 = map.get(PushMessage.Arguments.intercom_uuid.toString());
        String str3 = map.get(PushMessage.Arguments.call_id.toString());
        String str4 = map.get(PushMessage.Arguments.flat_uuid.toString());
        String subtitle = map.get(PushMessage.Arguments.address.toString());
        if ((subtitle == null || StringsKt.isBlank(subtitle)) && (subtitle = map.get("address")) == null) {
            LocalizationLocalModel data = getLocalizationScreen().getData();
            if (data == null || (callNotification = data.getCallNotification()) == null) {
                str = null;
            } else {
                subtitle = callNotification.getSubtitle();
                str = subtitle;
            }
        } else {
            str = subtitle;
        }
        SputnikApp.INSTANCE.changeCallState(new SputnikApp.Companion.CallState(true, str3, str2, null, 8, null));
        this.lastNotificationId = 2000;
        Intent intent = new Intent(this.context, (Class<?>) CallActivity.class);
        intent.setAction("103");
        intent.setFlags(268468224);
        intent.putExtra("sputnik.axmor.com.sputnik.global.call_id", str3);
        intent.putExtra("sputnik.axmor.com.sputnik.global.uuid", str2);
        intent.putExtra("call.flat_uuid", str4);
        PendingIntent activity = PendingIntent.getActivity(this.context, 103, intent, 167772160);
        LogUtilsKt.writeLog("GGGG: ACCEPT CREATING");
        Intent intent2 = new Intent(this.context, (Class<?>) CallActivity.class);
        intent2.setAction("101");
        intent2.putExtra("sputnik.axmor.com.sputnik.global.call_id", str3);
        intent2.putExtra("sputnik.axmor.com.sputnik.global.uuid", str2);
        intent2.putExtra("call.flat_uuid", str4);
        intent2.putExtra("sputnik.axmor.com.sputnik.global.is_accepted", true);
        PendingIntent activity2 = PendingIntent.getActivity(this.context, 101, intent2, 167772160);
        Intent intent3 = new Intent(this.context, (Class<?>) NotificationActionForegroundService.class);
        intent3.setAction("102");
        PendingIntent service = PendingIntent.getService(this.context, 102, intent3, 167772160);
        IconCompat iconCompatCreateWithResource = IconCompat.createWithResource(this.context, R.drawable.ic_accept);
        LocalizationLocalModel data2 = getLocalizationScreen().getData();
        NotificationCompat.Action.Builder builder = new NotificationCompat.Action.Builder(iconCompatCreateWithResource, (data2 == null || (callNotification9 = data2.getCallNotification()) == null || (actions4 = callNotification9.getActions()) == null) ? null : (String) CollectionsKt.first((List) actions4), activity2);
        IconCompat iconCompatCreateWithResource2 = IconCompat.createWithResource(this.context, R.drawable.ic_cancel_fullscreen);
        LocalizationLocalModel data3 = getLocalizationScreen().getData();
        NotificationCompat.Action.Builder builder2 = new NotificationCompat.Action.Builder(iconCompatCreateWithResource2, (data3 == null || (callNotification8 = data3.getCallNotification()) == null || (actions3 = callNotification8.getActions()) == null) ? null : (String) CollectionsKt.last((List) actions3), service);
        turnOnScreen();
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            Icon iconCreateWithResource = Icon.createWithResource(this.context, R.drawable.ic_our_home_logo_notifications);
            Intrinsics.checkNotNullExpressionValue(iconCreateWithResource, "createWithResource(...)");
            LocalizationLocalModel data4 = getLocalizationScreen().getData();
            if (data4 == null || (callNotification6 = data4.getCallNotification()) == null || (title2 = callNotification6.getTitle()) == null || !(!StringsKt.isBlank(title2))) {
                title = "Call";
            } else {
                LocalizationLocalModel data5 = getLocalizationScreen().getData();
                title = (data5 == null || (callNotification7 = data5.getCallNotification()) == null) ? null : callNotification7.getTitle();
            }
            Person personBuild = PushProcessorImpl$$ExternalSyntheticApiModelOutline0.m().setIcon(iconCreateWithResource).setName(title).setImportant(true).build();
            Intrinsics.checkNotNullExpressionValue(personBuild, "build(...)");
            Notification.CallStyle callStyleForIncomingCall = Notification.CallStyle.forIncomingCall(personBuild, service, activity2);
            Intrinsics.checkNotNullExpressionValue(callStyleForIncomingCall, "forIncomingCall(...)");
            Icon iconCreateWithResource2 = Icon.createWithResource(this.context, R.drawable.ic_accept);
            LocalizationLocalModel data6 = getLocalizationScreen().getData();
            Notification.Action.Builder builder3 = new Notification.Action.Builder(iconCreateWithResource2, (data6 == null || (callNotification5 = data6.getCallNotification()) == null || (actions2 = callNotification5.getActions()) == null) ? null : (String) CollectionsKt.first((List) actions2), activity2);
            Icon iconCreateWithResource3 = Icon.createWithResource(this.context, R.drawable.ic_cancel_fullscreen);
            LocalizationLocalModel data7 = getLocalizationScreen().getData();
            Notification.Action.Builder builder4 = new Notification.Action.Builder(iconCreateWithResource3, (data7 == null || (callNotification4 = data7.getCallNotification()) == null || (actions = callNotification4.getActions()) == null) ? null : (String) CollectionsKt.last((List) actions), service);
            PushProcessorImpl$$ExternalSyntheticApiModelOutline2.m();
            Notification.Builder smallIcon = PushProcessorImpl$$ExternalSyntheticApiModelOutline1.m(this.context, this.CHANNEL_ID).setSmallIcon(R.drawable.ic_our_home_logo_notifications);
            LocalizationLocalModel data8 = getLocalizationScreen().getData();
            Notification.Builder timeoutAfter = smallIcon.setContentTitle((data8 == null || (callNotification3 = data8.getCallNotification()) == null) ? null : callNotification3.getTitle()).setContentText(str).setStyle(new Notification.BigTextStyle().bigText(str)).setContentIntent(activity).setAutoCancel(true).setOngoing(true).setOnlyAlertOnce(true).setCategory("call").setTimeoutAfter(UtilsKt.UPDATE_INTERVAL);
            Intrinsics.checkNotNullExpressionValue(timeoutAfter, "setTimeoutAfter(...)");
            if (i >= 34 && this.notificationManager.canUseFullScreenIntent()) {
                timeoutAfter.setStyle(callStyleForIncomingCall);
                timeoutAfter.setFullScreenIntent(activity, true);
            } else {
                timeoutAfter.addAction(builder3.build());
                timeoutAfter.addAction(builder4.build());
            }
            NotificationManager notificationManager = this.notificationManager;
            Notification notificationBuild = timeoutAfter.build();
            if (i >= 34) {
                notificationBuild.flags = 8;
            } else {
                notificationBuild.flags = 8;
            }
            Unit unit = Unit.INSTANCE;
            notificationManager.notify(2000, notificationBuild);
        } else {
            NotificationCompat.Builder smallIcon2 = new NotificationCompat.Builder(this.context, this.CHANNEL_ID).setSmallIcon(R.drawable.ourhome);
            LocalizationLocalModel data9 = getLocalizationScreen().getData();
            NotificationCompat.Builder autoCancel = smallIcon2.setContentTitle((data9 == null || (callNotification2 = data9.getCallNotification()) == null) ? null : callNotification2.getTitle()).setContentText(str).setStyle(new NotificationCompat.BigTextStyle().bigText(str)).setOngoing(true).setOnlyAlertOnce(true).setSound(null).setPriority(2).setCategory("call").setContentIntent(activity).setAutoCancel(true);
            Intrinsics.checkNotNullExpressionValue(autoCancel, "setAutoCancel(...)");
            autoCancel.addAction(builder.build());
            autoCancel.addAction(builder2.build());
            NotificationManager notificationManager2 = this.notificationManager;
            Notification notificationBuild2 = autoCancel.build();
            notificationBuild2.flags = 8;
            Unit unit2 = Unit.INSTANCE;
            notificationManager2.notify(2000, notificationBuild2);
        }
        try {
            MediaPlayer mediaPlayer = this.player;
            if (mediaPlayer == null) {
                Uri defaultUri = RingtoneManager.getDefaultUri(1);
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                this.player = mediaPlayer2;
                mediaPlayer2.setDataSource(this.context, defaultUri);
                MediaPlayer mediaPlayer3 = this.player;
                if (mediaPlayer3 != null) {
                    mediaPlayer3.setAudioAttributes(new AudioAttributes.Builder().setUsage(5).setContentType(4).build());
                }
                MediaPlayer mediaPlayer4 = this.player;
                if (mediaPlayer4 != null) {
                    mediaPlayer4.prepare();
                }
            } else {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
                MediaPlayer mediaPlayer5 = this.player;
                if (mediaPlayer5 != null) {
                    mediaPlayer5.reset();
                }
            }
            MediaPlayer mediaPlayer6 = this.player;
            if (mediaPlayer6 != null) {
                mediaPlayer6.start();
            }
            this.vibrator.vibrate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void turnOnScreen() {
        LogUtilsKt.writeLog("DDD: Asquire screen lock && cpu");
        FileManager.Companion companion = FileManager.INSTANCE;
        String absolutePath = this.context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        FileManager.Companion.getInstance$default(companion, absolutePath, null, 2, null).write(DateUtilsKt.convertMillisToTime(System.currentTimeMillis(), "yyyy.MM.dd HH:mm:ss.SSSS") + "\tAsquire screen lock\n");
        String str = this.context.getPackageName() + ":MH24_SCREENLOCK";
        Object systemService = this.context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager powerManager = (PowerManager) systemService;
        if (powerManager.isInteractive()) {
            return;
        }
        powerManager.newWakeLock(805306394, str).acquire(40000L);
        powerManager.newWakeLock(1, str).acquire(40000L);
    }
}
