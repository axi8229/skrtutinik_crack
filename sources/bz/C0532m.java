package bz;

import android.os.Build;
import java.io.Serializable;
import java.util.Locale;

/* renamed from: bz.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0532m extends AbstractC0538n1 {
    public C0532m() {
        super(zone.bi.mobile.fingerprint.api.f.AgentBrand);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        Locale locale = Locale.ROOT;
        return str2.toLowerCase(locale).startsWith(str.toLowerCase(locale)) ? AbstractC0566x0.a(str2) : AbstractC0566x0.a(str);
    }
}
