package com.google.crypto.tink.monitoring;

import com.google.crypto.tink.annotations.Alpha;

@Alpha
/* loaded from: classes2.dex */
public interface MonitoringClient {

    public interface Logger {
        void log(int keyId, long numBytesAsInput);

        void logFailure();
    }

    Logger createLogger(MonitoringKeysetInfo keysetInfo, String primitive, String api);
}
