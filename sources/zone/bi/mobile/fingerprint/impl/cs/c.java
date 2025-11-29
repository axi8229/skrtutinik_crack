package zone.bi.mobile.fingerprint.impl.cs;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import bz.AbstractC0507d1;
import bz.C0519h1;
import zone.bi.mobile.fingerprint.impl.ntl.Brg;

/* loaded from: classes5.dex */
public final class c extends Binder implements e {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final /* synthetic */ FpWorkerService a;

    public c(FpWorkerService fpWorkerService) {
        this.a = fpWorkerService;
        attachInterface(this, "zone.bi.mobile.fingerprint.impl.cs.IFpWorkerService");
    }

    @Override // android.os.Binder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1598968902) {
            parcel2.writeString("zone.bi.mobile.fingerprint.impl.cs.IFpWorkerService");
            return true;
        }
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface("zone.bi.mobile.fingerprint.impl.cs.IFpWorkerService");
        int iA = a();
        parcel2.writeNoException();
        parcel2.writeInt(iA);
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // zone.bi.mobile.fingerprint.impl.cs.e
    public final int a() {
        C0519h1 c0519h1A = AbstractC0507d1.a();
        if (!c0519h1A.a()) {
            Context applicationContext = this.a.getApplicationContext();
            synchronized (c0519h1A) {
                if (!c0519h1A.a()) {
                    c0519h1A.a.getClass();
                    Brg brg = new Brg();
                    if (brg.a(applicationContext)) {
                        c0519h1A.b = brg;
                    }
                }
            }
        }
        if (c0519h1A.a()) {
            return c0519h1A.b().a();
        }
        return -1;
    }
}
