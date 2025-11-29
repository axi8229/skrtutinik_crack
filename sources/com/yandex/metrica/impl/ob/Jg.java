package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class Jg {
    private final List<String> a;
    private final C1257t2 b;

    public Jg(C1257t2 c1257t2) {
        this.b = c1257t2;
        this.a = a(new String[]{"https://startup.mobile.yandex.net/", "", "", ""});
    }

    public final Collection<String> a() {
        String[] strArrA = this.b.a();
        if (strArrA != null) {
            List<String> listA = a(strArrA);
            if (listA.isEmpty()) {
                listA = null;
            }
            if (listA != null) {
                return listA;
            }
        }
        return this.a;
    }

    private final List<String> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str == null || StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Jg() {
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        Context contextE = f0G.e();
        Intrinsics.checkNotNullExpressionValue(contextE, "GlobalServiceLocator.getInstance().context");
        this(new C1257t2(contextE, "appmetrica_startup_hosts"));
    }
}
