package org.jose4j.jwk;

import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.lang.JoseException;

/* loaded from: classes4.dex */
public class OctetSequenceJsonWebKey extends JsonWebKey {
    private byte[] octetSequence;

    public OctetSequenceJsonWebKey(Map<String, Object> map) throws JoseException {
        super(map);
        this.octetSequence = new Base64Url().base64UrlDecode(JsonWebKey.getStringRequired(map, "k"));
        this.key = new SecretKeySpec(this.octetSequence, "AES");
        removeFromOtherParams("k");
    }

    @Override // org.jose4j.jwk.JsonWebKey
    public String getKeyType() {
        return "oct";
    }

    private String getEncoded() {
        return Base64Url.encode(this.octetSequence);
    }

    @Override // org.jose4j.jwk.JsonWebKey
    protected void fillTypeSpecificParams(Map<String, Object> map, JsonWebKey.OutputControlLevel outputControlLevel) {
        if (JsonWebKey.OutputControlLevel.INCLUDE_SYMMETRIC.compareTo(outputControlLevel) >= 0) {
            map.put("k", getEncoded());
        }
    }
}
