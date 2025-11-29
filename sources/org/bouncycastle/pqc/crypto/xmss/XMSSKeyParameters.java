package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* loaded from: classes4.dex */
public class XMSSKeyParameters extends AsymmetricKeyParameter {
    private final String treeDigest;

    public XMSSKeyParameters(boolean z, String str) {
        super(z);
        this.treeDigest = str;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
