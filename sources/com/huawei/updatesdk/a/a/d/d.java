package com.huawei.updatesdk.a.a.d;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public abstract class d {
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public static String a(String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        ?? IsEmpty = TextUtils.isEmpty(str);
        FileInputStream fileInputStream2 = null;
        strA = null;
        strA = null;
        strA = null;
        strA = null;
        strA = null;
        strA = null;
        strA = null;
        strA = null;
        strA = null;
        strA = null;
        String strA = null;
        try {
            if (IsEmpty != 0) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str2);
                fileInputStream = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[1024];
                    long j = 0;
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                        j += i;
                    }
                    if (j > 0) {
                        strA = b.a(messageDigest.digest());
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    com.huawei.updatesdk.a.a.c.a.a.a.a("FileUtil", "getFileHashData FileNotFoundException", e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return strA;
                } catch (IOException e2) {
                    e = e2;
                    com.huawei.updatesdk.a.a.c.a.a.a.a("FileUtil", "getFileHashData IOException", e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return strA;
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    com.huawei.updatesdk.a.a.c.a.a.a.a("FileUtil", "getFileHashData IllegalArgumentException", e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return strA;
                } catch (IndexOutOfBoundsException e4) {
                    e = e4;
                    com.huawei.updatesdk.a.a.c.a.a.a.a("FileUtil", "getFileHashData IndexOutOfBoundsException", e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return strA;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    com.huawei.updatesdk.a.a.c.a.a.a.a("FileUtil", "getFileHashData NoSuchAlgorithmException", e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return strA;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                fileInputStream = null;
            } catch (IOException e7) {
                e = e7;
                fileInputStream = null;
            } catch (IllegalArgumentException e8) {
                e = e8;
                fileInputStream = null;
            } catch (IndexOutOfBoundsException e9) {
                e = e9;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e10) {
                e = e10;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                        com.huawei.updatesdk.a.a.c.a.a.a.b("FileUtil", "Close FileInputStream failed!");
                    }
                }
                throw th;
            }
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
                com.huawei.updatesdk.a.a.c.a.a.a.b("FileUtil", "Close FileInputStream failed!");
            }
            return strA;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = IsEmpty;
        }
    }

    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                com.huawei.updatesdk.a.a.c.a.a.a.a("FileUtil", "Closeable exception", e);
            }
        }
    }

    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                a(file2);
            }
        }
        return file.delete();
    }
}
