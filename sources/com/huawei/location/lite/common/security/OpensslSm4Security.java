package com.huawei.location.lite.common.security;

import android.text.TextUtils;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.LoadSoUtil;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;

/* loaded from: classes3.dex */
public class OpensslSm4Security implements Vw {
    public static native byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static native byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    @Override // com.huawei.location.lite.common.security.Vw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String decrypt(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "libOpensslSm4Security.so"
            boolean r0 = com.huawei.location.lite.common.util.LoadSoUtil.loadLocalSo(r0)
            java.lang.String r1 = "OpensslSm4Security"
            java.lang.String r2 = ""
            if (r0 != 0) goto L12
            java.lang.String r9 = "load openssl sm4 plugin fail"
            com.huawei.location.lite.common.log.LogLocation.d(r1, r9)
            return r2
        L12:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 == 0) goto L1e
            java.lang.String r9 = "gcm decrypt param is not right"
            com.huawei.location.lite.common.log.LogLocation.e(r1, r9)
            return r2
        L1e:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            java.lang.String r3 = "gcm decrypt key is not right"
            if (r0 != 0) goto Lc2
            int r0 = r10.length()
            r4 = 32
            if (r0 == r4) goto L30
            goto Lc2
        L30:
            java.lang.String r0 = ":"
            java.lang.String[] r9 = r9.split(r0)
            int r0 = r9.length
            r5 = 2
            if (r0 >= r5) goto L3f
            com.huawei.location.lite.common.log.LogLocation.e(r1, r3)
            goto Lc1
        L3f:
            r0 = 0
            r3 = r9[r0]
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 != 0) goto Lbe
            int r6 = r3.length()
            r7 = 24
            if (r6 == r7) goto L52
            goto Lbe
        L52:
            r6 = 1
            r9 = r9[r6]
            boolean r6 = android.text.TextUtils.isEmpty(r9)
            if (r6 != 0) goto Lbb
            int r6 = r9.length()
            if (r6 > r4) goto L62
            goto Lbb
        L62:
            int r6 = r9.length()
            int r6 = r6 - r4
            java.lang.String r0 = r9.substring(r0, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 != 0) goto Lb8
            int r6 = r0.length()
            int r6 = r6 % r5
            if (r6 == 0) goto L79
            goto Lb8
        L79:
            int r5 = r9.length()
            int r5 = r5 - r4
            java.lang.String r9 = r9.substring(r5)
            boolean r5 = android.text.TextUtils.isEmpty(r9)
            if (r5 != 0) goto Lb8
            int r5 = r9.length()
            if (r5 == r4) goto L8f
            goto Lb8
        L8f:
            byte[] r0 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(r0)
            byte[] r10 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(r10)
            byte[] r3 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(r3)
            byte[] r9 = com.huawei.secure.android.common.encrypt.utils.HexUtil.hexStr2ByteArray(r9)
            byte[] r9 = decrypt(r0, r10, r3, r9)
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8
            r10.<init>(r9, r0)
            boolean r9 = android.text.TextUtils.isEmpty(r10)
            if (r9 == 0) goto Lb6
            java.lang.String r9 = "gcm decrypt result is not right"
        Lb2:
            com.huawei.location.lite.common.log.LogLocation.e(r1, r9)
            goto Lc1
        Lb6:
            r2 = r10
            goto Lc1
        Lb8:
            java.lang.String r9 = "gcm decrypt tag is not right"
            goto Lb2
        Lbb:
            java.lang.String r9 = "gcm cipherAndTag length is not right"
            goto Lb2
        Lbe:
            java.lang.String r9 = "gcm decrypt iv is not right"
            goto Lb2
        Lc1:
            return r2
        Lc2:
            com.huawei.location.lite.common.log.LogLocation.e(r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.security.OpensslSm4Security.decrypt(java.lang.String, java.lang.String):java.lang.String");
    }

    @Override // com.huawei.location.lite.common.security.Vw
    public String encrypt(String str, String str2) {
        if (!LoadSoUtil.loadLocalSo("libOpensslSm4Security.so")) {
            LogLocation.d("OpensslSm4Security", "load openssl sm4 plugin fail");
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            LogLocation.e("OpensslSm4Security", "gcm encrypt param is not right");
            return "";
        }
        if (TextUtils.isEmpty(str2) || str2.length() != 32) {
            LogLocation.e("OpensslSm4Security", "gcm encrypt key is not right");
            return "";
        }
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(12);
        if (TextUtils.isEmpty(strGenerateSecureRandomStr) || strGenerateSecureRandomStr.length() != 24) {
            LogLocation.e("OpensslSm4Security", "gcm encrypt iv is not right");
            return "";
        }
        String strByteArray2HexStr = HexUtil.byteArray2HexStr(encrypt(StringUtils.getBytes(str), HexUtil.hexStr2ByteArray(str2), HexUtil.hexStr2ByteArray(strGenerateSecureRandomStr)));
        if (TextUtils.isEmpty(strByteArray2HexStr) || strByteArray2HexStr.length() <= 32) {
            LogLocation.e("OpensslSm4Security", "gcm encrypt result is not right");
            return "";
        }
        return strGenerateSecureRandomStr + ":" + strByteArray2HexStr;
    }
}
