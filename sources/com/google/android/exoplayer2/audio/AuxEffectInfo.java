package com.google.android.exoplayer2.audio;

/* loaded from: classes2.dex */
public final class AuxEffectInfo {
    public final int effectId;
    public final float sendLevel;

    public AuxEffectInfo(int effectId, float sendLevel) {
        this.effectId = effectId;
        this.sendLevel = sendLevel;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || AuxEffectInfo.class != o.getClass()) {
            return false;
        }
        AuxEffectInfo auxEffectInfo = (AuxEffectInfo) o;
        return this.effectId == auxEffectInfo.effectId && Float.compare(auxEffectInfo.sendLevel, this.sendLevel) == 0;
    }

    public int hashCode() {
        return ((527 + this.effectId) * 31) + Float.floatToIntBits(this.sendLevel);
    }
}
