package com.yandex.metrica.impl.ob;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.yandex.metrica.core.api.executors.ICommonExecutor;

/* loaded from: classes3.dex */
public class Kl extends BroadcastReceiver {
    private final InterfaceC1057km<Context, Intent> a;
    private final ICommonExecutor b;

    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ Intent b;

        a(Context context, Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Kl.this.a.a(this.a, this.b);
        }
    }

    public Kl(InterfaceC1057km<Context, Intent> interfaceC1057km, ICommonExecutor iCommonExecutor) {
        this.a = interfaceC1057km;
        this.b = iCommonExecutor;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.b.execute(new a(context, intent));
    }
}
