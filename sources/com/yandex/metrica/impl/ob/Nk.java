package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1228rl;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Nk implements Cl {
    private final Pattern a;

    Nk(Pattern pattern) {
        this.a = pattern;
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public boolean a(Object obj) {
        return this.a.matcher((String) obj).matches();
    }

    @Override // com.yandex.metrica.impl.ob.Cl
    public C1228rl.b a() {
        return C1228rl.b.BAD_REGEXP_MATCHED;
    }
}
