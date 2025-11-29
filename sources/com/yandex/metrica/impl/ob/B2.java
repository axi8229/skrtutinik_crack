package com.yandex.metrica.impl.ob;

import android.app.WallpaperManager;

/* loaded from: classes3.dex */
final class B2<T, R> implements InterfaceC1157om<WallpaperManager, Integer> {
    final /* synthetic */ int a;

    B2(int i) {
        this.a = i;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1157om
    public Integer a(WallpaperManager wallpaperManager) {
        return Integer.valueOf(wallpaperManager.getWallpaperId(this.a));
    }
}
