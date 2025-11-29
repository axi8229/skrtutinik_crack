package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;

/* loaded from: classes2.dex */
public final class TsUtil {
    public static int findSyncBytePosition(byte[] data, int startPosition, int limitPosition) {
        while (startPosition < limitPosition && data[startPosition] != 71) {
            startPosition++;
        }
        return startPosition;
    }

    public static long readPcrFromPacket(ParsableByteArray packetBuffer, int startOfPacket, int pcrPid) {
        packetBuffer.setPosition(startOfPacket);
        if (packetBuffer.bytesLeft() < 5) {
            return -9223372036854775807L;
        }
        int i = packetBuffer.readInt();
        if ((8388608 & i) != 0 || ((2096896 & i) >> 8) != pcrPid || (i & 32) == 0 || packetBuffer.readUnsignedByte() < 7 || packetBuffer.bytesLeft() < 7 || (packetBuffer.readUnsignedByte() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        packetBuffer.readBytes(bArr, 0, 6);
        return readPcrValueFromPcrBytes(bArr);
    }

    private static long readPcrValueFromPcrBytes(byte[] pcrBytes) {
        return ((pcrBytes[0] & 255) << 25) | ((pcrBytes[1] & 255) << 17) | ((pcrBytes[2] & 255) << 9) | ((pcrBytes[3] & 255) << 1) | ((255 & pcrBytes[4]) >> 7);
    }
}
