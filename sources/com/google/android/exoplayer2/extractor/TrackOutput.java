package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public interface TrackOutput {
    void format(Format format);

    int sampleData(DataReader input, int length, boolean allowEndOfInput) throws IOException;

    void sampleData(ParsableByteArray data, int length);

    void sampleMetadata(long timeUs, int flags, int size, int offset, CryptoData encryptionData);

    public static final class CryptoData {
        public final int clearBlocks;
        public final int cryptoMode;
        public final int encryptedBlocks;
        public final byte[] encryptionKey;

        public CryptoData(int cryptoMode, byte[] encryptionKey, int encryptedBlocks, int clearBlocks) {
            this.cryptoMode = cryptoMode;
            this.encryptionKey = encryptionKey;
            this.encryptedBlocks = encryptedBlocks;
            this.clearBlocks = clearBlocks;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CryptoData.class != obj.getClass()) {
                return false;
            }
            CryptoData cryptoData = (CryptoData) obj;
            return this.cryptoMode == cryptoData.cryptoMode && this.encryptedBlocks == cryptoData.encryptedBlocks && this.clearBlocks == cryptoData.clearBlocks && Arrays.equals(this.encryptionKey, cryptoData.encryptionKey);
        }

        public int hashCode() {
            return (((((this.cryptoMode * 31) + Arrays.hashCode(this.encryptionKey)) * 31) + this.encryptedBlocks) * 31) + this.clearBlocks;
        }
    }
}
