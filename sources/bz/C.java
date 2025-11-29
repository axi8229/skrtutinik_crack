package bz;

import android.os.Build;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class C extends AbstractC0538n1 {
    public C() {
        super(zone.bi.mobile.fingerprint.api.f.DeviceSystemVersion);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }
}
