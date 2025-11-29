package com.huawei.updatesdk.b.a.b;

import android.content.pm.PackageInfo;
import android.util.ArrayMap;
import android.util.ArraySet;
import com.huawei.updatesdk.a.a.d.g;
import com.huawei.updatesdk.b.a.b.a;
import com.huawei.updatesdk.b.a.b.c;
import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {
    private static b b;
    private final Map<String, a> a = new HashMap();

    private b() {
    }

    public static synchronized b a() {
        try {
            if (b == null) {
                b = new b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    private static void a(a aVar) {
        a().a.put(aVar.c(), aVar);
    }

    private static ArrayList<String> b(PackageInfo packageInfo) throws ClassNotFoundException {
        ArraySet<String> arraySet;
        a aVar = new a();
        aVar.a(packageInfo.packageName);
        File file = new File(packageInfo.applicationInfo.sourceDir);
        if (!file.exists()) {
            return null;
        }
        aVar.a(file.lastModified());
        c.a aVarA = c.a(file);
        ArrayMap<String, ArraySet<PublicKey>> arrayMap = aVarA.a;
        if (arrayMap == null || arrayMap.isEmpty() || (arraySet = aVarA.b) == null || arraySet.isEmpty()) {
            a(aVar);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, ArraySet<PublicKey>> entry : aVarA.a.entrySet()) {
            if (aVarA.b.contains(entry.getKey())) {
                Iterator<PublicKey> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(g.a(it.next().getEncoded()));
                }
            }
        }
        a.C0104a c0104a = new a.C0104a();
        c0104a.a(arrayList);
        aVar.a(c0104a);
        a(aVar);
        return arrayList;
    }

    public List<String> a(PackageInfo packageInfo) {
        String str;
        if (packageInfo == null || (str = packageInfo.applicationInfo.sourceDir) == null) {
            return null;
        }
        long jLastModified = new File(str).lastModified();
        a aVar = a().a.get(packageInfo.packageName);
        if (aVar == null || aVar.b() != jLastModified) {
            return b(packageInfo);
        }
        if (aVar.a() == null) {
            return null;
        }
        return aVar.a().a();
    }
}
