package com.huawei.location.tiles.store;

/* loaded from: classes3.dex */
class E5 implements Runnable {
    final /* synthetic */ dC yn;

    E5(dC dCVar) {
        this.yn = dCVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setName("SDM-TileStoreManager-" + hashCode());
        dC.Vw(this.yn);
    }
}
