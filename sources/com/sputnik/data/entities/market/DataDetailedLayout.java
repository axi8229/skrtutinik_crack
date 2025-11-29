package com.sputnik.data.entities.market;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.data.entities.subscriptions.subscriptions.DataNoticeBody;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataDetailedLayout.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/sputnik/data/entities/market/DataDetailedLayout;", "Landroid/os/Parcelable;", "Lcom/sputnik/data/entities/market/DataHeader;", "header", "Lcom/sputnik/data/entities/market/DataFeatures;", "features", "Lcom/sputnik/data/entities/market/DataIncludedServices;", "includedServices", "Lcom/sputnik/data/entities/market/DataAppearancePlans;", "plans", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataNoticeBody;", "notice", "<init>", "(Lcom/sputnik/data/entities/market/DataHeader;Lcom/sputnik/data/entities/market/DataFeatures;Lcom/sputnik/data/entities/market/DataIncludedServices;Lcom/sputnik/data/entities/market/DataAppearancePlans;Lcom/sputnik/data/entities/subscriptions/subscriptions/DataNoticeBody;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/data/entities/market/DataHeader;", "getHeader", "()Lcom/sputnik/data/entities/market/DataHeader;", "Lcom/sputnik/data/entities/market/DataFeatures;", "getFeatures", "()Lcom/sputnik/data/entities/market/DataFeatures;", "Lcom/sputnik/data/entities/market/DataIncludedServices;", "getIncludedServices", "()Lcom/sputnik/data/entities/market/DataIncludedServices;", "Lcom/sputnik/data/entities/market/DataAppearancePlans;", "getPlans", "()Lcom/sputnik/data/entities/market/DataAppearancePlans;", "Lcom/sputnik/data/entities/subscriptions/subscriptions/DataNoticeBody;", "getNotice", "()Lcom/sputnik/data/entities/subscriptions/subscriptions/DataNoticeBody;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataDetailedLayout implements Parcelable {
    public static final Parcelable.Creator<DataDetailedLayout> CREATOR = new Creator();
    private final DataFeatures features;
    private final DataHeader header;

    @SerializedName("included_services")
    private final DataIncludedServices includedServices;
    private final DataNoticeBody notice;
    private final DataAppearancePlans plans;

    /* compiled from: DataDetailedLayout.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataDetailedLayout> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataDetailedLayout createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataDetailedLayout(parcel.readInt() == 0 ? null : DataHeader.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : DataFeatures.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : DataIncludedServices.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : DataAppearancePlans.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? DataNoticeBody.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataDetailedLayout[] newArray(int i) {
            return new DataDetailedLayout[i];
        }
    }

    public DataDetailedLayout() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataDetailedLayout)) {
            return false;
        }
        DataDetailedLayout dataDetailedLayout = (DataDetailedLayout) other;
        return Intrinsics.areEqual(this.header, dataDetailedLayout.header) && Intrinsics.areEqual(this.features, dataDetailedLayout.features) && Intrinsics.areEqual(this.includedServices, dataDetailedLayout.includedServices) && Intrinsics.areEqual(this.plans, dataDetailedLayout.plans) && Intrinsics.areEqual(this.notice, dataDetailedLayout.notice);
    }

    public int hashCode() {
        DataHeader dataHeader = this.header;
        int iHashCode = (dataHeader == null ? 0 : dataHeader.hashCode()) * 31;
        DataFeatures dataFeatures = this.features;
        int iHashCode2 = (iHashCode + (dataFeatures == null ? 0 : dataFeatures.hashCode())) * 31;
        DataIncludedServices dataIncludedServices = this.includedServices;
        int iHashCode3 = (iHashCode2 + (dataIncludedServices == null ? 0 : dataIncludedServices.hashCode())) * 31;
        DataAppearancePlans dataAppearancePlans = this.plans;
        int iHashCode4 = (iHashCode3 + (dataAppearancePlans == null ? 0 : dataAppearancePlans.hashCode())) * 31;
        DataNoticeBody dataNoticeBody = this.notice;
        return iHashCode4 + (dataNoticeBody != null ? dataNoticeBody.hashCode() : 0);
    }

    public String toString() {
        return "DataDetailedLayout(header=" + this.header + ", features=" + this.features + ", includedServices=" + this.includedServices + ", plans=" + this.plans + ", notice=" + this.notice + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        DataHeader dataHeader = this.header;
        if (dataHeader == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataHeader.writeToParcel(parcel, flags);
        }
        DataFeatures dataFeatures = this.features;
        if (dataFeatures == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataFeatures.writeToParcel(parcel, flags);
        }
        DataIncludedServices dataIncludedServices = this.includedServices;
        if (dataIncludedServices == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataIncludedServices.writeToParcel(parcel, flags);
        }
        DataAppearancePlans dataAppearancePlans = this.plans;
        if (dataAppearancePlans == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataAppearancePlans.writeToParcel(parcel, flags);
        }
        DataNoticeBody dataNoticeBody = this.notice;
        if (dataNoticeBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataNoticeBody.writeToParcel(parcel, flags);
        }
    }

    public DataDetailedLayout(DataHeader dataHeader, DataFeatures dataFeatures, DataIncludedServices dataIncludedServices, DataAppearancePlans dataAppearancePlans, DataNoticeBody dataNoticeBody) {
        this.header = dataHeader;
        this.features = dataFeatures;
        this.includedServices = dataIncludedServices;
        this.plans = dataAppearancePlans;
        this.notice = dataNoticeBody;
    }

    public /* synthetic */ DataDetailedLayout(DataHeader dataHeader, DataFeatures dataFeatures, DataIncludedServices dataIncludedServices, DataAppearancePlans dataAppearancePlans, DataNoticeBody dataNoticeBody, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dataHeader, (i & 2) != 0 ? null : dataFeatures, (i & 4) != 0 ? null : dataIncludedServices, (i & 8) != 0 ? null : dataAppearancePlans, (i & 16) != 0 ? null : dataNoticeBody);
    }

    public final DataHeader getHeader() {
        return this.header;
    }

    public final DataFeatures getFeatures() {
        return this.features;
    }

    public final DataIncludedServices getIncludedServices() {
        return this.includedServices;
    }

    public final DataAppearancePlans getPlans() {
        return this.plans;
    }

    public final DataNoticeBody getNotice() {
        return this.notice;
    }
}
