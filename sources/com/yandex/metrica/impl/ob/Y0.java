package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.huawei.hms.android.SystemUtils;
import com.yandex.metrica.impl.ob.C1184q0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Y0 {
    private final JSONObject a = new JSONObject();
    private final Context b;
    private final C1184q0 c;

    public Y0(Context context, C1184q0 c1184q0) {
        this.b = context;
        this.c = c1184q0;
    }

    static <T> T a(JSONObject jSONObject, String str, T t) throws JSONException {
        if (!jSONObject.has(str)) {
            jSONObject.put(str, t);
        }
        return (T) jSONObject.get(str);
    }

    private void d() throws JSONException {
        if (A2.a(24)) {
            JSONObject jSONObject = (JSONObject) a(this.a, "dfid", new JSONObject());
            jSONObject.putOpt("wids", (Integer) A2.a(new B2(1), this.b, "wallpaper", "getting wallpaper id", "wallpaper manager"));
            jSONObject.putOpt("widl", (Integer) A2.a(new B2(2), this.b, "wallpaper", "getting wallpaper id", "wallpaper manager"));
        }
    }

    Y0 b() throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject = (JSONObject) a(this.a, "dfid", new JSONObject());
        if (A2.a(21)) {
            jSONArray = new JSONArray(Build.SUPPORTED_ABIS);
        } else {
            ArrayList arrayList = new ArrayList();
            String str = Build.CPU_ABI;
            if (!SystemUtils.UNKNOWN.equals(str)) {
                arrayList.add(str);
            }
            String str2 = Build.CPU_ABI2;
            if (!SystemUtils.UNKNOWN.equals(str2)) {
                arrayList.add(str2);
            }
            jSONArray = new JSONArray((Collection) arrayList);
        }
        jSONObject.put("cpu_abis", jSONArray);
        return this;
    }

    public Y0 c() {
        try {
            JSONObject jSONObject = (JSONObject) a(this.a, "dfid", new JSONObject());
            C1184q0.a aVarA = this.c.a();
            jSONObject.put("tds", aVarA.a);
            jSONObject.put("fds", aVarA.b);
            ((JSONObject) a(this.a, "dfid", new JSONObject())).put("boot_time", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000);
            d();
            ((JSONObject) a(this.a, "dfid", new JSONObject())).put("lc", Tl.b((List<?>) C0937g1.a(this.b).a()));
        } catch (Throwable unused) {
        }
        try {
            KotlinVersion.Companion companion = KotlinVersion.INSTANCE;
            Object obj = KotlinVersion.class.getDeclaredField("CURRENT").get(null);
            int iIntValue = ((Integer) obj.getClass().getDeclaredMethod("getMajor", null).invoke(obj, null)).intValue();
            int iIntValue2 = ((Integer) obj.getClass().getDeclaredMethod("getMinor", null).invoke(obj, null)).intValue();
            ((JSONObject) a(this.a, "dfid", new JSONObject())).put("kotlin_runtime", new JSONObject().put("major", iIntValue).put("minor", iIntValue2).put("patch", ((Integer) obj.getClass().getDeclaredMethod("getPatch", null).invoke(obj, null)).intValue()));
        } catch (Throwable unused2) {
        }
        return this;
    }

    public String toString() {
        return this.a.toString();
    }

    public String a() {
        return this.a.toString();
    }
}
