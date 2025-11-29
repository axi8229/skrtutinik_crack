package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Ll<T> {
    private T a;
    private final ICommonExecutor b;
    private final List<E1<T>> c = new ArrayList();

    class a implements Runnable {
        final /* synthetic */ E1 a;

        a(E1 e1) {
            this.a = e1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (Ll.this) {
                try {
                    Object obj = Ll.this.a;
                    if (obj == null) {
                        Ll.this.c.add(this.a);
                    } else {
                        this.a.b(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public Ll(ICommonExecutor iCommonExecutor) {
        this.b = iCommonExecutor;
    }

    public void a(E1<T> e1) {
        this.b.execute(new a(e1));
    }

    public synchronized void a(T t) {
        try {
            this.a = t;
            Iterator<E1<T>> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().b(t);
            }
            this.c.clear();
        } catch (Throwable th) {
            throw th;
        }
    }
}
