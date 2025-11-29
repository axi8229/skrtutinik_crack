package com.sputnik.data.entities.market.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.market.services.ServiceState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataService.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0010R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b*\u0010\u0010R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/sputnik/data/entities/market/service/DataService;", "Landroid/os/Parcelable;", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "state", "", "serviceConfigIdentifier", "Lcom/sputnik/data/entities/market/service/DataServiceAppearance;", "appearance", "Lcom/sputnik/data/entities/market/service/DataOriginSub;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "activatedAt", "", "requiresSubscription", "<init>", "(Lcom/sputnik/domain/entities/market/services/ServiceState;Ljava/lang/String;Lcom/sputnik/data/entities/market/service/DataServiceAppearance;Lcom/sputnik/data/entities/market/service/DataOriginSub;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "getState", "()Lcom/sputnik/domain/entities/market/services/ServiceState;", "Ljava/lang/String;", "getServiceConfigIdentifier", "Lcom/sputnik/data/entities/market/service/DataServiceAppearance;", "getAppearance", "()Lcom/sputnik/data/entities/market/service/DataServiceAppearance;", "Lcom/sputnik/data/entities/market/service/DataOriginSub;", "getOrigin", "()Lcom/sputnik/data/entities/market/service/DataOriginSub;", "getActivatedAt", "Ljava/lang/Boolean;", "getRequiresSubscription", "()Ljava/lang/Boolean;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataService implements Parcelable {
    public static final Parcelable.Creator<DataService> CREATOR = new Creator();

    @SerializedName("activated_at")
    private final String activatedAt;
    private final DataServiceAppearance appearance;
    private final DataOriginSub origin;

    @SerializedName("requires_subscription")
    private final Boolean requiresSubscription;

    @SerializedName("service_config_identifier")
    private final String serviceConfigIdentifier;
    private final ServiceState state;

    /* compiled from: DataService.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataService> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataService createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ServiceState serviceStateValueOf = ServiceState.valueOf(parcel.readString());
            String string = parcel.readString();
            DataServiceAppearance dataServiceAppearanceCreateFromParcel = parcel.readInt() == 0 ? null : DataServiceAppearance.CREATOR.createFromParcel(parcel);
            DataOriginSub dataOriginSubCreateFromParcel = parcel.readInt() == 0 ? null : DataOriginSub.CREATOR.createFromParcel(parcel);
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DataService(serviceStateValueOf, string, dataServiceAppearanceCreateFromParcel, dataOriginSubCreateFromParcel, string2, boolValueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataService[] newArray(int i) {
            return new DataService[i];
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
        if (!(other instanceof DataService)) {
            return false;
        }
        DataService dataService = (DataService) other;
        return this.state == dataService.state && Intrinsics.areEqual(this.serviceConfigIdentifier, dataService.serviceConfigIdentifier) && Intrinsics.areEqual(this.appearance, dataService.appearance) && Intrinsics.areEqual(this.origin, dataService.origin) && Intrinsics.areEqual(this.activatedAt, dataService.activatedAt) && Intrinsics.areEqual(this.requiresSubscription, dataService.requiresSubscription);
    }

    public int hashCode() {
        int iHashCode = this.state.hashCode() * 31;
        String str = this.serviceConfigIdentifier;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        DataServiceAppearance dataServiceAppearance = this.appearance;
        int iHashCode3 = (iHashCode2 + (dataServiceAppearance == null ? 0 : dataServiceAppearance.hashCode())) * 31;
        DataOriginSub dataOriginSub = this.origin;
        int iHashCode4 = (iHashCode3 + (dataOriginSub == null ? 0 : dataOriginSub.hashCode())) * 31;
        String str2 = this.activatedAt;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.requiresSubscription;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "DataService(state=" + this.state + ", serviceConfigIdentifier=" + this.serviceConfigIdentifier + ", appearance=" + this.appearance + ", origin=" + this.origin + ", activatedAt=" + this.activatedAt + ", requiresSubscription=" + this.requiresSubscription + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.state.name());
        parcel.writeString(this.serviceConfigIdentifier);
        DataServiceAppearance dataServiceAppearance = this.appearance;
        if (dataServiceAppearance == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataServiceAppearance.writeToParcel(parcel, flags);
        }
        DataOriginSub dataOriginSub = this.origin;
        if (dataOriginSub == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataOriginSub.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.activatedAt);
        Boolean bool = this.requiresSubscription;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public DataService(ServiceState state, String str, DataServiceAppearance dataServiceAppearance, DataOriginSub dataOriginSub, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.serviceConfigIdentifier = str;
        this.appearance = dataServiceAppearance;
        this.origin = dataOriginSub;
        this.activatedAt = str2;
        this.requiresSubscription = bool;
    }

    public final ServiceState getState() {
        return this.state;
    }

    public final String getServiceConfigIdentifier() {
        return this.serviceConfigIdentifier;
    }

    public final DataServiceAppearance getAppearance() {
        return this.appearance;
    }

    public final DataOriginSub getOrigin() {
        return this.origin;
    }

    public final String getActivatedAt() {
        return this.activatedAt;
    }

    public final Boolean getRequiresSubscription() {
        return this.requiresSubscription;
    }
}
