package bz;

import android.content.Context;
import java.io.Serializable;

/* renamed from: bz.r0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0548r0 extends AbstractC0538n1 {
    public final Context c;
    public volatile String d;

    public C0548r0(Context context) {
        super(zone.bi.mobile.fingerprint.api.f.InstallationSource);
        this.c = context;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() throws e2 {
        if (this.d == null) {
            this.d = this.c.getPackageManager().getInstallerPackageName(this.c.getPackageName());
            if (this.d == null) {
                throw new e2("pkg == null");
            }
        }
        return this.d;
    }
}
