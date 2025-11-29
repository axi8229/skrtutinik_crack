package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes2.dex */
public final class MediaCodecInfo {
    public final boolean adaptive;
    public final MediaCodecInfo.CodecCapabilities capabilities;
    public final String codecMimeType;
    public final boolean hardwareAccelerated;
    private final boolean isVideo;
    public final String mimeType;
    public final String name;
    public final boolean secure;
    public final boolean softwareOnly;
    public final boolean tunneling;
    public final boolean vendor;

    public static MediaCodecInfo newInstance(String name, String mimeType, String codecMimeType, MediaCodecInfo.CodecCapabilities capabilities, boolean hardwareAccelerated, boolean softwareOnly, boolean vendor, boolean forceDisableAdaptive, boolean forceSecure) {
        return new MediaCodecInfo(name, mimeType, codecMimeType, capabilities, hardwareAccelerated, softwareOnly, vendor, forceDisableAdaptive, forceSecure);
    }

    private MediaCodecInfo(String name, String mimeType, String codecMimeType, MediaCodecInfo.CodecCapabilities capabilities, boolean hardwareAccelerated, boolean softwareOnly, boolean vendor, boolean forceDisableAdaptive, boolean forceSecure) {
        this.name = (String) Assertions.checkNotNull(name);
        this.mimeType = mimeType;
        this.codecMimeType = codecMimeType;
        this.capabilities = capabilities;
        this.hardwareAccelerated = hardwareAccelerated;
        this.softwareOnly = softwareOnly;
        this.vendor = vendor;
        boolean z = false;
        this.adaptive = (forceDisableAdaptive || capabilities == null || !isAdaptive(capabilities)) ? false : true;
        this.tunneling = capabilities != null && isTunneling(capabilities);
        if (forceSecure || (capabilities != null && isSecure(capabilities))) {
            z = true;
        }
        this.secure = z;
        this.isVideo = MimeTypes.isVideo(mimeType);
    }

    public String toString() {
        return this.name;
    }

    public MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean isFormatSupported(Format format) throws MediaCodecUtil.DecoderQueryException {
        int i;
        if (!isCodecSupported(format)) {
            return false;
        }
        if (this.isVideo) {
            int i2 = format.width;
            if (i2 <= 0 || (i = format.height) <= 0) {
                return true;
            }
            if (Util.SDK_INT >= 21) {
                return isVideoSizeAndRateSupportedV21(i2, i, format.frameRate);
            }
            boolean z = i2 * i <= MediaCodecUtil.maxH264DecodableFrameSize();
            if (!z) {
                logNoSupport("legacyFrameSize, " + format.width + "x" + format.height);
            }
            return z;
        }
        if (Util.SDK_INT >= 21) {
            int i3 = format.sampleRate;
            if (i3 != -1 && !isAudioSampleRateSupportedV21(i3)) {
                return false;
            }
            int i4 = format.channelCount;
            if (i4 != -1 && !isAudioChannelCountSupportedV21(i4)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCodecSupported(Format format) {
        String mediaMimeType;
        String str = format.codecs;
        if (str == null || this.mimeType == null || (mediaMimeType = MimeTypes.getMediaMimeType(str)) == null) {
            return true;
        }
        if (!this.mimeType.equals(mediaMimeType)) {
            logNoSupport("codec.mime " + format.codecs + ", " + mediaMimeType);
            return false;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
        if (codecProfileAndLevel == null) {
            return true;
        }
        int iIntValue = ((Integer) codecProfileAndLevel.first).intValue();
        int iIntValue2 = ((Integer) codecProfileAndLevel.second).intValue();
        if (!this.isVideo && iIntValue != 42) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
            if (codecProfileLevel.profile == iIntValue && codecProfileLevel.level >= iIntValue2) {
                return true;
            }
        }
        logNoSupport("codec.profileLevel, " + format.codecs + ", " + mediaMimeType);
        return false;
    }

    public boolean isHdr10PlusOutOfBandMetadataSupported() {
        if (Util.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(this.mimeType)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSeamlessAdaptationSupported(Format format) {
        if (this.isVideo) {
            return this.adaptive;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
        return codecProfileAndLevel != null && ((Integer) codecProfileAndLevel.first).intValue() == 42;
    }

    public boolean isSeamlessAdaptationSupported(Format oldFormat, Format newFormat, boolean isNewFormatComplete) {
        if (this.isVideo) {
            return oldFormat.sampleMimeType.equals(newFormat.sampleMimeType) && oldFormat.rotationDegrees == newFormat.rotationDegrees && (this.adaptive || (oldFormat.width == newFormat.width && oldFormat.height == newFormat.height)) && ((!isNewFormatComplete && newFormat.colorInfo == null) || Util.areEqual(oldFormat.colorInfo, newFormat.colorInfo));
        }
        if ("audio/mp4a-latm".equals(this.mimeType) && oldFormat.sampleMimeType.equals(newFormat.sampleMimeType) && oldFormat.channelCount == newFormat.channelCount && oldFormat.sampleRate == newFormat.sampleRate) {
            Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(oldFormat);
            Pair<Integer, Integer> codecProfileAndLevel2 = MediaCodecUtil.getCodecProfileAndLevel(newFormat);
            if (codecProfileAndLevel != null && codecProfileAndLevel2 != null) {
                return ((Integer) codecProfileAndLevel.first).intValue() == 42 && ((Integer) codecProfileAndLevel2.first).intValue() == 42;
            }
        }
        return false;
    }

    public boolean isVideoSizeAndRateSupportedV21(int width, int height, double frameRate) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            logNoSupport("sizeAndRate.vCaps");
            return false;
        }
        if (areSizeAndRateSupportedV21(videoCapabilities, width, height, frameRate)) {
            return true;
        }
        if (width >= height || !enableRotatedVerticalResolutionWorkaround(this.name) || !areSizeAndRateSupportedV21(videoCapabilities, height, width, frameRate)) {
            logNoSupport("sizeAndRate.support, " + width + "x" + height + "x" + frameRate);
            return false;
        }
        logAssumedSupport("sizeAndRate.rotated, " + width + "x" + height + "x" + frameRate);
        return true;
    }

    public Point alignVideoSizeV21(int width, int height) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return alignVideoSizeV21(videoCapabilities, width, height);
    }

    public boolean isAudioSampleRateSupportedV21(int sampleRate) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            logNoSupport("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(sampleRate)) {
            return true;
        }
        logNoSupport("sampleRate.support, " + sampleRate);
        return false;
    }

    public boolean isAudioChannelCountSupportedV21(int channelCount) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            logNoSupport("channelCount.aCaps");
            return false;
        }
        if (adjustMaxInputChannelCount(this.name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) >= channelCount) {
            return true;
        }
        logNoSupport("channelCount.support, " + channelCount);
        return false;
    }

    private void logNoSupport(String message) {
        Log.d("MediaCodecInfo", "NoSupport [" + message + "] [" + this.name + ", " + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
    }

    private void logAssumedSupport(String message) {
        Log.d("MediaCodecInfo", "AssumedSupport [" + message + "] [" + this.name + ", " + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
    }

    private static int adjustMaxInputChannelCount(String name, String mimeType, int maxChannelCount) {
        int i;
        if (maxChannelCount > 1 || ((Util.SDK_INT >= 26 && maxChannelCount > 0) || "audio/mpeg".equals(mimeType) || "audio/3gpp".equals(mimeType) || "audio/amr-wb".equals(mimeType) || "audio/mp4a-latm".equals(mimeType) || "audio/vorbis".equals(mimeType) || "audio/opus".equals(mimeType) || "audio/raw".equals(mimeType) || "audio/flac".equals(mimeType) || "audio/g711-alaw".equals(mimeType) || "audio/g711-mlaw".equals(mimeType) || "audio/gsm".equals(mimeType))) {
            return maxChannelCount;
        }
        if ("audio/ac3".equals(mimeType)) {
            i = 6;
        } else {
            i = "audio/eac3".equals(mimeType) ? 16 : 30;
        }
        Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + name + ", [" + maxChannelCount + " to " + i + "]");
        return i;
    }

    private static boolean isAdaptive(MediaCodecInfo.CodecCapabilities capabilities) {
        return Util.SDK_INT >= 19 && isAdaptiveV19(capabilities);
    }

    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities capabilities) {
        return capabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean isTunneling(MediaCodecInfo.CodecCapabilities capabilities) {
        return Util.SDK_INT >= 21 && isTunnelingV21(capabilities);
    }

    private static boolean isTunnelingV21(MediaCodecInfo.CodecCapabilities capabilities) {
        return capabilities.isFeatureSupported("tunneled-playback");
    }

    private static boolean isSecure(MediaCodecInfo.CodecCapabilities capabilities) {
        return Util.SDK_INT >= 21 && isSecureV21(capabilities);
    }

    private static boolean isSecureV21(MediaCodecInfo.CodecCapabilities capabilities) {
        return capabilities.isFeatureSupported("secure-playback");
    }

    private static boolean areSizeAndRateSupportedV21(MediaCodecInfo.VideoCapabilities capabilities, int width, int height, double frameRate) {
        Point pointAlignVideoSizeV21 = alignVideoSizeV21(capabilities, width, height);
        int i = pointAlignVideoSizeV21.x;
        int i2 = pointAlignVideoSizeV21.y;
        if (frameRate == -1.0d || frameRate < 1.0d) {
            return capabilities.isSizeSupported(i, i2);
        }
        return capabilities.areSizeAndRateSupported(i, i2, Math.floor(frameRate));
    }

    private static Point alignVideoSizeV21(MediaCodecInfo.VideoCapabilities capabilities, int width, int height) {
        int widthAlignment = capabilities.getWidthAlignment();
        int heightAlignment = capabilities.getHeightAlignment();
        return new Point(Util.ceilDivide(width, widthAlignment) * widthAlignment, Util.ceilDivide(height, heightAlignment) * heightAlignment);
    }

    private static final boolean enableRotatedVerticalResolutionWorkaround(String name) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(name) && "mcv5a".equals(Util.DEVICE)) ? false : true;
    }
}
