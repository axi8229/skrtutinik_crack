package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;

/* loaded from: classes2.dex */
public final class Track {
    public final long durationUs;
    public final long[] editListDurations;
    public final long[] editListMediaTimes;
    public final Format format;
    public final int id;
    public final long movieTimescale;
    public final int nalUnitLengthFieldLength;
    private final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
    public final int sampleTransformation;
    public final long timescale;
    public final int type;

    public Track(int id, int type, long timescale, long movieTimescale, long durationUs, Format format, int sampleTransformation, TrackEncryptionBox[] sampleDescriptionEncryptionBoxes, int nalUnitLengthFieldLength, long[] editListDurations, long[] editListMediaTimes) {
        this.id = id;
        this.type = type;
        this.timescale = timescale;
        this.movieTimescale = movieTimescale;
        this.durationUs = durationUs;
        this.format = format;
        this.sampleTransformation = sampleTransformation;
        this.sampleDescriptionEncryptionBoxes = sampleDescriptionEncryptionBoxes;
        this.nalUnitLengthFieldLength = nalUnitLengthFieldLength;
        this.editListDurations = editListDurations;
        this.editListMediaTimes = editListMediaTimes;
    }

    public TrackEncryptionBox getSampleDescriptionEncryptionBox(int sampleDescriptionIndex) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.sampleDescriptionEncryptionBoxes;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[sampleDescriptionIndex];
    }
}
