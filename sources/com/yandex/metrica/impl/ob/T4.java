package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.text.TextUtils;
import com.yandex.metrica.impl.ac.CrashpadServiceHelper;

/* loaded from: classes3.dex */
public class T4 extends X4 {
    private final InterfaceC1107mm<String> b;

    class a implements InterfaceC1107mm<String> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(String str) {
            String str2 = str;
            if (A2.a(21)) {
                CrashpadServiceHelper.a(str2);
            }
        }
    }

    public T4(L3 l3) {
        this(l3, new a());
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        Bundle bundleL = c0836c0.l();
        if (bundleL == null) {
            return true;
        }
        String string = bundleL.getString("payload_crash_id");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        this.b.b(string);
        return true;
    }

    public T4(L3 l3, InterfaceC1107mm<String> interfaceC1107mm) {
        super(l3);
        this.b = interfaceC1107mm;
    }
}
