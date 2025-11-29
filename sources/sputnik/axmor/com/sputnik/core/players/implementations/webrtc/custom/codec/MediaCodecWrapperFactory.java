package sputnik.axmor.com.sputnik.core.players.implementations.webrtc.custom.codec;

import java.io.IOException;

/* loaded from: classes5.dex */
public interface MediaCodecWrapperFactory {
    MediaCodecWrapper createByCodecName(String str) throws IOException;
}
