package com.huawei.location.tiles.callback;

import com.huawei.location.tiles.cache.Vw;
import com.huawei.riemann.common.api.location.CityTileCallback;

/* loaded from: classes3.dex */
public class yn implements CityTileCallback {
    private int FB;
    private int Vw;
    private Vw yn;

    public yn(int i, int i2) {
        this.Vw = i;
        this.FB = i2;
        this.yn = new Vw(i, i2);
    }

    @Override // com.huawei.riemann.common.api.location.CityTileCallback
    public byte[] get(long j) {
        if (this.yn == null) {
            this.yn = new Vw(this.Vw, this.FB);
        }
        return this.yn.yn(j);
    }
}
