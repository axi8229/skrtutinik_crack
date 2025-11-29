package org.jose4j.jwk;

import java.io.Serializable;
import java.security.Key;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jose4j.json.JsonUtil;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.JsonHelp;

/* loaded from: classes4.dex */
public abstract class JsonWebKey implements Serializable {
    private String algorithm;
    protected Key key;
    private String keyId;
    private List<String> keyOps;
    protected Map<String, Object> otherParameters;
    private String use;

    public enum OutputControlLevel {
        INCLUDE_PRIVATE,
        INCLUDE_SYMMETRIC,
        PUBLIC_ONLY
    }

    protected abstract void fillTypeSpecificParams(Map<String, Object> map, OutputControlLevel outputControlLevel);

    public abstract String getKeyType();

    protected JsonWebKey(Map<String, Object> map) throws JoseException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.otherParameters = linkedHashMap;
        linkedHashMap.putAll(map);
        removeFromOtherParams("kty", "use", "kid", "alg", "key_ops");
        setUse(getString(map, "use"));
        setKeyId(getString(map, "kid"));
        setAlgorithm(getString(map, "alg"));
        if (map.containsKey("key_ops")) {
            this.keyOps = JsonHelp.getStringArray(map, "key_ops");
        }
    }

    public Key getKey() {
        return this.key;
    }

    public String getUse() {
        return this.use;
    }

    public void setUse(String str) {
        this.use = str;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    protected void removeFromOtherParams(String... strArr) {
        for (String str : strArr) {
            this.otherParameters.remove(str);
        }
    }

    public Map<String, Object> toParams(OutputControlLevel outputControlLevel) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("kty", getKeyType());
        putIfNotNull("kid", getKeyId(), linkedHashMap);
        putIfNotNull("use", getUse(), linkedHashMap);
        putIfNotNull("key_ops", this.keyOps, linkedHashMap);
        putIfNotNull("alg", getAlgorithm(), linkedHashMap);
        fillTypeSpecificParams(linkedHashMap, outputControlLevel);
        linkedHashMap.putAll(this.otherParameters);
        return linkedHashMap;
    }

    public String toString() {
        return getClass().getName() + toParams(OutputControlLevel.PUBLIC_ONLY);
    }

    protected void putIfNotNull(String str, Object obj, Map<String, Object> map) {
        if (obj != null) {
            map.put(str, obj);
        }
    }

    protected static String getString(Map<String, Object> map, String str) throws JoseException {
        return JsonHelp.getStringChecked(map, str);
    }

    protected static String getStringRequired(Map<String, Object> map, String str) throws JoseException {
        return getString(map, str, true);
    }

    protected static String getString(Map<String, Object> map, String str, boolean z) throws JoseException {
        String string = getString(map, str);
        if (string != null || !z) {
            return string;
        }
        throw new JoseException("Missing required '" + str + "' parameter.");
    }

    public static class Factory {
        public static JsonWebKey newJwk(Map<String, Object> map) throws JoseException {
            String stringRequired;
            stringRequired = JsonWebKey.getStringRequired(map, "kty");
            stringRequired.hashCode();
            switch (stringRequired) {
                case "EC":
                    return new EllipticCurveJsonWebKey(map);
                case "RSA":
                    return new RsaJsonWebKey(map);
                case "oct":
                    return new OctetSequenceJsonWebKey(map);
                default:
                    throw new JoseException("Unknown key type algorithm: '" + stringRequired + "'");
            }
        }

        public static JsonWebKey newJwk(String str) throws JoseException {
            return newJwk(JsonUtil.parseJson(str));
        }
    }
}
