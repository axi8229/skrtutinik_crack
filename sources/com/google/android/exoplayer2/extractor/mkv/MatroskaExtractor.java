package com.google.android.exoplayer2.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.KotlinVersion;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;
import org.pjsip.pjsua2.pjsip_status_code;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* loaded from: classes2.dex */
public class MatroskaExtractor implements Extractor {
    private final ParsableByteArray blockAdditionalData;
    private int blockAdditionalId;
    private long blockDurationUs;
    private int blockFlags;
    private boolean blockHasReferenceBlock;
    private int blockSampleCount;
    private int blockSampleIndex;
    private int[] blockSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private boolean haveOutputSample;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return MatroskaExtractor.lambda$static$0();
        }
    };
    private static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);

    protected int getElementType(int id) {
        switch (id) {
            case pjsip_transport_type_e.PJSIP_TRANSPORT_TLS6 /* 131 */:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case pjsip_status_code.PJSIP_SC_PROGRESS /* 183 */:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case pjsip_status_code.PJSIP_SC_CALL_BEING_FORWARDED /* 181 */:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected boolean isLevel1Element(int id) {
        return id == 357149030 || id == 524531317 || id == 475249515 || id == 374648427;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new MatroskaExtractor()};
    }

    public MatroskaExtractor() {
        this(0);
    }

    public MatroskaExtractor(int flags) {
        this(new DefaultEbmlReader(), flags);
    }

    MatroskaExtractor(EbmlReader reader, int flags) {
        this.segmentContentPosition = -1L;
        this.timecodeScale = -9223372036854775807L;
        this.durationTimecode = -9223372036854775807L;
        this.durationUs = -9223372036854775807L;
        this.cuesContentPosition = -1L;
        this.seekPositionAfterBuildingCues = -1L;
        this.clusterTimecodeUs = -9223372036854775807L;
        this.reader = reader;
        reader.init(new InnerEbmlProcessor());
        this.seekForCuesEnabled = (flags & 1) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
        this.blockAdditionalData = new ParsableByteArray();
        this.blockSampleSizes = new int[1];
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final boolean sniff(ExtractorInput input) throws IOException {
        return new Sniffer().sniff(input);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final void init(ExtractorOutput output) {
        this.extractorOutput = output;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long position, long timeUs) {
        this.clusterTimecodeUs = -9223372036854775807L;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetWriteSampleData();
        for (int i = 0; i < this.tracks.size(); i++) {
            this.tracks.valueAt(i).reset();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public final int read(ExtractorInput input, PositionHolder seekPosition) throws IOException {
        this.haveOutputSample = false;
        boolean z = true;
        while (z && !this.haveOutputSample) {
            z = this.reader.read(input);
            if (z && maybeSeekForCues(seekPosition, input.getPosition())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.tracks.size(); i++) {
            this.tracks.valueAt(i).outputPendingSampleMetadata();
        }
        return -1;
    }

    protected void startMasterElement(int id, long contentPosition, long contentSize) throws ParserException {
        if (id == 160) {
            this.blockHasReferenceBlock = false;
            return;
        }
        if (id == 174) {
            this.currentTrack = new Track();
            return;
        }
        if (id == 187) {
            this.seenClusterPositionForCurrentCuePoint = false;
            return;
        }
        if (id == 19899) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1L;
            return;
        }
        if (id == 20533) {
            this.currentTrack.hasContentEncryption = true;
            return;
        }
        if (id == 21968) {
            this.currentTrack.hasColorInfo = true;
            return;
        }
        if (id == 408125543) {
            long j = this.segmentContentPosition;
            if (j != -1 && j != contentPosition) {
                throw new ParserException("Multiple Segment elements not supported");
            }
            this.segmentContentPosition = contentPosition;
            this.segmentContentSize = contentSize;
            return;
        }
        if (id == 475249515) {
            this.cueTimesUs = new LongArray();
            this.cueClusterPositions = new LongArray();
        } else if (id == 524531317 && !this.sentSeekMap) {
            if (this.seekForCuesEnabled && this.cuesContentPosition != -1) {
                this.seekForCues = true;
            } else {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.sentSeekMap = true;
            }
        }
    }

    protected void endMasterElement(int id) throws ParserException {
        if (id == 160) {
            if (this.blockState != 2) {
                return;
            }
            int i = 0;
            for (int i2 = 0; i2 < this.blockSampleCount; i2++) {
                i += this.blockSampleSizes[i2];
            }
            Track track = this.tracks.get(this.blockTrackNumber);
            for (int i3 = 0; i3 < this.blockSampleCount; i3++) {
                long j = ((track.defaultSampleDurationNs * i3) / 1000) + this.blockTimeUs;
                int i4 = this.blockFlags;
                if (i3 == 0 && !this.blockHasReferenceBlock) {
                    i4 |= 1;
                }
                int i5 = this.blockSampleSizes[i3];
                i -= i5;
                commitSampleToOutput(track, j, i4, i5, i);
            }
            this.blockState = 0;
            return;
        }
        if (id == 174) {
            if (isCodecSupported(this.currentTrack.codecId)) {
                Track track2 = this.currentTrack;
                track2.initializeOutput(this.extractorOutput, track2.number);
                SparseArray<Track> sparseArray = this.tracks;
                Track track3 = this.currentTrack;
                sparseArray.put(track3.number, track3);
            }
            this.currentTrack = null;
            return;
        }
        if (id == 19899) {
            int i6 = this.seekEntryId;
            if (i6 != -1) {
                long j2 = this.seekEntryPosition;
                if (j2 != -1) {
                    if (i6 == 475249515) {
                        this.cuesContentPosition = j2;
                        return;
                    }
                    return;
                }
            }
            throw new ParserException("Mandatory element SeekID or SeekPosition not found");
        }
        if (id == 25152) {
            Track track4 = this.currentTrack;
            if (track4.hasContentEncryption) {
                if (track4.cryptoData == null) {
                    throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                }
                track4.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, "video/webm", this.currentTrack.cryptoData.encryptionKey));
                return;
            }
            return;
        }
        if (id == 28032) {
            Track track5 = this.currentTrack;
            if (track5.hasContentEncryption && track5.sampleStrippedBytes != null) {
                throw new ParserException("Combining encryption and compression is not supported");
            }
            return;
        }
        if (id == 357149030) {
            if (this.timecodeScale == -9223372036854775807L) {
                this.timecodeScale = 1000000L;
            }
            long j3 = this.durationTimecode;
            if (j3 != -9223372036854775807L) {
                this.durationUs = scaleTimecodeToUs(j3);
                return;
            }
            return;
        }
        if (id != 374648427) {
            if (id == 475249515 && !this.sentSeekMap) {
                this.extractorOutput.seekMap(buildSeekMap());
                this.sentSeekMap = true;
                return;
            }
            return;
        }
        if (this.tracks.size() == 0) {
            throw new ParserException("No valid tracks were found");
        }
        this.extractorOutput.endTracks();
    }

    protected void integerElement(int id, long value) throws ParserException {
        if (id == 20529) {
            if (value == 0) {
                return;
            }
            throw new ParserException("ContentEncodingOrder " + value + " not supported");
        }
        if (id == 20530) {
            if (value == 1) {
                return;
            }
            throw new ParserException("ContentEncodingScope " + value + " not supported");
        }
        switch (id) {
            case pjsip_transport_type_e.PJSIP_TRANSPORT_TLS6 /* 131 */:
                this.currentTrack.type = (int) value;
                return;
            case 136:
                this.currentTrack.flagDefault = value == 1;
                return;
            case 155:
                this.blockDurationUs = scaleTimecodeToUs(value);
                return;
            case 159:
                this.currentTrack.channelCount = (int) value;
                return;
            case 176:
                this.currentTrack.width = (int) value;
                return;
            case 179:
                this.cueTimesUs.add(scaleTimecodeToUs(value));
                return;
            case 186:
                this.currentTrack.height = (int) value;
                return;
            case 215:
                this.currentTrack.number = (int) value;
                return;
            case 231:
                this.clusterTimecodeUs = scaleTimecodeToUs(value);
                return;
            case 238:
                this.blockAdditionalId = (int) value;
                return;
            case 241:
                if (this.seenClusterPositionForCurrentCuePoint) {
                    return;
                }
                this.cueClusterPositions.add(value);
                this.seenClusterPositionForCurrentCuePoint = true;
                return;
            case 251:
                this.blockHasReferenceBlock = true;
                return;
            case 16980:
                if (value == 3) {
                    return;
                }
                throw new ParserException("ContentCompAlgo " + value + " not supported");
            case 17029:
                if (value < 1 || value > 2) {
                    throw new ParserException("DocTypeReadVersion " + value + " not supported");
                }
                return;
            case 17143:
                if (value == 1) {
                    return;
                }
                throw new ParserException("EBMLReadVersion " + value + " not supported");
            case 18401:
                if (value == 5) {
                    return;
                }
                throw new ParserException("ContentEncAlgo " + value + " not supported");
            case 18408:
                if (value == 1) {
                    return;
                }
                throw new ParserException("AESSettingsCipherMode " + value + " not supported");
            case 21420:
                this.seekEntryPosition = value + this.segmentContentPosition;
                return;
            case 21432:
                int i = (int) value;
                if (i == 0) {
                    this.currentTrack.stereoMode = 0;
                    return;
                }
                if (i == 1) {
                    this.currentTrack.stereoMode = 2;
                    return;
                } else if (i == 3) {
                    this.currentTrack.stereoMode = 1;
                    return;
                } else {
                    if (i != 15) {
                        return;
                    }
                    this.currentTrack.stereoMode = 3;
                    return;
                }
            case 21680:
                this.currentTrack.displayWidth = (int) value;
                return;
            case 21682:
                this.currentTrack.displayUnit = (int) value;
                return;
            case 21690:
                this.currentTrack.displayHeight = (int) value;
                return;
            case 21930:
                this.currentTrack.flagForced = value == 1;
                return;
            case 21998:
                this.currentTrack.maxBlockAdditionId = (int) value;
                return;
            case 22186:
                this.currentTrack.codecDelayNs = value;
                return;
            case 22203:
                this.currentTrack.seekPreRollNs = value;
                return;
            case 25188:
                this.currentTrack.audioBitDepth = (int) value;
                return;
            case 30321:
                int i2 = (int) value;
                if (i2 == 0) {
                    this.currentTrack.projectionType = 0;
                    return;
                }
                if (i2 == 1) {
                    this.currentTrack.projectionType = 1;
                    return;
                } else if (i2 == 2) {
                    this.currentTrack.projectionType = 2;
                    return;
                } else {
                    if (i2 != 3) {
                        return;
                    }
                    this.currentTrack.projectionType = 3;
                    return;
                }
            case 2352003:
                this.currentTrack.defaultSampleDurationNs = (int) value;
                return;
            case 2807729:
                this.timecodeScale = value;
                return;
            default:
                switch (id) {
                    case 21945:
                        int i3 = (int) value;
                        if (i3 == 1) {
                            this.currentTrack.colorRange = 2;
                            return;
                        } else {
                            if (i3 != 2) {
                                return;
                            }
                            this.currentTrack.colorRange = 1;
                            return;
                        }
                    case 21946:
                        int i4 = (int) value;
                        if (i4 != 1) {
                            if (i4 == 16) {
                                this.currentTrack.colorTransfer = 6;
                                return;
                            } else if (i4 == 18) {
                                this.currentTrack.colorTransfer = 7;
                                return;
                            } else if (i4 != 6 && i4 != 7) {
                                return;
                            }
                        }
                        this.currentTrack.colorTransfer = 3;
                        return;
                    case 21947:
                        Track track = this.currentTrack;
                        track.hasColorInfo = true;
                        int i5 = (int) value;
                        if (i5 == 1) {
                            track.colorSpace = 1;
                            return;
                        }
                        if (i5 == 9) {
                            track.colorSpace = 6;
                            return;
                        } else {
                            if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                track.colorSpace = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.currentTrack.maxContentLuminance = (int) value;
                        return;
                    case 21949:
                        this.currentTrack.maxFrameAverageLuminance = (int) value;
                        return;
                    default:
                        return;
                }
        }
    }

    protected void floatElement(int id, double value) {
        if (id == 181) {
            this.currentTrack.sampleRate = (int) value;
        }
        if (id == 17545) {
            this.durationTimecode = (long) value;
            return;
        }
        switch (id) {
            case 21969:
                this.currentTrack.primaryRChromaticityX = (float) value;
                break;
            case 21970:
                this.currentTrack.primaryRChromaticityY = (float) value;
                break;
            case 21971:
                this.currentTrack.primaryGChromaticityX = (float) value;
                break;
            case 21972:
                this.currentTrack.primaryGChromaticityY = (float) value;
                break;
            case 21973:
                this.currentTrack.primaryBChromaticityX = (float) value;
                break;
            case 21974:
                this.currentTrack.primaryBChromaticityY = (float) value;
                break;
            case 21975:
                this.currentTrack.whitePointChromaticityX = (float) value;
                break;
            case 21976:
                this.currentTrack.whitePointChromaticityY = (float) value;
                break;
            case 21977:
                this.currentTrack.maxMasteringLuminance = (float) value;
                break;
            case 21978:
                this.currentTrack.minMasteringLuminance = (float) value;
                break;
            default:
                switch (id) {
                    case 30323:
                        this.currentTrack.projectionPoseYaw = (float) value;
                        break;
                    case 30324:
                        this.currentTrack.projectionPosePitch = (float) value;
                        break;
                    case 30325:
                        this.currentTrack.projectionPoseRoll = (float) value;
                        break;
                }
        }
    }

    protected void stringElement(int id, String value) throws ParserException {
        if (id == 134) {
            this.currentTrack.codecId = value;
            return;
        }
        if (id != 17026) {
            if (id == 21358) {
                this.currentTrack.name = value;
                return;
            } else {
                if (id != 2274716) {
                    return;
                }
                this.currentTrack.language = value;
                return;
            }
        }
        if ("webm".equals(value) || "matroska".equals(value)) {
            return;
        }
        throw new ParserException("DocType " + value + " not supported");
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0205, code lost:
    
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void binaryElement(int r22, int r23, com.google.android.exoplayer2.extractor.ExtractorInput r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 703
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.binaryElement(int, int, com.google.android.exoplayer2.extractor.ExtractorInput):void");
    }

    protected void handleBlockAdditionalData(Track track, int blockAdditionalId, ExtractorInput input, int contentSize) throws IOException {
        if (blockAdditionalId == 4 && "V_VP9".equals(track.codecId)) {
            this.blockAdditionalData.reset(contentSize);
            input.readFully(this.blockAdditionalData.data, 0, contentSize);
        } else {
            input.skipFully(contentSize);
        }
    }

    private void commitSampleToOutput(Track track, long timeUs, int flags, int size, int offset) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track, timeUs, flags, size, offset);
        } else {
            if ("S_TEXT/UTF8".equals(track.codecId) || "S_TEXT/ASS".equals(track.codecId)) {
                if (this.blockSampleCount > 1) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j = this.blockDurationUs;
                    if (j == -9223372036854775807L) {
                        Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        setSubtitleEndTime(track.codecId, j, this.subtitleSample.data);
                        TrackOutput trackOutput = track.output;
                        ParsableByteArray parsableByteArray = this.subtitleSample;
                        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
                        size += this.subtitleSample.limit();
                    }
                }
            }
            if ((268435456 & flags) != 0) {
                if (this.blockSampleCount > 1) {
                    flags &= -268435457;
                } else {
                    int iLimit = this.blockAdditionalData.limit();
                    track.output.sampleData(this.blockAdditionalData, iLimit);
                    size += iLimit;
                }
            }
            track.output.sampleMetadata(timeUs, flags, size, offset, track.cryptoData);
        }
        this.haveOutputSample = true;
    }

    private void readScratch(ExtractorInput input, int requiredLength) throws IOException {
        if (this.scratch.limit() >= requiredLength) {
            return;
        }
        if (this.scratch.capacity() < requiredLength) {
            ParsableByteArray parsableByteArray = this.scratch;
            byte[] bArr = parsableByteArray.data;
            parsableByteArray.reset(Arrays.copyOf(bArr, Math.max(bArr.length * 2, requiredLength)), this.scratch.limit());
        }
        ParsableByteArray parsableByteArray2 = this.scratch;
        input.readFully(parsableByteArray2.data, parsableByteArray2.limit(), requiredLength - this.scratch.limit());
        this.scratch.setLimit(requiredLength);
    }

    private int writeSampleData(ExtractorInput input, Track track, int size) throws IOException {
        int i;
        if ("S_TEXT/UTF8".equals(track.codecId)) {
            writeSubtitleSampleData(input, SUBRIP_PREFIX, size);
            return finishWriteSampleData();
        }
        if ("S_TEXT/ASS".equals(track.codecId)) {
            writeSubtitleSampleData(input, SSA_PREFIX, size);
            return finishWriteSampleData();
        }
        TrackOutput trackOutput = track.output;
        if (!this.sampleEncodingHandled) {
            if (track.hasContentEncryption) {
                this.blockFlags &= -1073741825;
                if (!this.sampleSignalByteRead) {
                    input.readFully(this.scratch.data, 0, 1);
                    this.sampleBytesRead++;
                    byte b = this.scratch.data[0];
                    if ((b & 128) == 128) {
                        throw new ParserException("Extension bit is set in signal byte");
                    }
                    this.sampleSignalByte = b;
                    this.sampleSignalByteRead = true;
                }
                byte b2 = this.sampleSignalByte;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.blockFlags |= pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH;
                    if (!this.sampleInitializationVectorRead) {
                        input.readFully(this.encryptionInitializationVector.data, 0, 8);
                        this.sampleBytesRead += 8;
                        this.sampleInitializationVectorRead = true;
                        ParsableByteArray parsableByteArray = this.scratch;
                        parsableByteArray.data[0] = (byte) ((z ? 128 : 0) | 8);
                        parsableByteArray.setPosition(0);
                        trackOutput.sampleData(this.scratch, 1);
                        this.sampleBytesWritten++;
                        this.encryptionInitializationVector.setPosition(0);
                        trackOutput.sampleData(this.encryptionInitializationVector, 8);
                        this.sampleBytesWritten += 8;
                    }
                    if (z) {
                        if (!this.samplePartitionCountRead) {
                            input.readFully(this.scratch.data, 0, 1);
                            this.sampleBytesRead++;
                            this.scratch.setPosition(0);
                            this.samplePartitionCount = this.scratch.readUnsignedByte();
                            this.samplePartitionCountRead = true;
                        }
                        int i2 = this.samplePartitionCount * 4;
                        this.scratch.reset(i2);
                        input.readFully(this.scratch.data, 0, i2);
                        this.sampleBytesRead += i2;
                        short s = (short) ((this.samplePartitionCount / 2) + 1);
                        int i3 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                        if (byteBuffer == null || byteBuffer.capacity() < i3) {
                            this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i3);
                        }
                        this.encryptionSubsampleDataBuffer.position(0);
                        this.encryptionSubsampleDataBuffer.putShort(s);
                        int i4 = 0;
                        int i5 = 0;
                        while (true) {
                            i = this.samplePartitionCount;
                            if (i4 >= i) {
                                break;
                            }
                            int unsignedIntToInt = this.scratch.readUnsignedIntToInt();
                            if (i4 % 2 == 0) {
                                this.encryptionSubsampleDataBuffer.putShort((short) (unsignedIntToInt - i5));
                            } else {
                                this.encryptionSubsampleDataBuffer.putInt(unsignedIntToInt - i5);
                            }
                            i4++;
                            i5 = unsignedIntToInt;
                        }
                        int i6 = (size - this.sampleBytesRead) - i5;
                        if (i % 2 == 1) {
                            this.encryptionSubsampleDataBuffer.putInt(i6);
                        } else {
                            this.encryptionSubsampleDataBuffer.putShort((short) i6);
                            this.encryptionSubsampleDataBuffer.putInt(0);
                        }
                        this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i3);
                        trackOutput.sampleData(this.encryptionSubsampleData, i3);
                        this.sampleBytesWritten += i3;
                    }
                }
            } else {
                byte[] bArr = track.sampleStrippedBytes;
                if (bArr != null) {
                    this.sampleStrippedBytes.reset(bArr, bArr.length);
                }
            }
            if (track.maxBlockAdditionId > 0) {
                this.blockFlags |= 268435456;
                this.blockAdditionalData.reset();
                this.scratch.reset(4);
                ParsableByteArray parsableByteArray2 = this.scratch;
                byte[] bArr2 = parsableByteArray2.data;
                bArr2[0] = (byte) ((size >> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr2[1] = (byte) ((size >> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr2[2] = (byte) ((size >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
                bArr2[3] = (byte) (size & KotlinVersion.MAX_COMPONENT_VALUE);
                trackOutput.sampleData(parsableByteArray2, 4);
                this.sampleBytesWritten += 4;
            }
            this.sampleEncodingHandled = true;
        }
        int iLimit = size + this.sampleStrippedBytes.limit();
        if ("V_MPEG4/ISO/AVC".equals(track.codecId) || "V_MPEGH/ISO/HEVC".equals(track.codecId)) {
            byte[] bArr3 = this.nalLength.data;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i7 = track.nalUnitLengthFieldLength;
            int i8 = 4 - i7;
            while (this.sampleBytesRead < iLimit) {
                int i9 = this.sampleCurrentNalBytesRemaining;
                if (i9 == 0) {
                    writeToTarget(input, bArr3, i8, i7);
                    this.sampleBytesRead += i7;
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                } else {
                    int iWriteToOutput = writeToOutput(input, trackOutput, i9);
                    this.sampleBytesRead += iWriteToOutput;
                    this.sampleBytesWritten += iWriteToOutput;
                    this.sampleCurrentNalBytesRemaining -= iWriteToOutput;
                }
            }
        } else {
            if (track.trueHdSampleRechunker != null) {
                Assertions.checkState(this.sampleStrippedBytes.limit() == 0);
                track.trueHdSampleRechunker.startSample(input);
            }
            while (true) {
                int i10 = this.sampleBytesRead;
                if (i10 >= iLimit) {
                    break;
                }
                int iWriteToOutput2 = writeToOutput(input, trackOutput, iLimit - i10);
                this.sampleBytesRead += iWriteToOutput2;
                this.sampleBytesWritten += iWriteToOutput2;
            }
        }
        if ("A_VORBIS".equals(track.codecId)) {
            this.vorbisNumPageSamples.setPosition(0);
            trackOutput.sampleData(this.vorbisNumPageSamples, 4);
            this.sampleBytesWritten += 4;
        }
        return finishWriteSampleData();
    }

    private int finishWriteSampleData() {
        int i = this.sampleBytesWritten;
        resetWriteSampleData();
        return i;
    }

    private void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = (byte) 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset();
    }

    private void writeSubtitleSampleData(ExtractorInput input, byte[] samplePrefix, int size) throws IOException {
        int length = samplePrefix.length + size;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.data = Arrays.copyOf(samplePrefix, length + size);
        } else {
            System.arraycopy(samplePrefix, 0, this.subtitleSample.data, 0, samplePrefix.length);
        }
        input.readFully(this.subtitleSample.data, samplePrefix.length, size);
        this.subtitleSample.reset(length);
    }

    private static void setSubtitleEndTime(String codecId, long durationUs, byte[] subtitleData) {
        byte[] subtitleTimecode;
        int i;
        codecId.hashCode();
        if (codecId.equals("S_TEXT/ASS")) {
            subtitleTimecode = formatSubtitleTimecode(durationUs, "%01d:%02d:%02d:%02d", DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
            i = 21;
        } else if (codecId.equals("S_TEXT/UTF8")) {
            subtitleTimecode = formatSubtitleTimecode(durationUs, "%02d:%02d:%02d,%03d", 1000L);
            i = 19;
        } else {
            throw new IllegalArgumentException();
        }
        System.arraycopy(subtitleTimecode, 0, subtitleData, i, subtitleTimecode.length);
    }

    private static byte[] formatSubtitleTimecode(long timeUs, String timecodeFormat, long lastTimecodeValueScalingFactor) {
        Assertions.checkArgument(timeUs != -9223372036854775807L);
        int i = (int) (timeUs / 3600000000L);
        long j = timeUs - ((i * 3600) * 1000000);
        int i2 = (int) (j / 60000000);
        long j2 = j - ((i2 * 60) * 1000000);
        int i3 = (int) (j2 / 1000000);
        return Util.getUtf8Bytes(String.format(Locale.US, timecodeFormat, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j2 - (i3 * 1000000)) / lastTimecodeValueScalingFactor))));
    }

    private void writeToTarget(ExtractorInput input, byte[] target, int offset, int length) throws IOException {
        int iMin = Math.min(length, this.sampleStrippedBytes.bytesLeft());
        input.readFully(target, offset + iMin, length - iMin);
        if (iMin > 0) {
            this.sampleStrippedBytes.readBytes(target, offset, iMin);
        }
    }

    private int writeToOutput(ExtractorInput input, TrackOutput output, int length) throws IOException {
        int iBytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (iBytesLeft > 0) {
            int iMin = Math.min(length, iBytesLeft);
            output.sampleData(this.sampleStrippedBytes, iMin);
            return iMin;
        }
        return output.sampleData(input, length, false);
    }

    private SeekMap buildSeekMap() {
        LongArray longArray;
        LongArray longArray2;
        int i;
        if (this.segmentContentPosition == -1 || this.durationUs == -9223372036854775807L || (longArray = this.cueTimesUs) == null || longArray.size() == 0 || (longArray2 = this.cueClusterPositions) == null || longArray2.size() != this.cueTimesUs.size()) {
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
            return new SeekMap.Unseekable(this.durationUs);
        }
        int size = this.cueTimesUs.size();
        int[] iArrCopyOf = new int[size];
        long[] jArrCopyOf = new long[size];
        long[] jArrCopyOf2 = new long[size];
        long[] jArrCopyOf3 = new long[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            jArrCopyOf3[i3] = this.cueTimesUs.get(i3);
            jArrCopyOf[i3] = this.segmentContentPosition + this.cueClusterPositions.get(i3);
        }
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArrCopyOf[i2] = (int) (jArrCopyOf[i4] - jArrCopyOf[i2]);
            jArrCopyOf2[i2] = jArrCopyOf3[i4] - jArrCopyOf3[i2];
            i2 = i4;
        }
        iArrCopyOf[i] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArrCopyOf[i]);
        long j = this.durationUs - jArrCopyOf3[i];
        jArrCopyOf2[i] = j;
        if (j <= 0) {
            Log.w("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i);
        }
        this.cueTimesUs = null;
        this.cueClusterPositions = null;
        return new ChunkIndex(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    private boolean maybeSeekForCues(PositionHolder seekPosition, long currentPosition) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = currentPosition;
            seekPosition.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j = this.seekPositionAfterBuildingCues;
            if (j != -1) {
                seekPosition.position = j;
                this.seekPositionAfterBuildingCues = -1L;
                return true;
            }
        }
        return false;
    }

    private long scaleTimecodeToUs(long unscaledTimecode) throws ParserException {
        long j = this.timecodeScale;
        if (j == -9223372036854775807L) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return Util.scaleLargeTimestamp(unscaledTimecode, j, 1000L);
    }

    private static boolean isCodecSupported(String codecId) {
        return "V_VP8".equals(codecId) || "V_VP9".equals(codecId) || "V_AV1".equals(codecId) || "V_MPEG2".equals(codecId) || "V_MPEG4/ISO/SP".equals(codecId) || "V_MPEG4/ISO/ASP".equals(codecId) || "V_MPEG4/ISO/AP".equals(codecId) || "V_MPEG4/ISO/AVC".equals(codecId) || "V_MPEGH/ISO/HEVC".equals(codecId) || "V_MS/VFW/FOURCC".equals(codecId) || "V_THEORA".equals(codecId) || "A_OPUS".equals(codecId) || "A_VORBIS".equals(codecId) || "A_AAC".equals(codecId) || "A_MPEG/L2".equals(codecId) || "A_MPEG/L3".equals(codecId) || "A_AC3".equals(codecId) || "A_EAC3".equals(codecId) || "A_TRUEHD".equals(codecId) || "A_DTS".equals(codecId) || "A_DTS/EXPRESS".equals(codecId) || "A_DTS/LOSSLESS".equals(codecId) || "A_FLAC".equals(codecId) || "A_MS/ACM".equals(codecId) || "A_PCM/INT/LIT".equals(codecId) || "S_TEXT/UTF8".equals(codecId) || "S_TEXT/ASS".equals(codecId) || "S_VOBSUB".equals(codecId) || "S_HDMV/PGS".equals(codecId) || "S_DVBSUB".equals(codecId);
    }

    private static int[] ensureArrayCapacity(int[] array, int length) {
        if (array == null) {
            return new int[length];
        }
        return array.length >= length ? array : new int[Math.max(array.length * 2, length)];
    }

    private final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public int getElementType(int id) {
            return MatroskaExtractor.this.getElementType(id);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public boolean isLevel1Element(int id) {
            return MatroskaExtractor.this.isLevel1Element(id);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void startMasterElement(int id, long contentPosition, long contentSize) throws ParserException {
            MatroskaExtractor.this.startMasterElement(id, contentPosition, contentSize);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void endMasterElement(int id) throws ParserException {
            MatroskaExtractor.this.endMasterElement(id);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void integerElement(int id, long value) throws ParserException {
            MatroskaExtractor.this.integerElement(id, value);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void floatElement(int id, double value) {
            MatroskaExtractor.this.floatElement(id, value);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void stringElement(int id, String value) throws ParserException {
            MatroskaExtractor.this.stringElement(id, value);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void binaryElement(int id, int contentsSize, ExtractorInput input) throws IOException {
            MatroskaExtractor.this.binaryElement(id, contentsSize, input);
        }
    }

    private static final class TrueHdSampleRechunker {
        private int chunkFlags;
        private int chunkOffset;
        private int chunkSampleCount;
        private int chunkSize;
        private long chunkTimeUs;
        private boolean foundSyncframe;
        private final byte[] syncframePrefix = new byte[10];

        public void reset() {
            this.foundSyncframe = false;
            this.chunkSampleCount = 0;
        }

        public void startSample(ExtractorInput input) throws IOException {
            if (this.foundSyncframe) {
                return;
            }
            input.peekFully(this.syncframePrefix, 0, 10);
            input.resetPeekPosition();
            if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) == 0) {
                return;
            }
            this.foundSyncframe = true;
        }

        public void sampleMetadata(Track track, long timeUs, int flags, int size, int offset) {
            if (this.foundSyncframe) {
                int i = this.chunkSampleCount;
                int i2 = i + 1;
                this.chunkSampleCount = i2;
                if (i == 0) {
                    this.chunkTimeUs = timeUs;
                    this.chunkFlags = flags;
                    this.chunkSize = 0;
                }
                this.chunkSize += size;
                this.chunkOffset = offset;
                if (i2 >= 16) {
                    outputPendingSampleMetadata(track);
                }
            }
        }

        public void outputPendingSampleMetadata(Track track) {
            if (this.chunkSampleCount > 0) {
                track.output.sampleMetadata(this.chunkTimeUs, this.chunkFlags, this.chunkSize, this.chunkOffset, track.cryptoData);
                this.chunkSampleCount = 0;
            }
        }
    }

    private static final class Track {
        public int audioBitDepth;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        private String language;
        public int maxBlockAdditionId;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public String name;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public float projectionPosePitch;
        public float projectionPoseRoll;
        public float projectionPoseYaw;
        public int projectionType;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        private Track() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionType = -1;
            this.projectionPoseYaw = 0.0f;
            this.projectionPosePitch = 0.0f;
            this.projectionPoseRoll = 0.0f;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = JosStatusCodes.RTN_CODE_COMMON_ERROR;
            this.codecDelayNs = 0L;
            this.seekPreRollNs = 0L;
            this.flagDefault = true;
            this.language = "eng";
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:175:0x0343  */
        /* JADX WARN: Removed duplicated region for block: B:176:0x0345  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x0353  */
        /* JADX WARN: Removed duplicated region for block: B:180:0x0366  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void initializeOutput(com.google.android.exoplayer2.extractor.ExtractorOutput r20, int r21) throws com.google.android.exoplayer2.ParserException {
            /*
                Method dump skipped, instructions count: 1410
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.initializeOutput(com.google.android.exoplayer2.extractor.ExtractorOutput, int):void");
        }

        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.outputPendingSampleMetadata(this);
            }
        }

        public void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.reset();
            }
        }

        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.primaryRChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryRChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryGChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryGChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryBChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.primaryBChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.whitePointChromaticityX * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.whitePointChromaticityY * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.maxMasteringLuminance + 0.5f));
            byteBufferOrder.putShort((short) (this.minMasteringLuminance + 0.5f));
            byteBufferOrder.putShort((short) this.maxContentLuminance);
            byteBufferOrder.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray buffer) throws ParserException {
            try {
                buffer.skipBytes(16);
                long littleEndianUnsignedInt = buffer.readLittleEndianUnsignedInt();
                if (littleEndianUnsignedInt == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (littleEndianUnsignedInt == 859189832) {
                    return new Pair<>("video/3gpp", null);
                }
                if (littleEndianUnsignedInt == 826496599) {
                    byte[] bArr = buffer.data;
                    for (int position = buffer.getPosition() + 20; position < bArr.length - 4; position++) {
                        if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length)));
                        }
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                }
                Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] codecPrivate) throws ParserException {
            int i;
            int i2;
            try {
                if (codecPrivate[0] != 2) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i3 = 0;
                int i4 = 1;
                while (true) {
                    i = codecPrivate[i4];
                    if (i != -1) {
                        break;
                    }
                    i3 += KotlinVersion.MAX_COMPONENT_VALUE;
                    i4++;
                }
                int i5 = i4 + 1;
                int i6 = i3 + i;
                int i7 = 0;
                while (true) {
                    i2 = codecPrivate[i5];
                    if (i2 != -1) {
                        break;
                    }
                    i7 += KotlinVersion.MAX_COMPONENT_VALUE;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + i2;
                if (codecPrivate[i8] != 1) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr = new byte[i6];
                System.arraycopy(codecPrivate, i8, bArr, 0, i6);
                int i10 = i8 + i6;
                if (codecPrivate[i10] != 3) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i11 = i10 + i9;
                if (codecPrivate[i11] != 5) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] bArr2 = new byte[codecPrivate.length - i11];
                System.arraycopy(codecPrivate, i11, bArr2, 0, codecPrivate.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr);
                arrayList.add(bArr2);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray buffer) throws ParserException {
            try {
                int littleEndianUnsignedShort = buffer.readLittleEndianUnsignedShort();
                if (littleEndianUnsignedShort == 1) {
                    return true;
                }
                if (littleEndianUnsignedShort != 65534) {
                    return false;
                }
                buffer.setPosition(24);
                if (buffer.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits()) {
                    if (buffer.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }
    }
}
