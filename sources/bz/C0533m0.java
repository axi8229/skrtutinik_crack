package bz;

import android.content.Context;
import android.content.pm.PackageManager;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import okio.Utf8;

/* renamed from: bz.m0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0533m0 extends AbstractC0538n1 implements P1 {
    public static final HashMap e;
    public final Context c;
    public final zone.bi.mobile.fingerprint.api.settings.a d;

    static {
        HashMap map = new HashMap();
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceQSInstall, AbstractC0569y0.a(new byte[]{30, 30, 48, 127, 82, -96, 60, 41, 21, -109, 109, -31, -112, -85, 16, -50, -38, 62, -119, -89, 6, -11, 52, 99, 126, -29, -36, 121, 33, -90, -110, 15, -2, -2, -99, -21, 17, 34, 123, 52, 65, -125, -113, 55, -40, 5, 4, -79}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceAnyDeskInstall, AbstractC0569y0.a(new byte[]{45, -32, -59, -68, 69, -103, 39, 99, 89, 98, -76, 50, -86, 116, 44, 16, 17, 42, 29, 16, -49, -101, -1, 66, -62, -56, -20, 115, 119, 121, -74, 44}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceZoomInstall, AbstractC0569y0.a(new byte[]{-114, 56, -59, -41, 30, -11, -112, 15, 89, 87, 81, -94, 46, -76, 20, 82, 35, ByteSourceJsonBootstrapper.UTF8_BOM_1, 54, -48, -90, 8, 41, 108, -119, 18, 44, -14, 25, 107, -87, 84}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceDiscordInstall, AbstractC0569y0.a(new byte[]{57, 29, 55, -30, 38, -63, 17, 75, -102, -116, 6, 81, 91, 13, -87, 95}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceAwerayRemoteInstall, AbstractC0569y0.a(new byte[]{-19, -125, -96, -64, 18, -75, 123, 109, 19, -39, -33, 56, 35, 23, -63, -107, -72, -66, -36, 126, 115, 57, -9, -110, -75, 88, -119, 51, 21, 6, 103, 109}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceAweSunClientInstall, AbstractC0569y0.a(new byte[]{-19, -125, -96, -64, 18, -75, 123, 109, 19, -39, -33, 56, 35, 23, -63, -107, -127, ByteSourceJsonBootstrapper.UTF8_BOM_2, -108, 106, -123, 119, -37, ByteSourceJsonBootstrapper.UTF8_BOM_2, -66, -93, 7, -118, 39, -79, -45, 10}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceAirdroidInstall, AbstractC0569y0.a(new byte[]{-43, -73, 76, -25, -20, 68, -7, 29, -11, 19, 26, -91, 29, -126, 110, 0, -78, 83, 92, -34, -26, 106, -106, -53, 83, 13, -89, 107, 0, -45, 83, -111}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceAircastInstall, AbstractC0569y0.a(new byte[]{-100, 58, 47, 108, -56, 46, -2, 118, 65, -127, 0, -77, 47, 3, 76, 60, 121, -114, 25, 15, 36, 106, 13, 48, -73, -58, ByteSourceJsonBootstrapper.UTF8_BOM_1, 70, -108, -102, -57, Utf8.REPLACEMENT_BYTE}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceAirdroidRemoteSupportInstall, AbstractC0569y0.a(new byte[]{-70, 5, -89, 8, 64, -20, -49, -3, 102, -54, 73, -125, -20, -92, 60, -54}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceAirmirrorInstall, AbstractC0569y0.a(new byte[]{121, 107, -128, -108, 11, -128, -67, 4, -96, -56, -86, 126, 28, 115, -42, 120, 107, 11, 121, 10, 125, 76, 46, -19, -86, -43, 9, 47, -91, -127, -68, 123}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceMirPaySInstall, AbstractC0569y0.a(new byte[]{-52, -76, 122, 61, 46, 67, 126, -106, 99, -73, -83, 83, 73, 100, 8, 100}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceSbpPaySInstall, AbstractC0569y0.a(new byte[]{55, 88, -55, 5, -83, -61, 117, -63, -73, 6, 100, -23, 121, 108, 22, -119}));
        map.put(zone.bi.mobile.fingerprint.api.f.HoursSinceRustDeskRDInstall, AbstractC0569y0.a(new byte[]{-8, -39, -44, 2, -40, -30, 54, 116, 68, 88, -28, 29, 86, -66, -4, 22, 49, 93, -16, -54, -55, -40, -55, -112, 76, 81, -31, 47, -46, -67, -68, 53}));
        e = map;
    }

    public C0533m0(Context context, zone.bi.mobile.fingerprint.api.settings.a aVar) {
        super(zone.bi.mobile.fingerprint.api.f.HoursSinceInstall);
        this.c = context;
        this.d = aVar;
    }

    public final /* synthetic */ Integer a(Map.Entry entry) throws PackageManager.NameNotFoundException {
        try {
            return Integer.valueOf((int) TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis() - this.c.getPackageManager().getPackageInfo((String) entry.getValue(), 4096).firstInstallTime));
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @Override // bz.P1
    /* renamed from: b */
    public final zone.bi.mobile.fingerprint.api.settings.a mo2257b() {
        return this.d;
    }

    @Override // bz.AbstractC0538n1
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final zone.bi.mobile.fingerprint.api.serialize.model.a h() {
        HashMap map = e;
        zone.bi.mobile.fingerprint.api.serialize.model.a aVar = new zone.bi.mobile.fingerprint.api.serialize.model.a(map.size());
        for (final Map.Entry entry : map.entrySet()) {
            aVar.put(((zone.bi.mobile.fingerprint.api.f) entry.getKey()).name(), (Integer) a(new Callable() { // from class: bz.m0$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.a(entry);
                }
            }));
        }
        return aVar;
    }
}
