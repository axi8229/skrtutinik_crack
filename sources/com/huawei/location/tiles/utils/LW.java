package com.huawei.location.tiles.utils;

/* loaded from: classes3.dex */
public class LW {
    private static final char[] Vw = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String yn = "LW";

    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String yn(java.lang.String r8, java.lang.String r9) throws java.io.IOException {
        /*
            java.lang.String r8 = com.huawei.location.tiles.utils.yn.yn(r8)
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            java.lang.String r8 = "UTF-8"
            java.nio.charset.Charset r8 = java.nio.charset.Charset.forName(r8)
            byte[] r8 = r9.getBytes(r8)
            java.lang.String r9 = "SHA-256"
            boolean r1 = r0.exists()
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L26
            java.lang.String r8 = com.huawei.location.tiles.utils.LW.yn
            java.lang.String r9 = "file not exist"
        L21:
            com.huawei.location.lite.common.log.LogLocation.e(r8, r9)
            goto L8c
        L26:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L82 java.security.NoSuchAlgorithmException -> L87
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L82 java.security.NoSuchAlgorithmException -> L87
            r4.<init>(r0)     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L82 java.security.NoSuchAlgorithmException -> L87
            r1.<init>(r4)     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L82 java.security.NoSuchAlgorithmException -> L87
            java.security.MessageDigest r9 = java.security.MessageDigest.getInstance(r9)     // Catch: java.lang.Throwable -> L49
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r0]     // Catch: java.lang.Throwable -> L49
            int r5 = r1.read(r4)     // Catch: java.lang.Throwable -> L49
            r6 = r2
        L3d:
            r7 = -1
            if (r5 == r7) goto L4b
            r9.update(r4, r2, r5)     // Catch: java.lang.Throwable -> L49
            int r6 = r6 + r5
            int r5 = r1.read(r4)     // Catch: java.lang.Throwable -> L49
            goto L3d
        L49:
            r8 = move-exception
            goto L72
        L4b:
            if (r6 <= 0) goto L6e
            if (r8 == 0) goto L66
            int r4 = r8.length     // Catch: java.lang.Throwable -> L49
            if (r4 <= 0) goto L66
            r4 = r2
        L53:
            int r5 = r8.length     // Catch: java.lang.Throwable -> L49
            if (r4 >= r5) goto L66
            int r5 = r4 + 8192
            int r6 = r8.length     // Catch: java.lang.Throwable -> L49
            if (r5 > r6) goto L5f
            r9.update(r8, r4, r0)     // Catch: java.lang.Throwable -> L49
            goto L64
        L5f:
            int r6 = r8.length     // Catch: java.lang.Throwable -> L49
            int r6 = r6 - r4
            r9.update(r8, r4, r6)     // Catch: java.lang.Throwable -> L49
        L64:
            r4 = r5
            goto L53
        L66:
            byte[] r8 = r9.digest()     // Catch: java.lang.Throwable -> L49
            r1.close()     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L82 java.security.NoSuchAlgorithmException -> L87
            goto L8d
        L6e:
            r1.close()     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L82 java.security.NoSuchAlgorithmException -> L87
            goto L8c
        L72:
            throw r8     // Catch: java.lang.Throwable -> L73
        L73:
            r9 = move-exception
            r1.close()     // Catch: java.lang.Throwable -> L78
            goto L7c
        L78:
            r0 = move-exception
            r8.addSuppressed(r0)     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L82 java.security.NoSuchAlgorithmException -> L87
        L7c:
            throw r9     // Catch: java.io.IOException -> L7d java.io.FileNotFoundException -> L82 java.security.NoSuchAlgorithmException -> L87
        L7d:
            java.lang.String r8 = com.huawei.location.tiles.utils.LW.yn
            java.lang.String r9 = "IOException."
            goto L21
        L82:
            java.lang.String r8 = com.huawei.location.tiles.utils.LW.yn
            java.lang.String r9 = "FileNotFoundException."
            goto L21
        L87:
            java.lang.String r8 = com.huawei.location.tiles.utils.LW.yn
            java.lang.String r9 = "NoSuchAlgorithmException."
            goto L21
        L8c:
            r8 = r3
        L8d:
            if (r8 == 0) goto Lb9
            int r9 = r8.length
            if (r9 <= 0) goto Lb9
            java.lang.String r9 = new java.lang.String
            int r0 = r8.length
            int r1 = r0 << 1
            char[] r1 = new char[r1]
            r3 = r2
        L9a:
            if (r2 >= r0) goto Lb5
            int r4 = r3 + 1
            char[] r5 = com.huawei.location.tiles.utils.LW.Vw
            r6 = r8[r2]
            r7 = r6 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >>> 4
            char r7 = r5[r7]
            r1[r3] = r7
            int r3 = r3 + 2
            r6 = r6 & 15
            char r5 = r5[r6]
            r1[r4] = r5
            int r2 = r2 + 1
            goto L9a
        Lb5:
            r9.<init>(r1)
            return r9
        Lb9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.utils.LW.yn(java.lang.String, java.lang.String):java.lang.String");
    }
}
