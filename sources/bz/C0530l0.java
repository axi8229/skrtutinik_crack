package bz;

import android.content.Context;
import android.provider.Settings;
import java.io.Serializable;

/* renamed from: bz.l0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0530l0 extends AbstractC0538n1 {
    public final Context c;

    public C0530l0(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.BootCount);
        this.c = context;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws C0564w1 {
        try {
            return Integer.valueOf(Settings.Global.getInt(this.c.getContentResolver(), "boot_count"));
        } catch (Settings.SettingNotFoundException e) {
            throw new C0564w1(e.getMessage());
        }
    }
}
