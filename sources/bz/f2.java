package bz;

import android.content.Context;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class f2 extends AbstractC0538n1 {
    public final Context c;

    public f2(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.ScreenColorDepth);
        this.c = context;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        double d = this.c.getResources().getDisplayMetrics().density;
        return d >= 4.0d ? "~640 dpi" : d >= 3.0d ? "~480 dpi" : d >= 2.0d ? "~320 dpi" : d >= 1.5d ? "~240 dpi" : d >= 1.0d ? "~160 dpi" : "~120 dpi";
    }
}
