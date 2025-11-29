package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* renamed from: com.yandex.metrica.impl.ob.tm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1277tm {
    private final Context a;
    private final String b;
    private final B0 c;
    private File d;
    private FileLock e;
    private RandomAccessFile f;
    private FileChannel g;
    private int h;

    public C1277tm(Context context, String str) {
        this(context, str, new B0());
    }

    public synchronized void a() throws Throwable {
        try {
            File fileB = this.c.b(this.a.getFilesDir(), this.b);
            this.d = fileB;
            if (fileB == null) {
                throw new IllegalStateException("Cannot create lock file");
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.d, "rw");
            this.f = randomAccessFile;
            FileChannel channel = randomAccessFile.getChannel();
            this.g = channel;
            if (this.h == 0) {
                this.e = channel.lock();
            }
            this.h++;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b() {
        try {
            File file = this.d;
            if (file != null) {
                file.getAbsolutePath();
            }
            int i = this.h - 1;
            this.h = i;
            if (i == 0) {
                L0.a(this.e);
            }
            A2.a((Closeable) this.f);
            A2.a((Closeable) this.g);
            this.f = null;
            this.e = null;
            this.g = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void c() {
        b();
        File file = this.d;
        if (file != null) {
            file.delete();
        }
    }

    C1277tm(Context context, String str, B0 b0) {
        this.h = 0;
        this.a = context;
        this.b = str + ".lock";
        this.c = b0;
    }
}
