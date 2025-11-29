package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Zm {
    private final String a;
    private final C0858cm b;

    public Zm(int i, String str, C0858cm c0858cm) {
        this.a = str;
        this.b = c0858cm;
    }

    public boolean a(C0808am c0808am, String str, String str2) {
        int iA = c0808am.a();
        if (str2 != null) {
            iA += str2.length();
        }
        if (c0808am.containsKey(str)) {
            String str3 = c0808am.get(str);
            if (str3 != null) {
                iA -= str3.length();
            }
        } else {
            iA += str.length();
        }
        return iA > 4500;
    }

    public void a(String str) {
        if (this.b.isEnabled()) {
            this.b.fw("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", this.a, 4500, str);
        }
    }
}
