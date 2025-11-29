package bz;

import android.os.Build;
import java.io.Serializable;

/* renamed from: bz.k1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0528k1 extends AbstractC0538n1 {
    public C0528k1() {
        super(zone.bi.mobile.fingerprint.api.f.DeviceModel);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return AbstractC0566x0.a(Build.MODEL);
    }
}
