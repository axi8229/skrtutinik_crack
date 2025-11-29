package bz;

import android.content.Context;
import android.provider.Settings;
import java.io.Serializable;

/* renamed from: bz.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0512f0 extends AbstractC0538n1 {
    public final Context c;

    public C0512f0(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.DeveloperTools);
        this.c = context;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0564w1 {
        int i = Settings.Secure.getInt(this.c.getContentResolver(), "development_settings_enabled", 0);
        if (i == 1 || i == 0) {
            return Integer.valueOf(i);
        }
        throw new C0564w1("Unknown result state: " + i);
    }
}
