package sputnik.axmor.com.sputnik.services.ble_service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.LocationManager;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.IBinder;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.ktx.FirebaseCrashlyticsKt;
import com.google.firebase.ktx.Firebase;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.hms.support.api.location.common.LocationConstant;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.entities.localization.entities.ble.BleLocale;
import com.sputnik.common.entities.notifications.PushMessage;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.utils.LogUtilsKt;
import com.sputnik.data.local.PrefManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.IBeaconService;
import sputnik.axmor.com.app.services.beacon.utils.BluetoothUtilsKt;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.notifications.INotificationsManager;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager;
import sputnik.axmor.com.sputnik.utils.CommonUtilsKt;

/* compiled from: BeaconServiceManager.kt */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0006*\u0003>BF\u0018\u0000 I2\u00020\u0001:\u0002JIB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u0019J\r\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\nJ\r\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b\u001f\u0010\u001bJ\u0015\u0010 \u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010#R\u0018\u0010=\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010#R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00104R\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00104R\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager;", "", "Landroid/content/Context;", "context", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$BeaconServiceConnectionListener;", "serviceConnectionListener", "<init>", "(Landroid/content/Context;Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$BeaconServiceConnectionListener;)V", "", "unbindStoppingService", "()V", "doStartService", "startScan", "stopScan", "", AttributionReporter.SYSTEM_PERMISSION, "", "isPermissionGranted", "(Landroid/content/Context;Ljava/lang/String;)Z", "", "rssi", "updateRssi", "(I)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setServiceListener", "(Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$BeaconServiceConnectionListener;)V", "getTrackingStatus", "()Z", "beaconServiceStateListener", "startTracking", "stopTracking", "checkPermissionsForBle", "isGpsEnabled", "(Landroid/content/Context;)Z", "Landroid/content/Context;", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$BeaconServiceConnectionListener;", "Lcom/sputnik/data/local/PrefManager;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "setPrefManager", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/common/localization/LocalizationStorage;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "setLocalizationStorage", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "Lsputnik/axmor/com/IBeaconService;", "beaconScannerService", "Lsputnik/axmor/com/IBeaconService;", "Landroid/content/Intent;", "serviceIntent", "Landroid/content/Intent;", "isServiceStarted", "Z", "isServiceBounded", "isServiceNeedToBeStarted", "localBeaconServiceConnectionListener", "firstBeaconServiceConnectionListener", "sputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$beaconServiceConnection$1", "beaconServiceConnection", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$beaconServiceConnection$1;", "checkingServiceVariable", "sputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$checkIsServiceScanningServiceConnection$1", "checkIsServiceScanningServiceConnection", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$checkIsServiceScanningServiceConnection$1;", "stopBeaconServiceConnection", "sputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$stopScanningServiceConnection$1", "stopScanningServiceConnection", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$stopScanningServiceConnection$1;", "Companion", "BeaconServiceConnectionListener", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BeaconServiceManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static BeaconServiceManager instance;
    private IBeaconService beaconScannerService;
    private final BeaconServiceManager$beaconServiceConnection$1 beaconServiceConnection;
    private final BeaconServiceManager$checkIsServiceScanningServiceConnection$1 checkIsServiceScanningServiceConnection;
    private IBeaconService checkingServiceVariable;
    private final Context context;
    private BeaconServiceConnectionListener firstBeaconServiceConnectionListener;
    private boolean isServiceBounded;
    private boolean isServiceNeedToBeStarted;
    private boolean isServiceStarted;
    private BeaconServiceConnectionListener localBeaconServiceConnectionListener;
    public LocalizationStorage localizationStorage;
    public PrefManager prefManager;
    private BeaconServiceConnectionListener serviceConnectionListener;
    private Intent serviceIntent;
    private IBeaconService stopBeaconServiceConnection;
    private final BeaconServiceManager$stopScanningServiceConnection$1 stopScanningServiceConnection;

    /* compiled from: BeaconServiceManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$BeaconServiceConnectionListener;", "", "", "isTracking", "", "onBeaconServiceConnected", "(Z)V", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BeaconServiceConnectionListener {
        void onBeaconServiceConnected(boolean isTracking);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager$beaconServiceConnection$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager$checkIsServiceScanningServiceConnection$1] */
    /* JADX WARN: Type inference failed for: r2v3, types: [sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager$stopScanningServiceConnection$1] */
    public BeaconServiceManager(Context context, BeaconServiceConnectionListener beaconServiceConnectionListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.serviceConnectionListener = beaconServiceConnectionListener;
        SputnikApp.INSTANCE.applicationContext().getAppComponent().inject(this);
        this.serviceIntent = new Intent(context, (Class<?>) BeaconTrackingService.class);
        this.beaconServiceConnection = new ServiceConnection() { // from class: sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager$beaconServiceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                this.this$0.beaconScannerService = IBeaconService.Stub.asInterface(service);
                this.this$0.isServiceBounded = true;
                this.this$0.isServiceStarted = true;
                try {
                    if (this.this$0.isServiceNeedToBeStarted) {
                        IBeaconService iBeaconService = this.this$0.beaconScannerService;
                        if (iBeaconService != null) {
                            Integer rssiOptimal = this.this$0.getPrefManager().getAppSettings().getBleSettings().getRssiOptimal();
                            iBeaconService.start(rssiOptimal != null ? rssiOptimal.intValue() : -120);
                        }
                        BeaconServiceManager.BeaconServiceConnectionListener beaconServiceConnectionListener2 = this.this$0.serviceConnectionListener;
                        if (beaconServiceConnectionListener2 != null) {
                            beaconServiceConnectionListener2.onBeaconServiceConnected(true);
                        }
                        BeaconServiceManager.BeaconServiceConnectionListener beaconServiceConnectionListener3 = this.this$0.localBeaconServiceConnectionListener;
                        if (beaconServiceConnectionListener3 != null) {
                            beaconServiceConnectionListener3.onBeaconServiceConnected(true);
                        }
                        BeaconServiceManager.BeaconServiceConnectionListener beaconServiceConnectionListener4 = this.this$0.firstBeaconServiceConnectionListener;
                        if (beaconServiceConnectionListener4 != null) {
                            beaconServiceConnectionListener4.onBeaconServiceConnected(true);
                        }
                    } else {
                        BeaconServiceManager.BeaconServiceConnectionListener beaconServiceConnectionListener5 = this.this$0.serviceConnectionListener;
                        if (beaconServiceConnectionListener5 != null) {
                            beaconServiceConnectionListener5.onBeaconServiceConnected(false);
                        }
                        BeaconServiceManager.BeaconServiceConnectionListener beaconServiceConnectionListener6 = this.this$0.localBeaconServiceConnectionListener;
                        if (beaconServiceConnectionListener6 != null) {
                            beaconServiceConnectionListener6.onBeaconServiceConnected(false);
                        }
                        BeaconServiceManager.BeaconServiceConnectionListener beaconServiceConnectionListener7 = this.this$0.firstBeaconServiceConnectionListener;
                        if (beaconServiceConnectionListener7 != null) {
                            beaconServiceConnectionListener7.onBeaconServiceConnected(false);
                        }
                    }
                    this.this$0.isServiceNeedToBeStarted = false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.checkIsServiceScanningServiceConnection = new ServiceConnection() { // from class: sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager$checkIsServiceScanningServiceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                this.this$0.checkingServiceVariable = IBeaconService.Stub.asInterface(service);
                try {
                    IBeaconService iBeaconService = this.this$0.checkingServiceVariable;
                    if (iBeaconService == null || !iBeaconService.isTracking()) {
                        return;
                    }
                    this.this$0.isServiceBounded = true;
                    this.this$0.isServiceStarted = true;
                    this.this$0.startTracking(null);
                    BeaconServiceManager.BeaconServiceConnectionListener beaconServiceConnectionListener2 = this.this$0.serviceConnectionListener;
                    if (beaconServiceConnectionListener2 != null) {
                        beaconServiceConnectionListener2.onBeaconServiceConnected(true);
                    }
                    BeaconServiceManager.BeaconServiceConnectionListener beaconServiceConnectionListener3 = this.this$0.localBeaconServiceConnectionListener;
                    if (beaconServiceConnectionListener3 != null) {
                        beaconServiceConnectionListener3.onBeaconServiceConnected(true);
                    }
                    BeaconServiceManager.BeaconServiceConnectionListener beaconServiceConnectionListener4 = this.this$0.firstBeaconServiceConnectionListener;
                    if (beaconServiceConnectionListener4 != null) {
                        beaconServiceConnectionListener4.onBeaconServiceConnected(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.stopScanningServiceConnection = new ServiceConnection() { // from class: sputnik.axmor.com.sputnik.services.ble_service.BeaconServiceManager$stopScanningServiceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                this.this$0.stopBeaconServiceConnection = IBeaconService.Stub.asInterface(service);
                try {
                    IBeaconService iBeaconService = this.this$0.stopBeaconServiceConnection;
                    Intrinsics.checkNotNull(iBeaconService);
                    iBeaconService.stop();
                    this.this$0.unbindStoppingService();
                } catch (Exception e) {
                    LogUtilsKt.writeLog("Stop scanning service connection " + e.getMessage());
                    e.printStackTrace();
                }
            }
        };
    }

    public final PrefManager getPrefManager() {
        PrefManager prefManager = this.prefManager;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prefManager");
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

    public final void updateRssi(int rssi) {
        try {
            IBeaconService iBeaconService = this.beaconScannerService;
            if (iBeaconService != null) {
                iBeaconService.updateRssi(rssi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unbindStoppingService() {
        this.context.unbindService(this.stopScanningServiceConnection);
    }

    public final void setServiceListener(BeaconServiceConnectionListener listener) {
        if (listener != null) {
            this.serviceConnectionListener = listener;
        }
    }

    /* renamed from: getTrackingStatus, reason: from getter */
    public final boolean getIsServiceStarted() {
        return this.isServiceStarted;
    }

    public final void startTracking(BeaconServiceConnectionListener beaconServiceStateListener) {
        String title;
        String body;
        BleLocale ble;
        BleLocale.NoPermissionsNotification noPermissionsNotification;
        BleLocale ble2;
        BleLocale.NoPermissionsNotification noPermissionsNotification2;
        if (getIsServiceStarted()) {
            return;
        }
        if (checkPermissionsForBle() && isGpsEnabled(this.context) && BluetoothUtilsKt.isBluetoothEnabled()) {
            this.localBeaconServiceConnectionListener = beaconServiceStateListener;
            doStartService();
            return;
        }
        INotificationsManager companion = INotificationsManager.INSTANCE.getInstance(this.context);
        LocalizationLocalModel data = getLocalizationStorage().getData();
        if (data == null || (ble2 = data.getBle()) == null || (noPermissionsNotification2 = ble2.getNoPermissionsNotification()) == null || (title = noPermissionsNotification2.getTitle()) == null) {
            title = "❗️Недостаточно разрешений";
        }
        String str = title;
        LocalizationLocalModel data2 = getLocalizationStorage().getData();
        if (data2 == null || (ble = data2.getBle()) == null || (noPermissionsNotification = ble.getNoPermissionsNotification()) == null || (body = noPermissionsNotification.getBody()) == null) {
            body = "Для работы функции “Бесключевой доступ” необходимо выдать недостающие разрешения";
        }
        companion.notifyPush(new PushMessage(4102, str, body, PushMessage.Types.promo, "sputnik://no_permissions_dialog", null, 32, null));
    }

    public final void stopTracking() {
        stopScan();
    }

    private final void doStartService() {
        this.isServiceNeedToBeStarted = true;
        INotificationsManager.INSTANCE.getInstance(this.context).cancel(4102);
        startScan();
    }

    private final void startScan() {
        FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE).log("service-manager:launch-ble");
        CommonUtilsKt.launchService(this.context, this.serviceIntent);
        this.context.bindService(this.serviceIntent, this.beaconServiceConnection, 1);
    }

    private final void stopScan() {
        try {
            IBeaconService iBeaconService = this.beaconScannerService;
            if (iBeaconService != null) {
                iBeaconService.stop();
            }
            this.context.unbindService(this.beaconServiceConnection);
            this.context.stopService(new Intent(this.context, (Class<?>) BeaconTrackingService.class));
        } catch (DeadObjectException unused) {
            this.context.bindService(this.serviceIntent, this.stopScanningServiceConnection, 1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.isServiceStarted = false;
    }

    /* compiled from: BeaconServiceManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$Companion;", "", "()V", "instance", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager;", "getInstance", "context", "Landroid/content/Context;", "serviceConnectionListener", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconServiceManager$BeaconServiceConnectionListener;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BeaconServiceManager getInstance(Context context, BeaconServiceConnectionListener serviceConnectionListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (BeaconServiceManager.instance == null) {
                BeaconServiceManager.instance = new BeaconServiceManager(context, serviceConnectionListener);
            }
            BeaconServiceManager beaconServiceManager = BeaconServiceManager.instance;
            if (beaconServiceManager != null) {
                beaconServiceManager.setServiceListener(serviceConnectionListener);
            }
            BeaconServiceManager beaconServiceManager2 = BeaconServiceManager.instance;
            Intrinsics.checkNotNull(beaconServiceManager2);
            return beaconServiceManager2;
        }
    }

    public final boolean checkPermissionsForBle() {
        List listMutableListOf = CollectionsKt.mutableListOf("android.permission.ACCESS_FINE_LOCATION");
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            listMutableListOf.add("android.permission.BLUETOOTH_SCAN");
        }
        if (i >= 29) {
            listMutableListOf.add(LocationConstant.BACKGROUND_PERMISSION);
        }
        if (i < 29) {
            return isPermissionGranted(this.context, "android.permission.ACCESS_FINE_LOCATION");
        }
        if (29 <= i && i < 31) {
            isPermissionGranted(this.context, LocationConstant.BACKGROUND_PERMISSION);
            return true;
        }
        if (31 > i || i >= 41) {
            return true;
        }
        boolean z = isPermissionGranted(this.context, LocationConstant.BACKGROUND_PERMISSION) && isPermissionGranted(this.context, "android.permission.BLUETOOTH_SCAN");
        boolean z2 = i >= 33;
        boolean zIsPermissionGranted = isPermissionGranted(this.context, "android.permission.POST_NOTIFICATIONS");
        if (!z2 || zIsPermissionGranted) {
            return z;
        }
        return false;
    }

    private final boolean isPermissionGranted(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == 0;
    }

    public final boolean isGpsEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        return ((LocationManager) systemService).isProviderEnabled("gps");
    }
}
