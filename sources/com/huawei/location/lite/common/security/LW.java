package com.huawei.location.lite.common.security;

import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogLocation;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.engines.SM4Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes3.dex */
public class LW implements Vw {
    @Override // com.huawei.location.lite.common.security.Vw
    public String decrypt(String str, String str2) {
        return str;
    }

    @Override // com.huawei.location.lite.common.security.Vw
    public String encrypt(String str, String str2) throws CharacterCodingException, IllegalArgumentException {
        ByteBuffer byteBufferEncode;
        byte[] bArr;
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            byteBufferEncode = Charset.forName("UTF-8").newEncoder().encode(CharBuffer.wrap(str));
        } catch (CharacterCodingException unused) {
            LogLocation.e("SM4Security", "CharacterCodingException ");
            byteBufferEncode = null;
        }
        if (byteBufferEncode != null) {
            bArr = new byte[byteBufferEncode.limit()];
            byteBufferEncode.get(bArr);
        } else {
            bArr = new byte[0];
        }
        if (bArr.length <= 0) {
            return str;
        }
        byte[] bArrFromHexString = ByteUtils.fromHexString(str2);
        SM4Engine sM4Engine = new SM4Engine();
        sM4Engine.init(true, new KeyParameter(bArrFromHexString));
        if (bArr.length == 0) {
            LogLocation.e("SM4Security", "handlePKCS5Padding error");
        } else {
            int length = bArr.length;
            int i = 16 - (length % 16);
            int i2 = length + i;
            byte[] bArr2 = new byte[i2];
            byte[] bArr3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
            for (int i3 = 0; i3 < i2; i3++) {
                if (i3 < length) {
                    bArr2[i3] = bArr[i3];
                } else {
                    bArr2[i3] = bArr3[i];
                }
            }
            bArr = bArr2;
        }
        int length2 = bArr.length;
        byte[] bArr4 = new byte[length2];
        int i4 = length2 / 16;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 * 16;
            try {
                sM4Engine.processBlock(bArr, i6, bArr4, i6);
            } catch (IllegalStateException unused2) {
                str3 = "encryptBySm4OutByte IllegalStateException";
                LogLocation.e("SM4Security", str3);
                return Hex.toHexString(bArr4);
            } catch (DataLengthException unused3) {
                str3 = "encryptBySm4OutByte DataLengthException";
                LogLocation.e("SM4Security", str3);
                return Hex.toHexString(bArr4);
            }
        }
        return Hex.toHexString(bArr4);
    }
}
