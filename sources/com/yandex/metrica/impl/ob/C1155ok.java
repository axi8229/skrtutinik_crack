package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1228rl;
import java.util.regex.Pattern;

/* renamed from: com.yandex.metrica.impl.ob.ok, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1155ok implements Cl {
    private final Pattern a;

    C1155ok(Pattern pattern) {
        this.a = pattern;
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public boolean a(Object obj) {
        return !this.a.matcher((String) obj).matches();
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public C1228rl.b a() {
        return C1228rl.b.REGEXP_NOT_MATCHED;
    }
}
