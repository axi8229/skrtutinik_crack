package bz;

import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class T1 {
    public final LinkedBlockingQueue a = new LinkedBlockingQueue(512);

    public final void a(zone.bi.mobile.fingerprint.api.g gVar, String str, int i) {
        S1 s1 = new S1(System.currentTimeMillis(), gVar, str, i);
        if (this.a.size() == 512) {
            this.a.remove();
        }
        this.a.add(s1);
    }

    public final String toString() {
        return "Events: " + this.a;
    }
}
