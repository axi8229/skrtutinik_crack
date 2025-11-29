package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.al, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0807al implements InterfaceC1204qk {
    private final int a;

    public C0807al(int i) {
        this.a = i;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1204qk
    public void a(C0832bl c0832bl) {
        if (c0832bl.h.length() > this.a) {
            int length = c0832bl.h.length();
            int i = this.a;
            int i2 = length - i;
            String strSubstring = c0832bl.h.substring(0, i);
            c0832bl.h = strSubstring;
            c0832bl.j = Integer.valueOf(strSubstring.length() + i2);
        }
    }
}
