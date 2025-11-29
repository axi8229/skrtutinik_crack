package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.content.Context;

/* renamed from: com.yandex.metrica.impl.ob.hk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0981hk {
    private final C0881dk a;
    private final C0831bk b;

    C0981hk(Context context) {
        this(new C0881dk(context), new C0831bk());
    }

    Wk a(Activity activity, C0932fl c0932fl) {
        if (c0932fl == null) {
            return Wk.NULL_UI_ACCESS_CONFIG;
        }
        if (!c0932fl.a) {
            return Wk.UI_PARING_FEATURE_DISABLED;
        }
        C1348wl c1348wl = c0932fl.e;
        return c1348wl == null ? Wk.NULL_UI_PARSING_CONFIG : this.a.a(activity, c1348wl) ? Wk.FORBIDDEN_FOR_APP : this.b.a(activity, c0932fl.e) ? Wk.FORBIDDEN_FOR_ACTIVITY : Wk.OK;
    }

    C0981hk(C0881dk c0881dk, C0831bk c0831bk) {
        this.a = c0881dk;
        this.b = c0831bk;
    }
}
