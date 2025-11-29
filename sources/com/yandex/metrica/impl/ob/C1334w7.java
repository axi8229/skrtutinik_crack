package com.yandex.metrica.impl.ob;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.yandex.metrica.impl.ac.CrashpadServiceHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.w7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1334w7 {
    private final String a;
    private LocalServerSocket b;
    private volatile boolean c;
    private final B7 d;
    private final InterfaceC1107mm<String> e;
    private final String f;
    private List<InterfaceC1107mm<String>> g;
    private final Thread h;

    /* renamed from: com.yandex.metrica.impl.ob.w7$a */
    class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (C1334w7.this.c) {
                try {
                    LocalSocket localSocketAccept = C1334w7.this.b.accept();
                    byte[] bArr = new byte[256];
                    int i = localSocketAccept.getInputStream().read(bArr);
                    localSocketAccept.close();
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    C1334w7.a(C1334w7.this, new String(bArr2));
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.w7$b */
    class b implements InterfaceC1107mm<String> {
        b() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(String str) {
            CrashpadServiceHelper.setUpServiceHelper(str);
        }
    }

    public C1334w7(String str, String str2) {
        this(str, str2, B7.a(), new b());
    }

    C1334w7(String str, String str2, B7 b7, InterfaceC1107mm<String> interfaceC1107mm) {
        this.c = false;
        this.g = new LinkedList();
        this.h = new a();
        this.a = str;
        this.f = str2;
        this.d = b7;
        this.e = interfaceC1107mm;
    }

    public void a(InterfaceC1107mm<String> interfaceC1107mm) {
        synchronized (this) {
            this.g.add(interfaceC1107mm);
        }
        if (this.c || this.f == null) {
            return;
        }
        synchronized (this) {
            if (!this.c) {
                try {
                    if (this.d.b()) {
                        this.b = new LocalServerSocket(this.a);
                        this.c = true;
                        this.e.b(this.f);
                        this.h.start();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void b(InterfaceC1107mm<String> interfaceC1107mm) {
        this.g.remove(interfaceC1107mm);
    }

    static void a(C1334w7 c1334w7, String str) {
        synchronized (c1334w7) {
            Iterator<InterfaceC1107mm<String>> it = c1334w7.g.iterator();
            while (it.hasNext()) {
                it.next().b(str);
            }
        }
    }
}
