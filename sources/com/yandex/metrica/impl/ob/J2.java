package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.C0811b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class J2 implements InterfaceC1062l2 {
    private final List<InterfaceC1082lm<Context, Intent, Void>> a;
    private boolean b;
    private boolean c;
    private final Context d;
    private final C0811b0 e;

    class a implements InterfaceC1057km<Context, Intent> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1057km
        public void a(Context context, Intent intent) {
            J2.a(J2.this, context, intent);
        }
    }

    public J2(Context context, ICommonExecutor iCommonExecutor) {
        this(context, iCommonExecutor, new C0811b0.a());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
    public synchronized void a() {
        this.c = true;
        if (!this.a.isEmpty()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.e.a(this.d, intentFilter);
            this.b = true;
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
    public synchronized void b() {
        this.c = false;
        if (this.b) {
            this.e.a(this.d);
            this.b = false;
        }
    }

    J2(Context context, ICommonExecutor iCommonExecutor, C0811b0.a aVar) {
        this.a = new ArrayList();
        this.b = false;
        this.c = false;
        this.d = context;
        this.e = aVar.a(new Kl(new a(), iCommonExecutor));
    }

    public synchronized void b(InterfaceC1082lm<Context, Intent, Void> interfaceC1082lm) {
        this.a.remove(interfaceC1082lm);
        if (this.a.isEmpty() && this.b) {
            this.e.a(this.d);
            this.b = false;
        }
    }

    public synchronized void a(InterfaceC1082lm<Context, Intent, Void> interfaceC1082lm) {
        this.a.add(interfaceC1082lm);
        if (this.c && !this.b) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.e.a(this.d, intentFilter);
            this.b = true;
        }
    }

    static void a(J2 j2, Context context, Intent intent) {
        synchronized (j2) {
            Iterator<InterfaceC1082lm<Context, Intent, Void>> it = j2.a.iterator();
            while (it.hasNext()) {
                it.next().a(context, intent);
            }
        }
    }
}
