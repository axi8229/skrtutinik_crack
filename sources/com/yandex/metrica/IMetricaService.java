package com.yandex.metrica;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IMetricaService extends IInterface {
    void a(int i, Bundle bundle) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void b(Bundle bundle) throws RemoteException;

    void reportData(Bundle bundle) throws RemoteException;

    public static abstract class a extends Binder implements IMetricaService {
        public static final /* synthetic */ int $r8$clinit = 0;

        public a() {
            attachInterface(this, "com.yandex.metrica.IMetricaService");
        }

        public static IMetricaService a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.yandex.metrica.IMetricaService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMetricaService)) ? new C0278a(iBinder) : (IMetricaService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.yandex.metrica.IMetricaService");
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface("com.yandex.metrica.IMetricaService");
                MetricaService.c.a(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.yandex.metrica.IMetricaService");
                MetricaService.c.reportData(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.yandex.metrica.IMetricaService");
                MetricaService.c.b(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.yandex.metrica.IMetricaService");
                MetricaService.c.a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.yandex.metrica.IMetricaService");
            MetricaService.c.a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            return true;
        }

        /* renamed from: com.yandex.metrica.IMetricaService$a$a, reason: collision with other inner class name */
        private static class C0278a implements IMetricaService {
            private IBinder a;

            C0278a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // com.yandex.metrica.IMetricaService
            public void a(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.yandex.metrica.IMetricaService");
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    if (!this.a.transact(4, parcelObtain, null, 1)) {
                        int i = a.$r8$clinit;
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.yandex.metrica.IMetricaService
            public void b(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.yandex.metrica.IMetricaService");
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    if (!this.a.transact(3, parcelObtain, null, 1)) {
                        int i = a.$r8$clinit;
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.yandex.metrica.IMetricaService
            public void reportData(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.yandex.metrica.IMetricaService");
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    if (!this.a.transact(2, parcelObtain, null, 1)) {
                        int i = a.$r8$clinit;
                    }
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // com.yandex.metrica.IMetricaService
            public void a(int i, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.yandex.metrica.IMetricaService");
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.a.transact(5, parcelObtain, null, 1)) {
                        int i2 = a.$r8$clinit;
                    }
                    parcelObtain.recycle();
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }
    }
}
