package flussonic.watcher.sdk.presentation.watcher;

import android.os.Parcelable;
import android.text.TextUtils;
import flussonic.watcher.sdk.domain.utils.NonNullUtils;
import timber.log.Timber;

/* loaded from: classes3.dex */
public abstract class StreamerConnectionParameters implements Parcelable {
    public abstract int httpPort();

    public abstract int httpsPort();

    public abstract boolean permissionDvr();

    public abstract int rtmpPort();

    public abstract String server();

    public abstract String stream();

    public abstract String token();

    public static Builder builder() {
        return new Builder();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters create(java.lang.String r11) {
        /*
            flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters$Builder r0 = builder()     // Catch: java.lang.Exception -> L52
            okhttp3.HttpUrl r1 = okhttp3.HttpUrl.parse(r11)     // Catch: java.lang.Exception -> L52
            java.util.List r2 = r1.pathSegments()     // Catch: java.lang.Exception -> L52
            int r3 = r2.size()     // Catch: java.lang.Exception -> L52
            r4 = 1
            if (r3 != r4) goto Lb1
            java.lang.String r2 = r1.host()     // Catch: java.lang.Exception -> L52
            java.lang.String r3 = r1.encodedPath()     // Catch: java.lang.Exception -> L52
            java.lang.String r5 = r1.scheme()     // Catch: java.lang.Exception -> L52
            java.lang.String r6 = "token"
            java.lang.String r6 = r1.queryParameter(r6)     // Catch: java.lang.Exception -> L52
            java.lang.String r7 = "dvr"
            java.lang.String r7 = r1.queryParameter(r7)     // Catch: java.lang.Exception -> L52
            boolean r7 = java.lang.Boolean.parseBoolean(r7)     // Catch: java.lang.Exception -> L52
            int r1 = r1.port()     // Catch: java.lang.Exception -> L52
            int r8 = r5.hashCode()     // Catch: java.lang.Exception -> L52
            r9 = 3213448(0x310888, float:4.503E-39)
            r10 = 2
            if (r8 == r9) goto L5f
            r9 = 3511141(0x359365, float:4.920156E-39)
            if (r8 == r9) goto L55
            r9 = 99617003(0x5f008eb, float:2.2572767E-35)
            if (r8 == r9) goto L48
            goto L69
        L48:
            java.lang.String r8 = "https"
            boolean r5 = r5.equals(r8)     // Catch: java.lang.Exception -> L52
            if (r5 == 0) goto L69
            r5 = 0
            goto L6a
        L52:
            r0 = move-exception
            goto Lc5
        L55:
            java.lang.String r8 = "rtmp"
            boolean r5 = r5.equals(r8)     // Catch: java.lang.Exception -> L52
            if (r5 == 0) goto L69
            r5 = r10
            goto L6a
        L5f:
            java.lang.String r8 = "http"
            boolean r5 = r5.equals(r8)     // Catch: java.lang.Exception -> L52
            if (r5 == 0) goto L69
            r5 = r4
            goto L6a
        L69:
            r5 = -1
        L6a:
            if (r5 == 0) goto L81
            if (r5 == r4) goto L79
            if (r5 == r10) goto L71
            goto L88
        L71:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L52
            r0.setRtmpPort(r1)     // Catch: java.lang.Exception -> L52
            goto L88
        L79:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L52
            r0.setHttpPort(r1)     // Catch: java.lang.Exception -> L52
            goto L88
        L81:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L52
            r0.setHttpsPort(r1)     // Catch: java.lang.Exception -> L52
        L88:
            if (r6 == 0) goto La9
            boolean r1 = r6.isEmpty()     // Catch: java.lang.Exception -> L52
            if (r1 != 0) goto La9
            flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters$Builder r0 = r0.setPermissionDvr(r7)     // Catch: java.lang.Exception -> L52
            flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters$Builder r0 = r0.setToken(r6)     // Catch: java.lang.Exception -> L52
            flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters$Builder r0 = r0.setServer(r2)     // Catch: java.lang.Exception -> L52
            java.lang.String r1 = r3.substring(r4)     // Catch: java.lang.Exception -> L52
            flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters$Builder r0 = r0.setStream(r1)     // Catch: java.lang.Exception -> L52
            flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters r11 = r0.build()     // Catch: java.lang.Exception -> L52
            return r11
        La9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Exception -> L52
            java.lang.String r1 = "No token specified in query parameters"
            r0.<init>(r1)     // Catch: java.lang.Exception -> L52
            throw r0     // Catch: java.lang.Exception -> L52
        Lb1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Exception -> L52
            java.lang.String r1 = "Invalid cameraName specified in path %s"
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L52
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.Exception -> L52
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch: java.lang.Exception -> L52
            r0.<init>(r1)     // Catch: java.lang.Exception -> L52
            throw r0     // Catch: java.lang.Exception -> L52
        Lc5:
            flussonic.watcher.sdk.domain.exceptions.InvalidUrlException r1 = new flussonic.watcher.sdk.domain.exceptions.InvalidUrlException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid URL: "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r1.<init>(r11, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters.create(java.lang.String):flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters");
    }

    public boolean useHttps() {
        return httpsPort() != -1;
    }

    public static final class Builder {
        private Integer httpPort;
        private Integer httpsPort;
        private boolean permissionDvr;
        private Integer rtmpPort;
        private String server;
        private String stream;
        private String token;

        private Builder() {
            this.rtmpPort = 1935;
            this.httpPort = 80;
            this.httpsPort = -1;
        }

        private static boolean isPortValid(Integer port) {
            return port != null && port.intValue() > 0 && port.intValue() <= 65535;
        }

        public Builder setRtmpPort(Integer rtmpPort) {
            this.rtmpPort = rtmpPort;
            return this;
        }

        public Builder setHttpPort(Integer httpPort) {
            this.httpPort = httpPort;
            return this;
        }

        public Builder setHttpsPort(Integer httpsPort) {
            this.httpsPort = httpsPort;
            return this;
        }

        public Builder setServer(String server) {
            this.server = server;
            return this;
        }

        public Builder setStream(String stream) {
            this.stream = stream;
            return this;
        }

        public Builder setToken(String token) {
            this.token = token;
            return this;
        }

        public Builder setPermissionDvr(boolean permissionDvr) {
            this.permissionDvr = permissionDvr;
            return this;
        }

        public StreamerConnectionParameters build() {
            checkAll();
            return new AutoValue_StreamerConnectionParameters(NonNullUtils.intValue(this.rtmpPort), NonNullUtils.intValue(this.httpPort), NonNullUtils.intValue(this.httpsPort), this.server, this.stream, this.token, this.permissionDvr);
        }

        private void checkAll() {
            if (!isPortValid(this.rtmpPort)) {
                Timber.w("Using default rtmp port", new Object[0]);
                this.rtmpPort = 1935;
            }
            boolean zIsPortValid = isPortValid(this.httpPort);
            boolean zIsPortValid2 = isPortValid(this.httpsPort);
            if (!zIsPortValid && !zIsPortValid2) {
                Timber.w("Using default http port", new Object[0]);
            }
            if (!zIsPortValid) {
                this.httpPort = 80;
            }
            if (!zIsPortValid2) {
                this.httpsPort = -1;
            }
            if (TextUtils.isEmpty(this.server)) {
                throw new IllegalStateException("Specify server address");
            }
            if (TextUtils.isEmpty(this.stream)) {
                throw new IllegalStateException("Specify stream name");
            }
            if (TextUtils.isEmpty(this.token)) {
                throw new IllegalStateException("Specify token");
            }
        }
    }
}
