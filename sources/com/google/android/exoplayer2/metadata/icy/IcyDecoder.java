package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class IcyDecoder implements MetadataDecoder {
    private static final Pattern METADATA_ELEMENT = Pattern.compile("(.+?)='(.*?)';", 32);
    private final CharsetDecoder utf8Decoder = Charset.forName("UTF-8").newDecoder();
    private final CharsetDecoder iso88591Decoder = Charset.forName("ISO-8859-1").newDecoder();

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer inputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(inputBuffer.data);
        Assertions.checkArgument(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        String strDecodeToString = decodeToString(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (strDecodeToString == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = METADATA_ELEMENT.matcher(strDecodeToString);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String lowerInvariant = Util.toLowerInvariant(matcher.group(1));
            String strGroup = matcher.group(2);
            if (lowerInvariant != null) {
                if (lowerInvariant.equals("streamurl")) {
                    str2 = strGroup;
                } else if (lowerInvariant.equals("streamtitle")) {
                    str = strGroup;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }

    private String decodeToString(ByteBuffer data) {
        try {
            return this.utf8Decoder.decode(data).toString();
        } catch (CharacterCodingException unused) {
            try {
                String string = this.iso88591Decoder.decode(data).toString();
                this.iso88591Decoder.reset();
                data.rewind();
                return string;
            } catch (CharacterCodingException unused2) {
                this.iso88591Decoder.reset();
                data.rewind();
                return null;
            } catch (Throwable th) {
                this.iso88591Decoder.reset();
                data.rewind();
                throw th;
            }
        } finally {
            this.utf8Decoder.reset();
            data.rewind();
        }
    }
}
