package org.jose4j.jwa;

import java.security.Key;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes4.dex */
public class CryptoPrimitive {
    private final Cipher cip;
    private final KeyAgreement kag;
    private final Key key;
    private final Mac mac;
    private final Signature sig;

    public CryptoPrimitive(Signature signature) {
        this(signature, null, null, null, null);
    }

    public CryptoPrimitive(Mac mac) {
        this(null, null, mac, null, null);
    }

    private CryptoPrimitive(Signature signature, Cipher cipher, Mac mac, Key key, KeyAgreement keyAgreement) {
        this.sig = signature;
        this.cip = cipher;
        this.mac = mac;
        this.key = key;
        this.kag = keyAgreement;
    }

    public Signature getSignature() {
        return this.sig;
    }

    public Mac getMac() {
        return this.mac;
    }
}
