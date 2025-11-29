package zone.bi.mobile.fingerprint.api;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class d {
    public static final d b;
    public static final /* synthetic */ d[] c;
    public final f[] a;

    /* JADX INFO: Fake field, exist only in values array */
    d EF0;

    static {
        f fVar = f.TIMESTAMP;
        f fVar2 = f.HardwareID;
        f fVar3 = f.SIM_ID;
        f fVar4 = f.PhoneNumber;
        f fVar5 = f.DeviceModel;
        f fVar6 = f.DeviceName;
        f fVar7 = f.DeviceSystemName;
        f fVar8 = f.DeviceSystemVersion;
        f fVar9 = f.Languages;
        f fVar10 = f.CellTowerId;
        f fVar11 = f.LocationAreaCode;
        f fVar12 = f.ScreenSize;
        f fVar13 = f.MCC;
        f fVar14 = f.MNC;
        f fVar15 = f.AppKey;
        f fVar16 = f.SDK_VERSION;
        f fVar17 = f.Compromised;
        f fVar18 = f.MultitaskingSupported;
        f fVar19 = f.AdvertiserId;
        f fVar20 = f.OS_ID;
        f fVar21 = f.Emulator;
        d dVar = new d("BASIC", 0, fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12, fVar13, fVar14, fVar15, fVar16, fVar17, fVar18, fVar19, fVar20, fVar21);
        f fVar22 = f.GeoLocationInfo;
        d dVar2 = new d("BASIC_WITH_COORD", 1, fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12, fVar13, fVar14, fVar15, fVar16, fVar17, fVar18, fVar19, fVar20, fVar21, fVar22);
        f fVar23 = f.DeveloperTools;
        f fVar24 = f.GooglePlayProtect;
        f fVar25 = f.HoursSinceInstall;
        f fVar26 = f.UnknownSources;
        f fVar27 = f.RSA_ApplicationKey;
        f fVar28 = f.AgentBrand;
        f fVar29 = f.AgentBootTime;
        f fVar30 = f.TimeZone;
        f fVar31 = f.SupportedAPILevel;
        f fVar32 = f.OSCodeName;
        f fVar33 = f.AgentAppInfo;
        f fVar34 = f.ApprepInstalledApps;
        f fVar35 = f.OSFontsNumber;
        f fVar36 = f.OSFontsHash;
        f fVar37 = f.ScreenColorDepth;
        f fVar38 = f.TimeZoneDSTOffset;
        f fVar39 = f.SimCard;
        f fVar40 = f.AgentSignalStrengthCellular;
        f fVar41 = f.AgentConnectionType;
        f fVar42 = f.AgentSignalTypeCellular;
        f fVar43 = f.LocalIPv4;
        f fVar44 = f.LocalIPv6;
        f fVar45 = f.DnsIP;
        f fVar46 = f.LocationHash;
        f fVar47 = f.ApplicationMD5;
        f fVar48 = f.RdpConnection;
        f fVar49 = f.RdpConnectionDuration;
        f fVar50 = f.VpnConnection;
        f fVar51 = f.InstallationSource;
        f fVar52 = f.PhoneCallState;
        f fVar53 = f.PhoneCallDirection;
        f fVar54 = f.GoogleServicesParameters;
        f fVar55 = f.AccessibilityServices;
        f fVar56 = f.AuthenticationInfo;
        f fVar57 = f.ShareScreen;
        f fVar58 = f.ShareScreenInfo;
        f fVar59 = f.AppSetIdScopeApp;
        f fVar60 = f.AppSetIdScopeDeveloper;
        f fVar61 = f.Debugger;
        f fVar62 = f.BootId;
        f fVar63 = f.BootCount;
        d dVar3 = new d("MIX_BASIC", 2, fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12, fVar13, fVar14, fVar15, fVar16, fVar17, fVar18, fVar19, fVar20, fVar21, fVar23, fVar24, fVar25, fVar26, fVar27, fVar28, fVar29, fVar30, fVar31, fVar32, fVar33, fVar34, fVar35, fVar36, fVar37, fVar38, fVar39, fVar40, fVar41, fVar42, fVar43, fVar44, fVar45, fVar46, fVar47, fVar48, fVar49, fVar50, fVar51, fVar52, fVar53, fVar54, fVar55, fVar56, fVar57, fVar58, fVar59, fVar60, fVar61, fVar62, fVar63);
        d dVar4 = new d("MIX_BASIC_WITH_COORD", 3, fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12, fVar13, fVar14, fVar15, fVar16, fVar17, fVar18, fVar19, fVar20, fVar21, fVar22, fVar23, fVar24, fVar25, fVar26, fVar27, fVar28, fVar29, fVar30, fVar31, fVar32, fVar33, fVar34, fVar35, fVar36, fVar37, fVar38, fVar39, fVar40, fVar41, fVar42, fVar43, fVar44, fVar45, fVar46, fVar47, fVar48, fVar49, fVar50, fVar51, fVar52, fVar53, fVar54, fVar55, fVar56, fVar57, fVar58, fVar59, fVar60, fVar61, fVar62, fVar63);
        b = dVar4;
        c = new d[]{dVar, dVar2, dVar3, dVar4, new d("AFP", 4, fVar56, fVar53, fVar52, fVar3, fVar4, fVar14, fVar13, fVar11, fVar10, fVar42, fVar40, fVar62, fVar63, fVar35, fVar36, fVar32, fVar30, fVar38, fVar, fVar12, fVar37, fVar20, fVar9, fVar2, fVar21, fVar8, fVar7, fVar6, fVar5, fVar17, fVar34, fVar47, fVar28, fVar29, fVar33, fVar19, fVar22, fVar50, fVar43, fVar44, fVar45, fVar41, fVar26, fVar51, fVar24, fVar23, fVar48, fVar49, fVar16, fVar58, fVar57, fVar25)};
    }

    public d(String str, int i, f... fVarArr) {
        this.a = fVarArr;
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) c.clone();
    }
}
