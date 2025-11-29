package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class FlacStreamMetadata {
    public final int bitsPerSample;
    public final int bitsPerSampleLookupKey;
    public final int channels;
    public final int maxBlockSizeSamples;
    public final int maxFrameSize;
    private final Metadata metadata;
    public final int minBlockSizeSamples;
    public final int minFrameSize;
    public final int sampleRate;
    public final int sampleRateLookupKey;
    public final SeekTable seekTable;
    public final long totalSamples;

    private static int getBitsPerSampleLookupKey(int bitsPerSample) {
        if (bitsPerSample == 8) {
            return 1;
        }
        if (bitsPerSample == 12) {
            return 2;
        }
        if (bitsPerSample == 16) {
            return 4;
        }
        if (bitsPerSample != 20) {
            return bitsPerSample != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int getSampleRateLookupKey(int sampleRate) {
        switch (sampleRate) {
            case JosStatusCodes.RTN_CODE_COMMON_ERROR /* 8000 */:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public static class SeekTable {
        public final long[] pointOffsets;
        public final long[] pointSampleNumbers;

        public SeekTable(long[] pointSampleNumbers, long[] pointOffsets) {
            this.pointSampleNumbers = pointSampleNumbers;
            this.pointOffsets = pointOffsets;
        }
    }

    public FlacStreamMetadata(byte[] data, int offset) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(data);
        parsableBitArray.setPosition(offset * 8);
        this.minBlockSizeSamples = parsableBitArray.readBits(16);
        this.maxBlockSizeSamples = parsableBitArray.readBits(16);
        this.minFrameSize = parsableBitArray.readBits(24);
        this.maxFrameSize = parsableBitArray.readBits(24);
        int bits = parsableBitArray.readBits(20);
        this.sampleRate = bits;
        this.sampleRateLookupKey = getSampleRateLookupKey(bits);
        this.channels = parsableBitArray.readBits(3) + 1;
        int bits2 = parsableBitArray.readBits(5) + 1;
        this.bitsPerSample = bits2;
        this.bitsPerSampleLookupKey = getBitsPerSampleLookupKey(bits2);
        this.totalSamples = parsableBitArray.readBitsToLong(36);
        this.seekTable = null;
        this.metadata = null;
    }

    private FlacStreamMetadata(int minBlockSizeSamples, int maxBlockSizeSamples, int minFrameSize, int maxFrameSize, int sampleRate, int channels, int bitsPerSample, long totalSamples, SeekTable seekTable, Metadata metadata) {
        this.minBlockSizeSamples = minBlockSizeSamples;
        this.maxBlockSizeSamples = maxBlockSizeSamples;
        this.minFrameSize = minFrameSize;
        this.maxFrameSize = maxFrameSize;
        this.sampleRate = sampleRate;
        this.sampleRateLookupKey = getSampleRateLookupKey(sampleRate);
        this.channels = channels;
        this.bitsPerSample = bitsPerSample;
        this.bitsPerSampleLookupKey = getBitsPerSampleLookupKey(bitsPerSample);
        this.totalSamples = totalSamples;
        this.seekTable = seekTable;
        this.metadata = metadata;
    }

    public long getDurationUs() {
        long j = this.totalSamples;
        if (j == 0) {
            return -9223372036854775807L;
        }
        return (j * 1000000) / this.sampleRate;
    }

    public long getSampleNumber(long timeUs) {
        return Util.constrainValue((timeUs * this.sampleRate) / 1000000, 0L, this.totalSamples - 1);
    }

    public long getApproxBytesPerFrame() {
        long j;
        long j2;
        int i = this.maxFrameSize;
        if (i > 0) {
            j = (i + this.minFrameSize) / 2;
            j2 = 1;
        } else {
            int i2 = this.minBlockSizeSamples;
            j = ((((i2 != this.maxBlockSizeSamples || i2 <= 0) ? 4096L : i2) * this.channels) * this.bitsPerSample) / 8;
            j2 = 64;
        }
        return j + j2;
    }

    public Format getFormat(byte[] streamMarkerAndInfoBlock, Metadata id3Metadata) {
        streamMarkerAndInfoBlock[4] = -128;
        int i = this.maxFrameSize;
        if (i <= 0) {
            i = -1;
        }
        return new Format.Builder().setSampleMimeType("audio/flac").setMaxInputSize(i).setChannelCount(this.channels).setSampleRate(this.sampleRate).setInitializationData(Collections.singletonList(streamMarkerAndInfoBlock)).setMetadata(getMetadataCopyWithAppendedEntriesFrom(id3Metadata)).build();
    }

    public Metadata getMetadataCopyWithAppendedEntriesFrom(Metadata other) {
        Metadata metadata = this.metadata;
        return metadata == null ? other : metadata.copyWithAppendedEntriesFrom(other);
    }

    public FlacStreamMetadata copyWithSeekTable(SeekTable seekTable) {
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, seekTable, this.metadata);
    }

    public FlacStreamMetadata copyWithVorbisComments(List<String> vorbisComments) {
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, this.seekTable, getMetadataCopyWithAppendedEntriesFrom(buildMetadata(vorbisComments, Collections.emptyList())));
    }

    public FlacStreamMetadata copyWithPictureFrames(List<PictureFrame> pictureFrames) {
        return new FlacStreamMetadata(this.minBlockSizeSamples, this.maxBlockSizeSamples, this.minFrameSize, this.maxFrameSize, this.sampleRate, this.channels, this.bitsPerSample, this.totalSamples, this.seekTable, getMetadataCopyWithAppendedEntriesFrom(buildMetadata(Collections.emptyList(), pictureFrames)));
    }

    private static Metadata buildMetadata(List<String> vorbisComments, List<PictureFrame> pictureFrames) {
        if (vorbisComments.isEmpty() && pictureFrames.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < vorbisComments.size(); i++) {
            String str = vorbisComments.get(i);
            String[] strArrSplitAtFirst = Util.splitAtFirst(str, ContainerUtils.KEY_VALUE_DELIMITER);
            if (strArrSplitAtFirst.length != 2) {
                Log.w("FlacStreamMetadata", "Failed to parse Vorbis comment: " + str);
            } else {
                arrayList.add(new VorbisComment(strArrSplitAtFirst[0], strArrSplitAtFirst[1]));
            }
        }
        arrayList.addAll(pictureFrames);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }
}
