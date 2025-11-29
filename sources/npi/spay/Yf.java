package npi.spay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Yf extends BroadcastReceiver {
    public final A3 a;

    public Yf(A3 result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.a = result;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String it;
        A3 a3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -3956105) {
                it = "action_permissions_granted";
                if (!action.equals("action_permissions_granted")) {
                    return;
                }
                a3 = this.a;
                a3.getClass();
            } else {
                if (iHashCode != 456550495) {
                    return;
                }
                it = "action_permissions_denied";
                if (!action.equals("action_permissions_denied")) {
                    return;
                }
                a3 = this.a;
                a3.getClass();
            }
            Intrinsics.checkNotNullParameter(it, "it");
            a3.a.invoke(it);
            Unit unit = Unit.INSTANCE;
            context.unregisterReceiver(this);
        }
    }
}
