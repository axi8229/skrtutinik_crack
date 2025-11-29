package com.huawei.location.utils;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.util.SafeBase64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class yn {
    public static String Vw(IMessageEntity iMessageEntity) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        String str;
        JSONObject jSONObject = new JSONObject();
        for (Class<?> superclass = iMessageEntity.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                for (Field field : superclass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        boolean zIsAccessible = field.isAccessible();
                        field.setAccessible(true);
                        String name = field.getName();
                        Object obj = field.get(iMessageEntity);
                        field.setAccessible(zIsAccessible);
                        yn(name, obj, jSONObject);
                    }
                }
            } catch (IllegalAccessException unused) {
                str = "catch IllegalAccessException";
                LogLocation.e("JsonUtil", str);
                return jSONObject.toString();
            } catch (SecurityException unused2) {
                str = "catch SecurityException";
                LogLocation.e("JsonUtil", str);
                return jSONObject.toString();
            } catch (JSONException unused3) {
                str = "catch JSONException";
                LogLocation.e("JsonUtil", str);
                return jSONObject.toString();
            }
        }
        return jSONObject.toString();
    }

    private static Map Vw(Type type, JSONObject jSONObject) throws IllegalAccessException, JSONException, InstantiationException {
        Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        JSONArray jSONArray = new JSONArray(jSONObject.getString("_map_"));
        HashMap map = new HashMap();
        for (int i = 0; i < jSONArray.length(); i += 2) {
            Object objNewInstance = cls.newInstance();
            if (objNewInstance instanceof IMessageEntity) {
                map.put(jSONArray.get(i), yn(jSONArray.getString(i + 1), (IMessageEntity) objNewInstance));
            } else {
                map.put(jSONArray.get(i), jSONArray.get(i + 1));
            }
        }
        return map;
    }

    public static IMessageEntity yn(String str, IMessageEntity iMessageEntity) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (Class<?> superclass = iMessageEntity.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                for (Field field : superclass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        try {
                            yn(iMessageEntity, field, jSONObject);
                        } catch (IllegalAccessException unused) {
                            LogLocation.e("JsonUtil", "jsonToEntity, set value of the field exception, field name:" + field.getName());
                        }
                    }
                }
            }
        } catch (Exception unused2) {
            LogLocation.e("JsonUtil", "catch Exception when parse jsonString");
        }
        return iMessageEntity;
    }

    private static String yn(IMessageEntity iMessageEntity) throws IllegalAccessException, JSONException, SecurityException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject();
        for (Class<?> superclass = iMessageEntity.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    boolean zIsAccessible = field.isAccessible();
                    field.setAccessible(true);
                    String name = field.getName();
                    Object obj = field.get(iMessageEntity);
                    field.setAccessible(zIsAccessible);
                    yn(name, obj, jSONObject);
                }
            }
        }
        return jSONObject.toString();
    }

    private static List<Object> yn(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        int i = jSONObject.getInt("_list_size_");
        int i2 = jSONObject.getInt("_val_type_");
        ArrayList arrayList = new ArrayList(i);
        for (int i3 = 0; i3 < i; i3++) {
            Object objYn = jSONObject.get("_list_item_" + i3);
            if (i2 == 0 && (type instanceof ParameterizedType)) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    Object objNewInstance = ((Class) type2).newInstance();
                    if ((objNewInstance instanceof IMessageEntity) && (objYn instanceof String)) {
                        objYn = yn((String) objYn, (IMessageEntity) objNewInstance);
                        arrayList.add(objYn);
                    }
                }
            } else if (i2 == 1) {
                arrayList.add(objYn);
            } else {
                LogLocation.d("JsonUtil", "readList");
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean yn(java.lang.String r7, java.lang.Object r8, org.json.JSONObject r9) throws org.json.JSONException, java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.utils.yn.yn(java.lang.String, java.lang.Object, org.json.JSONObject):boolean");
    }

    private static void yn(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException {
        Object obj;
        String name = field.getName();
        Object objYn = null;
        if (jSONObject.has(name)) {
            obj = jSONObject.get(name);
        } else {
            String str = "header";
            if (!jSONObject.has("header") || !jSONObject.getJSONObject("header").has(name)) {
                str = "body";
                if (!jSONObject.has("body") || !jSONObject.getJSONObject("body").has(name)) {
                    obj = null;
                }
            }
            jSONObject = jSONObject.getJSONObject(str);
            obj = jSONObject.get(name);
        }
        if (obj != null) {
            try {
                if (field.getType().getName().startsWith("com.huawei") && (field.getType().newInstance() instanceof IMessageEntity) && (obj instanceof String)) {
                    objYn = yn((String) obj, (IMessageEntity) field.getType().newInstance());
                } else if ((obj instanceof JSONObject) && ((JSONObject) obj).has("_val_type_")) {
                    int i = ((JSONObject) obj).getInt("_val_type_");
                    if (i == 1 || i == 0) {
                        objYn = yn(field.getGenericType(), (JSONObject) obj);
                    } else if (i == 2) {
                        objYn = SafeBase64.decode(((JSONObject) obj).getString("_byte_"), 2);
                    } else if (i != 3) {
                        LogLocation.e("JsonUtil", "cannot support type : " + i);
                    } else {
                        objYn = Vw(field.getGenericType(), (JSONObject) obj);
                    }
                } else {
                    objYn = obj;
                }
            } catch (InstantiationException unused) {
                LogLocation.e("JsonUtil", "catch InstantiationException");
            }
        }
        if (objYn != null) {
            boolean zIsAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(iMessageEntity, objYn);
            field.setAccessible(zIsAccessible);
        }
    }
}
