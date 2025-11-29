package bz;

import android.content.Context;
import android.provider.Settings;
import java.io.Serializable;

/* renamed from: bz.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0559v extends AbstractC0538n1 {
    public final Context c;

    public C0559v(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.AccessibilityServices);
        this.c = context;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return new zone.bi.mobile.fingerprint.api.serialize.model.a();
    }

    @Override // bz.AbstractC0538n1
    public final Serializable i() throws C0564w1 {
        zone.bi.mobile.fingerprint.api.serialize.model.a aVar = (zone.bi.mobile.fingerprint.api.serialize.model.a) super.i();
        if (aVar != null) {
            try {
                boolean z = Settings.Secure.getInt(this.c.getApplicationContext().getContentResolver(), "accessibility_enabled") == 1;
                String string = z ? Settings.Secure.getString(this.c.getApplicationContext().getContentResolver(), "enabled_accessibility_services") : null;
                aVar.put("enabled", Boolean.valueOf(z));
                if (!(string == null || string.length() == 0)) {
                    aVar.put("packages", string);
                }
            } catch (Settings.SettingNotFoundException e) {
                throw new C0564w1(e.getMessage());
            }
        }
        return aVar;
    }
}
