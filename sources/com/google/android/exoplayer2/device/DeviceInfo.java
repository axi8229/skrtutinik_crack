package com.google.android.exoplayer2.device;

/* loaded from: classes2.dex */
public final class DeviceInfo {
    public final int maxVolume;
    public final int minVolume;
    public final int playbackType;

    public DeviceInfo(int playbackType, int minVolume, int maxVolume) {
        this.playbackType = playbackType;
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return this.playbackType == deviceInfo.playbackType && this.minVolume == deviceInfo.minVolume && this.maxVolume == deviceInfo.maxVolume;
    }

    public int hashCode() {
        return ((((527 + this.playbackType) * 31) + this.minVolume) * 31) + this.maxVolume;
    }
}
