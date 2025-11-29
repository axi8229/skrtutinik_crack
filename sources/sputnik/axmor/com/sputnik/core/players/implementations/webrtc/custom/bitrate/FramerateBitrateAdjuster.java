package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate;

/* loaded from: classes5.dex */
public class FramerateBitrateAdjuster extends BaseBitrateAdjuster {
    @Override // sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BaseBitrateAdjuster, sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BitrateAdjuster
    public void setTargets(int i, double d) {
        this.targetFramerateFps = 30.0d;
        this.targetBitrateBps = (int) ((i * 30) / d);
    }
}
