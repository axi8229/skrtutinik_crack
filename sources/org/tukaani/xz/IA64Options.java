package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.IA64;

/* loaded from: classes4.dex */
public class IA64Options extends BCJOptions {
    public IA64Options() {
        super(16);
    }

    @Override // org.tukaani.xz.BCJOptions
    public /* bridge */ /* synthetic */ Object clone() {
        return super.clone();
    }

    @Override // org.tukaani.xz.FilterOptions
    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        return new SimpleInputStream(inputStream, new IA64(false, this.startOffset));
    }
}
