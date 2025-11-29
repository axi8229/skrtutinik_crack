package flussonic.watcher.sdk.domain.pojo;

import android.os.Parcelable;
import flussonic.watcher.sdk.domain.pojo.C$AutoValue_Camera;
import flussonic.watcher.sdk.presentation.watcher.StreamerConnectionParameters;

/* loaded from: classes3.dex */
public abstract class Camera implements Parcelable {
    private StreamerConnectionParameters connectionParameters;

    public static abstract class Builder {
        public abstract Camera build();

        public abstract Builder setHasAnError(boolean hasAnError);

        public abstract Builder setHttpPort(int httpPort);

        public abstract Builder setHttpsPort(int httpsPort);

        public abstract Builder setIsAlive(boolean isAlive);

        public abstract Builder setName(String name);

        public abstract Builder setPermissionDvr(boolean permissionDvr);

        public abstract Builder setRtmpPort(int rtmpPort);

        public abstract Builder setServer(String server);

        public abstract Builder setTitle(String title);

        public abstract Builder setToken(String token);
    }

    public abstract boolean hasAnError();

    public abstract int httpPort();

    public abstract int httpsPort();

    public abstract boolean isAlive();

    public abstract String name();

    protected abstract boolean permissionDvr();

    public abstract int rtmpPort();

    public abstract String server();

    public abstract String title();

    public abstract String token();

    public static Builder builder() {
        return new C$AutoValue_Camera.Builder();
    }

    private void initConnectionParameters() {
        if (this.connectionParameters == null) {
            this.connectionParameters = StreamerConnectionParameters.builder().setRtmpPort(Integer.valueOf(rtmpPort())).setHttpPort(Integer.valueOf(httpPort())).setHttpsPort(Integer.valueOf(httpsPort())).setServer(server()).setStream(name()).setToken(token()).setPermissionDvr(permissionDvr()).build();
        }
    }

    public StreamerConnectionParameters getConnectionParameters() {
        initConnectionParameters();
        return this.connectionParameters;
    }
}
