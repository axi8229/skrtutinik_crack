package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom;

import java.util.Arrays;
import java.util.LinkedHashSet;
import org.webrtc.EglBase;
import org.webrtc.SoftwareVideoEncoderFactory;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoEncoder;
import org.webrtc.VideoEncoderFactory;
import org.webrtc.VideoEncoderFallback;

/* loaded from: classes5.dex */
public class CustomVideoEncoderFactory implements VideoEncoderFactory {
    private final VideoEncoderFactory hardwareVideoEncoderFactory;
    private final VideoEncoderFactory softwareVideoEncoderFactory = new SoftwareVideoEncoderFactory();

    public CustomVideoEncoderFactory(EglBase.Context context, boolean z, boolean z2) {
        this.hardwareVideoEncoderFactory = new CustomHardwareVideoEncoderFactory(context, z, z2);
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        VideoEncoder videoEncoderCreateEncoder = this.softwareVideoEncoderFactory.createEncoder(videoCodecInfo);
        VideoEncoder videoEncoderCreateEncoder2 = this.hardwareVideoEncoderFactory.createEncoder(videoCodecInfo);
        if (videoEncoderCreateEncoder2 == null || videoEncoderCreateEncoder == null) {
            return videoEncoderCreateEncoder2 != null ? videoEncoderCreateEncoder2 : videoEncoderCreateEncoder;
        }
        return new VideoEncoderFallback(videoEncoderCreateEncoder, videoEncoderCreateEncoder2);
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(Arrays.asList(this.softwareVideoEncoderFactory.getSupportedCodecs()));
        linkedHashSet.addAll(Arrays.asList(this.hardwareVideoEncoderFactory.getSupportedCodecs()));
        return (VideoCodecInfo[]) linkedHashSet.toArray(new VideoCodecInfo[0]);
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getImplementations() {
        return super.getImplementations();
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoEncoderFactory.VideoEncoderSelector getEncoderSelector() {
        return super.getEncoderSelector();
    }
}
