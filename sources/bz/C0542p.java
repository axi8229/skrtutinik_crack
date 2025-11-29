package bz;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.Serializable;
import java.util.concurrent.Callable;

/* renamed from: bz.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0542p extends AbstractC0538n1 implements P1 {
    public final Context c;
    public final zone.bi.mobile.fingerprint.api.settings.a d;
    public volatile String e;
    public volatile String f;

    public C0542p(Context context, zone.bi.mobile.fingerprint.api.settings.a aVar) {
        super(zone.bi.mobile.fingerprint.api.f.AgentAppInfo);
        this.c = context;
        this.d = aVar;
    }

    @Override // bz.P1
    /* renamed from: b */
    public final zone.bi.mobile.fingerprint.api.settings.a mo2257b() {
        return this.d;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return n() + " " + o() + " " + Build.CPU_ABI;
    }

    public final /* synthetic */ String l() {
        try {
            return this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public final /* synthetic */ String m() {
        ApplicationInfo applicationInfo = this.c.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? this.c.getPackageManager().getApplicationLabel(applicationInfo).toString() : this.c.getString(i);
    }

    public final String n() {
        if (this.e == null) {
            this.e = (String) a(new Callable() { // from class: bz.p$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.m();
                }
            });
        }
        return this.e;
    }

    public final String o() {
        if (this.f == null) {
            this.f = (String) a(new Callable() { // from class: bz.p$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.l();
                }
            });
        }
        return this.f;
    }
}
