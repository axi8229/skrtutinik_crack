package flussonic.watcher.sdk.domain.pojo;

import flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError;

/* loaded from: classes3.dex */
final class AutoValue_FlussonicThumbnailError extends FlussonicThumbnailError {
    private final Throwable cause;
    private final String code;
    private final String message;

    private AutoValue_FlussonicThumbnailError(String code, String message, Throwable cause) {
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError
    public String code() {
        return this.code;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError
    public String message() {
        return this.message;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError
    public Throwable cause() {
        return this.cause;
    }

    public String toString() {
        return "FlussonicThumbnailError{code=" + this.code + ", message=" + this.message + ", cause=" + this.cause + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof FlussonicThumbnailError)) {
            return false;
        }
        FlussonicThumbnailError flussonicThumbnailError = (FlussonicThumbnailError) o;
        return this.code.equals(flussonicThumbnailError.code()) && this.message.equals(flussonicThumbnailError.message()) && this.cause.equals(flussonicThumbnailError.cause());
    }

    public int hashCode() {
        return ((((this.code.hashCode() ^ 1000003) * 1000003) ^ this.message.hashCode()) * 1000003) ^ this.cause.hashCode();
    }

    static final class Builder extends FlussonicThumbnailError.Builder {
        private Throwable cause;
        private String code;
        private String message;

        Builder() {
        }

        @Override // flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError.Builder
        public FlussonicThumbnailError.Builder setCode(String code) {
            if (code == null) {
                throw new NullPointerException("Null code");
            }
            this.code = code;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError.Builder
        public FlussonicThumbnailError.Builder setMessage(String message) {
            if (message == null) {
                throw new NullPointerException("Null message");
            }
            this.message = message;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError.Builder
        public FlussonicThumbnailError.Builder setCause(Throwable cause) {
            if (cause == null) {
                throw new NullPointerException("Null cause");
            }
            this.cause = cause;
            return this;
        }

        @Override // flussonic.watcher.sdk.domain.pojo.FlussonicThumbnailError.Builder
        public FlussonicThumbnailError build() {
            String str;
            Throwable th;
            String str2 = this.code;
            if (str2 == null || (str = this.message) == null || (th = this.cause) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.code == null) {
                    sb.append(" code");
                }
                if (this.message == null) {
                    sb.append(" message");
                }
                if (this.cause == null) {
                    sb.append(" cause");
                }
                throw new IllegalStateException("Missing required properties:" + ((Object) sb));
            }
            return new AutoValue_FlussonicThumbnailError(str2, str, th);
        }
    }
}
