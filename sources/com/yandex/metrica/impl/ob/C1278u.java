package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.C1183q;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1278u implements C1183q.b {
    private final List<E1<C1010j0>> a;
    private volatile C1010j0 b;
    private final C1183q c;
    private final ICommonExecutor d;

    /* renamed from: com.yandex.metrica.impl.ob.u$a */
    class a implements E1<C1010j0> {
        final /* synthetic */ String a;

        a(C1278u c1278u, String str) {
            this.a = str;
        }

        @Override // com.yandex.metrica.impl.ob.E1
        public void b(C1010j0 c1010j0) {
            c1010j0.b(this.a);
        }
    }

    public C1278u(ICommonExecutor iCommonExecutor) {
        this(iCommonExecutor, P.g().b());
    }

    public void a() {
        this.c.a(this, C1183q.a.CREATED);
    }

    C1278u(ICommonExecutor iCommonExecutor, C1183q c1183q) {
        this.a = new ArrayList();
        this.b = null;
        this.d = iCommonExecutor;
        this.c = c1183q;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c A[LOOP:0: B:9:0x0016->B:11:0x001c, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.yandex.metrica.impl.ob.C1010j0 r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.b = r3     // Catch: java.lang.Throwable -> L27
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L27
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L29
            java.util.List<com.yandex.metrica.impl.ob.E1<com.yandex.metrica.impl.ob.j0>> r1 = r2.a     // Catch: java.lang.Throwable -> L29
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L29
            java.util.List<com.yandex.metrica.impl.ob.E1<com.yandex.metrica.impl.ob.j0>> r1 = r2.a     // Catch: java.lang.Throwable -> L29
            r1.clear()     // Catch: java.lang.Throwable -> L29
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L27
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L27
            java.util.Iterator r0 = r0.iterator()
        L16:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L26
            java.lang.Object r1 = r0.next()
            com.yandex.metrica.impl.ob.E1 r1 = (com.yandex.metrica.impl.ob.E1) r1
            r1.b(r3)
            goto L16
        L26:
            return
        L27:
            r3 = move-exception
            goto L2c
        L29:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L27
            throw r3     // Catch: java.lang.Throwable -> L27
        L2c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L27
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C1278u.a(com.yandex.metrica.impl.ob.j0):void");
    }

    @Override // com.yandex.metrica.impl.ob.C1183q.b
    public void a(Activity activity, C1183q.a aVar) {
        Intent intent;
        if (activity != null) {
            try {
                intent = activity.getIntent();
            } catch (Throwable unused) {
            }
        } else {
            intent = null;
        }
        String dataString = intent != null ? intent.getDataString() : null;
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        a aVar2 = new a(this, dataString);
        synchronized (this) {
            try {
                C1010j0 c1010j0 = this.b;
                if (c1010j0 == null) {
                    this.a.add(aVar2);
                } else {
                    this.d.execute(new RunnableC1254t(this, aVar2, c1010j0));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
