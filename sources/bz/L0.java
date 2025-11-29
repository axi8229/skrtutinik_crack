package bz;

import android.os.Build;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class L0 extends AbstractC0538n1 {
    public L0() {
        super(zone.bi.mobile.fingerprint.api.f.SupportedAPILevel);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }
}
