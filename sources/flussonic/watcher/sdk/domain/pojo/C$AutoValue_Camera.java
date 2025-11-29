package flussonic.watcher.sdk.domain.pojo;

import flussonic.watcher.sdk.domain.pojo.Camera;

/* renamed from: flussonic.watcher.sdk.domain.pojo.$AutoValue_Camera, reason: invalid class name */
/* loaded from: classes3.dex */
abstract class C$AutoValue_Camera extends Camera {
    private final boolean hasAnError;
    private final int httpPort;
    private final int httpsPort;
    private final boolean isAlive;
    private final String name;
    private final boolean permissionDvr;
    private final int rtmpPort;
    private final String server;
    private final String title;
    private final String token;

    C$AutoValue_Camera(String title, boolean isAlive, int rtmpPort, int httpPort, int httpsPort, String server, String name, String token, boolean hasAnError, boolean permissionDvr) {
        this.title = title;
        this.isAlive = isAlive;
        this.rtmpPort = rtmpPort;
        this.httpPort = httpPort;
        this.httpsPort = httpsPort;
        if (server == null) {
            throw new NullPointerException("Null server");
        }
        this.server = server;
        if (name == null) {
            throw new NullPointerException("Null name");
        }
        this.name = name;
        if (token == null) {
            throw new NullPointerException("Null token");
        }
        this.token = token;
        this.hasAnError = hasAnError;
        this.permissionDvr = permissionDvr;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Camera
    public String title() {
        return this.title;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Camera
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Camera
    public int rtmpPort() {
        return this.rtmpPort;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Camera
    public int httpPort() {
        return this.httpPort;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Camera
    public int httpsPort() {
        return this.httpsPort;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Camera
    public String server() {
        return this.server;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Camera
    public String name() {
        return this.name;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Camera
    public String token() {
        return this.token;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Camera
    public boolean hasAnError() {
        return this.hasAnError;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.Camera
    protected boolean permissionDvr() {
        return this.permissionDvr;
    }

    public String toString() {
        return "Camera{title=" + this.title + ", isAlive=" + this.isAlive + ", rtmpPort=" + this.rtmpPort + ", httpPort=" + this.httpPort + ", httpsPort=" + this.httpsPort + ", server=" + this.server + ", name=" + this.name + ", token=" + this.token + ", hasAnError=" + this.hasAnError + ", permissionDvr=" + this.permissionDvr + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Camera)) {
            return false;
        }
        Camera camera = (Camera) o;
        String str = this.title;
        if (str != null ? str.equals(camera.title()) : camera.title() == null) {
            if (this.isAlive == camera.isAlive() && this.rtmpPort == camera.rtmpPort() && this.httpPort == camera.httpPort() && this.httpsPort == camera.httpsPort() && this.server.equals(camera.server()) && this.name.equals(camera.name()) && this.token.equals(camera.token()) && this.hasAnError == camera.hasAnError() && this.permissionDvr == camera.permissionDvr()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.title;
        return (((((((((((((((((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ (this.isAlive ? 1231 : 1237)) * 1000003) ^ this.rtmpPort) * 1000003) ^ this.httpPort) * 1000003) ^ this.httpsPort) * 1000003) ^ this.server.hashCode()) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.token.hashCode()) * 1000003) ^ (this.hasAnError ? 1231 : 1237)) * 1000003) ^ (this.permissionDvr ? 1231 : 1237);
    }

    /* renamed from: flussonic.watcher.sdk.domain.pojo.$AutoValue_Camera$Builder */
    static class Builder extends Camera.Builder {
        private Boolean hasAnError;
        private Integer httpPort;
        private Integer httpsPort;
        private Boolean isAlive;
        private String name;
        private Boolean permissionDvr;
        private Integer rtmpPort;
        private String server;
        private String title;
        private String token;

        Builder() {
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera.Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera.Builder setIsAlive(boolean isAlive) {
            this.isAlive = Boolean.valueOf(isAlive);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera.Builder setRtmpPort(int rtmpPort) {
            this.rtmpPort = Integer.valueOf(rtmpPort);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera.Builder setHttpPort(int httpPort) {
            this.httpPort = Integer.valueOf(httpPort);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera.Builder setHttpsPort(int httpsPort) {
            this.httpsPort = Integer.valueOf(httpsPort);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera.Builder setServer(String server) {
            if (server == null) {
                throw new NullPointerException("Null server");
            }
            this.server = server;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera.Builder setName(String name) {
            if (name == null) {
                throw new NullPointerException("Null name");
            }
            this.name = name;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera.Builder setToken(String token) {
            if (token == null) {
                throw new NullPointerException("Null token");
            }
            this.token = token;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera.Builder setHasAnError(boolean hasAnError) {
            this.hasAnError = Boolean.valueOf(hasAnError);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera.Builder setPermissionDvr(boolean permissionDvr) {
            this.permissionDvr = Boolean.valueOf(permissionDvr);
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.Camera.Builder
        public Camera build() {
            if (this.isAlive == null || this.rtmpPort == null || this.httpPort == null || this.httpsPort == null || this.server == null || this.name == null || this.token == null || this.hasAnError == null || this.permissionDvr == null) {
                StringBuilder sb = new StringBuilder();
                if (this.isAlive == null) {
                    sb.append(" isAlive");
                }
                if (this.rtmpPort == null) {
                    sb.append(" rtmpPort");
                }
                if (this.httpPort == null) {
                    sb.append(" httpPort");
                }
                if (this.httpsPort == null) {
                    sb.append(" httpsPort");
                }
                if (this.server == null) {
                    sb.append(" server");
                }
                if (this.name == null) {
                    sb.append(" name");
                }
                if (this.token == null) {
                    sb.append(" token");
                }
                if (this.hasAnError == null) {
                    sb.append(" hasAnError");
                }
                if (this.permissionDvr == null) {
                    sb.append(" permissionDvr");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_Camera(this.title, this.isAlive.booleanValue(), this.rtmpPort.intValue(), this.httpPort.intValue(), this.httpsPort.intValue(), this.server, this.name, this.token, this.hasAnError.booleanValue(), this.permissionDvr.booleanValue());
        }
    }
}
