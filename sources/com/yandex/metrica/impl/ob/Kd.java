package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class Kd {
    private static final Rd e = new Rd("UNDEFINED_", null);
    protected final String a;
    protected final SharedPreferences b;
    private final Map<String, Object> c = new HashMap();
    private boolean d = false;

    public Kd(Context context, String str) {
        this.a = str;
        this.b = a(context);
        new Rd(e.b(), str);
    }

    private SharedPreferences a(Context context) {
        return C0810b.a(context, d());
    }

    public void b() {
        synchronized (this) {
            a();
            this.c.clear();
            this.d = false;
        }
    }

    protected String c() {
        return this.a;
    }

    protected abstract String d();

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends Kd> T e() {
        synchronized (this) {
            this.d = true;
            this.c.clear();
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends Kd> T a(String str, Object obj) {
        synchronized (this) {
            if (obj != null) {
                try {
                    this.c.put(str, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends Kd> T a(String str) {
        synchronized (this) {
            this.c.put(str, this);
        }
        return this;
    }

    private void a() {
        SharedPreferences.Editor editorEdit = this.b.edit();
        if (this.d) {
            editorEdit.clear();
            editorEdit.apply();
            return;
        }
        for (Map.Entry<String, Object> entry : this.c.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == this) {
                editorEdit.remove(key);
            } else if (value instanceof String) {
                editorEdit.putString(key, (String) value);
            } else if (value instanceof Long) {
                editorEdit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Integer) {
                editorEdit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Boolean) {
                editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value != null) {
                throw new UnsupportedOperationException();
            }
        }
        editorEdit.apply();
    }
}
