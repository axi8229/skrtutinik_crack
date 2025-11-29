package bz;

import java.io.Serializable;
import java.util.Locale;

/* loaded from: classes.dex */
public final class G0 extends AbstractC0538n1 {
    public G0() {
        super(zone.bi.mobile.fingerprint.api.f.Languages);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return Locale.getDefault().toString();
    }
}
