package org.tukaani.xz;

import java.io.InputStream;

/* loaded from: classes4.dex */
public class DeltaOptions extends FilterOptions {
    private int distance = 1;

    public DeltaOptions(int i) throws UnsupportedOptionsException {
        setDistance(i);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new RuntimeException();
        }
    }

    @Override // org.tukaani.xz.FilterOptions
    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        return new DeltaInputStream(inputStream, this.distance);
    }

    public void setDistance(int i) throws UnsupportedOptionsException {
        if (i >= 1 && i <= 256) {
            this.distance = i;
            return;
        }
        throw new UnsupportedOptionsException("Delta distance must be in the range [1, 256]: " + i);
    }
}
