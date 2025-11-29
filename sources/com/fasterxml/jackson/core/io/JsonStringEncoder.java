package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.util.Arrays;
import kotlin.KotlinVersion;
import org.pjsip.pjsua2.pj_ssl_sock_proto;

/* loaded from: classes2.dex */
public final class JsonStringEncoder {
    static final int MAX_BYTE_BUFFER_SIZE = 32000;
    static final int MAX_CHAR_BUFFER_SIZE = 32000;
    static final int MIN_BYTE_BUFFER_SIZE = 24;
    static final int MIN_CHAR_BUFFER_SIZE = 16;
    private static final int SURR1_FIRST = 55296;
    private static final int SURR1_LAST = 56319;
    private static final int SURR2_FIRST = 56320;
    private static final int SURR2_LAST = 57343;
    private static final char[] HC = CharTypes.copyHexChars();
    private static final byte[] HB = CharTypes.copyHexBytes();
    private static final JsonStringEncoder instance = new JsonStringEncoder();

    public static JsonStringEncoder getInstance() {
        return instance;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        r9 = r7 + 1;
        r7 = r13.charAt(r7);
        r10 = r2[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r10 >= 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        r7 = _appendNumeric(r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        r7 = _appendNamed(r10, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        r10 = r8 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        if (r10 <= r1.length) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        r10 = r1.length - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        if (r10 <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        java.lang.System.arraycopy(r6, 0, r1, r8, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        if (r5 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        r5 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        r1 = r5.finishCurrentSegment();
        r7 = r7 - r10;
        java.lang.System.arraycopy(r6, r10, r1, 0, r7);
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        java.lang.System.arraycopy(r6, 0, r1, r8, r7);
        r8 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        if (r6 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        r6 = _qbuf();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public char[] quoteAsString(java.lang.String r13) {
        /*
            r12 = this;
            int r0 = r13.length()
            int r1 = _initialCharBufSize(r0)
            char[] r1 = new char[r1]
            int[] r2 = com.fasterxml.jackson.core.io.CharTypes.get7BitOutputEscapes()
            int r3 = r2.length
            r4 = 0
            r5 = 0
            r7 = r4
            r8 = r7
            r6 = r5
        L14:
            if (r7 >= r0) goto L75
        L16:
            char r9 = r13.charAt(r7)
            if (r9 >= r3) goto L5b
            r10 = r2[r9]
            if (r10 == 0) goto L5b
            if (r6 != 0) goto L26
            char[] r6 = r12._qbuf()
        L26:
            int r9 = r7 + 1
            char r7 = r13.charAt(r7)
            r10 = r2[r7]
            if (r10 >= 0) goto L35
            int r7 = r12._appendNumeric(r7, r6)
            goto L39
        L35:
            int r7 = r12._appendNamed(r10, r6)
        L39:
            int r10 = r8 + r7
            int r11 = r1.length
            if (r10 <= r11) goto L55
            int r10 = r1.length
            int r10 = r10 - r8
            if (r10 <= 0) goto L45
            java.lang.System.arraycopy(r6, r4, r1, r8, r10)
        L45:
            if (r5 != 0) goto L4b
            com.fasterxml.jackson.core.util.TextBuffer r5 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r1)
        L4b:
            char[] r1 = r5.finishCurrentSegment()
            int r7 = r7 - r10
            java.lang.System.arraycopy(r6, r10, r1, r4, r7)
            r8 = r7
            goto L59
        L55:
            java.lang.System.arraycopy(r6, r4, r1, r8, r7)
            r8 = r10
        L59:
            r7 = r9
            goto L14
        L5b:
            int r10 = r1.length
            if (r8 < r10) goto L69
            if (r5 != 0) goto L64
            com.fasterxml.jackson.core.util.TextBuffer r5 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r1)
        L64:
            char[] r1 = r5.finishCurrentSegment()
            r8 = r4
        L69:
            int r10 = r8 + 1
            r1[r8] = r9
            int r7 = r7 + 1
            if (r7 < r0) goto L73
            r8 = r10
            goto L75
        L73:
            r8 = r10
            goto L16
        L75:
            if (r5 != 0) goto L7c
            char[] r13 = java.util.Arrays.copyOfRange(r1, r4, r8)
            return r13
        L7c:
            r5.setCurrentLength(r8)
            char[] r13 = r5.contentsAsArray()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.quoteAsString(java.lang.String):char[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (r6 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        r6 = _qbuf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        r9 = r7 + 1;
        r7 = r13.charAt(r7);
        r10 = r2[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        if (r10 >= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        r7 = _appendNumeric(r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        r7 = _appendNamed(r10, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        r10 = r8 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        if (r10 <= r1.length) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        r10 = r1.length - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        if (r10 <= 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
    
        java.lang.System.arraycopy(r6, 0, r1, r8, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        if (r4 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        r4 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        r1 = r4.finishCurrentSegment();
        r7 = r7 - r10;
        java.lang.System.arraycopy(r6, r10, r1, 0, r7);
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
    
        java.lang.System.arraycopy(r6, 0, r1, r8, r7);
        r8 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public char[] quoteAsString(java.lang.CharSequence r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof java.lang.String
            if (r0 == 0) goto Lb
            java.lang.String r13 = (java.lang.String) r13
            char[] r13 = r12.quoteAsString(r13)
            return r13
        Lb:
            int r0 = r13.length()
            int r1 = _initialCharBufSize(r0)
            char[] r1 = new char[r1]
            int[] r2 = com.fasterxml.jackson.core.io.CharTypes.get7BitOutputEscapes()
            int r3 = r2.length
            r4 = 0
            r5 = 0
            r6 = r4
            r7 = r5
            r8 = r7
        L1f:
            if (r7 >= r0) goto L80
        L21:
            char r9 = r13.charAt(r7)
            if (r9 >= r3) goto L66
            r10 = r2[r9]
            if (r10 == 0) goto L66
            if (r6 != 0) goto L31
            char[] r6 = r12._qbuf()
        L31:
            int r9 = r7 + 1
            char r7 = r13.charAt(r7)
            r10 = r2[r7]
            if (r10 >= 0) goto L40
            int r7 = r12._appendNumeric(r7, r6)
            goto L44
        L40:
            int r7 = r12._appendNamed(r10, r6)
        L44:
            int r10 = r8 + r7
            int r11 = r1.length
            if (r10 <= r11) goto L60
            int r10 = r1.length
            int r10 = r10 - r8
            if (r10 <= 0) goto L50
            java.lang.System.arraycopy(r6, r5, r1, r8, r10)
        L50:
            if (r4 != 0) goto L56
            com.fasterxml.jackson.core.util.TextBuffer r4 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r1)
        L56:
            char[] r1 = r4.finishCurrentSegment()
            int r7 = r7 - r10
            java.lang.System.arraycopy(r6, r10, r1, r5, r7)
            r8 = r7
            goto L64
        L60:
            java.lang.System.arraycopy(r6, r5, r1, r8, r7)
            r8 = r10
        L64:
            r7 = r9
            goto L1f
        L66:
            int r10 = r1.length
            if (r8 < r10) goto L74
            if (r4 != 0) goto L6f
            com.fasterxml.jackson.core.util.TextBuffer r4 = com.fasterxml.jackson.core.util.TextBuffer.fromInitial(r1)
        L6f:
            char[] r1 = r4.finishCurrentSegment()
            r8 = r5
        L74:
            int r10 = r8 + 1
            r1[r8] = r9
            int r7 = r7 + 1
            if (r7 < r0) goto L7e
            r8 = r10
            goto L80
        L7e:
            r8 = r10
            goto L21
        L80:
            if (r4 != 0) goto L87
            char[] r13 = java.util.Arrays.copyOfRange(r1, r5, r8)
            return r13
        L87:
            r4.setCurrentLength(r8)
            char[] r13 = r4.contentsAsArray()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.quoteAsString(java.lang.CharSequence):char[]");
    }

    public void quoteAsString(CharSequence charSequence, StringBuilder sb) {
        int i_appendNamed;
        int[] iArr = CharTypes.get7BitOutputEscapes();
        int length = iArr.length;
        int length2 = charSequence.length();
        char[] cArr_qbuf = null;
        int i = 0;
        while (i < length2) {
            do {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt >= length || iArr[cCharAt] == 0) {
                    sb.append(cCharAt);
                    i++;
                } else {
                    if (cArr_qbuf == null) {
                        cArr_qbuf = _qbuf();
                    }
                    int i2 = i + 1;
                    char cCharAt2 = charSequence.charAt(i);
                    int i3 = iArr[cCharAt2];
                    if (i3 < 0) {
                        i_appendNamed = _appendNumeric(cCharAt2, cArr_qbuf);
                    } else {
                        i_appendNamed = _appendNamed(i3, cArr_qbuf);
                    }
                    sb.append(cArr_qbuf, 0, i_appendNamed);
                    i = i2;
                }
            } while (i < length2);
            return;
        }
    }

    public byte[] quoteAsUTF8(String str) {
        int i;
        int i2;
        int i3;
        int length = str.length();
        byte[] bArrFinishCurrentSegment = new byte[_initialByteBufSize(length)];
        ByteArrayBuilder byteArrayBuilderFromInitial = null;
        int i4 = 0;
        int i_appendByte = 0;
        loop0: while (true) {
            if (i4 >= length) {
                break;
            }
            int[] iArr = CharTypes.get7BitOutputEscapes();
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt > 127 || iArr[cCharAt] != 0) {
                    break;
                }
                if (i_appendByte >= bArrFinishCurrentSegment.length) {
                    if (byteArrayBuilderFromInitial == null) {
                        byteArrayBuilderFromInitial = ByteArrayBuilder.fromInitial(bArrFinishCurrentSegment, i_appendByte);
                    }
                    bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                    i_appendByte = 0;
                }
                int i5 = i_appendByte + 1;
                bArrFinishCurrentSegment[i_appendByte] = (byte) cCharAt;
                i4++;
                if (i4 >= length) {
                    i_appendByte = i5;
                    break loop0;
                }
                i_appendByte = i5;
            }
            if (byteArrayBuilderFromInitial == null) {
                byteArrayBuilderFromInitial = ByteArrayBuilder.fromInitial(bArrFinishCurrentSegment, i_appendByte);
            }
            if (i_appendByte >= bArrFinishCurrentSegment.length) {
                bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                i_appendByte = 0;
            }
            int i6 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 <= 127) {
                i_appendByte = _appendByte(cCharAt2, iArr[cCharAt2], byteArrayBuilderFromInitial, i_appendByte);
                bArrFinishCurrentSegment = byteArrayBuilderFromInitial.getCurrentSegment();
            } else {
                if (cCharAt2 <= 2047) {
                    i3 = i_appendByte + 1;
                    bArrFinishCurrentSegment[i_appendByte] = (byte) ((cCharAt2 >> 6) | 192);
                    i2 = (cCharAt2 & '?') | 128;
                } else {
                    if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                        int i7 = i_appendByte + 1;
                        bArrFinishCurrentSegment[i_appendByte] = (byte) ((cCharAt2 >> '\f') | 224);
                        if (i7 >= bArrFinishCurrentSegment.length) {
                            bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                            i7 = 0;
                        }
                        bArrFinishCurrentSegment[i7] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                        i = i7 + 1;
                        i2 = (cCharAt2 & '?') | 128;
                    } else {
                        if (cCharAt2 > 56319) {
                            _illegal(cCharAt2);
                        }
                        if (i6 >= length) {
                            _illegal(cCharAt2);
                        }
                        int i8 = i4 + 2;
                        int i_convert = _convert(cCharAt2, str.charAt(i6));
                        if (i_convert > 1114111) {
                            _illegal(i_convert);
                        }
                        int i9 = i_appendByte + 1;
                        bArrFinishCurrentSegment[i_appendByte] = (byte) ((i_convert >> 18) | 240);
                        if (i9 >= bArrFinishCurrentSegment.length) {
                            bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                            i9 = 0;
                        }
                        int i10 = i9 + 1;
                        bArrFinishCurrentSegment[i9] = (byte) (((i_convert >> 12) & 63) | 128);
                        if (i10 >= bArrFinishCurrentSegment.length) {
                            bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                            i10 = 0;
                        }
                        int i11 = i10 + 1;
                        bArrFinishCurrentSegment[i10] = (byte) (((i_convert >> 6) & 63) | 128);
                        i2 = (i_convert & 63) | 128;
                        i = i11;
                        i6 = i8;
                    }
                    i3 = i;
                }
                if (i3 >= bArrFinishCurrentSegment.length) {
                    bArrFinishCurrentSegment = byteArrayBuilderFromInitial.finishCurrentSegment();
                    i3 = 0;
                }
                bArrFinishCurrentSegment[i3] = (byte) i2;
                i_appendByte = i3 + 1;
            }
            i4 = i6;
        }
        if (byteArrayBuilderFromInitial == null) {
            return Arrays.copyOfRange(bArrFinishCurrentSegment, 0, i_appendByte);
        }
        return byteArrayBuilderFromInitial.completeAndCoalesce(i_appendByte);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] encodeAsUTF8(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.encodeAsUTF8(java.lang.String):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] encodeAsUTF8(java.lang.CharSequence r12) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.JsonStringEncoder.encodeAsUTF8(java.lang.CharSequence):byte[]");
    }

    private char[] _qbuf() {
        return new char[]{'\\', 0, '0', '0', 0, 0};
    }

    private int _appendNumeric(int i, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = HC;
        cArr[4] = cArr2[i >> 4];
        cArr[5] = cArr2[i & 15];
        return 6;
    }

    private int _appendNamed(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int _appendByte(int i, int i2, ByteArrayBuilder byteArrayBuilder, int i3) {
        byteArrayBuilder.setCurrentSegmentLength(i3);
        byteArrayBuilder.append(92);
        if (i2 < 0) {
            byteArrayBuilder.append(117);
            if (i > 255) {
                byte[] bArr = HB;
                byteArrayBuilder.append(bArr[i >> 12]);
                byteArrayBuilder.append(bArr[(i >> 8) & 15]);
                i &= KotlinVersion.MAX_COMPONENT_VALUE;
            } else {
                byteArrayBuilder.append(48);
                byteArrayBuilder.append(48);
            }
            byte[] bArr2 = HB;
            byteArrayBuilder.append(bArr2[i >> 4]);
            byteArrayBuilder.append(bArr2[i & 15]);
        } else {
            byteArrayBuilder.append((byte) i2);
        }
        return byteArrayBuilder.getCurrentSegmentLength();
    }

    private static int _convert(int i, int i2) {
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i - 55296) << 10) + pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1 + (i2 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private static void _illegal(int i) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(i));
    }

    static int _initialCharBufSize(int i) {
        return Math.min(Math.max(16, i + Math.min((i >> 3) + 6, 1000)), 32000);
    }

    static int _initialByteBufSize(int i) {
        return Math.min(Math.max(24, i + 6 + (i >> 1)), 32000);
    }
}
