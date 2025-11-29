package com.yandex.metrica.modules.api;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class ModuleFullRemoteConfig {
    private final CommonIdentifiers a;
    private final RemoteConfigMetaInfo b;
    private final Object c;

    public ModuleFullRemoteConfig(CommonIdentifiers commonIdentifiers, RemoteConfigMetaInfo remoteConfigMetaInfo, Object obj) {
        Intrinsics.checkNotNullParameter(commonIdentifiers, "commonIdentifiers");
        Intrinsics.checkNotNullParameter(remoteConfigMetaInfo, "remoteConfigMetaInfo");
        this.a = commonIdentifiers;
        this.b = remoteConfigMetaInfo;
        this.c = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModuleFullRemoteConfig)) {
            return false;
        }
        ModuleFullRemoteConfig moduleFullRemoteConfig = (ModuleFullRemoteConfig) obj;
        return Intrinsics.areEqual(this.a, moduleFullRemoteConfig.a) && Intrinsics.areEqual(this.b, moduleFullRemoteConfig.b) && Intrinsics.areEqual(this.c, moduleFullRemoteConfig.c);
    }

    public int hashCode() {
        CommonIdentifiers commonIdentifiers = this.a;
        int iHashCode = (commonIdentifiers != null ? commonIdentifiers.hashCode() : 0) * 31;
        RemoteConfigMetaInfo remoteConfigMetaInfo = this.b;
        int iHashCode2 = (iHashCode + (remoteConfigMetaInfo != null ? remoteConfigMetaInfo.hashCode() : 0)) * 31;
        Object obj = this.c;
        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "ModuleFullRemoteConfig(commonIdentifiers=" + this.a + ", remoteConfigMetaInfo=" + this.b + ", moduleConfig=" + this.c + ")";
    }
}
