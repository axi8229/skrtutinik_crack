package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.D3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class X3 implements InterfaceC1053ki, R3 {
    private final Context a;
    private final I3 b;
    private final InterfaceC1139o4<S3> c;
    private final C1225ri d;
    private final C0840c4 e;
    private S3 f;
    private Q3 g;
    private List<InterfaceC1053ki> h = new ArrayList();
    private final J3 i;

    public X3(Context context, I3 i3, D3 d3, C0840c4 c0840c4, InterfaceC1139o4<S3> interfaceC1139o4, J3 j3, C0904ei c0904ei) {
        this.a = context;
        this.b = i3;
        this.e = c0840c4;
        this.c = interfaceC1139o4;
        this.i = j3;
        this.d = c0904ei.a(context, i3, d3.a);
        c0904ei.a(i3, this);
    }

    public void a(C0836c0 c0836c0, D3 d3) {
        S3 s3A;
        ((C1403z4) a()).a();
        if (C1399z0.a(c0836c0.o())) {
            s3A = a();
        } else {
            if (this.f == null) {
                synchronized (this) {
                    S3 s3A2 = this.c.a(this.a, this.b, this.e.a(), this.d);
                    this.f = s3A2;
                    this.h.add(s3A2);
                }
            }
            s3A = this.f;
        }
        if (!C1399z0.b(c0836c0.o())) {
            D3.a aVar = d3.b;
            synchronized (this) {
                try {
                    this.e.a(aVar);
                    Q3 q3 = this.g;
                    if (q3 != null) {
                        ((C1403z4) q3).a(aVar);
                    }
                    S3 s3 = this.f;
                    if (s3 != null) {
                        s3.a(aVar);
                    }
                } finally {
                }
            }
        }
        s3A.a(c0836c0);
    }

    public synchronized void b(InterfaceC1039k4 interfaceC1039k4) {
        this.i.b(interfaceC1039k4);
    }

    public synchronized void a(InterfaceC1039k4 interfaceC1039k4) {
        this.i.a(interfaceC1039k4);
    }

    private Q3 a() {
        if (this.g == null) {
            synchronized (this) {
                Q3 q3B = this.c.b(this.a, this.b, this.e.a(), this.d);
                this.g = q3B;
                this.h.add(q3B);
            }
        }
        return this.g;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1053ki
    public synchronized void a(C1178pi c1178pi) {
        Iterator<InterfaceC1053ki> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().a(c1178pi);
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1053ki
    public synchronized void a(EnumC0954gi enumC0954gi, C1178pi c1178pi) {
        Iterator<InterfaceC1053ki> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().a(enumC0954gi, c1178pi);
        }
    }

    @Override // com.yandex.metrica.impl.ob.R3
    public void a(D3 d3) {
        this.d.a(d3.a);
        D3.a aVar = d3.b;
        synchronized (this) {
            try {
                this.e.a(aVar);
                Q3 q3 = this.g;
                if (q3 != null) {
                    ((C1403z4) q3).a(aVar);
                }
                S3 s3 = this.f;
                if (s3 != null) {
                    s3.a(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
