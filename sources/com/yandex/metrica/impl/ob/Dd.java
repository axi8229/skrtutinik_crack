package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* loaded from: classes3.dex */
class Dd implements Ad {
    private final Context a;
    private final C1108mn b;

    public Dd(Context context, C1108mn c1108mn) {
        this.a = context;
        this.b = c1108mn;
    }

    @Override // com.yandex.metrica.impl.ob.Ad
    public List<Bd> a() {
        ArrayList arrayList = new ArrayList();
        C1108mn c1108mn = this.b;
        Context context = this.a;
        PackageInfo packageInfoB = c1108mn.b(context, context.getPackageName(), 4096);
        if (packageInfoB == null) {
            return arrayList;
        }
        String[] strArr = packageInfoB.requestedPermissions;
        int[] iArr = packageInfoB.requestedPermissionsFlags;
        if (strArr == null) {
            return arrayList;
        }
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            if (iArr == null || iArr.length <= i || (iArr[i] & 2) == 0) {
                arrayList.add(new Bd(str, false));
            } else {
                arrayList.add(new Bd(str, true));
            }
        }
        return arrayList;
    }
}
