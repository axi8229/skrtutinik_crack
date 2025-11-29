package com.yandex.metrica.impl.ob;

import com.yandex.metrica.i;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public class Wf {
    public com.yandex.metrica.i a(com.yandex.metrica.i iVar) {
        if (!A2.a(iVar.maxReportsInDatabaseCount)) {
            return iVar;
        }
        i.b bVarA = com.yandex.metrica.i.a(iVar).a(new ArrayList());
        if (A2.a((Object) iVar.a)) {
            bVarA.b(iVar.a);
        }
        if (A2.a((Object) iVar.b) && A2.a(iVar.i)) {
            bVarA.a(iVar.b, iVar.i);
        }
        if (A2.a(iVar.e)) {
            bVarA.a(iVar.e.intValue());
        }
        if (A2.a(iVar.f)) {
            bVarA.b(iVar.f.intValue());
        }
        if (A2.a(iVar.g)) {
            bVarA.c(iVar.g.intValue());
        }
        if (A2.a((Object) iVar.c)) {
            bVarA.f = iVar.c;
        }
        if (A2.a((Object) iVar.h)) {
            for (Map.Entry<String, String> entry : iVar.h.entrySet()) {
                bVarA.a(entry.getKey(), entry.getValue());
            }
        }
        if (A2.a(iVar.j)) {
            bVarA.g(iVar.j.booleanValue());
        }
        if (A2.a((Object) iVar.d)) {
            bVarA.a(iVar.d);
        }
        if (A2.a(iVar.k)) {
            bVarA.b(iVar.k.booleanValue());
        }
        return bVarA.d(a(iVar.maxReportsInDatabaseCount, iVar.apiKey)).a();
    }

    public com.yandex.metrica.e a(com.yandex.metrica.e eVar) {
        return A2.a(eVar.maxReportsInDatabaseCount) ? com.yandex.metrica.e.a(eVar).a(a(eVar.maxReportsInDatabaseCount, eVar.apiKey)).a() : eVar;
    }

    private int a(Integer num, String str) {
        if (num.intValue() < 100) {
            Ul.b(str).fw("Value passed as maxReportsInDatabaseCount is invalid. Should be greater than or equal to %d, but was: %d. Default value (%d) will be used", 100, num, 100);
            return 100;
        }
        if (num.intValue() > 10000) {
            Ul.b(str).fw("Value passed as maxReportsInDatabaseCount is invalid. Should be less than or equal to %d, but was: %d. Default value (%d) will be used", 10000, num, 10000);
            return 10000;
        }
        return num.intValue();
    }
}
