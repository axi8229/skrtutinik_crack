package flussonic.watcher.sdk.presentation.watcher;

import flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters;

/* loaded from: classes3.dex */
final class AutoValue_WatcherConnectionParameters extends WatcherConnectionParameters {
    private final long from;
    private final String protocol;
    private final String serverWithOptionalPort;
    private final String stream;
    private final String token;

    private AutoValue_WatcherConnectionParameters(String protocol, String token, String serverWithOptionalPort, String stream, long from) {
        this.protocol = protocol;
        this.token = token;
        this.serverWithOptionalPort = serverWithOptionalPort;
        this.stream = stream;
        this.from = from;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters
    public String protocol() {
        return this.protocol;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters
    public String token() {
        return this.token;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters
    public String serverWithOptionalPort() {
        return this.serverWithOptionalPort;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters
    public String stream() {
        return this.stream;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters
    public long from() {
        return this.from;
    }

    public String toString() {
        return "WatcherConnectionParameters{protocol=" + this.protocol + ", token=" + this.token + ", serverWithOptionalPort=" + this.serverWithOptionalPort + ", stream=" + this.stream + ", from=" + this.from + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WatcherConnectionParameters)) {
            return false;
        }
        WatcherConnectionParameters watcherConnectionParameters = (WatcherConnectionParameters) o;
        return this.protocol.equals(watcherConnectionParameters.protocol()) && this.token.equals(watcherConnectionParameters.token()) && this.serverWithOptionalPort.equals(watcherConnectionParameters.serverWithOptionalPort()) && this.stream.equals(watcherConnectionParameters.stream()) && this.from == watcherConnectionParameters.from();
    }

    public int hashCode() {
        int iHashCode = (((((((this.protocol.hashCode() ^ 1000003) * 1000003) ^ this.token.hashCode()) * 1000003) ^ this.serverWithOptionalPort.hashCode()) * 1000003) ^ this.stream.hashCode()) * 1000003;
        long j = this.from;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    static final class Builder extends WatcherConnectionParameters.Builder {
        private Long from;
        private String protocol;
        private String serverWithOptionalPort;
        private String stream;
        private String token;

        Builder() {
        }

        @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters.Builder
        public WatcherConnectionParameters.Builder setProtocol(String protocol) {
            if (protocol == null) {
                throw new NullPointerException("Null protocol");
            }
            this.protocol = protocol;
            return this;
        }

        @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters.Builder
        public WatcherConnectionParameters.Builder setToken(String token) {
            if (token == null) {
                throw new NullPointerException("Null token");
            }
            this.token = token;
            return this;
        }

        @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters.Builder
        public WatcherConnectionParameters.Builder setServerWithOptionalPort(String serverWithOptionalPort) {
            if (serverWithOptionalPort == null) {
                throw new NullPointerException("Null serverWithOptionalPort");
            }
            this.serverWithOptionalPort = serverWithOptionalPort;
            return this;
        }

        @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters.Builder
        public WatcherConnectionParameters.Builder setStream(String stream) {
            if (stream == null) {
                throw new NullPointerException("Null stream");
            }
            this.stream = stream;
            return this;
        }

        @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters.Builder
        public WatcherConnectionParameters.Builder setFrom(long from) {
            this.from = Long.valueOf(from);
            return this;
        }

        @Override // flussonic.watcher.sdk.presentation.watcher.WatcherConnectionParameters.Builder
        public WatcherConnectionParameters build() {
            if (this.protocol == null || this.token == null || this.serverWithOptionalPort == null || this.stream == null || this.from == null) {
                StringBuilder sb = new StringBuilder();
                if (this.protocol == null) {
                    sb.append(" protocol");
                }
                if (this.token == null) {
                    sb.append(" token");
                }
                if (this.serverWithOptionalPort == null) {
                    sb.append(" serverWithOptionalPort");
                }
                if (this.stream == null) {
                    sb.append(" stream");
                }
                if (this.from == null) {
                    sb.append(" from");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_WatcherConnectionParameters(this.protocol, this.token, this.serverWithOptionalPort, this.stream, this.from.longValue());
        }
    }
}
