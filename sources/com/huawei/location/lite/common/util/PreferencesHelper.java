package com.huawei.location.lite.common.util;

import android.content.SharedPreferences;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class PreferencesHelper {
    private static final Map<String, ?> DEF_MAP_VALUE = new HashMap();
    private SharedPreferences sharedPreferences;

    public PreferencesHelper(String str) {
        this(str, 0);
    }

    public PreferencesHelper(String str, int i) {
        try {
            this.sharedPreferences = (SDKComponentType.getComponentType() == 200 ? ContextUtil.getHMSContext() : ContextUtil.getContext()).createDeviceProtectedStorageContext().getSharedPreferences(str, i);
        } catch (Exception e) {
            LogLocation.e("LocationPreferences", "init getSharedPreferences fail:" + e.getMessage());
        }
    }

    public long getLong(String str) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            return -1L;
        }
        try {
            return sharedPreferences.getLong(str, -1L);
        } catch (Exception unused) {
            LogLocation.e("LocationPreferences", "getLong fail");
            return -1L;
        }
    }

    public String getString(String str) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            return "";
        }
        try {
            return sharedPreferences.getString(str, "");
        } catch (Exception unused) {
            LogLocation.e("LocationPreferences", "getString fail");
            return "";
        }
    }

    public boolean remove(String str) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            return false;
        }
        try {
            return sharedPreferences.edit().remove(str).commit();
        } catch (Exception unused) {
            LogLocation.e("LocationPreferences", "remove fail");
            return false;
        }
    }

    public boolean saveLong(String str, long j) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            return false;
        }
        try {
            return sharedPreferences.edit().putLong(str, j).commit();
        } catch (Exception unused) {
            LogLocation.e("LocationPreferences", "saveLong fail");
            return false;
        }
    }

    public boolean saveString(String str, String str2) {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        if (sharedPreferences == null) {
            return false;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (editorEdit != null) {
                editorEdit.putString(str, str2);
                return editorEdit.commit();
            }
        } catch (Exception unused) {
            LogLocation.e("LocationPreferences", "saveString fail");
        }
        return false;
    }
}
