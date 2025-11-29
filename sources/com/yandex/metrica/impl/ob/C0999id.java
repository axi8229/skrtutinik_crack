package com.yandex.metrica.impl.ob;

import com.yandex.metrica.modules.api.CommonIdentifiers;
import com.yandex.metrica.modules.api.ModuleFullRemoteConfig;
import com.yandex.metrica.modules.api.RemoteConfigMetaInfo;

/* renamed from: com.yandex.metrica.impl.ob.id, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0999id {
    private final CommonIdentifiers a;
    private final RemoteConfigMetaInfo b;
    private final C1178pi c;

    public C0999id(C1178pi c1178pi) {
        this.c = c1178pi;
        this.a = new CommonIdentifiers(c1178pi.V(), c1178pi.i());
        this.b = new RemoteConfigMetaInfo(c1178pi.o(), c1178pi.B());
    }

    public final ModuleFullRemoteConfig a(String str) {
        return new ModuleFullRemoteConfig(this.a, this.b, this.c.A().get(str));
    }
}
