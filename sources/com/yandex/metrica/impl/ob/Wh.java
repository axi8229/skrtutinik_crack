package com.yandex.metrica.impl.ob;

import com.yandex.metrica.IParamsCallback;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class Wh {
    private Xh a = new Xh();

    public final synchronized Xh a() {
        return this.a;
    }

    public final synchronized void a(Xh xh) {
        this.a = xh;
    }

    public final W0 a(String str) {
        Boolean boolB;
        String str2;
        Xh xh = this.a;
        if (str.hashCode() != 949037879 || !str.equals(IParamsCallback.YANDEX_MOBILE_METRICA_FEATURE_LIB_SSL_ENABLED) || (boolB = xh.b()) == null) {
            return null;
        }
        boolean zBooleanValue = boolB.booleanValue();
        U0 u0C = xh.c();
        String strA = xh.a();
        if (zBooleanValue) {
            str2 = "true";
        } else {
            if (zBooleanValue) {
                throw new NoWhenBranchMatchedException();
            }
            str2 = "false";
        }
        return new W0(str2, u0C, strA);
    }

    public final synchronized void a(List<String> list, Map<String, W0> map) {
        Boolean boolB;
        String str;
        try {
            for (String str2 : list) {
                if (str2.hashCode() == 949037879 && str2.equals(IParamsCallback.YANDEX_MOBILE_METRICA_FEATURE_LIB_SSL_ENABLED) && (boolB = this.a.b()) != null) {
                    boolean zBooleanValue = boolB.booleanValue();
                    U0 u0C = this.a.c();
                    String strA = this.a.a();
                    if (zBooleanValue) {
                        str = "true";
                    } else {
                        if (zBooleanValue) {
                            throw new NoWhenBranchMatchedException();
                        }
                        str = "false";
                    }
                    map.put(IParamsCallback.YANDEX_MOBILE_METRICA_FEATURE_LIB_SSL_ENABLED, new W0(str, u0C, strA));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
