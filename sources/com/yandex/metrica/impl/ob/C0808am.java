package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import org.json.JSONException;

/* renamed from: com.yandex.metrica.impl.ob.am, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0808am extends HashMap<String, String> {
    private int a;

    public C0808am() {
        this.a = 0;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String put(String str, String str2) {
        if (!containsKey(str)) {
            if (str2 == null) {
                return null;
            }
            this.a += str.length() + str2.length();
            return (String) super.put(str, str2);
        }
        if (str2 == null) {
            return remove(str);
        }
        String str3 = get(str);
        this.a += str2.length() - (str3 == null ? 0 : str3.length());
        return (String) super.put(str, str2);
    }

    public C0808am(String str) throws JSONException {
        super(Tl.e(str));
        this.a = 0;
        for (String str2 : keySet()) {
            String str3 = (String) get(str2);
            this.a += str2.length() + (str3 == null ? 0 : str3.length());
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String remove(Object obj) {
        if (containsKey(obj)) {
            String str = get(obj);
            this.a -= ((String) obj).length() + (str == null ? 0 : str.length());
        }
        return (String) super.remove(obj);
    }

    public int a() {
        return this.a;
    }
}
