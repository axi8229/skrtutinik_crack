package com.yandex.metrica.impl.ob;

import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.j0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1010j0 {
    private final K0 a;
    private final Map<Boolean, String> b = new HashMap();

    public C1010j0(K0 k0) {
        this.a = k0;
    }

    public void a(Intent intent) {
        if (intent != null) {
            a(intent.getDataString(), false);
        }
    }

    public void b(String str) {
        a(str, true);
    }

    public void a(String str) {
        a(str, false);
    }

    private void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!A2.a(str, this.b.get(Boolean.valueOf(!z)))) {
            this.a.a(str, z);
        }
        this.b.put(Boolean.valueOf(z), str);
    }
}
