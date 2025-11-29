package com.group_ib.sdk;

import android.view.Display;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class J0 {
    public static final HashMap e;
    public final int a;
    public final String b;
    public final String c;
    public final int d;

    static {
        HashMap map = new HashMap();
        e = map;
        map.put(1, "supports protected buffers");
        map.put(2, "secure");
        map.put(4, "private");
        map.put(8, "presentation");
        map.put(16, "round");
    }

    public J0(int i, String str, String str2, int i2) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
    }

    public static J0 a(Display display) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (display == null || display.getDisplayId() == 0 || display.getState() != 2) {
            return null;
        }
        String strReplace = null;
        String string = null;
        String strReplace2 = null;
        for (String str : display.toString().split(", ")) {
            if (str.startsWith("uniqueId ")) {
                strReplace2 = str.replace("uniqueId ", "").replace("\"", "");
            } else if (str.startsWith("type ")) {
                strReplace = str.replace("type ", "");
            } else if (str.startsWith(L0.p)) {
                String[] strArrSplit = str.split(" ");
                if (strArrSplit.length > 1) {
                    string = strArrSplit[1];
                }
            }
        }
        if (strReplace == null) {
            try {
                Object objInvoke = display.getClass().getDeclaredMethod(L0.i, null).invoke(display, null);
                if (objInvoke instanceof Integer) {
                    strReplace = ((Integer) objInvoke).intValue() == display.getClass().getDeclaredField(L0.l).getInt(null) ? "virtual" : "";
                }
            } catch (Exception e2) {
                c1.a(L0.f, "failed to invoke method " + L0.i, e2);
            }
        }
        if (strReplace != null && !strReplace.equalsIgnoreCase("virtual")) {
            return null;
        }
        if (string == null) {
            try {
                Object objInvoke2 = display.getClass().getDeclaredMethod(L0.j, null).invoke(display, null);
                if (objInvoke2 != null) {
                    string = objInvoke2.toString();
                }
            } catch (Exception e3) {
                c1.a(L0.f, "failed to invoke method " + L0.j, e3);
            }
        }
        return new J0(display.getDisplayId(), strReplace2, string, display.getFlags());
    }

    public final JSONObject a() throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.a).put("uid", this.b).put(L0.k, this.c);
            if (this.d > 0) {
                jSONArray = new JSONArray();
                int i = this.d;
                int i2 = 0;
                while (i != 0) {
                    if ((i & 1) != 0) {
                        int i3 = 1 << i2;
                        Object objValueOf = (String) e.get(Integer.valueOf(i3));
                        if (objValueOf == null) {
                            objValueOf = Integer.valueOf(i3);
                        }
                        jSONArray.put(objValueOf);
                    }
                    i >>= 1;
                    i2++;
                }
            } else {
                jSONArray = null;
            }
            jSONObject.put("flags", jSONArray);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
