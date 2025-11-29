package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class Mp4Extractor implements Extractor, SeekMap {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return Mp4Extractor.lambda$static$0();
        }
    };
    private long[][] accumulatedSampleSizes;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private int firstVideoTrackIndex;
    private final int flags;
    private boolean isQuickTime;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleTrackIndex;
    private final ParsableByteArray scratch;
    private Mp4Track[] tracks;

    private static boolean shouldParseContainerAtom(int atom) {
        return atom == 1836019574 || atom == 1953653099 || atom == 1835297121 || atom == 1835626086 || atom == 1937007212 || atom == 1701082227 || atom == 1835365473;
    }

    private static boolean shouldParseLeafAtom(int atom) {
        return atom == 1835296868 || atom == 1836476516 || atom == 1751411826 || atom == 1937011556 || atom == 1937011827 || atom == 1937011571 || atom == 1668576371 || atom == 1701606260 || atom == 1937011555 || atom == 1937011578 || atom == 1937013298 || atom == 1937007471 || atom == 1668232756 || atom == 1953196132 || atom == 1718909296 || atom == 1969517665 || atom == 1801812339 || atom == 1768715124;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new Mp4Extractor()};
    }

    public Mp4Extractor() {
        this(0);
    }

    public Mp4Extractor(int flags) {
        this.flags = flags;
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new ArrayDeque<>();
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.scratch = new ParsableByteArray();
        this.sampleTrackIndex = -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput input) throws IOException {
        return Sniffer.sniffUnfragmented(input);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput output) {
        this.extractorOutput = output;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long position, long timeUs) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        if (position == 0) {
            enterReadingAtomHeaderState();
        } else if (this.tracks != null) {
            updateSampleIndices(timeUs);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput input, PositionHolder seekPosition) throws IOException {
        while (true) {
            int i = this.parserState;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return readSample(input, seekPosition);
                    }
                    throw new IllegalStateException();
                }
                if (readAtomPayload(input, seekPosition)) {
                    return 1;
                }
            } else if (!readAtomHeader(input)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long timeUs) {
        long j;
        long j2;
        int indexOfLaterOrEqualSynchronizationSample;
        Mp4Track[] mp4TrackArr = this.tracks;
        if (mp4TrackArr.length == 0) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        int i = this.firstVideoTrackIndex;
        long jMaybeAdjustSeekOffset = -1;
        if (i != -1) {
            TrackSampleTable trackSampleTable = mp4TrackArr[i].sampleTable;
            int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, timeUs);
            if (synchronizationSampleIndex == -1) {
                return new SeekMap.SeekPoints(SeekPoint.START);
            }
            long j3 = trackSampleTable.timestampsUs[synchronizationSampleIndex];
            j = trackSampleTable.offsets[synchronizationSampleIndex];
            if (j3 >= timeUs || synchronizationSampleIndex >= trackSampleTable.sampleCount - 1 || (indexOfLaterOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(timeUs)) == -1 || indexOfLaterOrEqualSynchronizationSample == synchronizationSampleIndex) {
                j2 = -9223372036854775807L;
            } else {
                j2 = trackSampleTable.timestampsUs[indexOfLaterOrEqualSynchronizationSample];
                jMaybeAdjustSeekOffset = trackSampleTable.offsets[indexOfLaterOrEqualSynchronizationSample];
            }
            timeUs = j3;
        } else {
            j = Long.MAX_VALUE;
            j2 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            Mp4Track[] mp4TrackArr2 = this.tracks;
            if (i2 >= mp4TrackArr2.length) {
                break;
            }
            if (i2 != this.firstVideoTrackIndex) {
                TrackSampleTable trackSampleTable2 = mp4TrackArr2[i2].sampleTable;
                long jMaybeAdjustSeekOffset2 = maybeAdjustSeekOffset(trackSampleTable2, timeUs, j);
                if (j2 != -9223372036854775807L) {
                    jMaybeAdjustSeekOffset = maybeAdjustSeekOffset(trackSampleTable2, j2, jMaybeAdjustSeekOffset);
                }
                j = jMaybeAdjustSeekOffset2;
            }
            i2++;
        }
        SeekPoint seekPoint = new SeekPoint(timeUs, j);
        if (j2 == -9223372036854775807L) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(j2, jMaybeAdjustSeekOffset));
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private boolean readAtomHeader(ExtractorInput input) throws IOException {
        Atom.ContainerAtom containerAtomPeek;
        if (this.atomHeaderBytesRead == 0) {
            if (!input.readFully(this.atomHeader.data, 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j = this.atomSize;
        if (j == 1) {
            input.readFully(this.atomHeader.data, 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j == 0) {
            long length = input.getLength();
            if (length == -1 && (containerAtomPeek = this.containerAtoms.peek()) != null) {
                length = containerAtomPeek.endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - input.getPosition()) + this.atomHeaderBytesRead;
            }
        }
        if (this.atomSize < this.atomHeaderBytesRead) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if (shouldParseContainerAtom(this.atomType)) {
            long position = input.getPosition();
            long j2 = this.atomSize;
            int i = this.atomHeaderBytesRead;
            long j3 = (position + j2) - i;
            if (j2 != i && this.atomType == 1835365473) {
                maybeSkipRemainingMetaAtomHeaderBytes(input);
            }
            this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, j3));
            if (this.atomSize == this.atomHeaderBytesRead) {
                processAtomEnded(j3);
            } else {
                enterReadingAtomHeaderState();
            }
        } else if (shouldParseLeafAtom(this.atomType)) {
            Assertions.checkState(this.atomHeaderBytesRead == 8);
            Assertions.checkState(this.atomSize <= 2147483647L);
            ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.atomSize);
            this.atomData = parsableByteArray;
            System.arraycopy(this.atomHeader.data, 0, parsableByteArray.data, 0, 8);
            this.parserState = 1;
        } else {
            this.atomData = null;
            this.parserState = 1;
        }
        return true;
    }

    private boolean readAtomPayload(ExtractorInput input, PositionHolder positionHolder) throws IOException {
        boolean z;
        long j = this.atomSize - this.atomHeaderBytesRead;
        long position = input.getPosition() + j;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            input.readFully(parsableByteArray.data, this.atomHeaderBytesRead, (int) j);
            if (this.atomType == 1718909296) {
                this.isQuickTime = processFtypAtom(this.atomData);
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(new Atom.LeafAtom(this.atomType, this.atomData));
            }
        } else if (j < 262144) {
            input.skipFully((int) j);
        } else {
            positionHolder.position = input.getPosition() + j;
            z = true;
            processAtomEnded(position);
            return (z || this.parserState == 2) ? false : true;
        }
        z = false;
        processAtomEnded(position);
        if (z) {
        }
    }

    private void processAtomEnded(long atomEndPosition) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == atomEndPosition) {
            Atom.ContainerAtom containerAtomPop = this.containerAtoms.pop();
            if (containerAtomPop.type == 1836019574) {
                processMoovAtom(containerAtomPop);
                this.containerAtoms.clear();
                this.parserState = 2;
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(containerAtomPop);
            }
        }
        if (this.parserState != 2) {
            enterReadingAtomHeaderState();
        }
    }

    private void processMoovAtom(Atom.ContainerAtom moov) throws ParserException {
        Metadata udta;
        TrackSampleTable trackSampleTable;
        long j;
        ArrayList arrayList = new ArrayList();
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom.LeafAtom leafAtomOfType = moov.getLeafAtomOfType(1969517665);
        if (leafAtomOfType != null) {
            udta = AtomParsers.parseUdta(leafAtomOfType, this.isQuickTime);
            if (udta != null) {
                gaplessInfoHolder.setFromMetadata(udta);
            }
        } else {
            udta = null;
        }
        Atom.ContainerAtom containerAtomOfType = moov.getContainerAtomOfType(1835365473);
        Metadata mdtaFromMeta = containerAtomOfType != null ? AtomParsers.parseMdtaFromMeta(containerAtomOfType) : null;
        ArrayList<TrackSampleTable> trackSampleTables = getTrackSampleTables(moov, gaplessInfoHolder, (this.flags & 1) != 0);
        int size = trackSampleTables.size();
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        int i = 0;
        int size2 = -1;
        while (i < size) {
            TrackSampleTable trackSampleTable2 = trackSampleTables.get(i);
            Track track = trackSampleTable2.track;
            long j4 = track.durationUs;
            if (j4 != j2) {
                j = j4;
                trackSampleTable = trackSampleTable2;
            } else {
                trackSampleTable = trackSampleTable2;
                j = trackSampleTable.durationUs;
            }
            long jMax = Math.max(j3, j);
            ArrayList<TrackSampleTable> arrayList2 = trackSampleTables;
            int i2 = size;
            Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, this.extractorOutput.track(i, track.type));
            int i3 = trackSampleTable.maximumSize + 30;
            Format.Builder builderBuildUpon = track.format.buildUpon();
            builderBuildUpon.setMaxInputSize(i3);
            if (track.type == 2 && j > 0) {
                int i4 = trackSampleTable.sampleCount;
                if (i4 > 1) {
                    builderBuildUpon.setFrameRate(i4 / (j / 1000000.0f));
                }
            }
            MetadataUtil.setFormatMetadata(track.type, udta, mdtaFromMeta, gaplessInfoHolder, builderBuildUpon);
            mp4Track.trackOutput.format(builderBuildUpon.build());
            if (track.type == 2 && size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(mp4Track);
            i++;
            trackSampleTables = arrayList2;
            size = i2;
            j3 = jMax;
            j2 = -9223372036854775807L;
        }
        this.firstVideoTrackIndex = size2;
        this.durationUs = j3;
        Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList.toArray(new Mp4Track[0]);
        this.tracks = mp4TrackArr;
        this.accumulatedSampleSizes = calculateAccumulatedSampleSizes(mp4TrackArr);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(this);
    }

    private ArrayList<TrackSampleTable> getTrackSampleTables(Atom.ContainerAtom moov, GaplessInfoHolder gaplessInfoHolder, boolean ignoreEditLists) throws ParserException {
        Track trak;
        ArrayList<TrackSampleTable> arrayList = new ArrayList<>();
        for (int i = 0; i < moov.containerChildren.size(); i++) {
            Atom.ContainerAtom containerAtom = moov.containerChildren.get(i);
            if (containerAtom.type == 1953653099 && (trak = AtomParsers.parseTrak(containerAtom, moov.getLeafAtomOfType(1836476516), -9223372036854775807L, null, ignoreEditLists, this.isQuickTime)) != null) {
                TrackSampleTable stbl = AtomParsers.parseStbl(trak, containerAtom.getContainerAtomOfType(1835297121).getContainerAtomOfType(1835626086).getContainerAtomOfType(1937007212), gaplessInfoHolder);
                if (stbl.sampleCount != 0) {
                    arrayList.add(stbl);
                }
            }
        }
        return arrayList;
    }

    private int readSample(ExtractorInput input, PositionHolder positionHolder) throws IOException {
        long position = input.getPosition();
        if (this.sampleTrackIndex == -1) {
            int trackIndexOfNextReadSample = getTrackIndexOfNextReadSample(position);
            this.sampleTrackIndex = trackIndexOfNextReadSample;
            if (trackIndexOfNextReadSample == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = this.tracks[this.sampleTrackIndex];
        TrackOutput trackOutput = mp4Track.trackOutput;
        int i = mp4Track.sampleIndex;
        TrackSampleTable trackSampleTable = mp4Track.sampleTable;
        long j = trackSampleTable.offsets[i];
        int i2 = trackSampleTable.sizes[i];
        long j2 = (j - position) + this.sampleBytesRead;
        if (j2 < 0 || j2 >= 262144) {
            positionHolder.position = j;
            return 1;
        }
        if (mp4Track.track.sampleTransformation == 1) {
            j2 += 8;
            i2 -= 8;
        }
        input.skipFully((int) j2);
        Track track = mp4Track.track;
        int i3 = track.nalUnitLengthFieldLength;
        if (i3 != 0) {
            byte[] bArr = this.nalLength.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = 4 - i3;
            while (this.sampleBytesWritten < i2) {
                int i5 = this.sampleCurrentNalBytesRemaining;
                if (i5 == 0) {
                    input.readFully(bArr, i4, i3);
                    this.sampleBytesRead += i3;
                    this.nalLength.setPosition(0);
                    int i6 = this.nalLength.readInt();
                    if (i6 < 0) {
                        throw new ParserException("Invalid NAL length");
                    }
                    this.sampleCurrentNalBytesRemaining = i6;
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                    i2 += i4;
                } else {
                    int iSampleData = trackOutput.sampleData(input, i5, false);
                    this.sampleBytesRead += iSampleData;
                    this.sampleBytesWritten += iSampleData;
                    this.sampleCurrentNalBytesRemaining -= iSampleData;
                }
            }
        } else {
            if ("audio/ac4".equals(track.format.sampleMimeType)) {
                if (this.sampleBytesWritten == 0) {
                    Ac4Util.getAc4SampleHeader(i2, this.scratch);
                    trackOutput.sampleData(this.scratch, 7);
                    this.sampleBytesWritten += 7;
                }
                i2 += 7;
            }
            while (true) {
                int i7 = this.sampleBytesWritten;
                if (i7 >= i2) {
                    break;
                }
                int iSampleData2 = trackOutput.sampleData(input, i2 - i7, false);
                this.sampleBytesRead += iSampleData2;
                this.sampleBytesWritten += iSampleData2;
                this.sampleCurrentNalBytesRemaining -= iSampleData2;
            }
        }
        int i8 = i2;
        TrackSampleTable trackSampleTable2 = mp4Track.sampleTable;
        trackOutput.sampleMetadata(trackSampleTable2.timestampsUs[i], trackSampleTable2.flags[i], i8, 0, null);
        mp4Track.sampleIndex++;
        this.sampleTrackIndex = -1;
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        return 0;
    }

    private int getTrackIndexOfNextReadSample(long inputPosition) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j = Long.MAX_VALUE;
        boolean z = true;
        long j2 = Long.MAX_VALUE;
        boolean z2 = true;
        long j3 = Long.MAX_VALUE;
        while (true) {
            Mp4Track[] mp4TrackArr = this.tracks;
            if (i3 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i3];
            int i4 = mp4Track.sampleIndex;
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            if (i4 != trackSampleTable.sampleCount) {
                long j4 = trackSampleTable.offsets[i4];
                long j5 = this.accumulatedSampleSizes[i3][i4];
                long j6 = j4 - inputPosition;
                boolean z3 = j6 < 0 || j6 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j6 < j3)) {
                    z2 = z3;
                    j3 = j6;
                    i2 = i3;
                    j2 = j5;
                }
                if (j5 < j) {
                    z = z3;
                    i = i3;
                    j = j5;
                }
            }
            i3++;
        }
        return (j == Long.MAX_VALUE || !z || j2 < j + 10485760) ? i2 : i;
    }

    private void updateSampleIndices(long timeUs) {
        for (Mp4Track mp4Track : this.tracks) {
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(timeUs);
            if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(timeUs);
            }
            mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
        }
    }

    private void maybeSkipRemainingMetaAtomHeaderBytes(ExtractorInput input) throws IOException {
        this.scratch.reset(8);
        input.peekFully(this.scratch.data, 0, 8);
        this.scratch.skipBytes(4);
        if (this.scratch.readInt() == 1751411826) {
            input.resetPeekPosition();
        } else {
            input.skipFully(4);
        }
    }

    private static long[][] calculateAccumulatedSampleSizes(Mp4Track[] tracks) {
        long[][] jArr = new long[tracks.length][];
        int[] iArr = new int[tracks.length];
        long[] jArr2 = new long[tracks.length];
        boolean[] zArr = new boolean[tracks.length];
        for (int i = 0; i < tracks.length; i++) {
            jArr[i] = new long[tracks[i].sampleTable.sampleCount];
            jArr2[i] = tracks[i].sampleTable.timestampsUs[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < tracks.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < tracks.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            long[] jArr3 = jArr[i3];
            jArr3[i5] = j;
            TrackSampleTable trackSampleTable = tracks[i3].sampleTable;
            j += trackSampleTable.sizes[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr3.length) {
                jArr2[i3] = trackSampleTable.timestampsUs[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private static long maybeAdjustSeekOffset(TrackSampleTable sampleTable, long seekTimeUs, long offset) {
        int synchronizationSampleIndex = getSynchronizationSampleIndex(sampleTable, seekTimeUs);
        return synchronizationSampleIndex == -1 ? offset : Math.min(sampleTable.offsets[synchronizationSampleIndex], offset);
    }

    private static int getSynchronizationSampleIndex(TrackSampleTable sampleTable, long timeUs) {
        int indexOfEarlierOrEqualSynchronizationSample = sampleTable.getIndexOfEarlierOrEqualSynchronizationSample(timeUs);
        return indexOfEarlierOrEqualSynchronizationSample == -1 ? sampleTable.getIndexOfLaterOrEqualSynchronizationSample(timeUs) : indexOfEarlierOrEqualSynchronizationSample;
    }

    private static boolean processFtypAtom(ParsableByteArray atomData) {
        atomData.setPosition(8);
        if (atomData.readInt() == 1903435808) {
            return true;
        }
        atomData.skipBytes(4);
        while (atomData.bytesLeft() > 0) {
            if (atomData.readInt() == 1903435808) {
                return true;
            }
        }
        return false;
    }

    private static final class Mp4Track {
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;

        public Mp4Track(Track track, TrackSampleTable sampleTable, TrackOutput trackOutput) {
            this.track = track;
            this.sampleTable = sampleTable;
            this.trackOutput = trackOutput;
        }
    }
}
