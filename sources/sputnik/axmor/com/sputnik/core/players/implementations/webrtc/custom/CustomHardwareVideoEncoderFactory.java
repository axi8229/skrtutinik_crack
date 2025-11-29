package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.webrtc.EglBase;
import org.webrtc.EglBase14;
import org.webrtc.Logging;
import org.webrtc.Predicate;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoEncoder;
import org.webrtc.VideoEncoderFactory;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BaseBitrateAdjuster;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.BitrateAdjuster;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.DynamicBitrateAdjuster;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.bitrate.FramerateBitrateAdjuster;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecUtils;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecWrapperFactoryImpl;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.VideoCodecMimeType;

/* loaded from: classes5.dex */
public class CustomHardwareVideoEncoderFactory implements VideoEncoderFactory {
    private static final List<String> H264_HW_EXCEPTION_MODELS = Arrays.asList("SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4");
    private final Predicate<MediaCodecInfo> codecAllowedPredicate;
    private final boolean enableH264HighProfile;
    private final boolean enableIntelVp8Encoder;
    private final EglBase14.Context sharedContext;

    private boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    public CustomHardwareVideoEncoderFactory(EglBase.Context context, boolean z, boolean z2) {
        this(context, z, z2, null);
    }

    public CustomHardwareVideoEncoderFactory(EglBase.Context context, boolean z, boolean z2, Predicate<MediaCodecInfo> predicate) {
        if (context instanceof EglBase14.Context) {
            this.sharedContext = (EglBase14.Context) context;
        } else {
            Logging.w("HardwareVideoEncoderFactory", "No shared EglBase.Context.  Encoders will not use texture mode.");
            this.sharedContext = null;
        }
        this.enableIntelVp8Encoder = z;
        this.enableH264HighProfile = z2;
        this.codecAllowedPredicate = predicate;
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo) {
        VideoCodecMimeType videoCodecMimeTypeValueOf = VideoCodecMimeType.valueOf(videoCodecInfo.name);
        MediaCodecInfo mediaCodecInfoFindCodecForType = findCodecForType(videoCodecMimeTypeValueOf);
        if (mediaCodecInfoFindCodecForType == null) {
            return null;
        }
        String name = mediaCodecInfoFindCodecForType.getName();
        String strMimeType = videoCodecMimeTypeValueOf.mimeType();
        Integer numSelectColorFormat = MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, mediaCodecInfoFindCodecForType.getCapabilitiesForType(strMimeType));
        Integer numSelectColorFormat2 = MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, mediaCodecInfoFindCodecForType.getCapabilitiesForType(strMimeType));
        if (videoCodecMimeTypeValueOf == VideoCodecMimeType.H264) {
            boolean zIsSameH264Profile = H264Utils.isSameH264Profile(videoCodecInfo.params, MediaCodecUtils.getCodecProperties(videoCodecMimeTypeValueOf, true));
            boolean zIsSameH264Profile2 = H264Utils.isSameH264Profile(videoCodecInfo.params, MediaCodecUtils.getCodecProperties(videoCodecMimeTypeValueOf, false));
            if (!zIsSameH264Profile && !zIsSameH264Profile2) {
                return null;
            }
            if (zIsSameH264Profile && !isH264HighProfileSupported(mediaCodecInfoFindCodecForType)) {
                return null;
            }
        }
        return new HardwareVideoEncoder(new MediaCodecWrapperFactoryImpl(), name, videoCodecMimeTypeValueOf, numSelectColorFormat, numSelectColorFormat2, videoCodecInfo.params, 3600, getForcedKeyFrameIntervalMs(videoCodecMimeTypeValueOf, name), createBitrateAdjuster(videoCodecMimeTypeValueOf, name), this.sharedContext);
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        VideoCodecMimeType[] videoCodecMimeTypeArr = {VideoCodecMimeType.VP8, VideoCodecMimeType.VP9, VideoCodecMimeType.H264, VideoCodecMimeType.AV1};
        for (int i = 0; i < 4; i++) {
            VideoCodecMimeType videoCodecMimeType = videoCodecMimeTypeArr[i];
            MediaCodecInfo mediaCodecInfoFindCodecForType = findCodecForType(videoCodecMimeType);
            if (mediaCodecInfoFindCodecForType != null) {
                String strName = videoCodecMimeType.name();
                if (videoCodecMimeType == VideoCodecMimeType.H264 && isH264HighProfileSupported(mediaCodecInfoFindCodecForType)) {
                    arrayList.add(new VideoCodecInfo(strName, MediaCodecUtils.getCodecProperties(videoCodecMimeType, true)));
                }
                arrayList.add(new VideoCodecInfo(strName, MediaCodecUtils.getCodecProperties(videoCodecMimeType, false)));
            }
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }

    private MediaCodecInfo findCodecForType(VideoCodecMimeType videoCodecMimeType) {
        int i = 0;
        while (true) {
            MediaCodecInfo codecInfoAt = null;
            if (i >= MediaCodecList.getCodecCount()) {
                return null;
            }
            try {
                codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            } catch (IllegalArgumentException e) {
                Logging.e("HardwareVideoEncoderFactory", "Cannot retrieve encoder codec info", e);
            }
            if (codecInfoAt != null && codecInfoAt.isEncoder() && isSupportedCodec(codecInfoAt, videoCodecMimeType)) {
                return codecInfoAt;
            }
            i++;
        }
    }

    private boolean isSupportedCodec(MediaCodecInfo mediaCodecInfo, VideoCodecMimeType videoCodecMimeType) {
        return MediaCodecUtils.codecSupportsType(mediaCodecInfo, videoCodecMimeType) && MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, mediaCodecInfo.getCapabilitiesForType(videoCodecMimeType.mimeType())) != null && isHardwareSupportedInCurrentSdk(mediaCodecInfo, videoCodecMimeType) && isMediaCodecAllowed(mediaCodecInfo);
    }

    private boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo mediaCodecInfo, VideoCodecMimeType videoCodecMimeType) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isHardwareAccelerated();
        }
        int i = AnonymousClass1.$SwitchMap$sputnik$axmor$com$sputnik$core$players$implementations$webrtc$custom$codec$VideoCodecMimeType[videoCodecMimeType.ordinal()];
        if (i == 1) {
            return isHardwareSupportedInCurrentSdkVp8(mediaCodecInfo);
        }
        if (i == 2) {
            return isHardwareSupportedInCurrentSdkVp9(mediaCodecInfo);
        }
        if (i != 3) {
            return false;
        }
        return isHardwareSupportedInCurrentSdkH264(mediaCodecInfo);
    }

    /* renamed from: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.CustomHardwareVideoEncoderFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$sputnik$axmor$com$sputnik$core$players$implementations$webrtc$custom$codec$VideoCodecMimeType;

        static {
            int[] iArr = new int[VideoCodecMimeType.values().length];
            $SwitchMap$sputnik$axmor$com$sputnik$core$players$implementations$webrtc$custom$codec$VideoCodecMimeType = iArr;
            try {
                iArr[VideoCodecMimeType.VP8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$sputnik$axmor$com$sputnik$core$players$implementations$webrtc$custom$codec$VideoCodecMimeType[VideoCodecMimeType.VP9.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$sputnik$axmor$com$sputnik$core$players$implementations$webrtc$custom$codec$VideoCodecMimeType[VideoCodecMimeType.H264.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$sputnik$axmor$com$sputnik$core$players$implementations$webrtc$custom$codec$VideoCodecMimeType[VideoCodecMimeType.AV1.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private boolean isHardwareSupportedInCurrentSdkVp8(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        return name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.") || (name.startsWith("OMX.Intel.") && this.enableIntelVp8Encoder);
    }

    private boolean isHardwareSupportedInCurrentSdkVp9(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        return name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.");
    }

    private boolean isMediaCodecAllowed(MediaCodecInfo mediaCodecInfo) {
        Predicate<MediaCodecInfo> predicate = this.codecAllowedPredicate;
        if (predicate == null) {
            return true;
        }
        return predicate.test(mediaCodecInfo);
    }

    private int getForcedKeyFrameIntervalMs(VideoCodecMimeType videoCodecMimeType, String str) {
        return (videoCodecMimeType == VideoCodecMimeType.VP8 && str.startsWith("OMX.qcom.")) ? 15000 : 0;
    }

    private BitrateAdjuster createBitrateAdjuster(VideoCodecMimeType videoCodecMimeType, String str) {
        if (str.startsWith("OMX.Exynos.")) {
            return videoCodecMimeType == VideoCodecMimeType.VP8 ? new DynamicBitrateAdjuster() : new FramerateBitrateAdjuster();
        }
        return new BaseBitrateAdjuster();
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo mediaCodecInfo) {
        return this.enableH264HighProfile && mediaCodecInfo.getName().startsWith("OMX.Exynos.");
    }
}
