package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class h implements AesDecrypt {
    private final Context a;
    private final String b;
    private IDecrypt c;

    public h(Context context, String str) {
        Log.d("AGC_FlexibleDecrypt", "init");
        this.a = context;
        this.b = str;
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public String decrypt(String str, String str2) {
        if (this.c == null) {
            this.c = decryptComponent();
        }
        if (this.c == null) {
            Log.w("AGC_FlexibleDecrypt", "decrypt Flexible Decrypt error, use old instead");
            this.c = new g(this.a, this.b).decryptComponent();
        }
        return this.c.decrypt(l.a(this.a, this.b, "agc_plugin_", str), str2);
    }

    public IDecrypt decryptComponent() throws JSONException {
        String strA = l.a(this.a, this.b, "agc_plugin_", "crypto_component");
        if (strA == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Hex.decodeHexString(strA), "utf-8"));
            return new f(new d(jSONObject.getString("rx"), jSONObject.getString("ry"), jSONObject.getString("rz"), jSONObject.getString("salt"), jSONObject.getString("algorithm"), jSONObject.getInt("iterationCount")));
        } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e) {
            Log.e("AGC_FlexibleDecrypt", "FlexibleDecrypt exception: " + e.getMessage());
            return null;
        }
    }
}
