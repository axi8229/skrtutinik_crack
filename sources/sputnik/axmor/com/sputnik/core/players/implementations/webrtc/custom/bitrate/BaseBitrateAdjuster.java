package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate;

/* loaded from: classes5.dex */
public class BaseBitrateAdjuster implements BitrateAdjuster {
    protected int targetBitrateBps;
    protected double targetFramerateFps;

    @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BitrateAdjuster
    public void reportEncodedFrame(int i) {
    }

    @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BitrateAdjuster
    public void setTargets(int i, double d) {
        this.targetBitrateBps = i;
        this.targetFramerateFps = d;
    }

    @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return this.targetBitrateBps;
    }

    @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BitrateAdjuster
    public double getAdjustedFramerateFps() {
        return this.targetFramerateFps;
    }
}
