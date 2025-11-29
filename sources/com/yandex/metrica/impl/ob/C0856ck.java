package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

/* renamed from: com.yandex.metrica.impl.ob.ck, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0856ck implements Ok {
    private final C1108mn a;

    C0856ck() {
        this(new C1108mn());
    }

    @Override // com.yandex.metrica.impl.ob.Ok
    public Bundle a(Activity activity) {
        ActivityInfo activityInfo;
        C1108mn c1108mn = this.a;
        ComponentName componentName = activity.getComponentName();
        c1108mn.getClass();
        try {
            activityInfo = activity.getPackageManager().getActivityInfo(componentName, 128);
        } catch (Throwable unused) {
            activityInfo = null;
        }
        if (activityInfo != null) {
            return activityInfo.metaData;
        }
        return null;
    }

    C0856ck(C1108mn c1108mn) {
        this.a = c1108mn;
    }
}
