package com.group_ib.sdk;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class q {
    public static final /* synthetic */ boolean r = true;
    public Context a = null;
    public FileOutputStream b = null;
    public String c = null;
    public RandomAccessFile d = null;
    public String e = null;
    public RandomAccessFile f = null;
    public long g = 0;
    public final ByteBuffer h = ByteBuffer.allocate(8);
    public final ByteBuffer i = ByteBuffer.allocate(4);
    public File j = null;
    public String k = null;
    public long l = 0;
    public long m = 131072;
    public long n = 1048576;
    public long o = 1048576;
    public String p;
    public int q;

    public q(Context context, String str, int i) {
        a(context, str, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096 A[Catch: all -> 0x003a, Exception -> 0x003d, TRY_LEAVE, TryCatch #0 {Exception -> 0x003d, blocks: (B:4:0x0002, B:6:0x0006, B:10:0x0010, B:15:0x003f, B:17:0x004f, B:19:0x0053, B:22:0x005a, B:24:0x007b, B:28:0x0087, B:30:0x0096), top: B:43:0x0002, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized int a(com.group_ib.sdk.m1 r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            java.io.RandomAccessFile r1 = r6.d     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r1 != 0) goto L3f
            java.lang.String r1 = r6.c()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r6.e = r1     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r1 != 0) goto L10
            monitor-exit(r6)
            return r0
        L10:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r1.<init>()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.lang.String r2 = r6.e     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r1.append(r2)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.lang.String r2 = ".pos"
            r1.append(r2)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            long r1 = r6.b(r1)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r6.g = r1     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.lang.String r2 = r6.e     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r6.d = r1     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            long r2 = r6.g     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r1.seek(r2)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            goto L3f
        L3a:
            r7 = move-exception
            goto Lbd
        L3d:
            r1 = move-exception
            goto L9e
        L3f:
            r1 = 4
            r7.a(r1)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.io.RandomAccessFile r2 = r6.d     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            byte[] r3 = r7.a     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r4 = r7.b     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r2 = r2.read(r3, r4, r1)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r2 != r1) goto La1
            byte[] r2 = r7.a     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r2 == 0) goto L7a
            int r3 = r2.length     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r4 = r7.b     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r3 = r3 - r4
            if (r3 >= r1) goto L5a
            goto L7a
        L5a:
            r3 = r2[r4]     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 24
            int r5 = r4 + 1
            r5 = r2[r5]     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 16
            int r3 = r3 + r5
            int r5 = r4 + 2
            r5 = r2[r5]     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 8
            int r3 = r3 + r5
            int r4 = r4 + 3
            r2 = r2[r4]     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            goto L7b
        L7a:
            r3 = r0
        L7b:
            int r2 = r7.b     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r2 = r2 + r1
            r7.b = r2     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r3 <= 0) goto La1
            r2 = 102400(0x19000, float:1.43493E-40)
            if (r3 > r2) goto La1
            r7.a(r3)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            java.io.RandomAccessFile r2 = r6.d     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            byte[] r4 = r7.a     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r5 = r7.b     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r2 = r2.read(r4, r5, r3)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r2 != r3) goto La1
            int r2 = r7.b     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r2 = r2 + r3
            r7.b = r2     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r0 = r3 + 4
            goto La1
        L9e:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L3a
        La1:
            if (r0 != 0) goto Lbb
            java.lang.String r1 = r6.c     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto Laf
            java.lang.String r2 = r6.e     // Catch: java.lang.Throwable -> L3a
            boolean r1 = r2.matches(r1)     // Catch: java.lang.Throwable -> L3a
            if (r1 != 0) goto Lbb
        Laf:
            java.lang.String r0 = r6.e     // Catch: java.lang.Throwable -> L3a
            r6.a(r0)     // Catch: java.lang.Throwable -> L3a
            r0 = 0
            r6.e = r0     // Catch: java.lang.Throwable -> L3a
            int r0 = r6.a(r7)     // Catch: java.lang.Throwable -> L3a
        Lbb:
            monitor-exit(r6)
            return r0
        Lbd:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L3a
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.group_ib.sdk.q.a(com.group_ib.sdk.m1):int");
    }

    public final long b(String str) throws IOException {
        if (this.f == null) {
            this.f = new RandomAccessFile(new File(str), "rwd");
        }
        this.h.clear();
        this.f.seek(0L);
        if (this.f.read(this.h.array(), 0, 8) == 8) {
            return this.h.getLong();
        }
        return 0L;
    }

    public final String c() {
        String name;
        File[] fileArrListFiles = this.j.listFiles(new C0611n());
        long j = 0;
        if (fileArrListFiles != null) {
            long j2 = Long.MAX_VALUE;
            name = null;
            for (File file : fileArrListFiles) {
                String name2 = file.getName();
                if (!name2.endsWith(".cached")) {
                    long jLastModified = file.lastModified();
                    long length = file.length() + j;
                    if (jLastModified < j2) {
                        name = file.getName();
                        j2 = jLastModified;
                    }
                    j = length;
                } else if (!name2.startsWith(this.p)) {
                    file.delete();
                }
            }
        } else {
            name = null;
        }
        this.n = j;
        if (name == null) {
            return null;
        }
        return this.k + File.separator + name;
    }

    public final synchronized void d() {
        try {
            if (this.q == 2) {
                return;
            }
            this.q = 2;
            File[] fileArrListFiles = this.j.listFiles(new C0613o());
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    String name = file.getName();
                    if (name.startsWith(this.p)) {
                        String str = this.c;
                        boolean z = str != null && str.endsWith(name);
                        if (z) {
                            FileOutputStream fileOutputStream = this.b;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                                this.b = null;
                            }
                            this.c = null;
                        }
                        String strSubstring = name.substring(0, name.length() - 7);
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.k);
                        String str2 = File.separator;
                        sb.append(str2);
                        sb.append(strSubstring);
                        if (!file.renameTo(new File(sb.toString()))) {
                            this.n -= file.length();
                            file.delete();
                        }
                        if (z) {
                            this.c = this.k + str2 + strSubstring;
                            this.b = new FileOutputStream(new File(this.c), true);
                        }
                    }
                }
            }
        } finally {
        }
    }

    public final synchronized void b() {
        try {
            FileOutputStream fileOutputStream = this.b;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.b = null;
            }
            File[] fileArrListFiles = this.j.listFiles(new C0615p());
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    String name = file.getName();
                    if (!name.endsWith(".cached")) {
                        a(name);
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a() {
        try {
            RandomAccessFile randomAccessFile = this.d;
            if (randomAccessFile != null) {
                long filePointer = randomAccessFile.getFilePointer();
                if (!r && this.f == null) {
                    throw new AssertionError();
                }
                RandomAccessFile randomAccessFile2 = this.f;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.seek(0L);
                    this.h.clear();
                    this.h.putLong(filePointer);
                    this.f.write(this.h.array(), 0, 8);
                }
                this.g = filePointer;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(m1 m1Var) {
        if (m1Var != null) {
            try {
                if (!m1Var.a()) {
                    if (this.l + m1Var.b + 4 > this.m) {
                        FileOutputStream fileOutputStream = this.b;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            this.b = null;
                        }
                        this.l = 0L;
                    }
                    long j = this.n;
                    int i = m1Var.b;
                    if (j + i + 4 > this.o) {
                        long j2 = (i << 1) + 4;
                        while (true) {
                            String strC = c();
                            if (this.n + j2 <= this.o) {
                                break;
                            } else if (strC != null) {
                                a(strC);
                            }
                        }
                    }
                    if (this.b == null) {
                        this.c = this.k + File.separator + this.p + "." + System.currentTimeMillis() + ".log";
                        if (this.q == 1) {
                            this.c += ".cached";
                        }
                        this.b = new FileOutputStream(new File(this.c), true);
                        this.l = 0L;
                    }
                    this.i.clear();
                    this.i.putInt(m1Var.b);
                    this.b.write(this.i.array());
                    this.b.write(m1Var.a, 0, m1Var.b);
                    this.b.flush();
                    long j3 = this.l;
                    long j4 = m1Var.b + 4;
                    this.l = j3 + j4;
                    this.n += j4;
                }
            } finally {
            }
        }
    }

    public final void a(Context context, String str, int i) {
        boolean z = r;
        if (!z && context == null) {
            throw new AssertionError();
        }
        if (!z && str == null) {
            throw new AssertionError();
        }
        this.a = context;
        this.p = str;
        this.q = i;
        this.o = 1048576L;
        this.n = 1048576L;
        this.m = 131072L;
        File file = new File(this.a.getCacheDir() + File.separator + "logs");
        this.j = file;
        if (!file.exists() || !this.j.isDirectory()) {
            this.j.mkdirs();
        }
        this.k = this.j.getAbsolutePath();
    }

    public final void a(String str) throws IOException {
        if (!r && str == null) {
            throw new AssertionError();
        }
        try {
            RandomAccessFile randomAccessFile = this.d;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.d = null;
            }
            RandomAccessFile randomAccessFile2 = this.f;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
                this.f = null;
            }
        } catch (Exception unused) {
        }
        try {
            File file = new File(str);
            long length = file.length();
            file.delete();
            this.n -= length;
            new File(str + ".pos").delete();
        } catch (Exception unused2) {
        }
    }
}
