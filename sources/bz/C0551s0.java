package bz;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Iterator;
import java.util.Set;

/* renamed from: bz.s0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0551s0 {
    public final PackageManager a;

    public C0551s0(Context context) {
        this.a = context.getPackageManager();
    }

    public final boolean a(Set set) {
        Iterator<PackageInfo> it = this.a.getInstalledPackages(128).iterator();
        while (it.hasNext()) {
            if (set.contains(it.next().packageName)) {
                return true;
            }
        }
        return false;
    }
}
