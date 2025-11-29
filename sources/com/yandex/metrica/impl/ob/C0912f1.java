package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.f1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0912f1 {
    private final InterfaceC1141o6 a;
    private final J2 b;
    private final C c;
    private final C1326w d;
    private final List<InterfaceC1062l2> e;

    public C0912f1(Context context, ICommonExecutor iCommonExecutor) {
        this(A2.a(21) ? new C1166p6(context) : new C1190q6(), new J2(context, iCommonExecutor), new C(context, iCommonExecutor), new C1326w());
    }

    public synchronized void a(InterfaceC1062l2 interfaceC1062l2) {
        this.e.add(interfaceC1062l2);
    }

    public C b() {
        return this.c;
    }

    public InterfaceC1141o6 c() {
        return this.a;
    }

    public J2 d() {
        return this.b;
    }

    public synchronized void e() {
        Iterator<InterfaceC1062l2> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public synchronized void f() {
        Iterator<InterfaceC1062l2> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public C1326w a() {
        return this.d;
    }

    C0912f1(InterfaceC1141o6 interfaceC1141o6, J2 j2, C c, C1326w c1326w) {
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        this.a = interfaceC1141o6;
        arrayList.add(interfaceC1141o6);
        this.b = j2;
        arrayList.add(j2);
        this.c = c;
        arrayList.add(c);
        this.d = c1326w;
        arrayList.add(c1326w);
    }
}
