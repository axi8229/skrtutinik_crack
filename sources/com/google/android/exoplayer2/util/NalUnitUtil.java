package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class NalUnitUtil {
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object scratchEscapePositionsLock = new Object();
    private static int[] scratchEscapePositions = new int[10];

    public static final class SpsData {
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int profileIdc, int constraintsFlagsAndReservedZero2Bits, int levelIdc, int seqParameterSetId, int width, int height, float pixelWidthAspectRatio, boolean separateColorPlaneFlag, boolean frameMbsOnlyFlag, int frameNumLength, int picOrderCountType, int picOrderCntLsbLength, boolean deltaPicOrderAlwaysZeroFlag) {
            this.profileIdc = profileIdc;
            this.constraintsFlagsAndReservedZero2Bits = constraintsFlagsAndReservedZero2Bits;
            this.levelIdc = levelIdc;
            this.seqParameterSetId = seqParameterSetId;
            this.width = width;
            this.height = height;
            this.pixelWidthAspectRatio = pixelWidthAspectRatio;
            this.separateColorPlaneFlag = separateColorPlaneFlag;
            this.frameMbsOnlyFlag = frameMbsOnlyFlag;
            this.frameNumLength = frameNumLength;
            this.picOrderCountType = picOrderCountType;
            this.picOrderCntLsbLength = picOrderCntLsbLength;
            this.deltaPicOrderAlwaysZeroFlag = deltaPicOrderAlwaysZeroFlag;
        }
    }

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int picParameterSetId, int seqParameterSetId, boolean bottomFieldPicOrderInFramePresentFlag) {
            this.picParameterSetId = picParameterSetId;
            this.seqParameterSetId = seqParameterSetId;
            this.bottomFieldPicOrderInFramePresentFlag = bottomFieldPicOrderInFramePresentFlag;
        }
    }

    public static int unescapeStream(byte[] data, int limit) {
        int i;
        synchronized (scratchEscapePositionsLock) {
            int iFindNextUnescapeIndex = 0;
            int i2 = 0;
            while (iFindNextUnescapeIndex < limit) {
                try {
                    iFindNextUnescapeIndex = findNextUnescapeIndex(data, iFindNextUnescapeIndex, limit);
                    if (iFindNextUnescapeIndex < limit) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i2) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i2] = iFindNextUnescapeIndex;
                        iFindNextUnescapeIndex += 3;
                        i2++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i = limit - i2;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = scratchEscapePositions[i5] - i4;
                System.arraycopy(data, i4, data, i3, i6);
                int i7 = i3 + i6;
                int i8 = i7 + 1;
                data[i7] = 0;
                i3 = i7 + 2;
                data[i8] = 0;
                i4 += i6 + 3;
            }
            System.arraycopy(data, i4, data, i3, i - i3);
        }
        return i;
    }

    public static void discardToSps(ByteBuffer data) {
        int iPosition = data.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < iPosition) {
                int i4 = data.get(i) & 255;
                if (i2 == 3) {
                    if (i4 == 1 && (data.get(i3) & 31) == 7) {
                        ByteBuffer byteBufferDuplicate = data.duplicate();
                        byteBufferDuplicate.position(i - 3);
                        byteBufferDuplicate.limit(iPosition);
                        data.position(0);
                        data.put(byteBufferDuplicate);
                        return;
                    }
                } else if (i4 == 0) {
                    i2++;
                }
                if (i4 != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                data.clear();
                return;
            }
        }
    }

    public static boolean isNalUnitSei(String mimeType, byte nalUnitHeaderFirstByte) {
        if ("video/avc".equals(mimeType) && (nalUnitHeaderFirstByte & 31) == 6) {
            return true;
        }
        return "video/hevc".equals(mimeType) && ((nalUnitHeaderFirstByte & 126) >> 1) == 39;
    }

    public static int getNalUnitType(byte[] data, int offset) {
        return data[offset + 3] & 31;
    }

    public static int getH265NalUnitType(byte[] data, int offset) {
        return (data[offset + 3] & 126) >> 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014e A[PHI: r2
  0x014e: PHI (r2v8 float) = (r2v7 float), (r2v7 float), (r2v7 float), (r2v7 float), (r2v7 float), (r2v10 float) binds: [B:71:0x012a, B:73:0x0130, B:84:0x0159, B:77:0x0146, B:78:0x0148, B:79:0x014a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.exoplayer2.util.NalUnitUtil.SpsData parseSpsNalUnit(byte[] r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.parseSpsNalUnit(byte[], int, int):com.google.android.exoplayer2.util.NalUnitUtil$SpsData");
    }

    public static PpsData parsePpsNalUnit(byte[] nalData, int nalOffset, int nalLimit) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalData, nalOffset, nalLimit);
        parsableNalUnitBitArray.skipBits(8);
        int unsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int unsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0079, code lost:
    
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int findNalUnit(byte[] r8, int r9, int r10, boolean[] r11) {
        /*
            Method dump skipped, instructions count: 188
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.findNalUnit(byte[], int, int, boolean[]):int");
    }

    public static void clearPrefixFlags(boolean[] prefixFlags) {
        prefixFlags[0] = false;
        prefixFlags[1] = false;
        prefixFlags[2] = false;
    }

    private static int findNextUnescapeIndex(byte[] bytes, int offset, int limit) {
        while (offset < limit - 2) {
            if (bytes[offset] == 0 && bytes[offset + 1] == 0 && bytes[offset + 2] == 3) {
                return offset;
            }
            offset++;
        }
        return limit;
    }

    private static void skipScalingList(ParsableNalUnitBitArray bitArray, int size) {
        int signedExpGolombCodedInt = 8;
        int i = 8;
        for (int i2 = 0; i2 < size; i2++) {
            if (signedExpGolombCodedInt != 0) {
                signedExpGolombCodedInt = ((bitArray.readSignedExpGolombCodedInt() + i) + 256) % 256;
            }
            if (signedExpGolombCodedInt != 0) {
                i = signedExpGolombCodedInt;
            }
        }
    }
}
