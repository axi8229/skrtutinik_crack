package com.sputnik.common.entities.localization.entities.ble;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BleLocale.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001:\u0007456789:BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010.\u001a\u0004\b/\u00100R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b2\u00103¨\u0006;"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/ble/BleLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$ServiceNotification;", "serviceNotification", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$NoPermissionsNotification;", "noPermissionsNotification", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$EmergencyCodeNotification;", "emergencyCodeNotification", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$BleService;", "bleService", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$SetupRssiBottomSheet;", "setupRssiBottomSheet", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$PermissionsNotGrantedBottomSheet;", "permissionsNotGrantedBottomSheet", "<init>", "(Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$ServiceNotification;Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$NoPermissionsNotification;Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$EmergencyCodeNotification;Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$BleService;Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$SetupRssiBottomSheet;Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$PermissionsNotGrantedBottomSheet;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$ServiceNotification;", "getServiceNotification", "()Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$ServiceNotification;", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$NoPermissionsNotification;", "getNoPermissionsNotification", "()Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$NoPermissionsNotification;", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$EmergencyCodeNotification;", "getEmergencyCodeNotification", "()Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$EmergencyCodeNotification;", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$BleService;", "getBleService", "()Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$BleService;", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$SetupRssiBottomSheet;", "getSetupRssiBottomSheet", "()Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$SetupRssiBottomSheet;", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$PermissionsNotGrantedBottomSheet;", "getPermissionsNotGrantedBottomSheet", "()Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$PermissionsNotGrantedBottomSheet;", "BleService", "Body", "EmergencyCodeNotification", "NoPermissionsNotification", "PermissionsNotGrantedBottomSheet", "ServiceNotification", "SetupRssiBottomSheet", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BleLocale implements Parcelable {
    public static final Parcelable.Creator<BleLocale> CREATOR = new Creator();

    @SerializedName("ble_service")
    private final BleService bleService;

    @SerializedName("emergency_code_notification")
    private final EmergencyCodeNotification emergencyCodeNotification;

    @SerializedName("no_permissions_notification")
    private final NoPermissionsNotification noPermissionsNotification;

    @SerializedName("permissions_not_granted_bottom_sheet")
    private final PermissionsNotGrantedBottomSheet permissionsNotGrantedBottomSheet;

    @SerializedName("service_notification")
    private final ServiceNotification serviceNotification;

    @SerializedName("setup_rssi_bottom_sheet")
    private final SetupRssiBottomSheet setupRssiBottomSheet;

    /* compiled from: BleLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BleLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BleLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BleLocale(parcel.readInt() == 0 ? null : ServiceNotification.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : NoPermissionsNotification.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : EmergencyCodeNotification.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : BleService.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : SetupRssiBottomSheet.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? PermissionsNotGrantedBottomSheet.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BleLocale[] newArray(int i) {
            return new BleLocale[i];
        }
    }

    public BleLocale() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BleLocale)) {
            return false;
        }
        BleLocale bleLocale = (BleLocale) other;
        return Intrinsics.areEqual(this.serviceNotification, bleLocale.serviceNotification) && Intrinsics.areEqual(this.noPermissionsNotification, bleLocale.noPermissionsNotification) && Intrinsics.areEqual(this.emergencyCodeNotification, bleLocale.emergencyCodeNotification) && Intrinsics.areEqual(this.bleService, bleLocale.bleService) && Intrinsics.areEqual(this.setupRssiBottomSheet, bleLocale.setupRssiBottomSheet) && Intrinsics.areEqual(this.permissionsNotGrantedBottomSheet, bleLocale.permissionsNotGrantedBottomSheet);
    }

    public int hashCode() {
        ServiceNotification serviceNotification = this.serviceNotification;
        int iHashCode = (serviceNotification == null ? 0 : serviceNotification.hashCode()) * 31;
        NoPermissionsNotification noPermissionsNotification = this.noPermissionsNotification;
        int iHashCode2 = (iHashCode + (noPermissionsNotification == null ? 0 : noPermissionsNotification.hashCode())) * 31;
        EmergencyCodeNotification emergencyCodeNotification = this.emergencyCodeNotification;
        int iHashCode3 = (iHashCode2 + (emergencyCodeNotification == null ? 0 : emergencyCodeNotification.hashCode())) * 31;
        BleService bleService = this.bleService;
        int iHashCode4 = (iHashCode3 + (bleService == null ? 0 : bleService.hashCode())) * 31;
        SetupRssiBottomSheet setupRssiBottomSheet = this.setupRssiBottomSheet;
        int iHashCode5 = (iHashCode4 + (setupRssiBottomSheet == null ? 0 : setupRssiBottomSheet.hashCode())) * 31;
        PermissionsNotGrantedBottomSheet permissionsNotGrantedBottomSheet = this.permissionsNotGrantedBottomSheet;
        return iHashCode5 + (permissionsNotGrantedBottomSheet != null ? permissionsNotGrantedBottomSheet.hashCode() : 0);
    }

    public String toString() {
        return "BleLocale(serviceNotification=" + this.serviceNotification + ", noPermissionsNotification=" + this.noPermissionsNotification + ", emergencyCodeNotification=" + this.emergencyCodeNotification + ", bleService=" + this.bleService + ", setupRssiBottomSheet=" + this.setupRssiBottomSheet + ", permissionsNotGrantedBottomSheet=" + this.permissionsNotGrantedBottomSheet + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        ServiceNotification serviceNotification = this.serviceNotification;
        if (serviceNotification == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            serviceNotification.writeToParcel(parcel, flags);
        }
        NoPermissionsNotification noPermissionsNotification = this.noPermissionsNotification;
        if (noPermissionsNotification == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            noPermissionsNotification.writeToParcel(parcel, flags);
        }
        EmergencyCodeNotification emergencyCodeNotification = this.emergencyCodeNotification;
        if (emergencyCodeNotification == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            emergencyCodeNotification.writeToParcel(parcel, flags);
        }
        BleService bleService = this.bleService;
        if (bleService == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bleService.writeToParcel(parcel, flags);
        }
        SetupRssiBottomSheet setupRssiBottomSheet = this.setupRssiBottomSheet;
        if (setupRssiBottomSheet == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            setupRssiBottomSheet.writeToParcel(parcel, flags);
        }
        PermissionsNotGrantedBottomSheet permissionsNotGrantedBottomSheet = this.permissionsNotGrantedBottomSheet;
        if (permissionsNotGrantedBottomSheet == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permissionsNotGrantedBottomSheet.writeToParcel(parcel, flags);
        }
    }

    public BleLocale(ServiceNotification serviceNotification, NoPermissionsNotification noPermissionsNotification, EmergencyCodeNotification emergencyCodeNotification, BleService bleService, SetupRssiBottomSheet setupRssiBottomSheet, PermissionsNotGrantedBottomSheet permissionsNotGrantedBottomSheet) {
        this.serviceNotification = serviceNotification;
        this.noPermissionsNotification = noPermissionsNotification;
        this.emergencyCodeNotification = emergencyCodeNotification;
        this.bleService = bleService;
        this.setupRssiBottomSheet = setupRssiBottomSheet;
        this.permissionsNotGrantedBottomSheet = permissionsNotGrantedBottomSheet;
    }

    public /* synthetic */ BleLocale(ServiceNotification serviceNotification, NoPermissionsNotification noPermissionsNotification, EmergencyCodeNotification emergencyCodeNotification, BleService bleService, SetupRssiBottomSheet setupRssiBottomSheet, PermissionsNotGrantedBottomSheet permissionsNotGrantedBottomSheet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : serviceNotification, (i & 2) != 0 ? null : noPermissionsNotification, (i & 4) != 0 ? null : emergencyCodeNotification, (i & 8) != 0 ? null : bleService, (i & 16) != 0 ? null : setupRssiBottomSheet, (i & 32) != 0 ? null : permissionsNotGrantedBottomSheet);
    }

    public final ServiceNotification getServiceNotification() {
        return this.serviceNotification;
    }

    public final NoPermissionsNotification getNoPermissionsNotification() {
        return this.noPermissionsNotification;
    }

    public final EmergencyCodeNotification getEmergencyCodeNotification() {
        return this.emergencyCodeNotification;
    }

    public final BleService getBleService() {
        return this.bleService;
    }

    public final SetupRssiBottomSheet getSetupRssiBottomSheet() {
        return this.setupRssiBottomSheet;
    }

    public final PermissionsNotGrantedBottomSheet getPermissionsNotGrantedBottomSheet() {
        return this.permissionsNotGrantedBottomSheet;
    }

    /* compiled from: BleLocale.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$ServiceNotification;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getBody", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ServiceNotification implements Parcelable {
        public static final Parcelable.Creator<ServiceNotification> CREATOR = new Creator();

        @SerializedName("body")
        private final String body;

        @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
        private final String title;

        /* compiled from: BleLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ServiceNotification> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ServiceNotification createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ServiceNotification(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final ServiceNotification[] newArray(int i) {
                return new ServiceNotification[i];
            }
        }

        public ServiceNotification() {
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
            if (!(other instanceof ServiceNotification)) {
                return false;
            }
            ServiceNotification serviceNotification = (ServiceNotification) other;
            return Intrinsics.areEqual(this.title, serviceNotification.title) && Intrinsics.areEqual(this.body, serviceNotification.body);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.body;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ServiceNotification(title=" + this.title + ", body=" + this.body + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.body);
        }

        public ServiceNotification(String str, String str2) {
            this.title = str;
            this.body = str2;
        }

        public /* synthetic */ ServiceNotification(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getBody() {
            return this.body;
        }
    }

    /* compiled from: BleLocale.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$NoPermissionsNotification;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getBody", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NoPermissionsNotification implements Parcelable {
        public static final Parcelable.Creator<NoPermissionsNotification> CREATOR = new Creator();

        @SerializedName("body")
        private final String body;

        @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
        private final String title;

        /* compiled from: BleLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<NoPermissionsNotification> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoPermissionsNotification createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NoPermissionsNotification(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final NoPermissionsNotification[] newArray(int i) {
                return new NoPermissionsNotification[i];
            }
        }

        public NoPermissionsNotification() {
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
            if (!(other instanceof NoPermissionsNotification)) {
                return false;
            }
            NoPermissionsNotification noPermissionsNotification = (NoPermissionsNotification) other;
            return Intrinsics.areEqual(this.title, noPermissionsNotification.title) && Intrinsics.areEqual(this.body, noPermissionsNotification.body);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.body;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "NoPermissionsNotification(title=" + this.title + ", body=" + this.body + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.body);
        }

        public NoPermissionsNotification(String str, String str2) {
            this.title = str;
            this.body = str2;
        }

        public /* synthetic */ NoPermissionsNotification(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getBody() {
            return this.body;
        }
    }

    /* compiled from: BleLocale.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$EmergencyCodeNotification;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getBody", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class EmergencyCodeNotification implements Parcelable {
        public static final Parcelable.Creator<EmergencyCodeNotification> CREATOR = new Creator();

        @SerializedName("body")
        private final String body;

        @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
        private final String title;

        /* compiled from: BleLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<EmergencyCodeNotification> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EmergencyCodeNotification createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new EmergencyCodeNotification(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final EmergencyCodeNotification[] newArray(int i) {
                return new EmergencyCodeNotification[i];
            }
        }

        public EmergencyCodeNotification() {
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
            if (!(other instanceof EmergencyCodeNotification)) {
                return false;
            }
            EmergencyCodeNotification emergencyCodeNotification = (EmergencyCodeNotification) other;
            return Intrinsics.areEqual(this.title, emergencyCodeNotification.title) && Intrinsics.areEqual(this.body, emergencyCodeNotification.body);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.body;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "EmergencyCodeNotification(title=" + this.title + ", body=" + this.body + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.body);
        }

        public EmergencyCodeNotification(String str, String str2) {
            this.title = str;
            this.body = str2;
        }

        public /* synthetic */ EmergencyCodeNotification(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getBody() {
            return this.body;
        }
    }

    /* compiled from: BleLocale.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$BleService;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "navigation", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body;", "body", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNavigation", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body;", "getBody", "()Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class BleService implements Parcelable {
        public static final Parcelable.Creator<BleService> CREATOR = new Creator();

        @SerializedName("body")
        private final Body body;

        @SerializedName("navigation")
        private final TextTitle navigation;

        /* compiled from: BleLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<BleService> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BleService createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new BleService(parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Body.CREATOR.createFromParcel(parcel) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final BleService[] newArray(int i) {
                return new BleService[i];
            }
        }

        public BleService() {
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
            if (!(other instanceof BleService)) {
                return false;
            }
            BleService bleService = (BleService) other;
            return Intrinsics.areEqual(this.navigation, bleService.navigation) && Intrinsics.areEqual(this.body, bleService.body);
        }

        public int hashCode() {
            TextTitle textTitle = this.navigation;
            int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
            Body body = this.body;
            return iHashCode + (body != null ? body.hashCode() : 0);
        }

        public String toString() {
            return "BleService(navigation=" + this.navigation + ", body=" + this.body + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            TextTitle textTitle = this.navigation;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            Body body = this.body;
            if (body == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                body.writeToParcel(parcel, flags);
            }
        }

        public BleService(TextTitle textTitle, Body body) {
            this.navigation = textTitle;
            this.body = body;
        }

        public /* synthetic */ BleService(TextTitle textTitle, Body body, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : body);
        }

        public final TextTitle getNavigation() {
            return this.navigation;
        }

        public final Body getBody() {
            return this.body;
        }
    }

    /* compiled from: BleLocale.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001:\u00029:B¯\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0019J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b(\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b)\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b*\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b+\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b0\u00101R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b2\u0010\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b3\u0010\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b4\u0010\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010&\u001a\u0004\b5\u0010\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b6\u0010\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b7\u0010\u0016R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b8\u0010\u0016¨\u0006;"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body;", "Landroid/os/Parcelable;", "", "useBleSwitch", "permissionsNotGrantedAttention", "rssiSetupHint", "rssiLevel", "rssiLevelDescription", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body$SetupPermissionsButton;", "setupPermissionsButton", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body$SetupRssiButton;", "setupRssiButton", "openDistance", "openDistanceDescription", "distanceNear", "distanceLong", "mainTitle", "promo", "beta", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body$SetupPermissionsButton;Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body$SetupRssiButton;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUseBleSwitch", "getPermissionsNotGrantedAttention", "getRssiSetupHint", "getRssiLevel", "getRssiLevelDescription", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body$SetupPermissionsButton;", "getSetupPermissionsButton", "()Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body$SetupPermissionsButton;", "Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body$SetupRssiButton;", "getSetupRssiButton", "()Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body$SetupRssiButton;", "getOpenDistance", "getOpenDistanceDescription", "getDistanceNear", "getDistanceLong", "getMainTitle", "getPromo", "getBeta", "SetupPermissionsButton", "SetupRssiButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Body implements Parcelable {
        public static final Parcelable.Creator<Body> CREATOR = new Creator();

        @SerializedName("beta")
        private final String beta;

        @SerializedName("distance_long")
        private final String distanceLong;

        @SerializedName("distance_near")
        private final String distanceNear;

        @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
        private final String mainTitle;

        @SerializedName("open_distance")
        private final String openDistance;

        @SerializedName("open_distance_description")
        private final String openDistanceDescription;

        @SerializedName("permissions_not_granted_attention")
        private final String permissionsNotGrantedAttention;

        @SerializedName("promo")
        private final String promo;

        @SerializedName("rssi_level")
        private final String rssiLevel;

        @SerializedName("rssi_level_description")
        private final String rssiLevelDescription;

        @SerializedName("rssi_setup_hint")
        private final String rssiSetupHint;

        @SerializedName("setup_permissions_button")
        private final SetupPermissionsButton setupPermissionsButton;

        @SerializedName("setup_rssi_button")
        private final SetupRssiButton setupRssiButton;

        @SerializedName("use_ble_switch")
        private final String useBleSwitch;

        /* compiled from: BleLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Body> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Body createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Body(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : SetupPermissionsButton.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? SetupRssiButton.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Body[] newArray(int i) {
                return new Body[i];
            }
        }

        public Body() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Body)) {
                return false;
            }
            Body body = (Body) other;
            return Intrinsics.areEqual(this.useBleSwitch, body.useBleSwitch) && Intrinsics.areEqual(this.permissionsNotGrantedAttention, body.permissionsNotGrantedAttention) && Intrinsics.areEqual(this.rssiSetupHint, body.rssiSetupHint) && Intrinsics.areEqual(this.rssiLevel, body.rssiLevel) && Intrinsics.areEqual(this.rssiLevelDescription, body.rssiLevelDescription) && Intrinsics.areEqual(this.setupPermissionsButton, body.setupPermissionsButton) && Intrinsics.areEqual(this.setupRssiButton, body.setupRssiButton) && Intrinsics.areEqual(this.openDistance, body.openDistance) && Intrinsics.areEqual(this.openDistanceDescription, body.openDistanceDescription) && Intrinsics.areEqual(this.distanceNear, body.distanceNear) && Intrinsics.areEqual(this.distanceLong, body.distanceLong) && Intrinsics.areEqual(this.mainTitle, body.mainTitle) && Intrinsics.areEqual(this.promo, body.promo) && Intrinsics.areEqual(this.beta, body.beta);
        }

        public int hashCode() {
            String str = this.useBleSwitch;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.permissionsNotGrantedAttention;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.rssiSetupHint;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.rssiLevel;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.rssiLevelDescription;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            SetupPermissionsButton setupPermissionsButton = this.setupPermissionsButton;
            int iHashCode6 = (iHashCode5 + (setupPermissionsButton == null ? 0 : setupPermissionsButton.hashCode())) * 31;
            SetupRssiButton setupRssiButton = this.setupRssiButton;
            int iHashCode7 = (iHashCode6 + (setupRssiButton == null ? 0 : setupRssiButton.hashCode())) * 31;
            String str6 = this.openDistance;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.openDistanceDescription;
            int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.distanceNear;
            int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.distanceLong;
            int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.mainTitle;
            int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.promo;
            int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.beta;
            return iHashCode13 + (str12 != null ? str12.hashCode() : 0);
        }

        public String toString() {
            return "Body(useBleSwitch=" + this.useBleSwitch + ", permissionsNotGrantedAttention=" + this.permissionsNotGrantedAttention + ", rssiSetupHint=" + this.rssiSetupHint + ", rssiLevel=" + this.rssiLevel + ", rssiLevelDescription=" + this.rssiLevelDescription + ", setupPermissionsButton=" + this.setupPermissionsButton + ", setupRssiButton=" + this.setupRssiButton + ", openDistance=" + this.openDistance + ", openDistanceDescription=" + this.openDistanceDescription + ", distanceNear=" + this.distanceNear + ", distanceLong=" + this.distanceLong + ", mainTitle=" + this.mainTitle + ", promo=" + this.promo + ", beta=" + this.beta + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.useBleSwitch);
            parcel.writeString(this.permissionsNotGrantedAttention);
            parcel.writeString(this.rssiSetupHint);
            parcel.writeString(this.rssiLevel);
            parcel.writeString(this.rssiLevelDescription);
            SetupPermissionsButton setupPermissionsButton = this.setupPermissionsButton;
            if (setupPermissionsButton == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                setupPermissionsButton.writeToParcel(parcel, flags);
            }
            SetupRssiButton setupRssiButton = this.setupRssiButton;
            if (setupRssiButton == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                setupRssiButton.writeToParcel(parcel, flags);
            }
            parcel.writeString(this.openDistance);
            parcel.writeString(this.openDistanceDescription);
            parcel.writeString(this.distanceNear);
            parcel.writeString(this.distanceLong);
            parcel.writeString(this.mainTitle);
            parcel.writeString(this.promo);
            parcel.writeString(this.beta);
        }

        public Body(String str, String str2, String str3, String str4, String str5, SetupPermissionsButton setupPermissionsButton, SetupRssiButton setupRssiButton, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
            this.useBleSwitch = str;
            this.permissionsNotGrantedAttention = str2;
            this.rssiSetupHint = str3;
            this.rssiLevel = str4;
            this.rssiLevelDescription = str5;
            this.setupPermissionsButton = setupPermissionsButton;
            this.setupRssiButton = setupRssiButton;
            this.openDistance = str6;
            this.openDistanceDescription = str7;
            this.distanceNear = str8;
            this.distanceLong = str9;
            this.mainTitle = str10;
            this.promo = str11;
            this.beta = str12;
        }

        public /* synthetic */ Body(String str, String str2, String str3, String str4, String str5, SetupPermissionsButton setupPermissionsButton, SetupRssiButton setupRssiButton, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : setupPermissionsButton, (i & 64) != 0 ? null : setupRssiButton, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) == 0 ? str12 : null);
        }

        public final String getUseBleSwitch() {
            return this.useBleSwitch;
        }

        public final String getPermissionsNotGrantedAttention() {
            return this.permissionsNotGrantedAttention;
        }

        public final String getRssiLevel() {
            return this.rssiLevel;
        }

        public final String getRssiLevelDescription() {
            return this.rssiLevelDescription;
        }

        public final SetupPermissionsButton getSetupPermissionsButton() {
            return this.setupPermissionsButton;
        }

        public final SetupRssiButton getSetupRssiButton() {
            return this.setupRssiButton;
        }

        public final String getOpenDistance() {
            return this.openDistance;
        }

        public final String getOpenDistanceDescription() {
            return this.openDistanceDescription;
        }

        public final String getDistanceNear() {
            return this.distanceNear;
        }

        public final String getDistanceLong() {
            return this.distanceLong;
        }

        public final String getMainTitle() {
            return this.mainTitle;
        }

        public final String getPromo() {
            return this.promo;
        }

        public final String getBeta() {
            return this.beta;
        }

        /* compiled from: BleLocale.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body$SetupPermissionsButton;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SetupPermissionsButton implements Parcelable {
            public static final Parcelable.Creator<SetupPermissionsButton> CREATOR = new Creator();

            @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
            private final String title;

            /* compiled from: BleLocale.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<SetupPermissionsButton> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final SetupPermissionsButton createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new SetupPermissionsButton(parcel.readString());
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final SetupPermissionsButton[] newArray(int i) {
                    return new SetupPermissionsButton[i];
                }
            }

            public SetupPermissionsButton() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetupPermissionsButton) && Intrinsics.areEqual(this.title, ((SetupPermissionsButton) other).title);
            }

            public int hashCode() {
                String str = this.title;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "SetupPermissionsButton(title=" + this.title + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.title);
            }

            public SetupPermissionsButton(String str) {
                this.title = str;
            }

            public /* synthetic */ SetupPermissionsButton(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getTitle() {
                return this.title;
            }
        }

        /* compiled from: BleLocale.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$Body$SetupRssiButton;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SetupRssiButton implements Parcelable {
            public static final Parcelable.Creator<SetupRssiButton> CREATOR = new Creator();

            @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
            private final String title;

            /* compiled from: BleLocale.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<SetupRssiButton> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final SetupRssiButton createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new SetupRssiButton(parcel.readString());
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public final SetupRssiButton[] newArray(int i) {
                    return new SetupRssiButton[i];
                }
            }

            public SetupRssiButton() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetupRssiButton) && Intrinsics.areEqual(this.title, ((SetupRssiButton) other).title);
            }

            public int hashCode() {
                String str = this.title;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "SetupRssiButton(title=" + this.title + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.title);
            }

            public SetupRssiButton(String str) {
                this.title = str;
            }

            public /* synthetic */ SetupRssiButton(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getTitle() {
                return this.title;
            }
        }
    }

    /* compiled from: BleLocale.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b%\u0010$R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b&\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b'\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b(\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b)\u0010\u000f¨\u0006*"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$SetupRssiBottomSheet;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "subtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "okButton", "cancelButton", "measureFailed", "measureSuccess", "successButton", "inProgress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getSubtitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getOkButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "getMeasureFailed", "getMeasureSuccess", "getSuccessButton", "getInProgress", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SetupRssiBottomSheet implements Parcelable {
        public static final Parcelable.Creator<SetupRssiBottomSheet> CREATOR = new Creator();

        @SerializedName("cancel_button")
        private final TextTitle cancelButton;

        @SerializedName("in_progress")
        private final String inProgress;

        @SerializedName("measure_failed")
        private final String measureFailed;

        @SerializedName("measure_success")
        private final String measureSuccess;

        @SerializedName("ok_button")
        private final TextTitle okButton;

        @SerializedName("subtitle")
        private final String subtitle;

        @SerializedName("success_button")
        private final TextTitle successButton;

        @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
        private final String title;

        /* compiled from: BleLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<SetupRssiBottomSheet> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SetupRssiBottomSheet createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SetupRssiBottomSheet(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SetupRssiBottomSheet[] newArray(int i) {
                return new SetupRssiBottomSheet[i];
            }
        }

        public SetupRssiBottomSheet() {
            this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetupRssiBottomSheet)) {
                return false;
            }
            SetupRssiBottomSheet setupRssiBottomSheet = (SetupRssiBottomSheet) other;
            return Intrinsics.areEqual(this.title, setupRssiBottomSheet.title) && Intrinsics.areEqual(this.subtitle, setupRssiBottomSheet.subtitle) && Intrinsics.areEqual(this.okButton, setupRssiBottomSheet.okButton) && Intrinsics.areEqual(this.cancelButton, setupRssiBottomSheet.cancelButton) && Intrinsics.areEqual(this.measureFailed, setupRssiBottomSheet.measureFailed) && Intrinsics.areEqual(this.measureSuccess, setupRssiBottomSheet.measureSuccess) && Intrinsics.areEqual(this.successButton, setupRssiBottomSheet.successButton) && Intrinsics.areEqual(this.inProgress, setupRssiBottomSheet.inProgress);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.subtitle;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            TextTitle textTitle = this.okButton;
            int iHashCode3 = (iHashCode2 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            TextTitle textTitle2 = this.cancelButton;
            int iHashCode4 = (iHashCode3 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
            String str3 = this.measureFailed;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.measureSuccess;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            TextTitle textTitle3 = this.successButton;
            int iHashCode7 = (iHashCode6 + (textTitle3 == null ? 0 : textTitle3.hashCode())) * 31;
            String str5 = this.inProgress;
            return iHashCode7 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "SetupRssiBottomSheet(title=" + this.title + ", subtitle=" + this.subtitle + ", okButton=" + this.okButton + ", cancelButton=" + this.cancelButton + ", measureFailed=" + this.measureFailed + ", measureSuccess=" + this.measureSuccess + ", successButton=" + this.successButton + ", inProgress=" + this.inProgress + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            TextTitle textTitle = this.okButton;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            TextTitle textTitle2 = this.cancelButton;
            if (textTitle2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle2.writeToParcel(parcel, flags);
            }
            parcel.writeString(this.measureFailed);
            parcel.writeString(this.measureSuccess);
            TextTitle textTitle3 = this.successButton;
            if (textTitle3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle3.writeToParcel(parcel, flags);
            }
            parcel.writeString(this.inProgress);
        }

        public SetupRssiBottomSheet(String str, String str2, TextTitle textTitle, TextTitle textTitle2, String str3, String str4, TextTitle textTitle3, String str5) {
            this.title = str;
            this.subtitle = str2;
            this.okButton = textTitle;
            this.cancelButton = textTitle2;
            this.measureFailed = str3;
            this.measureSuccess = str4;
            this.successButton = textTitle3;
            this.inProgress = str5;
        }

        public /* synthetic */ SetupRssiBottomSheet(String str, String str2, TextTitle textTitle, TextTitle textTitle2, String str3, String str4, TextTitle textTitle3, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : textTitle, (i & 8) != 0 ? null : textTitle2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : textTitle3, (i & 128) == 0 ? str5 : null);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final TextTitle getOkButton() {
            return this.okButton;
        }

        public final TextTitle getCancelButton() {
            return this.cancelButton;
        }

        public final String getMeasureFailed() {
            return this.measureFailed;
        }

        public final String getMeasureSuccess() {
            return this.measureSuccess;
        }

        public final TextTitle getSuccessButton() {
            return this.successButton;
        }

        public final String getInProgress() {
            return this.inProgress;
        }
    }

    /* compiled from: BleLocale.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001f\u0010\u001e¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/entities/ble/BleLocale$PermissionsNotGrantedBottomSheet;", "Landroid/os/Parcelable;", "", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "okButton", "cancelButton", "<init>", "(Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getOkButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PermissionsNotGrantedBottomSheet implements Parcelable {
        public static final Parcelable.Creator<PermissionsNotGrantedBottomSheet> CREATOR = new Creator();

        @SerializedName("cancel_button")
        private final TextTitle cancelButton;

        @SerializedName("ok_button")
        private final TextTitle okButton;

        @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
        private final String title;

        /* compiled from: BleLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<PermissionsNotGrantedBottomSheet> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PermissionsNotGrantedBottomSheet createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PermissionsNotGrantedBottomSheet(parcel.readString(), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final PermissionsNotGrantedBottomSheet[] newArray(int i) {
                return new PermissionsNotGrantedBottomSheet[i];
            }
        }

        public PermissionsNotGrantedBottomSheet() {
            this(null, null, null, 7, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsNotGrantedBottomSheet)) {
                return false;
            }
            PermissionsNotGrantedBottomSheet permissionsNotGrantedBottomSheet = (PermissionsNotGrantedBottomSheet) other;
            return Intrinsics.areEqual(this.title, permissionsNotGrantedBottomSheet.title) && Intrinsics.areEqual(this.okButton, permissionsNotGrantedBottomSheet.okButton) && Intrinsics.areEqual(this.cancelButton, permissionsNotGrantedBottomSheet.cancelButton);
        }

        public int hashCode() {
            String str = this.title;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            TextTitle textTitle = this.okButton;
            int iHashCode2 = (iHashCode + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
            TextTitle textTitle2 = this.cancelButton;
            return iHashCode2 + (textTitle2 != null ? textTitle2.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsNotGrantedBottomSheet(title=" + this.title + ", okButton=" + this.okButton + ", cancelButton=" + this.cancelButton + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            TextTitle textTitle = this.okButton;
            if (textTitle == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle.writeToParcel(parcel, flags);
            }
            TextTitle textTitle2 = this.cancelButton;
            if (textTitle2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                textTitle2.writeToParcel(parcel, flags);
            }
        }

        public PermissionsNotGrantedBottomSheet(String str, TextTitle textTitle, TextTitle textTitle2) {
            this.title = str;
            this.okButton = textTitle;
            this.cancelButton = textTitle2;
        }

        public /* synthetic */ PermissionsNotGrantedBottomSheet(String str, TextTitle textTitle, TextTitle textTitle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : textTitle, (i & 4) != 0 ? null : textTitle2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final TextTitle getOkButton() {
            return this.okButton;
        }

        public final TextTitle getCancelButton() {
            return this.cancelButton;
        }
    }
}
