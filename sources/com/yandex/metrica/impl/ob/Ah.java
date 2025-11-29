package com.yandex.metrica.impl.ob;

import android.net.Uri;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class Ah {
    final Socket a;
    final Gh b;
    final C0879di c;
    final Uri d;
    final Hh e;

    Ah(Socket socket, Uri uri, Gh gh, C0879di c0879di, Hh hh) {
        this.a = socket;
        this.d = uri;
        this.b = gh;
        this.c = c0879di;
        this.e = hh;
    }

    abstract void a();

    void a(String str, Map<String, String> map, byte[] bArr) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        this.e.b();
        OutputStream outputStream = null;
        OutputStream outputStream2 = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(this.a.getOutputStream());
                try {
                    bufferedOutputStream.write(str.getBytes());
                    a(bufferedOutputStream);
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        a(bufferedOutputStream, key, entry.getValue());
                        outputStream2 = key;
                    }
                    a(bufferedOutputStream);
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    this.e.c();
                    ((Jh) this.b).b(this.a.getLocalPort(), this.e);
                    outputStream = outputStream2;
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream2 = bufferedOutputStream;
                    ((Jh) this.b).a("io_exception_during_sync", e);
                    bufferedOutputStream = bufferedOutputStream2;
                    outputStream = bufferedOutputStream2;
                    A2.a((Closeable) bufferedOutputStream);
                } catch (Throwable th) {
                    th = th;
                    outputStream = bufferedOutputStream;
                    A2.a((Closeable) outputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            A2.a((Closeable) bufferedOutputStream);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(OutputStream outputStream, String str, String str2) throws IOException {
        outputStream.write((str + ": " + str2).getBytes());
        a(outputStream);
    }

    private void a(OutputStream outputStream) throws IOException {
        outputStream.write("\r\n".getBytes());
    }
}
