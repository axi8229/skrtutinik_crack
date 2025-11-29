package sputnik.axmor.com.sputnik.core.players.webrtc;

import kotlin.Metadata;
import org.webrtc.MediaConstraints;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0001\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lorg/webrtc/MediaConstraints;", "mediaConstraints", "Lorg/webrtc/MediaConstraints;", "getMediaConstraints", "()Lorg/webrtc/MediaConstraints;", "app_huaweiRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UtilsKt {
    private static final MediaConstraints mediaConstraints;

    static {
        MediaConstraints mediaConstraints2 = new MediaConstraints();
        mediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "true"));
        mediaConstraints2.mandatory.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "true"));
        mediaConstraints = mediaConstraints2;
    }

    public static final MediaConstraints getMediaConstraints() {
        return mediaConstraints;
    }
}
