package com.huawei.updatesdk.b.e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.updatesdk.service.otaupdate.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b extends a {
    private String a = "";

    private String a(Context context, String str) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        byte[] bArr = new byte[inputStreamOpen.available()];
        com.huawei.updatesdk.a.a.a.b("AppTouchTaskInit", "loadJSONFromAsset code: " + inputStreamOpen.read(bArr));
        inputStreamOpen.close();
        return new String(bArr, "UTF-8");
    }

    @Override // com.huawei.updatesdk.b.e.a
    String a() {
        return "com.huawei.apptouch.updatesdk";
    }

    @Override // com.huawei.updatesdk.b.e.a
    String a(Context context) throws JSONException {
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        try {
            JSONArray jSONArray = new JSONObject(a(context, "grs_sdk_global_route_config_apptouchupdatesdk.json")).getJSONArray("services").getJSONObject(0).getJSONArray("servings");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (TextUtils.equals("DR3", jSONObject.getString("countryOrAreaGroup"))) {
                    this.a = jSONObject.getJSONObject("addresses").getString("ROOT");
                }
            }
        } catch (Exception unused) {
            com.huawei.updatesdk.a.a.a.a("AppTouchTaskInit", "Failed to obtain the default url.");
        }
        return this.a;
    }

    @Override // com.huawei.updatesdk.b.e.a
    public void a(List<String> list) {
    }

    @Override // com.huawei.updatesdk.b.e.a
    public String b() {
        return f.e().c();
    }

    @Override // com.huawei.updatesdk.b.e.a
    public boolean d() {
        return true;
    }
}
