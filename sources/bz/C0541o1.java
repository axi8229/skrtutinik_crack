package bz;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: bz.o1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0541o1 extends AbstractC0538n1 {
    public static final SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);

    public C0541o1() {
        super(zone.bi.mobile.fingerprint.api.f.TIMESTAMP);
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override // bz.AbstractC0538n1
    public final Serializable h() {
        return c.format(new Date());
    }
}
