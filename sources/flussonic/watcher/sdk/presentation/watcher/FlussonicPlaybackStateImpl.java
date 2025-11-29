package flussonic.watcher.sdk.presentation.watcher;

import android.os.Parcel;
import android.os.Parcelable;
import flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor;
import flussonic.watcher.sdk.domain.pojo.PlaybackSpeed;
import flussonic.watcher.sdk.domain.pojo.Quality;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.pojo.Ranges;
import flussonic.watcher.sdk.domain.pojo.RangesResponse;
import flussonic.watcher.sdk.domain.pojo.Track;
import flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent;
import flussonic.watcher.sdk.domain.utils.FlussonicUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import timber.log.Timber;

/* loaded from: classes3.dex */
class FlussonicPlaybackStateImpl implements RecordingStatusInteractor.RangesProcessor, Parcelable {
    public static final Parcelable.Creator<FlussonicPlaybackStateImpl> CREATOR = new Parcelable.Creator<FlussonicPlaybackStateImpl>() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicPlaybackStateImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FlussonicPlaybackStateImpl createFromParcel(Parcel source) {
            return new FlussonicPlaybackStateImpl(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FlussonicPlaybackStateImpl[] newArray(int size) {
            return new FlussonicPlaybackStateImpl[size];
        }
    };
    private Quality archiveQuality;
    private final List<Range> events;
    private final List<Range> failedRanges;
    private long from;
    private Quality liveQuality;
    private Track liveTrack;
    private final List<Range> loadingRanges;
    private long playbackStoppedAtTime;
    private long playerPosition;
    private final List<Range> ranges;
    private final List<Range> requestedRanges;
    private PlaybackSpeed speed;
    private long startPosition;
    private long theLeftBorder;
    private long theRightBorder;
    private float volume;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    FlussonicPlaybackStateImpl() {
        this.requestedRanges = new ArrayList();
        this.ranges = new ArrayList();
        this.events = new ArrayList();
        this.loadingRanges = new ArrayList();
        this.failedRanges = new ArrayList();
        this.volume = 1.0f;
        this.speed = PlaybackSpeed.NORMAL;
        this.playbackStoppedAtTime = 0L;
    }

    private FlussonicPlaybackStateImpl(Parcel in) {
        this.requestedRanges = new ArrayList();
        this.ranges = new ArrayList();
        this.events = new ArrayList();
        this.loadingRanges = new ArrayList();
        this.failedRanges = new ArrayList();
        this.volume = 1.0f;
        this.speed = PlaybackSpeed.NORMAL;
        this.playbackStoppedAtTime = 0L;
        this.theLeftBorder = in.readLong();
        this.theRightBorder = in.readLong();
        this.from = in.readLong();
        this.playerPosition = in.readLong();
        this.startPosition = in.readLong();
        this.volume = in.readFloat();
        int i = in.readInt();
        this.speed = i == -1 ? null : PlaybackSpeed.values()[i];
        this.liveTrack = (Track) in.readParcelable(Track.class.getClassLoader());
        int i2 = in.readInt();
        this.liveQuality = i2 == -1 ? null : Quality.values()[i2];
        int i3 = in.readInt();
        this.archiveQuality = i3 != -1 ? Quality.values()[i3] : null;
    }

    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.RangesProcessor
    public synchronized long getLastValue() {
        long jUtcTimeSeconds;
        jUtcTimeSeconds = this.theRightBorder;
        if (jUtcTimeSeconds == 0) {
            jUtcTimeSeconds = FlussonicUtils.utcTimeSeconds();
        }
        return jUtcTimeSeconds;
    }

    synchronized Range getAvailableRange() {
        long j;
        try {
            j = this.theLeftBorder;
        } catch (Throwable th) {
            throw th;
        }
        return (j == 0 && this.theRightBorder == 0) ? Range.empty() : Range.createFromTo(j, this.theRightBorder);
    }

    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.RangesProcessor
    public synchronized void setAvailableRange(Range range) {
        this.theLeftBorder = range.from();
        this.theRightBorder = range.to();
    }

    public synchronized boolean isArchiveAvailable() {
        return getAvailableRange() != Range.empty();
    }

    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.RangesProcessor
    public synchronized Ranges getLoadedRanges() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        arrayList = new ArrayList(this.ranges);
        arrayList2 = new ArrayList(this.loadingRanges);
        FlussonicUtils.mergeRanges0(arrayList2, this.failedRanges);
        arrayList3 = new ArrayList(this.events);
        long jMin = Math.min(FlussonicUtils.utcTimeSeconds(), arrayList.isEmpty() ? 0L : ((Range) arrayList.get(arrayList.size() - 1)).to());
        FlussonicUtils.reduceRangesRight(arrayList, jMin);
        FlussonicUtils.reduceRangesRight(arrayList3, jMin);
        FlussonicUtils.reduceRangesRight(arrayList2, jMin);
        FlussonicUtils.increaseLastRangeToNowIfNeeded(arrayList);
        FlussonicUtils.subtract(arrayList2, arrayList);
        return Ranges.create(arrayList, arrayList3, arrayList2);
    }

    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.RangesProcessor
    public synchronized Range expandRange(VisibleRangeChangedEvent event) {
        long j;
        long j2;
        try {
            long jFrom = event.range().from();
            long j3 = event.range().to();
            long jSecondsInScreen = (event.secondsInScreen() > 0 ? event.secondsInScreen() : event.range().duration()) * 2;
            j = jFrom - jSecondsInScreen;
            j2 = j3 + jSecondsInScreen;
            long j4 = this.theLeftBorder;
            if (j < j4) {
                j = j4;
            }
            long jUtcTimeSeconds = FlussonicUtils.utcTimeSeconds();
            if (j2 > jUtcTimeSeconds) {
                j2 = jUtcTimeSeconds;
            }
        } catch (Throwable th) {
            throw th;
        }
        return Range.createFromTo(j, j2);
    }

    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.RangesProcessor
    public synchronized List<Range> splitRange(Range range) {
        List<Range> listSplitRange;
        listSplitRange = FlussonicUtils.splitRange(range, this.requestedRanges);
        FlussonicUtils.subtract(listSplitRange, this.loadingRanges);
        return listSplitRange;
    }

    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.RangesProcessor
    public List<Range> splitRangeByDuration(List<Range> ranges) {
        return FlussonicUtils.splitRanges(ranges, 345600L);
    }

    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.RangesProcessor
    public synchronized List<Range> expandRangeByConstant(List<Range> ranges) {
        for (int i = 0; i < ranges.size(); i++) {
            Range range = ranges.get(i);
            if (range.duration() < 10) {
                long jFrom = range.from() - 10;
                long j = range.to() + 10;
                long j2 = this.theLeftBorder;
                if (jFrom < j2) {
                    j = j2 + 20;
                    jFrom = j2;
                }
                ranges.set(i, Range.createFromTo(jFrom, j));
            }
        }
        return ranges;
    }

    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.RangesProcessor
    public void mergeRanges(RangesResponse rangesResponse) {
        long j;
        List listSingletonList = Collections.singletonList(rangesResponse.requestedRange());
        if (rangesResponse.isFailed()) {
            synchronized (this) {
                FlussonicUtils.subtract(this.loadingRanges, listSingletonList);
                FlussonicUtils.mergeRanges0(this.failedRanges, listSingletonList);
            }
            return;
        }
        if (rangesResponse.tooBigRange()) {
            Timber.e("too big range: ignoring", new Object[0]);
            return;
        }
        synchronized (this) {
            try {
                FlussonicUtils.mergeRanges1(this.ranges, rangesResponse.ranges());
                FlussonicUtils.mergeRanges1(this.events, rangesResponse.events());
                FlussonicUtils.mergeRanges0(this.requestedRanges, listSingletonList);
                FlussonicUtils.subtract(this.loadingRanges, listSingletonList);
                FlussonicUtils.subtract(this.failedRanges, listSingletonList);
                if (this.ranges.isEmpty()) {
                    j = 0;
                } else {
                    j = this.ranges.get(r5.size() - 1).to();
                }
                FlussonicUtils.reduceRangesRight(this.requestedRanges, j);
                if (j > 0) {
                    this.theRightBorder = j;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.RangesProcessor
    public void mergeEvents(List<Range> eventRanges) {
        if (eventRanges.isEmpty()) {
            Timber.e("Empty Events - ignored", new Object[0]);
        } else {
            synchronized (this) {
                FlussonicUtils.mergeRanges1(this.events, eventRanges);
            }
        }
    }

    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.RangesProcessor
    public synchronized void putLoadingRanges(List<Range> ranges) {
        FlussonicUtils.mergeRanges0(this.loadingRanges, ranges);
    }

    synchronized void beforeStartingRequests() {
        this.loadingRanges.clear();
        this.failedRanges.clear();
    }

    long getLastPosition() {
        if (isLive()) {
            return 0L;
        }
        return getArchivePosition();
    }

    long getTimelinePosition() {
        return isLive() ? FlussonicUtils.utcTimeSeconds() : getArchivePosition();
    }

    long correctFrom(long from) {
        if (from == 0) {
            return 0L;
        }
        return !FlussonicUtils.contains(new ArrayList(this.requestedRanges), from) ? from : FlussonicUtils.calculateTimelinePosition(this.ranges, from, 0L);
    }

    private synchronized long getArchivePosition() {
        return this.playerPosition;
    }

    synchronized long getDateTimeInBorders(long dateTimeInSecs) {
        long j = this.theLeftBorder;
        if (j != 0) {
            long j2 = this.theRightBorder;
            if (j2 != 0 && dateTimeInSecs > 0) {
                if (dateTimeInSecs < j) {
                    return j;
                }
                if (dateTimeInSecs >= j2) {
                    return 0L;
                }
                return dateTimeInSecs;
            }
        }
        return 0L;
    }

    synchronized void clearCache() {
        this.requestedRanges.clear();
        this.ranges.clear();
        this.events.clear();
        this.loadingRanges.clear();
        this.failedRanges.clear();
    }

    void setPlayerPosition(long value) {
        this.playerPosition = value;
    }

    void setFrom(long value) {
        this.from = value;
    }

    boolean isLive() {
        return this.from == 0;
    }

    boolean isArchive() {
        return !isLive();
    }

    float getVolume() {
        return this.volume;
    }

    void setVolume(float volume) {
        this.volume = volume;
    }

    PlaybackSpeed getSpeed() {
        return this.speed;
    }

    void setSpeed(PlaybackSpeed speed) {
        this.speed = speed;
    }

    Track getLiveTrack() {
        return this.liveTrack;
    }

    Quality getLiveQuality() {
        return this.liveQuality;
    }

    Quality getArchiveQuality() {
        return this.archiveQuality;
    }

    void setArchiveQuality(Quality archiveQuality) {
        this.archiveQuality = archiveQuality;
    }

    void setLiveTrackInfo(Track track, Quality quality) {
        if ((track == null && quality != null) || (track != null && quality == null)) {
            throw new IllegalArgumentException("Specify both live track and live quality");
        }
        this.liveTrack = track;
        this.liveQuality = quality;
    }

    long getStartPosition() {
        return this.startPosition;
    }

    void setStartPosition(long startPosition) {
        this.startPosition = startPosition;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.theLeftBorder);
        dest.writeLong(this.theRightBorder);
        dest.writeLong(this.from);
        dest.writeLong(this.playerPosition);
        dest.writeLong(this.startPosition);
        dest.writeFloat(this.volume);
        PlaybackSpeed playbackSpeed = this.speed;
        dest.writeInt(playbackSpeed == null ? -1 : playbackSpeed.ordinal());
        dest.writeParcelable(this.liveTrack, flags);
        Quality quality = this.liveQuality;
        dest.writeInt(quality == null ? -1 : quality.ordinal());
        Quality quality2 = this.archiveQuality;
        dest.writeInt(quality2 != null ? quality2.ordinal() : -1);
    }

    public void setPlaybackStoppedAtTime(long playbackStoppedAtTime) {
        this.playbackStoppedAtTime = playbackStoppedAtTime;
    }

    public boolean shouldRestartLivePlayback() {
        if (this.playbackStoppedAtTime <= 0) {
            return false;
        }
        long jUtcTimeSeconds = FlussonicUtils.utcTimeSeconds();
        long j = this.playbackStoppedAtTime;
        return jUtcTimeSeconds > 2 + j && jUtcTimeSeconds < j + 12;
    }
}
