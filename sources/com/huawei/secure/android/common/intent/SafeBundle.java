package com.huawei.secure.android.common.intent;

import android.os.Bundle;
import android.os.Parcelable;
import com.huawei.secure.android.common.activity.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes3.dex */
public class SafeBundle {
    private final Bundle a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.a.containsKey(str);
        } catch (Throwable unused) {
            a.a("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.a.get(str);
        } catch (Throwable th) {
            a.a("SafeBundle", "get exception: " + th.getMessage(), true);
            return null;
        }
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public Bundle getBundle() {
        return this.a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public <T extends Parcelable> T getParcelable(String str) {
        try {
            return (T) this.a.getParcelable(str);
        } catch (Throwable th) {
            a.a("SafeBundle", "getParcelable exception: " + th.getMessage(), true);
            return null;
        }
    }

    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String str) {
        try {
            return this.a.getParcelableArrayList(str);
        } catch (Throwable th) {
            a.a("SafeBundle", "getParcelableArrayList exception: " + th.getMessage(), true);
            return null;
        }
    }

    public Serializable getSerializable(String str) {
        try {
            return this.a.getSerializable(str);
        } catch (Throwable th) {
            a.a("SafeBundle", "getSerializable exception: " + th.getMessage(), true);
            return null;
        }
    }

    public String getString(String str) {
        try {
            return this.a.getString(str);
        } catch (Throwable th) {
            a.a("SafeBundle", "getString exception: " + th.getMessage(), true);
            return "";
        }
    }

    public Set<String> keySet() {
        try {
            return this.a.keySet();
        } catch (Throwable unused) {
            a.a("SafeBundle", "keySet exception.");
            return null;
        }
    }

    public SafeBundle putInt(String str, int i) {
        try {
            this.a.putInt(str, i);
        } catch (Throwable th) {
            a.a("SafeBundle", "putInt exception: " + th.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putParcelable(String str, Parcelable parcelable) {
        try {
            this.a.putParcelable(str, parcelable);
        } catch (Throwable th) {
            a.a("SafeBundle", "putParcelable exception: " + th.getMessage(), true);
        }
        return this;
    }

    public SafeBundle putSerializable(String str, Serializable serializable) {
        try {
            this.a.putSerializable(str, serializable);
        } catch (Throwable th) {
            a.a("SafeBundle", "putSerializable exception: " + th.getMessage(), true);
        }
        return this;
    }

    public String toString() {
        try {
            return this.a.toString();
        } catch (Throwable unused) {
            a.a("SafeBundle", "toString exception.");
            return null;
        }
    }

    public SafeBundle(Bundle bundle) {
        this.a = bundle == null ? new Bundle() : bundle;
    }

    public boolean getBoolean(String str, boolean z) {
        try {
            return this.a.getBoolean(str, z);
        } catch (Throwable th) {
            a.a("SafeBundle", "getBoolean exception : " + th.getMessage(), true);
            return z;
        }
    }

    public int getInt(String str, int i) {
        try {
            return this.a.getInt(str, i);
        } catch (Throwable th) {
            a.a("SafeBundle", "getInt exception: " + th.getMessage(), true);
            return i;
        }
    }
}
