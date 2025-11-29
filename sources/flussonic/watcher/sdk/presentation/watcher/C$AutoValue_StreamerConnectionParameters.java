package flussonic.watcher.sdk.presentation.watcher;

/* renamed from: flussonic.watcher.sdk.presentation.watcher.$AutoValue_StreamerConnectionParameters, reason: invalid class name */
/* loaded from: classes3.dex */
abstract class C$AutoValue_StreamerConnectionParameters extends StreamerConnectionParameters {
    private final int httpPort;
    private final int httpsPort;
    private final boolean permissionDvr;
    private final int rtmpPort;
    private final String server;
    private final String stream;
    private final String token;

    C$AutoValue_StreamerConnectionParameters(int rtmpPort, int httpPort, int httpsPort, String server, String stream, String token, boolean permissionDvr) {
        this.rtmpPort = rtmpPort;
        this.httpPort = httpPort;
        this.httpsPort = httpsPort;
        if (server == null) {
            throw new NullPointerException("Null server");
        }
        this.server = server;
        if (stream == null) {
            throw new NullPointerException("Null stream");
        }
        this.stream = stream;
        if (token == null) {
            throw new NullPointerException("Null token");
        }
        this.token = token;
        this.permissionDvr = permissionDvr;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters
    public int rtmpPort() {
        return this.rtmpPort;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters
    public int httpPort() {
        return this.httpPort;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters
    public int httpsPort() {
        return this.httpsPort;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters
    public String server() {
        return this.server;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters
    public String stream() {
        return this.stream;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters
    public String token() {
        return this.token;
    }

    @Override // flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters
    public boolean permissionDvr() {
        return this.permissionDvr;
    }

    public String toString() {
        return "StreamerConnectionParameters{rtmpPort=" + this.rtmpPort + ", httpPort=" + this.httpPort + ", httpsPort=" + this.httpsPort + ", server=" + this.server + ", stream=" + this.stream + ", token=" + this.token + ", permissionDvr=" + this.permissionDvr + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StreamerConnectionParameters)) {
            return false;
        }
        StreamerConnectionParameters streamerConnectionParameters = (StreamerConnectionParameters) o;
        return this.rtmpPort == streamerConnectionParameters.rtmpPort() && this.httpPort == streamerConnectionParameters.httpPort() && this.httpsPort == streamerConnectionParameters.httpsPort() && this.server.equals(streamerConnectionParameters.server()) && this.stream.equals(streamerConnectionParameters.stream()) && this.token.equals(streamerConnectionParameters.token()) && this.permissionDvr == streamerConnectionParameters.permissionDvr();
    }

    public int hashCode() {
        return ((((((((((((this.rtmpPort ^ 1000003) * 1000003) ^ this.httpPort) * 1000003) ^ this.httpsPort) * 1000003) ^ this.server.hashCode()) * 1000003) ^ this.stream.hashCode()) * 1000003) ^ this.token.hashCode()) * 1000003) ^ (this.permissionDvr ? 1231 : 1237);
    }
}
