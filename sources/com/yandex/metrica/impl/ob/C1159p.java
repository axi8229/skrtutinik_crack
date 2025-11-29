package com.yandex.metrica.impl.ob;

import android.app.Activity;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.C1183q;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.yandex.metrica.impl.ob.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1159p implements C1183q.b {
    private final Set<b> a = new HashSet();
    private final ICommonExecutor b;

    /* renamed from: com.yandex.metrica.impl.ob.p$a */
    class a implements Runnable {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1159p.this.a(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.p$b */
    public interface b {
        void a(Activity activity);
    }

    public C1159p(C1183q c1183q, ICommonExecutor iCommonExecutor) {
        this.b = iCommonExecutor;
        c1183q.a(this, new C1183q.a[0]);
    }

    public synchronized void a(b bVar) {
        this.a.add(bVar);
    }

    public void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(activity);
        }
    }

    @Override // com.yandex.metrica.impl.ob.C1183q.b
    public void a(Activity activity, C1183q.a aVar) {
        this.b.execute(new a(activity));
    }
}
