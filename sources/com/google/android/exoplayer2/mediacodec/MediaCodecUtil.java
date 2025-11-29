package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2Connection;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjmedia_tp_proto;

@SuppressLint({"InlinedApi"})
/* loaded from: classes2.dex */
public final class MediaCodecUtil {
    private static final SparseIntArray AV1_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray AVC_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray AVC_PROFILE_NUMBER_TO_CONST;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_LEVEL;
    private static final Map<String, Integer> DOLBY_VISION_STRING_TO_PROFILE;
    private static final Map<String, Integer> HEVC_CODEC_STRING_TO_PROFILE_LEVEL;
    private static final SparseIntArray MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE;
    private static final SparseIntArray VP9_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray VP9_PROFILE_NUMBER_TO_CONST;
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap<>();
    private static int maxH264DecodableFrameSize = -1;

    private interface MediaCodecListCompat {
        int getCodecCount();

        android.media.MediaCodecInfo getCodecInfoAt(int index);

        boolean isFeatureRequired(String feature, String mimeType, MediaCodecInfo.CodecCapabilities capabilities);

        boolean isFeatureSupported(String feature, String mimeType, MediaCodecInfo.CodecCapabilities capabilities);

        boolean secureDecodersExplicit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface ScoreProvider<T> {
        int getScore(T t);
    }

    private static int avcLevelToMaxFrameSize(int avcLevel) {
        if (avcLevel == 1 || avcLevel == 2) {
            return 25344;
        }
        switch (avcLevel) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP /* 32768 */:
            case pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1 /* 65536 */:
                return 9437184;
            default:
                return -1;
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable cause) {
            super("Failed to query underlying media codecs", cause);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        AVC_PROFILE_NUMBER_TO_CONST = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        sparseIntArray.put(110, 16);
        sparseIntArray.put(122, 32);
        sparseIntArray.put(244, 64);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        AVC_LEVEL_NUMBER_TO_CONST = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP);
        sparseIntArray2.put(52, pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1);
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        VP9_PROFILE_NUMBER_TO_CONST = sparseIntArray3;
        sparseIntArray3.put(0, 1);
        sparseIntArray3.put(1, 2);
        sparseIntArray3.put(2, 4);
        sparseIntArray3.put(3, 8);
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        VP9_LEVEL_NUMBER_TO_CONST = sparseIntArray4;
        sparseIntArray4.put(10, 1);
        sparseIntArray4.put(11, 2);
        sparseIntArray4.put(20, 4);
        sparseIntArray4.put(21, 8);
        sparseIntArray4.put(30, 16);
        sparseIntArray4.put(31, 32);
        sparseIntArray4.put(40, 64);
        sparseIntArray4.put(41, 128);
        sparseIntArray4.put(50, 256);
        sparseIntArray4.put(51, 512);
        sparseIntArray4.put(60, 2048);
        sparseIntArray4.put(61, 4096);
        sparseIntArray4.put(62, 8192);
        HashMap map = new HashMap();
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL = map;
        map.put("L30", 1);
        map.put("L60", 4);
        map.put("L63", 16);
        map.put("L90", 64);
        map.put("L93", 256);
        map.put("L120", 1024);
        map.put("L123", 4096);
        map.put("L150", 16384);
        map.put("L153", Integer.valueOf(pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1));
        map.put("L156", 262144);
        map.put("L180", 1048576);
        map.put("L183", 4194304);
        map.put("L186", Integer.valueOf(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE));
        map.put("H30", 2);
        map.put("H60", 8);
        map.put("H63", 32);
        map.put("H90", 128);
        map.put("H93", 512);
        map.put("H120", 2048);
        map.put("H123", 8192);
        map.put("H150", Integer.valueOf(pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP));
        map.put("H153", 131072);
        map.put("H156", 524288);
        map.put("H180", 2097152);
        map.put("H183", 8388608);
        map.put("H186", 33554432);
        HashMap map2 = new HashMap();
        DOLBY_VISION_STRING_TO_PROFILE = map2;
        map2.put("00", 1);
        map2.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 2);
        map2.put("02", 4);
        map2.put("03", 8);
        map2.put("04", 16);
        map2.put("05", 32);
        map2.put("06", 64);
        map2.put("07", 128);
        map2.put("08", 256);
        map2.put("09", 512);
        HashMap map3 = new HashMap();
        DOLBY_VISION_STRING_TO_LEVEL = map3;
        map3.put(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1);
        map3.put("02", 2);
        map3.put("03", 4);
        map3.put("04", 8);
        map3.put("05", 16);
        map3.put("06", 32);
        map3.put("07", 64);
        map3.put("08", 128);
        map3.put("09", 256);
        SparseIntArray sparseIntArray5 = new SparseIntArray();
        AV1_LEVEL_NUMBER_TO_CONST = sparseIntArray5;
        sparseIntArray5.put(0, 1);
        sparseIntArray5.put(1, 2);
        sparseIntArray5.put(2, 4);
        sparseIntArray5.put(3, 8);
        sparseIntArray5.put(4, 16);
        sparseIntArray5.put(5, 32);
        sparseIntArray5.put(6, 64);
        sparseIntArray5.put(7, 128);
        sparseIntArray5.put(8, 256);
        sparseIntArray5.put(9, 512);
        sparseIntArray5.put(10, 1024);
        sparseIntArray5.put(11, 2048);
        sparseIntArray5.put(12, 4096);
        sparseIntArray5.put(13, 8192);
        sparseIntArray5.put(14, 16384);
        sparseIntArray5.put(15, pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP);
        sparseIntArray5.put(16, pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1);
        sparseIntArray5.put(17, 131072);
        sparseIntArray5.put(18, 262144);
        sparseIntArray5.put(19, 524288);
        sparseIntArray5.put(20, 1048576);
        sparseIntArray5.put(21, 2097152);
        sparseIntArray5.put(22, 4194304);
        sparseIntArray5.put(23, 8388608);
        SparseIntArray sparseIntArray6 = new SparseIntArray();
        MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE = sparseIntArray6;
        sparseIntArray6.put(1, 1);
        sparseIntArray6.put(2, 2);
        sparseIntArray6.put(3, 3);
        sparseIntArray6.put(4, 4);
        sparseIntArray6.put(5, 5);
        sparseIntArray6.put(6, 6);
        sparseIntArray6.put(17, 17);
        sparseIntArray6.put(20, 20);
        sparseIntArray6.put(23, 23);
        sparseIntArray6.put(29, 29);
        sparseIntArray6.put(39, 39);
        sparseIntArray6.put(42, 42);
    }

    public static MediaCodecInfo getPassthroughDecoderInfo() throws DecoderQueryException {
        return getDecoderInfo("audio/raw", false, false);
    }

    public static MediaCodecInfo getDecoderInfo(String mimeType, boolean secure, boolean tunneling) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mimeType, secure, tunneling);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(String mimeType, boolean secure, boolean tunneling) throws DecoderQueryException {
        try {
            CodecKey codecKey = new CodecKey(mimeType, secure, tunneling);
            HashMap<CodecKey, List<MediaCodecInfo>> map = decoderInfosCache;
            List<MediaCodecInfo> list = map.get(codecKey);
            if (list != null) {
                return list;
            }
            int i = Util.SDK_INT;
            ArrayList<MediaCodecInfo> decoderInfosInternal = getDecoderInfosInternal(codecKey, i >= 21 ? new MediaCodecListCompatV21(secure, tunneling) : new MediaCodecListCompatV16());
            if (secure && decoderInfosInternal.isEmpty() && 21 <= i && i <= 23) {
                decoderInfosInternal = getDecoderInfosInternal(codecKey, new MediaCodecListCompatV16());
                if (!decoderInfosInternal.isEmpty()) {
                    Log.w("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + mimeType + ". Assuming: " + decoderInfosInternal.get(0).name);
                }
            }
            applyWorkarounds(mimeType, decoderInfosInternal);
            List<MediaCodecInfo> listUnmodifiableList = Collections.unmodifiableList(decoderInfosInternal);
            map.put(codecKey, listUnmodifiableList);
            return listUnmodifiableList;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static List<MediaCodecInfo> getDecoderInfosSortedByFormatSupport(List<MediaCodecInfo> decoderInfos, final Format format) {
        ArrayList arrayList = new ArrayList(decoderInfos);
        sortByScore(arrayList, new ScoreProvider() { // from class: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$$ExternalSyntheticLambda6
            @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider
            public final int getScore(Object obj) {
                return MediaCodecUtil.lambda$getDecoderInfosSortedByFormatSupport$0(format, (MediaCodecInfo) obj);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getDecoderInfosSortedByFormatSupport$0(Format format, MediaCodecInfo mediaCodecInfo) {
        try {
            return mediaCodecInfo.isFormatSupported(format) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        if (maxH264DecodableFrameSize == -1) {
            int iMax = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo("video/avc", false, false);
            if (decoderInfo != null) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(avcLevelToMaxFrameSize(profileLevels[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, Util.SDK_INT >= 21 ? 345600 : 172800);
            }
            maxH264DecodableFrameSize = iMax;
        }
        return maxH264DecodableFrameSize;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> getCodecProfileAndLevel(com.google.android.exoplayer2.Format r6) {
        /*
            r0 = 0
            java.lang.String r1 = r6.codecs
            r2 = 0
            if (r1 != 0) goto L7
            return r2
        L7:
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)
            java.lang.String r3 = "video/dolby-vision"
            java.lang.String r4 = r6.sampleMimeType
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L1e
            java.lang.String r6 = r6.codecs
            android.util.Pair r6 = getDolbyVisionProfileAndLevel(r6, r1)
            return r6
        L1e:
            r3 = r1[r0]
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case 3004662: goto L6f;
                case 3006243: goto L64;
                case 3006244: goto L59;
                case 3199032: goto L4e;
                case 3214780: goto L43;
                case 3356560: goto L38;
                case 3624515: goto L2d;
                default: goto L2b;
            }
        L2b:
            r0 = r4
            goto L78
        L2d:
            java.lang.String r0 = "vp09"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L36
            goto L2b
        L36:
            r0 = 6
            goto L78
        L38:
            java.lang.String r0 = "mp4a"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L41
            goto L2b
        L41:
            r0 = 5
            goto L78
        L43:
            java.lang.String r0 = "hvc1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L4c
            goto L2b
        L4c:
            r0 = 4
            goto L78
        L4e:
            java.lang.String r0 = "hev1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L57
            goto L2b
        L57:
            r0 = 3
            goto L78
        L59:
            java.lang.String r0 = "avc2"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L62
            goto L2b
        L62:
            r0 = 2
            goto L78
        L64:
            java.lang.String r0 = "avc1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L6d
            goto L2b
        L6d:
            r0 = 1
            goto L78
        L6f:
            java.lang.String r5 = "av01"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L78
            goto L2b
        L78:
            switch(r0) {
                case 0: goto L98;
                case 1: goto L91;
                case 2: goto L91;
                case 3: goto L8a;
                case 4: goto L8a;
                case 5: goto L83;
                case 6: goto L7c;
                default: goto L7b;
            }
        L7b:
            return r2
        L7c:
            java.lang.String r6 = r6.codecs
            android.util.Pair r6 = getVp9ProfileAndLevel(r6, r1)
            return r6
        L83:
            java.lang.String r6 = r6.codecs
            android.util.Pair r6 = getAacCodecProfileAndLevel(r6, r1)
            return r6
        L8a:
            java.lang.String r6 = r6.codecs
            android.util.Pair r6 = getHevcProfileAndLevel(r6, r1)
            return r6
        L91:
            java.lang.String r6 = r6.codecs
            android.util.Pair r6 = getAvcProfileAndLevel(r6, r1)
            return r6
        L98:
            java.lang.String r0 = r6.codecs
            com.google.android.exoplayer2.video.ColorInfo r6 = r6.colorInfo
            android.util.Pair r6 = getAv1ProfileAndLevel(r0, r1, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(com.google.android.exoplayer2.Format):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0108 A[Catch: Exception -> 0x0131, TRY_ENTER, TryCatch #5 {Exception -> 0x0131, blocks: (B:3:0x0008, B:5:0x001b, B:61:0x0127, B:8:0x002d, B:11:0x0038, B:55:0x0100, B:58:0x0108, B:60:0x010e, B:64:0x0133, B:65:0x0156), top: B:79:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0133 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfosInternal(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey r25, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat r26) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecoderInfosInternal(com.google.android.exoplayer2.mediacodec.MediaCodecUtil$CodecKey, com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat):java.util.ArrayList");
    }

    private static String getCodecMimeType(android.media.MediaCodecInfo info, String name, String mimeType) {
        for (String str : info.getSupportedTypes()) {
            if (str.equalsIgnoreCase(mimeType)) {
                return str;
            }
        }
        if (mimeType.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(name)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(name) || "OMX.realtek.video.decoder.tunneled".equals(name)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (mimeType.equals("audio/alac") && "OMX.lge.alac.decoder".equals(name)) {
            return "audio/x-lg-alac";
        }
        if (mimeType.equals("audio/flac") && "OMX.lge.flac.decoder".equals(name)) {
            return "audio/x-lg-flac";
        }
        return null;
    }

    private static boolean isCodecUsableDecoder(android.media.MediaCodecInfo info, String name, boolean secureDecodersExplicit, String mimeType) {
        if (info.isEncoder() || (!secureDecodersExplicit && name.endsWith(".secure"))) {
            return false;
        }
        int i = Util.SDK_INT;
        if (i < 21 && ("CIPAACDecoder".equals(name) || "CIPMP3Decoder".equals(name) || "CIPVorbisDecoder".equals(name) || "CIPAMRNBDecoder".equals(name) || "AACDecoder".equals(name) || "MP3Decoder".equals(name))) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(name)) {
            String str = Util.DEVICE;
            if ("a70".equals(str) || ("Xiaomi".equals(Util.MANUFACTURER) && str.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(name)) {
            String str2 = Util.DEVICE;
            if ("dlxu".equals(str2) || "protou".equals(str2) || "ville".equals(str2) || "villeplus".equals(str2) || "villec2".equals(str2) || str2.startsWith("gee") || "C6602".equals(str2) || "C6603".equals(str2) || "C6606".equals(str2) || "C6616".equals(str2) || "L36h".equals(str2) || "SO-02E".equals(str2)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(name)) {
            String str3 = Util.DEVICE;
            if ("C1504".equals(str3) || "C1505".equals(str3) || "C1604".equals(str3) || "C1605".equals(str3)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && "samsung".equals(Util.MANUFACTURER))) {
            String str4 = Util.DEVICE;
            if (str4.startsWith("zeroflte") || str4.startsWith("zerolte") || str4.startsWith("zenlte") || "SC-05G".equals(str4) || "marinelteatt".equals(str4) || "404SC".equals(str4) || "SC-04G".equals(str4) || "SCV31".equals(str4)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(name) && "samsung".equals(Util.MANUFACTURER)) {
            String str5 = Util.DEVICE;
            if (str5.startsWith("d2") || str5.startsWith("serrano") || str5.startsWith("jflte") || str5.startsWith("santos") || str5.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(name)) {
            return false;
        }
        return ("audio/eac3-joc".equals(mimeType) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(name)) ? false : true;
    }

    private static void applyWorkarounds(String mimeType, List<MediaCodecInfo> decoderInfos) {
        if ("audio/raw".equals(mimeType)) {
            if (Util.SDK_INT < 26 && Util.DEVICE.equals("R9") && decoderInfos.size() == 1 && decoderInfos.get(0).name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                decoderInfos.add(MediaCodecInfo.newInstance("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            sortByScore(decoderInfos, new ScoreProvider() { // from class: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$$ExternalSyntheticLambda4
                @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider
                public final int getScore(Object obj) {
                    return MediaCodecUtil.lambda$applyWorkarounds$1((MediaCodecInfo) obj);
                }
            });
        }
        int i = Util.SDK_INT;
        if (i < 21 && decoderInfos.size() > 1) {
            String str = decoderInfos.get(0).name;
            if ("OMX.SEC.mp3.dec".equals(str) || "OMX.SEC.MP3.Decoder".equals(str) || "OMX.brcm.audio.mp3.decoder".equals(str)) {
                sortByScore(decoderInfos, new ScoreProvider() { // from class: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$$ExternalSyntheticLambda5
                    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.ScoreProvider
                    public final int getScore(Object obj) {
                        return MediaCodecUtil.lambda$applyWorkarounds$2((MediaCodecInfo) obj);
                    }
                });
            }
        }
        if (i >= 30 || decoderInfos.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(decoderInfos.get(0).name)) {
            return;
        }
        decoderInfos.add(decoderInfos.remove(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$applyWorkarounds$1(MediaCodecInfo decoderInfo) {
        String str = decoderInfo.name;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Util.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$applyWorkarounds$2(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.name.startsWith("OMX.google") ? 1 : 0;
    }

    private static boolean isAlias(android.media.MediaCodecInfo info) {
        return Util.SDK_INT >= 29 && isAliasV29(info);
    }

    private static boolean isAliasV29(android.media.MediaCodecInfo info) {
        return info.isAlias();
    }

    private static boolean isHardwareAccelerated(android.media.MediaCodecInfo codecInfo) {
        if (Util.SDK_INT >= 29) {
            return isHardwareAcceleratedV29(codecInfo);
        }
        return !isSoftwareOnly(codecInfo);
    }

    private static boolean isHardwareAcceleratedV29(android.media.MediaCodecInfo codecInfo) {
        return codecInfo.isHardwareAccelerated();
    }

    private static boolean isSoftwareOnly(android.media.MediaCodecInfo codecInfo) {
        if (Util.SDK_INT >= 29) {
            return isSoftwareOnlyV29(codecInfo);
        }
        String lowerInvariant = Util.toLowerInvariant(codecInfo.getName());
        if (lowerInvariant.startsWith("arc.")) {
            return false;
        }
        return lowerInvariant.startsWith("omx.google.") || lowerInvariant.startsWith("omx.ffmpeg.") || (lowerInvariant.startsWith("omx.sec.") && lowerInvariant.contains(".sw.")) || lowerInvariant.equals("omx.qcom.video.decoder.hevcswvdec") || lowerInvariant.startsWith("c2.android.") || lowerInvariant.startsWith("c2.google.") || !(lowerInvariant.startsWith("omx.") || lowerInvariant.startsWith("c2."));
    }

    private static boolean isSoftwareOnlyV29(android.media.MediaCodecInfo codecInfo) {
        return codecInfo.isSoftwareOnly();
    }

    private static boolean isVendor(android.media.MediaCodecInfo codecInfo) {
        if (Util.SDK_INT >= 29) {
            return isVendorV29(codecInfo);
        }
        String lowerInvariant = Util.toLowerInvariant(codecInfo.getName());
        return (lowerInvariant.startsWith("omx.google.") || lowerInvariant.startsWith("c2.android.") || lowerInvariant.startsWith("c2.google.")) ? false : true;
    }

    private static boolean isVendorV29(android.media.MediaCodecInfo codecInfo) {
        return codecInfo.isVendor();
    }

    private static boolean codecNeedsDisableAdaptationWorkaround(String name) {
        if (Util.SDK_INT <= 22) {
            String str = Util.MODEL;
            if (("ODROID-XU3".equals(str) || "Nexus 10".equals(str)) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name))) {
                return true;
            }
        }
        return false;
    }

    private static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String codec, String[] parts) {
        if (parts.length < 3) {
            Log.w("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + codec);
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(parts[1]);
        if (!matcher.matches()) {
            Log.w("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: " + codec);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer num = DOLBY_VISION_STRING_TO_PROFILE.get(strGroup);
        if (num == null) {
            Log.w("MediaCodecUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str = parts[2];
        Integer num2 = DOLBY_VISION_STRING_TO_LEVEL.get(str);
        if (num2 == null) {
            Log.w("MediaCodecUtil", "Unknown Dolby Vision level string: " + str);
            return null;
        }
        return new Pair<>(num, num2);
    }

    private static Pair<Integer, Integer> getHevcProfileAndLevel(String codec, String[] parts) {
        if (parts.length < 4) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + codec);
            return null;
        }
        int i = 1;
        Matcher matcher = PROFILE_PATTERN.matcher(parts[1]);
        if (!matcher.matches()) {
            Log.w("MediaCodecUtil", "Ignoring malformed HEVC codec string: " + codec);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            if (!"2".equals(strGroup)) {
                Log.w("MediaCodecUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
            i = 2;
        }
        String str = parts[3];
        Integer num = HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(str);
        if (num == null) {
            Log.w("MediaCodecUtil", "Unknown HEVC level string: " + str);
            return null;
        }
        return new Pair<>(Integer.valueOf(i), num);
    }

    private static Pair<Integer, Integer> getAvcProfileAndLevel(String codec, String[] parts) throws NumberFormatException {
        int i;
        int i2;
        if (parts.length < 2) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + codec);
            return null;
        }
        try {
            if (parts[1].length() == 6) {
                i2 = Integer.parseInt(parts[1].substring(0, 2), 16);
                i = Integer.parseInt(parts[1].substring(4), 16);
            } else if (parts.length >= 3) {
                int i3 = Integer.parseInt(parts[1]);
                i = Integer.parseInt(parts[2]);
                i2 = i3;
            } else {
                Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + codec);
                return null;
            }
            int i4 = AVC_PROFILE_NUMBER_TO_CONST.get(i2, -1);
            if (i4 == -1) {
                Log.w("MediaCodecUtil", "Unknown AVC profile: " + i2);
                return null;
            }
            int i5 = AVC_LEVEL_NUMBER_TO_CONST.get(i, -1);
            if (i5 == -1) {
                Log.w("MediaCodecUtil", "Unknown AVC level: " + i);
                return null;
            }
            return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i5));
        } catch (NumberFormatException unused) {
            Log.w("MediaCodecUtil", "Ignoring malformed AVC codec string: " + codec);
            return null;
        }
    }

    private static Pair<Integer, Integer> getVp9ProfileAndLevel(String codec, String[] parts) throws NumberFormatException {
        if (parts.length < 3) {
            Log.w("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + codec);
            return null;
        }
        try {
            int i = Integer.parseInt(parts[1]);
            int i2 = Integer.parseInt(parts[2]);
            int i3 = VP9_PROFILE_NUMBER_TO_CONST.get(i, -1);
            if (i3 == -1) {
                Log.w("MediaCodecUtil", "Unknown VP9 profile: " + i);
                return null;
            }
            int i4 = VP9_LEVEL_NUMBER_TO_CONST.get(i2, -1);
            if (i4 == -1) {
                Log.w("MediaCodecUtil", "Unknown VP9 level: " + i2);
                return null;
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i4));
        } catch (NumberFormatException unused) {
            Log.w("MediaCodecUtil", "Ignoring malformed VP9 codec string: " + codec);
            return null;
        }
    }

    private static Pair<Integer, Integer> getAv1ProfileAndLevel(String codec, String[] parts, ColorInfo colorInfo) throws NumberFormatException {
        int i;
        if (parts.length < 4) {
            Log.w("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + codec);
            return null;
        }
        int i2 = 1;
        try {
            int i3 = Integer.parseInt(parts[1]);
            int i4 = Integer.parseInt(parts[2].substring(0, 2));
            int i5 = Integer.parseInt(parts[3]);
            if (i3 != 0) {
                Log.w("MediaCodecUtil", "Unknown AV1 profile: " + i3);
                return null;
            }
            if (i5 != 8 && i5 != 10) {
                Log.w("MediaCodecUtil", "Unknown AV1 bit depth: " + i5);
                return null;
            }
            if (i5 != 8) {
                i2 = (colorInfo == null || !(colorInfo.hdrStaticInfo != null || (i = colorInfo.colorTransfer) == 7 || i == 6)) ? 2 : 4096;
            }
            int i6 = AV1_LEVEL_NUMBER_TO_CONST.get(i4, -1);
            if (i6 == -1) {
                Log.w("MediaCodecUtil", "Unknown AV1 level: " + i4);
                return null;
            }
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i6));
        } catch (NumberFormatException unused) {
            Log.w("MediaCodecUtil", "Ignoring malformed AV1 codec string: " + codec);
            return null;
        }
    }

    private static Pair<Integer, Integer> getAacCodecProfileAndLevel(String codec, String[] parts) throws NumberFormatException {
        if (parts.length != 3) {
            Log.w("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + codec);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(MimeTypes.getMimeTypeFromMp4ObjectType(Integer.parseInt(parts[1], 16)))) {
                int i = MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.get(Integer.parseInt(parts[2]), -1);
                if (i != -1) {
                    return new Pair<>(Integer.valueOf(i), 0);
                }
            }
        } catch (NumberFormatException unused) {
            Log.w("MediaCodecUtil", "Ignoring malformed MP4A codec string: " + codec);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortByScore$3(final ScoreProvider scoreProvider, Object a, Object b) {
        return scoreProvider.getScore(b) - scoreProvider.getScore(a);
    }

    private static <T> void sortByScore(List<T> list, final ScoreProvider<T> scoreProvider) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$$ExternalSyntheticLambda7
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.lambda$sortByScore$3(scoreProvider, obj, obj2);
            }
        });
    }

    private static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        private android.media.MediaCodecInfo[] mediaCodecInfos;

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return true;
        }

        public MediaCodecListCompatV21(boolean includeSecure, boolean includeTunneling) {
            this.codecKind = (includeSecure || includeTunneling) ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int index) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[index];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureSupported(String feature, String mimeType, MediaCodecInfo.CodecCapabilities capabilities) {
            return capabilities.isFeatureSupported(feature);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureRequired(String feature, String mimeType, MediaCodecInfo.CodecCapabilities capabilities) {
            return capabilities.isFeatureRequired(feature);
        }

        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }
    }

    private static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureRequired(String feature, String mimeType, MediaCodecInfo.CodecCapabilities capabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return false;
        }

        private MediaCodecListCompatV16() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int index) {
            return MediaCodecList.getCodecInfoAt(index);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isFeatureSupported(String feature, String mimeType, MediaCodecInfo.CodecCapabilities capabilities) {
            return "secure-playback".equals(feature) && "video/avc".equals(mimeType);
        }
    }

    private static final class CodecKey {
        public final String mimeType;
        public final boolean secure;
        public final boolean tunneling;

        public CodecKey(String mimeType, boolean secure, boolean tunneling) {
            this.mimeType = mimeType;
            this.secure = secure;
            this.tunneling = tunneling;
        }

        public int hashCode() {
            return ((((this.mimeType.hashCode() + 31) * 31) + (this.secure ? 1231 : 1237)) * 31) + (this.tunneling ? 1231 : 1237);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != CodecKey.class) {
                return false;
            }
            CodecKey codecKey = (CodecKey) obj;
            return TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure && this.tunneling == codecKey.tunneling;
        }
    }
}
