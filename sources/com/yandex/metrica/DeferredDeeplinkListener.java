package com.yandex.metrica;

/* loaded from: classes3.dex */
public interface DeferredDeeplinkListener {

    public enum Error {
        NOT_A_FIRST_LAUNCH("Deferred deeplink can be requested during first launch only."),
        PARSE_ERROR("Google Play referrer did not contain deferred deeplink."),
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

    void onDeeplinkLoaded(String str);

    void onError(Error error, String str);
}
