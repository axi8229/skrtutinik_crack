package zone.bi.mobile.fingerprint.impl.cs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public final class a implements ServiceConnection {
    public final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e dVar;
        e eVar;
        int iA;
        b bVar = this.a;
        int i = c.$r8$clinit;
        if (iBinder == null) {
            dVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("zone.bi.mobile.fingerprint.impl.cs.IFpWorkerService");
            dVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof e)) ? new d(iBinder) : (e) iInterfaceQueryLocalInterface;
        }
        bVar.c = dVar;
        b bVar2 = this.a;
        bVar2.d = true;
        if (bVar2.b == null || (eVar = bVar2.c) == null) {
            return;
        }
        try {
            iA = eVar.a();
        } catch (RemoteException unused) {
            iA = -1;
        }
        bVar2.b.a(iA);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        b bVar = this.a;
        bVar.d = false;
        bVar.c = null;
    }
}
