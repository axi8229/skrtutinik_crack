package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.google.protobuf.nano.ym.MessageNano;
import com.yandex.metrica.coreutils.services.TimeProvider;
import com.yandex.metrica.impl.ob.C1199qf;
import com.yandex.metrica.impl.ob.E4;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class C4 {
    public static final Map<Integer, Integer> h = Collections.unmodifiableMap(new a());
    private final C0836c0 a;
    private final D4 b;
    private final E4 c;
    private final C0859cn d;
    private final C0859cn e;
    private final TimeProvider f;
    private final O3 g;

    class a extends HashMap<Integer, Integer> {
        a() {
            put(Integer.valueOf(EnumC0787a1.EVENT_TYPE_DIAGNOSTIC.b()), 22);
            put(Integer.valueOf(EnumC0787a1.EVENT_TYPE_DIAGNOSTIC_STATBOX.b()), 23);
            put(Integer.valueOf(EnumC0787a1.EVENT_TYPE_DIAGNOSTIC_DISABLE_STAT_SENDING.b()), 24);
            put(Integer.valueOf(EnumC0787a1.EVENT_TYPE_APPMETRICA_DIAGNOSTICS.b()), 24);
        }
    }

    public C4(C0836c0 c0836c0, D4 d4, E4 e4, O3 o3, C0859cn c0859cn, C0859cn c0859cn2, TimeProvider timeProvider) {
        this.a = c0836c0;
        this.b = d4;
        this.c = e4;
        this.g = o3;
        this.e = c0859cn;
        this.d = c0859cn2;
        this.f = timeProvider;
    }

    public byte[] a() throws UnsupportedEncodingException {
        C1199qf c1199qf = new C1199qf();
        C1199qf.d dVar = new C1199qf.d();
        c1199qf.a = new C1199qf.d[]{dVar};
        E4.a aVarA = this.c.a();
        dVar.a = aVarA.a;
        C1199qf.d.b bVar = new C1199qf.d.b();
        dVar.b = bVar;
        bVar.c = 2;
        bVar.a = new C1199qf.f();
        C1199qf.f fVar = dVar.b.a;
        long j = aVarA.b;
        fVar.a = j;
        fVar.b = ((GregorianCalendar) Calendar.getInstance()).getTimeZone().getOffset(j * 1000) / 1000;
        dVar.b.b = this.b.k();
        C1199qf.d.a aVar = new C1199qf.d.a();
        dVar.c = new C1199qf.d.a[]{aVar};
        aVar.a = aVarA.c;
        aVar.p = this.g.a(this.a.o());
        aVar.b = this.f.currentTimeSeconds() - aVarA.b;
        aVar.c = h.get(Integer.valueOf(this.a.o())).intValue();
        if (!TextUtils.isEmpty(this.a.g())) {
            aVar.d = this.e.a(this.a.g());
        }
        if (!TextUtils.isEmpty(this.a.q())) {
            String strQ = this.a.q();
            String strA = this.d.a(strQ);
            if (!TextUtils.isEmpty(strA)) {
                aVar.e = strA.getBytes();
            }
            int length = strQ.getBytes().length;
            byte[] bArr = aVar.e;
            aVar.j = length - (bArr == null ? 0 : bArr.length);
        }
        return MessageNano.toByteArray(c1199qf);
    }
}
