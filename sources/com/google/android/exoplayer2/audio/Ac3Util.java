package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import okio.Utf8;
import org.pjsip.pjsua2.pjsip_status_code;

/* loaded from: classes2.dex */
public final class Ac3Util {
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] SAMPLE_RATE_BY_FSCOD = {48000, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {24000, 22050, 16000};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, pjsip_status_code.PJSIP_SC_UNKNOWN_RESOURCE_PRIORITY, pjsip_status_code.PJSIP_SC_REQUEST_TERMINATED, 557, 696, 835, 975, 1114, 1253, 1393};

    public static final class SyncFrameInfo {
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        private SyncFrameInfo(String mimeType, int streamType, int channelCount, int sampleRate, int frameSize, int sampleCount) {
            this.mimeType = mimeType;
            this.streamType = streamType;
            this.channelCount = channelCount;
            this.sampleRate = sampleRate;
            this.frameSize = frameSize;
            this.sampleCount = sampleCount;
        }
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray data, String trackId, String language, DrmInitData drmInitData) {
        int i = SAMPLE_RATE_BY_FSCOD[(data.readUnsignedByte() & 192) >> 6];
        int unsignedByte = data.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(unsignedByte & 56) >> 3];
        if ((unsignedByte & 4) != 0) {
            i2++;
        }
        return new Format.Builder().setId(trackId).setSampleMimeType("audio/ac3").setChannelCount(i2).setSampleRate(i).setDrmInitData(drmInitData).setLanguage(language).build();
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray data, String trackId, String language, DrmInitData drmInitData) {
        String str;
        data.skipBytes(2);
        int i = SAMPLE_RATE_BY_FSCOD[(data.readUnsignedByte() & 192) >> 6];
        int unsignedByte = data.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(unsignedByte & 14) >> 1];
        if ((unsignedByte & 1) != 0) {
            i2++;
        }
        if (((data.readUnsignedByte() & 30) >> 1) > 0 && (2 & data.readUnsignedByte()) != 0) {
            i2 += 2;
        }
        if (data.bytesLeft() > 0 && (data.readUnsignedByte() & 1) != 0) {
            str = "audio/eac3-joc";
        } else {
            str = "audio/eac3";
        }
        return new Format.Builder().setId(trackId).setSampleMimeType(str).setChannelCount(i2).setSampleRate(i).setDrmInitData(drmInitData).setLanguage(language).build();
    }

    public static SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        int ac3SyncframeSize;
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        int bits;
        int i5;
        int i6;
        String str2;
        int i7;
        int i8;
        int position = parsableBitArray.getPosition();
        parsableBitArray.skipBits(40);
        boolean z = parsableBitArray.readBits(5) > 10;
        parsableBitArray.setPosition(position);
        int i9 = -1;
        if (z) {
            parsableBitArray.skipBits(16);
            int bits2 = parsableBitArray.readBits(2);
            if (bits2 == 0) {
                i9 = 0;
            } else if (bits2 == 1) {
                i9 = 1;
            } else if (bits2 == 2) {
                i9 = 2;
            }
            parsableBitArray.skipBits(3);
            ac3SyncframeSize = (parsableBitArray.readBits(11) + 1) * 2;
            int bits3 = parsableBitArray.readBits(2);
            if (bits3 == 3) {
                i = SAMPLE_RATE_BY_FSCOD2[parsableBitArray.readBits(2)];
                i5 = 6;
                bits = 3;
            } else {
                bits = parsableBitArray.readBits(2);
                i5 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[bits];
                i = SAMPLE_RATE_BY_FSCOD[bits3];
            }
            i3 = i5 * 256;
            int bits4 = parsableBitArray.readBits(3);
            boolean bit = parsableBitArray.readBit();
            i2 = CHANNEL_COUNT_BY_ACMOD[bits4] + (bit ? 1 : 0);
            parsableBitArray.skipBits(10);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(8);
            }
            if (bits4 == 0) {
                parsableBitArray.skipBits(5);
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
            }
            if (i9 == 1 && parsableBitArray.readBit()) {
                parsableBitArray.skipBits(16);
            }
            if (parsableBitArray.readBit()) {
                if (bits4 > 2) {
                    parsableBitArray.skipBits(2);
                }
                if ((bits4 & 1) == 0 || bits4 <= 2) {
                    i7 = 6;
                } else {
                    i7 = 6;
                    parsableBitArray.skipBits(6);
                }
                if ((bits4 & 4) != 0) {
                    parsableBitArray.skipBits(i7);
                }
                if (bit && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(5);
                }
                if (i9 == 0) {
                    if (parsableBitArray.readBit()) {
                        i8 = 6;
                        parsableBitArray.skipBits(6);
                    } else {
                        i8 = 6;
                    }
                    if (bits4 == 0 && parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(i8);
                    }
                    if (parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(i8);
                    }
                    int bits5 = parsableBitArray.readBits(2);
                    if (bits5 == 1) {
                        parsableBitArray.skipBits(5);
                    } else if (bits5 == 2) {
                        parsableBitArray.skipBits(12);
                    } else if (bits5 == 3) {
                        int bits6 = parsableBitArray.readBits(5);
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(4);
                                }
                            }
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray.skipBits(7);
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(8);
                                }
                            }
                        }
                        parsableBitArray.skipBits((bits6 + 2) * 8);
                        parsableBitArray.byteAlign();
                    }
                    if (bits4 < 2) {
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                        if (bits4 == 0 && parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(14);
                        }
                    }
                    if (parsableBitArray.readBit()) {
                        if (bits == 0) {
                            parsableBitArray.skipBits(5);
                        } else {
                            for (int i10 = 0; i10 < i5; i10++) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(5);
                if (bits4 == 2) {
                    parsableBitArray.skipBits(4);
                }
                if (bits4 >= 6) {
                    parsableBitArray.skipBits(2);
                }
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
                if (bits4 == 0 && parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(8);
                }
                if (bits3 < 3) {
                    parsableBitArray.skipBit();
                }
            }
            if (i9 == 0 && bits != 3) {
                parsableBitArray.skipBit();
            }
            if (i9 == 2 && (bits == 3 || parsableBitArray.readBit())) {
                i6 = 6;
                parsableBitArray.skipBits(6);
            } else {
                i6 = 6;
            }
            if (parsableBitArray.readBit() && parsableBitArray.readBits(i6) == 1 && parsableBitArray.readBits(8) == 1) {
                str2 = "audio/eac3-joc";
            } else {
                str2 = "audio/eac3";
            }
            str = str2;
            i4 = i9;
        } else {
            parsableBitArray.skipBits(32);
            int bits7 = parsableBitArray.readBits(2);
            String str3 = bits7 == 3 ? null : "audio/ac3";
            ac3SyncframeSize = getAc3SyncframeSize(bits7, parsableBitArray.readBits(6));
            parsableBitArray.skipBits(8);
            int bits8 = parsableBitArray.readBits(3);
            if ((bits8 & 1) != 0 && bits8 != 1) {
                parsableBitArray.skipBits(2);
            }
            if ((bits8 & 4) != 0) {
                parsableBitArray.skipBits(2);
            }
            if (bits8 == 2) {
                parsableBitArray.skipBits(2);
            }
            int[] iArr = SAMPLE_RATE_BY_FSCOD;
            i = bits7 < iArr.length ? iArr[bits7] : -1;
            i2 = CHANNEL_COUNT_BY_ACMOD[bits8] + (parsableBitArray.readBit() ? 1 : 0);
            i3 = 1536;
            i4 = -1;
            str = str3;
        }
        return new SyncFrameInfo(str, i4, i2, i, ac3SyncframeSize, i3);
    }

    public static int parseAc3SyncframeSize(byte[] data) {
        if (data.length < 6) {
            return -1;
        }
        if (((data[5] & 248) >> 3) > 10) {
            return (((data[3] & 255) | ((data[2] & 7) << 8)) + 1) * 2;
        }
        byte b = data[4];
        return getAc3SyncframeSize((b & 192) >> 6, b & Utf8.REPLACEMENT_BYTE);
    }

    public static int parseAc3SyncframeAudioSampleCount(ByteBuffer buffer) {
        if (((buffer.get(buffer.position() + 5) & 248) >> 3) > 10) {
            return BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[((buffer.get(buffer.position() + 4) & 192) >> 6) != 3 ? (buffer.get(buffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static int findTrueHdSyncframeOffset(ByteBuffer buffer) {
        int iPosition = buffer.position();
        int iLimit = buffer.limit() - 10;
        for (int i = iPosition; i <= iLimit; i++) {
            if ((buffer.getInt(i + 4) & (-16777217)) == -1167101192) {
                return i - iPosition;
            }
        }
        return -1;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] syncframe) {
        if (syncframe[4] == -8 && syncframe[5] == 114 && syncframe[6] == 111) {
            byte b = syncframe[7];
            if ((b & 254) == 186) {
                return 40 << ((syncframe[(b & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer buffer, int offset) {
        return 40 << ((buffer.get((buffer.position() + offset) + ((buffer.get((buffer.position() + offset) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    private static int getAc3SyncframeSize(int fscod, int frmsizecod) {
        int i = frmsizecod / 2;
        if (fscod < 0) {
            return -1;
        }
        int[] iArr = SAMPLE_RATE_BY_FSCOD;
        if (fscod >= iArr.length || frmsizecod < 0) {
            return -1;
        }
        int[] iArr2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
        if (i >= iArr2.length) {
            return -1;
        }
        int i2 = iArr[fscod];
        if (i2 == 44100) {
            return (iArr2[i] + (frmsizecod % 2)) * 2;
        }
        int i3 = BITRATE_BY_HALF_FRMSIZECOD[i];
        return i2 == 32000 ? i3 * 6 : i3 * 4;
    }
}
