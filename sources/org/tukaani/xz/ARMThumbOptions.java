package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.ARMThumb;

/* loaded from: classes4.dex */
public class ARMThumbOptions extends BCJOptions {
    public ARMThumbOptions() {
        super(2);
    }

    @Override // org.tukaani.xz.BCJOptions
    public /* bridge */ /* synthetic */ Object clone() {
        return super.clone();
    }

    @Override // org.tukaani.xz.FilterOptions
    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        return new SimpleInputStream(inputStream, new ARMThumb(false, this.startOffset));
    }
}
