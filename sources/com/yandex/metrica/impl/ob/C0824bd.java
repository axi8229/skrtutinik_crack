package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C1175pf;

/* renamed from: com.yandex.metrica.impl.ob.bd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0824bd {
    private final Vb a;
    private final C0799ad b;

    public C0824bd(Vb vb, C0799ad c0799ad) {
        this.a = vb;
        this.b = c0799ad;
    }

    public C1175pf.b a(long j, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Hc hcB = this.a.b(j, str);
                if (hcB != null) {
                    return this.b.a(hcB);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
