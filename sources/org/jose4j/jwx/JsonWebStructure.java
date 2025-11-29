package org.jose4j.jwx;

import java.security.Key;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.lang.JoseException;

/* loaded from: classes4.dex */
public abstract class JsonWebStructure {
    private static final ProviderContext DEFAULT_PROVIDER_CONTEXT = new ProviderContext();
    private byte[] integrity;
    private Key key;
    protected String rawCompactSerialization;
    protected Base64Url base64url = new Base64Url();
    protected Headers headers = new Headers();
    protected boolean doKeyValidation = true;
    private AlgorithmConstraints algorithmConstraints = AlgorithmConstraints.NO_CONSTRAINTS;
    private Set<String> knownCriticalHeaders = Collections.emptySet();
    private ProviderContext providerCtx = DEFAULT_PROVIDER_CONTEXT;

    protected abstract boolean isSupportedCriticalHeader(String str);

    protected abstract void onNewKey();

    protected abstract void setCompactSerializationParts(String[] strArr) throws JoseException;

    public void setCompactSerialization(String str) throws JoseException {
        setCompactSerializationParts(CompactSerializer.deserialize(str));
        this.rawCompactSerialization = str;
    }

    protected String getEncodedHeader() {
        return this.headers.getEncodedHeader();
    }

    public void setHeader(String str, String str2) {
        this.headers.setStringHeaderValue(str, str2);
    }

    protected void setEncodedHeader(String str) throws JoseException {
        checkNotEmptyPart(str, "Encoded Header");
        this.headers.setEncodedHeader(str);
    }

    public Headers getHeaders() {
        return this.headers;
    }

    protected void checkNotEmptyPart(String str, String str2) throws JoseException {
        if (str == null || str.length() == 0) {
            throw new JoseException("The " + str2 + " cannot be empty.");
        }
    }

    public String getHeader(String str) {
        return this.headers.getStringHeaderValue(str);
    }

    public void setAlgorithmHeaderValue(String str) {
        setHeader("alg", str);
    }

    public String getAlgorithmHeaderValue() {
        return getHeader("alg");
    }

    public String getKeyIdHeaderValue() {
        return getHeader("kid");
    }

    public Key getKey() {
        return this.key;
    }

    public void setKey(Key key) {
        Key key2 = this.key;
        if (key != null ? key2 == null || !key.equals(key2) : key2 != null) {
            onNewKey();
        }
        this.key = key;
    }

    protected byte[] getIntegrity() {
        return this.integrity;
    }

    protected void setIntegrity(byte[] bArr) {
        this.integrity = bArr;
    }

    public boolean isDoKeyValidation() {
        return this.doKeyValidation;
    }

    protected AlgorithmConstraints getAlgorithmConstraints() {
        return this.algorithmConstraints;
    }

    public void setAlgorithmConstraints(AlgorithmConstraints algorithmConstraints) {
        this.algorithmConstraints = algorithmConstraints;
    }

    protected void checkCrit() throws JoseException {
        List<String> listAsList;
        Object objectHeaderValue = this.headers.getObjectHeaderValue("crit");
        if (objectHeaderValue != null) {
            if (objectHeaderValue instanceof List) {
                listAsList = (List) objectHeaderValue;
            } else if (objectHeaderValue instanceof String[]) {
                listAsList = Arrays.asList((String[]) objectHeaderValue);
            } else {
                throw new JoseException("crit header value not an array (" + objectHeaderValue.getClass() + ").");
            }
            for (String str : listAsList) {
                if (!this.knownCriticalHeaders.contains(str) && !isSupportedCriticalHeader(str)) {
                    throw new JoseException("Unrecognized header '" + str + "' marked as critical.");
                }
            }
        }
    }

    protected ProviderContext getProviderCtx() {
        return this.providerCtx;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(getHeaders().getFullHeaderAsJsonString());
        if (this.rawCompactSerialization != null) {
            sb.append("->");
            sb.append(this.rawCompactSerialization);
        }
        return sb.toString();
    }
}
