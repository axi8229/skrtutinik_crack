package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.utils.ByteUtils;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.LZMAInputStream;

/* loaded from: classes4.dex */
class LZMADecoder extends CoderBase {
    LZMADecoder() {
        super(LZMA2Options.class, Number.class);
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException, IllegalArgumentException {
        byte[] bArr2 = coder.properties;
        if (bArr2 == null) {
            throw new IOException("Missing LZMA properties");
        }
        if (bArr2.length < 1) {
            throw new IOException("LZMA properties too short");
        }
        byte b = bArr2[0];
        int dictionarySize = getDictionarySize(coder);
        if (dictionarySize > 2147483632) {
            throw new IOException("Dictionary larger than 4GiB maximum size used in " + str);
        }
        int memoryUsage = LZMAInputStream.getMemoryUsage(dictionarySize, b);
        if (memoryUsage > i) {
            throw new MemoryLimitException(memoryUsage, i);
        }
        return new LZMAInputStream(inputStream, j, b, dictionarySize);
    }

    @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
    Object getOptionsFromCoder(Coder coder, InputStream inputStream) throws IOException {
        byte[] bArr = coder.properties;
        if (bArr == null) {
            throw new IOException("Missing LZMA properties");
        }
        if (bArr.length < 1) {
            throw new IOException("LZMA properties too short");
        }
        int i = bArr[0] & 255;
        int i2 = i / 45;
        int i3 = i - (i2 * 45);
        int i4 = i3 / 9;
        LZMA2Options lZMA2Options = new LZMA2Options();
        lZMA2Options.setPb(i2);
        lZMA2Options.setLcLp(i3 - (i4 * 9), i4);
        lZMA2Options.setDictSize(getDictionarySize(coder));
        return lZMA2Options;
    }

    private int getDictionarySize(Coder coder) throws IllegalArgumentException {
        return (int) ByteUtils.fromLittleEndian(coder.properties, 1, 4);
    }
}
