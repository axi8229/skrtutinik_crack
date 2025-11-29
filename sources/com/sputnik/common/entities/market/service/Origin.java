package com.sputnik.common.entities.market.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.common.entities.subscriptions.services.ServiceAppearance;
import com.sputnik.domain.entities.market.services.OriginType;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Origin.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJd\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0011R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b'\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b(\u0010\u0011R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b)\u0010\u0011R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/sputnik/common/entities/market/service/Origin;", "Landroid/os/Parcelable;", "", "productId", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/domain/entities/market/services/OriginType;", "type", "expires", "phone", "website", "Lcom/sputnik/common/entities/subscriptions/services/ServiceAppearance;", "appearance", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/market/services/OriginType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/subscriptions/services/ServiceAppearance;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/market/services/OriginType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/subscriptions/services/ServiceAppearance;)Lcom/sputnik/common/entities/market/service/Origin;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getProductId", "getTitle", "Lcom/sputnik/domain/entities/market/services/OriginType;", "getType", "()Lcom/sputnik/domain/entities/market/services/OriginType;", "getExpires", "getPhone", "getWebsite", "Lcom/sputnik/common/entities/subscriptions/services/ServiceAppearance;", "getAppearance", "()Lcom/sputnik/common/entities/subscriptions/services/ServiceAppearance;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Origin implements Parcelable {
    public static final Parcelable.Creator<Origin> CREATOR = new Creator();
    private final ServiceAppearance appearance;
    private final String expires;
    private final String phone;
    private final String productId;
    private final String title;
    private final OriginType type;
    private final String website;

    /* compiled from: Origin.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Origin> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Origin createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Origin(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : OriginType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? ServiceAppearance.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Origin[] newArray(int i) {
            return new Origin[i];
        }
    }

    public Origin() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ Origin copy$default(Origin origin, String str, String str2, OriginType originType, String str3, String str4, String str5, ServiceAppearance serviceAppearance, int i, Object obj) {
        if ((i & 1) != 0) {
            str = origin.productId;
        }
        if ((i & 2) != 0) {
            str2 = origin.title;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            originType = origin.type;
        }
        OriginType originType2 = originType;
        if ((i & 8) != 0) {
            str3 = origin.expires;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = origin.phone;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = origin.website;
        }
        String str9 = str5;
        if ((i & 64) != 0) {
            serviceAppearance = origin.appearance;
        }
        return origin.copy(str, str6, originType2, str7, str8, str9, serviceAppearance);
    }

    public final Origin copy(String productId, String title, OriginType type, String expires, String phone, String website, ServiceAppearance appearance) {
        return new Origin(productId, title, type, expires, phone, website, appearance);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Origin)) {
            return false;
        }
        Origin origin = (Origin) other;
        return Intrinsics.areEqual(this.productId, origin.productId) && Intrinsics.areEqual(this.title, origin.title) && this.type == origin.type && Intrinsics.areEqual(this.expires, origin.expires) && Intrinsics.areEqual(this.phone, origin.phone) && Intrinsics.areEqual(this.website, origin.website) && Intrinsics.areEqual(this.appearance, origin.appearance);
    }

    public int hashCode() {
        String str = this.productId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        OriginType originType = this.type;
        int iHashCode3 = (iHashCode2 + (originType == null ? 0 : originType.hashCode())) * 31;
        String str3 = this.expires;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.phone;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.website;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ServiceAppearance serviceAppearance = this.appearance;
        return iHashCode6 + (serviceAppearance != null ? serviceAppearance.hashCode() : 0);
    }

    public String toString() {
        return "Origin(productId=" + this.productId + ", title=" + this.title + ", type=" + this.type + ", expires=" + this.expires + ", phone=" + this.phone + ", website=" + this.website + ", appearance=" + this.appearance + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.productId);
        parcel.writeString(this.title);
        OriginType originType = this.type;
        if (originType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(originType.name());
        }
        parcel.writeString(this.expires);
        parcel.writeString(this.phone);
        parcel.writeString(this.website);
        ServiceAppearance serviceAppearance = this.appearance;
        if (serviceAppearance == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            serviceAppearance.writeToParcel(parcel, flags);
        }
    }

    public Origin(String str, String str2, OriginType originType, String str3, String str4, String str5, ServiceAppearance serviceAppearance) {
        this.productId = str;
        this.title = str2;
        this.type = originType;
        this.expires = str3;
        this.phone = str4;
        this.website = str5;
        this.appearance = serviceAppearance;
    }

    public /* synthetic */ Origin(String str, String str2, OriginType originType, String str3, String str4, String str5, ServiceAppearance serviceAppearance, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : originType, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : serviceAppearance);
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final OriginType getType() {
        return this.type;
    }

    public final String getExpires() {
        return this.expires;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getWebsite() {
        return this.website;
    }

    public final ServiceAppearance getAppearance() {
        return this.appearance;
    }
}
