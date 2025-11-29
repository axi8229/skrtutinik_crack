package sputnik.axmor.com.sputnik.services.ble_service;

import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: HexUtils.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00022\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "bytes", "", "hex", "([B)Ljava/lang/String;", "Landroid/util/SparseArray;", "parseManufacturerSpecificData", "(Landroid/util/SparseArray;)Ljava/lang/String;", "", "HEX_CHARS", "[C", "app_huaweiRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HexUtilsKt {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final String hex(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char[] cArr = new char[bytes.length * 2];
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            byte b = bytes[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_CHARS;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static final String parseManufacturerSpecificData(SparseArray<byte[]> bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] bArr = bytes.get(65535);
        int i = 0;
        if (bArr != null) {
            byte[] bArr2 = new byte[4];
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            bArr2[3] = 0;
            while (i < 4) {
                try {
                    bArr2[i] = bArr[i];
                    i++;
                } catch (Exception unused) {
                }
            }
            return String.valueOf(Long.parseLong(hex(bArr2), CharsKt.checkRadix(16)));
        }
        byte[] bArr3 = bytes.get(76);
        byte[] bArr4 = new byte[4];
        bArr4[0] = 0;
        bArr4[1] = 0;
        bArr4[2] = 0;
        bArr4[3] = 0;
        while (i < 4) {
            try {
                bArr4[i] = bArr3[i + 18];
                i++;
            } catch (Exception unused2) {
            }
        }
        return String.valueOf(Long.parseLong(hex(bArr4), CharsKt.checkRadix(16)));
    }
}
