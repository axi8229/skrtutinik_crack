package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* renamed from: com.yandex.metrica.impl.ob.d9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0870d9 {
    private final S7 a;
    private final String b;

    public AbstractC0870d9(S7 s7) {
        this(s7, null);
    }

    public long a(String str, long j) {
        return this.a.a(str, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends AbstractC0870d9> T b(String str, String str2) {
        synchronized (this) {
            this.a.a(str, str2);
        }
        return this;
    }

    public boolean c(String str) {
        return this.a.a(str);
    }

    protected Rd d(String str) {
        return new Rd(str, this.b);
    }

    String e(String str) {
        return this.a.b(str, (String) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractC0870d9> T f(String str) {
        synchronized (this) {
            this.a.b(str);
        }
        return this;
    }

    public AbstractC0870d9(S7 s7, String str) {
        this.a = s7;
        this.b = str;
    }

    public int a(String str, int i) {
        return this.a.a(str, i);
    }

    public Set<String> e() {
        return this.a.a();
    }

    public String a(String str, String str2) {
        return this.a.b(str, str2);
    }

    public boolean a(String str, boolean z) {
        return this.a.b(str, z);
    }

    public void d() {
        synchronized (this) {
            this.a.b();
        }
    }

    List<String> a(String str, List<String> list) {
        String[] strArr = list == null ? null : (String[]) list.toArray(new String[list.size()]);
        String strB = this.a.b(str, (String) null);
        if (!TextUtils.isEmpty(strB)) {
            try {
                JSONArray jSONArray = new JSONArray(strB);
                strArr = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    strArr[i] = jSONArray.optString(i);
                }
            } catch (Throwable unused) {
            }
        }
        if (strArr == null) {
            return null;
        }
        return Arrays.asList(strArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractC0870d9> T b(String str, long j) {
        synchronized (this) {
            this.a.b(str, j);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends AbstractC0870d9> T b(String str, int i) {
        synchronized (this) {
            this.a.b(str, i);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends AbstractC0870d9> T b(String str, boolean z) {
        synchronized (this) {
            this.a.a(str, z);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends AbstractC0870d9> T b(String str, List<String> list) {
        String string;
        String[] strArr = (String[]) list.toArray(new String[list.size()]);
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : strArr) {
                jSONArray.put(str2);
            }
            string = jSONArray.toString();
        } catch (Throwable unused) {
            string = null;
        }
        this.a.a(str, string);
        return this;
    }
}
