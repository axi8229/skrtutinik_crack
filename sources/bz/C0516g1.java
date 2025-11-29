package bz;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: bz.g1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0516g1 extends AbstractC0538n1 {
    public C0516g1() {
        super(zone.bi.mobile.fingerprint.api.f.TimeZone);
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return Long.toString(TimeUnit.MILLISECONDS.toMinutes(TimeZone.getDefault().getOffset(Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.getDefault()).getTimeInMillis())));
    }
}
