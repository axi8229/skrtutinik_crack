package flussonic.watcher.sdk.domain.pojo;

import java.util.List;

/* loaded from: classes3.dex */
final class AutoValue_MediaInfo extends MediaInfo {
    private final int height;
    private final List<Track> streams;
    private final int width;

    AutoValue_MediaInfo(int width, int height, List<Track> streams) {
        this.width = width;
        this.height = height;
        if (streams == null) {
            throw new NullPointerException("Null streams");
        }
        this.streams = streams;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.MediaInfo
    public int width() {
        return this.width;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.MediaInfo
    public int height() {
        return this.height;
    }

    @Override // flussonic.watcher.sdk.domain.pojo.MediaInfo
    public List<Track> streams() {
        return this.streams;
    }

    public String toString() {
        return "MediaInfo{width=" + this.width + ", height=" + this.height + ", streams=" + this.streams + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) o;
        return this.width == mediaInfo.width() && this.height == mediaInfo.height() && this.streams.equals(mediaInfo.streams());
    }

    public int hashCode() {
        return ((((this.width ^ 1000003) * 1000003) ^ this.height) * 1000003) ^ this.streams.hashCode();
    }
}
