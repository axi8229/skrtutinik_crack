package bz;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import java.io.Serializable;

/* renamed from: bz.s1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0552s1 extends AbstractC0538n1 {
    public final Context c;

    public C0552s1(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.UnknownSources);
        this.c = context;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0564w1 {
        if (Build.VERSION.SDK_INT >= 26) {
            throw new C0564w1("Build.VERSION.SDK_INT >= Build.VERSION_CODES.O");
        }
        try {
            return Integer.valueOf(Settings.Secure.getInt(this.c.getContentResolver(), "install_non_market_apps"));
        } catch (Settings.SettingNotFoundException e) {
            throw new C0564w1(e.getMessage(), e);
        }
    }
}
