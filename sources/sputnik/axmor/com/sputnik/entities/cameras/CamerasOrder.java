package sputnik.axmor.com.sputnik.entities.cameras;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.common.entities.addresses.UserAddress;
import com.sputnik.common.entities.camera.CameraObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CamerasOrder.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJF\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lsputnik/axmor/com/sputnik/entities/cameras/CamerasOrder;", "Landroid/os/Parcelable;", "", "addressId", "", "Lcom/sputnik/common/entities/camera/CameraObject;", "cameras", "", "callEnabled", "Lcom/sputnik/common/entities/addresses/UserAddress;", "address", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Lcom/sputnik/common/entities/addresses/UserAddress;)V", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Lcom/sputnik/common/entities/addresses/UserAddress;)Lsputnik/axmor/com/sputnik/entities/cameras/CamerasOrder;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getAddressId", "()Ljava/lang/Integer;", "Ljava/util/List;", "getCameras", "()Ljava/util/List;", "Ljava/lang/Boolean;", "getCallEnabled", "()Ljava/lang/Boolean;", "Lcom/sputnik/common/entities/addresses/UserAddress;", "getAddress", "()Lcom/sputnik/common/entities/addresses/UserAddress;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CamerasOrder implements Parcelable {
    public static final Parcelable.Creator<CamerasOrder> CREATOR = new Creator();
    private final UserAddress address;
    private final Integer addressId;
    private final Boolean callEnabled;
    private final List<CameraObject> cameras;

    /* compiled from: CamerasOrder.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CamerasOrder> {
        @Override // android.os.Parcelable.Creator
        public final CamerasOrder createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(parcel.readParcelable(CamerasOrder.class.getClassLoader()));
                }
            }
            return new CamerasOrder(numValueOf, arrayList, parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null, (UserAddress) parcel.readParcelable(CamerasOrder.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final CamerasOrder[] newArray(int i) {
            return new CamerasOrder[i];
        }
    }

    public CamerasOrder() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CamerasOrder copy$default(CamerasOrder camerasOrder, Integer num, List list, Boolean bool, UserAddress userAddress, int i, Object obj) {
        if ((i & 1) != 0) {
            num = camerasOrder.addressId;
        }
        if ((i & 2) != 0) {
            list = camerasOrder.cameras;
        }
        if ((i & 4) != 0) {
            bool = camerasOrder.callEnabled;
        }
        if ((i & 8) != 0) {
            userAddress = camerasOrder.address;
        }
        return camerasOrder.copy(num, list, bool, userAddress);
    }

    public final CamerasOrder copy(Integer addressId, List<CameraObject> cameras, Boolean callEnabled, UserAddress address) {
        return new CamerasOrder(addressId, cameras, callEnabled, address);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CamerasOrder)) {
            return false;
        }
        CamerasOrder camerasOrder = (CamerasOrder) other;
        return Intrinsics.areEqual(this.addressId, camerasOrder.addressId) && Intrinsics.areEqual(this.cameras, camerasOrder.cameras) && Intrinsics.areEqual(this.callEnabled, camerasOrder.callEnabled) && Intrinsics.areEqual(this.address, camerasOrder.address);
    }

    public int hashCode() {
        Integer num = this.addressId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<CameraObject> list = this.cameras;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.callEnabled;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        UserAddress userAddress = this.address;
        return iHashCode3 + (userAddress != null ? userAddress.hashCode() : 0);
    }

    public String toString() {
        return "CamerasOrder(addressId=" + this.addressId + ", cameras=" + this.cameras + ", callEnabled=" + this.callEnabled + ", address=" + this.address + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.addressId;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        List<CameraObject> list = this.cameras;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<CameraObject> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeParcelable(it.next(), flags);
            }
        }
        Boolean bool = this.callEnabled;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeParcelable(this.address, flags);
    }

    public CamerasOrder(Integer num, List<CameraObject> list, Boolean bool, UserAddress userAddress) {
        this.addressId = num;
        this.cameras = list;
        this.callEnabled = bool;
        this.address = userAddress;
    }

    public /* synthetic */ CamerasOrder(Integer num, List list, Boolean bool, UserAddress userAddress, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : userAddress);
    }

    public final Integer getAddressId() {
        return this.addressId;
    }

    public final List<CameraObject> getCameras() {
        return this.cameras;
    }

    public final Boolean getCallEnabled() {
        return this.callEnabled;
    }

    public final UserAddress getAddress() {
        return this.address;
    }
}
