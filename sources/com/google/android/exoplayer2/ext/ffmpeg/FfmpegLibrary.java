package com.google.android.exoplayer2.ext.ffmpeg;

import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.util.LibraryLoader;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes2.dex */
public final class FfmpegLibrary {
    private static final LibraryLoader LOADER;

    private static native String ffmpegGetVersion();

    private static native boolean ffmpegHasDecoder(String codecName);

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ffmpeg");
        LOADER = new LibraryLoader("c++_shared", "crypto", "ssl", "avutil", "avcodec", "swresample", "exo_ffmpeg");
    }

    private FfmpegLibrary() {
    }

    public static boolean isAvailable() {
        return LOADER.isAvailable();
    }

    public static String getVersion() {
        if (isAvailable()) {
            return ffmpegGetVersion();
        }
        return null;
    }

    public static boolean supportsFormat(String mimeType) {
        boolean z = false;
        if (!isAvailable()) {
            return false;
        }
        String codecName = getCodecName(mimeType);
        if (codecName != null) {
            try {
                if (ffmpegHasDecoder(codecName)) {
                    z = true;
                }
            } catch (UnsatisfiedLinkError unused) {
            }
        }
        if (!z) {
            Log.w("FfmpegLibrary", "No " + codecName + " decoder available. Check the FFmpeg build configuration.");
        }
        return z;
    }

    static String getCodecName(String mimeType) {
        mimeType.hashCode();
        switch (mimeType) {
            case "audio/eac3-joc":
            case "audio/eac3":
                return "eac3";
            case "video/3gpp":
                return "h263";
            case "video/hevc":
                return "hevc";
            case "audio/amr-wb":
                return "amrwb";
            case "audio/vnd.dts":
            case "audio/vnd.dts.hd":
                return "dca";
            case "audio/vorbis":
                return "vorbis";
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/mpeg":
                return "mp3";
            case "audio/mp4a-latm":
                return "aac";
            case "audio/ac3":
                return "ac3";
            case "video/avc":
                return "h264";
            case "audio/3gpp":
                return "amrnb";
            case "audio/alac":
                return "alac";
            case "audio/flac":
                return "flac";
            case "audio/opus":
                return "opus";
            case "audio/true-hd":
                return "truehd";
            case "audio/g711-alaw":
                return "pcm_alaw";
            case "audio/g711-mlaw":
                return "pcm_mulaw";
            default:
                return null;
        }
    }
}
