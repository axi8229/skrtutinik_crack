package com.yandex.metrica.impl.ob;

import android.util.Pair;

/* renamed from: com.yandex.metrica.impl.ob.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1230s {
    private C0808am a;
    private long b;
    private boolean c;
    private final C0834bn d;

    /* renamed from: com.yandex.metrica.impl.ob.s$a */
    public static final class a {
        public final String a;
        public final long b;

        public a(String str, long j) {
            this.a = str;
            this.b = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b) {
                return false;
            }
            String str = this.a;
            String str2 = aVar.a;
            if (str != null) {
                if (str.equals(str2)) {
                    return true;
                }
            } else if (str2 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.a;
            int iHashCode = str != null ? str.hashCode() : 0;
            long j = this.b;
            return (iHashCode * 31) + ((int) (j ^ (j >>> 32)));
        }
    }

    public C1230s(String str, long j, C0858cm c0858cm) {
        this(str, j, new C0834bn(c0858cm, "[App Environment]"));
    }

    public synchronized void a(Pair<String, String> pair) {
        if (this.d.b(this.a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public synchronized void b() {
        this.a = new C0808am();
    }

    public synchronized String toString() {
        return "Map size " + this.a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    C1230s(String str, long j, C0834bn c0834bn) {
        this.b = j;
        try {
            this.a = new C0808am(str);
        } catch (Throwable unused) {
            this.a = new C0808am();
        }
        this.d = c0834bn;
    }

    public synchronized a a() {
        try {
            if (this.c) {
                this.b++;
                this.c = false;
            }
        } catch (Throwable th) {
            throw th;
        }
        return new a(Tl.g(this.a), this.b);
    }
}
