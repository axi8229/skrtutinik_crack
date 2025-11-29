package sputnik.axmor.com.sputnik.core.players.implementations.webrtc;

import dagger.MembersInjector;
import okhttp3.OkHttpClient;

/* loaded from: classes5.dex */
public final class WebRtcPlayerImpl_MembersInjector implements MembersInjector<WebRtcPlayerImpl> {
    public static void injectOkHttpClient(WebRtcPlayerImpl webRtcPlayerImpl, OkHttpClient okHttpClient) {
        webRtcPlayerImpl.okHttpClient = okHttpClient;
    }
}
