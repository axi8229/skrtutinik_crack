package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class Hd {
    private Context a;

    public Hd(Context context) {
        this.a = context;
    }

    public void a() {
        SharedPreferences sharedPreferencesA = C0810b.a(this.a, "_bidoptpreferences");
        if (sharedPreferencesA.getAll().size() > 0) {
            Rd rd = Pd.p;
            String string = sharedPreferencesA.getString(rd.b(), null);
            Pd pd = new Pd(this.a, null);
            if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(pd.b((String) null))) {
                pd.i(string).b();
                sharedPreferencesA.edit().remove(rd.b()).apply();
            }
            Map<String, ?> all = sharedPreferencesA.getAll();
            if (all.size() > 0) {
                Iterator it = ((ArrayList) a(all, Pd.q.b())).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    String string2 = sharedPreferencesA.getString(new Rd(Pd.q.b(), str).a(), null);
                    Pd pd2 = new Pd(this.a, str);
                    if (!TextUtils.isEmpty(string2) && TextUtils.isEmpty(pd2.h(null))) {
                        pd2.j(string2).b();
                    }
                }
            }
            sharedPreferencesA.edit().clear().apply();
        }
    }

    public void b() {
        S7 s7P = C1020ja.a(this.a).p();
        SharedPreferences sharedPreferencesA = C0810b.a(this.a, "_startupserviceinfopreferences");
        C0920f9 c0920f9 = new C0920f9(s7P, null);
        Rd rd = Pd.p;
        String string = sharedPreferencesA.getString(rd.b(), null);
        if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(c0920f9.g().b)) {
            c0920f9.i(string).d();
            sharedPreferencesA.edit().remove(rd.b()).apply();
        }
        C0920f9 c0920f92 = new C0920f9(s7P, this.a.getPackageName());
        boolean z = sharedPreferencesA.getBoolean(Pd.y.b(), false);
        if (z) {
            c0920f92.a(z).d();
        }
        a(s7P, this.a.getPackageName());
        Iterator it = ((ArrayList) a(sharedPreferencesA.getAll(), Pd.q.b())).iterator();
        while (it.hasNext()) {
            a(s7P, (String) it.next());
        }
    }

    private List<String> a(Map<String, ?> map, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2.replace(str, ""));
            }
        }
        return arrayList;
    }

    private void a(S7 s7, String str) {
        C0920f9 c0920f9 = new C0920f9(s7, str);
        Pd pd = new Pd(this.a, str);
        String strH = pd.h(null);
        if (!TextUtils.isEmpty(strH)) {
            c0920f9.o(strH);
        }
        String strC = pd.c(null);
        if (!TextUtils.isEmpty(strC)) {
            c0920f9.j(strC);
        }
        String strD = pd.d(null);
        if (!TextUtils.isEmpty(strD)) {
            c0920f9.k(strD);
        }
        String strF = pd.f(null);
        if (!TextUtils.isEmpty(strF)) {
            c0920f9.m(strF);
        }
        String strE = pd.e(null);
        if (!TextUtils.isEmpty(strE)) {
            c0920f9.l(strE);
        }
        long jA = pd.a(-1L);
        if (jA != -1) {
            c0920f9.b(jA);
        }
        String strG = pd.g(null);
        if (!TextUtils.isEmpty(strG)) {
            c0920f9.n(strG);
        }
        c0920f9.d();
        pd.f();
    }
}
