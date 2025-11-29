package com.huawei.secure.android.common.encrypt.hash;

import android.app.backup.BackupDataInputStream;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.a;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public abstract class FileSHA256 {
    private static final String c = "FileSHA256";
    private static final String[] e = {"SHA-256", "SHA-384", "SHA-512"};

    private static boolean a(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static String fileSHA256Encrypt(File file) {
        return fileSHAEncrypt(file, "SHA-256");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String fileSHAEncrypt(File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str) || !a(str)) {
            b.b(c, "algorithm is empty or not safe");
            return "";
        }
        if (!a(file)) {
            b.b(c, "file is not valid");
            return "";
        }
        BackupDataInputStream backupDataInputStream = 0;
        String strByteArray2HexStr = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    boolean z = false;
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                        z = true;
                    }
                    strByteArray2HexStr = z ? HexUtil.byteArray2HexStr(messageDigest.digest()) : null;
                    a.a((InputStream) fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    b.b(c, "IOException" + e.getMessage());
                    a.a((InputStream) fileInputStream);
                    return strByteArray2HexStr;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    b.b(c, "NoSuchAlgorithmException" + e.getMessage());
                    a.a((InputStream) fileInputStream);
                    return strByteArray2HexStr;
                }
            } catch (IOException e4) {
                e = e4;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                a.a((InputStream) backupDataInputStream);
                throw th;
            }
            return strByteArray2HexStr;
        } catch (Throwable th2) {
            th = th2;
            backupDataInputStream = "";
            a.a((InputStream) backupDataInputStream);
            throw th;
        }
    }

    public static boolean validateFileSHA256(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(fileSHA256Encrypt(file));
    }

    private static boolean a(String str) {
        for (String str2 : e) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
