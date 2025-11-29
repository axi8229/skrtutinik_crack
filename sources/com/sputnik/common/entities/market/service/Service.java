package com.sputnik.common.entities.market.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.domain.entities.market.services.ServiceState;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Service.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001:\u0001:B\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0094\u0001\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0018R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b(\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b\b\u0010-R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b\t\u0010-R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b.\u0010\u0018R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00102\u001a\u0004\b3\u00104R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b5\u0010\u0018R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b9\u0010-¨\u0006;"}, d2 = {"Lcom/sputnik/common/entities/market/service/Service;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "description", "", "serviceImage", "", "isCompanyService", "isSubscriptionService", "serviceConfigIdentifier", "Lcom/sputnik/common/entities/market/service/Origin;", AppMeasurementSdk.ConditionalUserProperty.ORIGIN, "Lcom/sputnik/domain/entities/market/services/ServiceState;", "state", "activatedAt", "Lcom/sputnik/common/entities/market/service/Service$Badge;", "badge", "requiresSubscription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/common/entities/market/service/Origin;Lcom/sputnik/domain/entities/market/services/ServiceState;Ljava/lang/String;Lcom/sputnik/common/entities/market/service/Service$Badge;Ljava/lang/Boolean;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/common/entities/market/service/Origin;Lcom/sputnik/domain/entities/market/services/ServiceState;Ljava/lang/String;Lcom/sputnik/common/entities/market/service/Service$Badge;Ljava/lang/Boolean;)Lcom/sputnik/common/entities/market/service/Service;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getDescription", "Ljava/lang/Integer;", "getServiceImage", "()Ljava/lang/Integer;", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "getServiceConfigIdentifier", "Lcom/sputnik/common/entities/market/service/Origin;", "getOrigin", "()Lcom/sputnik/common/entities/market/service/Origin;", "Lcom/sputnik/domain/entities/market/services/ServiceState;", "getState", "()Lcom/sputnik/domain/entities/market/services/ServiceState;", "getActivatedAt", "Lcom/sputnik/common/entities/market/service/Service$Badge;", "getBadge", "()Lcom/sputnik/common/entities/market/service/Service$Badge;", "getRequiresSubscription", "Badge", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Service implements Parcelable {
    public static final Parcelable.Creator<Service> CREATOR = new Creator();
    private final String activatedAt;
    private final Badge badge;
    private final String description;
    private final Boolean isCompanyService;
    private final Boolean isSubscriptionService;
    private final Origin origin;
    private final Boolean requiresSubscription;
    private final String serviceConfigIdentifier;
    private final Integer serviceImage;
    private final ServiceState state;
    private final String title;

    /* compiled from: Service.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Service> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Service createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string3 = parcel.readString();
            Origin originCreateFromParcel = parcel.readInt() == 0 ? null : Origin.CREATOR.createFromParcel(parcel);
            ServiceState serviceStateValueOf = parcel.readInt() == 0 ? null : ServiceState.valueOf(parcel.readString());
            String string4 = parcel.readString();
            Badge badgeCreateFromParcel = parcel.readInt() == 0 ? null : Badge.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                boolValueOf3 = null;
            } else {
                boolValueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new Service(string, string2, numValueOf, boolValueOf, boolValueOf2, string3, originCreateFromParcel, serviceStateValueOf, string4, badgeCreateFromParcel, boolValueOf3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Service[] newArray(int i) {
            return new Service[i];
        }
    }

    public Service() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public final Service copy(String title, String description, Integer serviceImage, Boolean isCompanyService, Boolean isSubscriptionService, String serviceConfigIdentifier, Origin origin, ServiceState state, String activatedAt, Badge badge, Boolean requiresSubscription) {
        return new Service(title, description, serviceImage, isCompanyService, isSubscriptionService, serviceConfigIdentifier, origin, state, activatedAt, badge, requiresSubscription);
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
        return Intrinsics.areEqual(this.title, service.title) && Intrinsics.areEqual(this.description, service.description) && Intrinsics.areEqual(this.serviceImage, service.serviceImage) && Intrinsics.areEqual(this.isCompanyService, service.isCompanyService) && Intrinsics.areEqual(this.isSubscriptionService, service.isSubscriptionService) && Intrinsics.areEqual(this.serviceConfigIdentifier, service.serviceConfigIdentifier) && Intrinsics.areEqual(this.origin, service.origin) && this.state == service.state && Intrinsics.areEqual(this.activatedAt, service.activatedAt) && Intrinsics.areEqual(this.badge, service.badge) && Intrinsics.areEqual(this.requiresSubscription, service.requiresSubscription);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.serviceImage;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isCompanyService;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isSubscriptionService;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str3 = this.serviceConfigIdentifier;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Origin origin = this.origin;
        int iHashCode7 = (iHashCode6 + (origin == null ? 0 : origin.hashCode())) * 31;
        ServiceState serviceState = this.state;
        int iHashCode8 = (iHashCode7 + (serviceState == null ? 0 : serviceState.hashCode())) * 31;
        String str4 = this.activatedAt;
        int iHashCode9 = (iHashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Badge badge = this.badge;
        int iHashCode10 = (iHashCode9 + (badge == null ? 0 : badge.hashCode())) * 31;
        Boolean bool3 = this.requiresSubscription;
        return iHashCode10 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "Service(title=" + this.title + ", description=" + this.description + ", serviceImage=" + this.serviceImage + ", isCompanyService=" + this.isCompanyService + ", isSubscriptionService=" + this.isSubscriptionService + ", serviceConfigIdentifier=" + this.serviceConfigIdentifier + ", origin=" + this.origin + ", state=" + this.state + ", activatedAt=" + this.activatedAt + ", badge=" + this.badge + ", requiresSubscription=" + this.requiresSubscription + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        Integer num = this.serviceImage;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Boolean bool = this.isCompanyService;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.isSubscriptionService;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.serviceConfigIdentifier);
        Origin origin = this.origin;
        if (origin == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            origin.writeToParcel(parcel, flags);
        }
        ServiceState serviceState = this.state;
        if (serviceState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(serviceState.name());
        }
        parcel.writeString(this.activatedAt);
        Badge badge = this.badge;
        if (badge == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            badge.writeToParcel(parcel, flags);
        }
        Boolean bool3 = this.requiresSubscription;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
    }

    public Service(String str, String str2, Integer num, Boolean bool, Boolean bool2, String str3, Origin origin, ServiceState serviceState, String str4, Badge badge, Boolean bool3) {
        this.title = str;
        this.description = str2;
        this.serviceImage = num;
        this.isCompanyService = bool;
        this.isSubscriptionService = bool2;
        this.serviceConfigIdentifier = str3;
        this.origin = origin;
        this.state = serviceState;
        this.activatedAt = str4;
        this.badge = badge;
        this.requiresSubscription = bool3;
    }

    public /* synthetic */ Service(String str, String str2, Integer num, Boolean bool, Boolean bool2, String str3, Origin origin, ServiceState serviceState, String str4, Badge badge, Boolean bool3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : origin, (i & 128) != 0 ? null : serviceState, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : badge, (i & 1024) == 0 ? bool3 : null);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    /* renamed from: isCompanyService, reason: from getter */
    public final Boolean getIsCompanyService() {
        return this.isCompanyService;
    }

    public final String getServiceConfigIdentifier() {
        return this.serviceConfigIdentifier;
    }

    public final Origin getOrigin() {
        return this.origin;
    }

    public final ServiceState getState() {
        return this.state;
    }

    public final Badge getBadge() {
        return this.badge;
    }

    public final Boolean getRequiresSubscription() {
        return this.requiresSubscription;
    }

    /* compiled from: Service.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/market/service/Service$Badge;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, RemoteMessageConst.Notification.COLOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getColor", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Badge implements Parcelable {
        public static final Parcelable.Creator<Badge> CREATOR = new Creator();
        private final String color;
        private final String title;

        /* compiled from: Service.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Badge> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Badge createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Badge(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Badge[] newArray(int i) {
                return new Badge[i];
            }
        }

        public Badge() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Badge)) {
                return false;
            }
            Badge badge = (Badge) other;
            return Intrinsics.areEqual(this.title, badge.title) && Intrinsics.areEqual(this.color, badge.color);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.color;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Badge(title=" + this.title + ", color=" + this.color + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.color);
        }

        public Badge(String str, String str2) {
            this.title = str;
            this.color = str2;
        }

        public /* synthetic */ Badge(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getColor() {
            return this.color;
        }
    }
}
