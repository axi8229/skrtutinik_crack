package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.MemoryLimitException;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.LZMA2Options;

/* loaded from: classes4.dex */
class LZMA2Decoder extends CoderBase {
    LZMA2Decoder() {
        super(LZMA2Options.class, Number.class);
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
        try {
            int dictionarySize = getDictionarySize(coder);
            int memoryUsage = LZMA2InputStream.getMemoryUsage(dictionarySize);
            if (memoryUsage > i) {
                throw new MemoryLimitException(memoryUsage, i);
            }
            return new LZMA2InputStream(inputStream, dictionarySize);
        } catch (IllegalArgumentException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    Object getOptionsFromCoder(Coder coder, InputStream inputStream) throws IOException {
        return Integer.valueOf(getDictionarySize(coder));
    }

    private int getDictionarySize(Coder coder) throws IOException {
        byte[] bArr = coder.properties;
        if (bArr == null) {
            throw new IOException("Missing LZMA2 properties");
        }
        if (bArr.length < 1) {
            throw new IOException("LZMA2 properties too short");
        }
        byte b = bArr[0];
        int i = b & 255;
        if ((b & 192) != 0) {
            throw new IOException("Unsupported LZMA2 property bits");
        }
        if (i > 40) {
            throw new IOException("Dictionary larger than 4GiB maximum size");
        }
        if (i == 40) {
            return -1;
        }
        return ((b & 1) | 2) << ((i / 2) + 11);
    }
}
