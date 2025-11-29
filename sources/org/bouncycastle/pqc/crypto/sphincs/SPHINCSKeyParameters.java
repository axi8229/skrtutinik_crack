package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* loaded from: classes4.dex */
public class SPHINCSKeyParameters extends AsymmetricKeyParameter {
    private final String treeDigest;

    protected SPHINCSKeyParameters(boolean z, String str) {
        super(z);
        this.treeDigest = str;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
