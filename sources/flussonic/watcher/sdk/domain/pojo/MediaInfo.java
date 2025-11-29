package flussonic.watcher.sdk.domain.pojo;

import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class MediaInfo {
    public abstract int height();

    public abstract List<Track> streams();

    public abstract int width();

    public static MediaInfo create(int width, int height, List<Track> tracks) {
        return new AutoValue_MediaInfo(width, height, Collections.unmodifiableList(tracks));
    }

    public Track getLowerStreamBitrate(Track current) {
        for (Track track : streams()) {
            if (track.bitrate() < current.bitrate() && track.isVideoTrack()) {
                return track;
            }
        }
        return current;
    }

    public Track getMaxStreamBitrate() {
        for (Track track : streams()) {
            if (track.isVideoTrack()) {
                return track;
            }
        }
        return null;
    }

    public Track getMinStreamBitrate() {
        for (int size = streams().size() - 1; size >= 0; size--) {
            Track track = streams().get(size);
            if (track.isVideoTrack()) {
                return track;
            }
        }
        return null;
    }
}
