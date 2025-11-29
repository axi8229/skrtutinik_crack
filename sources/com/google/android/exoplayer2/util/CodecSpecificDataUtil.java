package com.google.android.exoplayer2.util;

import android.util.Pair;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class CodecSpecificDataUtil {
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};

    public static Pair<Integer, Integer> parseAlacAudioSpecificConfig(byte[] audioSpecificConfig) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(audioSpecificConfig);
        parsableByteArray.setPosition(9);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.setPosition(20);
        return Pair.create(Integer.valueOf(parsableByteArray.readUnsignedIntToInt()), Integer.valueOf(unsignedByte));
    }

    public static List<byte[]> buildCea708InitializationData(boolean isWideAspectRatio) {
        return Collections.singletonList(isWideAspectRatio ? new byte[]{1} : new byte[]{0});
    }

    public static boolean parseCea708InitializationData(List<byte[]> initializationData) {
        return initializationData.size() == 1 && initializationData.get(0).length == 1 && initializationData.get(0)[0] == 1;
    }

    public static String buildAvcCodecString(int profileIdc, int constraintsFlagsAndReservedZero2Bits, int levelIdc) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(profileIdc), Integer.valueOf(constraintsFlagsAndReservedZero2Bits), Integer.valueOf(levelIdc));
    }

    public static byte[] buildNalUnit(byte[] data, int offset, int length) {
        byte[] bArr = NAL_START_CODE;
        byte[] bArr2 = new byte[bArr.length + length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(data, offset, bArr2, bArr.length, length);
        return bArr2;
    }
}
