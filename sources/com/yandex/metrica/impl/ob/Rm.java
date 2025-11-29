package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

/* loaded from: classes3.dex */
public final class Rm {
    private static final HashMap<String, Rm> g = new HashMap<>();
    private final String a;
    private FileLock b;
    private FileChannel c;
    private final File d;
    private RandomAccessFile e;
    private Semaphore f = new Semaphore(1, true);

    private Rm(Context context, String str) {
        String str2 = str + ".lock";
        this.a = str2;
        File cacheDir = context.getCacheDir();
        File file = cacheDir == null ? null : new File(cacheDir, "appmetrica_locks");
        if (file != null) {
            file.mkdirs();
        }
        this.d = file != null ? new File(file, str2) : null;
    }

    public static synchronized Rm a(Context context, String str) {
        Rm rm;
        HashMap<String, Rm> map = g;
        rm = map.get(str);
        if (rm == null) {
            rm = new Rm(context, str);
            map.put(str, rm);
        }
        return rm;
    }

    public synchronized void b() {
        this.f.release();
        if (this.f.availablePermits() > 0) {
            L0.a(this.b);
            A2.a((Closeable) this.c);
            A2.a((Closeable) this.e);
            this.c = null;
            this.e = null;
        }
    }

    public synchronized void a() throws Throwable {
        try {
            this.f.acquire();
            if (this.d != null) {
                if (this.c == null) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(this.d, "rw");
                    this.e = randomAccessFile;
                    this.c = randomAccessFile.getChannel();
                }
                this.b = this.c.lock();
            } else {
                throw new IllegalStateException("Lock file is null");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
