package org.tukaani.xz;

/* loaded from: classes4.dex */
abstract class BCJOptions extends FilterOptions {
    private final int alignment;
    int startOffset = 0;

    BCJOptions(int i) {
        this.alignment = i;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException();
        }
    }
}
