package flussonic.watcher.sdk.presentation.watcher;

import java.util.Locale;

/* loaded from: classes3.dex */
public class WatcherUrlProvider {
    private final WatcherConnectionParameters connectionParameters;

    public WatcherUrlProvider(WatcherConnectionParameters connectionParameters) {
        this.connectionParameters = connectionParameters;
    }

    public String getBaseUrl() {
        return String.format(Locale.US, "%s://%s/vsaas/api/v2/", this.connectionParameters.protocol(), this.connectionParameters.serverWithOptionalPort());
    }
}
