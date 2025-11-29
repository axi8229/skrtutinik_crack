package com.google.firebase.analytics.connector;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-measurement-connector@@20.0.1 */
/* loaded from: classes.dex */
public interface AnalyticsConnector {

    /* compiled from: com.google.firebase:firebase-measurement-connector@@20.0.1 */
    @KeepForSdk
    public interface AnalyticsConnectorHandle {
    }

    /* compiled from: com.google.firebase:firebase-measurement-connector@@20.0.1 */
    @KeepForSdk
    public interface AnalyticsConnectorListener {
        @KeepForSdk
        void onMessageTriggered(int i, Bundle bundle);
    }

    @KeepForSdk
    Map<String, Object> getUserProperties(boolean z);

    @KeepForSdk
    void logEvent(String str, String str2, Bundle bundle);

    @KeepForSdk
    AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnectorListener analyticsConnectorListener);

    @KeepForSdk
    void setUserProperty(String str, String str2, Object obj);
}
