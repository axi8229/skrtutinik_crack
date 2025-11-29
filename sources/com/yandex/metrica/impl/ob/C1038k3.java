package com.yandex.metrica.impl.ob;

import android.os.Looper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.yandex.metrica.impl.ob.k3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1038k3 {
    private final c a;
    private final InterfaceC1082lm<Thread, StackTraceElement[], E6> b;
    private final InterfaceC0833bm c;

    /* renamed from: com.yandex.metrica.impl.ob.k3$a */
    class a implements c {
        a() {
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.k3$b */
    class b implements Comparator<Thread> {
        b(C1038k3 c1038k3) {
        }

        @Override // java.util.Comparator
        public int compare(Thread thread, Thread thread2) {
            Thread thread3 = thread;
            Thread thread4 = thread2;
            if (thread3 != thread4) {
                String name = thread3.getName();
                String name2 = thread4.getName();
                if (name != null) {
                    if (name2 == null) {
                        return 1;
                    }
                    return name.compareTo(name2);
                }
                if (name2 != null) {
                    return -1;
                }
            }
            return 0;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.k3$c */
    interface c {
    }

    public C1038k3() {
        this(new a(), new C1013j3(), P.g().j());
    }

    public C1333w6 a() {
        StackTraceElement[] stackTrace;
        ((a) this.a).getClass();
        Thread thread = Looper.getMainLooper().getThread();
        try {
            stackTrace = thread.getStackTrace();
        } catch (SecurityException unused) {
            stackTrace = null;
        }
        return new C1333w6(this.b.a(thread, stackTrace), a(thread, null), ((Xl) this.c).b());
    }

    C1038k3(c cVar, InterfaceC1082lm<Thread, StackTraceElement[], E6> interfaceC1082lm, InterfaceC0833bm interfaceC0833bm) {
        this.a = cVar;
        this.b = interfaceC1082lm;
        this.c = interfaceC0833bm;
    }

    public List<E6> a(Thread thread) {
        StackTraceElement[] stackTrace;
        ((a) this.a).getClass();
        Thread thread2 = Looper.getMainLooper().getThread();
        List<E6> listA = a(thread2, thread);
        if (thread != thread2) {
            try {
                stackTrace = thread2.getStackTrace();
            } catch (SecurityException unused) {
                stackTrace = null;
            }
            ((ArrayList) listA).add(0, this.b.a(thread2, stackTrace));
        }
        return listA;
    }

    private List<E6> a(Thread thread, Thread thread2) {
        Map<Thread, StackTraceElement[]> allStackTraces;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new b(this));
        try {
            ((a) this.a).getClass();
            allStackTraces = Thread.getAllStackTraces();
        } catch (SecurityException unused) {
            allStackTraces = null;
        }
        if (allStackTraces != null) {
            treeMap.putAll(allStackTraces);
        }
        if (thread2 != null) {
            treeMap.remove(thread2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread3 = (Thread) entry.getKey();
            if (thread3 != thread && thread3 != thread2) {
                arrayList.add(this.b.a(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }
}
