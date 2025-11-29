package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C1228rl;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.yandex.metrica.impl.ob.bl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0832bl extends C1228rl {
    public String h;
    public final int i;
    public Integer j;
    public final boolean k;
    public final b l;
    public final Float m;
    public final Float n;
    public final Float o;
    public final String p;
    public final Boolean q;
    public final Boolean r;
    public Integer s;

    /* renamed from: com.yandex.metrica.impl.ob.bl$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TextUtils.TruncateAt.values().length];
            a = iArr;
            try {
                iArr[TextUtils.TruncateAt.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TextUtils.TruncateAt.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TextUtils.TruncateAt.MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TextUtils.TruncateAt.MARQUEE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.bl$b */
    enum b {
        START("START"),
        END("END"),
        MIDDLE("MIDDLE"),
        MARQUEE("MARQUEE"),
        NONE("NONE"),
        UNKNOWN("UNKNOWN");

        final String a;

        b(String str) {
            this.a = str;
        }
    }

    C0832bl(String str, String str2, C1228rl.b bVar, int i, boolean z, C1228rl.a aVar, String str3, Float f, Float f2, Float f3, String str4, Boolean bool, Boolean bool2, boolean z2, int i2, b bVar2) {
        super(str, str2, null, i, z, C1228rl.c.VIEW, aVar);
        this.h = str3;
        this.i = i2;
        this.l = bVar2;
        this.k = z2;
        this.m = f;
        this.n = f2;
        this.o = f3;
        this.p = str4;
        this.q = bool;
        this.r = bool2;
    }

    @Override // com.yandex.metrica.impl.ob.C1228rl
    C1228rl.b a(Ak ak) {
        C1228rl.b bVar = this.c;
        return bVar == null ? ak.a(this.h) : bVar;
    }

    @Override // com.yandex.metrica.impl.ob.C1228rl
    boolean a() {
        return true;
    }

    @Override // com.yandex.metrica.impl.ob.C1228rl
    public String toString() {
        return "TextViewElement{mText='" + this.h + "', mVisibleTextLength=" + this.i + ", mOriginalTextLength=" + this.j + ", mIsVisible=" + this.k + ", mTextShorteningType=" + this.l + ", mSizePx=" + this.m + ", mSizeDp=" + this.n + ", mSizeSp=" + this.o + ", mColor='" + this.p + "', mIsBold=" + this.q + ", mIsItalic=" + this.r + ", mRelativeTextSize=" + this.s + ", mClassName='" + this.a + "', mId='" + this.b + "', mParseFilterReason=" + this.c + ", mDepth=" + this.d + ", mListItem=" + this.e + ", mViewType=" + this.f + ", mClassType=" + this.g + '}';
    }

    @Override // com.yandex.metrica.impl.ob.C1228rl
    JSONArray a(C0982hl c0982hl) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            String strSubstring = this.h;
            if (strSubstring.length() > c0982hl.l) {
                this.j = Integer.valueOf(this.h.length());
                strSubstring = this.h.substring(0, c0982hl.l);
            }
            jSONObject.put("t", "TEXT");
            jSONObject.put("vl", strSubstring);
            jSONObject.put("i", a(c0982hl, strSubstring));
            jSONArray.put(jSONObject);
        } catch (Throwable unused) {
        }
        return jSONArray;
    }

    private JSONObject a(C0982hl c0982hl, String str) {
        int length;
        JSONObject jSONObject = new JSONObject();
        try {
            if (c0982hl.a) {
                jSONObject.putOpt("sp", this.m).putOpt("sd", this.n).putOpt("ss", this.o);
            }
            if (c0982hl.b) {
                jSONObject.put("rts", this.s);
            }
            if (c0982hl.d) {
                jSONObject.putOpt("c", this.p).putOpt("ib", this.q).putOpt("ii", this.r);
            }
            if (c0982hl.c) {
                jSONObject.put("vtl", this.i).put("iv", this.k).put("tst", this.l.a);
            }
            Integer num = this.j;
            if (num != null) {
                length = num.intValue();
            } else {
                length = this.h.length();
            }
            if (c0982hl.g) {
                jSONObject.put("tl", str.length()).put("otl", length);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
