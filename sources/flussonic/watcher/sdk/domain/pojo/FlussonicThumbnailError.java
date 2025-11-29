package flussonic.watcher.sdk.domain.pojo;

import flussonic.watcher.sdk.domain.pojo.AutoValue_FlussonicThumbnailError;

/* loaded from: classes3.dex */
public abstract class FlussonicThumbnailError {

    public static abstract class Builder {
        public abstract FlussonicThumbnailError build();

        public abstract Builder setCause(Throwable cause);

        public abstract Builder setCode(String code);

        public abstract Builder setMessage(String message);
    }

    public abstract Throwable cause();

    public abstract String code();

    public abstract String message();

    public static Builder builder() {
        return new AutoValue_FlussonicThumbnailError.Builder();
    }
}
