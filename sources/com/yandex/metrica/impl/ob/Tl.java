package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.yandex.metrica.impl.ob.C1420zl;
import com.yandex.metrica.impl.ob.If;
import com.yandex.varioqub.config.model.ConfigValue;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Tl {

    public static class a extends JSONObject {
        public a() {
        }

        public Long a(String str) {
            try {
                return Long.valueOf(getLong(str));
            } catch (Throwable unused) {
                return null;
            }
        }

        public String b(String str) {
            if (!has(str) || !has(str)) {
                return "";
            }
            try {
                return getString(str);
            } catch (Throwable unused) {
                return "";
            }
        }

        public String c(String str) {
            if (has(str)) {
                try {
                    return getString(str);
                } catch (Throwable unused) {
                }
            }
            return "";
        }

        public boolean d(String str) {
            try {
                return JSONObject.NULL != get(str);
            } catch (Throwable unused) {
                return false;
            }
        }

        public a(String str) throws JSONException {
            super(str);
        }
    }

    public static <T> T a(T t, T t2) {
        return t == null ? t2 : t;
    }

    public static String a(Context context, String str) throws UnsupportedEncodingException {
        byte[] bArrA = a(context, Base64.decode(str.getBytes("UTF-8"), 0));
        if (bArrA == null) {
            return null;
        }
        try {
            return new String(L0.a(new String(bArrA, "UTF-8")), "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] b(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(str.getBytes("UTF-8"));
        return messageDigest.digest();
    }

    public static String c(Map<String, String> map) {
        if (A2.b(map)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static boolean d(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            try {
                Integer.parseInt(it.next().getValue());
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }

    public static JSONObject e(Map map) {
        if (A2.b(map)) {
            return null;
        }
        return A2.a(19) ? new JSONObject(map) : h(map);
    }

    public static JSONObject f(Map map) {
        if (map == null) {
            return null;
        }
        return map.isEmpty() ? new JSONObject() : e(map);
    }

    public static String g(Map map) {
        if (A2.b(map)) {
            return null;
        }
        return A2.a(19) ? new JSONObject(map).toString() : a((Object) map).toString();
    }

    private static JSONObject h(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String string = entry.getKey().toString();
            if (string != null) {
                linkedHashMap.put(string, a(entry.getValue()));
            }
        }
        return new JSONObject(linkedHashMap);
    }

    public static Map<String, String> i(Map<String, String> map) throws NumberFormatException {
        long j;
        HashMap map2 = new HashMap();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key) && !key.contains(":") && !key.contains(",") && !key.contains(ContainerUtils.FIELD_DELIMITER)) {
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(value)) {
                        try {
                            j = Long.parseLong(value);
                        } catch (NumberFormatException unused) {
                            j = -1;
                        }
                        if (j != -1) {
                            map2.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
        }
        return map2;
    }

    public static String b(Context context, String str) throws UnsupportedEncodingException {
        String strA;
        try {
            strA = L0.a(str.getBytes("UTF-8"));
        } catch (Throwable unused) {
            strA = null;
        }
        return Base64.encodeToString(a(context, strA.getBytes("UTF-8")), 0);
    }

    public static C0838c2 f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new C0838c2(jSONObject.optInt("width"), jSONObject.optInt("height"), jSONObject.optInt("dpi"), (float) jSONObject.optDouble("scaleFactor", ConfigValue.DOUBLE_DEFAULT_VALUE), com.yandex.metrica.b.a(jSONObject.optString("deviceType")));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Map<String, String> a(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                int iIndexOf = str2.indexOf(":");
                if (iIndexOf != -1) {
                    map.put(str2.substring(0, iIndexOf), str2.substring(iIndexOf + 1));
                }
            }
        }
        return map;
    }

    public static HashMap<String, String> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b(new JSONObject(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(List<String> list) {
        if (A2.b(list)) {
            return null;
        }
        if (A2.a(19)) {
            return new JSONArray((Collection) list).toString();
        }
        return a((Object) list).toString();
    }

    private static JSONArray b(Collection<?> collection) {
        if (collection == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return new JSONArray((Collection) arrayList);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static HashMap<String, String> e(String str) throws JSONException {
        return b(new JSONObject(str));
    }

    public static JSONArray b(List<?> list) {
        if (A2.b(list)) {
            return null;
        }
        if (A2.a(19)) {
            return new JSONArray((Collection) list);
        }
        return b((Collection<?>) list);
    }

    public static long a(Long l, TimeUnit timeUnit, long j) {
        return l == null ? j : timeUnit.toMillis(l.longValue());
    }

    private static byte[] a(Context context, byte[] bArr) {
        try {
            byte[] bArrB = b(context.getPackageName());
            byte[] bArr2 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = (byte) (bArr[i] ^ bArrB[i % bArrB.length]);
            }
            return bArr2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<String> c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList(jSONArray.length());
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        arrayList.add(jSONArray.getString(i));
                    } catch (Throwable unused) {
                        return arrayList;
                    }
                }
                return arrayList;
            } catch (Throwable unused2) {
            }
        }
        return null;
    }

    public static Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    arrayList.add(a(Array.get(obj, i)));
                }
                return new JSONArray((Collection) arrayList);
            }
            if (obj instanceof Collection) {
                return b((Collection<?>) obj);
            }
            return obj instanceof Map ? h((Map) obj) : obj;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static HashMap<String, String> b(JSONObject jSONObject) {
        if (JSONObject.NULL.equals(jSONObject)) {
            return null;
        }
        HashMap<String, String> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject.optString(next);
            if (strOptString != null) {
                map.put(next, strOptString);
            }
        }
        return map;
    }

    public static C0932fl c(JSONObject jSONObject) throws JSONException {
        C1348wl c1348wl;
        If.i iVar = new If.i();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("upc");
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("uecc");
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("ucfbc");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ruecc");
        boolean zOptBoolean = jSONObject.optBoolean("upe", iVar.o);
        boolean zOptBoolean2 = jSONObject.optBoolean("uece", iVar.p);
        boolean zOptBoolean3 = jSONObject.optBoolean("ucfbe", iVar.q);
        boolean zOptBoolean4 = jSONObject.optBoolean("ruece", iVar.u);
        if (jSONObjectOptJSONObject == null) {
            c1348wl = null;
        } else {
            If.w wVar = new If.w();
            c1348wl = new C1348wl(jSONObjectOptJSONObject.optInt("tltb", wVar.a), jSONObjectOptJSONObject.optInt("ttb", wVar.b), jSONObjectOptJSONObject.optInt("mvcl", wVar.c), jSONObjectOptJSONObject.optLong("act", wVar.d), jSONObjectOptJSONObject.optBoolean("rtsc", wVar.e), jSONObjectOptJSONObject.optBoolean("er", wVar.f), jSONObjectOptJSONObject.optBoolean("pabd", wVar.g), a(jSONObjectOptJSONObject.optJSONArray("f")));
        }
        return new C0932fl(zOptBoolean, zOptBoolean2, zOptBoolean3, zOptBoolean4, c1348wl, jSONObjectOptJSONObject2 == null ? null : a(jSONObjectOptJSONObject2, C1085m0.b()), jSONObjectOptJSONObject3 == null ? null : a(jSONObjectOptJSONObject3, C1085m0.a()), jSONObjectOptJSONObject4 != null ? a(jSONObjectOptJSONObject4, C1085m0.b()) : null);
    }

    public static String b(JSONObject jSONObject, String str) {
        if (jSONObject != null && jSONObject.has(str)) {
            try {
                return jSONObject.getString(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return map.isEmpty() ? "" : g(map);
    }

    public static List<String> b(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static Long a(JSONObject jSONObject, String str, Long l) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return l;
        }
        try {
            return Long.valueOf(jSONObject.getLong(str));
        } catch (Throwable unused) {
            return l;
        }
    }

    public static String b(Map<String, List<String>> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                JSONArray jSONArrayB = b((List<?>) entry.getValue());
                if (jSONArrayB != null) {
                    jSONObject.put(entry.getKey(), jSONArrayB.toString());
                }
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public static String a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String strB = b(jSONObject, str);
        if (jSONObject2 == null || !jSONObject2.has(str)) {
            return strB;
        }
        try {
            return jSONObject2.getString(str);
        } catch (Throwable unused) {
            return strB;
        }
    }

    public static Integer a(JSONObject jSONObject, String str, Integer num) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return num;
        }
        try {
            return Integer.valueOf(jSONObject.getInt(str));
        } catch (Throwable unused) {
            return num;
        }
    }

    public static boolean a(JSONObject jSONObject, String str, boolean z) {
        Boolean boolA = a(jSONObject, str, (Boolean) null);
        return boolA == null ? z : boolA.booleanValue();
    }

    public static Boolean a(JSONObject jSONObject, String str, Boolean bool) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return bool;
        }
        try {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        } catch (Throwable unused) {
            return bool;
        }
    }

    public static JSONArray a(Collection<C1298uj> collection) {
        JSONArray jSONArray = new JSONArray();
        if (collection != null) {
            Iterator<C1298uj> it = collection.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put(a(it.next()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject a(C1298uj c1298uj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cell_id", c1298uj.b());
        jSONObject.put("signal_strength", c1298uj.p());
        jSONObject.put("lac", c1298uj.e());
        jSONObject.put("country_code", c1298uj.k());
        jSONObject.put("operator_id", c1298uj.l());
        jSONObject.put("operator_name", c1298uj.n());
        jSONObject.put("is_connected", c1298uj.q());
        jSONObject.put("cell_type", c1298uj.c());
        jSONObject.put("pci", c1298uj.o());
        jSONObject.put("last_visible_time_offset", c1298uj.d());
        jSONObject.put("lte_rsrq", c1298uj.h());
        jSONObject.put("lte_rssnr", c1298uj.j());
        jSONObject.put("arfcn", c1298uj.a());
        jSONObject.put("lte_rssi", c1298uj.i());
        jSONObject.put("lte_bandwidth", c1298uj.f());
        jSONObject.put("lte_cqi", c1298uj.g());
        return jSONObject;
    }

    public static JSONObject a(C0932fl c0932fl) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("upe", c0932fl.a).put("uece", c0932fl.b).put("ruece", c0932fl.d).put("ucfbe", c0932fl.c);
        C1348wl c1348wl = c0932fl.e;
        JSONObject jSONObjectPutOpt = jSONObjectPut.putOpt("upc", c1348wl == null ? null : new JSONObject().put("tltb", c1348wl.a).put("ttb", c1348wl.b).put("mvcl", c1348wl.c).put("act", c1348wl.d).put("rtsc", c1348wl.e).put("er", c1348wl.f).put("pabd", c1348wl.g).put("f", a(c1348wl.h)));
        C0982hl c0982hl = c0932fl.f;
        JSONObject jSONObjectPutOpt2 = jSONObjectPutOpt.putOpt("uecc", c0982hl == null ? null : a(c0982hl));
        C0982hl c0982hl2 = c0932fl.h;
        JSONObject jSONObjectPutOpt3 = jSONObjectPutOpt2.putOpt("ruecc", c0982hl2 == null ? null : a(c0982hl2));
        C0982hl c0982hl3 = c0932fl.g;
        return jSONObjectPutOpt3.putOpt("ucfbc", c0982hl3 != null ? a(c0982hl3) : null);
    }

    private static JSONObject a(C0982hl c0982hl) throws JSONException {
        return new JSONObject().put("tsc", c0982hl.a).put("rtsc1", c0982hl.b).put("tvc", c0982hl.c).put("tsc1", c0982hl.d).put("ic", c0982hl.e).put("ncvc", c0982hl.f).put("tlc", c0982hl.g).put("vh", c0982hl.h).put("if", c0982hl.i).put("wvuc", c0982hl.j).put("tltb", c0982hl.k).put("ttb", c0982hl.l).put("mec", c0982hl.m).put("mfcl", c0982hl.n).put("wvul", c0982hl.o).put("f", a(c0982hl.p));
    }

    private static C0982hl a(JSONObject jSONObject, If.v vVar) {
        return new C0982hl(jSONObject.optBoolean("tsc", vVar.a), jSONObject.optBoolean("rtsc1", vVar.b), jSONObject.optBoolean("tvc", vVar.c), jSONObject.optBoolean("tsc1", vVar.d), jSONObject.optBoolean("ic", vVar.i), jSONObject.optBoolean("ncvc", vVar.j), jSONObject.optBoolean("tlc", vVar.k), jSONObject.optBoolean("vh", vVar.l), jSONObject.optBoolean("if", vVar.n), jSONObject.optBoolean("wvuc", vVar.o), jSONObject.optInt("tltb", vVar.e), jSONObject.optInt("ttb", vVar.f), jSONObject.optInt("mec", vVar.g), jSONObject.optInt("mfcl", vVar.h), jSONObject.optInt("wvul", vVar.p), a(jSONObject.optJSONArray("f")));
    }

    private static JSONArray a(List<C1420zl> list) {
        JSONArray jSONArray = new JSONArray();
        for (C1420zl c1420zl : list) {
            try {
                jSONArray.put(new JSONObject().put("ft", c1420zl.a.a).put("fv", c1420zl.b));
            } catch (Throwable unused) {
            }
        }
        return jSONArray;
    }

    private static List<C1420zl> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(new C1420zl(C1420zl.b.a(jSONObject.getInt("ft")), jSONObject.optString("fv")));
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    public static C1217ra a(JSONObject jSONObject) {
        return new C1217ra(a(jSONObject, "activation"), a(jSONObject, "satellite_clids"), a(jSONObject, "preload_info"));
    }

    public static JSONObject a(C1217ra c1217ra) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("activation", a(c1217ra.a));
            jSONObject.putOpt("preload_info", a(c1217ra.c));
            jSONObject.putOpt("satellite_clids", a(c1217ra.b));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static C1194qa a(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject != null) {
            return new C1194qa(jSONObjectOptJSONObject.optLong("exp_t"), jSONObjectOptJSONObject.optInt("interval"));
        }
        return null;
    }

    private static JSONObject a(C1194qa c1194qa) {
        if (c1194qa == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("exp_t", c1194qa.a).put("interval", c1194qa.b);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static String a(C0838c2 c0838c2) {
        JSONObject jSONObject;
        if (c0838c2 == null) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("width", c0838c2.e()).put("height", c0838c2.c()).put("dpi", c0838c2.b()).put("scaleFactor", c0838c2.d()).putOpt("deviceType", c0838c2.a() == null ? null : c0838c2.a().a());
            } catch (Throwable unused) {
            }
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
