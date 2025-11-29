package com.yandex.metrica;

import android.content.ContentValues;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.A2;
import com.yandex.metrica.impl.ob.C1315vc;
import com.yandex.metrica.impl.ob.ResultReceiverC0911f0;

@Deprecated
/* loaded from: classes3.dex */
public class CounterConfiguration implements Parcelable {
    public static final Parcelable.Creator<CounterConfiguration> CREATOR = new a();
    private final ContentValues a;

    class a implements Parcelable.Creator<CounterConfiguration> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public CounterConfiguration createFromParcel(Parcel parcel) {
            return new CounterConfiguration((ContentValues) parcel.readBundle(ResultReceiverC0911f0.class.getClassLoader()).getParcelable("com.yandex.metrica.CounterConfiguration.data"));
        }

        @Override // android.os.Parcelable.Creator
        public CounterConfiguration[] newArray(int i) {
            return new CounterConfiguration[i];
        }
    }

    public enum b {
        MAIN("main"),
        MANUAL("manual"),
        APPMETRICA("appmetrica"),
        COMMUTATION("commutation"),
        SELF_DIAGNOSTIC_MAIN("self_diagnostic_main"),
        SELF_DIAGNOSTIC_MANUAL("self_diagnostic_manual"),
        CRASH("crash");

        private final String a;

        b(String str) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }

        public static b a(String str) {
            b[] bVarArrValues = values();
            for (int i2 = 0; i2 < 7; i2++) {
                b bVar = bVarArrValues[i2];
                if (bVar.a.equals(str)) {
                    return bVar;
                }
            }
            return MAIN;
        }
    }

    public CounterConfiguration(CounterConfiguration counterConfiguration) {
        synchronized (counterConfiguration) {
            this.a = new ContentValues(counterConfiguration.a);
            r();
        }
    }

    private void a(String str) {
        if (A2.a((Object) str)) {
            synchronized (this) {
                this.a.put("CFG_API_KEY", str);
            }
        }
    }

    private void b(Integer num) {
        if (A2.a(num)) {
            int iIntValue = num.intValue();
            synchronized (this) {
                ContentValues contentValues = this.a;
                if (iIntValue <= 0) {
                    iIntValue = Integer.MAX_VALUE;
                }
                contentValues.put("CFG_MAX_REPORTS_COUNT", Integer.valueOf(iIntValue));
            }
        }
    }

    private void c(String str) {
        if ("20799a27-fa80-4b36-b2db-0f8141f24180".equals(str)) {
            b bVar = b.APPMETRICA;
            synchronized (this) {
                this.a.put("CFG_REPORTER_TYPE", bVar.a());
            }
        } else {
            b bVar2 = b.MANUAL;
            synchronized (this) {
                this.a.put("CFG_REPORTER_TYPE", bVar2.a());
            }
        }
    }

    private void d(Integer num) {
        if (A2.a(num)) {
            num.intValue();
            synchronized (this) {
                this.a.put("CFG_SESSION_TIMEOUT", num);
            }
        }
    }

    private void e(i iVar) {
        if (A2.a(iVar.locationTracking)) {
            b(iVar.locationTracking.booleanValue());
        }
    }

    private void f(i iVar) {
        if (A2.a(iVar.location)) {
            a(iVar.location);
        }
    }

    private void g(i iVar) {
        if (A2.a(iVar.j)) {
            Boolean bool = iVar.j;
            bool.booleanValue();
            synchronized (this) {
                this.a.put("CFG_PERMISSIONS_COLLECTING", bool);
            }
        }
    }

    private void h(i iVar) {
        if (A2.a(iVar.revenueAutoTrackingEnabled)) {
            Boolean bool = iVar.revenueAutoTrackingEnabled;
            bool.booleanValue();
            synchronized (this) {
                this.a.put("CFG_REVENUE_AUTO_TRACKING_ENABLED", bool);
            }
        }
    }

    private void r() {
        if (this.a.containsKey("CFG_REPORTER_TYPE")) {
            return;
        }
        if (this.a.containsKey("CFG_MAIN_REPORTER")) {
            if (!this.a.getAsBoolean("CFG_MAIN_REPORTER").booleanValue()) {
                c(a());
                return;
            }
            b bVar = b.MAIN;
            synchronized (this) {
                this.a.put("CFG_REPORTER_TYPE", bVar.a());
            }
        }
        if (!this.a.containsKey("CFG_COMMUTATION_REPORTER") || !this.a.getAsBoolean("CFG_COMMUTATION_REPORTER").booleanValue()) {
            return;
        }
        b bVar2 = b.COMMUTATION;
        synchronized (this) {
            this.a.put("CFG_REPORTER_TYPE", bVar2.a());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Integer i() {
        return this.a.getAsInteger("MAX_REPORTS_IN_DB_COUNT");
    }

    public Boolean j() {
        return this.a.getAsBoolean("CFG_NATIVE_CRASHES_ENABLED");
    }

    public b k() {
        return b.a(this.a.getAsString("CFG_REPORTER_TYPE"));
    }

    public Integer l() {
        return this.a.getAsInteger("CFG_SESSION_TIMEOUT");
    }

    public Boolean m() {
        return this.a.getAsBoolean("CFG_STATISTICS_SENDING");
    }

    public Boolean n() {
        return this.a.getAsBoolean("CFG_IS_FIRST_ACTIVATION_AS_UPDATE");
    }

    public Boolean o() {
        return this.a.getAsBoolean("CFG_LOCATION_TRACKING");
    }

    public Boolean p() {
        return this.a.getAsBoolean("CFG_IS_LOG_ENABLED");
    }

    public synchronized Boolean q() {
        return this.a.getAsBoolean("CFG_REVENUE_AUTO_TRACKING_ENABLED");
    }

    public synchronized String toString() {
        return "CounterConfiguration{mParamsMapping=" + this.a + '}';
    }

    @Override // android.os.Parcelable
    public synchronized void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.yandex.metrica.CounterConfiguration.data", this.a);
        parcel.writeBundle(bundle);
    }

    private void a(Integer num) {
        if (A2.a(num)) {
            num.intValue();
            synchronized (this) {
                this.a.put("CFG_DISPATCH_PERIOD", num);
            }
        }
    }

    public Integer e() {
        return this.a.getAsInteger("CFG_DISPATCH_PERIOD");
    }

    public Boolean f() {
        return this.a.getAsBoolean("CFG_LOCATION_ALLOWED_BY_BRIDGE");
    }

    private void b(i iVar) {
        if (TextUtils.isEmpty(iVar.appVersion)) {
            return;
        }
        String str = iVar.appVersion;
        synchronized (this) {
            this.a.put("CFG_APP_VERSION", str);
        }
    }

    private void d(i iVar) {
        if (A2.a(iVar.firstActivationAsUpdate)) {
            Boolean bool = iVar.firstActivationAsUpdate;
            bool.booleanValue();
            synchronized (this) {
                this.a.put("CFG_IS_FIRST_ACTIVATION_AS_UPDATE", bool);
            }
        }
    }

    public Location g() {
        if (!this.a.containsKey("CFG_MANUAL_LOCATION")) {
            return null;
        }
        byte[] asByteArray = this.a.getAsByteArray("CFG_MANUAL_LOCATION");
        int i = C1315vc.q;
        if (asByteArray == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(asByteArray, 0, asByteArray.length);
            parcelObtain.setDataPosition(0);
            Location location = (Location) parcelObtain.readValue(Location.class.getClassLoader());
            parcelObtain.recycle();
            return location;
        } catch (Throwable unused) {
            parcelObtain.recycle();
            return null;
        }
    }

    public Integer h() {
        return this.a.getAsInteger("CFG_MAX_REPORTS_COUNT");
    }

    public CounterConfiguration() {
        this.a = new ContentValues();
    }

    private void a(Boolean bool) {
        if (A2.a(bool)) {
            bool.booleanValue();
            synchronized (this) {
                this.a.put("CFG_IS_LOG_ENABLED", bool);
            }
        }
    }

    private void c(i iVar) {
        if (A2.a((Object) iVar.a)) {
            String str = iVar.a;
            synchronized (this) {
                ContentValues contentValues = this.a;
                if (TextUtils.isEmpty(str)) {
                    str = null;
                }
                contentValues.put("CFG_DEVICE_SIZE_TYPE", str);
            }
        }
    }

    public String d() {
        return this.a.getAsString("CFG_DEVICE_SIZE_TYPE");
    }

    public CounterConfiguration(i iVar, b bVar) {
        this();
        synchronized (this) {
            a(iVar.apiKey);
            d(iVar.sessionTimeout);
            f(iVar);
            e(iVar);
            c(iVar);
            a(iVar.f);
            b(iVar.g);
            b(iVar);
            a(iVar);
            g(iVar);
            d(iVar);
            c(iVar.statisticsSending);
            c(iVar.maxReportsInDatabaseCount);
            b(iVar.nativeCrashReporting);
            h(iVar);
            a(bVar);
        }
    }

    private void b(Boolean bool) {
        if (A2.a(bool)) {
            this.a.put("CFG_NATIVE_CRASHES_ENABLED", bool);
        }
    }

    public synchronized void d(String str) {
        this.a.put("CFG_UUID", str);
    }

    private void a(i iVar) {
        if (A2.a(iVar.e)) {
            int iIntValue = iVar.e.intValue();
            synchronized (this) {
                this.a.put("CFG_APP_VERSION_CODE", String.valueOf(iIntValue));
            }
        }
    }

    private void c(Boolean bool) {
        if (A2.a(bool)) {
            c(bool.booleanValue());
        }
    }

    public synchronized void b(String str) {
        this.a.put("CFG_API_KEY", str);
    }

    private void c(Integer num) {
        if (A2.a(num)) {
            this.a.put("MAX_REPORTS_IN_DB_COUNT", num);
        }
    }

    public synchronized void b(boolean z) {
        this.a.put("CFG_LOCATION_TRACKING", Boolean.valueOf(z));
    }

    public String a() {
        return this.a.getAsString("CFG_API_KEY");
    }

    public String b() {
        return this.a.getAsString("CFG_APP_VERSION_CODE");
    }

    public synchronized void a(boolean z) {
        this.a.put("CFG_LOCATION_ALLOWED_BY_BRIDGE", Boolean.valueOf(z));
    }

    public String c() {
        return this.a.getAsString("CFG_APP_VERSION");
    }

    public final synchronized void a(Location location) {
        byte[] bArrMarshall;
        try {
            ContentValues contentValues = this.a;
            int i = C1315vc.q;
            if (location != null) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeValue(location);
                    bArrMarshall = parcelObtain.marshall();
                    parcelObtain.recycle();
                } catch (Throwable unused) {
                    parcelObtain.recycle();
                }
            } else {
                bArrMarshall = null;
            }
            contentValues.put("CFG_MANUAL_LOCATION", bArrMarshall);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(boolean z) {
        this.a.put("CFG_STATISTICS_SENDING", Boolean.valueOf(z));
    }

    public CounterConfiguration(e eVar) {
        this();
        synchronized (this) {
            a(eVar.apiKey);
            d(eVar.sessionTimeout);
            a(eVar.a);
            b(eVar.b);
            a(eVar.logs);
            c(eVar.statisticsSending);
            c(eVar.maxReportsInDatabaseCount);
            c(eVar.apiKey);
        }
    }

    CounterConfiguration(ContentValues contentValues) {
        this.a = contentValues;
        r();
    }

    public synchronized void a(b bVar) {
        this.a.put("CFG_REPORTER_TYPE", bVar.a());
    }

    public static CounterConfiguration a(Bundle bundle) {
        CounterConfiguration counterConfiguration = null;
        if (bundle != null) {
            try {
                counterConfiguration = (CounterConfiguration) bundle.getParcelable("COUNTER_CFG_OBJ");
            } catch (Throwable unused) {
                return null;
            }
        }
        if (counterConfiguration == null) {
            counterConfiguration = new CounterConfiguration();
        }
        synchronized (counterConfiguration) {
            if (bundle != null) {
                try {
                    if (bundle.getInt("CFG_DISPATCH_PERIOD") != 0) {
                        int i = bundle.getInt("CFG_DISPATCH_PERIOD");
                        synchronized (counterConfiguration) {
                            counterConfiguration.a.put("CFG_DISPATCH_PERIOD", Integer.valueOf(i));
                        }
                    }
                    if (bundle.getInt("CFG_SESSION_TIMEOUT") != 0) {
                        int i2 = bundle.getInt("CFG_SESSION_TIMEOUT");
                        synchronized (counterConfiguration) {
                            counterConfiguration.a.put("CFG_SESSION_TIMEOUT", Integer.valueOf(i2));
                        }
                    }
                    if (bundle.getInt("CFG_MAX_REPORTS_COUNT") != 0) {
                        int i3 = bundle.getInt("CFG_MAX_REPORTS_COUNT");
                        synchronized (counterConfiguration) {
                            ContentValues contentValues = counterConfiguration.a;
                            if (i3 <= 0) {
                                i3 = Integer.MAX_VALUE;
                            }
                            contentValues.put("CFG_MAX_REPORTS_COUNT", Integer.valueOf(i3));
                        }
                    }
                    if (bundle.getString("CFG_API_KEY") != null && !"-1".equals(bundle.getString("CFG_API_KEY"))) {
                        counterConfiguration.b(bundle.getString("CFG_API_KEY"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return counterConfiguration;
    }
}
