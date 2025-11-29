package com.yandex.metrica.impl.ob;

import android.content.pm.FeatureInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.AbstractC1218rb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Z4 extends X4 {
    private final C1108mn b;

    public Z4(L3 l3) {
        this(l3, new C1108mn());
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        L3 l3A = a();
        if (l3A.x().k() && l3A.C()) {
            C0845c9 c0845c9F = l3A.f();
            String strG = a().f().g();
            HashSet hashSet = null;
            if (!TextUtils.isEmpty(strG)) {
                try {
                    HashSet hashSet2 = new HashSet();
                    JSONArray jSONArray = new JSONArray(strG);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet2.add(new C1242sb(jSONArray.getJSONObject(i)));
                    }
                    hashSet = hashSet2;
                } catch (Throwable unused) {
                }
            }
            try {
                ArrayList<C1242sb> arrayListB = b();
                if (C0810b.a(hashSet, arrayListB)) {
                    l3A.y();
                } else {
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<C1242sb> it = arrayListB.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next().a());
                    }
                    l3A.r().c(C0836c0.a(c0836c0, new JSONObject().put("features", jSONArray2).toString()));
                    c0845c9F.h(jSONArray2.toString());
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    ArrayList<C1242sb> b() {
        FeatureInfo[] featureInfoArr;
        try {
            L3 l3A = a();
            PackageInfo packageInfoB = this.b.b(l3A.g(), l3A.g().getPackageName(), 16384);
            ArrayList<C1242sb> arrayList = new ArrayList<>();
            AbstractC1218rb aVar = A2.a(24) ? new AbstractC1218rb.a() : new AbstractC1218rb.b();
            if (packageInfoB != null && (featureInfoArr = packageInfoB.reqFeatures) != null) {
                for (FeatureInfo featureInfo : featureInfoArr) {
                    arrayList.add(aVar.a(featureInfo));
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Z4(L3 l3, C1108mn c1108mn) {
        super(l3);
        this.b = c1108mn;
    }
}
