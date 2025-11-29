package org.bouncycastle.pqc.jcajce.provider.qtesla;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAPublicKeyParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLASecurityCategory;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.util.Arrays;

/* loaded from: classes4.dex */
public class BCqTESLAPublicKey implements PublicKey {
    private transient QTESLAPublicKeyParameters keyParams;

    public BCqTESLAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        init(subjectPublicKeyInfo);
    }

    private void init(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        this.keyParams = (QTESLAPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCqTESLAPublicKey)) {
            return false;
        }
        BCqTESLAPublicKey bCqTESLAPublicKey = (BCqTESLAPublicKey) obj;
        return this.keyParams.getSecurityCategory() == bCqTESLAPublicKey.keyParams.getSecurityCategory() && Arrays.areEqual(this.keyParams.getPublicData(), bCqTESLAPublicKey.keyParams.getPublicData());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return QTESLASecurityCategory.getName(this.keyParams.getSecurityCategory());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.keyParams).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.keyParams.getSecurityCategory() + (Arrays.hashCode(this.keyParams.getPublicData()) * 37);
    }
}
