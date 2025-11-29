package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;

/* loaded from: classes2.dex */
final class VideoTagPayloadReader extends TagPayloadReader {
    private int frameType;
    private boolean hasOutputFormat;
    private boolean hasOutputKeyframe;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int nalUnitLengthFieldLength;

    public VideoTagPayloadReader(TrackOutput output) {
        super(output);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parseHeader(ParsableByteArray data) throws TagPayloadReader.UnsupportedFormatException {
        int unsignedByte = data.readUnsignedByte();
        int i = (unsignedByte >> 4) & 15;
        int i2 = unsignedByte & 15;
        if (i2 != 7) {
            throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i2);
        }
        this.frameType = i;
        return i != 5;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parsePayload(ParsableByteArray data, long timeUs) throws ParserException {
        int unsignedByte = data.readUnsignedByte();
        long int24 = timeUs + (data.readInt24() * 1000);
        if (unsignedByte == 0 && !this.hasOutputFormat) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(new byte[data.bytesLeft()]);
            data.readBytes(parsableByteArray.data, 0, data.bytesLeft());
            AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
            this.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
            this.output.format(new Format.Builder().setSampleMimeType("video/avc").setWidth(avcConfig.width).setHeight(avcConfig.height).setPixelWidthHeightRatio(avcConfig.pixelWidthAspectRatio).setInitializationData(avcConfig.initializationData).build());
            this.hasOutputFormat = true;
            return false;
        }
        if (unsignedByte != 1 || !this.hasOutputFormat) {
            return false;
        }
        int i = this.frameType == 1 ? 1 : 0;
        if (!this.hasOutputKeyframe && i == 0) {
            return false;
        }
        byte[] bArr = this.nalLength.data;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        int i2 = 4 - this.nalUnitLengthFieldLength;
        int i3 = 0;
        while (data.bytesLeft() > 0) {
            data.readBytes(this.nalLength.data, i2, this.nalUnitLengthFieldLength);
            this.nalLength.setPosition(0);
            int unsignedIntToInt = this.nalLength.readUnsignedIntToInt();
            this.nalStartCode.setPosition(0);
            this.output.sampleData(this.nalStartCode, 4);
            this.output.sampleData(data, unsignedIntToInt);
            i3 = i3 + 4 + unsignedIntToInt;
        }
        this.output.sampleMetadata(int24, i, i3, 0, null);
        this.hasOutputKeyframe = true;
        return true;
    }
}
