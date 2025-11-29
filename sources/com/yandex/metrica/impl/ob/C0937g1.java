package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.g1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0937g1 {
    private static volatile C0937g1 c;
    private static final Object d = new Object();
    private List<String> a;
    private final List<a> b = new ArrayList();

    /* renamed from: com.yandex.metrica.impl.ob.g1$a */
    public interface a {
        void a();
    }

    C0937g1(Context context) {
        synchronized (this) {
            this.a = a(context.getResources().getConfiguration());
        }
    }

    public static C0937g1 a(Context context) {
        if (c == null) {
            synchronized (d) {
                try {
                    if (c == null) {
                        c = new C0937g1(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public void b(Configuration configuration) {
        ArrayList arrayList;
        synchronized (this) {
            this.a = a(configuration);
            arrayList = new ArrayList(this.b);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    public List<String> a() {
        return this.a;
    }

    public synchronized void a(a aVar) {
        this.b.add(aVar);
    }

    private List<String> a(Configuration configuration) {
        if (A2.a(24)) {
            ArrayList arrayList = new ArrayList();
            LocaleList locales = configuration.getLocales();
            if (locales != null) {
                Intrinsics.checkNotNullExpressionValue(locales, "configuration.locales ?: return result");
                int size = locales.size();
                for (int i = 0; i < size; i++) {
                    Locale locale = locales.get(i);
                    if (locale != null) {
                        String strA = H1.a(locale);
                        Intrinsics.checkNotNullExpressionValue(strA, "PhoneUtils.normalizedLocale(it)");
                        arrayList.add(strA);
                    }
                }
            }
            return arrayList;
        }
        return Collections.singletonList(H1.a(configuration.locale));
    }
}
