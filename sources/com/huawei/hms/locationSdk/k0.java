package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import android.os.Looper;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import java.util.Objects;

/* loaded from: classes3.dex */
public class k0 extends h0 {
    private LocationRequest b;
    private PendingIntent c;
    private LocationCallback d;
    private int e;
    private String f;
    private Looper g;
    private String h;

    public k0(LocationRequest locationRequest, PendingIntent pendingIntent, LocationCallback locationCallback, Looper looper, String str, String str2) {
        this.e = 0;
        this.b = locationRequest;
        this.c = pendingIntent;
        if (locationRequest != null) {
            this.e = locationRequest.getNumUpdates();
        }
        this.d = locationCallback;
        this.g = looper;
        if (locationCallback != null) {
            this.f = str;
        } else {
            this.f = null;
        }
        this.h = str2;
        a(str);
    }

    public void a(int i) {
        this.e = i;
    }

    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k0.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.d, ((k0) obj).d);
    }

    public PendingIntent b() {
        return this.c;
    }

    public boolean b(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k0.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.c, ((k0) obj).c);
    }

    public LocationCallback c() {
        return this.d;
    }

    public LocationRequest d() {
        return this.b;
    }

    public Looper e() {
        return this.g;
    }

    @Override // com.huawei.hms.locationSdk.h0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k0.class == obj.getClass()) {
            if (c() != null) {
                return a(obj);
            }
            if (b() != null) {
                return b(obj);
            }
        }
        return false;
    }

    public String f() {
        return this.h;
    }

    public int g() {
        return this.e;
    }

    public String h() {
        return this.f;
    }

    public int hashCode() {
        return 0;
    }
}
