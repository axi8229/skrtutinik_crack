package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec;

import android.media.MediaCodecInfo;
import java.util.HashMap;
import java.util.Map;
import sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.H264Utils;

/* loaded from: classes5.dex */
public class MediaCodecUtils {
    public static final String[] SOFTWARE_IMPLEMENTATION_PREFIXES = {"OMX.google.", "OMX.SEC.", "c2.android"};
    public static final int[] DECODER_COLOR_FORMATS = {19, 21, 2141391872, 2141391873, 2141391874, 2141391875, 2141391876};
    public static final int[] ENCODER_COLOR_FORMATS = {19, 21, 2141391872, 2141391876};
    public static final int[] TEXTURE_COLOR_FORMATS = {2130708361};

    public static Integer selectColorFormat(int[] iArr, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        for (int i : iArr) {
            for (int i2 : codecCapabilities.colorFormats) {
                if (i2 == i) {
                    return Integer.valueOf(i2);
                }
            }
        }
        return null;
    }

    public static boolean codecSupportsType(MediaCodecInfo mediaCodecInfo, VideoCodecMimeType videoCodecMimeType) {
        for (String str : mediaCodecInfo.getSupportedTypes()) {
            if (videoCodecMimeType.mimeType().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec.MediaCodecUtils$1, reason: invalid class name */
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
                $SwitchMap$sputnik$axmor$com$sputnik$core$players$implementations$webrtc$custom$codec$VideoCodecMimeType[VideoCodecMimeType.AV1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$sputnik$axmor$com$sputnik$core$players$implementations$webrtc$custom$codec$VideoCodecMimeType[VideoCodecMimeType.H264.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static Map<String, String> getCodecProperties(VideoCodecMimeType videoCodecMimeType, boolean z) {
        int i = AnonymousClass1.$SwitchMap$sputnik$axmor$com$sputnik$core$players$implementations$webrtc$custom$codec$VideoCodecMimeType[videoCodecMimeType.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return new HashMap();
        }
        if (i == 4) {
            return H264Utils.getDefaultH264Params(z);
        }
        throw new IllegalArgumentException("Unsupported codec: " + videoCodecMimeType);
    }
}
