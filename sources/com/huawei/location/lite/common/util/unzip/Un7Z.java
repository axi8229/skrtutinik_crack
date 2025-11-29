package com.huawei.location.lite.common.util.unzip;

import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ReflectionUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

/* loaded from: classes3.dex */
public class Un7Z implements IUnzip {
    private boolean isHasUn7ZCoreMethod = isHasCoreMethod();

    private void createFile(String str, SevenZArchiveEntry sevenZArchiveEntry, SevenZFile sevenZFile, List<String> list, List<String> list2) throws IOException {
        File file = new File(str, sevenZArchiveEntry.getName());
        File parentFile = file.getParentFile();
        if (list != null && parentFile != null && !list.contains(parentFile.getName())) {
            return;
        }
        if (list2 != null && !list2.contains(sevenZArchiveEntry.getName())) {
            return;
        }
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = sevenZFile.read(bArr);
                if (i == -1) {
                    bufferedOutputStream.close();
                    return;
                }
                bufferedOutputStream.write(bArr, 0, i);
            }
        } finally {
        }
    }

    private void createFileDir(String str, SevenZArchiveEntry sevenZArchiveEntry, List<String> list) {
        File file = new File(str, sevenZArchiveEntry.getName());
        if ((list == null || list.contains(sevenZArchiveEntry.getName())) && !file.exists()) {
            file.mkdirs();
        }
    }

    private static boolean isContainInvalidStr(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "isContainInvalidStr: name is null";
        } else if (str.contains("../") || str.contains("..\\")) {
            str2 = "isContainInvalidStr: ../ or ..\\";
        } else if (str.contains("..") || str.contains("./")) {
            str2 = "isContainInvalidStr: .. or ./";
        } else {
            if (!str.contains(".\\.\\") && !str.contains("%00")) {
                return false;
            }
            str2 = "isContainInvalidStr: .\\.\\ or %00";
        }
        LogLocation.e("Un7Z", str2);
        return true;
    }

    private static boolean isFileOrDirSafe(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || isContainInvalidStr(str)) {
            str3 = "zip file is not valid";
        } else if (TextUtils.isEmpty(str2) || isContainInvalidStr(str2)) {
            str3 = "target directory is not valid";
        } else {
            if (isZipFileValid(str, 104857600L, 1000)) {
                return true;
            }
            str3 = "zip file contains invalid chars or too many files";
        }
        LogLocation.e("Un7Z", str3);
        return false;
    }

    private boolean isHasCoreMethod() {
        return ReflectionUtils.getMethod(ReflectionUtils.getClass("java.io.File"), "toPath", new Class[0]) != null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:33:0x0072
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static boolean isZipFileValid(java.lang.String r11, long r12, int r14) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "Un7Z"
            r2 = 0
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L67
            r4.<init>(r11)     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L67
            boolean r11 = r4.exists()     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L67
            if (r11 != 0) goto L19
            java.lang.String r11 = "Decompress7zFromPath: has no .7zfile"
            com.huawei.location.lite.common.log.LogLocation.e(r1, r11)     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L67
            return r3
        L17:
            r11 = move-exception
            goto L76
        L19:
            org.apache.commons.compress.archivers.sevenz.SevenZFile r11 = new org.apache.commons.compress.archivers.sevenz.SevenZFile     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L67
            r11.<init>(r4)     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L67
            java.lang.Iterable r2 = r11.getEntries()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L66
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L66
            r4 = 0
            r6 = r3
        L29:
            boolean r7 = r2.hasNext()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L66
            r8 = 1
            if (r7 == 0) goto L61
            java.lang.Object r7 = r2.next()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L66
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry r7 = (org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry) r7     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L66
            long r9 = r7.getSize()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L66
            long r4 = r4 + r9
            int r6 = r6 + r8
            java.lang.String r8 = r7.getName()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L66
            boolean r8 = isContainInvalidStr(r8)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L66
            if (r8 != 0) goto L5b
            if (r6 >= r14) goto L5b
            int r8 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r8 > 0) goto L5b
            long r7 = r7.getSize()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L66
            r9 = -1
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L29
            goto L5b
        L57:
            r12 = move-exception
            r2 = r11
            r11 = r12
            goto L76
        L5b:
            java.lang.String r12 = "File name is invalid or too many files or too big"
            com.huawei.location.lite.common.log.LogLocation.e(r1, r12)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L66
            goto L62
        L61:
            r3 = r8
        L62:
            r11.close()     // Catch: java.io.IOException -> L72
            goto L75
        L66:
            r2 = r11
        L67:
            java.lang.String r11 = "not a valid zip file, IOException"
            com.huawei.location.lite.common.log.LogLocation.e(r1, r11)     // Catch: java.lang.Throwable -> L17
            if (r2 == 0) goto L75
            r2.close()     // Catch: java.io.IOException -> L72
            goto L75
        L72:
            com.huawei.location.lite.common.log.LogLocation.e(r1, r0)
        L75:
            return r3
        L76:
            if (r2 == 0) goto L7f
            r2.close()     // Catch: java.io.IOException -> L7c
            goto L7f
        L7c:
            com.huawei.location.lite.common.log.LogLocation.e(r1, r0)
        L7f:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.unzip.Un7Z.isZipFileValid(java.lang.String, long, int):boolean");
    }

    @Override // com.huawei.location.lite.common.util.unzip.IUnzip
    public boolean doUnzip(String str, String str2) {
        return doUnzip(str, str2, null, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:46:0x00b6
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v16, types: [com.huawei.location.lite.common.util.unzip.Un7Z] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public boolean doUnzip(java.lang.String r12, java.lang.String r13, java.util.List<java.lang.String> r14, java.util.List<java.lang.String> r15) {
        /*
            r11 = this;
            java.lang.String r0 = "SevenZFile close : IOException"
            boolean r1 = r11.isSupportUnZip(r12)
            r2 = 0
            java.lang.String r3 = "Un7Z"
            if (r1 != 0) goto L11
            java.lang.String r12 = "Decompress7zFromPath:  path or inputFile not support"
        Ld:
            com.huawei.location.lite.common.log.LogLocation.e(r3, r12)
            return r2
        L11:
            boolean r1 = isFileOrDirSafe(r12, r13)
            if (r1 != 0) goto L1a
            java.lang.String r12 = "Decompress7zFromPath:  path or inputFile invalid"
            goto Ld
        L1a:
            java.lang.String r1 = java.io.File.separator
            boolean r4 = r13.endsWith(r1)
            if (r4 == 0) goto L39
            int r4 = r13.length()
            int r5 = r1.length()
            if (r4 <= r5) goto L39
            int r4 = r13.length()
            int r1 = r1.length()
            int r4 = r4 - r1
            java.lang.String r13 = r13.substring(r2, r4)
        L39:
            java.io.File r1 = new java.io.File
            r1.<init>(r12)
            boolean r12 = r1.exists()
            if (r12 != 0) goto L4b
            java.lang.String r12 = "Decompress7zFromPath: has no .7zfile"
            com.huawei.location.lite.common.log.LogLocation.e(r3, r12)
            r12 = r2
            goto L4c
        L4b:
            r12 = 1
        L4c:
            r4 = 0
            org.apache.commons.compress.archivers.sevenz.SevenZFile r10 = new org.apache.commons.compress.archivers.sevenz.SevenZFile     // Catch: java.lang.Throwable -> La9 java.io.IOException -> Lab
            r10.<init>(r1)     // Catch: java.lang.Throwable -> La9 java.io.IOException -> Lab
        L52:
            org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry r6 = r10.getNextEntry()     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            if (r6 == 0) goto La2
            java.lang.String r1 = r6.getName()     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            if (r4 == 0) goto L63
            goto L52
        L63:
            java.lang.String r4 = "\\\\"
            java.lang.String r5 = "/"
            java.lang.String r1 = r1.replaceAll(r4, r5)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            java.text.Normalizer$Form r4 = java.text.Normalizer.Form.NFKC     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            java.lang.String r1 = java.text.Normalizer.normalize(r1, r4)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            boolean r4 = isContainInvalidStr(r1)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            if (r4 == 0) goto L8f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            r12.<init>()     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            java.lang.String r13 = "zipPath is a invalid path: "
            r12.append(r13)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            r12.append(r1)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            com.huawei.location.lite.common.log.LogLocation.e(r3, r12)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            goto La3
        L8c:
            r12 = move-exception
            r4 = r10
            goto Lba
        L8f:
            boolean r1 = r6.isDirectory()     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            if (r1 == 0) goto L99
            r11.createFileDir(r13, r6, r14)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            goto L52
        L99:
            r4 = r11
            r5 = r13
            r7 = r10
            r8 = r14
            r9 = r15
            r4.createFile(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L8c java.io.IOException -> La7
            goto L52
        La2:
            r2 = r12
        La3:
            r10.close()     // Catch: java.io.IOException -> Lb6
            goto Lb9
        La7:
            r4 = r10
            goto Lab
        La9:
            r12 = move-exception
            goto Lba
        Lab:
            java.lang.String r12 = "decompress7zFromPath : IOException"
            com.huawei.location.lite.common.log.LogLocation.e(r3, r12)     // Catch: java.lang.Throwable -> La9
            if (r4 == 0) goto Lb9
            r4.close()     // Catch: java.io.IOException -> Lb6
            goto Lb9
        Lb6:
            com.huawei.location.lite.common.log.LogLocation.e(r3, r0)
        Lb9:
            return r2
        Lba:
            if (r4 == 0) goto Lc3
            r4.close()     // Catch: java.io.IOException -> Lc0
            goto Lc3
        Lc0:
            com.huawei.location.lite.common.log.LogLocation.e(r3, r0)
        Lc3:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.util.unzip.Un7Z.doUnzip(java.lang.String, java.lang.String, java.util.List, java.util.List):boolean");
    }

    public boolean isSupportUnZip(String str) {
        return str.contains(".7z") && this.isHasUn7ZCoreMethod;
    }
}
