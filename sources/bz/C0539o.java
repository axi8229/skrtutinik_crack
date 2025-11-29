package bz;

import android.os.SystemClock;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* renamed from: bz.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0539o extends AbstractC0538n1 {
    public C0539o() {
        super(zone.bi.mobile.fingerprint.api.f.AgentBootTime);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return String.valueOf(TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime()));
    }
}
