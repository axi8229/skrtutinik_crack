package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;

/* loaded from: classes2.dex */
public final class AacUtil {
    private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, JosStatusCodes.RTN_CODE_COMMON_ERROR, 7350};
    private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static final class Config {
        public final int channelCount;
        public final String codecs;
        public final int sampleRateHz;

        private Config(int sampleRateHz, int channelCount, String codecs) {
            this.sampleRateHz = sampleRateHz;
            this.channelCount = channelCount;
            this.codecs = codecs;
        }
    }

    public static Config parseAudioSpecificConfig(byte[] audioSpecificConfig) throws ParserException {
        return parseAudioSpecificConfig(new ParsableBitArray(audioSpecificConfig), false);
    }

    public static Config parseAudioSpecificConfig(ParsableBitArray bitArray, boolean forceReadToEnd) throws ParserException {
        int audioObjectType = getAudioObjectType(bitArray);
        int samplingFrequency = getSamplingFrequency(bitArray);
        int bits = bitArray.readBits(4);
        String str = "mp4a.40." + audioObjectType;
        if (audioObjectType == 5 || audioObjectType == 29) {
            samplingFrequency = getSamplingFrequency(bitArray);
            audioObjectType = getAudioObjectType(bitArray);
            if (audioObjectType == 22) {
                bits = bitArray.readBits(4);
            }
        }
        if (forceReadToEnd) {
            if (audioObjectType != 1 && audioObjectType != 2 && audioObjectType != 3 && audioObjectType != 4 && audioObjectType != 6 && audioObjectType != 7 && audioObjectType != 17) {
                switch (audioObjectType) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new ParserException("Unsupported audio object type: " + audioObjectType);
                }
            }
            parseGaSpecificConfig(bitArray, audioObjectType, bits);
            switch (audioObjectType) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int bits2 = bitArray.readBits(2);
                    if (bits2 == 2 || bits2 == 3) {
                        throw new ParserException("Unsupported epConfig: " + bits2);
                    }
            }
        }
        int i = AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE[bits];
        Assertions.checkArgument(i != -1);
        return new Config(samplingFrequency, i, str);
    }

    public static byte[] buildAudioSpecificConfig(int audioObjectType, int sampleRateIndex, int channelConfig) {
        return new byte[]{(byte) (((audioObjectType << 3) & 248) | ((sampleRateIndex >> 1) & 7)), (byte) (((sampleRateIndex << 7) & 128) | ((channelConfig << 3) & 120))};
    }

    private static int getAudioObjectType(ParsableBitArray bitArray) {
        int bits = bitArray.readBits(5);
        return bits == 31 ? bitArray.readBits(6) + 32 : bits;
    }

    private static int getSamplingFrequency(ParsableBitArray bitArray) {
        int bits = bitArray.readBits(4);
        if (bits == 15) {
            return bitArray.readBits(24);
        }
        Assertions.checkArgument(bits < 13);
        return AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[bits];
    }

    private static void parseGaSpecificConfig(ParsableBitArray bitArray, int audioObjectType, int channelConfiguration) {
        if (bitArray.readBit()) {
            Log.w("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (bitArray.readBit()) {
            bitArray.skipBits(14);
        }
        boolean bit = bitArray.readBit();
        if (channelConfiguration == 0) {
            throw new UnsupportedOperationException();
        }
        if (audioObjectType == 6 || audioObjectType == 20) {
            bitArray.skipBits(3);
        }
        if (bit) {
            if (audioObjectType == 22) {
                bitArray.skipBits(16);
            }
            if (audioObjectType == 17 || audioObjectType == 19 || audioObjectType == 20 || audioObjectType == 23) {
                bitArray.skipBits(3);
            }
            bitArray.skipBits(1);
        }
    }
}
