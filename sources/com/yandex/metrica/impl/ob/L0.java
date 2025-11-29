package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public final class L0 {
    private static final B0 a = new B0();

    public static String a(byte[] bArr) {
        try {
            return Base64.encodeToString(b(bArr), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] b(byte[] bArr) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = null;
            }
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                A2.a((Closeable) gZIPOutputStream);
                A2.a((Closeable) byteArrayOutputStream2);
                return byteArray;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                A2.a((Closeable) gZIPOutputStream);
                A2.a((Closeable) byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
        }
    }

    public static byte[] a(String str) {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } catch (Throwable unused) {
                gZIPInputStream = null;
            }
        } catch (Throwable unused2) {
            gZIPInputStream = null;
        }
        try {
            byte[] bArrA = a(gZIPInputStream);
            A2.a((Closeable) gZIPInputStream);
            A2.a((Closeable) byteArrayInputStream);
            return bArrA;
        } catch (Throwable unused3) {
            byteArrayInputStream2 = byteArrayInputStream;
            try {
                return new byte[0];
            } finally {
                A2.a((Closeable) gZIPInputStream);
                A2.a((Closeable) byteArrayInputStream2);
            }
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (true) {
            try {
                int i2 = inputStream.read(bArr);
                if (-1 == i2 || i > Integer.MAX_VALUE) {
                    break;
                }
                if (i2 > 0) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                    i += i2;
                }
            } catch (Throwable th) {
                A2.a((Closeable) byteArrayOutputStream);
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        A2.a((Closeable) byteArrayOutputStream);
        return byteArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r9) throws java.io.IOException {
        /*
            r0 = 0
            if (r9 == 0) goto L76
            boolean r1 = r9.exists()
            if (r1 != 0) goto Lb
            goto L76
        Lb:
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L6b
            java.lang.String r2 = "r"
            r1.<init>(r9, r2)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L6b
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch: java.lang.Throwable -> L42 java.lang.Throwable -> L45
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r8 = 1
            r4 = 0
            r3 = r2
            java.nio.channels.FileLock r3 = r3.lock(r4, r6, r8)     // Catch: java.lang.Throwable -> L42 java.lang.Throwable -> L45
            long r4 = r9.length()     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L6d
            int r4 = (int) r4     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L6d
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L6d
            r2.read(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L6d
            r4.flip()     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L6d
            byte[] r2 = r4.array()     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L6d
            r9.getAbsolutePath()
            a(r3)
            com.yandex.metrica.impl.ob.A2.a(r1)
            goto L77
        L40:
            r2 = move-exception
            goto L4b
        L42:
            r2 = move-exception
            r3 = r0
            goto L4b
        L45:
            r3 = r0
            goto L6d
        L47:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r3 = r1
        L4b:
            com.yandex.metrica.impl.ob.M0 r4 = com.yandex.metrica.impl.ob.C1152oh.a()     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = "error_during_file_reading"
            com.yandex.metrica.impl.ob.nh r4 = (com.yandex.metrica.impl.ob.C1127nh) r4
            r4.reportError(r5, r2)     // Catch: java.lang.Throwable -> L60
            r9.getAbsolutePath()
            a(r3)
            com.yandex.metrica.impl.ob.A2.a(r1)
            goto L76
        L60:
            r0 = move-exception
            r9.getAbsolutePath()
            a(r3)
            com.yandex.metrica.impl.ob.A2.a(r1)
            throw r0
        L6b:
            r1 = r0
            r3 = r1
        L6d:
            r9.getAbsolutePath()
            a(r3)
            com.yandex.metrica.impl.ob.A2.a(r1)
        L76:
            r2 = r0
        L77:
            if (r2 == 0) goto L92
            java.lang.String r0 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L81
            java.lang.String r9 = "UTF-8"
            r0.<init>(r2, r9)     // Catch: java.io.UnsupportedEncodingException -> L81
            goto L92
        L81:
            r9 = move-exception
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            com.yandex.metrica.impl.ob.M0 r1 = com.yandex.metrica.impl.ob.C1152oh.a()
            com.yandex.metrica.impl.ob.nh r1 = (com.yandex.metrica.impl.ob.C1127nh) r1
            java.lang.String r2 = "read_share_file_with_unsupported_encoding"
            r1.reportError(r2, r9)
        L92:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.L0.a(java.io.File):java.lang.String");
    }

    public static void a(FileLock fileLock) throws IOException {
        if (fileLock == null || !fileLock.isValid()) {
            return;
        }
        try {
            fileLock.release();
        } catch (IOException unused) {
        }
    }

    @SuppressLint({"WorldReadableFiles"})
    public static void a(Context context, String str) {
        if (A2.a(24)) {
            try {
                File noBackupFilesDir = context.getNoBackupFilesDir();
                File file = noBackupFilesDir == null ? null : new File(noBackupFilesDir, str);
                if (file != null && file.exists() && file.canWrite()) {
                    file.delete();
                }
            } catch (Throwable unused) {
            }
        }
        try {
            File fileStreamPath = context.getFileStreamPath(str);
            if (fileStreamPath != null) {
                File file2 = new File(fileStreamPath.getAbsolutePath());
                if (file2.exists() && file2.canWrite()) {
                    file2.delete();
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void a(String str, String str2, FileOutputStream fileOutputStream) throws IOException {
        FileLock fileLockLock = null;
        try {
            FileChannel channel = fileOutputStream.getChannel();
            fileLockLock = channel.lock();
            byte[] bytes = str.getBytes("UTF-8");
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length);
            byteBufferAllocate.put(bytes);
            byteBufferAllocate.flip();
            channel.write(byteBufferAllocate);
            channel.force(true);
        } catch (IOException unused) {
        } finally {
            a(fileLockLock);
            A2.a((Closeable) fileOutputStream);
        }
    }
}
