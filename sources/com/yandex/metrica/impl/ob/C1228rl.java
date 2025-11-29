package com.yandex.metrica.impl.ob;

import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.rl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1228rl {
    public final String a;
    public final String b;
    public final b c;
    public final int d;
    public final boolean e;
    public final c f;
    public final a g;

    /* renamed from: com.yandex.metrica.impl.ob.rl$a */
    enum a {
        LIST("LIST"),
        LABEL("LABEL"),
        BUTTON("BUTTON"),
        CONTAINER("CONTAINER"),
        TOOLBAR("TOOLBAR"),
        INPUT("INPUT"),
        IMAGE("IMAGE"),
        WEBVIEW("WEBVIEW"),
        OTHER("OTHER");

        private final String a;

        a(String str) {
            this.a = str;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.rl$b */
    enum b {
        TEXT_TOO_LONG("TEXT_TOO_LONG"),
        REGEXP_NOT_MATCHED("REGEXP_NOT_MATCHED"),
        IRRELEVANT_CLASS("IRRELEVANT_CLASS"),
        BAD_REGEXP_MATCHED("BAD_REGEXP_MATCHED"),
        EQUALS("EQUALS"),
        CONTAINS("CONTAINS");

        private final String a;

        b(String str) {
            this.a = str;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.rl$c */
    enum c {
        VIEW_CONTAINER("VIEW_CONTAINER"),
        VIEW("VIEW");

        private final String a;

        c(String str) {
            this.a = str;
        }
    }

    C1228rl(String str, String str2, b bVar, int i, boolean z, c cVar, a aVar) {
        this.a = str;
        this.b = str2;
        this.c = bVar;
        this.d = i;
        this.e = z;
        this.f = cVar;
        this.g = aVar;
    }

    b a(Ak ak) {
        return this.c;
    }

    JSONArray a(C0982hl c0982hl) {
        return null;
    }

    boolean a() {
        return false;
    }

    public String toString() {
        return "UiElement{mClassName='" + this.a + "', mId='" + this.b + "', mParseFilterReason=" + this.c + ", mDepth=" + this.d + ", mListItem=" + this.e + ", mViewType=" + this.f + ", mClassType=" + this.g + '}';
    }

    public JSONObject a(C0982hl c0982hl, b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", this.f.a);
            if (bVar == null) {
                jSONObject.put("cnt", a(c0982hl));
            }
            if (c0982hl.e) {
                JSONObject jSONObjectPut = new JSONObject().put("ct", this.g.a).put("cn", this.a).put("rid", this.b).put("d", this.d).put("lc", this.e).put("if", bVar != null);
                if (bVar != null) {
                    jSONObjectPut.put("fr", bVar.a);
                }
                jSONObject.put("i", jSONObjectPut);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
