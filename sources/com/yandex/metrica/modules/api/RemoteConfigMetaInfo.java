package com.yandex.metrica.modules.api;

/* loaded from: classes3.dex */
public final class RemoteConfigMetaInfo {
    private final long a;
    private final long b;

    public RemoteConfigMetaInfo(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteConfigMetaInfo)) {
            return false;
        }
        RemoteConfigMetaInfo remoteConfigMetaInfo = (RemoteConfigMetaInfo) obj;
        return this.a == remoteConfigMetaInfo.a && this.b == remoteConfigMetaInfo.b;
    }

    public int hashCode() {
        long j = this.a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.b;
        return i + ((int) ((j2 >>> 32) ^ j2));
    }

    public String toString() {
        return "RemoteConfigMetaInfo(firstSendTime=" + this.a + ", lastUpdateTime=" + this.b + ")";
    }
}
