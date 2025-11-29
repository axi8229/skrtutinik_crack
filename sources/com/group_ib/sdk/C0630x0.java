package com.group_ib.sdk;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.safetynet.HarmfulAppsData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.x0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0630x0 {
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public Map d = null;
    public boolean e = false;
    public long f = 0;

    public final C0602i0 a(PackageInfo packageInfo, PackageManager packageManager) {
        C0602i0 c0602i0 = new C0602i0(packageInfo, packageManager);
        this.a.put(c0602i0.a, c0602i0);
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            for (Signature signature : signatureArr) {
                byte[] byteArray = signature.toByteArray();
                String strA = C0608l0.a(byteArray);
                C0608l0 c0608l0 = (C0608l0) this.c.get(strA);
                if (c0608l0 == null) {
                    c0608l0 = new C0608l0(byteArray, strA);
                    this.c.put(strA, c0608l0);
                }
                c0608l0.a(c0602i0);
            }
        }
        return c0602i0;
    }

    public final JSONArray b() {
        Map map = this.d;
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry : this.d.entrySet()) {
                jSONArray.put(new JSONObject().put(AppMeasurementSdk.ConditionalUserProperty.NAME, entry.getKey()).put("removed", entry.getValue()));
            }
            return jSONArray;
        } catch (Exception e) {
            c1.b("PackageSet", "failed to stringify removed packages", e);
            return null;
        }
    }

    public final JSONArray c() throws JSONException {
        JSONObject jSONObjectB;
        try {
            HashMap map = this.c;
            if (map == null || map.isEmpty()) {
                return null;
            }
            Iterator it = this.c.entrySet().iterator();
            JSONArray jSONArray = null;
            while (it.hasNext()) {
                C0608l0 c0608l0 = (C0608l0) ((Map.Entry) it.next()).getValue();
                if (c0608l0 != null) {
                    JSONObject jSONObjectA = c0608l0.a();
                    if (jSONObjectA != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator it2 = c0608l0.f.iterator();
                        while (it2.hasNext()) {
                            C0602i0 c0602i0 = (C0602i0) this.a.get((String) it2.next());
                            if (c0602i0 != null && (jSONObjectB = c0602i0.b()) != null) {
                                jSONArray2.put(jSONObjectB);
                            }
                        }
                        jSONObjectA.put("packages", jSONArray2);
                    }
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    jSONArray.put(jSONObjectA);
                }
            }
            return jSONArray;
        } catch (Exception e) {
            c1.b("PackageSet", "Failed to build json", e);
            return null;
        }
    }

    public final boolean b(List list, PackageManager packageManager) {
        String str;
        if (list == null) {
            return false;
        }
        this.f++;
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = ((ResolveInfo) it.next()).activityInfo;
            if (activityInfo != null && (str = activityInfo.packageName) != null) {
                C0602i0 c0602i0A = (C0602i0) this.b.get(str);
                if (c0602i0A == null) {
                    try {
                        c0602i0A = a(str, packageManager);
                    } catch (Exception e) {
                        c1.b("PackageSet", "Failed to get admin enabled package for ".concat(str), e);
                    }
                    if (c0602i0A != null) {
                        this.b.put(str, c0602i0A);
                    }
                }
                if (!c0602i0A.h) {
                    c0602i0A.h = true;
                    c0602i0A.e = true;
                    c1.a(4, 4, "PackageSet", "Fix admin enabled package: ".concat(str));
                    z = true;
                }
                c0602i0A.i = this.f;
            }
        }
        Iterator it2 = this.b.entrySet().iterator();
        while (it2.hasNext()) {
            C0602i0 c0602i0 = (C0602i0) ((Map.Entry) it2.next()).getValue();
            if (c0602i0.i != this.f && c0602i0.h) {
                c0602i0.h = false;
                c0602i0.e = true;
                c1.a(4, 4, "PackageSet", "Unfix admin enabled package: " + c0602i0.a);
                z = true;
            }
        }
        return z;
    }

    public final C0602i0 a(String str, PackageManager packageManager) {
        PackageInfo packageInfo;
        C0602i0 c0602i0 = (C0602i0) this.a.get(str);
        return (c0602i0 != null || (packageInfo = packageManager.getPackageInfo(str, 4290)) == null) ? c0602i0 : a(packageInfo, packageManager);
    }

    public final C0630x0 a() throws Throwable {
        C0630x0 c0630x0 = null;
        if (this.d != null) {
            C0630x0 c0630x02 = new C0630x0();
            c0630x02.d = this.d;
            this.d = null;
            c0630x0 = c0630x02;
        }
        boolean z = false;
        for (C0608l0 c0608l0 : this.c.values()) {
            if (c0608l0.f.size() <= 3 || c0608l0.e) {
                Iterator it = c0608l0.f.iterator();
                while (it.hasNext()) {
                    C0602i0 c0602i0 = (C0602i0) this.a.get((String) it.next());
                    if (c0602i0 != null && c0602i0.e) {
                        if (c0630x0 != null) {
                            z = c0630x0.a.size() >= 10;
                            if (z) {
                                break;
                            }
                        }
                        if (c0630x0 == null) {
                            c0630x0 = new C0630x0();
                        }
                        c0602i0.e = false;
                        c0602i0.a();
                        C0602i0 c0602i02 = new C0602i0(c0602i0);
                        C0608l0 c0608l02 = (C0608l0) c0630x0.c.get(c0608l0.d);
                        if (c0608l02 == null) {
                            c0608l02 = new C0608l0(c0608l0);
                            c0630x0.c.put(c0608l02.d, c0608l02);
                        }
                        c0608l02.a(c0602i02);
                        c0630x0.a.put(c0602i02.a, c0602i02);
                    }
                }
                if (z) {
                    break;
                }
            }
        }
        if (!z) {
            if (c0630x0 == null) {
                c0630x0 = new C0630x0();
            }
            c0630x0.e = true;
        }
        return c0630x0;
    }

    public final void a(HarmfulAppsData harmfulAppsData, PackageManager packageManager) {
        try {
            C0602i0 c0602i0A = a(harmfulAppsData.apkPackageName, packageManager);
            if (c0602i0A == null || c0602i0A.f) {
                return;
            }
            c0602i0A.f = true;
            c0602i0A.e = true;
        } catch (Exception e) {
            c1.b("PackageSet", "Failed to mark harmful: " + harmfulAppsData.apkPackageName, e);
        }
    }

    public final void a(C0630x0 c0630x0) {
        for (C0608l0 c0608l0 : c0630x0.c.values()) {
            C0608l0 c0608l02 = (C0608l0) this.c.get(c0608l0.d);
            if (c0608l02 == null) {
                c0608l02 = new C0608l0(c0608l0);
                this.c.put(c0608l02.d, c0608l02);
            }
            Iterator it = c0608l0.f.iterator();
            while (it.hasNext()) {
                C0602i0 c0602i0 = (C0602i0) c0630x0.a.get((String) it.next());
                if (c0602i0 != null) {
                    this.a.put(c0602i0.a, c0602i0);
                    c0608l02.a(c0602i0);
                }
            }
        }
        Map map = c0630x0.d;
        if (map != null) {
            Map map2 = this.d;
            if (map2 != null) {
                map2.putAll(map);
            } else {
                this.d = map;
            }
        }
        this.e = c0630x0.e;
    }

    public final boolean a(List list, PackageManager packageManager) {
        if (list == null) {
            return false;
        }
        this.f++;
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String packageName = ((ComponentName) it.next()).getPackageName();
            C0602i0 c0602i0A = (C0602i0) this.b.get(packageName);
            if (c0602i0A == null) {
                try {
                    c0602i0A = a(packageName, packageManager);
                } catch (Exception e) {
                    c1.b("PackageSet", "Failed to get admin active package for " + packageName, e);
                }
                if (c0602i0A != null) {
                    this.b.put(packageName, c0602i0A);
                }
            }
            if (!c0602i0A.g) {
                c0602i0A.g = true;
                c0602i0A.e = true;
                c1.a(4, 4, "PackageSet", "Fix admin active package: " + packageName);
                z = true;
            }
            c0602i0A.i = this.f;
        }
        Iterator it2 = this.b.entrySet().iterator();
        while (it2.hasNext()) {
            C0602i0 c0602i0 = (C0602i0) ((Map.Entry) it2.next()).getValue();
            if (c0602i0.i != this.f && c0602i0.g) {
                c0602i0.g = false;
                c0602i0.e = true;
                c1.a(4, 4, "PackageSet", "Unfix admin active package: " + c0602i0.a);
                z = true;
            }
        }
        return z;
    }
}
