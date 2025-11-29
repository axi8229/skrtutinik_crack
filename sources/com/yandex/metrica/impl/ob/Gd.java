package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Gd implements Ad {
    private final Context a;
    private final String b;
    private final C1108mn c;

    public Gd(Context context, String str, C1108mn c1108mn) {
        this.a = context;
        this.b = str;
        this.c = c1108mn;
    }

    @Override // com.yandex.metrica.impl.ob.Ad
    public List<Bd> a() {
        ArrayList arrayList = new ArrayList();
        PackageInfo packageInfoB = this.c.b(this.a, this.b, 4096);
        if (packageInfoB != null) {
            for (String str : packageInfoB.requestedPermissions) {
                arrayList.add(new Bd(str, true));
            }
        }
        return arrayList;
    }
}
