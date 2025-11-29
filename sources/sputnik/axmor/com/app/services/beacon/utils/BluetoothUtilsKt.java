package sputnik.axmor.com.app.services.beacon.utils;

import android.bluetooth.BluetoothAdapter;
import kotlin.Metadata;

/* compiled from: BluetoothUtils.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"isBluetoothEnabled", "", "app_huaweiRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BluetoothUtilsKt {
    public static final boolean isBluetoothEnabled() {
        try {
            return BluetoothAdapter.getDefaultAdapter().isEnabled();
        } catch (Exception unused) {
            return false;
        }
    }
}
