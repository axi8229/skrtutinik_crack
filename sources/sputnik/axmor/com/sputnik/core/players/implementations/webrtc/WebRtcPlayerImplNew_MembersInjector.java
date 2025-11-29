package sputnik.axmor.com.sputnik.core.players.implementations.webrtc;

import dagger.MembersInjector;
import okhttp3.OkHttpClient;

/* loaded from: classes5.dex */
public final class WebRtcPlayerImplNew_MembersInjector implements MembersInjector<WebRtcPlayerImplNew> {
    public static void injectOkHttpClient(WebRtcPlayerImplNew webRtcPlayerImplNew, OkHttpClient okHttpClient) {
        webRtcPlayerImplNew.okHttpClient = okHttpClient;
    }
}
