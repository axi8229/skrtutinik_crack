package sputnik.axmor.com.sputnik.ui.settings;

import com.huawei.hms.push.AttributionReporter;
import com.sputnik.common.base.VMState;
import com.sputnik.data.entities.cameras.CameraPreferences;
import com.sputnik.domain.common.Event;
import com.sputnik.domain.entities.prefs.AppSettings;
import com.sputnik.domain.entities.prefs.DebugToolsSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0012\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0092\u0001\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0012HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b%\u0010\u001aR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b)\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b\u000b\u0010+R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00102\u001a\u0004\b3\u00104R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u00105\u001a\u0004\b6\u00107R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u00105\u001a\u0004\b8\u00107¨\u00069"}, d2 = {"Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;", "Lcom/sputnik/common/base/VMState;", "", "baseUrl", "lastAccruedDate", AttributionReporter.APP_VERSION, "", "Lcom/sputnik/data/entities/cameras/CameraPreferences;", "adaptiveZoomPreferences", "jwt", "", "isPaymentsEnvironmentEnabled", "Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;", "debugToolsSettings", "Lsputnik/axmor/com/sputnik/ui/settings/AppState;", "appState", "Lcom/sputnik/domain/entities/prefs/AppSettings;", "appSettings", "Lcom/sputnik/domain/common/Event;", "needToShowNoPermissionsScreen", "needLaunchBleServiceAfterRequestingPermissions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLcom/sputnik/domain/entities/prefs/DebugToolsSettings;Lsputnik/axmor/com/sputnik/ui/settings/AppState;Lcom/sputnik/domain/entities/prefs/AppSettings;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLcom/sputnik/domain/entities/prefs/DebugToolsSettings;Lsputnik/axmor/com/sputnik/ui/settings/AppState;Lcom/sputnik/domain/entities/prefs/AppSettings;Lcom/sputnik/domain/common/Event;Lcom/sputnik/domain/common/Event;)Lsputnik/axmor/com/sputnik/ui/settings/SettingsViewState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBaseUrl", "getLastAccruedDate", "getAppVersion", "Ljava/util/List;", "getAdaptiveZoomPreferences", "()Ljava/util/List;", "getJwt", "Z", "()Z", "Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;", "getDebugToolsSettings", "()Lcom/sputnik/domain/entities/prefs/DebugToolsSettings;", "Lsputnik/axmor/com/sputnik/ui/settings/AppState;", "getAppState", "()Lsputnik/axmor/com/sputnik/ui/settings/AppState;", "Lcom/sputnik/domain/entities/prefs/AppSettings;", "getAppSettings", "()Lcom/sputnik/domain/entities/prefs/AppSettings;", "Lcom/sputnik/domain/common/Event;", "getNeedToShowNoPermissionsScreen", "()Lcom/sputnik/domain/common/Event;", "getNeedLaunchBleServiceAfterRequestingPermissions", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SettingsViewState implements VMState {
    private final List<CameraPreferences> adaptiveZoomPreferences;
    private final AppSettings appSettings;
    private final AppState appState;
    private final String appVersion;
    private final String baseUrl;
    private final DebugToolsSettings debugToolsSettings;
    private final boolean isPaymentsEnvironmentEnabled;
    private final String jwt;
    private final String lastAccruedDate;
    private final Event<Boolean> needLaunchBleServiceAfterRequestingPermissions;
    private final Event<Boolean> needToShowNoPermissionsScreen;

    public SettingsViewState() {
        this(null, null, null, null, null, false, null, null, null, null, null, 2047, null);
    }

    public final SettingsViewState copy(String baseUrl, String lastAccruedDate, String appVersion, List<CameraPreferences> adaptiveZoomPreferences, String jwt, boolean isPaymentsEnvironmentEnabled, DebugToolsSettings debugToolsSettings, AppState appState, AppSettings appSettings, Event<Boolean> needToShowNoPermissionsScreen, Event<Boolean> needLaunchBleServiceAfterRequestingPermissions) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(lastAccruedDate, "lastAccruedDate");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(adaptiveZoomPreferences, "adaptiveZoomPreferences");
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        Intrinsics.checkNotNullParameter(appState, "appState");
        Intrinsics.checkNotNullParameter(appSettings, "appSettings");
        Intrinsics.checkNotNullParameter(needToShowNoPermissionsScreen, "needToShowNoPermissionsScreen");
        Intrinsics.checkNotNullParameter(needLaunchBleServiceAfterRequestingPermissions, "needLaunchBleServiceAfterRequestingPermissions");
        return new SettingsViewState(baseUrl, lastAccruedDate, appVersion, adaptiveZoomPreferences, jwt, isPaymentsEnvironmentEnabled, debugToolsSettings, appState, appSettings, needToShowNoPermissionsScreen, needLaunchBleServiceAfterRequestingPermissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsViewState)) {
            return false;
        }
        SettingsViewState settingsViewState = (SettingsViewState) other;
        return Intrinsics.areEqual(this.baseUrl, settingsViewState.baseUrl) && Intrinsics.areEqual(this.lastAccruedDate, settingsViewState.lastAccruedDate) && Intrinsics.areEqual(this.appVersion, settingsViewState.appVersion) && Intrinsics.areEqual(this.adaptiveZoomPreferences, settingsViewState.adaptiveZoomPreferences) && Intrinsics.areEqual(this.jwt, settingsViewState.jwt) && this.isPaymentsEnvironmentEnabled == settingsViewState.isPaymentsEnvironmentEnabled && Intrinsics.areEqual(this.debugToolsSettings, settingsViewState.debugToolsSettings) && Intrinsics.areEqual(this.appState, settingsViewState.appState) && Intrinsics.areEqual(this.appSettings, settingsViewState.appSettings) && Intrinsics.areEqual(this.needToShowNoPermissionsScreen, settingsViewState.needToShowNoPermissionsScreen) && Intrinsics.areEqual(this.needLaunchBleServiceAfterRequestingPermissions, settingsViewState.needLaunchBleServiceAfterRequestingPermissions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((((((this.baseUrl.hashCode() * 31) + this.lastAccruedDate.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.adaptiveZoomPreferences.hashCode()) * 31) + this.jwt.hashCode()) * 31;
        boolean z = this.isPaymentsEnvironmentEnabled;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        DebugToolsSettings debugToolsSettings = this.debugToolsSettings;
        return ((((((((i2 + (debugToolsSettings == null ? 0 : debugToolsSettings.hashCode())) * 31) + this.appState.hashCode()) * 31) + this.appSettings.hashCode()) * 31) + this.needToShowNoPermissionsScreen.hashCode()) * 31) + this.needLaunchBleServiceAfterRequestingPermissions.hashCode();
    }

    public String toString() {
        return "SettingsViewState(baseUrl=" + this.baseUrl + ", lastAccruedDate=" + this.lastAccruedDate + ", appVersion=" + this.appVersion + ", adaptiveZoomPreferences=" + this.adaptiveZoomPreferences + ", jwt=" + this.jwt + ", isPaymentsEnvironmentEnabled=" + this.isPaymentsEnvironmentEnabled + ", debugToolsSettings=" + this.debugToolsSettings + ", appState=" + this.appState + ", appSettings=" + this.appSettings + ", needToShowNoPermissionsScreen=" + this.needToShowNoPermissionsScreen + ", needLaunchBleServiceAfterRequestingPermissions=" + this.needLaunchBleServiceAfterRequestingPermissions + ")";
    }

    public SettingsViewState(String baseUrl, String lastAccruedDate, String appVersion, List<CameraPreferences> adaptiveZoomPreferences, String jwt, boolean z, DebugToolsSettings debugToolsSettings, AppState appState, AppSettings appSettings, Event<Boolean> needToShowNoPermissionsScreen, Event<Boolean> needLaunchBleServiceAfterRequestingPermissions) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(lastAccruedDate, "lastAccruedDate");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(adaptiveZoomPreferences, "adaptiveZoomPreferences");
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        Intrinsics.checkNotNullParameter(appState, "appState");
        Intrinsics.checkNotNullParameter(appSettings, "appSettings");
        Intrinsics.checkNotNullParameter(needToShowNoPermissionsScreen, "needToShowNoPermissionsScreen");
        Intrinsics.checkNotNullParameter(needLaunchBleServiceAfterRequestingPermissions, "needLaunchBleServiceAfterRequestingPermissions");
        this.baseUrl = baseUrl;
        this.lastAccruedDate = lastAccruedDate;
        this.appVersion = appVersion;
        this.adaptiveZoomPreferences = adaptiveZoomPreferences;
        this.jwt = jwt;
        this.isPaymentsEnvironmentEnabled = z;
        this.debugToolsSettings = debugToolsSettings;
        this.appState = appState;
        this.appSettings = appSettings;
        this.needToShowNoPermissionsScreen = needToShowNoPermissionsScreen;
        this.needLaunchBleServiceAfterRequestingPermissions = needLaunchBleServiceAfterRequestingPermissions;
    }

    public /* synthetic */ SettingsViewState(String str, String str2, String str3, List list, String str4, boolean z, DebugToolsSettings debugToolsSettings, AppState appState, AppSettings appSettings, Event event, Event event2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) == 0 ? str4 : "", (i & 32) != 0 ? false : z, (i & 64) != 0 ? null : debugToolsSettings, (i & 128) != 0 ? new AppState(false, false, false, null, false, false, false, 127, null) : appState, (i & 256) != 0 ? new AppSettings((AppSettings.BleSettings) null, (Boolean) null, 3, (DefaultConstructorMarker) null) : appSettings, (i & 512) != 0 ? new Event(Boolean.FALSE) : event, (i & 1024) != 0 ? new Event(Boolean.FALSE) : event2);
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getLastAccruedDate() {
        return this.lastAccruedDate;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getJwt() {
        return this.jwt;
    }

    /* renamed from: isPaymentsEnvironmentEnabled, reason: from getter */
    public final boolean getIsPaymentsEnvironmentEnabled() {
        return this.isPaymentsEnvironmentEnabled;
    }

    public final DebugToolsSettings getDebugToolsSettings() {
        return this.debugToolsSettings;
    }

    public final AppState getAppState() {
        return this.appState;
    }

    public final AppSettings getAppSettings() {
        return this.appSettings;
    }

    public final Event<Boolean> getNeedToShowNoPermissionsScreen() {
        return this.needToShowNoPermissionsScreen;
    }

    public final Event<Boolean> getNeedLaunchBleServiceAfterRequestingPermissions() {
        return this.needLaunchBleServiceAfterRequestingPermissions;
    }
}
