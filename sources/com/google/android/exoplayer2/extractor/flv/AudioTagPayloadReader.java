package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.util.Collections;

/* loaded from: classes2.dex */
final class AudioTagPayloadReader extends TagPayloadReader {
    private static final int[] AUDIO_SAMPLING_RATE_TABLE = {5512, 11025, 22050, 44100};
    private int audioFormat;
    private boolean hasOutputFormat;
    private boolean hasParsedAudioDataHeader;

    public AudioTagPayloadReader(TrackOutput output) {
        super(output);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parseHeader(ParsableByteArray data) throws TagPayloadReader.UnsupportedFormatException {
        if (!this.hasParsedAudioDataHeader) {
            int unsignedByte = data.readUnsignedByte();
            int i = (unsignedByte >> 4) & 15;
            this.audioFormat = i;
            if (i == 2) {
                this.output.format(new Format.Builder().setSampleMimeType("audio/mpeg").setChannelCount(1).setSampleRate(AUDIO_SAMPLING_RATE_TABLE[(unsignedByte >> 2) & 3]).build());
                this.hasOutputFormat = true;
            } else if (i == 7 || i == 8) {
                this.output.format(new Format.Builder().setSampleMimeType(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").setChannelCount(1).setSampleRate(JosStatusCodes.RTN_CODE_COMMON_ERROR).build());
                this.hasOutputFormat = true;
            } else if (i != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.audioFormat);
            }
            this.hasParsedAudioDataHeader = true;
        } else {
            data.skipBytes(1);
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parsePayload(ParsableByteArray data, long timeUs) throws ParserException {
        if (this.audioFormat == 2) {
            int iBytesLeft = data.bytesLeft();
            this.output.sampleData(data, iBytesLeft);
            this.output.sampleMetadata(timeUs, 1, iBytesLeft, 0, null);
            return true;
        }
        int unsignedByte = data.readUnsignedByte();
        if (unsignedByte == 0 && !this.hasOutputFormat) {
            int iBytesLeft2 = data.bytesLeft();
            byte[] bArr = new byte[iBytesLeft2];
            data.readBytes(bArr, 0, iBytesLeft2);
            AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr);
            this.output.format(new Format.Builder().setSampleMimeType("audio/mp4a-latm").setCodecs(audioSpecificConfig.codecs).setChannelCount(audioSpecificConfig.channelCount).setSampleRate(audioSpecificConfig.sampleRateHz).setInitializationData(Collections.singletonList(bArr)).build());
            this.hasOutputFormat = true;
            return false;
        }
        if (this.audioFormat == 10 && unsignedByte != 1) {
            return false;
        }
        int iBytesLeft3 = data.bytesLeft();
        this.output.sampleData(data, iBytesLeft3);
        this.output.sampleMetadata(timeUs, 1, iBytesLeft3, 0, null);
        return true;
    }
}
