package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    private final List<Format> closedCaptionFormats;
    private final int flags;

    public DefaultTsPayloadReaderFactory(int flags) {
        this(flags, Collections.singletonList(new Format.Builder().setSampleMimeType("application/cea-608").build()));
    }

    public DefaultTsPayloadReaderFactory(int flags, List<Format> closedCaptionFormats) {
        this.flags = flags;
        this.closedCaptionFormats = closedCaptionFormats;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public TsPayloadReader createPayloadReader(int streamType, TsPayloadReader.EsInfo esInfo) {
        if (streamType == 2) {
            return new PesReader(new H262Reader(buildUserDataReader(esInfo)));
        }
        if (streamType == 3 || streamType == 4) {
            return new PesReader(new MpegAudioReader(esInfo.language));
        }
        if (streamType == 15) {
            if (isSet(2)) {
                return null;
            }
            return new PesReader(new AdtsReader(false, esInfo.language));
        }
        if (streamType == 17) {
            if (isSet(2)) {
                return null;
            }
            return new PesReader(new LatmReader(esInfo.language));
        }
        if (streamType == 21) {
            return new PesReader(new Id3Reader());
        }
        if (streamType == 27) {
            if (isSet(4)) {
                return null;
            }
            return new PesReader(new H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8)));
        }
        if (streamType == 36) {
            return new PesReader(new H265Reader(buildSeiReader(esInfo)));
        }
        if (streamType != 89) {
            if (streamType != 138) {
                if (streamType == 172) {
                    return new PesReader(new Ac4Reader(esInfo.language));
                }
                if (streamType != 257) {
                    if (streamType != 129) {
                        if (streamType != 130) {
                            if (streamType == 134) {
                                if (isSet(16)) {
                                    return null;
                                }
                                return new SectionReader(new PassthroughSectionPayloadReader("application/x-scte35"));
                            }
                            if (streamType != 135) {
                                return null;
                            }
                        } else if (!isSet(64)) {
                            return null;
                        }
                    }
                    return new PesReader(new Ac3Reader(esInfo.language));
                }
                return new SectionReader(new PassthroughSectionPayloadReader("application/vnd.dvb.ait"));
            }
            return new PesReader(new DtsReader(esInfo.language));
        }
        return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
    }

    private SeiReader buildSeiReader(TsPayloadReader.EsInfo esInfo) {
        return new SeiReader(getClosedCaptionFormats(esInfo));
    }

    private UserDataReader buildUserDataReader(TsPayloadReader.EsInfo esInfo) {
        return new UserDataReader(getClosedCaptionFormats(esInfo));
    }

    private List<Format> getClosedCaptionFormats(TsPayloadReader.EsInfo esInfo) {
        String str;
        int i;
        List<byte[]> listBuildCea708InitializationData;
        if (isSet(32)) {
            return this.closedCaptionFormats;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
        List<Format> arrayList = this.closedCaptionFormats;
        while (parsableByteArray.bytesLeft() > 0) {
            int unsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (unsignedByte == 134) {
                arrayList = new ArrayList<>();
                int unsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < unsignedByte2; i2++) {
                    String string = parsableByteArray.readString(3);
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z = (unsignedByte3 & 128) != 0;
                    if (z) {
                        i = unsignedByte3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte unsignedByte4 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    if (z) {
                        listBuildCea708InitializationData = CodecSpecificDataUtil.buildCea708InitializationData((unsignedByte4 & 64) != 0);
                    } else {
                        listBuildCea708InitializationData = null;
                    }
                    arrayList.add(new Format.Builder().setSampleMimeType(str).setLanguage(string).setAccessibilityChannel(i).setInitializationData(listBuildCea708InitializationData).build());
                }
            }
            parsableByteArray.setPosition(position);
        }
        return arrayList;
    }

    private boolean isSet(int flag) {
        return (flag & this.flags) != 0;
    }
}
