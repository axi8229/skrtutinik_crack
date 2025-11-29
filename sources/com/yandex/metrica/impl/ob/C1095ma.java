package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.Set;

/* renamed from: com.yandex.metrica.impl.ob.ma, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1095ma implements S7 {
    private final S7 a;

    public C1095ma(Context context, W7 w7, S7 s7) {
        this.a = s7;
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public int a(String str, int i) {
        return this.a.a(str, i);
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public void b() {
        this.a.b();
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public long a(String str, long j) {
        return this.a.a(str, j);
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public String b(String str, String str2) {
        return this.a.b(str, str2);
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public S7 a(String str, String str2) {
        this.a.a(str, str2);
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public boolean b(String str, boolean z) {
        return this.a.b(str, z);
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public S7 a(String str, boolean z) {
        this.a.a(str, z);
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public S7 b(String str) {
        this.a.b(str);
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public boolean a(String str) {
        return this.a.a(str);
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public S7 b(String str, long j) {
        this.a.b(str, j);
        return this;
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public Set<String> a() {
        return this.a.a();
    }

    @Override // com.yandex.metrica.impl.ob.S7
    public S7 b(String str, int i) {
        this.a.b(str, i);
        return this;
    }
}
