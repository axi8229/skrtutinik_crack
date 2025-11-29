package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C1175pf;

/* loaded from: classes3.dex */
public class Zc {
    private final Vb a;
    private final Yc b;

    public Zc(Vb vb, Yc yc) {
        this.a = vb;
        this.b = yc;
    }

    public C1175pf.a a(long j, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                C1072lc c1072lcA = this.a.a(j, str);
                if (c1072lcA != null) {
                    return this.b.a(c1072lcA);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
