package zone.bi.mobile.fingerprint.impl.cs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes5.dex */
public class FpWorkerService extends Service {
    public final c a = new c(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.a;
    }
}
