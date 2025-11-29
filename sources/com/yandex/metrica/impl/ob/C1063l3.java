package com.yandex.metrica.impl.ob;

import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.yandex.metrica.impl.ob.l3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1063l3 {
    private final Lm a;
    private final BlockingQueue<b> b = new LinkedBlockingQueue();
    private ConcurrentHashMap<Class, CopyOnWriteArrayList<C1163p3<? extends C1113n3>>> c = new ConcurrentHashMap<>();
    private WeakHashMap<Object, CopyOnWriteArrayList<d>> d = new WeakHashMap<>();
    private ConcurrentHashMap<Class, C1113n3> e = new ConcurrentHashMap<>();

    /* renamed from: com.yandex.metrica.impl.ob.l3$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                C1063l3.this.getClass();
                try {
                    ((b) C1063l3.this.b.take()).a();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.l3$b */
    private static class b {
        private final C1113n3 a;
        private final C1163p3<? extends C1113n3> b;

        /* synthetic */ b(C1113n3 c1113n3, C1163p3 c1163p3, a aVar) {
            this(c1113n3, c1163p3);
        }

        void a() {
            try {
                if (this.b.a(this.a)) {
                    return;
                }
                this.b.b(this.a);
            } catch (Throwable unused) {
            }
        }

        private b(C1113n3 c1113n3, C1163p3<? extends C1113n3> c1163p3) {
            this.a = c1113n3;
            this.b = c1163p3;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.l3$c */
    private static final class c {
        private static final C1063l3 a = new C1063l3();
    }

    /* renamed from: com.yandex.metrica.impl.ob.l3$d */
    private static class d {
        final CopyOnWriteArrayList<C1163p3<? extends C1113n3>> a;
        final C1163p3<? extends C1113n3> b;

        /* synthetic */ d(CopyOnWriteArrayList copyOnWriteArrayList, C1163p3 c1163p3, a aVar) {
            this(copyOnWriteArrayList, c1163p3);
        }

        protected void finalize() throws Throwable {
            super.finalize();
            this.a.remove(this.b);
        }

        private d(CopyOnWriteArrayList<C1163p3<? extends C1113n3>> copyOnWriteArrayList, C1163p3<? extends C1113n3> c1163p3) {
            this.a = copyOnWriteArrayList;
            this.b = c1163p3;
        }
    }

    C1063l3() {
        Lm lmA = Mm.a("YMM-BD", new a());
        this.a = lmA;
        lmA.start();
    }

    public static final C1063l3 a() {
        return c.a;
    }

    public synchronized void a(C1113n3 c1113n3) {
        synchronized (this) {
            CopyOnWriteArrayList<C1163p3<? extends C1113n3>> copyOnWriteArrayList = this.c.get(c1113n3.getClass());
            if (copyOnWriteArrayList != null) {
                Iterator<C1163p3<? extends C1113n3>> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    this.b.add(new b(c1113n3, it.next(), null));
                }
            }
        }
        this.e.put(c1113n3.getClass(), c1113n3);
    }

    public synchronized void a(Object obj, Class cls, C1163p3<? extends C1113n3> c1163p3) {
        try {
            CopyOnWriteArrayList<C1163p3<? extends C1113n3>> copyOnWriteArrayList = this.c.get(cls);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.c.put(cls, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(c1163p3);
            CopyOnWriteArrayList<d> copyOnWriteArrayList2 = this.d.get(obj);
            if (copyOnWriteArrayList2 == null) {
                copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                this.d.put(obj, copyOnWriteArrayList2);
            }
            a aVar = null;
            copyOnWriteArrayList2.add(new d(copyOnWriteArrayList, c1163p3, aVar));
            C1113n3 c1113n3 = this.e.get(cls);
            if (c1113n3 != null) {
                this.b.add(new b(c1113n3, c1163p3, aVar));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(Object obj) {
        CopyOnWriteArrayList<d> copyOnWriteArrayListRemove = this.d.remove(obj);
        if (copyOnWriteArrayListRemove != null) {
            for (d dVar : copyOnWriteArrayListRemove) {
                dVar.a.remove(dVar.b);
            }
        }
    }
}
