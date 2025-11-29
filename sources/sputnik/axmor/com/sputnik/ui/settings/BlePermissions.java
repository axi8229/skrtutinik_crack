package sputnik.axmor.com.sputnik.ui.settings;

import com.huawei.hms.support.api.location.common.LocationConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u0006\u001e"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/settings/BlePermissions;", "", "Lsputnik/axmor/com/sputnik/ui/settings/PermissionItem;", "locationPermission", "backgroundLocationPermission", "nearbyDevicesPermission", "notificationsPermission", "<init>", "(Lsputnik/axmor/com/sputnik/ui/settings/PermissionItem;Lsputnik/axmor/com/sputnik/ui/settings/PermissionItem;Lsputnik/axmor/com/sputnik/ui/settings/PermissionItem;Lsputnik/axmor/com/sputnik/ui/settings/PermissionItem;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lsputnik/axmor/com/sputnik/ui/settings/PermissionItem;", "getLocationPermission", "()Lsputnik/axmor/com/sputnik/ui/settings/PermissionItem;", "setLocationPermission", "(Lsputnik/axmor/com/sputnik/ui/settings/PermissionItem;)V", "getBackgroundLocationPermission", "setBackgroundLocationPermission", "getNearbyDevicesPermission", "setNearbyDevicesPermission", "getNotificationsPermission", "setNotificationsPermission", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BlePermissions {
    private PermissionItem backgroundLocationPermission;
    private PermissionItem locationPermission;
    private PermissionItem nearbyDevicesPermission;
    private PermissionItem notificationsPermission;

    public BlePermissions() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlePermissions)) {
            return false;
        }
        BlePermissions blePermissions = (BlePermissions) other;
        return Intrinsics.areEqual(this.locationPermission, blePermissions.locationPermission) && Intrinsics.areEqual(this.backgroundLocationPermission, blePermissions.backgroundLocationPermission) && Intrinsics.areEqual(this.nearbyDevicesPermission, blePermissions.nearbyDevicesPermission) && Intrinsics.areEqual(this.notificationsPermission, blePermissions.notificationsPermission);
    }

    public int hashCode() {
        return (((((this.locationPermission.hashCode() * 31) + this.backgroundLocationPermission.hashCode()) * 31) + this.nearbyDevicesPermission.hashCode()) * 31) + this.notificationsPermission.hashCode();
    }

    public String toString() {
        return "BlePermissions(locationPermission=" + this.locationPermission + ", backgroundLocationPermission=" + this.backgroundLocationPermission + ", nearbyDevicesPermission=" + this.nearbyDevicesPermission + ", notificationsPermission=" + this.notificationsPermission + ")";
    }

    public BlePermissions(PermissionItem locationPermission, PermissionItem backgroundLocationPermission, PermissionItem nearbyDevicesPermission, PermissionItem notificationsPermission) {
        Intrinsics.checkNotNullParameter(locationPermission, "locationPermission");
        Intrinsics.checkNotNullParameter(backgroundLocationPermission, "backgroundLocationPermission");
        Intrinsics.checkNotNullParameter(nearbyDevicesPermission, "nearbyDevicesPermission");
        Intrinsics.checkNotNullParameter(notificationsPermission, "notificationsPermission");
        this.locationPermission = locationPermission;
        this.backgroundLocationPermission = backgroundLocationPermission;
        this.nearbyDevicesPermission = nearbyDevicesPermission;
        this.notificationsPermission = notificationsPermission;
    }

    public /* synthetic */ BlePermissions(PermissionItem permissionItem, PermissionItem permissionItem2, PermissionItem permissionItem3, PermissionItem permissionItem4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new PermissionItem("android.permission.ACCESS_FINE_LOCATION", false, false, 6, null) : permissionItem, (i & 2) != 0 ? new PermissionItem(LocationConstant.BACKGROUND_PERMISSION, false, false, 6, null) : permissionItem2, (i & 4) != 0 ? new PermissionItem("android.permission.BLUETOOTH_SCAN", false, false, 6, null) : permissionItem3, (i & 8) != 0 ? new PermissionItem("android.permission.POST_NOTIFICATIONS", false, false, 6, null) : permissionItem4);
    }

    public final PermissionItem getLocationPermission() {
        return this.locationPermission;
    }

    public final void setLocationPermission(PermissionItem permissionItem) {
        Intrinsics.checkNotNullParameter(permissionItem, "<set-?>");
        this.locationPermission = permissionItem;
    }

    public final PermissionItem getBackgroundLocationPermission() {
        return this.backgroundLocationPermission;
    }

    public final void setBackgroundLocationPermission(PermissionItem permissionItem) {
        Intrinsics.checkNotNullParameter(permissionItem, "<set-?>");
        this.backgroundLocationPermission = permissionItem;
    }

    public final PermissionItem getNearbyDevicesPermission() {
        return this.nearbyDevicesPermission;
    }

    public final void setNearbyDevicesPermission(PermissionItem permissionItem) {
        Intrinsics.checkNotNullParameter(permissionItem, "<set-?>");
        this.nearbyDevicesPermission = permissionItem;
    }

    public final PermissionItem getNotificationsPermission() {
        return this.notificationsPermission;
    }

    public final void setNotificationsPermission(PermissionItem permissionItem) {
        Intrinsics.checkNotNullParameter(permissionItem, "<set-?>");
        this.notificationsPermission = permissionItem;
    }
}
