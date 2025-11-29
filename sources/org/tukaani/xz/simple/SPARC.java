package org.tukaani.xz.simple;

import kotlin.KotlinVersion;
import org.pjsip.pjsua2.pj_ssl_cert_verify_flag_t;

/* loaded from: classes4.dex */
public final class SPARC implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public SPARC(boolean z, int i) {
        this.isEncoder = z;
        this.pos = i;
    }

    @Override // org.tukaani.xz.simple.SimpleFilter
    public int code(byte[] bArr, int i, int i2) {
        int i3 = (i2 + i) - 4;
        int i4 = i;
        while (i4 <= i3) {
            int i5 = bArr[i4];
            if ((i5 == 64 && (bArr[i4 + 1] & 192) == 0) || (i5 == 127 && (bArr[i4 + 1] & 192) == 192)) {
                int i6 = i4 + 1;
                int i7 = i4 + 2;
                int i8 = i4 + 3;
                int i9 = (((((i5 & KotlinVersion.MAX_COMPONENT_VALUE) << 24) | ((bArr[i6] & KotlinVersion.MAX_COMPONENT_VALUE) << 16)) | ((bArr[i7] & KotlinVersion.MAX_COMPONENT_VALUE) << 8)) | (bArr[i8] & KotlinVersion.MAX_COMPONENT_VALUE)) << 2;
                int i10 = this.isEncoder ? i9 + ((this.pos + i4) - i) : i9 - ((this.pos + i4) - i);
                int i11 = (((0 - ((i10 >>> 24) & 1)) << 22) & 1073741823) | ((i10 >>> 2) & 4194303) | pj_ssl_cert_verify_flag_t.PJ_SSL_CERT_EIDENTITY_NOT_MATCH;
                bArr[i4] = (byte) (i11 >>> 24);
                bArr[i6] = (byte) (i11 >>> 16);
                bArr[i7] = (byte) (i11 >>> 8);
                bArr[i8] = (byte) i11;
            }
            i4 += 4;
        }
        int i12 = i4 - i;
        this.pos += i12;
        return i12;
    }
}
