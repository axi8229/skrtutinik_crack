package com.sputnik.common.entities.localization.entities.permissions;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.pjsip.pjsua2.pjmedia_tp_proto;

/* compiled from: PermissionsLocale.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001:\u0001@BÇ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\"\u0010\u001cJ \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b0\u00101R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010/\u001a\u0004\b2\u00101R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010/\u001a\u0004\b3\u00101R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b4\u00101R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b5\u00101R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b6\u00101R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b7\u00101R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010/\u001a\u0004\b8\u00101R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b9\u00101R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010/\u001a\u0004\b:\u00101R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010/\u001a\u0004\b;\u00101R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b<\u0010+R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b=\u0010+R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010>\u001a\u0004\b?\u0010\u0019¨\u0006A"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "navigation", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "tapPermissions", "Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;", "bluetoothService", "locationService", "aboveOtherApps", "microphone", "notifications", "location", "locationIos", "nearbyDevices", "backgroundLocation", "whitelist", "backgroundWork", "openSettingsBtn", "setupBackgroundWorkBtn", "", "locationExplaining", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNavigation", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "getTapPermissions", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;", "getBluetoothService", "()Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;", "getLocationService", "getAboveOtherApps", "getMicrophone", "getNotifications", "getLocation", "getLocationIos", "getNearbyDevices", "getBackgroundLocation", "getWhitelist", "getBackgroundWork", "getOpenSettingsBtn", "getSetupBackgroundWorkBtn", "Ljava/lang/String;", "getLocationExplaining", "Permission", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PermissionsLocale implements Parcelable {
    public static final Parcelable.Creator<PermissionsLocale> CREATOR = new Creator();

    @SerializedName("above_other_apps")
    private final Permission aboveOtherApps;

    @SerializedName("background_location")
    private final Permission backgroundLocation;

    @SerializedName("background_work")
    private final Permission backgroundWork;

    @SerializedName("bluetooth_service")
    private final Permission bluetoothService;

    @SerializedName("location")
    private final Permission location;

    @SerializedName("location_explaining")
    private final String locationExplaining;

    @SerializedName("location_ios")
    private final Permission locationIos;

    @SerializedName("location_service")
    private final Permission locationService;

    @SerializedName("microphone")
    private final Permission microphone;
    private final TextTitle navigation;

    @SerializedName("nearby_devices")
    private final Permission nearbyDevices;

    @SerializedName("notifications")
    private final Permission notifications;

    @SerializedName("open_settings_btn")
    private final TextTitle openSettingsBtn;

    @SerializedName("setup_background_work_btn")
    private final TextTitle setupBackgroundWorkBtn;

    @SerializedName("tap_permissions")
    private final TitleWithParam tapPermissions;

    @SerializedName("whitelist")
    private final Permission whitelist;

    /* compiled from: PermissionsLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PermissionsLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermissionsLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PermissionsLocale(parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TitleWithParam.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Permission.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : TextTitle.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? TextTitle.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PermissionsLocale[] newArray(int i) {
            return new PermissionsLocale[i];
        }
    }

    public PermissionsLocale() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionsLocale)) {
            return false;
        }
        PermissionsLocale permissionsLocale = (PermissionsLocale) other;
        return Intrinsics.areEqual(this.navigation, permissionsLocale.navigation) && Intrinsics.areEqual(this.tapPermissions, permissionsLocale.tapPermissions) && Intrinsics.areEqual(this.bluetoothService, permissionsLocale.bluetoothService) && Intrinsics.areEqual(this.locationService, permissionsLocale.locationService) && Intrinsics.areEqual(this.aboveOtherApps, permissionsLocale.aboveOtherApps) && Intrinsics.areEqual(this.microphone, permissionsLocale.microphone) && Intrinsics.areEqual(this.notifications, permissionsLocale.notifications) && Intrinsics.areEqual(this.location, permissionsLocale.location) && Intrinsics.areEqual(this.locationIos, permissionsLocale.locationIos) && Intrinsics.areEqual(this.nearbyDevices, permissionsLocale.nearbyDevices) && Intrinsics.areEqual(this.backgroundLocation, permissionsLocale.backgroundLocation) && Intrinsics.areEqual(this.whitelist, permissionsLocale.whitelist) && Intrinsics.areEqual(this.backgroundWork, permissionsLocale.backgroundWork) && Intrinsics.areEqual(this.openSettingsBtn, permissionsLocale.openSettingsBtn) && Intrinsics.areEqual(this.setupBackgroundWorkBtn, permissionsLocale.setupBackgroundWorkBtn) && Intrinsics.areEqual(this.locationExplaining, permissionsLocale.locationExplaining);
    }

    public int hashCode() {
        TextTitle textTitle = this.navigation;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        TitleWithParam titleWithParam = this.tapPermissions;
        int iHashCode2 = (iHashCode + (titleWithParam == null ? 0 : titleWithParam.hashCode())) * 31;
        Permission permission = this.bluetoothService;
        int iHashCode3 = (iHashCode2 + (permission == null ? 0 : permission.hashCode())) * 31;
        Permission permission2 = this.locationService;
        int iHashCode4 = (iHashCode3 + (permission2 == null ? 0 : permission2.hashCode())) * 31;
        Permission permission3 = this.aboveOtherApps;
        int iHashCode5 = (iHashCode4 + (permission3 == null ? 0 : permission3.hashCode())) * 31;
        Permission permission4 = this.microphone;
        int iHashCode6 = (iHashCode5 + (permission4 == null ? 0 : permission4.hashCode())) * 31;
        Permission permission5 = this.notifications;
        int iHashCode7 = (iHashCode6 + (permission5 == null ? 0 : permission5.hashCode())) * 31;
        Permission permission6 = this.location;
        int iHashCode8 = (iHashCode7 + (permission6 == null ? 0 : permission6.hashCode())) * 31;
        Permission permission7 = this.locationIos;
        int iHashCode9 = (iHashCode8 + (permission7 == null ? 0 : permission7.hashCode())) * 31;
        Permission permission8 = this.nearbyDevices;
        int iHashCode10 = (iHashCode9 + (permission8 == null ? 0 : permission8.hashCode())) * 31;
        Permission permission9 = this.backgroundLocation;
        int iHashCode11 = (iHashCode10 + (permission9 == null ? 0 : permission9.hashCode())) * 31;
        Permission permission10 = this.whitelist;
        int iHashCode12 = (iHashCode11 + (permission10 == null ? 0 : permission10.hashCode())) * 31;
        Permission permission11 = this.backgroundWork;
        int iHashCode13 = (iHashCode12 + (permission11 == null ? 0 : permission11.hashCode())) * 31;
        TextTitle textTitle2 = this.openSettingsBtn;
        int iHashCode14 = (iHashCode13 + (textTitle2 == null ? 0 : textTitle2.hashCode())) * 31;
        TextTitle textTitle3 = this.setupBackgroundWorkBtn;
        int iHashCode15 = (iHashCode14 + (textTitle3 == null ? 0 : textTitle3.hashCode())) * 31;
        String str = this.locationExplaining;
        return iHashCode15 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "PermissionsLocale(navigation=" + this.navigation + ", tapPermissions=" + this.tapPermissions + ", bluetoothService=" + this.bluetoothService + ", locationService=" + this.locationService + ", aboveOtherApps=" + this.aboveOtherApps + ", microphone=" + this.microphone + ", notifications=" + this.notifications + ", location=" + this.location + ", locationIos=" + this.locationIos + ", nearbyDevices=" + this.nearbyDevices + ", backgroundLocation=" + this.backgroundLocation + ", whitelist=" + this.whitelist + ", backgroundWork=" + this.backgroundWork + ", openSettingsBtn=" + this.openSettingsBtn + ", setupBackgroundWorkBtn=" + this.setupBackgroundWorkBtn + ", locationExplaining=" + this.locationExplaining + ")";
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
        TitleWithParam titleWithParam = this.tapPermissions;
        if (titleWithParam == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            titleWithParam.writeToParcel(parcel, flags);
        }
        Permission permission = this.bluetoothService;
        if (permission == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission.writeToParcel(parcel, flags);
        }
        Permission permission2 = this.locationService;
        if (permission2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission2.writeToParcel(parcel, flags);
        }
        Permission permission3 = this.aboveOtherApps;
        if (permission3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission3.writeToParcel(parcel, flags);
        }
        Permission permission4 = this.microphone;
        if (permission4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission4.writeToParcel(parcel, flags);
        }
        Permission permission5 = this.notifications;
        if (permission5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission5.writeToParcel(parcel, flags);
        }
        Permission permission6 = this.location;
        if (permission6 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission6.writeToParcel(parcel, flags);
        }
        Permission permission7 = this.locationIos;
        if (permission7 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission7.writeToParcel(parcel, flags);
        }
        Permission permission8 = this.nearbyDevices;
        if (permission8 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission8.writeToParcel(parcel, flags);
        }
        Permission permission9 = this.backgroundLocation;
        if (permission9 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission9.writeToParcel(parcel, flags);
        }
        Permission permission10 = this.whitelist;
        if (permission10 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission10.writeToParcel(parcel, flags);
        }
        Permission permission11 = this.backgroundWork;
        if (permission11 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            permission11.writeToParcel(parcel, flags);
        }
        TextTitle textTitle2 = this.openSettingsBtn;
        if (textTitle2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle2.writeToParcel(parcel, flags);
        }
        TextTitle textTitle3 = this.setupBackgroundWorkBtn;
        if (textTitle3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            textTitle3.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.locationExplaining);
    }

    public PermissionsLocale(TextTitle textTitle, TitleWithParam titleWithParam, Permission permission, Permission permission2, Permission permission3, Permission permission4, Permission permission5, Permission permission6, Permission permission7, Permission permission8, Permission permission9, Permission permission10, Permission permission11, TextTitle textTitle2, TextTitle textTitle3, String str) {
        this.navigation = textTitle;
        this.tapPermissions = titleWithParam;
        this.bluetoothService = permission;
        this.locationService = permission2;
        this.aboveOtherApps = permission3;
        this.microphone = permission4;
        this.notifications = permission5;
        this.location = permission6;
        this.locationIos = permission7;
        this.nearbyDevices = permission8;
        this.backgroundLocation = permission9;
        this.whitelist = permission10;
        this.backgroundWork = permission11;
        this.openSettingsBtn = textTitle2;
        this.setupBackgroundWorkBtn = textTitle3;
        this.locationExplaining = str;
    }

    public /* synthetic */ PermissionsLocale(TextTitle textTitle, TitleWithParam titleWithParam, Permission permission, Permission permission2, Permission permission3, Permission permission4, Permission permission5, Permission permission6, Permission permission7, Permission permission8, Permission permission9, Permission permission10, Permission permission11, TextTitle textTitle2, TextTitle textTitle3, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : titleWithParam, (i & 4) != 0 ? null : permission, (i & 8) != 0 ? null : permission2, (i & 16) != 0 ? null : permission3, (i & 32) != 0 ? null : permission4, (i & 64) != 0 ? null : permission5, (i & 128) != 0 ? null : permission6, (i & 256) != 0 ? null : permission7, (i & 512) != 0 ? null : permission8, (i & 1024) != 0 ? null : permission9, (i & 2048) != 0 ? null : permission10, (i & 4096) != 0 ? null : permission11, (i & 8192) != 0 ? null : textTitle2, (i & 16384) != 0 ? null : textTitle3, (i & pjmedia_tp_proto.PJMEDIA_TP_PROFILE_AVP) != 0 ? null : str);
    }

    public final TextTitle getNavigation() {
        return this.navigation;
    }

    public final TitleWithParam getTapPermissions() {
        return this.tapPermissions;
    }

    public final Permission getBluetoothService() {
        return this.bluetoothService;
    }

    public final Permission getLocationService() {
        return this.locationService;
    }

    public final Permission getAboveOtherApps() {
        return this.aboveOtherApps;
    }

    public final Permission getNotifications() {
        return this.notifications;
    }

    public final Permission getLocation() {
        return this.location;
    }

    public final Permission getNearbyDevices() {
        return this.nearbyDevices;
    }

    public final Permission getWhitelist() {
        return this.whitelist;
    }

    public final Permission getBackgroundWork() {
        return this.backgroundWork;
    }

    public final TextTitle getOpenSettingsBtn() {
        return this.openSettingsBtn;
    }

    public final TextTitle getSetupBackgroundWorkBtn() {
        return this.setupBackgroundWorkBtn;
    }

    public final String getLocationExplaining() {
        return this.locationExplaining;
    }

    /* compiled from: PermissionsLocale.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\fR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/permissions/PermissionsLocale$Permission;", "Landroid/os/Parcelable;", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "explain", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "items", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getName", "getExplain", "getTitle", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Permission implements Parcelable {
        public static final Parcelable.Creator<Permission> CREATOR = new Creator();

        @SerializedName("explain")
        private final String explain;

        @SerializedName("items")
        private final List<TitleWithParam> items;

        @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
        private final String name;

        @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
        private final String title;

        /* compiled from: PermissionsLocale.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Permission> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Permission createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String string = parcel.readString();
                String string2 = parcel.readString();
                String string3 = parcel.readString();
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(i);
                    for (int i2 = 0; i2 != i; i2++) {
                        arrayList2.add(TitleWithParam.CREATOR.createFromParcel(parcel));
                    }
                    arrayList = arrayList2;
                }
                return new Permission(string, string2, string3, arrayList);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Permission[] newArray(int i) {
                return new Permission[i];
            }
        }

        public Permission() {
            this(null, null, null, null, 15, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Permission)) {
                return false;
            }
            Permission permission = (Permission) other;
            return Intrinsics.areEqual(this.name, permission.name) && Intrinsics.areEqual(this.explain, permission.explain) && Intrinsics.areEqual(this.title, permission.title) && Intrinsics.areEqual(this.items, permission.items);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.explain;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.title;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            List<TitleWithParam> list = this.items;
            return iHashCode3 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Permission(name=" + this.name + ", explain=" + this.explain + ", title=" + this.title + ", items=" + this.items + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.name);
            parcel.writeString(this.explain);
            parcel.writeString(this.title);
            List<TitleWithParam> list = this.items;
            if (list == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<TitleWithParam> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }

        public Permission(String str, String str2, String str3, List<TitleWithParam> list) {
            this.name = str;
            this.explain = str2;
            this.title = str3;
            this.items = list;
        }

        public /* synthetic */ Permission(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list);
        }

        public final String getName() {
            return this.name;
        }

        public final String getExplain() {
            return this.explain;
        }

        public final String getTitle() {
            return this.title;
        }

        public final List<TitleWithParam> getItems() {
            return this.items;
        }
    }
}
