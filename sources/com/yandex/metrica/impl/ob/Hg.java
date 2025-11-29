package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.Eg;
import java.util.List;

/* loaded from: classes3.dex */
public class Hg extends Eg {
    private String m;
    private String n;

    protected static abstract class a<T extends Hg, A extends Eg.a> extends Eg.b<T, A> {
        private final C1108mn c;

        protected a(Context context, String str) {
            this(context, str, new C1108mn());
        }

        public T a(Eg.c<A> cVar) {
            T tA = a();
            tA.a(U.a());
            C0838c2 c0838c2A = F0.g().n().a();
            tA.a(c0838c2A);
            tA.a(cVar.a);
            String strA = cVar.b.a;
            if (strA == null) {
                strA = c0838c2A.a() != null ? c0838c2A.a().a() : null;
            }
            tA.c(strA);
            String str = this.b;
            String strA2 = cVar.b.b;
            Context context = this.a;
            if (TextUtils.isEmpty(strA2)) {
                strA2 = A2.a(context, str);
            }
            tA.b(strA2);
            String str2 = this.b;
            String strValueOf = cVar.b.c;
            Context context2 = this.a;
            if (TextUtils.isEmpty(strValueOf)) {
                strValueOf = String.valueOf(A2.b(context2, str2));
            }
            tA.a(strValueOf);
            tA.e(this.b);
            tA.a(F0.g().r().a(this.a));
            tA.a(F0.g().a().a());
            List<String> listA = C0937g1.a(this.a).a();
            tA.d(listA.isEmpty() ? null : listA.get(0));
            T t = tA;
            String packageName = this.a.getPackageName();
            ApplicationInfo applicationInfoA = this.c.a(this.a, this.b, 0);
            if (applicationInfoA != null) {
                t.f((applicationInfoA.flags & 2) != 0 ? "1" : "0");
                t.g((applicationInfoA.flags & 1) == 0 ? "0" : "1");
            } else if (TextUtils.equals(packageName, this.b)) {
                t.f((this.a.getApplicationInfo().flags & 2) != 0 ? "1" : "0");
                t.g((this.a.getApplicationInfo().flags & 1) == 0 ? "0" : "1");
            } else {
                t.f("0");
                t.g("0");
            }
            return t;
        }

        protected a(Context context, String str, C1108mn c1108mn) {
            super(context, str);
            this.c = c1108mn;
        }
    }

    public String A() {
        return this.n;
    }

    void f(String str) {
        this.m = str;
    }

    void g(String str) {
        this.n = str;
    }

    @Override // com.yandex.metrica.impl.ob.Eg
    public String toString() {
        return "CoreRequestConfig{mAppDebuggable='" + this.m + "', mAppSystem='" + this.n + "'} " + super.toString();
    }

    public String z() {
        return this.m;
    }
}
