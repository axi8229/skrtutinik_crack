package com.group_ib.sdk;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b1 extends HashMap {
    public final b1 a() {
        b1 b1Var = null;
        for (Map.Entry entry : entrySet()) {
            if (entry.getValue() instanceof a1) {
                if (b1Var == null) {
                    b1Var = new b1();
                }
                b1Var.put(entry.getKey(), entry.getValue());
            }
        }
        return b1Var;
    }

    public final b1 a(b1 b1Var) {
        b1 b1Var2 = null;
        for (Map.Entry entry : entrySet()) {
            if (entry.getValue() instanceof a1) {
                if (b1Var2 == null) {
                    b1Var2 = new b1();
                }
                b1Var2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : b1Var.entrySet()) {
            Object value = entry2.getValue();
            Object obj = get(entry2.getKey());
            if (((value == null) ^ (obj == null)) || (value != null && !value.equals(obj))) {
                if (b1Var2 == null) {
                    b1Var2 = new b1();
                }
                b1Var2.put(entry2.getKey(), value);
            }
        }
        return b1Var2;
    }

    public final JSONObject a(int i) throws JSONException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Object value;
        byte[] bArrDoFinal;
        try {
            if (isEmpty()) {
                return null;
            }
            if (i == 4) {
                String str = T.a;
                return null;
            }
            JSONObject jSONObject = null;
            for (Map.Entry entry : entrySet()) {
                if ((T.a((String) entry.getKey()) & i) != 0 && (value = entry.getValue()) != null && i != -1) {
                    if (i == 2) {
                        byte[] bytes = value.toString().getBytes();
                        char[] cArr = AbstractC0604j0.a;
                        value = Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(bytes), 2);
                    } else if (i == 4) {
                        byte[] bytes2 = value.toString().getBytes();
                        char[] cArr2 = AbstractC0604j0.a;
                        try {
                            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                            cipher.init(1, (Key) null);
                            bArrDoFinal = cipher.doFinal(bytes2);
                        } catch (Exception e) {
                            c1.b("rsaEncrypt", "failed to encrypt with given RSA public key", e);
                            bArrDoFinal = null;
                        }
                        value = Base64.encodeToString(bArrDoFinal, 2);
                    }
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put((String) entry.getKey(), value);
                }
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(String str, String str2) {
        if (c1.b(5)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append('\n');
            for (Map.Entry entry : entrySet()) {
                if (entry.getValue() != null) {
                    sb.append('\t');
                    sb.append((String) entry.getKey());
                    sb.append(": ");
                    sb.append(entry.getValue().toString());
                    sb.append('\n');
                }
            }
            c1.a(4, 4, str, sb.toString());
        }
    }
}
