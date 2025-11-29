package com.yandex.metrica;

import java.util.Map;

/* loaded from: classes3.dex */
public interface DeferredDeeplinkParametersListener {

    public enum Error {
        NOT_A_FIRST_LAUNCH("Deferred deeplink parameters can be requested during first launch only."),
        PARSE_ERROR("Google Play referrer did not contain valid deferred deeplink parameters."),
        NO_REFERRER("No referrer was found"),
        UNKNOWN("Unknown error");

        private final String mDescription;

        Error(String str) {
            this.mDescription = str;
        }

        public String getDescription() {
            return this.mDescription;
        }
    }

    void onError(Error error, String str);

    void onParametersLoaded(Map<String, String> map);
}
