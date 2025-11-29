package bz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.ExecutorService;

/* renamed from: bz.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0553t extends BroadcastReceiver {
    public final InterfaceC0550s a;

    public C0553t(InterfaceC0550s interfaceC0550s) {
        this.a = interfaceC0550s;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REMOVED")) {
            N0 n0 = (N0) this.a;
            ExecutorService executorService = S0.o;
            n0.getClass();
            executorService.execute(new M0(n0));
        }
    }
}
