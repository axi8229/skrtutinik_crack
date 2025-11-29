package bz;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: bz.c1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0504c1 extends AbstractC0538n1 {
    public C0504c1() {
        super(zone.bi.mobile.fingerprint.api.f.TimeZoneDSTOffset);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return String.valueOf(TimeZone.getDefault().inDaylightTime(new Date()) ? TimeUnit.MILLISECONDS.toMinutes(r0.getDSTSavings()) : 0L);
    }
}
