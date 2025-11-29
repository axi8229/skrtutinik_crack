package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.CeaUtil;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.KotlinVersion;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;

/* loaded from: classes2.dex */
public class FragmentedMp4Extractor implements Extractor {
    private final TrackOutput additionalEmsgTrackOutput;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private TrackOutput[] cea608TrackOutputs;
    private final List<Format> closedCaptionFormats;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private TrackBundle currentTrackBundle;
    private long durationUs;
    private TrackOutput[] emsgTrackOutputs;
    private long endOfMdatPosition;
    private final EventMessageEncoder eventMessageEncoder;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalBuffer;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final ArrayDeque<MetadataSampleInfo> pendingMetadataSampleInfos;
    private long pendingSeekTimeUs;
    private boolean processSeiNalUnitPayload;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private final ParsableByteArray scratch;
    private final byte[] scratchBytes;
    private long segmentIndexEarliestPresentationTimeUs;
    private final Track sideloadedTrack;
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray<TrackBundle> trackBundles;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return FragmentedMp4Extractor.lambda$static$0();
        }
    };
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final Format EMSG_FORMAT = new Format.Builder().setSampleMimeType("application/x-emsg").build();

    private static boolean shouldParseContainerAtom(int atom) {
        return atom == 1836019574 || atom == 1953653099 || atom == 1835297121 || atom == 1835626086 || atom == 1937007212 || atom == 1836019558 || atom == 1953653094 || atom == 1836475768 || atom == 1701082227;
    }

    private static boolean shouldParseLeafAtom(int atom) {
        return atom == 1751411826 || atom == 1835296868 || atom == 1836476516 || atom == 1936286840 || atom == 1937011556 || atom == 1952867444 || atom == 1952868452 || atom == 1953196132 || atom == 1953654136 || atom == 1953658222 || atom == 1886614376 || atom == 1935763834 || atom == 1935763823 || atom == 1936027235 || atom == 1970628964 || atom == 1935828848 || atom == 1936158820 || atom == 1701606260 || atom == 1835362404 || atom == 1701671783;
    }

    protected Track modifyTrack(Track track) {
        return track;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FragmentedMp4Extractor()};
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    public FragmentedMp4Extractor(int flags) {
        this(flags, null);
    }

    public FragmentedMp4Extractor(int flags, TimestampAdjuster timestampAdjuster) {
        this(flags, timestampAdjuster, null, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int flags, TimestampAdjuster timestampAdjuster, Track sideloadedTrack, List<Format> closedCaptionFormats) {
        this(flags, timestampAdjuster, sideloadedTrack, closedCaptionFormats, null);
    }

    public FragmentedMp4Extractor(int flags, TimestampAdjuster timestampAdjuster, Track sideloadedTrack, List<Format> closedCaptionFormats, TrackOutput additionalEmsgTrackOutput) {
        this.flags = flags | (sideloadedTrack != null ? 8 : 0);
        this.timestampAdjuster = timestampAdjuster;
        this.sideloadedTrack = sideloadedTrack;
        this.closedCaptionFormats = Collections.unmodifiableList(closedCaptionFormats);
        this.additionalEmsgTrackOutput = additionalEmsgTrackOutput;
        this.eventMessageEncoder = new EventMessageEncoder();
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(5);
        this.nalBuffer = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.scratchBytes = bArr;
        this.scratch = new ParsableByteArray(bArr);
        this.containerAtoms = new ArrayDeque<>();
        this.pendingMetadataSampleInfos = new ArrayDeque<>();
        this.trackBundles = new SparseArray<>();
        this.durationUs = -9223372036854775807L;
        this.pendingSeekTimeUs = -9223372036854775807L;
        this.segmentIndexEarliestPresentationTimeUs = -9223372036854775807L;
        enterReadingAtomHeaderState();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput input) throws IOException {
        return Sniffer.sniffFragmented(input);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput output) {
        this.extractorOutput = output;
        Track track = this.sideloadedTrack;
        if (track != null) {
            TrackBundle trackBundle = new TrackBundle(output.track(0, track.type));
            trackBundle.init(this.sideloadedTrack, new DefaultSampleValues(0, 0, 0, 0));
            this.trackBundles.put(0, trackBundle);
            maybeInitExtraTracks();
            this.extractorOutput.endTracks();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long position, long timeUs) {
        int size = this.trackBundles.size();
        for (int i = 0; i < size; i++) {
            this.trackBundles.valueAt(i).reset();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.pendingSeekTimeUs = timeUs;
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput input, PositionHolder seekPosition) throws IOException {
        while (true) {
            int i = this.parserState;
            if (i != 0) {
                if (i == 1) {
                    readAtomPayload(input);
                } else if (i == 2) {
                    readEncryptionData(input);
                } else if (readSample(input)) {
                    return 0;
                }
            } else if (!readAtomHeader(input)) {
                return -1;
            }
        }
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private boolean readAtomHeader(ExtractorInput input) throws IOException {
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
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - input.getPosition()) + this.atomHeaderBytesRead;
            }
        }
        if (this.atomSize < this.atomHeaderBytesRead) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        long position = input.getPosition() - this.atomHeaderBytesRead;
        if (this.atomType == 1836019558) {
            int size = this.trackBundles.size();
            for (int i = 0; i < size; i++) {
                TrackFragment trackFragment = this.trackBundles.valueAt(i).fragment;
                trackFragment.atomPosition = position;
                trackFragment.auxiliaryDataPosition = position;
                trackFragment.dataPosition = position;
            }
        }
        int i2 = this.atomType;
        if (i2 == 1835295092) {
            this.currentTrackBundle = null;
            this.endOfMdatPosition = this.atomSize + position;
            if (!this.haveOutputSeekMap) {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, position));
                this.haveOutputSeekMap = true;
            }
            this.parserState = 2;
            return true;
        }
        if (shouldParseContainerAtom(i2)) {
            long position2 = (input.getPosition() + this.atomSize) - 8;
            this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, position2));
            if (this.atomSize == this.atomHeaderBytesRead) {
                processAtomEnded(position2);
            } else {
                enterReadingAtomHeaderState();
            }
        } else if (shouldParseLeafAtom(this.atomType)) {
            if (this.atomHeaderBytesRead != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            long j2 = this.atomSize;
            if (j2 > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            ParsableByteArray parsableByteArray = new ParsableByteArray((int) j2);
            this.atomData = parsableByteArray;
            System.arraycopy(this.atomHeader.data, 0, parsableByteArray.data, 0, 8);
            this.parserState = 1;
        } else {
            if (this.atomSize > 2147483647L) {
                throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.atomData = null;
            this.parserState = 1;
        }
        return true;
    }

    private void readAtomPayload(ExtractorInput input) throws IOException {
        int i = ((int) this.atomSize) - this.atomHeaderBytesRead;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            input.readFully(parsableByteArray.data, 8, i);
            onLeafAtomRead(new Atom.LeafAtom(this.atomType, this.atomData), input.getPosition());
        } else {
            input.skipFully(i);
        }
        processAtomEnded(input.getPosition());
    }

    private void processAtomEnded(long atomEndPosition) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == atomEndPosition) {
            onContainerAtomRead(this.containerAtoms.pop());
        }
        enterReadingAtomHeaderState();
    }

    private void onLeafAtomRead(Atom.LeafAtom leaf, long inputPosition) throws ParserException {
        if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(leaf);
            return;
        }
        int i = leaf.type;
        if (i != 1936286840) {
            if (i == 1701671783) {
                onEmsgLeafAtomRead(leaf.data);
            }
        } else {
            Pair<Long, ChunkIndex> sidx = parseSidx(leaf.data, inputPosition);
            this.segmentIndexEarliestPresentationTimeUs = ((Long) sidx.first).longValue();
            this.extractorOutput.seekMap((SeekMap) sidx.second);
            this.haveOutputSeekMap = true;
        }
    }

    private void onContainerAtomRead(Atom.ContainerAtom container) throws ParserException {
        int i = container.type;
        if (i == 1836019574) {
            onMoovContainerAtomRead(container);
        } else if (i == 1836019558) {
            onMoofContainerAtomRead(container);
        } else {
            if (this.containerAtoms.isEmpty()) {
                return;
            }
            this.containerAtoms.peek().add(container);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onMoovContainerAtomRead(Atom.ContainerAtom moov) throws ParserException {
        int i;
        int i2;
        int i3 = 0;
        Assertions.checkState(this.sideloadedTrack == null, "Unexpected moov box.");
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(moov.leafChildren);
        Atom.ContainerAtom containerAtomOfType = moov.getContainerAtomOfType(1836475768);
        SparseArray sparseArray = new SparseArray();
        int size = containerAtomOfType.leafChildren.size();
        long mehd = -9223372036854775807L;
        for (int i4 = 0; i4 < size; i4++) {
            Atom.LeafAtom leafAtom = containerAtomOfType.leafChildren.get(i4);
            int i5 = leafAtom.type;
            if (i5 == 1953654136) {
                Pair<Integer, DefaultSampleValues> trex = parseTrex(leafAtom.data);
                sparseArray.put(((Integer) trex.first).intValue(), trex.second);
            } else if (i5 == 1835362404) {
                mehd = parseMehd(leafAtom.data);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = moov.containerChildren.size();
        int i6 = 0;
        while (i6 < size2) {
            Atom.ContainerAtom containerAtom = moov.containerChildren.get(i6);
            if (containerAtom.type == 1953653099) {
                i = i6;
                i2 = size2;
                Track trackModifyTrack = modifyTrack(AtomParsers.parseTrak(containerAtom, moov.getLeafAtomOfType(1836476516), mehd, drmInitDataFromAtoms, (this.flags & 16) != 0, false));
                if (trackModifyTrack != null) {
                    sparseArray2.put(trackModifyTrack.id, trackModifyTrack);
                }
            } else {
                i = i6;
                i2 = size2;
            }
            i6 = i + 1;
            size2 = i2;
        }
        int size3 = sparseArray2.size();
        if (this.trackBundles.size() == 0) {
            while (i3 < size3) {
                Track track = (Track) sparseArray2.valueAt(i3);
                TrackBundle trackBundle = new TrackBundle(this.extractorOutput.track(i3, track.type));
                trackBundle.init(track, getDefaultSampleValues(sparseArray, track.id));
                this.trackBundles.put(track.id, trackBundle);
                this.durationUs = Math.max(this.durationUs, track.durationUs);
                i3++;
            }
            maybeInitExtraTracks();
            this.extractorOutput.endTracks();
            return;
        }
        Assertions.checkState(this.trackBundles.size() == size3);
        while (i3 < size3) {
            Track track2 = (Track) sparseArray2.valueAt(i3);
            this.trackBundles.get(track2.id).init(track2, getDefaultSampleValues(sparseArray, track2.id));
            i3++;
        }
    }

    private DefaultSampleValues getDefaultSampleValues(SparseArray<DefaultSampleValues> defaultSampleValuesArray, int trackId) {
        if (defaultSampleValuesArray.size() == 1) {
            return defaultSampleValuesArray.valueAt(0);
        }
        return (DefaultSampleValues) Assertions.checkNotNull(defaultSampleValuesArray.get(trackId));
    }

    private void onMoofContainerAtomRead(Atom.ContainerAtom moof) throws ParserException {
        parseMoof(moof, this.trackBundles, this.flags, this.scratchBytes);
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(moof.leafChildren);
        if (drmInitDataFromAtoms != null) {
            int size = this.trackBundles.size();
            for (int i = 0; i < size; i++) {
                this.trackBundles.valueAt(i).updateDrmInitData(drmInitDataFromAtoms);
            }
        }
        if (this.pendingSeekTimeUs != -9223372036854775807L) {
            int size2 = this.trackBundles.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.trackBundles.valueAt(i2).seek(this.pendingSeekTimeUs);
            }
            this.pendingSeekTimeUs = -9223372036854775807L;
        }
    }

    private void maybeInitExtraTracks() {
        int i;
        if (this.emsgTrackOutputs == null) {
            TrackOutput[] trackOutputArr = new TrackOutput[2];
            this.emsgTrackOutputs = trackOutputArr;
            TrackOutput trackOutput = this.additionalEmsgTrackOutput;
            if (trackOutput != null) {
                trackOutputArr[0] = trackOutput;
                i = 1;
            } else {
                i = 0;
            }
            if ((this.flags & 4) != 0) {
                trackOutputArr[i] = this.extractorOutput.track(this.trackBundles.size(), 4);
                i++;
            }
            TrackOutput[] trackOutputArr2 = (TrackOutput[]) Arrays.copyOf(this.emsgTrackOutputs, i);
            this.emsgTrackOutputs = trackOutputArr2;
            for (TrackOutput trackOutput2 : trackOutputArr2) {
                trackOutput2.format(EMSG_FORMAT);
            }
        }
        if (this.cea608TrackOutputs == null) {
            this.cea608TrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
            for (int i2 = 0; i2 < this.cea608TrackOutputs.length; i2++) {
                TrackOutput trackOutputTrack = this.extractorOutput.track(this.trackBundles.size() + 1 + i2, 3);
                trackOutputTrack.format(this.closedCaptionFormats.get(i2));
                this.cea608TrackOutputs[i2] = trackOutputTrack;
            }
        }
    }

    private void onEmsgLeafAtomRead(ParsableByteArray atom) {
        long jScaleLargeTimestamp;
        String str;
        long jScaleLargeTimestamp2;
        String str2;
        long unsignedInt;
        long jAdjustSampleTimestamp;
        TrackOutput[] trackOutputArr = this.emsgTrackOutputs;
        if (trackOutputArr == null || trackOutputArr.length == 0) {
            return;
        }
        atom.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(atom.readInt());
        if (fullAtomVersion == 0) {
            String str3 = (String) Assertions.checkNotNull(atom.readNullTerminatedString());
            String str4 = (String) Assertions.checkNotNull(atom.readNullTerminatedString());
            long unsignedInt2 = atom.readUnsignedInt();
            jScaleLargeTimestamp = Util.scaleLargeTimestamp(atom.readUnsignedInt(), 1000000L, unsignedInt2);
            long j = this.segmentIndexEarliestPresentationTimeUs;
            long j2 = j != -9223372036854775807L ? j + jScaleLargeTimestamp : -9223372036854775807L;
            str = str3;
            jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(atom.readUnsignedInt(), 1000L, unsignedInt2);
            str2 = str4;
            unsignedInt = atom.readUnsignedInt();
            jAdjustSampleTimestamp = j2;
        } else {
            if (fullAtomVersion != 1) {
                Log.w("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + fullAtomVersion);
                return;
            }
            long unsignedInt3 = atom.readUnsignedInt();
            jAdjustSampleTimestamp = Util.scaleLargeTimestamp(atom.readUnsignedLongToLong(), 1000000L, unsignedInt3);
            long jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(atom.readUnsignedInt(), 1000L, unsignedInt3);
            long unsignedInt4 = atom.readUnsignedInt();
            str = (String) Assertions.checkNotNull(atom.readNullTerminatedString());
            jScaleLargeTimestamp2 = jScaleLargeTimestamp3;
            unsignedInt = unsignedInt4;
            str2 = (String) Assertions.checkNotNull(atom.readNullTerminatedString());
            jScaleLargeTimestamp = -9223372036854775807L;
        }
        byte[] bArr = new byte[atom.bytesLeft()];
        atom.readBytes(bArr, 0, atom.bytesLeft());
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.eventMessageEncoder.encode(new EventMessage(str, str2, jScaleLargeTimestamp2, unsignedInt, bArr)));
        int iBytesLeft = parsableByteArray.bytesLeft();
        for (TrackOutput trackOutput : this.emsgTrackOutputs) {
            parsableByteArray.setPosition(0);
            trackOutput.sampleData(parsableByteArray, iBytesLeft);
        }
        if (jAdjustSampleTimestamp == -9223372036854775807L) {
            this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(jScaleLargeTimestamp, iBytesLeft));
            this.pendingMetadataSampleBytes += iBytesLeft;
            return;
        }
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster != null) {
            jAdjustSampleTimestamp = timestampAdjuster.adjustSampleTimestamp(jAdjustSampleTimestamp);
        }
        for (TrackOutput trackOutput2 : this.emsgTrackOutputs) {
            trackOutput2.sampleMetadata(jAdjustSampleTimestamp, 1, iBytesLeft, 0, null);
        }
    }

    private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray trex) {
        trex.setPosition(12);
        return Pair.create(Integer.valueOf(trex.readInt()), new DefaultSampleValues(trex.readInt() - 1, trex.readInt(), trex.readInt(), trex.readInt()));
    }

    private static long parseMehd(ParsableByteArray mehd) {
        mehd.setPosition(8);
        return Atom.parseFullAtomVersion(mehd.readInt()) == 0 ? mehd.readUnsignedInt() : mehd.readUnsignedLongToLong();
    }

    private static void parseMoof(Atom.ContainerAtom moof, SparseArray<TrackBundle> trackBundleArray, int flags, byte[] extendedTypeScratch) throws ParserException {
        int size = moof.containerChildren.size();
        for (int i = 0; i < size; i++) {
            Atom.ContainerAtom containerAtom = moof.containerChildren.get(i);
            if (containerAtom.type == 1953653094) {
                parseTraf(containerAtom, trackBundleArray, flags, extendedTypeScratch);
            }
        }
    }

    private static void parseTraf(Atom.ContainerAtom traf, SparseArray<TrackBundle> trackBundleArray, int flags, byte[] extendedTypeScratch) throws ParserException {
        TrackBundle tfhd = parseTfhd(traf.getLeafAtomOfType(1952868452).data, trackBundleArray);
        if (tfhd == null) {
            return;
        }
        TrackFragment trackFragment = tfhd.fragment;
        long tfdt = trackFragment.nextFragmentDecodeTime;
        tfhd.reset();
        if (traf.getLeafAtomOfType(1952867444) != null && (flags & 2) == 0) {
            tfdt = parseTfdt(traf.getLeafAtomOfType(1952867444).data);
        }
        parseTruns(traf, tfhd, tfdt, flags);
        TrackEncryptionBox sampleDescriptionEncryptionBox = tfhd.track.getSampleDescriptionEncryptionBox(trackFragment.header.sampleDescriptionIndex);
        Atom.LeafAtom leafAtomOfType = traf.getLeafAtomOfType(1935763834);
        if (leafAtomOfType != null) {
            parseSaiz(sampleDescriptionEncryptionBox, leafAtomOfType.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType2 = traf.getLeafAtomOfType(1935763823);
        if (leafAtomOfType2 != null) {
            parseSaio(leafAtomOfType2.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType3 = traf.getLeafAtomOfType(1936027235);
        if (leafAtomOfType3 != null) {
            parseSenc(leafAtomOfType3.data, trackFragment);
        }
        Atom.LeafAtom leafAtomOfType4 = traf.getLeafAtomOfType(1935828848);
        Atom.LeafAtom leafAtomOfType5 = traf.getLeafAtomOfType(1936158820);
        if (leafAtomOfType4 != null && leafAtomOfType5 != null) {
            parseSgpd(leafAtomOfType4.data, leafAtomOfType5.data, sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null, trackFragment);
        }
        int size = traf.leafChildren.size();
        for (int i = 0; i < size; i++) {
            Atom.LeafAtom leafAtom = traf.leafChildren.get(i);
            if (leafAtom.type == 1970628964) {
                parseUuid(leafAtom.data, trackFragment, extendedTypeScratch);
            }
        }
    }

    private static void parseTruns(Atom.ContainerAtom traf, TrackBundle trackBundle, long decodeTime, int flags) throws ParserException {
        List<Atom.LeafAtom> list = traf.leafChildren;
        int size = list.size();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Atom.LeafAtom leafAtom = list.get(i3);
            if (leafAtom.type == 1953658222) {
                ParsableByteArray parsableByteArray = leafAtom.data;
                parsableByteArray.setPosition(12);
                int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (unsignedIntToInt > 0) {
                    i2 += unsignedIntToInt;
                    i++;
                }
            }
        }
        trackBundle.currentTrackRunIndex = 0;
        trackBundle.currentSampleInTrackRun = 0;
        trackBundle.currentSampleIndex = 0;
        trackBundle.fragment.initTables(i, i2);
        int i4 = 0;
        int trun = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Atom.LeafAtom leafAtom2 = list.get(i5);
            if (leafAtom2.type == 1953658222) {
                trun = parseTrun(trackBundle, i4, decodeTime, flags, leafAtom2.data, trun);
                i4++;
            }
        }
    }

    private static void parseSaiz(TrackEncryptionBox encryptionBox, ParsableByteArray saiz, TrackFragment out) throws ParserException {
        int i;
        int i2 = encryptionBox.perSampleIvSize;
        saiz.setPosition(8);
        if ((Atom.parseFullAtomFlags(saiz.readInt()) & 1) == 1) {
            saiz.skipBytes(8);
        }
        int unsignedByte = saiz.readUnsignedByte();
        int unsignedIntToInt = saiz.readUnsignedIntToInt();
        if (unsignedIntToInt != out.sampleCount) {
            throw new ParserException("Length mismatch: " + unsignedIntToInt + ", " + out.sampleCount);
        }
        if (unsignedByte == 0) {
            boolean[] zArr = out.sampleHasSubsampleEncryptionTable;
            i = 0;
            for (int i3 = 0; i3 < unsignedIntToInt; i3++) {
                int unsignedByte2 = saiz.readUnsignedByte();
                i += unsignedByte2;
                zArr[i3] = unsignedByte2 > i2;
            }
        } else {
            i = unsignedByte * unsignedIntToInt;
            Arrays.fill(out.sampleHasSubsampleEncryptionTable, 0, unsignedIntToInt, unsignedByte > i2);
        }
        out.initEncryptionData(i);
    }

    private static void parseSaio(ParsableByteArray saio, TrackFragment out) throws ParserException {
        saio.setPosition(8);
        int i = saio.readInt();
        if ((Atom.parseFullAtomFlags(i) & 1) == 1) {
            saio.skipBytes(8);
        }
        int unsignedIntToInt = saio.readUnsignedIntToInt();
        if (unsignedIntToInt != 1) {
            throw new ParserException("Unexpected saio entry count: " + unsignedIntToInt);
        }
        out.auxiliaryDataPosition += Atom.parseFullAtomVersion(i) == 0 ? saio.readUnsignedInt() : saio.readUnsignedLongToLong();
    }

    private static TrackBundle parseTfhd(ParsableByteArray tfhd, SparseArray<TrackBundle> trackBundles) {
        tfhd.setPosition(8);
        int fullAtomFlags = Atom.parseFullAtomFlags(tfhd.readInt());
        TrackBundle trackBundle = getTrackBundle(trackBundles, tfhd.readInt());
        if (trackBundle == null) {
            return null;
        }
        if ((fullAtomFlags & 1) != 0) {
            long unsignedLongToLong = tfhd.readUnsignedLongToLong();
            TrackFragment trackFragment = trackBundle.fragment;
            trackFragment.dataPosition = unsignedLongToLong;
            trackFragment.auxiliaryDataPosition = unsignedLongToLong;
        }
        DefaultSampleValues defaultSampleValues = trackBundle.defaultSampleValues;
        trackBundle.fragment.header = new DefaultSampleValues((fullAtomFlags & 2) != 0 ? tfhd.readInt() - 1 : defaultSampleValues.sampleDescriptionIndex, (fullAtomFlags & 8) != 0 ? tfhd.readInt() : defaultSampleValues.duration, (fullAtomFlags & 16) != 0 ? tfhd.readInt() : defaultSampleValues.size, (fullAtomFlags & 32) != 0 ? tfhd.readInt() : defaultSampleValues.flags);
        return trackBundle;
    }

    private static TrackBundle getTrackBundle(SparseArray<TrackBundle> trackBundles, int trackId) {
        if (trackBundles.size() == 1) {
            return trackBundles.valueAt(0);
        }
        return trackBundles.get(trackId);
    }

    private static long parseTfdt(ParsableByteArray tfdt) {
        tfdt.setPosition(8);
        return Atom.parseFullAtomVersion(tfdt.readInt()) == 1 ? tfdt.readUnsignedLongToLong() : tfdt.readUnsignedInt();
    }

    private static int parseTrun(TrackBundle trackBundle, int index, long decodeTime, int flags, ParsableByteArray trun, int trackRunStart) throws ParserException {
        boolean z;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        trun.setPosition(8);
        int fullAtomFlags = Atom.parseFullAtomFlags(trun.readInt());
        Track track = trackBundle.track;
        TrackFragment trackFragment = trackBundle.fragment;
        DefaultSampleValues defaultSampleValues = trackFragment.header;
        trackFragment.trunLength[index] = trun.readUnsignedIntToInt();
        long[] jArr = trackFragment.trunDataPosition;
        long j = trackFragment.dataPosition;
        jArr[index] = j;
        if ((fullAtomFlags & 1) != 0) {
            jArr[index] = j + trun.readInt();
        }
        boolean z7 = (fullAtomFlags & 4) != 0;
        int i3 = defaultSampleValues.flags;
        if (z7) {
            i3 = trun.readInt();
        }
        boolean z8 = (fullAtomFlags & 256) != 0;
        boolean z9 = (fullAtomFlags & 512) != 0;
        boolean z10 = (fullAtomFlags & 1024) != 0;
        boolean z11 = (fullAtomFlags & 2048) != 0;
        long[] jArr2 = track.editListDurations;
        long jScaleLargeTimestamp = 0;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            jScaleLargeTimestamp = Util.scaleLargeTimestamp(track.editListMediaTimes[0], 1000L, track.timescale);
        }
        int[] iArr = trackFragment.sampleSizeTable;
        int[] iArr2 = trackFragment.sampleCompositionTimeOffsetTable;
        long[] jArr3 = trackFragment.sampleDecodingTimeTable;
        boolean[] zArr = trackFragment.sampleIsSyncFrameTable;
        int i4 = i3;
        boolean z12 = track.type == 2 && (flags & 1) != 0;
        int i5 = trackRunStart + trackFragment.trunLength[index];
        long j2 = track.timescale;
        long j3 = jScaleLargeTimestamp;
        long j4 = index > 0 ? trackFragment.nextFragmentDecodeTime : decodeTime;
        int i6 = trackRunStart;
        while (i6 < i5) {
            int iCheckNonNegative = checkNonNegative(z8 ? trun.readInt() : defaultSampleValues.duration);
            if (z9) {
                i = trun.readInt();
                z = z8;
            } else {
                z = z8;
                i = defaultSampleValues.size;
            }
            int iCheckNonNegative2 = checkNonNegative(i);
            if (i6 == 0 && z7) {
                z2 = z7;
                i2 = i4;
            } else if (z10) {
                z2 = z7;
                i2 = trun.readInt();
            } else {
                z2 = z7;
                i2 = defaultSampleValues.flags;
            }
            if (z11) {
                z3 = z11;
                z4 = z9;
                z5 = z10;
                iArr2[i6] = (int) ((trun.readInt() * 1000) / j2);
                z6 = false;
            } else {
                z3 = z11;
                z4 = z9;
                z5 = z10;
                z6 = false;
                iArr2[i6] = 0;
            }
            jArr3[i6] = Util.scaleLargeTimestamp(j4, 1000L, j2) - j3;
            iArr[i6] = iCheckNonNegative2;
            zArr[i6] = (((i2 >> 16) & 1) != 0 || (z12 && i6 != 0)) ? z6 : true;
            i6++;
            j4 += iCheckNonNegative;
            j2 = j2;
            z8 = z;
            z7 = z2;
            z11 = z3;
            z9 = z4;
            z10 = z5;
        }
        trackFragment.nextFragmentDecodeTime = j4;
        return i5;
    }

    private static int checkNonNegative(int value) throws ParserException {
        if (value >= 0) {
            return value;
        }
        throw new ParserException("Unexpected negtive value: " + value);
    }

    private static void parseUuid(ParsableByteArray uuid, TrackFragment out, byte[] extendedTypeScratch) throws ParserException {
        uuid.setPosition(8);
        uuid.readBytes(extendedTypeScratch, 0, 16);
        if (Arrays.equals(extendedTypeScratch, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            parseSenc(uuid, 16, out);
        }
    }

    private static void parseSenc(ParsableByteArray senc, TrackFragment out) throws ParserException {
        parseSenc(senc, 0, out);
    }

    private static void parseSenc(ParsableByteArray senc, int offset, TrackFragment out) throws ParserException {
        senc.setPosition(offset + 8);
        int fullAtomFlags = Atom.parseFullAtomFlags(senc.readInt());
        if ((fullAtomFlags & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (fullAtomFlags & 2) != 0;
        int unsignedIntToInt = senc.readUnsignedIntToInt();
        if (unsignedIntToInt != out.sampleCount) {
            throw new ParserException("Length mismatch: " + unsignedIntToInt + ", " + out.sampleCount);
        }
        Arrays.fill(out.sampleHasSubsampleEncryptionTable, 0, unsignedIntToInt, z);
        out.initEncryptionData(senc.bytesLeft());
        out.fillEncryptionData(senc);
    }

    private static void parseSgpd(ParsableByteArray sbgp, ParsableByteArray sgpd, String schemeType, TrackFragment out) throws ParserException {
        byte[] bArr;
        sbgp.setPosition(8);
        int i = sbgp.readInt();
        if (sbgp.readInt() != 1936025959) {
            return;
        }
        if (Atom.parseFullAtomVersion(i) == 1) {
            sbgp.skipBytes(4);
        }
        if (sbgp.readInt() != 1) {
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
        sgpd.setPosition(8);
        int i2 = sgpd.readInt();
        if (sgpd.readInt() != 1936025959) {
            return;
        }
        int fullAtomVersion = Atom.parseFullAtomVersion(i2);
        if (fullAtomVersion == 1) {
            if (sgpd.readUnsignedInt() == 0) {
                throw new ParserException("Variable length description in sgpd found (unsupported)");
            }
        } else if (fullAtomVersion >= 2) {
            sgpd.skipBytes(4);
        }
        if (sgpd.readUnsignedInt() != 1) {
            throw new ParserException("Entry count in sgpd != 1 (unsupported).");
        }
        sgpd.skipBytes(1);
        int unsignedByte = sgpd.readUnsignedByte();
        int i3 = (unsignedByte & 240) >> 4;
        int i4 = unsignedByte & 15;
        boolean z = sgpd.readUnsignedByte() == 1;
        if (z) {
            int unsignedByte2 = sgpd.readUnsignedByte();
            byte[] bArr2 = new byte[16];
            sgpd.readBytes(bArr2, 0, 16);
            if (unsignedByte2 == 0) {
                int unsignedByte3 = sgpd.readUnsignedByte();
                byte[] bArr3 = new byte[unsignedByte3];
                sgpd.readBytes(bArr3, 0, unsignedByte3);
                bArr = bArr3;
            } else {
                bArr = null;
            }
            out.definesEncryptionData = true;
            out.trackEncryptionBox = new TrackEncryptionBox(z, schemeType, unsignedByte2, bArr2, i3, i4, bArr);
        }
    }

    private static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray atom, long inputPosition) throws ParserException {
        long unsignedLongToLong;
        long unsignedLongToLong2;
        atom.setPosition(8);
        int fullAtomVersion = Atom.parseFullAtomVersion(atom.readInt());
        atom.skipBytes(4);
        long unsignedInt = atom.readUnsignedInt();
        if (fullAtomVersion == 0) {
            unsignedLongToLong = atom.readUnsignedInt();
            unsignedLongToLong2 = atom.readUnsignedInt();
        } else {
            unsignedLongToLong = atom.readUnsignedLongToLong();
            unsignedLongToLong2 = atom.readUnsignedLongToLong();
        }
        long j = unsignedLongToLong;
        long j2 = inputPosition + unsignedLongToLong2;
        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000L, unsignedInt);
        atom.skipBytes(2);
        int unsignedShort = atom.readUnsignedShort();
        int[] iArr = new int[unsignedShort];
        long[] jArr = new long[unsignedShort];
        long[] jArr2 = new long[unsignedShort];
        long[] jArr3 = new long[unsignedShort];
        long j3 = jScaleLargeTimestamp;
        int i = 0;
        long j4 = j;
        while (i < unsignedShort) {
            int i2 = atom.readInt();
            if ((i2 & Integer.MIN_VALUE) != 0) {
                throw new ParserException("Unhandled indirect reference");
            }
            long unsignedInt2 = atom.readUnsignedInt();
            iArr[i] = i2 & Integer.MAX_VALUE;
            jArr[i] = j2;
            jArr3[i] = j3;
            long j5 = j4 + unsignedInt2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i3 = unsignedShort;
            long jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(j5, 1000000L, unsignedInt);
            jArr4[i] = jScaleLargeTimestamp2 - jArr5[i];
            atom.skipBytes(4);
            j2 += r1[i];
            i++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            unsignedShort = i3;
            j4 = j5;
            j3 = jScaleLargeTimestamp2;
        }
        return Pair.create(Long.valueOf(jScaleLargeTimestamp), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private void readEncryptionData(ExtractorInput input) throws IOException {
        int size = this.trackBundles.size();
        TrackBundle trackBundleValueAt = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            TrackFragment trackFragment = this.trackBundles.valueAt(i).fragment;
            if (trackFragment.sampleEncryptionDataNeedsFill) {
                long j2 = trackFragment.auxiliaryDataPosition;
                if (j2 < j) {
                    trackBundleValueAt = this.trackBundles.valueAt(i);
                    j = j2;
                }
            }
        }
        if (trackBundleValueAt == null) {
            this.parserState = 3;
            return;
        }
        int position = (int) (j - input.getPosition());
        if (position < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        input.skipFully(position);
        trackBundleValueAt.fragment.fillEncryptionData(input);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean readSample(ExtractorInput extractorInput) throws IOException {
        int i;
        TrackOutput.CryptoData cryptoData;
        int iSampleData;
        int i2 = 4;
        int i3 = 1;
        int i4 = 0;
        if (this.parserState == 3) {
            if (this.currentTrackBundle == null) {
                TrackBundle nextFragmentRun = getNextFragmentRun(this.trackBundles);
                if (nextFragmentRun == null) {
                    int position = (int) (this.endOfMdatPosition - extractorInput.getPosition());
                    if (position < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    extractorInput.skipFully(position);
                    enterReadingAtomHeaderState();
                    return false;
                }
                int position2 = (int) (nextFragmentRun.fragment.trunDataPosition[nextFragmentRun.currentTrackRunIndex] - extractorInput.getPosition());
                if (position2 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                extractorInput.skipFully(position2);
                this.currentTrackBundle = nextFragmentRun;
            }
            TrackBundle trackBundle = this.currentTrackBundle;
            int[] iArr = trackBundle.fragment.sampleSizeTable;
            int i5 = trackBundle.currentSampleIndex;
            int i6 = iArr[i5];
            this.sampleSize = i6;
            if (i5 < trackBundle.firstSampleToOutputIndex) {
                extractorInput.skipFully(i6);
                this.currentTrackBundle.skipSampleEncryptionData();
                if (!this.currentTrackBundle.next()) {
                    this.currentTrackBundle = null;
                }
                this.parserState = 3;
                return true;
            }
            if (trackBundle.track.sampleTransformation == 1) {
                this.sampleSize = i6 - 8;
                extractorInput.skipFully(8);
            }
            if ("audio/ac4".equals(this.currentTrackBundle.track.format.sampleMimeType)) {
                this.sampleBytesWritten = this.currentTrackBundle.outputSampleEncryptionData(this.sampleSize, 7);
                Ac4Util.getAc4SampleHeader(this.sampleSize, this.scratch);
                this.currentTrackBundle.output.sampleData(this.scratch, 7);
                this.sampleBytesWritten += 7;
            } else {
                this.sampleBytesWritten = this.currentTrackBundle.outputSampleEncryptionData(this.sampleSize, 0);
            }
            this.sampleSize += this.sampleBytesWritten;
            this.parserState = 4;
            this.sampleCurrentNalBytesRemaining = 0;
        }
        TrackBundle trackBundle2 = this.currentTrackBundle;
        TrackFragment trackFragment = trackBundle2.fragment;
        Track track = trackBundle2.track;
        TrackOutput trackOutput = trackBundle2.output;
        int i7 = trackBundle2.currentSampleIndex;
        long samplePresentationTime = trackFragment.getSamplePresentationTime(i7) * 1000;
        TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
        if (timestampAdjuster != null) {
            samplePresentationTime = timestampAdjuster.adjustSampleTimestamp(samplePresentationTime);
        }
        long j = samplePresentationTime;
        int i8 = track.nalUnitLengthFieldLength;
        if (i8 == 0) {
            while (true) {
                int i9 = this.sampleBytesWritten;
                int i10 = this.sampleSize;
                if (i9 >= i10) {
                    break;
                }
                this.sampleBytesWritten += trackOutput.sampleData(extractorInput, i10 - i9, false);
            }
        } else {
            byte[] bArr = this.nalPrefix.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i11 = i8 + 1;
            int i12 = 4 - i8;
            while (this.sampleBytesWritten < this.sampleSize) {
                int i13 = this.sampleCurrentNalBytesRemaining;
                if (i13 == 0) {
                    extractorInput.readFully(bArr, i12, i11);
                    this.nalPrefix.setPosition(i4);
                    int i14 = this.nalPrefix.readInt();
                    if (i14 < i3) {
                        throw new ParserException("Invalid NAL length");
                    }
                    this.sampleCurrentNalBytesRemaining = i14 - 1;
                    this.nalStartCode.setPosition(i4);
                    trackOutput.sampleData(this.nalStartCode, i2);
                    trackOutput.sampleData(this.nalPrefix, i3);
                    this.processSeiNalUnitPayload = (this.cea608TrackOutputs.length <= 0 || !NalUnitUtil.isNalUnitSei(track.format.sampleMimeType, bArr[i2])) ? i4 : i3;
                    this.sampleBytesWritten += 5;
                    this.sampleSize += i12;
                } else {
                    if (this.processSeiNalUnitPayload) {
                        this.nalBuffer.reset(i13);
                        extractorInput.readFully(this.nalBuffer.data, i4, this.sampleCurrentNalBytesRemaining);
                        trackOutput.sampleData(this.nalBuffer, this.sampleCurrentNalBytesRemaining);
                        iSampleData = this.sampleCurrentNalBytesRemaining;
                        ParsableByteArray parsableByteArray = this.nalBuffer;
                        int iUnescapeStream = NalUnitUtil.unescapeStream(parsableByteArray.data, parsableByteArray.limit());
                        this.nalBuffer.setPosition("video/hevc".equals(track.format.sampleMimeType) ? 1 : 0);
                        this.nalBuffer.setLimit(iUnescapeStream);
                        CeaUtil.consume(j, this.nalBuffer, this.cea608TrackOutputs);
                    } else {
                        iSampleData = trackOutput.sampleData(extractorInput, i13, i4);
                    }
                    this.sampleBytesWritten += iSampleData;
                    this.sampleCurrentNalBytesRemaining -= iSampleData;
                    i2 = 4;
                    i3 = 1;
                    i4 = 0;
                }
            }
        }
        boolean z = trackFragment.sampleIsSyncFrameTable[i7];
        TrackEncryptionBox encryptionBoxIfEncrypted = this.currentTrackBundle.getEncryptionBoxIfEncrypted();
        if (encryptionBoxIfEncrypted != null) {
            i = (z ? 1 : 0) | pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH;
            cryptoData = encryptionBoxIfEncrypted.cryptoData;
        } else {
            i = z ? 1 : 0;
            cryptoData = null;
        }
        trackOutput.sampleMetadata(j, i, this.sampleSize, 0, cryptoData);
        outputPendingMetadataSamples(j);
        if (!this.currentTrackBundle.next()) {
            this.currentTrackBundle = null;
        }
        this.parserState = 3;
        return true;
    }

    private void outputPendingMetadataSamples(long sampleTimeUs) {
        while (!this.pendingMetadataSampleInfos.isEmpty()) {
            MetadataSampleInfo metadataSampleInfoRemoveFirst = this.pendingMetadataSampleInfos.removeFirst();
            this.pendingMetadataSampleBytes -= metadataSampleInfoRemoveFirst.size;
            long jAdjustSampleTimestamp = metadataSampleInfoRemoveFirst.presentationTimeDeltaUs + sampleTimeUs;
            TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
            if (timestampAdjuster != null) {
                jAdjustSampleTimestamp = timestampAdjuster.adjustSampleTimestamp(jAdjustSampleTimestamp);
            }
            for (TrackOutput trackOutput : this.emsgTrackOutputs) {
                trackOutput.sampleMetadata(jAdjustSampleTimestamp, 1, metadataSampleInfoRemoveFirst.size, this.pendingMetadataSampleBytes, null);
            }
        }
    }

    private static TrackBundle getNextFragmentRun(SparseArray<TrackBundle> trackBundles) {
        int size = trackBundles.size();
        TrackBundle trackBundle = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            TrackBundle trackBundleValueAt = trackBundles.valueAt(i);
            int i2 = trackBundleValueAt.currentTrackRunIndex;
            TrackFragment trackFragment = trackBundleValueAt.fragment;
            if (i2 != trackFragment.trunCount) {
                long j2 = trackFragment.trunDataPosition[i2];
                if (j2 < j) {
                    trackBundle = trackBundleValueAt;
                    j = j2;
                }
            }
        }
        return trackBundle;
    }

    private static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> leafChildren) {
        int size = leafChildren.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Atom.LeafAtom leafAtom = leafChildren.get(i);
            if (leafAtom.type == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = leafAtom.data.data;
                UUID uuid = PsshAtomUtil.parseUuid(bArr);
                if (uuid == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuid, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static final class MetadataSampleInfo {
        public final long presentationTimeDeltaUs;
        public final int size;

        public MetadataSampleInfo(long presentationTimeDeltaUs, int size) {
            this.presentationTimeDeltaUs = presentationTimeDeltaUs;
            this.size = size;
        }
    }

    private static final class TrackBundle {
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        public DefaultSampleValues defaultSampleValues;
        public int firstSampleToOutputIndex;
        public final TrackOutput output;
        public Track track;
        public final TrackFragment fragment = new TrackFragment();
        public final ParsableByteArray scratch = new ParsableByteArray();
        private final ParsableByteArray encryptionSignalByte = new ParsableByteArray(1);
        private final ParsableByteArray defaultInitializationVector = new ParsableByteArray();

        public TrackBundle(TrackOutput output) {
            this.output = output;
        }

        public void init(Track track, DefaultSampleValues defaultSampleValues) {
            this.track = (Track) Assertions.checkNotNull(track);
            this.defaultSampleValues = (DefaultSampleValues) Assertions.checkNotNull(defaultSampleValues);
            this.output.format(track.format);
            reset();
        }

        public void updateDrmInitData(DrmInitData drmInitData) {
            TrackEncryptionBox sampleDescriptionEncryptionBox = this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex);
            this.output.format(this.track.format.buildUpon().setDrmInitData(drmInitData.copyWithSchemeType(sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null)).build());
        }

        public void reset() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
            this.firstSampleToOutputIndex = 0;
        }

        public void seek(long timeUs) {
            long jUsToMs = C.usToMs(timeUs);
            int i = this.currentSampleIndex;
            while (true) {
                TrackFragment trackFragment = this.fragment;
                if (i >= trackFragment.sampleCount || trackFragment.getSamplePresentationTime(i) >= jUsToMs) {
                    return;
                }
                if (this.fragment.sampleIsSyncFrameTable[i]) {
                    this.firstSampleToOutputIndex = i;
                }
                i++;
            }
        }

        public boolean next() {
            this.currentSampleIndex++;
            int i = this.currentSampleInTrackRun + 1;
            this.currentSampleInTrackRun = i;
            int[] iArr = this.fragment.trunLength;
            int i2 = this.currentTrackRunIndex;
            if (i != iArr[i2]) {
                return true;
            }
            this.currentTrackRunIndex = i2 + 1;
            this.currentSampleInTrackRun = 0;
            return false;
        }

        public int outputSampleEncryptionData(int sampleSize, int clearHeaderSize) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return 0;
            }
            int length = encryptionBoxIfEncrypted.perSampleIvSize;
            if (length != 0) {
                parsableByteArray = this.fragment.sampleEncryptionData;
            } else {
                byte[] bArr = encryptionBoxIfEncrypted.defaultInitializationVector;
                this.defaultInitializationVector.reset(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.defaultInitializationVector;
                length = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean zSampleHasSubsampleEncryptionTable = this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex);
            boolean z = zSampleHasSubsampleEncryptionTable || clearHeaderSize != 0;
            ParsableByteArray parsableByteArray3 = this.encryptionSignalByte;
            parsableByteArray3.data[0] = (byte) ((z ? 128 : 0) | length);
            parsableByteArray3.setPosition(0);
            this.output.sampleData(this.encryptionSignalByte, 1);
            this.output.sampleData(parsableByteArray, length);
            if (!z) {
                return length + 1;
            }
            if (!zSampleHasSubsampleEncryptionTable) {
                this.scratch.reset(8);
                ParsableByteArray parsableByteArray4 = this.scratch;
                byte[] bArr2 = parsableByteArray4.data;
                bArr2[0] = 0;
                bArr2[1] = 1;
                bArr2[2] = (byte) ((clearHeaderSize >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr2[3] = (byte) (clearHeaderSize & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr2[4] = (byte) ((sampleSize >> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr2[5] = (byte) ((sampleSize >> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr2[6] = (byte) ((sampleSize >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr2[7] = (byte) (sampleSize & KotlinVersion.MAX_COMPONENT_VALUE);
                this.output.sampleData(parsableByteArray4, 8);
                return length + 9;
            }
            ParsableByteArray parsableByteArray5 = this.fragment.sampleEncryptionData;
            int unsignedShort = parsableByteArray5.readUnsignedShort();
            parsableByteArray5.skipBytes(-2);
            int i = (unsignedShort * 6) + 2;
            if (clearHeaderSize != 0) {
                this.scratch.reset(i);
                this.scratch.readBytes(parsableByteArray5.data, 0, i);
                parsableByteArray5.skipBytes(i);
                parsableByteArray5 = this.scratch;
                byte[] bArr3 = parsableByteArray5.data;
                int i2 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + clearHeaderSize;
                bArr3[2] = (byte) ((i2 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr3[3] = (byte) (i2 & KotlinVersion.MAX_COMPONENT_VALUE);
            }
            this.output.sampleData(parsableByteArray5, i);
            return length + 1 + i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void skipSampleEncryptionData() {
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return;
            }
            ParsableByteArray parsableByteArray = this.fragment.sampleEncryptionData;
            int i = encryptionBoxIfEncrypted.perSampleIvSize;
            if (i != 0) {
                parsableByteArray.skipBytes(i);
            }
            if (this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex)) {
                parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort() * 6);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public TrackEncryptionBox getEncryptionBoxIfEncrypted() {
            TrackFragment trackFragment = this.fragment;
            int i = trackFragment.header.sampleDescriptionIndex;
            TrackEncryptionBox sampleDescriptionEncryptionBox = trackFragment.trackEncryptionBox;
            if (sampleDescriptionEncryptionBox == null) {
                sampleDescriptionEncryptionBox = this.track.getSampleDescriptionEncryptionBox(i);
            }
            if (sampleDescriptionEncryptionBox == null || !sampleDescriptionEncryptionBox.isEncrypted) {
                return null;
            }
            return sampleDescriptionEncryptionBox;
        }
    }
}
