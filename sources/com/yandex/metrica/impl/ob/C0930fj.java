package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;

/* renamed from: com.yandex.metrica.impl.ob.fj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0930fj {
    private final Context a;
    private final B0 b;
    private final C1032jm c;

    C0930fj(Context context, B0 b0, C1032jm c1032jm) {
        this.a = context;
        this.b = b0;
        this.c = c1032jm;
    }

    public String a() {
        return L0.a(this.b.a(this.a, "uuid.dat"));
    }

    public String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = this.c.a();
            }
            File fileA = this.b.a(this.a, "uuid.dat");
            if (fileA != null) {
                L0.a(str, "uuid.dat", new FileOutputStream(fileA));
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }
}
