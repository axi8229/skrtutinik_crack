package com.group_ib.sdk;

import android.util.Base64;
import com.fasterxml.jackson.core.base.GeneratorBase;
import java.util.zip.CRC32;
import org.pjsip.pjsua2.pj_ssl_sock_proto;
import org.pjsip.pjsua2.pjsip_status_code;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* loaded from: classes3.dex */
public abstract class M {
    public static final String a = X.b(1);
    public static final String b = X.b(2);
    public static final int[] c = {113, 11, 53, 101, 47, 23, 41, 103, 19, 37, 29, 73, 109, 97, 89, 71, 59, 107, 31, 79, 83, 43, 13, 17, 61, 67};
    public static final int[] d = {1009, pjsip_transport_type_e.PJSIP_TRANSPORT_TLS6, 1699, 1283, 587, 967, 929, 271, 773, 1811, 1373, 1319, 809, 971, 1249, 1361, 1697, 593, 367, 1879, 1667, 523, 1789, 1523, 557, 1049};
    public static final int[] e = {7127, 15313, 3203, 9181, 16927, 42169, 48079, 49853, 23417, 30851, 21401, 28793, 17449, 16067, 38281, 33637, 44711, 7853, 16657, 46831, 19913, 1987, 47111, 51449, 27767, 17747};
    public static final int[] f = {4643, 2129, 1399, 719, 787, 881, 7879, 499, 4721, 3187, 3203, 7333, 3527, 7451, 5399, 1733, 3583, 3863, 661, 4591, 257, 7717, 3877, 7691, 4597, 6701};
    public static final int[] g = {397, 137, 1009, pjsip_status_code.PJSIP_SC_CALL_BEING_FORWARDED, 881, 379, 107, 919, 229, 1019, 809, 359, 17, pjsip_status_code.PJSIP_SC_CONFLICT, 179, 13, 37, 431, pjsip_status_code.PJSIP_SC_EARLY_DIALOG_TERMINATED, 257, 929, 197, 859, 503, 127, 29};

    public static String a(String str) {
        int i;
        int i2;
        int iCodePointAt;
        int iCodePointAt2;
        int i3;
        if (str == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(str.length());
            int i4 = 0;
            int i5 = 0;
            while (i4 < str.length()) {
                int iCodePointAt3 = str.codePointAt(i4);
                if (iCodePointAt3 >= 8) {
                    if (iCodePointAt3 < 128) {
                        i3 = (((iCodePointAt3 - 8) + c[i5 % 26]) % 120) + 8;
                    } else {
                        if (iCodePointAt3 < 2048) {
                            i = (((iCodePointAt3 - 128) + d[i5 % 26]) % 1920) + 128;
                            i2 = (i >> 6) | 192;
                        } else if (iCodePointAt3 < 55296) {
                            i = (((iCodePointAt3 - 2048) + e[i5 % 26]) % 53248) + 2048;
                            sb.appendCodePoint((i >> 12) | 224);
                            i2 = ((i >> 6) & 63) | 128;
                        } else {
                            if (iCodePointAt3 < 56320) {
                                int i6 = i4 + 1;
                                if (i6 >= str.length() || (iCodePointAt2 = str.codePointAt(i6)) < 56320 || iCodePointAt2 >= 57344) {
                                }
                            } else if (iCodePointAt3 < 57344) {
                                if (i4 != 0 && (iCodePointAt = str.codePointAt(i4 - 1)) >= 55296 && iCodePointAt < 56320) {
                                    int[] iArr = g;
                                    i = ((((((iCodePointAt3 - 56320) + iArr[i5 % 26]) % 1024) + 56320) & 1023) | ((((((iCodePointAt - GeneratorBase.SURR1_FIRST) + iArr[(i5 - 1) % 26]) % 1024) + GeneratorBase.SURR1_FIRST) & 1023) << 10)) + pj_ssl_sock_proto.PJ_SSL_SOCK_PROTO_DTLS1;
                                    sb.appendCodePoint((i >> 18) | 240);
                                    sb.appendCodePoint(((i >> 12) & 63) | 128);
                                    i2 = ((i >> 6) & 63) | 128;
                                }
                            } else if (iCodePointAt3 >= 57344) {
                                i = (((iCodePointAt3 - 57344) + f[i5 % 26]) % 8192) + 57344;
                                sb.appendCodePoint((i >> 12) | 224);
                                i2 = ((i >> 6) & 63) | 128;
                            }
                            i4++;
                            i5++;
                        }
                        sb.appendCodePoint(i2);
                        i3 = (i & 63) | 128;
                    }
                    sb.appendCodePoint(i3);
                    i4++;
                    i5++;
                }
                i5--;
                i4++;
                i5++;
            }
            String string = sb.toString();
            CRC32 crc32 = new CRC32();
            crc32.update(string.getBytes("ISO-8859-1"));
            long value = crc32.getValue();
            return Base64.encodeToString(b.getBytes(), 2) + Base64.encodeToString(string.getBytes("ISO-8859-1"), 2) + Base64.encodeToString(new byte[]{(byte) ((value >> 24) & 255), (byte) ((value >> 16) & 255), (byte) ((value >> 8) & 255), (byte) (value & 255)}, 2);
        } catch (Exception e2) {
            c1.b(a, "failed to mangle pkt", e2);
            return null;
        }
    }
}
