package com.yandex.metrica.impl.ob;

import com.huawei.hms.android.SystemUtils;
import com.yandex.metrica.impl.ob.C1326w;

/* renamed from: com.yandex.metrica.impl.ob.oc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1147oc {
    public final C1097mc a;
    public final Ac b;

    /* renamed from: com.yandex.metrica.impl.ob.oc$a */
    public enum a {
        UNKNOWN(SystemUtils.UNKNOWN),
        FOREGROUND("fg"),
        BACKGROUND("bg"),
        VISIBLE("visible");

        private final String a;

        a(String str) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.a;
        }

        public static a a(String str) {
            a aVar = UNKNOWN;
            a[] aVarArrValues = values();
            for (int i = 0; i < 4; i++) {
                a aVar2 = aVarArrValues[i];
                if (aVar2.a.equals(str)) {
                    aVar = aVar2;
                }
            }
            return aVar;
        }

        public static a a(C1326w.a aVar) {
            a aVar2 = UNKNOWN;
            if (aVar == null) {
                return aVar2;
            }
            int iOrdinal = aVar.ordinal();
            if (iOrdinal != 1) {
                return iOrdinal != 2 ? aVar2 : VISIBLE;
            }
            return BACKGROUND;
        }
    }

    public C1147oc(C1097mc c1097mc, Ac ac) {
        this.a = c1097mc;
        this.b = ac;
    }

    public String toString() {
        return "LocationCollectionConfig{arguments=" + this.a + ", preconditions=" + this.b + '}';
    }
}
