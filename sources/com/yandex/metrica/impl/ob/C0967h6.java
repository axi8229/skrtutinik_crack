package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* renamed from: com.yandex.metrica.impl.ob.h6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0967h6 {
    private final C1016j6 a;
    private final Map<String, byte[]> b;

    public C0967h6(Context context, I3 i3) {
        String strA = i3.a();
        if (strA != null) {
            A2.a(strA);
        }
        C1016j6 c1016j6 = new C1016j6(context, i3);
        this.a = c1016j6;
        this.b = MapsKt.toMutableMap(c1016j6.a());
    }

    public final Map<String, byte[]> a() {
        return new HashMap(this.b);
    }

    public final void a(String str, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            this.b.remove(str);
        } else {
            this.b.put(str, bArr);
        }
        this.a.a(this.b);
    }
}
