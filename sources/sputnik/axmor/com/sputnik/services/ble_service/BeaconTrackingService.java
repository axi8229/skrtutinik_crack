package sputnik.axmor.com.sputnik.services.ble_service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.LifecycleService;
import com.axmor.ash.toolset.service.impl.CompositeService$$ExternalSyntheticApiModelOutline3;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.gson.Gson;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.l$$ExternalSyntheticApiModelOutline1;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.sputnik.activationautomation.data.files.ILogger;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.ble.BleLocale;
import com.sputnik.common.entities.notifications.PushMessage;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.entities.door.OpenDoorProducers;
import com.sputnik.domain.entities.prefs.Camera;
import com.sputnik.domain.repositories.cameras.ICamerasRepository;
import com.sputnik.scancameraidentifiers.data.files.FileManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import sputnik.axmor.com.IBeaconService;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.notifications.INotificationsManager;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager;
import sputnik.axmor.com.sputnik.ui.root.SputnikRootActivity;

/* compiled from: BeaconTrackingService.kt */
@Metadata(d1 = {"\u0000Ó\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001g\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0090\u0001\u0091\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b!\u0010\u0004J)\u0010'\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\u0004J\u0017\u0010+\u001a\u00020*2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b+\u0010,J\u0019\u0010-\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\u0004J\u0019\u00100\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00104\u001a\u00020\u00052\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020$H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020$H\u0016¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u001bH\u0016¢\u0006\u0004\b:\u0010\u001eJ\u0019\u0010<\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b<\u0010.R\u0017\u0010>\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010G\u001a\n F*\u0004\u0018\u00010E0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u001c\u0010V\u001a\b\u0018\u00010TR\u00020U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010^R\u0016\u0010c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010^R\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010h\u001a\u00020g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\"\u0010k\u001a\u00020j8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010r\u001a\u00020q8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\"\u0010y\u001a\u00020x8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R)\u0010\u0080\u0001\u001a\u00020\u007f8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0018\u0010\u0086\u0001\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010ZR!\u0010\u008c\u0001\u001a\u00030\u0087\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0019\u0010\u008d\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u008f\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008e\u0001¨\u0006\u0092\u0001"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/BeaconTrackingService;", "Landroidx/lifecycle/LifecycleService;", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$ScanResultsListener;", "<init>", "()V", "", "initVariables", "Landroid/app/Notification;", "createMainNotification", "()Landroid/app/Notification;", "", "code", "showEmergencyCodeNotification", "(Ljava/lang/String;)V", "showNoPermissionsNotification", "cancelNoPermissionsNotification", "showForegroundNotification", "hideForegroundNotification", "cancelAllNotifications", "", "Lsputnik/axmor/com/sputnik/services/ble_service/ScanParameters;", "getScanParameters", "()Ljava/util/List;", "startTracking", "registerReceivers", "unregisterReceivers", "stopTimers", "", "state", "setTracking", "(Z)V", "stopTracking", "releaseWakeLock", "updateWakeLock", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onCreate", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onRebind", "(Landroid/content/Intent;)V", "onLowMemory", "onUnbind", "(Landroid/content/Intent;)Z", "serial", "rssi", "onIntercomFound", "(Ljava/lang/String;I)V", "errorCode", "onScanError", "(I)V", "isEnabled", "onBluetoothStateChanged", "rootIntent", "onTaskRemoved", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager;", "beaconScanningManager", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager;", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "soundUri", "Landroid/net/Uri;", "Landroid/app/NotificationChannel;", "mainNotificationChannel", "Landroid/app/NotificationChannel;", "Landroidx/core/app/NotificationManagerCompat;", "notificationManager", "Landroidx/core/app/NotificationManagerCompat;", RemoteMessageConst.NOTIFICATION, "Landroid/app/Notification;", "Ljava/util/Timer;", "wakelockTimer", "Ljava/util/Timer;", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "", "lastLockUpdateMillis", "J", "powerManager", "Landroid/os/PowerManager;", "isTracking", "Z", "Landroid/os/Handler;", "timerHandler", "Landroid/os/Handler;", "gpsEnabled", "bluetoothEnabled", "Landroid/location/LocationManager;", "locationManager", "Landroid/location/LocationManager;", "sputnik/axmor/com/sputnik/services/ble_service/BeaconTrackingService$gpsStateBroadcastReceiver$1", "gpsStateBroadcastReceiver", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconTrackingService$gpsStateBroadcastReceiver$1;", "Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;", "camerasRepository", "Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;", "getCamerasRepository", "()Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;", "setCamerasRepository", "(Lcom/sputnik/domain/repositories/cameras/ICamerasRepository;)V", "Lcom/sputnik/data/local/PrefManager;", "prefs", "Lcom/sputnik/data/local/PrefManager;", "getPrefs", "()Lcom/sputnik/data/local/PrefManager;", "setPrefs", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/analytics/Analytics;", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "setAnalytics", "(Lcom/sputnik/common/analytics/Analytics;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "lastOpeningTimeMillis", "Lcom/sputnik/activationautomation/data/files/ILogger;", "fileManager$delegate", "Lkotlin/Lazy;", "getFileManager", "()Lcom/sputnik/activationautomation/data/files/ILogger;", "fileManager", "currentRssi", "I", "startTrackingCounter", "BeaconService", "UpdateWakeLockTimerTask", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BeaconTrackingService extends LifecycleService implements BeaconScanningManager.ScanResultsListener {
    public Analytics analytics;
    private BeaconScanningManager beaconScanningManager;
    public ICamerasRepository camerasRepository;
    private boolean isTracking;
    private long lastLockUpdateMillis;
    private long lastOpeningTimeMillis;
    public LocalizationStorage localizationStorage;
    private LocationManager locationManager;
    private NotificationChannel mainNotificationChannel;
    private Notification notification;
    private NotificationManagerCompat notificationManager;
    private PowerManager powerManager;
    public PrefManager prefs;
    private PowerManager.WakeLock wakeLock;
    private final Gson gson = new Gson();
    private final Uri soundUri = RingtoneManager.getDefaultUri(2);
    private Timer wakelockTimer = new Timer();
    private Handler timerHandler = new Handler(Looper.getMainLooper());
    private boolean gpsEnabled = true;
    private boolean bluetoothEnabled = true;
    private final BeaconTrackingService$gpsStateBroadcastReceiver$1 gpsStateBroadcastReceiver = new BroadcastReceiver() { // from class: sputnik.axmor.com.sputnik.services.ble_service.BeaconTrackingService$gpsStateBroadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (intent.getAction() != null) {
                LocationManager locationManager = this.this$0.locationManager;
                boolean z = false;
                if (locationManager != null && locationManager.isProviderEnabled("gps")) {
                    z = true;
                }
                this.this$0.gpsEnabled = z;
                if (z) {
                    if (this.this$0.bluetoothEnabled) {
                        this.this$0.cancelNoPermissionsNotification();
                        return;
                    }
                    return;
                }
                this.this$0.showNoPermissionsNotification();
            }
        }
    };

    /* renamed from: fileManager$delegate, reason: from kotlin metadata */
    private final Lazy fileManager = LazyKt.lazy(new Function0<ILogger>() { // from class: sputnik.axmor.com.sputnik.services.ble_service.BeaconTrackingService$fileManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILogger invoke() {
            FileManager.Companion companion = FileManager.INSTANCE;
            String absolutePath = this.this$0.getFilesDir().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            return FileManager.Companion.getInstance$default(companion, absolutePath, null, 2, null);
        }
    });
    private int currentRssi = -120;
    private int startTrackingCounter = -1;

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
    }

    /* compiled from: BeaconTrackingService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/BeaconTrackingService$UpdateWakeLockTimerTask;", "Ljava/util/TimerTask;", "(Lsputnik/axmor/com/sputnik/services/ble_service/BeaconTrackingService;)V", "run", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class UpdateWakeLockTimerTask extends TimerTask {
        public UpdateWakeLockTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BeaconTrackingService.this.updateWakeLock();
        }
    }

    /* compiled from: BeaconTrackingService.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/BeaconTrackingService$BeaconService;", "Lsputnik/axmor/com/IBeaconService$Stub;", "(Lsputnik/axmor/com/sputnik/services/ble_service/BeaconTrackingService;)V", "isTracking", "", "start", "", "rssi", "", "stop", "updateRssi", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class BeaconService extends IBeaconService.Stub {
        public BeaconService() {
        }

        @Override // sputnik.axmor.com.IBeaconService
        public void start(int rssi) {
            BeaconTrackingService.this.currentRssi = rssi;
            BeaconTrackingService.this.startTracking();
        }

        @Override // sputnik.axmor.com.IBeaconService
        public void updateRssi(int rssi) {
            BeaconTrackingService.this.currentRssi = rssi;
        }

        @Override // sputnik.axmor.com.IBeaconService
        public void stop() {
            BeaconTrackingService.this.stopTracking();
        }

        @Override // sputnik.axmor.com.IBeaconService
        public boolean isTracking() {
            return isTracking();
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        initVariables();
        showForegroundNotification();
        if (intent != null && intent.getBooleanExtra("from_reboot", false)) {
            startTracking();
        }
        return 1;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onBind(intent);
        return new BeaconService();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public final ICamerasRepository getCamerasRepository() {
        ICamerasRepository iCamerasRepository = this.camerasRepository;
        if (iCamerasRepository != null) {
            return iCamerasRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("camerasRepository");
        return null;
    }

    public final PrefManager getPrefs() {
        PrefManager prefManager = this.prefs;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefs");
        return null;
    }

    public final Analytics getAnalytics() {
        Analytics analytics = this.analytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analytics");
        return null;
    }

    public final LocalizationStorage getLocalizationStorage() {
        LocalizationStorage localizationStorage = this.localizationStorage;
        if (localizationStorage != null) {
            return localizationStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizationStorage");
        return null;
    }

    @Override // sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager.ScanResultsListener
    public void onIntercomFound(String serial, int rssi) {
        Intrinsics.checkNotNullParameter(serial, "serial");
        StringsKt.isBlank(serial);
        if (rssi <= this.currentRssi || StringsKt.isBlank(serial) || rssi == 127 || System.currentTimeMillis() - this.lastOpeningTimeMillis <= DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
            return;
        }
        this.lastOpeningTimeMillis = System.currentTimeMillis() + DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(serial, null), 3, null);
    }

    /* compiled from: BeaconTrackingService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sputnik.axmor.com.sputnik.services.ble_service.BeaconTrackingService$onIntercomFound$1", f = "BeaconTrackingService.kt", l = {207}, m = "invokeSuspend")
    /* renamed from: sputnik.axmor.com.sputnik.services.ble_service.BeaconTrackingService$onIntercomFound$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $serial;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$serial = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BeaconTrackingService.this.new AnonymousClass1(this.$serial, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object next;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<Camera> cameras = BeaconTrackingService.this.getPrefs().getCameras();
                String str = this.$serial;
                Iterator<T> it = cameras.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((Camera) next).getSerial(), str)) {
                        break;
                    }
                }
                Camera camera = (Camera) next;
                if (camera != null) {
                    BeaconTrackingService beaconTrackingService = BeaconTrackingService.this;
                    Flow flowOpenDoor$default = ICamerasRepository.DefaultImpls.openDoor$default(beaconTrackingService.getCamerasRepository(), String.valueOf(camera.getUuid()), false, OpenDoorProducers.ble, null, 10, null);
                    BeaconTrackingService$onIntercomFound$1$1$1 beaconTrackingService$onIntercomFound$1$1$1 = new BeaconTrackingService$onIntercomFound$1$1$1(beaconTrackingService, null);
                    this.label = 1;
                    if (FlowKt.collectLatest(flowOpenDoor$default, beaconTrackingService$onIntercomFound$1$1$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager.ScanResultsListener
    public void onScanError(int errorCode) {
        if (errorCode == 10) {
            showNoPermissionsNotification();
        }
        setTracking(false);
        this.startTrackingCounter = 1;
        startTracking();
    }

    @Override // sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager.ScanResultsListener
    public void onBluetoothStateChanged(boolean isEnabled) {
        this.bluetoothEnabled = isEnabled;
        if (isEnabled) {
            if (this.gpsEnabled) {
                cancelNoPermissionsNotification();
                return;
            }
            return;
        }
        showNoPermissionsNotification();
    }

    private final void initVariables() {
        SputnikApp.Companion companion = SputnikApp.INSTANCE;
        companion.applicationContext().getAppComponent().inject(this);
        Integer rssiOptimal = getPrefs().getAppSettings().getBleSettings().getRssiOptimal();
        this.currentRssi = rssiOptimal != null ? rssiOptimal.intValue() : -120;
        this.notification = createMainNotification();
        Object systemService = getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        this.locationManager = (LocationManager) systemService;
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(this);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(...)");
        this.notificationManager = notificationManagerCompatFrom;
        Object systemService2 = getSystemService("power");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
        this.powerManager = (PowerManager) systemService2;
        if (Build.VERSION.SDK_INT >= 26) {
            l$$ExternalSyntheticApiModelOutline1.m();
            NotificationChannel notificationChannelM = CompositeService$$ExternalSyntheticApiModelOutline3.m(companion.applicationContext().getString(R.string.app_name) + "CallId", companion.applicationContext().getString(R.string.app_name) + " Smart Home", 4);
            notificationChannelM.setSound(this.soundUri, new AudioAttributes.Builder().setUsage(5).setContentType(1).build());
            this.mainNotificationChannel = notificationChannelM;
            NotificationManagerCompat notificationManagerCompat = this.notificationManager;
            NotificationChannel notificationChannel = null;
            if (notificationManagerCompat == null) {
                Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                notificationManagerCompat = null;
            }
            NotificationChannel notificationChannel2 = this.mainNotificationChannel;
            if (notificationChannel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mainNotificationChannel");
            } else {
                notificationChannel = notificationChannel2;
            }
            notificationManagerCompat.createNotificationChannel(notificationChannel);
        }
    }

    private final Notification createMainNotification() {
        String title;
        String body;
        BleLocale ble;
        BleLocale.ServiceNotification serviceNotification;
        BleLocale ble2;
        BleLocale.ServiceNotification serviceNotification2;
        PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) SputnikRootActivity.class), 67108864);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, SputnikApp.INSTANCE.applicationContext().getString(R.string.app_name) + "CallId");
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (ble2 = data.getBle()) == null || (serviceNotification2 = ble2.getServiceNotification()) == null || (title = serviceNotification2.getTitle()) == null) {
            title = "Бесключевой доступ к домофону";
        }
        NotificationCompat.Builder contentTitle = builder.setContentTitle(title);
        LocalizationLocalModel data2 = getLocalizationStorage().getData();
        if (data2 == null || (ble = data2.getBle()) == null || (serviceNotification = ble.getServiceNotification()) == null || (body = serviceNotification.getBody()) == null) {
            body = "Функция “Бесключевой доступ” активна";
        }
        Notification notificationBuild = contentTitle.setContentText(body).setOngoing(true).setSmallIcon(R.drawable.ic_out_home_icon).setWhen(System.currentTimeMillis()).setPriority(2).setSound(this.soundUri).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmergencyCodeNotification(String code) {
        String title;
        String body;
        BleLocale ble;
        BleLocale.EmergencyCodeNotification emergencyCodeNotification;
        BleLocale ble2;
        BleLocale.EmergencyCodeNotification emergencyCodeNotification2;
        Intent intent = new Intent(this, (Class<?>) SputnikRootActivity.class);
        intent.addFlags(536870912);
        intent.putExtra(PushMessage.Arguments.deeplink.toString(), getString(R.string.deeplink_emergency_code));
        intent.putExtra("code", code);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, SputnikApp.INSTANCE.applicationContext().getString(R.string.app_name) + "CallId");
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (ble2 = data.getBle()) == null || (emergencyCodeNotification2 = ble2.getEmergencyCodeNotification()) == null || (title = emergencyCodeNotification2.getTitle()) == null) {
            title = "🔑 Код " + code + " для открытия двери 🔑";
        }
        NotificationCompat.Builder contentTitle = builder.setContentTitle(title);
        LocalizationLocalModel data2 = getLocalizationStorage().getData();
        if (data2 == null || (ble = data2.getBle()) == null || (emergencyCodeNotification = ble.getEmergencyCodeNotification()) == null || (body = emergencyCodeNotification.getBody()) == null) {
            body = "Не смогли открыть дверь? Попробуйте воспользоваться кодом";
        }
        NotificationCompat.Builder priority = contentTitle.setContentText(body).setSmallIcon(R.drawable.ic_out_home_icon).setContentIntent(activity).setWhen(System.currentTimeMillis()).setAutoCancel(false).setOngoing(false).setPriority(2);
        Intrinsics.checkNotNullExpressionValue(priority, "setPriority(...)");
        NotificationManagerCompat notificationManagerCompat = this.notificationManager;
        if (notificationManagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
            notificationManagerCompat = null;
        }
        notificationManagerCompat.notify(4101, priority.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNoPermissionsNotification() {
        String title;
        String title2;
        BleLocale ble;
        BleLocale.NoPermissionsNotification noPermissionsNotification;
        BleLocale ble2;
        BleLocale.NoPermissionsNotification noPermissionsNotification2;
        Intent intent = new Intent(this, (Class<?>) SputnikRootActivity.class);
        intent.addFlags(536870912);
        intent.putExtra(PushMessage.Arguments.deeplink.toString(), getString(R.string.deeplink_no_permissions));
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, SputnikApp.INSTANCE.applicationContext().getString(R.string.app_name) + "CallId");
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (ble2 = data.getBle()) == null || (noPermissionsNotification2 = ble2.getNoPermissionsNotification()) == null || (title = noPermissionsNotification2.getTitle()) == null) {
            title = "⚠️ Недостаточно разрешений";
        }
        NotificationCompat.Builder contentTitle = builder.setContentTitle(title);
        LocalizationLocalModel data2 = getLocalizationStorage().getData();
        if (data2 == null || (ble = data2.getBle()) == null || (noPermissionsNotification = ble.getNoPermissionsNotification()) == null || (title2 = noPermissionsNotification.getTitle()) == null) {
            title2 = "Для работы бесключевого доступа требуется предоставить все разрешения";
        }
        NotificationCompat.Builder priority = contentTitle.setContentText(title2).setSmallIcon(R.drawable.ic_out_home_icon).setContentIntent(activity).setWhen(System.currentTimeMillis()).setAutoCancel(false).setOngoing(false).setPriority(2);
        Intrinsics.checkNotNullExpressionValue(priority, "setPriority(...)");
        NotificationManagerCompat notificationManagerCompat = this.notificationManager;
        if (notificationManagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
            notificationManagerCompat = null;
        }
        notificationManagerCompat.notify(4102, priority.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelNoPermissionsNotification() {
        INotificationsManager.INSTANCE.getInstance(this).cancel(4102);
    }

    private final void showForegroundNotification() {
        Notification notification = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Notification notification2 = this.notification;
            if (notification2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(RemoteMessageConst.NOTIFICATION);
            } else {
                notification = notification2;
            }
            startForeground(203, notification, 8);
            return;
        }
        Notification notification3 = this.notification;
        if (notification3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(RemoteMessageConst.NOTIFICATION);
        } else {
            notification = notification3;
        }
        startForeground(203, notification);
    }

    private final void hideForegroundNotification() {
        stopForeground(true);
    }

    private final void cancelAllNotifications() {
        NotificationManagerCompat notificationManagerCompat = this.notificationManager;
        if (notificationManagerCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
            notificationManagerCompat = null;
        }
        notificationManagerCompat.cancelAll();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }

    private final List<ScanParameters> getScanParameters() {
        ArrayList arrayList = new ArrayList();
        UUID uuidFromString = UUID.fromString("0000fff2-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        ScanParameters scanParameters = new ScanParameters(uuidFromString, 0, 0);
        UUID uuidFromString2 = UUID.fromString("0000fff1-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkNotNullExpressionValue(uuidFromString2, "fromString(...)");
        ScanParameters scanParameters2 = new ScanParameters(uuidFromString2, 0, 0);
        UUID uuidFromString3 = UUID.fromString("0000fff0-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkNotNullExpressionValue(uuidFromString3, "fromString(...)");
        ScanParameters scanParameters3 = new ScanParameters(uuidFromString3, 0, 0);
        UUID uuidFromString4 = UUID.fromString("67f0728c-19bd-4170-8203-ec14c9335d80");
        Intrinsics.checkNotNullExpressionValue(uuidFromString4, "fromString(...)");
        CollectionsKt.addAll(arrayList, new ScanParameters[]{scanParameters, scanParameters2, scanParameters3, new ScanParameters(uuidFromString4, 0, 0)});
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTracking() {
        if (this.isTracking) {
            return;
        }
        if (this.startTrackingCounter == 1) {
            this.startTrackingCounter = 0;
        }
        if (this.startTrackingCounter == 0) {
            this.startTrackingCounter = -1;
            return;
        }
        BeaconScanningManager beaconScanningManager = new BeaconScanningManager(this, this, getScanParameters());
        this.beaconScanningManager = beaconScanningManager;
        beaconScanningManager.startTracking();
        try {
            this.wakelockTimer.purge();
            this.wakelockTimer.schedule(new UpdateWakeLockTimerTask(), 0L, 250000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        registerReceivers();
        setTracking(true);
    }

    private final void registerReceivers() {
        try {
            getApplicationContext().registerReceiver(this.gpsStateBroadcastReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void unregisterReceivers() {
        try {
            unregisterReceiver(this.gpsStateBroadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void stopTimers() {
        try {
            this.wakelockTimer.cancel();
            this.wakelockTimer.purge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void setTracking(boolean state) {
        this.isTracking = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopTracking() {
        hideForegroundNotification();
        BeaconScanningManager beaconScanningManager = this.beaconScanningManager;
        if (beaconScanningManager != null) {
            beaconScanningManager.stopTracking();
        }
        stopTimers();
        releaseWakeLock();
        cancelAllNotifications();
        unregisterReceivers();
        setTracking(false);
    }

    private final void releaseWakeLock() {
        try {
            PowerManager.WakeLock wakeLock = this.wakeLock;
            if (wakeLock != null) {
                wakeLock.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWakeLock() {
        PowerManager.WakeLock wakeLock;
        if (this.isTracking) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - this.lastLockUpdateMillis) > 120000) {
                this.lastLockUpdateMillis = jCurrentTimeMillis;
                PowerManager.WakeLock wakeLock2 = this.wakeLock;
                if (wakeLock2 != null) {
                    if (wakeLock2 != null) {
                        wakeLock2.release();
                    }
                    this.wakeLock = null;
                }
                PowerManager powerManager = this.powerManager;
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager != null ? powerManager.newWakeLock(1, "sputnikBLEWakelock:UpdateWakeLock") : null;
                this.wakeLock = wakeLockNewWakeLock;
                if (wakeLockNewWakeLock != null) {
                    wakeLockNewWakeLock.acquire(300000L);
                    return;
                }
                return;
            }
            return;
        }
        this.lastLockUpdateMillis = 0L;
        PowerManager.WakeLock wakeLock3 = this.wakeLock;
        if (wakeLock3 != null) {
            if (wakeLock3 != null) {
                try {
                    if (wakeLock3.isHeld() && (wakeLock = this.wakeLock) != null) {
                        wakeLock.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.wakeLock = null;
        }
    }
}
