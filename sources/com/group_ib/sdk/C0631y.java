package com.group_ib.sdk;

import android.view.View;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.group_ib.sdk.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0631y implements InterfaceC0629x {
    public static final /* synthetic */ boolean m = true;
    public View a;
    public final int b;
    public int c;
    public String d;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public String h = null;
    public final int i;
    public final int j;
    public int k;
    public int l;

    public C0631y(View view, int[] iArr, int i) {
        this.a = view;
        this.b = i;
        this.i = iArr[0];
        this.j = iArr[1];
    }

    @Override // com.group_ib.sdk.InterfaceC0629x
    public final JSONObject a(int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.d;
            if (str != null) {
                jSONObject.put("class", str);
            }
            String str2 = this.h;
            if (str2 != null) {
                jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
            } else {
                int i2 = this.c;
                if (i2 != -1) {
                    jSONObject.put("id", i2);
                }
            }
            int i3 = this.b;
            if (i3 != 0) {
                jSONObject.put("index", i3);
            }
            if ((i & 2) != 0) {
                jSONObject.put("properties", new JSONObject().put("enabled", this.e).put("clickable", this.f).put("focusable", this.g));
            }
            if ((i & 1) == 0) {
                return jSONObject;
            }
            jSONObject.put("geometry", new JSONObject().put("left", this.i).put("top", this.j).put("w", this.k).put("h", this.l));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.group_ib.sdk.InterfaceC0629x
    public final int b() {
        if (m || this.a == null) {
            return this.c;
        }
        throw new AssertionError();
    }

    @Override // com.group_ib.sdk.InterfaceC0629x
    public final boolean equals(Object obj) {
        if (!(obj instanceof C0631y)) {
            return false;
        }
        C0631y c0631y = (C0631y) obj;
        return c0631y.c == this.c && this.b == c0631y.b && this.d.equals(c0631y.d);
    }

    @Override // com.group_ib.sdk.InterfaceC0629x
    public final void a() {
        View view = this.a;
        if (view != null) {
            int id = view.getId();
            this.c = id;
            if (id != -1) {
                char[] cArr = AbstractC0604j0.a;
                if ((id >>> 24) != 0) {
                    try {
                        this.h = this.a.getResources().getResourceEntryName(this.c);
                    } catch (Exception unused) {
                    }
                }
            }
            String name = this.a.getClass().getName();
            this.d = name;
            if (name.lastIndexOf(".") > 0) {
                String str = this.d;
                this.d = str.substring(str.lastIndexOf(".") + 1);
            }
            this.k = this.a.getWidth();
            this.l = this.a.getHeight();
            this.e = this.a.isEnabled();
            this.f = this.a.isClickable();
            this.g = this.a.isFocusable();
            this.a = null;
        }
    }
}
