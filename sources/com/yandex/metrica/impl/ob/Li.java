package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.If;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Li {
    private static final Map<String, Integer> a = Collections.unmodifiableMap(new a());

    class a extends HashMap<String, Integer> {
        a() {
            put("BACKGROUND", 0);
            put("FOREGROUND", 2);
            put("VISIBLE", 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.yandex.metrica.impl.ob.Ui r17, org.json.JSONObject r18) {
        /*
            Method dump skipped, instructions count: 884
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.Li.a(com.yandex.metrica.impl.ob.Ui, org.json.JSONObject):void");
    }

    private static If.k.a.C0285a a(JSONObject jSONObject, boolean z) {
        If.k.a.C0285a c0285a = new If.k.a.C0285a();
        Boolean boolA = Tl.a(jSONObject, "last_known_enabled", (Boolean) null);
        Boolean boolValueOf = Boolean.valueOf(c0285a.a);
        if (boolA == null) {
            boolA = boolValueOf;
        }
        c0285a.a = boolA.booleanValue();
        Boolean boolA2 = Tl.a(jSONObject, "scanning_enabled", (Boolean) null);
        Boolean boolValueOf2 = Boolean.valueOf(z);
        if (boolA2 == null) {
            boolA2 = boolValueOf2;
        }
        boolean zBooleanValue = boolA2.booleanValue();
        c0285a.b = zBooleanValue;
        if (jSONObject != null && zBooleanValue) {
            If.k.a.C0285a.C0286a c0286a = new If.k.a.C0285a.C0286a();
            Long lA = Tl.a(jSONObject, "duration_seconds", (Long) null);
            Long lValueOf = Long.valueOf(c0286a.a);
            if (lA == null) {
                lA = lValueOf;
            }
            c0286a.a = lA.longValue();
            Long lA2 = Tl.a(jSONObject, "interval_seconds", (Long) null);
            Long lValueOf2 = Long.valueOf(c0286a.b);
            if (lA2 == null) {
                lA2 = lValueOf2;
            }
            c0286a.b = lA2.longValue();
            c0285a.c = c0286a;
        }
        return c0285a;
    }
}
