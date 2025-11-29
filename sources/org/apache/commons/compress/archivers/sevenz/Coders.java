package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.tukaani.xz.ARMOptions;
import org.tukaani.xz.ARMThumbOptions;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.IA64Options;
import org.tukaani.xz.PowerPCOptions;
import org.tukaani.xz.SPARCOptions;
import org.tukaani.xz.X86Options;

/* loaded from: classes4.dex */
class Coders {
    private static final Map<SevenZMethod, CoderBase> CODER_MAP = new HashMap<SevenZMethod, CoderBase>() { // from class: org.apache.commons.compress.archivers.sevenz.Coders.1
        {
            put(SevenZMethod.COPY, new CopyDecoder());
            put(SevenZMethod.LZMA, new LZMADecoder());
            put(SevenZMethod.LZMA2, new LZMA2Decoder());
            put(SevenZMethod.DEFLATE, new DeflateDecoder());
            put(SevenZMethod.DEFLATE64, new Deflate64Decoder());
            put(SevenZMethod.BZIP2, new BZIP2Decoder());
            put(SevenZMethod.AES256SHA256, new AES256SHA256Decoder());
            put(SevenZMethod.BCJ_X86_FILTER, new BCJDecoder(new X86Options()));
            put(SevenZMethod.BCJ_PPC_FILTER, new BCJDecoder(new PowerPCOptions()));
            put(SevenZMethod.BCJ_IA64_FILTER, new BCJDecoder(new IA64Options()));
            put(SevenZMethod.BCJ_ARM_FILTER, new BCJDecoder(new ARMOptions()));
            put(SevenZMethod.BCJ_ARM_THUMB_FILTER, new BCJDecoder(new ARMThumbOptions()));
            put(SevenZMethod.BCJ_SPARC_FILTER, new BCJDecoder(new SPARCOptions()));
            put(SevenZMethod.DELTA_FILTER, new DeltaDecoder());
        }
    };

    static CoderBase findByMethod(SevenZMethod sevenZMethod) {
        return CODER_MAP.get(sevenZMethod);
    }

    static InputStream addDecoder(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
        CoderBase coderBaseFindByMethod = findByMethod(SevenZMethod.byId(coder.decompressionMethodId));
        if (coderBaseFindByMethod == null) {
            throw new IOException("Unsupported compression method " + Arrays.toString(coder.decompressionMethodId) + " used in " + str);
        }
        return coderBaseFindByMethod.decode(str, inputStream, j, coder, bArr, i);
    }

    static class CopyDecoder extends CoderBase {
        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
            return inputStream;
        }

        CopyDecoder() {
            super(new Class[0]);
        }
    }

    static class BCJDecoder extends CoderBase {
        private final FilterOptions opts;

        BCJDecoder(FilterOptions filterOptions) {
            super(new Class[0]);
            this.opts = filterOptions;
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
            try {
                return this.opts.getInputStream(inputStream);
            } catch (AssertionError e) {
                throw new IOException("BCJ filter used in " + str + " needs XZ for Java > 1.4 - see https://commons.apache.org/proper/commons-compress/limitations.html#7Z", e);
            }
        }
    }

    static class DeflateDecoder extends CoderBase {
        private static final byte[] ONE_ZERO_BYTE = new byte[1];

        DeflateDecoder() {
            super(Number.class);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
            Inflater inflater = new Inflater(true);
            return new DeflateDecoderInputStream(new InflaterInputStream(new SequenceInputStream(inputStream, new ByteArrayInputStream(ONE_ZERO_BYTE)), inflater), inflater);
        }

        static class DeflateDecoderInputStream extends InputStream {
            Inflater inflater;
            final InflaterInputStream inflaterInputStream;

            public DeflateDecoderInputStream(InflaterInputStream inflaterInputStream, Inflater inflater) {
                this.inflaterInputStream = inflaterInputStream;
                this.inflater = inflater;
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                return this.inflaterInputStream.read();
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                return this.inflaterInputStream.read(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr) throws IOException {
                return this.inflaterInputStream.read(bArr);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                try {
                    this.inflaterInputStream.close();
                } finally {
                    this.inflater.end();
                }
            }
        }
    }

    static class Deflate64Decoder extends CoderBase {
        Deflate64Decoder() {
            super(Number.class);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
            return new Deflate64CompressorInputStream(inputStream);
        }
    }

    static class BZIP2Decoder extends CoderBase {
        BZIP2Decoder() {
            super(Number.class);
        }

        @Override // org.apache.commons.compress.archivers.sevenz.CoderBase
        InputStream decode(String str, InputStream inputStream, long j, Coder coder, byte[] bArr, int i) throws IOException {
            return new BZip2CompressorInputStream(inputStream);
        }
    }
}
