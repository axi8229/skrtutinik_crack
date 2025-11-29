package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes2.dex */
public final class TrackEncryptionBox {
    public final TrackOutput.CryptoData cryptoData;
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;
    public final String schemeType;

    public TrackEncryptionBox(boolean isEncrypted, String schemeType, int perSampleIvSize, byte[] keyId, int defaultEncryptedBlocks, int defaultClearBlocks, byte[] defaultInitializationVector) {
        Assertions.checkArgument((defaultInitializationVector == null) ^ (perSampleIvSize == 0));
        this.isEncrypted = isEncrypted;
        this.schemeType = schemeType;
        this.perSampleIvSize = perSampleIvSize;
        this.defaultInitializationVector = defaultInitializationVector;
        this.cryptoData = new TrackOutput.CryptoData(schemeToCryptoMode(schemeType), keyId, defaultEncryptedBlocks, defaultClearBlocks);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int schemeToCryptoMode(String schemeType) {
        if (schemeType == null) {
            return 1;
        }
        char c = 65535;
        switch (schemeType.hashCode()) {
            case 3046605:
                if (schemeType.equals("cbc1")) {
                    c = 0;
                    break;
                }
                break;
            case 3046671:
                if (schemeType.equals("cbcs")) {
                    c = 1;
                    break;
                }
                break;
            case 3049879:
                if (schemeType.equals("cenc")) {
                    c = 2;
                    break;
                }
                break;
            case 3049895:
                if (schemeType.equals("cens")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return 2;
            default:
                Log.w("TrackEncryptionBox", "Unsupported protection scheme type '" + schemeType + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
