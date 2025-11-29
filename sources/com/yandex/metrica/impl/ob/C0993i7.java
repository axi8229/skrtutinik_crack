package com.yandex.metrica.impl.ob;

import java.io.File;

/* renamed from: com.yandex.metrica.impl.ob.i7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0993i7 implements InterfaceC1132nm<File, String> {
    private final C0843c7 a;
    private final C0968h7 b;

    public C0993i7(C0843c7 c0843c7, C0968h7 c0968h7) {
        this.a = c0843c7;
        this.b = c0968h7;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
    public String a(File file) {
        return this.b.a(file, this.a);
    }
}
