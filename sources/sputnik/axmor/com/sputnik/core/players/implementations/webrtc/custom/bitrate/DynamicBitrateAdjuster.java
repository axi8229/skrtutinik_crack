package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate;

import com.yandex.varioqub.config.model.ConfigValue;

/* loaded from: classes5.dex */
public class DynamicBitrateAdjuster extends BaseBitrateAdjuster {
    private int bitrateAdjustmentScaleExp;
    private double deviationBytes;
    private double timeSinceLastAdjustmentMs;

    @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BaseBitrateAdjuster, sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BitrateAdjuster
    public void setTargets(int i, double d) {
        int i2 = this.targetBitrateBps;
        if (i2 > 0 && i < i2) {
            this.deviationBytes = (this.deviationBytes * i) / i2;
        }
        super.setTargets(i, d);
    }

    @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BaseBitrateAdjuster, sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BitrateAdjuster
    public void reportEncodedFrame(int i) {
        double d = this.targetFramerateFps;
        if (d != ConfigValue.DOUBLE_DEFAULT_VALUE) {
            int i2 = this.targetBitrateBps;
            double d2 = this.deviationBytes + (i - ((i2 / 8.0d) / d));
            this.deviationBytes = d2;
            this.timeSinceLastAdjustmentMs += 1000.0d / d;
            double d3 = i2 / 8.0d;
            double d4 = 3.0d * d3;
            double dMin = Math.min(d2, d4);
            this.deviationBytes = dMin;
            double dMax = Math.max(dMin, -d4);
            this.deviationBytes = dMax;
            if (this.timeSinceLastAdjustmentMs > 3000.0d) {
                if (dMax > d3) {
                    int i3 = this.bitrateAdjustmentScaleExp - ((int) ((dMax / d3) + 0.5d));
                    this.bitrateAdjustmentScaleExp = i3;
                    this.bitrateAdjustmentScaleExp = Math.max(i3, -20);
                    this.deviationBytes = d3;
                } else {
                    double d5 = -d3;
                    if (dMax < d5) {
                        int i4 = this.bitrateAdjustmentScaleExp + ((int) (((-dMax) / d3) + 0.5d));
                        this.bitrateAdjustmentScaleExp = i4;
                        this.bitrateAdjustmentScaleExp = Math.min(i4, 20);
                        this.deviationBytes = d5;
                    }
                }
                this.timeSinceLastAdjustmentMs = ConfigValue.DOUBLE_DEFAULT_VALUE;
            }
        }
    }

    private double getBitrateAdjustmentScale() {
        return Math.pow(4.0d, this.bitrateAdjustmentScaleExp / 20.0d);
    }

    @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BaseBitrateAdjuster, sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return (int) (this.targetBitrateBps * getBitrateAdjustmentScale());
    }
}
