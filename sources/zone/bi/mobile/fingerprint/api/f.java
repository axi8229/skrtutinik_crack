package zone.bi.mobile.fingerprint.api;

/* loaded from: classes5.dex */
public enum f {
    UnknownSources(true, Integer.class),
    DeveloperTools(true, Integer.class),
    HoursSinceInstall(false, zone.bi.mobile.fingerprint.api.serialize.model.a.class),
    HoursSinceQSInstall(true, Integer.class),
    HoursSinceAnyDeskInstall(true, Integer.class),
    HoursSinceZoomInstall(true, Integer.class),
    HoursSinceDiscordInstall(true, Integer.class),
    HoursSinceAwerayRemoteInstall(true, Integer.class),
    HoursSinceAweSunClientInstall(true, Integer.class),
    HoursSinceAirdroidInstall(true, Integer.class),
    HoursSinceAircastInstall(true, Integer.class),
    HoursSinceAirdroidRemoteSupportInstall(true, Integer.class),
    HoursSinceAirmirrorInstall(true, Integer.class),
    HoursSinceMirPaySInstall(true, Integer.class),
    HoursSinceSbpPaySInstall(true, Integer.class),
    HoursSinceRustDeskRDInstall(true, Integer.class),
    GooglePlayProtect(true, Integer.class),
    Emulator(true, Integer.class),
    TIMESTAMP(true, String.class),
    HardwareID(false, String.class),
    SIM_ID(false, String.class),
    PhoneNumber(false, String.class),
    DeviceModel(true, String.class),
    DeviceName(true, String.class),
    DeviceSystemName(true, String.class),
    DeviceSystemVersion(true, String.class),
    Languages(true, String.class),
    CellTowerId(false, String.class),
    LocationAreaCode(false, String.class),
    ScreenSize(true, String.class),
    MCC(false, String.class),
    MNC(false, String.class),
    AppKey(true, String.class, "uniqueID"),
    SDK_VERSION(true, String.class),
    Compromised(true, Integer.class),
    MultitaskingSupported(true, Boolean.class),
    AdvertiserId(false, String.class, "adsId"),
    AppSetIdScopeApp(false, String.class, "appSetIdScopeApp"),
    AppSetIdScopeDeveloper(false, String.class, "appSetIdScopeDeveloper"),
    OS_ID(false, String.class),
    GeoLocationInfo(true, zone.bi.mobile.fingerprint.api.serialize.model.d.class, "cachingGeoLocationTimeName"),
    Longitude(true, String.class, "cachingLongitude"),
    Latitude(true, String.class, "cachingLatitude"),
    HorizontalAccuracy(true, String.class, "cachingHorizontalAccuracy"),
    Altitude(true, String.class, "cachingAltitude"),
    AltitudeAccuracy(true, String.class, "cachingVerticalAccuracy"),
    Heading(true, String.class, "cachingHeading"),
    Speed(true, String.class, "cachingSpeed"),
    Status(true, String.class),
    Timestamp(true, String.class, "cachingTimeStamp"),
    RSA_ApplicationKey(false, String.class),
    AgentBrand(true, String.class),
    AgentBootTime(true, String.class),
    TimeZone(true, String.class),
    SupportedAPILevel(true, String.class),
    OSCodeName(true, String.class),
    AgentAppInfo(true, String.class),
    ApprepInstalledApps(true, String.class),
    OSFontsNumber(true, String.class),
    OSFontsHash(true, Integer.class),
    ScreenColorDepth(true, String.class),
    TimeZoneDSTOffset(true, String.class),
    SimCard(true, String.class),
    AgentSignalStrengthCellular(true, String.class),
    AgentConnectionType(false, String.class),
    AgentSignalTypeCellular(true, String.class),
    LocalIPv4(false, String.class),
    LocalIPv6(false, String.class),
    DnsIP(true, String.class),
    RdpConnection(true, String.class),
    RdpConnectionDuration(true, Integer.class),
    LocationHash(true, String.class),
    ApplicationMD5(false, String.class),
    InstallationSource(false, String.class),
    PhoneCallState(true, Integer.class),
    PhoneCallDirection(true, Integer.class),
    GoogleServicesParameters(false, zone.bi.mobile.fingerprint.api.serialize.model.a.class),
    GoogleServicesDeviceId(false, String.class),
    AccessibilityServices(false, zone.bi.mobile.fingerprint.api.serialize.model.a.class),
    AuthenticationInfo(false, zone.bi.mobile.fingerprint.api.serialize.model.a.class),
    ShareScreen(false, Boolean.class),
    ShareScreenInfo(false, zone.bi.mobile.fingerprint.api.serialize.model.a.class),
    Debugger(true, Integer.class),
    VpnConnection(false, Boolean.class),
    BootId(false, String.class),
    BootCount(false, Integer.class);

    public final Class a;
    public final boolean b;
    public final String c;

    f(boolean z, Class cls) {
        this.b = z;
        this.a = cls;
        this.c = null;
    }

    public final String a() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        return "fp_" + name();
    }

    f(boolean z, Class cls, String str) {
        this.b = z;
        this.a = cls;
        this.c = str;
    }
}
