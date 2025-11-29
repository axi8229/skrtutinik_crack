package sputnik.axmor.com.sputnik.ui.settings;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelKt;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.hms.support.api.location.common.LocationConstant;
import com.sputnik.common.base.BaseViewModel;
import com.sputnik.data.entities.cameras.CameraPreferences;
import com.sputnik.data.entities.preferences.MarketRedPointPreferences;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.auth.RegistrationWay;
import com.sputnik.domain.entities.prefs.AppSettings;
import com.sputnik.domain.entities.prefs.DebugToolsSettings;
import com.sputnik.domain.entities.prefs.LoginState;
import com.sputnik.domain.entities.prefs.OnboardingSettings;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import sputnik.axmor.com.sputnik.utils.PowerUtilsKt;
import sputnik.axmor.com.sputnik.utils.permissions.PermissionsUtilsKt;

/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004*\u0002OR\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0016\u0010\u0012J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\u001cJ\u0015\u0010$\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u0004\u0018\u00010\"2\u0006\u0010&\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0010¢\u0006\u0004\b)\u0010\u0012J\r\u0010*\u001a\u00020\u0010¢\u0006\u0004\b*\u0010\u0012J\u0015\u0010,\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u000b¢\u0006\u0004\b,\u0010\u001cJ\r\u0010-\u001a\u00020\u0010¢\u0006\u0004\b-\u0010\u0012J\r\u0010.\u001a\u00020\u0010¢\u0006\u0004\b.\u0010\u0012J\r\u0010/\u001a\u00020\u0010¢\u0006\u0004\b/\u0010\u0012J\r\u00100\u001a\u00020\u0010¢\u0006\u0004\b0\u0010\u0012J\r\u00101\u001a\u00020\u0010¢\u0006\u0004\b1\u0010\u0012J\r\u00102\u001a\u00020\u0010¢\u0006\u0004\b2\u0010\u0012J\u0015\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0015\u00109\u001a\u00020\u00102\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u000207¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\r¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u0010¢\u0006\u0004\b?\u0010\u0012J\r\u0010@\u001a\u00020\u0010¢\u0006\u0004\b@\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010A\u001a\u0004\bB\u0010CR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010H\u001a\u0004\u0018\u00010G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010J\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010M\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006U"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel;", "Lcom/sputnik/common/base/BaseViewModel;", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;", "", "Landroid/app/Application;", "context", "Lcom/sputnik/data/local/PrefManager;", "prefs", "<init>", "(Landroid/app/Application;Lcom/sputnik/data/local/PrefManager;)V", "Landroid/content/Context;", "", AttributionReporter.SYSTEM_PERMISSION, "", "isPermissionGranted", "(Landroid/content/Context;Ljava/lang/String;)Z", "", "registerReceivers", "()V", "unregisterReceivers", "checkPermissionsForBle", "()Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;", "onCleared", "reloadPreferences", "getBaseUrl", "()Ljava/lang/String;", "url", "saveBaseUrl", "(Ljava/lang/String;)V", "getLastAccrualDate", "version", "updateAppVersion", FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "updateLastShowingDebtDate", "Lcom/sputnik/data/entities/cameras/CameraPreferences;", "cameraPreferences", "saveCameraPreference", "(Lcom/sputnik/data/entities/cameras/CameraPreferences;)V", "uuid", "getCameraPreferencesByCameraUuid", "(Ljava/lang/String;)Lcom/sputnik/data/entities/cameras/CameraPreferences;", "clearMarketRedPoint", "clearVisitsHistoryPopup", "it", "updateJwt", "enablePaymentsTestEnvironment", "disablePaymentsTestEnvironment", "clearOnboarding", "clearAccounts", "clearSessions", "clearSplashData", "Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;", "obj", "setDebugToolsSettings", "(Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;)V", "Lcom/sputnik/domain/entities/prefs/AppSettings;", "appSettings", "updateAppSettings", "(Lcom/sputnik/domain/entities/prefs/AppSettings;)V", "getAppSettings", "()Lcom/sputnik/domain/entities/prefs/AppSettings;", "needToShowNoPermissions", "()Z", "disableBleFeature", "needLaunchBleServiceAfterRequestingPermissions", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "Lcom/sputnik/data/local/PrefManager;", "getPrefs", "()Lcom/sputnik/data/local/PrefManager;", "Landroid/bluetooth/BluetoothManager;", "bluetoothAdapter", "Landroid/bluetooth/BluetoothManager;", "GPS_CHANGE_ACTION", "Ljava/lang/String;", "Landroid/location/LocationManager;", "locationManager", "Landroid/location/LocationManager;", "sputnik/axmor/com/sputnik/ui/settings/SettingsViewModel$gpsStateBroadcastReceiver$1", "gpsStateBroadcastReceiver", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel$gpsStateBroadcastReceiver$1;", "sputnik/axmor/com/sputnik/ui/settings/SettingsViewModel$bluetoothStateBroadcastReceiver$1", "bluetoothStateBroadcastReceiver", "Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewModel$bluetoothStateBroadcastReceiver$1;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsViewModel extends BaseViewModel<SettingsViewState> {
    private final String GPS_CHANGE_ACTION;
    private final BluetoothManager bluetoothAdapter;
    private final SettingsViewModel$bluetoothStateBroadcastReceiver$1 bluetoothStateBroadcastReceiver;
    private final Application context;
    private final SettingsViewModel$gpsStateBroadcastReceiver$1 gpsStateBroadcastReceiver;
    private final LocationManager locationManager;
    private final PrefManager prefs;

    public final PrefManager getPrefs() {
        return this.prefs;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel$gpsStateBroadcastReceiver$1] */
    /* JADX WARN: Type inference failed for: r1v8, types: [sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel$bluetoothStateBroadcastReceiver$1] */
    public SettingsViewModel(Application context, PrefManager prefs) {
        BluetoothManager bluetoothManager;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        SettingsViewState settingsViewState = new SettingsViewState(null, null, null, null, null, false, null, null, null, null, null, 2047, null);
        String name = SettingsViewModel.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        super(settingsViewState, name);
        this.context = context;
        this.prefs = prefs;
        try {
            bluetoothManager = (BluetoothManager) context.getApplicationContext().getSystemService(BluetoothManager.class);
        } catch (Exception unused) {
            bluetoothManager = null;
        }
        this.bluetoothAdapter = bluetoothManager;
        this.GPS_CHANGE_ACTION = "com.android.broadcast_listeners.LocationChangeReceiver";
        Object systemService = this.context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        this.locationManager = (LocationManager) systemService;
        this.gpsStateBroadcastReceiver = new BroadcastReceiver() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel$gpsStateBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (intent.getAction() != null) {
                    SettingsViewModel settingsViewModel = this.this$0;
                    SettingsViewState currentState = settingsViewModel.getCurrentState();
                    SettingsViewState settingsViewStateCopy = currentState.copy((1023 & 1) != 0 ? currentState.baseUrl : null, (1023 & 2) != 0 ? currentState.lastAccruedDate : null, (1023 & 4) != 0 ? currentState.appVersion : null, (1023 & 8) != 0 ? currentState.adaptiveZoomPreferences : null, (1023 & 16) != 0 ? currentState.jwt : null, (1023 & 32) != 0 ? currentState.isPaymentsEnvironmentEnabled : false, (1023 & 64) != 0 ? currentState.debugToolsSettings : null, (1023 & 128) != 0 ? currentState.appState : AppState.copy$default(currentState.getAppState(), false, settingsViewModel.locationManager.isProviderEnabled("gps"), false, null, false, false, false, 125, null), (1023 & 256) != 0 ? currentState.appSettings : null, (1023 & 512) != 0 ? currentState.needToShowNoPermissionsScreen : null, (1023 & 1024) != 0 ? currentState.needLaunchBleServiceAfterRequestingPermissions : null);
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(settingsViewModel), null, null, new SettingsViewModel$gpsStateBroadcastReceiver$1$onReceive$$inlined$updateState$1(settingsViewStateCopy, settingsViewModel, null), 3, null);
                    settingsViewModel.getState().setValue(settingsViewStateCopy);
                }
            }
        };
        this.bluetoothStateBroadcastReceiver = new BroadcastReceiver() { // from class: sputnik.axmor.com.sputnik.ui.settings.SettingsViewModel$bluetoothStateBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (StringsKt.equals$default(intent != null ? intent.getAction() : null, "android.bluetooth.adapter.action.STATE_CHANGED", false, 2, null)) {
                    Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) : null;
                    if (numValueOf != null && numValueOf.intValue() == 10) {
                        SettingsViewModel settingsViewModel = this.this$0;
                        SettingsViewState currentState = settingsViewModel.getCurrentState();
                        SettingsViewState settingsViewStateCopy = currentState.copy((1023 & 1) != 0 ? currentState.baseUrl : null, (1023 & 2) != 0 ? currentState.lastAccruedDate : null, (1023 & 4) != 0 ? currentState.appVersion : null, (1023 & 8) != 0 ? currentState.adaptiveZoomPreferences : null, (1023 & 16) != 0 ? currentState.jwt : null, (1023 & 32) != 0 ? currentState.isPaymentsEnvironmentEnabled : false, (1023 & 64) != 0 ? currentState.debugToolsSettings : null, (1023 & 128) != 0 ? currentState.appState : AppState.copy$default(currentState.getAppState(), false, false, false, null, false, false, false, 126, null), (1023 & 256) != 0 ? currentState.appSettings : null, (1023 & 512) != 0 ? currentState.needToShowNoPermissionsScreen : null, (1023 & 1024) != 0 ? currentState.needLaunchBleServiceAfterRequestingPermissions : null);
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(settingsViewModel), null, null, new SettingsViewModel$bluetoothStateBroadcastReceiver$1$onReceive$$inlined$updateState$1(settingsViewStateCopy, settingsViewModel, null), 3, null);
                        settingsViewModel.getState().setValue(settingsViewStateCopy);
                        return;
                    }
                    if (numValueOf != null && numValueOf.intValue() == 12) {
                        SettingsViewModel settingsViewModel2 = this.this$0;
                        SettingsViewState currentState2 = settingsViewModel2.getCurrentState();
                        SettingsViewState settingsViewStateCopy2 = currentState2.copy((1023 & 1) != 0 ? currentState2.baseUrl : null, (1023 & 2) != 0 ? currentState2.lastAccruedDate : null, (1023 & 4) != 0 ? currentState2.appVersion : null, (1023 & 8) != 0 ? currentState2.adaptiveZoomPreferences : null, (1023 & 16) != 0 ? currentState2.jwt : null, (1023 & 32) != 0 ? currentState2.isPaymentsEnvironmentEnabled : false, (1023 & 64) != 0 ? currentState2.debugToolsSettings : null, (1023 & 128) != 0 ? currentState2.appState : AppState.copy$default(currentState2.getAppState(), true, false, false, null, false, false, false, 126, null), (1023 & 256) != 0 ? currentState2.appSettings : null, (1023 & 512) != 0 ? currentState2.needToShowNoPermissionsScreen : null, (1023 & 1024) != 0 ? currentState2.needLaunchBleServiceAfterRequestingPermissions : null);
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(settingsViewModel2), null, null, new SettingsViewModel$bluetoothStateBroadcastReceiver$1$onReceive$$inlined$updateState$2(settingsViewStateCopy2, settingsViewModel2, null), 3, null);
                        settingsViewModel2.getState().setValue(settingsViewStateCopy2);
                        return;
                    }
                    if (numValueOf != null && numValueOf.intValue() == 13) {
                        SettingsViewModel settingsViewModel3 = this.this$0;
                        SettingsViewState currentState3 = settingsViewModel3.getCurrentState();
                        SettingsViewState settingsViewStateCopy3 = currentState3.copy((1023 & 1) != 0 ? currentState3.baseUrl : null, (1023 & 2) != 0 ? currentState3.lastAccruedDate : null, (1023 & 4) != 0 ? currentState3.appVersion : null, (1023 & 8) != 0 ? currentState3.adaptiveZoomPreferences : null, (1023 & 16) != 0 ? currentState3.jwt : null, (1023 & 32) != 0 ? currentState3.isPaymentsEnvironmentEnabled : false, (1023 & 64) != 0 ? currentState3.debugToolsSettings : null, (1023 & 128) != 0 ? currentState3.appState : AppState.copy$default(currentState3.getAppState(), true, false, false, null, false, false, false, 126, null), (1023 & 256) != 0 ? currentState3.appSettings : null, (1023 & 512) != 0 ? currentState3.needToShowNoPermissionsScreen : null, (1023 & 1024) != 0 ? currentState3.needLaunchBleServiceAfterRequestingPermissions : null);
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(settingsViewModel3), null, null, new SettingsViewModel$bluetoothStateBroadcastReceiver$1$onReceive$$inlined$updateState$3(settingsViewStateCopy3, settingsViewModel3, null), 3, null);
                        settingsViewModel3.getState().setValue(settingsViewStateCopy3);
                        return;
                    }
                    if (numValueOf != null && numValueOf.intValue() == 11) {
                        SettingsViewModel settingsViewModel4 = this.this$0;
                        SettingsViewState currentState4 = settingsViewModel4.getCurrentState();
                        SettingsViewState settingsViewStateCopy4 = currentState4.copy((1023 & 1) != 0 ? currentState4.baseUrl : null, (1023 & 2) != 0 ? currentState4.lastAccruedDate : null, (1023 & 4) != 0 ? currentState4.appVersion : null, (1023 & 8) != 0 ? currentState4.adaptiveZoomPreferences : null, (1023 & 16) != 0 ? currentState4.jwt : null, (1023 & 32) != 0 ? currentState4.isPaymentsEnvironmentEnabled : false, (1023 & 64) != 0 ? currentState4.debugToolsSettings : null, (1023 & 128) != 0 ? currentState4.appState : AppState.copy$default(currentState4.getAppState(), true, false, false, null, false, false, false, 126, null), (1023 & 256) != 0 ? currentState4.appSettings : null, (1023 & 512) != 0 ? currentState4.needToShowNoPermissionsScreen : null, (1023 & 1024) != 0 ? currentState4.needLaunchBleServiceAfterRequestingPermissions : null);
                        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(settingsViewModel4), null, null, new SettingsViewModel$bluetoothStateBroadcastReceiver$1$onReceive$$inlined$updateState$4(settingsViewStateCopy4, settingsViewModel4, null), 3, null);
                        settingsViewModel4.getState().setValue(settingsViewStateCopy4);
                    }
                }
            }
        };
        registerReceivers();
        reloadPreferences();
    }

    public final SettingsViewState checkPermissionsForBle() {
        boolean zIsPermissionGranted;
        List listMutableListOf = CollectionsKt.mutableListOf("android.permission.ACCESS_FINE_LOCATION");
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            listMutableListOf.add("android.permission.BLUETOOTH_SCAN");
        }
        if (i >= 29) {
            listMutableListOf.add(LocationConstant.BACKGROUND_PERMISSION);
        }
        SettingsViewState currentState = getCurrentState();
        if (i < 29) {
            zIsPermissionGranted = isPermissionGranted(this.context, "android.permission.ACCESS_FINE_LOCATION");
            BlePermissions blePermissions = currentState.getAppState().getBlePermissions();
            blePermissions.setLocationPermission(new PermissionItem("android.permission.ACCESS_FINE_LOCATION", zIsPermissionGranted, true));
            blePermissions.setNearbyDevicesPermission(new PermissionItem("android.permission.BLUETOOTH_SCAN", true, false));
        } else if (29 <= i && i < 31) {
            zIsPermissionGranted = isPermissionGranted(this.context, LocationConstant.BACKGROUND_PERMISSION);
            BlePermissions blePermissions2 = currentState.getAppState().getBlePermissions();
            blePermissions2.setBackgroundLocationPermission(new PermissionItem(LocationConstant.BACKGROUND_PERMISSION, zIsPermissionGranted, true));
            blePermissions2.setNearbyDevicesPermission(new PermissionItem("android.permission.BLUETOOTH_SCAN", true, false));
            blePermissions2.setLocationPermission(new PermissionItem("android.permission.ACCESS_FINE_LOCATION", true, false));
        } else {
            if (31 <= i && i < 41) {
                boolean zIsPermissionGranted2 = isPermissionGranted(this.context, LocationConstant.BACKGROUND_PERMISSION);
                boolean zIsPermissionGranted3 = isPermissionGranted(this.context, "android.permission.BLUETOOTH_SCAN");
                boolean z = zIsPermissionGranted2 && zIsPermissionGranted3;
                boolean z2 = i >= 33;
                boolean zIsPermissionGranted4 = isPermissionGranted(this.context, "android.permission.POST_NOTIFICATIONS");
                if (z2 && !zIsPermissionGranted4) {
                    z = false;
                }
                BlePermissions blePermissions3 = currentState.getAppState().getBlePermissions();
                blePermissions3.setBackgroundLocationPermission(new PermissionItem(LocationConstant.BACKGROUND_PERMISSION, zIsPermissionGranted2, true));
                blePermissions3.setNearbyDevicesPermission(new PermissionItem("android.permission.BLUETOOTH_SCAN", zIsPermissionGranted3, true));
                blePermissions3.setLocationPermission(new PermissionItem("android.permission.ACCESS_FINE_LOCATION", true, false));
                blePermissions3.setNotificationsPermission(new PermissionItem("android.permission.POST_NOTIFICATIONS", z2 ? zIsPermissionGranted4 : true, z2));
                z = z;
            }
            currentState.getAppState().setBlePermissionsGranted(z);
            return currentState;
        }
        z = zIsPermissionGranted;
        currentState.getAppState().setBlePermissionsGranted(z);
        return currentState;
    }

    public final void needLaunchBleServiceAfterRequestingPermissions() {
        SettingsViewState currentState = getCurrentState();
        SettingsViewState settingsViewStateCopy = currentState.copy((1023 & 1) != 0 ? currentState.baseUrl : null, (1023 & 2) != 0 ? currentState.lastAccruedDate : null, (1023 & 4) != 0 ? currentState.appVersion : null, (1023 & 8) != 0 ? currentState.adaptiveZoomPreferences : null, (1023 & 16) != 0 ? currentState.jwt : null, (1023 & 32) != 0 ? currentState.isPaymentsEnvironmentEnabled : false, (1023 & 64) != 0 ? currentState.debugToolsSettings : null, (1023 & 128) != 0 ? currentState.appState : null, (1023 & 256) != 0 ? currentState.appSettings : null, (1023 & 512) != 0 ? currentState.needToShowNoPermissionsScreen : null, (1023 & 1024) != 0 ? currentState.needLaunchBleServiceAfterRequestingPermissions : new Event(Boolean.TRUE));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SettingsViewModel$needLaunchBleServiceAfterRequestingPermissions$$inlined$updateState$1(settingsViewStateCopy, this, null), 3, null);
        getState().setValue(settingsViewStateCopy);
    }

    private final boolean isPermissionGranted(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == 0;
    }

    private final void registerReceivers() {
        this.context.registerReceiver(this.bluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        this.context.getApplicationContext().registerReceiver(this.gpsStateBroadcastReceiver, new IntentFilter("android.location.PROVIDERS_CHANGED"));
    }

    private final void unregisterReceivers() {
        this.context.unregisterReceiver(this.bluetoothStateBroadcastReceiver);
        this.context.unregisterReceiver(this.gpsStateBroadcastReceiver);
    }

    @Override // com.sputnik.common.base.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        unregisterReceivers();
    }

    public void reloadPreferences() {
        BluetoothAdapter adapter;
        SettingsViewState settingsViewStateCheckPermissionsForBle = checkPermissionsForBle();
        boolean z = System.currentTimeMillis() - this.prefs.getOnboardingSettings().getLastShowingNoBlePermissionsBottomSheetTimestamp() > 86400000 || this.prefs.getOnboardingSettings().getLastShowingNoBlePermissionsBottomSheetTimestamp() == 0;
        String baseUrl = getBaseUrl();
        String lastAccrualDate = getLastAccrualDate();
        String appVersion = this.prefs.getAppVersion();
        String jwtToken = this.prefs.getJwtToken();
        boolean isTestEnvironmentForPaymentsEnabled = this.prefs.getIsTestEnvironmentForPaymentsEnabled();
        DebugToolsSettings debugToolsSettingsM2507getDebugToolsSettings = this.prefs.m2507getDebugToolsSettings();
        AppState appState = settingsViewStateCheckPermissionsForBle.getAppState();
        BluetoothManager bluetoothManager = this.bluetoothAdapter;
        SettingsViewState settingsViewStateCopy = settingsViewStateCheckPermissionsForBle.copy((1023 & 1) != 0 ? settingsViewStateCheckPermissionsForBle.baseUrl : baseUrl, (1023 & 2) != 0 ? settingsViewStateCheckPermissionsForBle.lastAccruedDate : lastAccrualDate, (1023 & 4) != 0 ? settingsViewStateCheckPermissionsForBle.appVersion : appVersion, (1023 & 8) != 0 ? settingsViewStateCheckPermissionsForBle.adaptiveZoomPreferences : null, (1023 & 16) != 0 ? settingsViewStateCheckPermissionsForBle.jwt : jwtToken, (1023 & 32) != 0 ? settingsViewStateCheckPermissionsForBle.isPaymentsEnvironmentEnabled : isTestEnvironmentForPaymentsEnabled, (1023 & 64) != 0 ? settingsViewStateCheckPermissionsForBle.debugToolsSettings : debugToolsSettingsM2507getDebugToolsSettings, (1023 & 128) != 0 ? settingsViewStateCheckPermissionsForBle.appState : AppState.copy$default(appState, (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null) ? false : adapter.isEnabled(), this.locationManager.isProviderEnabled("gps"), false, null, PowerUtilsKt.isIgnoringBatteryOptimizations(this.context), false, PermissionsUtilsKt.isDisplayOverOtherAppsGranted(this.context), 44, null), (1023 & 256) != 0 ? settingsViewStateCheckPermissionsForBle.appSettings : getAppSettings(), (1023 & 512) != 0 ? settingsViewStateCheckPermissionsForBle.needToShowNoPermissionsScreen : new Event(Boolean.valueOf(needToShowNoPermissions() && z)), (1023 & 1024) != 0 ? settingsViewStateCheckPermissionsForBle.needLaunchBleServiceAfterRequestingPermissions : null);
        getCurrentState();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SettingsViewModel$reloadPreferences$$inlined$updateState$1(settingsViewStateCopy, this, null), 3, null);
        getState().setValue(settingsViewStateCopy);
    }

    public String getBaseUrl() {
        return this.prefs.getBaseUrl();
    }

    public void saveBaseUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.prefs.updateBaseUrl(url);
    }

    public String getLastAccrualDate() {
        return this.prefs.getLastAccruedDate();
    }

    public void updateAppVersion(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        this.prefs.updateAppVersion(version);
        reloadPreferences();
    }

    public void updateLastShowingDebtDate(String date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.prefs.setLastAccruedDate(date);
    }

    public final void saveCameraPreference(CameraPreferences cameraPreferences) {
        Intrinsics.checkNotNullParameter(cameraPreferences, "cameraPreferences");
        this.prefs.saveZoom(cameraPreferences);
    }

    public final CameraPreferences getCameraPreferencesByCameraUuid(String uuid) {
        Object next;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Iterator<T> it = this.prefs.getCameraPreferences().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((CameraPreferences) next).getUuid(), uuid)) {
                break;
            }
        }
        return (CameraPreferences) next;
    }

    public final void clearMarketRedPoint() {
        this.prefs.saveMarketRedPointPreferences(MarketRedPointPreferences.INSTANCE.m2506default());
    }

    public final void clearVisitsHistoryPopup() {
        this.prefs.updateCallHistoryBottomSheetShowed(false);
    }

    public final void updateJwt(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.prefs.updateJwtToken(it);
    }

    public final void enablePaymentsTestEnvironment() {
        this.prefs.setIsTestEnvironmentForPaymentsEnabled(true);
    }

    public final void disablePaymentsTestEnvironment() {
        this.prefs.setIsTestEnvironmentForPaymentsEnabled(false);
    }

    public final void clearOnboarding() {
        this.prefs.setOnboardingSettings(new OnboardingSettings(0L, 0L, 0L, false, false, null, null, null, false, false, 1023, null));
        PrefManager prefManager = this.prefs;
        prefManager.saveMarketRedPointPreferences(new MarketRedPointPreferences(prefManager.m2508getMarketRedPointPreferences().getIsMarketAvailable() != null ? Boolean.valueOf(!r2.booleanValue()) : null, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
    }

    public final void clearAccounts() {
        this.prefs.setLoginState(new LoginState((String) null, (Long) null, (String) null, false, (Long) null, (RegistrationWay) null, (List) new ArrayList(), 32, (DefaultConstructorMarker) null));
    }

    public final void clearSessions() {
        LoginState loginState = this.prefs.getLoginState();
        List<LoginState.Session> sessions = loginState.getSessions();
        if (sessions != null) {
            Iterator<T> it = sessions.iterator();
            while (it.hasNext()) {
                ((LoginState.Session) it.next()).setAddresses(CollectionsKt.emptyList());
            }
        }
        this.prefs.setLoginState(loginState);
    }

    public final void clearSplashData() {
        PrefManager prefManager = this.prefs;
        LoginState loginState = prefManager.getLoginState();
        List<LoginState.Session> sessions = loginState.getSessions();
        if (sessions != null) {
            int i = 0;
            for (Object obj : sessions) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                List<LoginState.Session> sessions2 = loginState.getSessions();
                LoginState.Session session = sessions2 != null ? sessions2.get(i) : null;
                if (session != null) {
                    session.setProfileSettings(null);
                }
                i = i2;
            }
        }
        prefManager.setLoginState(loginState);
    }

    public final void setDebugToolsSettings(DebugToolsSettings obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.prefs.setDebugToolsSettings(obj);
    }

    public final void updateAppSettings(AppSettings appSettings) {
        Boolean enabled;
        Integer rssiMin;
        Integer rssiMax;
        Integer rssiOptimal;
        Boolean blePromoEnabled;
        Intrinsics.checkNotNullParameter(appSettings, "appSettings");
        AppSettings appSettings2 = this.prefs.getAppSettings();
        AppSettings.BleSettings bleSettings = appSettings2.getBleSettings();
        AppSettings.BleSettings bleSettings2 = appSettings.getBleSettings();
        if (bleSettings2 == null || (enabled = bleSettings2.getEnabled()) == null) {
            enabled = appSettings2.getBleSettings().getEnabled();
        }
        AppSettings.BleSettings bleSettings3 = appSettings.getBleSettings();
        if (bleSettings3 == null || (rssiMin = bleSettings3.getRssiMin()) == null) {
            rssiMin = appSettings2.getBleSettings().getRssiMin();
        }
        AppSettings.BleSettings bleSettings4 = appSettings.getBleSettings();
        if (bleSettings4 == null || (rssiMax = bleSettings4.getRssiMax()) == null) {
            rssiMax = appSettings2.getBleSettings().getRssiMax();
        }
        AppSettings.BleSettings bleSettings5 = appSettings.getBleSettings();
        if (bleSettings5 == null || (rssiOptimal = bleSettings5.getRssiOptimal()) == null) {
            rssiOptimal = appSettings2.getBleSettings().getRssiOptimal();
        }
        AppSettings.BleSettings bleSettings6 = appSettings.getBleSettings();
        if (bleSettings6 == null || (blePromoEnabled = bleSettings6.getBlePromoEnabled()) == null) {
            AppSettings.BleSettings bleSettings7 = appSettings2.getBleSettings();
            blePromoEnabled = bleSettings7 != null ? bleSettings7.getBlePromoEnabled() : null;
        }
        AppSettings.BleSettings bleSettingsCopy$default = AppSettings.BleSettings.copy$default(bleSettings, enabled, rssiMin, rssiMax, rssiOptimal, blePromoEnabled, null, 32, null);
        Boolean permissionsRequested = appSettings.getPermissionsRequested();
        this.prefs.updateAppSettings(appSettings2.copy(bleSettingsCopy$default, Boolean.valueOf((permissionsRequested == null && (permissionsRequested = appSettings2.getPermissionsRequested()) == null) ? false : permissionsRequested.booleanValue())));
        SettingsViewState currentState = getCurrentState();
        SettingsViewState settingsViewStateCopy = currentState.copy((1023 & 1) != 0 ? currentState.baseUrl : null, (1023 & 2) != 0 ? currentState.lastAccruedDate : null, (1023 & 4) != 0 ? currentState.appVersion : null, (1023 & 8) != 0 ? currentState.adaptiveZoomPreferences : null, (1023 & 16) != 0 ? currentState.jwt : null, (1023 & 32) != 0 ? currentState.isPaymentsEnvironmentEnabled : false, (1023 & 64) != 0 ? currentState.debugToolsSettings : null, (1023 & 128) != 0 ? currentState.appState : null, (1023 & 256) != 0 ? currentState.appSettings : getAppSettings(), (1023 & 512) != 0 ? currentState.needToShowNoPermissionsScreen : null, (1023 & 1024) != 0 ? currentState.needLaunchBleServiceAfterRequestingPermissions : null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SettingsViewModel$updateAppSettings$$inlined$updateState$1(settingsViewStateCopy, this, null), 3, null);
        getState().setValue(settingsViewStateCopy);
    }

    public final AppSettings getAppSettings() {
        return this.prefs.getAppSettings();
    }

    public final boolean needToShowNoPermissions() {
        Boolean enabled = getCurrentState().getAppSettings().getBleSettings().getEnabled();
        if (enabled != null ? enabled.booleanValue() : false) {
            return (getCurrentState().getAppState().getBlePermissionsGranted() && getCurrentState().getAppState().getGpsEnabled() && getCurrentState().getAppState().getBluetoothEnabled()) ? false : true;
        }
        return false;
    }

    public final void disableBleFeature() {
        AppSettings appSettings = this.prefs.getAppSettings();
        this.prefs.updateAppSettings(AppSettings.copy$default(appSettings, AppSettings.BleSettings.copy$default(appSettings.getBleSettings(), Boolean.FALSE, null, null, null, null, null, 62, null), null, 2, null));
    }
}
