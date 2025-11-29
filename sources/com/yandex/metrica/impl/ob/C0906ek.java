package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;

/* renamed from: com.yandex.metrica.impl.ob.ek, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0906ek implements Ok {
    private final Bundle a;

    C0906ek(Context context) {
        this(context, new C1108mn());
    }

    @Override // com.yandex.metrica.impl.ob.Ok
    public Bundle a(Activity activity) {
        return this.a;
    }

    C0906ek(Context context, C1108mn c1108mn) {
        ApplicationInfo applicationInfoA = c1108mn.a(context, context.getPackageName(), 128);
        if (applicationInfoA != null) {
            this.a = applicationInfoA.metaData;
        } else {
            this.a = null;
        }
    }
}
