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
public class C implements InterfaceC1062l2 {
    private final List<InterfaceC1107mm<Intent>> a;
    private Intent b;
    private final Context c;
    private final C0811b0 d;

    class a implements InterfaceC1057km<Context, Intent> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1057km
        public void a(Context context, Intent intent) {
            Intent intent2 = intent;
            synchronized (C.this) {
                C.this.b = intent2;
                C.this.a(intent2);
            }
        }
    }

    public C(Context context, ICommonExecutor iCommonExecutor) {
        this(context, iCommonExecutor, new C0811b0.a());
    }

    public synchronized Intent c(InterfaceC1107mm<Intent> interfaceC1107mm) {
        this.a.add(interfaceC1107mm);
        return this.b;
    }

    C(Context context, ICommonExecutor iCommonExecutor, C0811b0.a aVar) {
        this.a = new ArrayList();
        this.b = null;
        this.c = context;
        this.d = aVar.a(new Kl(new a(), iCommonExecutor));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
    public synchronized void a() {
        Intent intentA = this.d.a(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.b = intentA;
        a(intentA);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
    public synchronized void b() {
        this.b = null;
        this.d.a(this.c);
        a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent) {
        Iterator<InterfaceC1107mm<Intent>> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(intent);
        }
    }
}
