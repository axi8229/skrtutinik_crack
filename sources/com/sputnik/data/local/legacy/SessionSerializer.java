package com.sputnik.data.local.legacy;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class SessionSerializer {
    public static Type getTypeToken(Type type, Type... typeArr) {
        return C$Gson$Types.newParameterizedTypeWithOwner(null, type, typeArr);
    }

    public static Object deserialize(String str, Type type, Type... typeArr) {
        return new Gson().fromJson(str, getTypeToken(type, typeArr));
    }

    public static String getPrefString(SharedPreferences sharedPreferences, String str, String str2) {
        return sharedPreferences.getString(str, str2);
    }

    public static Session getObject(SharedPreferences sharedPreferences, String str) {
        String prefString = getPrefString(sharedPreferences, str, null);
        if (prefString == null) {
            return null;
        }
        return (Session) deserialize(prefString, Session.class, new Type[0]);
    }
}
