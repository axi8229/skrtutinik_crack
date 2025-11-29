package com.yandex.metrica.networktasks.api;

import com.yandex.metrica.networktasks.impl.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public class NetworkCore extends com.yandex.metrica.networktasks.impl.c {
    private final BlockingQueue b;
    private final Object c;
    private final Object d;
    private volatile c e;
    private final e f;

    public NetworkCore() {
        this(new e());
    }

    NetworkCore(e eVar) {
        this.b = new LinkedBlockingQueue();
        this.c = new Object();
        this.d = new Object();
        this.f = eVar;
    }

    public void onDestroy() {
        synchronized (this.d) {
            try {
                c cVar = this.e;
                if (cVar != null) {
                    cVar.a.onTaskRemoved();
                }
                ArrayList arrayList = new ArrayList(this.b.size());
                this.b.drainTo(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a.onTaskRemoved();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        NetworkTask networkTask = null;
        while (isRunning()) {
            try {
                synchronized (this.d) {
                }
                this.e = (c) this.b.take();
                networkTask = this.e.a;
                networkTask.getExecutor().execute(this.f.a(networkTask, this));
                synchronized (this.d) {
                    this.e = null;
                    networkTask.onTaskFinished();
                    networkTask.onTaskRemoved();
                }
            } catch (InterruptedException unused) {
                synchronized (this.d) {
                    try {
                        this.e = null;
                        if (networkTask != null) {
                            networkTask.onTaskFinished();
                            networkTask.onTaskRemoved();
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                synchronized (this.d) {
                    try {
                        this.e = null;
                        if (networkTask != null) {
                            networkTask.onTaskFinished();
                            networkTask.onTaskRemoved();
                        }
                        throw th;
                    } finally {
                    }
                }
            }
        }
    }

    public void startTask(NetworkTask networkTask) {
        synchronized (this.c) {
            try {
                c cVar = new c(networkTask);
                if (isRunning() && !this.b.contains(cVar) && !cVar.equals(this.e) && cVar.a.onTaskAdded()) {
                    this.b.offer(cVar);
                }
            } finally {
            }
        }
    }
}
