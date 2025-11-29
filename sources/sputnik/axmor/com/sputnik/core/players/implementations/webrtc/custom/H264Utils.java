package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom;

import java.util.HashMap;
import java.util.Map;
import org.webrtc.VideoCodecInfo;

/* loaded from: classes5.dex */
public class H264Utils {
    public static VideoCodecInfo DEFAULT_H264_BASELINE_PROFILE_CODEC = new VideoCodecInfo("H264", getDefaultH264Params(false));
    public static VideoCodecInfo DEFAULT_H264_HIGH_PROFILE_CODEC = new VideoCodecInfo("H264", getDefaultH264Params(true));

    private static native boolean nativeIsSameH264Profile(Map<String, String> map, Map<String, String> map2);

    public static Map<String, String> getDefaultH264Params(boolean z) {
        HashMap map = new HashMap();
        map.put("level-asymmetry-allowed", "1");
        map.put("packetization-mode", "1");
        map.put("profile-level-id", z ? "640c1f" : "42e01f");
        return map;
    }

    public static boolean isSameH264Profile(Map<String, String> map, Map<String, String> map2) {
        return nativeIsSameH264Profile(map, map2);
    }
}
