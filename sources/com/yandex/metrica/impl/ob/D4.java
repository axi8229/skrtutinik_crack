package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.D3;
import com.yandex.metrica.impl.ob.Eg;
import com.yandex.metrica.impl.ob.Hg;
import java.util.List;

/* loaded from: classes3.dex */
public class D4 extends Hg {
    private List<String> o;
    private String p;
    private Boolean q;

    public String B() {
        return this.p;
    }

    public List<String> C() {
        return this.o;
    }

    public Boolean D() {
        return this.q;
    }

    public void a(List<String> list) {
        this.o = list;
    }

    public void h(String str) {
        this.p = str;
    }

    @Override // com.yandex.metrica.impl.ob.Hg, com.yandex.metrica.impl.ob.Eg
    public String toString() {
        return "DiagnosticRequestConfig{mDiagnosticHosts=" + this.o + ", mApiKey='" + this.p + "', statisticsSending=" + this.q + "} " + super.toString();
    }

    public void a(Boolean bool) {
        this.q = bool;
    }

    public static final class a extends Eg.a<D3.a, a> {
        public final String d;
        public final boolean e;

        public a(String str, String str2, String str3, String str4, Boolean bool) {
            super(str, str2, str3);
            this.d = str4;
            this.e = ((Boolean) Tl.a(bool, Boolean.TRUE)).booleanValue();
        }

        @Override // com.yandex.metrica.impl.ob.Dg
        public Object a(Object obj) {
            D3.a aVar = (D3.a) obj;
            String str = aVar.a;
            String str2 = this.a;
            if (str != null) {
                str2 = str;
            }
            String str3 = aVar.b;
            String str4 = this.b;
            if (str3 != null) {
                str4 = str3;
            }
            String str5 = aVar.c;
            String str6 = this.c;
            if (str5 != null) {
                str6 = str5;
            }
            String str7 = aVar.d;
            String str8 = this.d;
            if (str7 != null) {
                str8 = str7;
            }
            Boolean bool = aVar.l;
            return new a(str2, str4, str6, str8, bool == null ? Boolean.valueOf(this.e) : bool);
        }

        @Override // com.yandex.metrica.impl.ob.Dg
        public boolean b(Object obj) {
            String str;
            String str2;
            String str3;
            D3.a aVar = (D3.a) obj;
            String str4 = aVar.a;
            return (str4 == null || str4.equals(this.a)) && ((str = aVar.b) == null || str.equals(this.b)) && (((str2 = aVar.c) == null || str2.equals(this.c)) && ((str3 = aVar.d) == null || str3.equals(this.d)));
        }

        public a(D3.a aVar) {
            this(aVar.a, aVar.b, aVar.c, aVar.d, aVar.l);
        }
    }

    public static class b extends Hg.a<D4, a> {
        public b(Context context, String str) {
            super(context, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.yandex.metrica.impl.ob.Eg.d
        public Eg a(Object obj) {
            Eg.c cVar = (Eg.c) obj;
            D4 d4A = a(cVar);
            d4A.a(cVar.a.k());
            d4A.h(((a) cVar.b).d);
            d4A.a(Boolean.valueOf(((a) cVar.b).e));
            return d4A;
        }

        @Override // com.yandex.metrica.impl.ob.Eg.b
        protected Eg a() {
            return new D4();
        }
    }
}
