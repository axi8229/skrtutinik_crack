package com.group_ib.sdk;

import androidx.fragment.app.Fragment;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class O implements InterfaceC0629x {
    public static final /* synthetic */ boolean e = true;
    public Fragment a;
    public int b = -1;
    public String c = null;
    public String d = null;

    public O(Fragment fragment) {
        this.a = fragment;
    }

    @Override // com.group_ib.sdk.InterfaceC0629x
    public final JSONObject a(int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.d;
            if (str != null) {
                jSONObject.put("class", str);
            }
            String str2 = this.c;
            if (str2 != null) {
                jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
                return jSONObject;
            }
            int i2 = this.b;
            if (i2 == -1) {
                return jSONObject;
            }
            jSONObject.put("id", i2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.group_ib.sdk.InterfaceC0629x
    public final int b() {
        if (e || this.a == null) {
            return this.b;
        }
        throw new AssertionError();
    }

    @Override // com.group_ib.sdk.InterfaceC0629x
    public final boolean equals(Object obj) {
        if (!(obj instanceof O)) {
            return false;
        }
        O o = (O) obj;
        return o.b == this.b && this.d.equals(o.d);
    }

    @Override // com.group_ib.sdk.InterfaceC0629x
    public final void a() {
        Fragment fragment = this.a;
        if (fragment != null) {
            int id = fragment.getId();
            this.b = id;
            if (id != -1) {
                char[] cArr = AbstractC0604j0.a;
                if ((id >>> 24) != 0) {
                    try {
                        this.c = this.a.getResources().getResourceEntryName(this.b);
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
            this.a = null;
        }
    }
}
