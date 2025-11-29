package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class Id3Decoder implements MetadataDecoder {
    public static final FramePredicate NO_FRAMES_PREDICATE = new FramePredicate() { // from class: com.google.android.exoplayer2.metadata.id3.Id3Decoder$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate
        public final boolean evaluate(int i, int i2, int i3, int i4, int i5) {
            return Id3Decoder.lambda$static$0(i, i2, i3, i4, i5);
        }
    };
    private final FramePredicate framePredicate;

    public interface FramePredicate {
        boolean evaluate(int majorVersion, int id0, int id1, int id2, int id3);
    }

    private static int delimiterLength(int encodingByte) {
        return (encodingByte == 0 || encodingByte == 3) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(int majorVersion, int id0, int id1, int id2, int id3) {
        return false;
    }

    public Id3Decoder() {
        this(null);
    }

    public Id3Decoder(FramePredicate framePredicate) {
        this.framePredicate = framePredicate;
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer inputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(inputBuffer.data);
        Assertions.checkArgument(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public Metadata decode(byte[] data, int size) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(data, size);
        Id3Header id3HeaderDecodeHeader = decodeHeader(parsableByteArray);
        if (id3HeaderDecodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i = id3HeaderDecodeHeader.majorVersion == 2 ? 6 : 10;
        int iRemoveUnsynchronization = id3HeaderDecodeHeader.framesSize;
        if (id3HeaderDecodeHeader.isUnsynchronized) {
            iRemoveUnsynchronization = removeUnsynchronization(parsableByteArray, id3HeaderDecodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + iRemoveUnsynchronization);
        boolean z = false;
        if (!validateFrames(parsableByteArray, id3HeaderDecodeHeader.majorVersion, i, false)) {
            if (id3HeaderDecodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i, true)) {
                Log.w("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + id3HeaderDecodeHeader.majorVersion);
                return null;
            }
            z = true;
        }
        while (parsableByteArray.bytesLeft() >= i) {
            Id3Frame id3FrameDecodeFrame = decodeFrame(id3HeaderDecodeHeader.majorVersion, parsableByteArray, z, i, this.framePredicate);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        return new Metadata(arrayList);
    }

    private static Id3Header decodeHeader(ParsableByteArray data) {
        if (data.bytesLeft() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int unsignedInt24 = data.readUnsignedInt24();
        if (unsignedInt24 != 4801587) {
            Log.w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(unsignedInt24)));
            return null;
        }
        int unsignedByte = data.readUnsignedByte();
        data.skipBytes(1);
        int unsignedByte2 = data.readUnsignedByte();
        int synchSafeInt = data.readSynchSafeInt();
        if (unsignedByte == 2) {
            if ((unsignedByte2 & 64) != 0) {
                Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (unsignedByte == 3) {
            if ((unsignedByte2 & 64) != 0) {
                int i = data.readInt();
                data.skipBytes(i);
                synchSafeInt -= i + 4;
            }
        } else {
            if (unsignedByte != 4) {
                Log.w("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + unsignedByte);
                return null;
            }
            if ((unsignedByte2 & 64) != 0) {
                int synchSafeInt2 = data.readSynchSafeInt();
                data.skipBytes(synchSafeInt2 - 4);
                synchSafeInt -= synchSafeInt2;
            }
            if ((unsignedByte2 & 16) != 0) {
                synchSafeInt -= 10;
            }
        }
        return new Id3Header(unsignedByte, unsignedByte < 4 && (unsignedByte2 & 128) != 0, synchSafeInt);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007c A[PHI: r3
  0x007c: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:42:0x0089, B:33:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean validateFrames(com.google.android.exoplayer2.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.getPosition()
        L8:
            int r3 = r18.bytesLeft()     // Catch: java.lang.Throwable -> L22
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lae
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L25
            int r7 = r18.readInt()     // Catch: java.lang.Throwable -> L22
            long r8 = r18.readUnsignedInt()     // Catch: java.lang.Throwable -> L22
            int r10 = r18.readUnsignedShort()     // Catch: java.lang.Throwable -> L22
            goto L2f
        L22:
            r0 = move-exception
            goto Lb2
        L25:
            int r7 = r18.readUnsignedInt24()     // Catch: java.lang.Throwable -> L22
            int r8 = r18.readUnsignedInt24()     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8
            r10 = r6
        L2f:
            r11 = 0
            if (r7 != 0) goto L3d
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3d
            if (r10 != 0) goto L3d
            r1.setPosition(r2)
            return r4
        L3d:
            r7 = 4
            if (r0 != r7) goto L6e
            if (r21 != 0) goto L6e
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4e
            r1.setPosition(r2)
            return r6
        L4e:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6e:
            if (r0 != r7) goto L7e
            r3 = r10 & 64
            if (r3 == 0) goto L76
            r3 = r4
            goto L77
        L76:
            r3 = r6
        L77:
            r7 = r10 & 1
            if (r7 == 0) goto L7c
            goto L8e
        L7c:
            r4 = r6
            goto L8e
        L7e:
            if (r0 != r3) goto L8c
            r3 = r10 & 32
            if (r3 == 0) goto L86
            r3 = r4
            goto L87
        L86:
            r3 = r6
        L87:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L7c
            goto L8e
        L8c:
            r3 = r6
            r4 = r3
        L8e:
            if (r4 == 0) goto L92
            int r3 = r3 + 4
        L92:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L9b
            r1.setPosition(r2)
            return r6
        L9b:
            int r3 = r18.bytesLeft()     // Catch: java.lang.Throwable -> L22
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La8
            r1.setPosition(r2)
            return r6
        La8:
            int r3 = (int) r8
            r1.skipBytes(r3)     // Catch: java.lang.Throwable -> L22
            goto L8
        Lae:
            r1.setPosition(r2)
            return r4
        Lb2:
            r1.setPosition(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.validateFrames(com.google.android.exoplayer2.util.ParsableByteArray, int, int, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ea A[Catch: all -> 0x0122, UnsupportedEncodingException -> 0x0218, TryCatch #1 {UnsupportedEncodingException -> 0x0218, blocks: (B:91:0x011c, B:159:0x01f4, B:95:0x0127, B:102:0x013d, B:104:0x0145, B:112:0x015f, B:121:0x0177, B:132:0x0192, B:139:0x01a4, B:145:0x01b3, B:150:0x01cb, B:156:0x01e5, B:157:0x01ea), top: B:169:0x0112, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.metadata.id3.Id3Frame decodeFrame(int r19, com.google.android.exoplayer2.util.ParsableByteArray r20, boolean r21, int r22, com.google.android.exoplayer2.metadata.id3.Id3Decoder.FramePredicate r23) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.id3.Id3Decoder.decodeFrame(int, com.google.android.exoplayer2.util.ParsableByteArray, boolean, int, com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray id3Data, int frameSize) throws UnsupportedEncodingException {
        if (frameSize < 1) {
            return null;
        }
        int unsignedByte = id3Data.readUnsignedByte();
        String charsetName = getCharsetName(unsignedByte);
        int i = frameSize - 1;
        byte[] bArr = new byte[i];
        id3Data.readBytes(bArr, 0, i);
        int iIndexOfEos = indexOfEos(bArr, 0, unsignedByte);
        String str = new String(bArr, 0, iIndexOfEos, charsetName);
        int iDelimiterLength = iIndexOfEos + delimiterLength(unsignedByte);
        return new TextInformationFrame("TXXX", str, decodeStringIfValid(bArr, iDelimiterLength, indexOfEos(bArr, iDelimiterLength, unsignedByte), charsetName));
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray id3Data, int frameSize, String id) throws UnsupportedEncodingException {
        if (frameSize < 1) {
            return null;
        }
        int unsignedByte = id3Data.readUnsignedByte();
        String charsetName = getCharsetName(unsignedByte);
        int i = frameSize - 1;
        byte[] bArr = new byte[i];
        id3Data.readBytes(bArr, 0, i);
        return new TextInformationFrame(id, null, new String(bArr, 0, indexOfEos(bArr, 0, unsignedByte), charsetName));
    }

    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray id3Data, int frameSize) throws UnsupportedEncodingException {
        if (frameSize < 1) {
            return null;
        }
        int unsignedByte = id3Data.readUnsignedByte();
        String charsetName = getCharsetName(unsignedByte);
        int i = frameSize - 1;
        byte[] bArr = new byte[i];
        id3Data.readBytes(bArr, 0, i);
        int iIndexOfEos = indexOfEos(bArr, 0, unsignedByte);
        String str = new String(bArr, 0, iIndexOfEos, charsetName);
        int iDelimiterLength = iIndexOfEos + delimiterLength(unsignedByte);
        return new UrlLinkFrame("WXXX", str, decodeStringIfValid(bArr, iDelimiterLength, indexOfZeroByte(bArr, iDelimiterLength), "ISO-8859-1"));
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray id3Data, int frameSize, String id) throws UnsupportedEncodingException {
        byte[] bArr = new byte[frameSize];
        id3Data.readBytes(bArr, 0, frameSize);
        return new UrlLinkFrame(id, null, new String(bArr, 0, indexOfZeroByte(bArr, 0), "ISO-8859-1"));
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray id3Data, int frameSize) throws UnsupportedEncodingException {
        byte[] bArr = new byte[frameSize];
        id3Data.readBytes(bArr, 0, frameSize);
        int iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iIndexOfZeroByte, "ISO-8859-1"), copyOfRangeIfValid(bArr, iIndexOfZeroByte + 1, frameSize));
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray id3Data, int frameSize) throws UnsupportedEncodingException {
        int unsignedByte = id3Data.readUnsignedByte();
        String charsetName = getCharsetName(unsignedByte);
        int i = frameSize - 1;
        byte[] bArr = new byte[i];
        id3Data.readBytes(bArr, 0, i);
        int iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, iIndexOfZeroByte, "ISO-8859-1");
        int i2 = iIndexOfZeroByte + 1;
        int iIndexOfEos = indexOfEos(bArr, i2, unsignedByte);
        String strDecodeStringIfValid = decodeStringIfValid(bArr, i2, iIndexOfEos, charsetName);
        int iDelimiterLength = iIndexOfEos + delimiterLength(unsignedByte);
        int iIndexOfEos2 = indexOfEos(bArr, iDelimiterLength, unsignedByte);
        return new GeobFrame(str, strDecodeStringIfValid, decodeStringIfValid(bArr, iDelimiterLength, iIndexOfEos2, charsetName), copyOfRangeIfValid(bArr, iIndexOfEos2 + delimiterLength(unsignedByte), i));
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray id3Data, int frameSize, int majorVersion) throws UnsupportedEncodingException {
        int iIndexOfZeroByte;
        String lowerInvariant;
        int unsignedByte = id3Data.readUnsignedByte();
        String charsetName = getCharsetName(unsignedByte);
        int i = frameSize - 1;
        byte[] bArr = new byte[i];
        id3Data.readBytes(bArr, 0, i);
        if (majorVersion == 2) {
            lowerInvariant = "image/" + Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(lowerInvariant)) {
                lowerInvariant = "image/jpeg";
            }
            iIndexOfZeroByte = 2;
        } else {
            iIndexOfZeroByte = indexOfZeroByte(bArr, 0);
            lowerInvariant = Util.toLowerInvariant(new String(bArr, 0, iIndexOfZeroByte, "ISO-8859-1"));
            if (lowerInvariant.indexOf(47) == -1) {
                lowerInvariant = "image/" + lowerInvariant;
            }
        }
        int i2 = bArr[iIndexOfZeroByte + 1] & 255;
        int i3 = iIndexOfZeroByte + 2;
        int iIndexOfEos = indexOfEos(bArr, i3, unsignedByte);
        return new ApicFrame(lowerInvariant, new String(bArr, i3, iIndexOfEos - i3, charsetName), i2, copyOfRangeIfValid(bArr, iIndexOfEos + delimiterLength(unsignedByte), i));
    }

    private static CommentFrame decodeCommentFrame(ParsableByteArray id3Data, int frameSize) throws UnsupportedEncodingException {
        if (frameSize < 4) {
            return null;
        }
        int unsignedByte = id3Data.readUnsignedByte();
        String charsetName = getCharsetName(unsignedByte);
        byte[] bArr = new byte[3];
        id3Data.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i = frameSize - 4;
        byte[] bArr2 = new byte[i];
        id3Data.readBytes(bArr2, 0, i);
        int iIndexOfEos = indexOfEos(bArr2, 0, unsignedByte);
        String str2 = new String(bArr2, 0, iIndexOfEos, charsetName);
        int iDelimiterLength = iIndexOfEos + delimiterLength(unsignedByte);
        return new CommentFrame(str, str2, decodeStringIfValid(bArr2, iDelimiterLength, indexOfEos(bArr2, iDelimiterLength, unsignedByte), charsetName));
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray id3Data, int frameSize, int majorVersion, boolean unsignedIntFrameSizeHack, int frameHeaderSize, FramePredicate framePredicate) throws UnsupportedEncodingException {
        int position = id3Data.getPosition();
        int iIndexOfZeroByte = indexOfZeroByte(id3Data.data, position);
        String str = new String(id3Data.data, position, iIndexOfZeroByte - position, "ISO-8859-1");
        id3Data.setPosition(iIndexOfZeroByte + 1);
        int i = id3Data.readInt();
        int i2 = id3Data.readInt();
        long unsignedInt = id3Data.readUnsignedInt();
        long j = unsignedInt == 4294967295L ? -1L : unsignedInt;
        long unsignedInt2 = id3Data.readUnsignedInt();
        long j2 = unsignedInt2 == 4294967295L ? -1L : unsignedInt2;
        ArrayList arrayList = new ArrayList();
        int i3 = position + frameSize;
        while (id3Data.getPosition() < i3) {
            Id3Frame id3FrameDecodeFrame = decodeFrame(majorVersion, id3Data, unsignedIntFrameSizeHack, frameHeaderSize, framePredicate);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, i, i2, j, j2, id3FrameArr);
    }

    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray id3Data, int frameSize, int majorVersion, boolean unsignedIntFrameSizeHack, int frameHeaderSize, FramePredicate framePredicate) throws UnsupportedEncodingException {
        int position = id3Data.getPosition();
        int iIndexOfZeroByte = indexOfZeroByte(id3Data.data, position);
        String str = new String(id3Data.data, position, iIndexOfZeroByte - position, "ISO-8859-1");
        id3Data.setPosition(iIndexOfZeroByte + 1);
        int unsignedByte = id3Data.readUnsignedByte();
        boolean z = (unsignedByte & 2) != 0;
        boolean z2 = (unsignedByte & 1) != 0;
        int unsignedByte2 = id3Data.readUnsignedByte();
        String[] strArr = new String[unsignedByte2];
        for (int i = 0; i < unsignedByte2; i++) {
            int position2 = id3Data.getPosition();
            int iIndexOfZeroByte2 = indexOfZeroByte(id3Data.data, position2);
            strArr[i] = new String(id3Data.data, position2, iIndexOfZeroByte2 - position2, "ISO-8859-1");
            id3Data.setPosition(iIndexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i2 = position + frameSize;
        while (id3Data.getPosition() < i2) {
            Id3Frame id3FrameDecodeFrame = decodeFrame(majorVersion, id3Data, unsignedIntFrameSizeHack, frameHeaderSize, framePredicate);
            if (id3FrameDecodeFrame != null) {
                arrayList.add(id3FrameDecodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z, z2, strArr, id3FrameArr);
    }

    private static MlltFrame decodeMlltFrame(ParsableByteArray id3Data, int frameSize) {
        int unsignedShort = id3Data.readUnsignedShort();
        int unsignedInt24 = id3Data.readUnsignedInt24();
        int unsignedInt242 = id3Data.readUnsignedInt24();
        int unsignedByte = id3Data.readUnsignedByte();
        int unsignedByte2 = id3Data.readUnsignedByte();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(id3Data);
        int i = ((frameSize - 10) * 8) / (unsignedByte + unsignedByte2);
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int bits = parsableBitArray.readBits(unsignedByte);
            int bits2 = parsableBitArray.readBits(unsignedByte2);
            iArr[i2] = bits;
            iArr2[i2] = bits2;
        }
        return new MlltFrame(unsignedShort, unsignedInt24, unsignedInt242, iArr, iArr2);
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray id3Data, int frameSize, String id) {
        byte[] bArr = new byte[frameSize];
        id3Data.readBytes(bArr, 0, frameSize);
        return new BinaryFrame(id, bArr);
    }

    private static int removeUnsynchronization(ParsableByteArray data, int length) {
        byte[] bArr = data.data;
        int position = data.getPosition();
        int i = position;
        while (true) {
            int i2 = i + 1;
            if (i2 >= position + length) {
                return length;
            }
            if ((bArr[i] & 255) == 255 && bArr[i2] == 0) {
                System.arraycopy(bArr, i + 2, bArr, i2, (length - (i - position)) - 2);
                length--;
            }
            i = i2;
        }
    }

    private static String getCharsetName(int encodingByte) {
        if (encodingByte == 1) {
            return "UTF-16";
        }
        if (encodingByte == 2) {
            return "UTF-16BE";
        }
        if (encodingByte == 3) {
            return "UTF-8";
        }
        return "ISO-8859-1";
    }

    private static String getFrameId(int majorVersion, int frameId0, int frameId1, int frameId2, int frameId3) {
        if (majorVersion == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(frameId0), Integer.valueOf(frameId1), Integer.valueOf(frameId2));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(frameId0), Integer.valueOf(frameId1), Integer.valueOf(frameId2), Integer.valueOf(frameId3));
    }

    private static int indexOfEos(byte[] data, int fromIndex, int encoding) {
        int iIndexOfZeroByte = indexOfZeroByte(data, fromIndex);
        if (encoding == 0 || encoding == 3) {
            return iIndexOfZeroByte;
        }
        while (iIndexOfZeroByte < data.length - 1) {
            if (iIndexOfZeroByte % 2 == 0 && data[iIndexOfZeroByte + 1] == 0) {
                return iIndexOfZeroByte;
            }
            iIndexOfZeroByte = indexOfZeroByte(data, iIndexOfZeroByte + 1);
        }
        return data.length;
    }

    private static int indexOfZeroByte(byte[] data, int fromIndex) {
        while (fromIndex < data.length) {
            if (data[fromIndex] == 0) {
                return fromIndex;
            }
            fromIndex++;
        }
        return data.length;
    }

    private static byte[] copyOfRangeIfValid(byte[] data, int from, int to) {
        if (to <= from) {
            return Util.EMPTY_BYTE_ARRAY;
        }
        return Arrays.copyOfRange(data, from, to);
    }

    private static String decodeStringIfValid(byte[] data, int from, int to, String charsetName) throws UnsupportedEncodingException {
        if (to <= from || to > data.length) {
            return "";
        }
        return new String(data, from, to - from, charsetName);
    }

    private static final class Id3Header {
        private final int framesSize;
        private final boolean isUnsynchronized;
        private final int majorVersion;

        public Id3Header(int majorVersion, boolean isUnsynchronized, int framesSize) {
            this.majorVersion = majorVersion;
            this.isUnsynchronized = isUnsynchronized;
            this.framesSize = framesSize;
        }
    }
}
