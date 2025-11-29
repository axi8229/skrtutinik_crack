package flussonic.watcher.sdk.presentation.watcher;

import flussonic.watcher.sdk.presentation.watcher.AutoValue_WatcherConnectionParameters;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class WatcherConnectionParameters {
    private static final Pattern PATTERN_FROM = Pattern.compile("from=(\\d+)");

    public static abstract class Builder {
        public abstract WatcherConnectionParameters build();

        public abstract Builder setFrom(long from);

        public abstract Builder setProtocol(String protocol);

        public abstract Builder setServerWithOptionalPort(String serverWithOptionalPort);

        public abstract Builder setStream(String stream);

        public abstract Builder setToken(String token);
    }

    public abstract long from();

    public abstract String protocol();

    public abstract String serverWithOptionalPort();

    public abstract String stream();

    public abstract String token();

    public static Builder builder() {
        return new AutoValue_WatcherConnectionParameters.Builder();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters create(java.lang.String r8) {
        /*
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Exception -> L21
            r0.<init>(r8)     // Catch: java.lang.Exception -> L21
            java.lang.String r1 = r0.getProtocol()     // Catch: java.lang.Exception -> L21
            java.lang.String r2 = r0.getAuthority()     // Catch: java.lang.Exception -> L21
            java.lang.String r3 = "@"
            java.lang.String[] r2 = r2.split(r3)     // Catch: java.lang.Exception -> L21
            int r3 = r2.length     // Catch: java.lang.Exception -> L21
            r4 = 1
            if (r3 < r4) goto L8e
            int r3 = r2.length     // Catch: java.lang.Exception -> L21
            r5 = 2
            r6 = 0
            if (r3 >= r5) goto L23
            java.lang.String r3 = ""
            r2 = r2[r6]     // Catch: java.lang.Exception -> L21
            goto L29
        L21:
            r0 = move-exception
            goto L96
        L23:
            r3 = r2[r6]     // Catch: java.lang.Exception -> L21
            int r5 = r2.length     // Catch: java.lang.Exception -> L21
            int r5 = r5 - r4
            r2 = r2[r5]     // Catch: java.lang.Exception -> L21
        L29:
            java.lang.String r5 = r0.getPath()     // Catch: java.lang.Exception -> L21
            java.lang.String r6 = "/"
            java.lang.String[] r5 = r5.split(r6)     // Catch: java.lang.Exception -> L21
            int r6 = r5.length     // Catch: java.lang.Exception -> L21
            if (r6 < r4) goto L86
            int r6 = r5.length     // Catch: java.lang.Exception -> L21
            int r6 = r6 - r4
            r5 = r5[r6]     // Catch: java.lang.Exception -> L21
            boolean r6 = r5.isEmpty()     // Catch: java.lang.Exception -> L21
            if (r6 != 0) goto L7e
            java.lang.String r6 = r0.getQuery()     // Catch: java.lang.Exception -> L21
            if (r6 == 0) goto L5f
            java.util.regex.Pattern r6 = flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters.PATTERN_FROM     // Catch: java.lang.Exception -> L21
            java.lang.String r0 = r0.getQuery()     // Catch: java.lang.Exception -> L21
            java.util.regex.Matcher r0 = r6.matcher(r0)     // Catch: java.lang.Exception -> L21
            boolean r6 = r0.find()     // Catch: java.lang.Exception -> L21
            if (r6 == 0) goto L5f
            java.lang.String r0 = r0.group(r4)     // Catch: java.lang.Exception -> L21
            long r6 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Exception -> L21
            goto L61
        L5f:
            r6 = 0
        L61:
            flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters$Builder r0 = builder()     // Catch: java.lang.Exception -> L21
            flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters$Builder r0 = r0.setProtocol(r1)     // Catch: java.lang.Exception -> L21
            flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters$Builder r0 = r0.setToken(r3)     // Catch: java.lang.Exception -> L21
            flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters$Builder r0 = r0.setServerWithOptionalPort(r2)     // Catch: java.lang.Exception -> L21
            flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters$Builder r0 = r0.setStream(r5)     // Catch: java.lang.Exception -> L21
            flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters$Builder r0 = r0.setFrom(r6)     // Catch: java.lang.Exception -> L21
            flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters r8 = r0.build()     // Catch: java.lang.Exception -> L21
            return r8
        L7e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Exception -> L21
            java.lang.String r1 = "Stream is empty"
            r0.<init>(r1)     // Catch: java.lang.Exception -> L21
            throw r0     // Catch: java.lang.Exception -> L21
        L86:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Exception -> L21
            java.lang.String r1 = "No stream specified"
            r0.<init>(r1)     // Catch: java.lang.Exception -> L21
            throw r0     // Catch: java.lang.Exception -> L21
        L8e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Exception -> L21
            java.lang.String r1 = "No server and no token specified"
            r0.<init>(r1)     // Catch: java.lang.Exception -> L21
            throw r0     // Catch: java.lang.Exception -> L21
        L96:
            flussonic.watcher.sdk.domain.exceptions.InvalidUrlException r1 = new flussonic.watcher.sdk.domain.exceptions.InvalidUrlException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid URL: "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r1.<init>(r8, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters.create(java.lang.String):flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters");
    }
}
