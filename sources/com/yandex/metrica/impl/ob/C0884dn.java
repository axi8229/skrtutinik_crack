package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.dn, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0884dn extends Sm<String> {
    public C0884dn(int i, String str) {
        this(i, str, C0858cm.a());
    }

    public C0884dn(int i, String str, C0858cm c0858cm) {
        super(i, str, c0858cm);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0934fn
    public String a(String str) {
        if (str == null || str.length() <= super.b()) {
            return str;
        }
        String strSubstring = str.substring(0, super.b());
        if (this.c.isEnabled()) {
            this.c.fw("\"%s\" %s size exceeded limit of %d characters", super.a(), str, Integer.valueOf(super.b()));
        }
        return strSubstring;
    }
}
