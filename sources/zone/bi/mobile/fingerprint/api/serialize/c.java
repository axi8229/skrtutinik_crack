package zone.bi.mobile.fingerprint.api.serialize;

import bz.AbstractC0566x0;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.yoomoney.sdk.auth.utils.CipherChaCha20Poly1305Kt;

/* loaded from: classes5.dex */
public abstract class c {
    public static String a(JSONObject jSONObject) throws JSONException {
        String str;
        String string;
        StringBuilder sb;
        TreeMap treeMap = new TreeMap();
        StringBuilder sb2 = new StringBuilder("{ ");
        try {
            String strB = jSONObject.has("WiFiNetworksData") ? b((JSONObject) jSONObject.get("WiFiNetworksData")) : "";
            boolean z = false;
            if (jSONObject.has("GeoLocationInfo")) {
                JSONArray jSONArray = (JSONArray) jSONObject.get("GeoLocationInfo");
                str = jSONArray.length() > 0 ? "[" + b((JSONObject) jSONArray.get(0)) + "]" : "\"-1\":\"-1\"";
                z = true;
            } else {
                str = "";
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                treeMap.put(next, jSONObject.getString(next));
            }
            for (String str2 : treeMap.keySet()) {
                String string2 = jSONObject.getString(str2);
                if (str2.equals("WiFiNetworksData")) {
                    sb = new StringBuilder();
                    sb.append("\"");
                    sb.append(str2);
                    sb.append("\":");
                    sb.append(strB);
                    sb.append("");
                } else if (z && str2.equals("GeoLocationInfo")) {
                    sb = new StringBuilder();
                    sb.append("\"");
                    sb.append(str2);
                    sb.append("\":");
                    sb.append(str);
                    sb.append("");
                } else {
                    string = "\"" + str2 + "\":\"" + string2 + "\"";
                    sb2.append(",");
                    sb2.append(string);
                }
                string = sb.toString();
                sb2.append(",");
                sb2.append(string);
            }
            sb2.append("}");
        } catch (JSONException unused) {
        }
        return sb2.toString().replace("{ ,", "{").replaceAll("\\s+", "");
    }

    public static String b(JSONObject jSONObject) throws JSONException {
        TreeMap treeMap = new TreeMap();
        StringBuilder sb = new StringBuilder("{ ");
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                treeMap.put(next, jSONObject.getString(next));
            }
            for (String str : treeMap.keySet()) {
                String str2 = "\"" + str + "\":\"" + jSONObject.getString(str) + "\"";
                sb.append(",");
                sb.append(str2);
            }
            sb.append("}");
        } catch (JSONException unused) {
        }
        return sb.toString();
    }

    public static String a(String str, String str2) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        String string;
        try {
            byte[] bytes = str2.getBytes();
            byte[] bytes2 = str.getBytes();
            Mac mac = Mac.getInstance(CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256);
            mac.init(new SecretKeySpec(bytes, CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256));
            byte[] bArrDoFinal = mac.doFinal(bytes2);
            if (bArrDoFinal == null) {
                return "";
            }
            int length = bArrDoFinal.length;
            if (bArrDoFinal.length <= 0) {
                string = "";
            } else {
                if (length > bArrDoFinal.length) {
                    length = bArrDoFinal.length;
                }
                StringBuilder sb = new StringBuilder(length * 2);
                for (int i = 0; i < length; i++) {
                    byte b = bArrDoFinal[i];
                    char[] cArr = AbstractC0566x0.a;
                    sb.append(cArr[(b & 255) >>> 4]);
                    sb.append(cArr[b & 15]);
                }
                string = sb.toString();
            }
            return string.toLowerCase(Locale.ROOT);
        } catch (Exception unused) {
            return "";
        }
    }
}
