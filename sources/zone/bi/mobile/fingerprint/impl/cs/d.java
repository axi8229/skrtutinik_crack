package zone.bi.mobile.fingerprint.impl.cs;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes5.dex */
public final class d implements e {
    public final IBinder a;

    public d(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // zone.bi.mobile.fingerprint.impl.cs.e
    public final int a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("zone.bi.mobile.fingerprint.impl.cs.IFpWorkerService");
            if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                int i = c.$r8$clinit;
            }
            parcelObtain2.readException();
            int i2 = parcelObtain2.readInt();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return i2;
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
