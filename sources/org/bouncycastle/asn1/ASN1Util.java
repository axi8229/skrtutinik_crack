package org.bouncycastle.asn1;

/* loaded from: classes4.dex */
public abstract class ASN1Util {
    public static String getTagText(int i, int i2) {
        StringBuilder sb;
        String str;
        if (i == 64) {
            sb = new StringBuilder();
            str = "[APPLICATION ";
        } else if (i == 128) {
            sb = new StringBuilder();
            str = "[CONTEXT ";
        } else if (i != 192) {
            sb = new StringBuilder();
            str = "[UNIVERSAL ";
        } else {
            sb = new StringBuilder();
            str = "[PRIVATE ";
        }
        sb.append(str);
        sb.append(i2);
        sb.append("]");
        return sb.toString();
    }
}
