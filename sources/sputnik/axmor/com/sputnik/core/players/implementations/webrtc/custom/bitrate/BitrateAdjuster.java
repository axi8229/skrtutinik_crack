package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate;

/* loaded from: classes5.dex */
public interface BitrateAdjuster {
    int getAdjustedBitrateBps();

    double getAdjustedFramerateFps();

    void reportEncodedFrame(int i);

    void setTargets(int i, double d);
}
