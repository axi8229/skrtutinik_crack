package com.huawei.location.crowdsourcing.common.util;

import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.secure.android.common.util.SafeBase64;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import ru.yoomoney.sdk.auth.utils.CipherChaCha20Poly1305Kt;

/* loaded from: classes3.dex */
public final class FB {

    enum yn {
        DEFAULT_ALG(CipherChaCha20Poly1305Kt.HASHING_ALGORITHM_HMAC_SHA_256);

        private final String FB;

        yn(String str) {
            this.FB = str;
        }

        public String yn() {
            return this.FB;
        }
    }

    public static String yn(String str, byte[] bArr) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        String str2;
        byte[] bArrDoFinal;
        byte[] bArrEncode;
        Mac mac;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, yn.DEFAULT_ALG.yn());
        try {
            mac = Mac.getInstance(secretKeySpec.getAlgorithm());
        } catch (NoSuchAlgorithmException unused) {
            str2 = "NoSuchAlgorithmException";
        }
        try {
            mac.init(secretKeySpec);
            bArrDoFinal = mac.doFinal(str.getBytes(StandardCharsets.UTF_8));
        } catch (InvalidKeyException unused2) {
            str2 = "InvalidKeyException";
            LogLocation.e("HmacUtil", str2);
            bArrDoFinal = null;
            if (bArrDoFinal == null) {
                return null;
            }
            return new String(bArrEncode, StandardCharsets.UTF_8);
        }
        if (bArrDoFinal == null && (bArrEncode = SafeBase64.encode(bArrDoFinal, 2)) != null) {
            return new String(bArrEncode, StandardCharsets.UTF_8);
        }
        return null;
    }
}
