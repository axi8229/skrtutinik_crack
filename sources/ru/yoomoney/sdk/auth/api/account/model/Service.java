package ru.yoomoney.sdk.auth.api.account.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/model/Service;", "Landroid/os/Parcelable;", "type", "Lru/yoomoney/sdk/auth/api/account/model/ServiceType;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "logoUrl", "(Lru/yoomoney/sdk/auth/api/account/model/ServiceType;Ljava/lang/String;Ljava/lang/String;)V", "getLogoUrl", "()Ljava/lang/String;", "getTitle", "getType", "()Lru/yoomoney/sdk/auth/api/account/model/ServiceType;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Service implements Parcelable {
    public static final Parcelable.Creator<Service> CREATOR = new Creator();

    @SerializedName("logoUrl")
    private final String logoUrl;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final String title;

    @SerializedName("type")
    private final ServiceType type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Service> {
        @Override // android.os.Parcelable.Creator
        public final Service createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Service(parcel.readInt() == 0 ? null : ServiceType.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Service[] newArray(int i) {
            return new Service[i];
        }
    }

    public Service(ServiceType serviceType, String title, String logoUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        this.type = serviceType;
        this.title = title;
        this.logoUrl = logoUrl;
    }

    public static /* synthetic */ Service copy$default(Service service, ServiceType serviceType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            serviceType = service.type;
        }
        if ((i & 2) != 0) {
            str = service.title;
        }
        if ((i & 4) != 0) {
            str2 = service.logoUrl;
        }
        return service.copy(serviceType, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final ServiceType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final Service copy(ServiceType type, String title, String logoUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
        return new Service(type, title, logoUrl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Service)) {
            return false;
        }
        Service service = (Service) other;
        return this.type == service.type && Intrinsics.areEqual(this.title, service.title) && Intrinsics.areEqual(this.logoUrl, service.logoUrl);
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ServiceType getType() {
        return this.type;
    }

    public int hashCode() {
        ServiceType serviceType = this.type;
        return this.logoUrl.hashCode() + ru.yoomoney.sdk.auth.a.a(this.title, (serviceType == null ? 0 : serviceType.hashCode()) * 31, 31);
    }

    public String toString() {
        return "Service(type=" + this.type + ", title=" + this.title + ", logoUrl=" + this.logoUrl + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        ServiceType serviceType = this.type;
        if (serviceType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(serviceType.name());
        }
        parcel.writeString(this.title);
        parcel.writeString(this.logoUrl);
    }
}
