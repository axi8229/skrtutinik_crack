package org.jose4j.jwk;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.keys.BigEndianBigInteger;
import org.jose4j.keys.X509Util;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.JsonHelp;

/* loaded from: classes4.dex */
public abstract class PublicJsonWebKey extends JsonWebKey {
    private List<X509Certificate> certificateChain;
    protected String jcaProvider;
    protected PrivateKey privateKey;
    protected boolean writeOutPrivateKeyToJson;
    private String x5t;
    private String x5tS256;
    private String x5u;

    protected abstract void fillPrivateTypeSpecificParams(Map<String, Object> map);

    protected abstract void fillPublicTypeSpecificParams(Map<String, Object> map);

    protected PublicJsonWebKey(Map<String, Object> map, String str) throws JoseException {
        super(map);
        this.jcaProvider = str;
        if (map.containsKey("x5c")) {
            List<String> stringArray = JsonHelp.getStringArray(map, "x5c");
            this.certificateChain = new ArrayList(stringArray.size());
            X509Util x509Util = X509Util.getX509Util(str);
            Iterator<String> it = stringArray.iterator();
            while (it.hasNext()) {
                this.certificateChain.add(x509Util.fromBase64Der(it.next()));
            }
        }
        this.x5t = JsonWebKey.getString(map, "x5t");
        this.x5tS256 = JsonWebKey.getString(map, "x5t#S256");
        this.x5u = JsonWebKey.getString(map, "x5u");
        removeFromOtherParams("x5c", "x5t#S256", "x5t", "x5u");
    }

    @Override // org.jose4j.jwk.JsonWebKey
    protected void fillTypeSpecificParams(Map<String, Object> map, JsonWebKey.OutputControlLevel outputControlLevel) {
        fillPublicTypeSpecificParams(map);
        if (this.certificateChain != null) {
            X509Util x509Util = new X509Util();
            ArrayList arrayList = new ArrayList(this.certificateChain.size());
            Iterator<X509Certificate> it = this.certificateChain.iterator();
            while (it.hasNext()) {
                arrayList.add(x509Util.toBase64(it.next()));
            }
            map.put("x5c", arrayList);
        }
        putIfNotNull("x5t", this.x5t, map);
        putIfNotNull("x5t#S256", this.x5tS256, map);
        putIfNotNull("x5u", this.x5u, map);
        if (this.writeOutPrivateKeyToJson || outputControlLevel == JsonWebKey.OutputControlLevel.INCLUDE_PRIVATE) {
            fillPrivateTypeSpecificParams(map);
        }
    }

    public PublicKey getPublicKey() {
        return (PublicKey) this.key;
    }

    public X509Certificate getLeafCertificate() {
        List<X509Certificate> list = this.certificateChain;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.certificateChain.get(0);
    }

    void checkForBareKeyCertMismatch() {
        X509Certificate leafCertificate = getLeafCertificate();
        if (leafCertificate == null || leafCertificate.getPublicKey().equals(getPublicKey())) {
            return;
        }
        throw new IllegalArgumentException("The key in the first certificate MUST match the bare public key represented by other members of the JWK. Public key = " + getPublicKey() + " cert = " + leafCertificate);
    }

    BigInteger getBigIntFromBase64UrlEncodedParam(Map<String, Object> map, String str, boolean z) throws JoseException {
        return BigEndianBigInteger.fromBase64Url(JsonWebKey.getString(map, str, z));
    }

    void putBigIntAsBase64UrlEncodedParam(Map<String, Object> map, String str, BigInteger bigInteger) {
        map.put(str, BigEndianBigInteger.toBase64Url(bigInteger));
    }

    void putBigIntAsBase64UrlEncodedParam(Map<String, Object> map, String str, BigInteger bigInteger, int i) {
        map.put(str, BigEndianBigInteger.toBase64Url(bigInteger, i));
    }
}
