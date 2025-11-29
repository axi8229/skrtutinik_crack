package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public abstract class FilterOptions implements Cloneable {
    FilterOptions() {
    }

    public InputStream getInputStream(InputStream inputStream) throws IOException {
        return getInputStream(inputStream, ArrayCache.getDefaultCache());
    }

    public abstract InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) throws IOException;
}
