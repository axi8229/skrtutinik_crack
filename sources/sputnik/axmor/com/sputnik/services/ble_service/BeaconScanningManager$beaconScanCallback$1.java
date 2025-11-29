package sputnik.axmor.com.sputnik.services.ble_service;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.util.SparseArray;
import androidx.core.content.ContextCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BeaconScanningManager.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, d2 = {"sputnik/axmor/com/sputnik/services/ble_service/BeaconScanningManager$beaconScanCallback$1", "Landroid/bluetooth/le/ScanCallback;", "onBatchScanResults", "", "results", "", "Landroid/bluetooth/le/ScanResult;", "onScanFailed", "errorCode", "", "onScanResult", "callbackType", "result", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BeaconScanningManager$beaconScanCallback$1 extends ScanCallback {
    final /* synthetic */ BeaconScanningManager this$0;

    @Override // android.bluetooth.le.ScanCallback
    public void onBatchScanResults(List<ScanResult> results) {
    }

    BeaconScanningManager$beaconScanCallback$1(BeaconScanningManager beaconScanningManager) {
        this.this$0 = beaconScanningManager;
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanFailed(int errorCode) {
        BluetoothAdapter adapter;
        this.this$0.scanResultsListener.onScanError(errorCode);
        if (errorCode == 2 && ContextCompat.checkSelfPermission(this.this$0.context, "android.permission.BLUETOOTH_CONNECT") == 0) {
            BluetoothManager bluetoothManager = this.this$0.bluetoothManager;
            if (bluetoothManager != null && (adapter = bluetoothManager.getAdapter()) != null) {
                adapter.disable();
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new BeaconScanningManager$beaconScanCallback$1$onScanFailed$1(this.this$0, null), 3, null);
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(int callbackType, ScanResult result) {
        ScanRecord scanRecord;
        String manufacturerSpecificData;
        if (result == null || (scanRecord = result.getScanRecord()) == null) {
            return;
        }
        BeaconScanningManager beaconScanningManager = this.this$0;
        byte[] bytes = scanRecord.getBytes();
        int rssi = result.getRssi();
        if (bytes != null) {
            ScanRecord scanRecord2 = result.getScanRecord();
            SparseArray<byte[]> manufacturerSpecificData2 = scanRecord2 != null ? scanRecord2.getManufacturerSpecificData() : null;
            if (manufacturerSpecificData2 != null && manufacturerSpecificData2.size() != 0) {
                manufacturerSpecificData = HexUtilsKt.parseManufacturerSpecificData(manufacturerSpecificData2);
            } else {
                manufacturerSpecificData = "";
            }
            if (manufacturerSpecificData == null || Intrinsics.areEqual(manufacturerSpecificData, "0") || StringsKt.isBlank(manufacturerSpecificData)) {
                return;
            }
            beaconScanningManager.scanResultsListener.onIntercomFound(manufacturerSpecificData, rssi);
        }
    }
}
