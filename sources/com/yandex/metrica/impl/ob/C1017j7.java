package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.j7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1017j7 {
    private String a;
    private final Context b;
    private final List<InterfaceC1042k7> c;
    private final C0818b7 d;
    private boolean e;
    private boolean f;
    private InterfaceC1042k7 g;
    private final B0 h;

    public C1017j7(Context context, A3 a3) {
        this(context, A2.a(21) ? Arrays.asList(new A7(context, a3), new C1142o7()) : Collections.singletonList(new C1142o7()), new B0(), new C0818b7());
    }

    private void a() {
        InterfaceC1042k7 next;
        if (!this.f) {
            Iterator<InterfaceC1042k7> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                try {
                    C0818b7 c0818b7 = this.d;
                    String strC = next.c();
                    c0818b7.getClass();
                    System.loadLibrary(strC);
                    break;
                } catch (Throwable unused) {
                }
            }
            this.g = next;
            if (next != null) {
                try {
                    next.a(false);
                } catch (Throwable unused2) {
                }
                this.a = this.h.b(this.b, this.g.a());
            }
        }
        this.f = true;
    }

    C1017j7(Context context, List<InterfaceC1042k7> list, B0 b0, C0818b7 c0818b7) {
        this.b = context;
        this.c = list;
        this.h = b0;
        this.d = c0818b7;
    }

    public synchronized void a(boolean z, String str, String str2) {
        String str3;
        try {
            if (z) {
                a();
                synchronized (this) {
                    InterfaceC1042k7 interfaceC1042k7 = this.g;
                    if ((interfaceC1042k7 != null) && (str3 = this.a) != null && !this.e) {
                        interfaceC1042k7.a(str, str3, str2);
                        this.e = true;
                    }
                }
            } else {
                synchronized (this) {
                    synchronized (this) {
                        InterfaceC1042k7 interfaceC1042k72 = this.g;
                        if ((interfaceC1042k72 != null) && this.e) {
                            interfaceC1042k72.b();
                        }
                        this.e = false;
                    }
                }
            }
        } catch (Throwable unused) {
            this.e = false;
        } finally {
        }
    }

    public void a(String str) {
        InterfaceC1042k7 interfaceC1042k7 = this.g;
        if (interfaceC1042k7 != null) {
            interfaceC1042k7.a(str);
        }
    }
}
