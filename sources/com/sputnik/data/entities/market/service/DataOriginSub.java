package com.sputnik.data.entities.market.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.market.services.OriginType;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataOriginSub.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0016J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b'\u0010\u0014R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b+\u0010\u0014R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b,\u0010\u0014R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b-\u0010\u0014R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b.\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/sputnik/data/entities/market/service/DataOriginSub;", "Landroid/os/Parcelable;", "Lcom/sputnik/domain/entities/market/services/OriginType;", "type", "", "productId", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "price", "fullExpires", "phone", "website", "originTitle", "", "showBadge", "Lcom/sputnik/data/entities/subscriptions/services/DataServiceAppearance;", "appearance", "<init>", "(Lcom/sputnik/domain/entities/market/services/OriginType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/sputnik/data/entities/subscriptions/services/DataServiceAppearance;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/domain/entities/market/services/OriginType;", "getType", "()Lcom/sputnik/domain/entities/market/services/OriginType;", "Ljava/lang/String;", "getProductId", "getTitle", "Ljava/lang/Integer;", "getPrice", "()Ljava/lang/Integer;", "getFullExpires", "getPhone", "getWebsite", "getOriginTitle", "Z", "getShowBadge", "()Z", "Lcom/sputnik/data/entities/subscriptions/services/DataServiceAppearance;", "getAppearance", "()Lcom/sputnik/data/entities/subscriptions/services/DataServiceAppearance;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataOriginSub implements Parcelable {
    public static final Parcelable.Creator<DataOriginSub> CREATOR = new Creator();
    private final com.sputnik.data.entities.subscriptions.services.DataServiceAppearance appearance;

    @SerializedName("expires")
    private final String fullExpires;
    private final String originTitle;
    private final String phone;
    private final Integer price;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("show_badge")
    private final boolean showBadge;
    private final String title;
    private final OriginType type;
    private final String website;

    /* compiled from: DataOriginSub.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataOriginSub> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataOriginSub createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataOriginSub(parcel.readInt() == 0 ? null : OriginType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0 ? com.sputnik.data.entities.subscriptions.services.DataServiceAppearance.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataOriginSub[] newArray(int i) {
            return new DataOriginSub[i];
        }
    }

    public DataOriginSub() {
        this(null, null, null, null, null, null, null, null, false, null, 1023, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataOriginSub)) {
            return false;
        }
        DataOriginSub dataOriginSub = (DataOriginSub) other;
        return this.type == dataOriginSub.type && Intrinsics.areEqual(this.productId, dataOriginSub.productId) && Intrinsics.areEqual(this.title, dataOriginSub.title) && Intrinsics.areEqual(this.price, dataOriginSub.price) && Intrinsics.areEqual(this.fullExpires, dataOriginSub.fullExpires) && Intrinsics.areEqual(this.phone, dataOriginSub.phone) && Intrinsics.areEqual(this.website, dataOriginSub.website) && Intrinsics.areEqual(this.originTitle, dataOriginSub.originTitle) && this.showBadge == dataOriginSub.showBadge && Intrinsics.areEqual(this.appearance, dataOriginSub.appearance);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        OriginType originType = this.type;
        int iHashCode = (originType == null ? 0 : originType.hashCode()) * 31;
        String str = this.productId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.price;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.fullExpires;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.phone;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.website;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.originTitle;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        boolean z = this.showBadge;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode8 + i) * 31;
        com.sputnik.data.entities.subscriptions.services.DataServiceAppearance dataServiceAppearance = this.appearance;
        return i2 + (dataServiceAppearance != null ? dataServiceAppearance.hashCode() : 0);
    }

    public String toString() {
        return "DataOriginSub(type=" + this.type + ", productId=" + this.productId + ", title=" + this.title + ", price=" + this.price + ", fullExpires=" + this.fullExpires + ", phone=" + this.phone + ", website=" + this.website + ", originTitle=" + this.originTitle + ", showBadge=" + this.showBadge + ", appearance=" + this.appearance + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        OriginType originType = this.type;
        if (originType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(originType.name());
        }
        parcel.writeString(this.productId);
        parcel.writeString(this.title);
        Integer num = this.price;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.fullExpires);
        parcel.writeString(this.phone);
        parcel.writeString(this.website);
        parcel.writeString(this.originTitle);
        parcel.writeInt(this.showBadge ? 1 : 0);
        com.sputnik.data.entities.subscriptions.services.DataServiceAppearance dataServiceAppearance = this.appearance;
        if (dataServiceAppearance == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataServiceAppearance.writeToParcel(parcel, flags);
        }
    }

    public DataOriginSub(OriginType originType, String str, String str2, Integer num, String str3, String str4, String str5, String str6, boolean z, com.sputnik.data.entities.subscriptions.services.DataServiceAppearance dataServiceAppearance) {
        this.type = originType;
        this.productId = str;
        this.title = str2;
        this.price = num;
        this.fullExpires = str3;
        this.phone = str4;
        this.website = str5;
        this.originTitle = str6;
        this.showBadge = z;
        this.appearance = dataServiceAppearance;
    }

    public /* synthetic */ DataOriginSub(OriginType originType, String str, String str2, Integer num, String str3, String str4, String str5, String str6, boolean z, com.sputnik.data.entities.subscriptions.services.DataServiceAppearance dataServiceAppearance, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : originType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? true : z, (i & 512) == 0 ? dataServiceAppearance : null);
    }

    public final OriginType getType() {
        return this.type;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final String getFullExpires() {
        return this.fullExpires;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getWebsite() {
        return this.website;
    }

    public final String getOriginTitle() {
        return this.originTitle;
    }

    public final boolean getShowBadge() {
        return this.showBadge;
    }

    public final com.sputnik.data.entities.subscriptions.services.DataServiceAppearance getAppearance() {
        return this.appearance;
    }
}
