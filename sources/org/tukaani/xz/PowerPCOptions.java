package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.PowerPC;

/* loaded from: classes4.dex */
public class PowerPCOptions extends BCJOptions {
    public PowerPCOptions() {
        super(4);
    }

    @Override // org.tukaani.xz.BCJOptions
    public /* bridge */ /* synthetic */ Object clone() {
        return super.clone();
    }

    @Override // org.tukaani.xz.FilterOptions
    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        return new SimpleInputStream(inputStream, new PowerPC(false, this.startOffset));
    }
}
