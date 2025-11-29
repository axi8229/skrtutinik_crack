package sputnik.axmor.com;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface IBeaconService extends IInterface {
    boolean isTracking() throws RemoteException;

    void start(int i) throws RemoteException;

    void stop() throws RemoteException;

    void updateRssi(int i) throws RemoteException;

    public static abstract class Stub extends Binder implements IBeaconService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "sputnik.axmor.com.IBeaconService");
        }

        public static IBeaconService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("sputnik.axmor.com.IBeaconService");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IBeaconService)) {
                return (IBeaconService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("sputnik.axmor.com.IBeaconService");
            }
            if (i == 1598968902) {
                parcel2.writeString("sputnik.axmor.com.IBeaconService");
                return true;
            }
            if (i == 1) {
                start(parcel.readInt());
                parcel2.writeNoException();
            } else if (i == 2) {
                updateRssi(parcel.readInt());
                parcel2.writeNoException();
            } else if (i == 3) {
                stop();
                parcel2.writeNoException();
            } else if (i == 4) {
                boolean zIsTracking = isTracking();
                parcel2.writeNoException();
                parcel2.writeInt(zIsTracking ? 1 : 0);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        private static class Proxy implements IBeaconService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // sputnik.axmor.com.IBeaconService
            public void start(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("sputnik.axmor.com.IBeaconService");
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // sputnik.axmor.com.IBeaconService
            public void updateRssi(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("sputnik.axmor.com.IBeaconService");
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // sputnik.axmor.com.IBeaconService
            public void stop() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("sputnik.axmor.com.IBeaconService");
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // sputnik.axmor.com.IBeaconService
            public boolean isTracking() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("sputnik.axmor.com.IBeaconService");
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
