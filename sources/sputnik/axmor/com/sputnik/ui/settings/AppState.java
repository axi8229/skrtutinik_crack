package sputnik.axmor.com.sputnik.ui.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJV\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001eR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b$\u0010\u001aR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001e¨\u0006'"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/settings/AppState;", "", "", "bluetoothEnabled", "gpsEnabled", "blePermissionsGranted", "Lsputnik/axmor/com/sputnik/ui/settings/BlePermissions;", "blePermissions", "appInWhiteList", "backgroundWorkAllowed", "displayOverOtherAppsAllowed", "<init>", "(ZZZLsputnik/axmor/com/sputnik/ui/settings/BlePermissions;ZZZ)V", "copy", "(ZZZLsputnik/axmor/com/sputnik/ui/settings/BlePermissions;ZZZ)Lsputnik/axmor/com/sputnik/ui/settings/AppState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getBluetoothEnabled", "()Z", "getGpsEnabled", "getBlePermissionsGranted", "setBlePermissionsGranted", "(Z)V", "Lsputnik/axmor/com/sputnik/ui/settings/BlePermissions;", "getBlePermissions", "()Lsputnik/axmor/com/sputnik/ui/settings/BlePermissions;", "getAppInWhiteList", "setAppInWhiteList", "getBackgroundWorkAllowed", "getDisplayOverOtherAppsAllowed", "setDisplayOverOtherAppsAllowed", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AppState {
    private boolean appInWhiteList;
    private final boolean backgroundWorkAllowed;
    private final BlePermissions blePermissions;
    private boolean blePermissionsGranted;
    private final boolean bluetoothEnabled;
    private boolean displayOverOtherAppsAllowed;
    private final boolean gpsEnabled;

    public AppState() {
        this(false, false, false, null, false, false, false, 127, null);
    }

    public static /* synthetic */ AppState copy$default(AppState appState, boolean z, boolean z2, boolean z3, BlePermissions blePermissions, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if ((i & 1) != 0) {
            z = appState.bluetoothEnabled;
        }
        if ((i & 2) != 0) {
            z2 = appState.gpsEnabled;
        }
        boolean z7 = z2;
        if ((i & 4) != 0) {
            z3 = appState.blePermissionsGranted;
        }
        boolean z8 = z3;
        if ((i & 8) != 0) {
            blePermissions = appState.blePermissions;
        }
        BlePermissions blePermissions2 = blePermissions;
        if ((i & 16) != 0) {
            z4 = appState.appInWhiteList;
        }
        boolean z9 = z4;
        if ((i & 32) != 0) {
            z5 = appState.backgroundWorkAllowed;
        }
        boolean z10 = z5;
        if ((i & 64) != 0) {
            z6 = appState.displayOverOtherAppsAllowed;
        }
        return appState.copy(z, z7, z8, blePermissions2, z9, z10, z6);
    }

    public final AppState copy(boolean bluetoothEnabled, boolean gpsEnabled, boolean blePermissionsGranted, BlePermissions blePermissions, boolean appInWhiteList, boolean backgroundWorkAllowed, boolean displayOverOtherAppsAllowed) {
        Intrinsics.checkNotNullParameter(blePermissions, "blePermissions");
        return new AppState(bluetoothEnabled, gpsEnabled, blePermissionsGranted, blePermissions, appInWhiteList, backgroundWorkAllowed, displayOverOtherAppsAllowed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppState)) {
            return false;
        }
        AppState appState = (AppState) other;
        return this.bluetoothEnabled == appState.bluetoothEnabled && this.gpsEnabled == appState.gpsEnabled && this.blePermissionsGranted == appState.blePermissionsGranted && Intrinsics.areEqual(this.blePermissions, appState.blePermissions) && this.appInWhiteList == appState.appInWhiteList && this.backgroundWorkAllowed == appState.backgroundWorkAllowed && this.displayOverOtherAppsAllowed == appState.displayOverOtherAppsAllowed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z = this.bluetoothEnabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.gpsEnabled;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.blePermissionsGranted;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int iHashCode = (((i3 + i4) * 31) + this.blePermissions.hashCode()) * 31;
        ?? r23 = this.appInWhiteList;
        int i5 = r23;
        if (r23 != 0) {
            i5 = 1;
        }
        int i6 = (iHashCode + i5) * 31;
        ?? r24 = this.backgroundWorkAllowed;
        int i7 = r24;
        if (r24 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        boolean z2 = this.displayOverOtherAppsAllowed;
        return i8 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "AppState(bluetoothEnabled=" + this.bluetoothEnabled + ", gpsEnabled=" + this.gpsEnabled + ", blePermissionsGranted=" + this.blePermissionsGranted + ", blePermissions=" + this.blePermissions + ", appInWhiteList=" + this.appInWhiteList + ", backgroundWorkAllowed=" + this.backgroundWorkAllowed + ", displayOverOtherAppsAllowed=" + this.displayOverOtherAppsAllowed + ")";
    }

    public AppState(boolean z, boolean z2, boolean z3, BlePermissions blePermissions, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(blePermissions, "blePermissions");
        this.bluetoothEnabled = z;
        this.gpsEnabled = z2;
        this.blePermissionsGranted = z3;
        this.blePermissions = blePermissions;
        this.appInWhiteList = z4;
        this.backgroundWorkAllowed = z5;
        this.displayOverOtherAppsAllowed = z6;
    }

    public final boolean getBluetoothEnabled() {
        return this.bluetoothEnabled;
    }

    public final boolean getGpsEnabled() {
        return this.gpsEnabled;
    }

    public final boolean getBlePermissionsGranted() {
        return this.blePermissionsGranted;
    }

    public final void setBlePermissionsGranted(boolean z) {
        this.blePermissionsGranted = z;
    }

    public /* synthetic */ AppState(boolean z, boolean z2, boolean z3, BlePermissions blePermissions, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? new BlePermissions(null, null, null, null, 15, null) : blePermissions, (i & 16) != 0 ? false : z4, (i & 32) != 0 ? false : z5, (i & 64) == 0 ? z6 : false);
    }

    public final BlePermissions getBlePermissions() {
        return this.blePermissions;
    }

    public final boolean getAppInWhiteList() {
        return this.appInWhiteList;
    }

    public final boolean getDisplayOverOtherAppsAllowed() {
        return this.displayOverOtherAppsAllowed;
    }
}
