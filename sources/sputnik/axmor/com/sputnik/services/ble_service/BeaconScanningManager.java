package sputnik.axmor.com.sputnik.services.ble_service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager;

/* compiled from: BeaconScanningManager.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0002\u001d+\u0018\u00002\u00020\u0001:\u0002./B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\rJ\u000f\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\rJ\r\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\rJ\r\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00060"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager;", "", "Landroid/content/Context;", "context", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$ScanResultsListener;", "scanResultsListener", "", "Lsputnik/axmor/com/sputnik/services/ble_service/ScanParameters;", "scanParameters", "<init>", "(Landroid/content/Context;Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$ScanResultsListener;Ljava/util/List;)V", "", "init", "()V", "Landroid/bluetooth/le/ScanSettings;", "getDefaultScanSettings", "()Landroid/bluetooth/le/ScanSettings;", "Ljava/util/ArrayList;", "Landroid/bluetooth/le/ScanFilter;", "getScanFilters", "()Ljava/util/ArrayList;", "doStartTracking", "restartScan", "doStopTracking", "startTracking", "stopTracking", "Landroid/content/Context;", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$ScanResultsListener;", "Ljava/util/List;", "sputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$bluetoothStateBroadcastReceiver$1", "bluetoothStateBroadcastReceiver", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$bluetoothStateBroadcastReceiver$1;", "Ljava/util/Timer;", "scannerTimer", "Ljava/util/Timer;", "Landroid/bluetooth/BluetoothManager;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "Landroid/bluetooth/le/BluetoothLeScanner;", "bluetoothAdapter", "Landroid/bluetooth/le/BluetoothLeScanner;", "scanSettings", "Landroid/bluetooth/le/ScanSettings;", "sputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$beaconScanCallback$1", "beaconScanCallback", "Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$beaconScanCallback$1;", "RestartScanningTimerTask", "ScanResultsListener", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BeaconScanningManager {
    private final BeaconScanningManager$beaconScanCallback$1 beaconScanCallback;
    private BluetoothLeScanner bluetoothAdapter;
    private BluetoothManager bluetoothManager;
    private final BeaconScanningManager$bluetoothStateBroadcastReceiver$1 bluetoothStateBroadcastReceiver;
    private Context context;
    private final List<ScanParameters> scanParameters;
    private ScanResultsListener scanResultsListener;
    private ScanSettings scanSettings;
    private Timer scannerTimer;

    /* compiled from: BeaconScanningManager.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&¨\u0006\r"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$ScanResultsListener;", "", "onBluetoothStateChanged", "", "isEnabled", "", "onIntercomFound", "serial", "", "rssi", "", "onScanError", "errorCode", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ScanResultsListener {
        void onBluetoothStateChanged(boolean isEnabled);

        void onIntercomFound(String serial, int rssi);

        void onScanError(int errorCode);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager$bluetoothStateBroadcastReceiver$1] */
    public BeaconScanningManager(Context context, ScanResultsListener scanResultsListener, List<ScanParameters> scanParameters) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scanResultsListener, "scanResultsListener");
        Intrinsics.checkNotNullParameter(scanParameters, "scanParameters");
        this.context = context;
        this.scanResultsListener = scanResultsListener;
        this.scanParameters = scanParameters;
        this.bluetoothStateBroadcastReceiver = new BroadcastReceiver() { // from class: sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager$bluetoothStateBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (StringsKt.equals$default(intent != null ? intent.getAction() : null, "android.bluetooth.adapter.action.STATE_CHANGED", false, 2, null)) {
                    Integer numValueOf = intent != null ? Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) : null;
                    if (numValueOf != null && numValueOf.intValue() == 10) {
                        BeaconScanningManager.ScanResultsListener scanResultsListener2 = this.this$0.scanResultsListener;
                        if (scanResultsListener2 != null) {
                            scanResultsListener2.onBluetoothStateChanged(false);
                            return;
                        }
                        return;
                    }
                    if ((numValueOf != null && numValueOf.intValue() == 13) || numValueOf == null || numValueOf.intValue() != 12) {
                        return;
                    }
                    BeaconScanningManager.ScanResultsListener scanResultsListener3 = this.this$0.scanResultsListener;
                    if (scanResultsListener3 != null) {
                        scanResultsListener3.onBluetoothStateChanged(true);
                    }
                    this.this$0.restartScan();
                }
            }
        };
        this.scanSettings = getDefaultScanSettings();
        this.beaconScanCallback = new BeaconScanningManager$beaconScanCallback$1(this);
        init();
    }

    /* compiled from: BeaconScanningManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$RestartScanningTimerTask;", "Ljava/util/TimerTask;", "(Lsputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager;)V", "run", "", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class RestartScanningTimerTask extends TimerTask {
        public RestartScanningTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            BeaconScanningManager.this.restartScan();
        }
    }

    public final void startTracking() {
        doStartTracking();
    }

    public final void stopTracking() {
        doStopTracking();
    }

    private final void init() throws Exception {
        BluetoothAdapter adapter;
        Object systemService = this.context.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.bluetoothManager = (BluetoothManager) systemService;
        this.scannerTimer = new Timer();
        try {
            BluetoothManager bluetoothManager = this.bluetoothManager;
            BluetoothLeScanner bluetoothLeScanner = null;
            if ((bluetoothManager != null ? bluetoothManager.getAdapter() : null) != null) {
                BluetoothManager bluetoothManager2 = this.bluetoothManager;
                if (bluetoothManager2 != null && (adapter = bluetoothManager2.getAdapter()) != null) {
                    bluetoothLeScanner = adapter.getBluetoothLeScanner();
                }
                this.bluetoothAdapter = bluetoothLeScanner;
                return;
            }
            this.beaconScanCallback.onScanFailed(10);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private final ScanSettings getDefaultScanSettings() {
        ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).setCallbackType(1).setMatchMode(1).setNumOfMatches(3).setReportDelay(0L).build();
        Intrinsics.checkNotNull(scanSettingsBuild);
        return scanSettingsBuild;
    }

    private final ArrayList<ScanFilter> getScanFilters() {
        ScanFilter scanFilterBuild = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString("0000fff2-0000-1000-8000-00805f9b34fb")).build();
        Intrinsics.checkNotNullExpressionValue(scanFilterBuild, "build(...)");
        ScanFilter scanFilterBuild2 = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString("0000fff1-0000-1000-8000-00805f9b34fb")).build();
        Intrinsics.checkNotNullExpressionValue(scanFilterBuild2, "build(...)");
        ScanFilter scanFilterBuild3 = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString("0000fff0-0000-1000-8000-00805f9b34fb")).build();
        Intrinsics.checkNotNullExpressionValue(scanFilterBuild3, "build(...)");
        ScanFilter scanFilterBuild4 = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString("67f0728c-19bd-4170-8203-ec14c9335d80")).build();
        Intrinsics.checkNotNullExpressionValue(scanFilterBuild4, "build(...)");
        return CollectionsKt.arrayListOf(scanFilterBuild, scanFilterBuild2, scanFilterBuild3, scanFilterBuild4);
    }

    private final void doStartTracking() {
        BluetoothAdapter adapter;
        try {
            BluetoothManager bluetoothManager = this.bluetoothManager;
            if (bluetoothManager != null && (adapter = bluetoothManager.getAdapter()) != null && adapter.isEnabled()) {
                BluetoothLeScanner bluetoothLeScanner = this.bluetoothAdapter;
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.startScan(getScanFilters(), this.scanSettings, this.beaconScanCallback);
                }
                Timer timer = this.scannerTimer;
                if (timer != null) {
                    timer.purge();
                }
                Timer timer2 = this.scannerTimer;
                if (timer2 != null) {
                    timer2.schedule(new RestartScanningTimerTask(), 420000L, 420000L);
                }
                this.context.registerReceiver(this.bluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                return;
            }
            this.beaconScanCallback.onScanFailed(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restartScan() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: sputnik.axmor.com.sputnik.services.ble_service.BeaconScanningManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BeaconScanningManager.restartScan$lambda$1(this.f$0);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restartScan$lambda$1(BeaconScanningManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            BluetoothLeScanner bluetoothLeScanner = this$0.bluetoothAdapter;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this$0.beaconScanCallback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            BluetoothLeScanner bluetoothLeScanner2 = this$0.bluetoothAdapter;
            if (bluetoothLeScanner2 != null) {
                bluetoothLeScanner2.startScan(this$0.getScanFilters(), this$0.getDefaultScanSettings(), this$0.beaconScanCallback);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void doStopTracking() {
        try {
            BluetoothLeScanner bluetoothLeScanner = this.bluetoothAdapter;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this.beaconScanCallback);
            }
            Timer timer = this.scannerTimer;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = this.scannerTimer;
            if (timer2 != null) {
                timer2.purge();
            }
            this.context.unregisterReceiver(this.bluetoothStateBroadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
