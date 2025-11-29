package bz;

import android.content.Context;
import android.provider.Settings;
import java.io.Serializable;

/* renamed from: bz.n0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0537n0 extends AbstractC0538n1 {
    public final Context c;

    public C0537n0(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.OS_ID);
        this.c = context;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return Settings.Secure.getString(this.c.getContentResolver(), "android_id");
    }
}
