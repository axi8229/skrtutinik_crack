package bz;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class O extends AbstractC0538n1 {
    public final BluetoothAdapter c;
    public final Context d;

    public O(Context context, BluetoothAdapter bluetoothAdapter) {
        super(zone.bi.mobile.fingerprint.api.f.DeviceName);
        this.d = context;
        this.c = bluetoothAdapter;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws e2 {
        if (Build.VERSION.SDK_INT >= 31 && !K0.a(this.d, "android.permission.BLUETOOTH_CONNECT")) {
            throw new e2("Permission BLUETOOTH_CONNECT was not granted");
        }
        BluetoothAdapter bluetoothAdapter = this.c;
        if (bluetoothAdapter == null) {
            throw new e2("mBluetoothAdapter == null");
        }
        String name = bluetoothAdapter.getName();
        if (name != null) {
            return name;
        }
        throw new e2("deviceName == null");
    }

    @Override // bz.AbstractC0538n1
    public final Serializable i() {
        try {
            return (String) super.i();
        } catch (e2 unused) {
            return "";
        }
    }
}
