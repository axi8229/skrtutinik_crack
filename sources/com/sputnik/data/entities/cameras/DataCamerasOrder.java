package com.sputnik.data.entities.cameras;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataCamerasOrder.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000fJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/sputnik/data/entities/cameras/DataCamerasOrder;", "Landroid/os/Parcelable;", "", "addressId", "", "callEnabled", "", "", "Lcom/sputnik/data/entities/cameras/DataCameraObject;", "cameras", "<init>", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getAddressId", "()Ljava/lang/Integer;", "Ljava/lang/Boolean;", "getCallEnabled", "()Ljava/lang/Boolean;", "Ljava/util/Map;", "getCameras", "()Ljava/util/Map;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataCamerasOrder implements Parcelable {
    public static final Parcelable.Creator<DataCamerasOrder> CREATOR = new Creator();

    @SerializedName("address_id")
    private final Integer addressId;

    @SerializedName("call_enabled")
    private final Boolean callEnabled;

    @SerializedName("cameras")
    private final Map<String, DataCameraObject> cameras;

    /* compiled from: DataCamerasOrder.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataCamerasOrder> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataCamerasOrder createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            LinkedHashMap linkedHashMap = null;
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Boolean boolValueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            if (parcel.readInt() != 0) {
                int i = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(i);
                for (int i2 = 0; i2 != i; i2++) {
                    linkedHashMap2.put(parcel.readString(), DataCameraObject.CREATOR.createFromParcel(parcel));
                }
                linkedHashMap = linkedHashMap2;
            }
            return new DataCamerasOrder(numValueOf, boolValueOf, linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataCamerasOrder[] newArray(int i) {
            return new DataCamerasOrder[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataCamerasOrder)) {
            return false;
        }
        DataCamerasOrder dataCamerasOrder = (DataCamerasOrder) other;
        return Intrinsics.areEqual(this.addressId, dataCamerasOrder.addressId) && Intrinsics.areEqual(this.callEnabled, dataCamerasOrder.callEnabled) && Intrinsics.areEqual(this.cameras, dataCamerasOrder.cameras);
    }

    public int hashCode() {
        Integer num = this.addressId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.callEnabled;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Map<String, DataCameraObject> map = this.cameras;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "DataCamerasOrder(addressId=" + this.addressId + ", callEnabled=" + this.callEnabled + ", cameras=" + this.cameras + ")";
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
        Boolean bool = this.callEnabled;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Map<String, DataCameraObject> map = this.cameras;
        if (map == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(map.size());
        for (Map.Entry<String, DataCameraObject> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            entry.getValue().writeToParcel(parcel, flags);
        }
    }

    public DataCamerasOrder(Integer num, Boolean bool, Map<String, DataCameraObject> map) {
        this.addressId = num;
        this.callEnabled = bool;
        this.cameras = map;
    }

    public final Integer getAddressId() {
        return this.addressId;
    }

    public final Boolean getCallEnabled() {
        return this.callEnabled;
    }

    public final Map<String, DataCameraObject> getCameras() {
        return this.cameras;
    }
}
