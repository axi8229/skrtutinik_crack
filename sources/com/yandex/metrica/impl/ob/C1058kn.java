package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.kn, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1058kn extends AbstractC0984hn {
    public C1058kn(int i) {
        super(i);
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC0984hn
    public C0959gn<String, Vm> a(String str) {
        int length = 0;
        if (str != null && str.length() > a()) {
            String strSubstring = str.substring(0, a());
            int length2 = C0810b.b(str).length;
            int length3 = C0810b.b(strSubstring).length;
            length = str.getBytes().length - strSubstring.getBytes().length;
            str = strSubstring;
        }
        return new C0959gn<>(str, new Um(length));
    }
}
