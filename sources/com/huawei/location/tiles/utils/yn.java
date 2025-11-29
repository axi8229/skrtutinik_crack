package com.huawei.location.tiles.utils;

import android.text.TextUtils;
import com.huawei.location.lite.common.log.LogLocation;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes3.dex */
public class yn {
    public static String Vw(String str) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(yn(str));
            try {
                byte[] bArr = new byte[1024];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        String string = sb.toString();
                        fileInputStream.close();
                        return string;
                    }
                    sb.append(new String(bArr, 0, i, StandardCharsets.UTF_8));
                }
            } finally {
            }
        } catch (IOException unused) {
            LogLocation.e("FileUtils", "read data from file failed");
            return null;
        }
    }

    public static String yn(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        if (str.contains("../")) {
            str = str.trim().replaceAll("\\.\\./", "");
        }
        return str.contains("..\\") ? str.trim().replaceAll("\\.\\.\\\\", "") : str;
    }

    public static String yn(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LogLocation.i("FileUtils", "Failed to combine paths, the local dir is empty");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            LogLocation.i("FileUtils", "Failed to combine paths, the download Url is empty");
            return null;
        }
        int iLastIndexOf = str2.lastIndexOf(File.separator);
        if (iLastIndexOf < 0 || iLastIndexOf == str2.length() - 1) {
            LogLocation.i("FileUtils", "Failed to combine paths, The download url is abnormal.");
            return null;
        }
        String strSubstring = str2.substring(iLastIndexOf + 1);
        if (!Pattern.compile("[a-zA-Z0-9\\.\\-\\_]+").matcher(strSubstring).matches()) {
            LogLocation.i("FileUtils", "Failed to combine paths, The file path contains invalid characters.");
            return null;
        }
        return str + strSubstring;
    }

    public static void yn(String str, int i) {
        String str2;
        File file = new File(str);
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length >= i) {
                Arrays.sort(fileArrListFiles, new dC());
                for (int i2 = i - 1; i2 < fileArrListFiles.length; i2++) {
                    if (!fileArrListFiles[i2].delete()) {
                        LogLocation.d("FileUtils", "file delete fail");
                    }
                }
                return;
            }
            str2 = "The number of files does not exceed the limit.";
        } else {
            str2 = "The directory does not exist.";
        }
        LogLocation.e("FileUtils", str2);
    }

    public static void yn(String str, File file) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = byteArrayInputStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream.close();
                            byteArrayInputStream.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            LogLocation.e("FileUtils", "write data to file failed");
        }
    }

    private static void yn(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - i) - 1];
            bArr[(bArr.length - i) - 1] = b;
        }
    }

    private static boolean yn(File file, ZipInputStream zipInputStream) throws IOException {
        byte[] bArr = new byte[1024];
        if (file.exists() || !file.createNewFile()) {
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                int i = zipInputStream.read(bArr);
                boolean z = false;
                while (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                    i = zipInputStream.read(bArr);
                    z = true;
                }
                fileOutputStream.close();
                return z;
            } finally {
            }
        } catch (IOException unused) {
            LogLocation.e("FileUtils", "zip fos error is: ");
            return false;
        }
    }

    public static boolean yn(String str, long j) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && System.currentTimeMillis() - file.lastModified() <= j;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String yn(java.lang.String r21, double r22, double r24) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.utils.yn.yn(java.lang.String, double, double):java.lang.String");
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0055: MOVE (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:25:0x0055 */
    public static boolean yn(String str, String str2, String str3) throws IOException {
        String str4;
        boolean z;
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        boolean z2;
        File file = new File(str2);
        boolean z3 = false;
        if (!file.exists() && !file.mkdirs()) {
            LogLocation.d("FileUtils", " not exists!!!");
            return false;
        }
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(new File(yn(str)));
                    try {
                        try {
                            zipInputStream = new ZipInputStream(fileInputStream);
                        } catch (Throwable th) {
                            th = th;
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } catch (IOException unused) {
                    str4 = "zip error";
                    LogLocation.e("FileUtils", str4);
                    LogLocation.i("FileUtils", "The unzip file is decompressed: " + z3);
                    return z3;
                }
            } catch (FileNotFoundException unused2) {
                z3 = z;
                str4 = "zip error: file not found";
                LogLocation.e("FileUtils", str4);
                LogLocation.i("FileUtils", "The unzip file is decompressed: " + z3);
                return z3;
            }
        } catch (FileNotFoundException unused3) {
            str4 = "zip error: file not found";
            LogLocation.e("FileUtils", str4);
            LogLocation.i("FileUtils", "The unzip file is decompressed: " + z3);
            return z3;
        }
        try {
            boolean zYn = false;
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                try {
                    String name = nextEntry.getName();
                    if (name.contains("../")) {
                        LogLocation.e("FileUtils", " is not security!!!");
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        zipInputStream.close();
                        fileInputStream.close();
                        return false;
                    }
                    if (nextEntry.isDirectory()) {
                        File file2 = new File(yn(str2 + File.separator + name));
                        if (file2.exists() || file2.mkdirs()) {
                            zYn = false;
                        } else {
                            LogLocation.d("FileUtils", " not exists!!!");
                            zYn = true;
                        }
                    } else {
                        zYn = yn(new File(yn(str2 + File.separator + str3)), zipInputStream);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            zipInputStream.close();
            fileInputStream.close();
            z3 = zYn;
            LogLocation.i("FileUtils", "The unzip file is decompressed: " + z3);
            return z3;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
