package com.huawei.location.tiles.cache;

import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.tiles.store.dC;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class Vw {
    private static final String yn;
    private int FB;
    private int LW;
    private dC Vw;

    static {
        String str;
        try {
            str = ContextUtil.getContext().getCacheDir().getCanonicalPath() + File.separator + "tileFile";
        } catch (IOException unused) {
            LogLocation.e("TileCacheManager", "failed to get tile cache file path");
            str = "";
        }
        yn = str;
    }

    public Vw(int i, int i2) {
        this.FB = i;
        this.LW = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] yn(long r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.cache.Vw.yn(long):byte[]");
    }
}
