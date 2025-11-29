package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.yandex.metrica.impl.ob.jc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1022jc {
    private final T7 a;
    private final Vb b;

    public C1022jc(Context context) {
        this(C1020ja.a(context).e(), new Vb(context));
    }

    public void a(C1072lc c1072lc) {
        String strA = this.b.a(c1072lc);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.a.a(c1072lc.d(), strA);
    }

    C1022jc(T7 t7, Vb vb) {
        this.a = t7;
        this.b = vb;
    }
}
