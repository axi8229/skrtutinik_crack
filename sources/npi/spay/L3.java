package npi.spay;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class L3 extends Handler implements InterfaceC1548dj {
    public final LinkedHashMap a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L3(Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.a = new LinkedHashMap();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i = msg.what;
        if (!this.a.containsKey(Integer.valueOf(i))) {
            super.handleMessage(msg);
            return;
        }
        Runnable runnable = (Runnable) this.a.get(Integer.valueOf(i));
        if (runnable != null) {
            runnable.run();
        }
    }
}
