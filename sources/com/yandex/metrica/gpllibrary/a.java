package com.yandex.metrica.gpllibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationListener;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class a implements com.yandex.metrica.gpllibrary.b {
    private final FusedLocationProviderClient a;
    private final LocationListener b;
    private final LocationCallback c;
    private final Looper d;
    private final Executor e;
    private final long f;

    /* renamed from: com.yandex.metrica.gpllibrary.a$a, reason: collision with other inner class name */
    static class C0281a {
        private final Context a;

        C0281a(Context context) {
            this.a = context;
        }

        FusedLocationProviderClient a() throws Throwable {
            return new FusedLocationProviderClient(this.a);
        }
    }

    public enum b {
        PRIORITY_NO_POWER,
        PRIORITY_LOW_POWER,
        PRIORITY_BALANCED_POWER_ACCURACY,
        PRIORITY_HIGH_ACCURACY
    }

    public a(Context context, LocationListener locationListener, Looper looper, Executor executor, long j) throws Throwable {
        this(new C0281a(context), locationListener, looper, executor, j);
    }

    @Override // com.yandex.metrica.gpllibrary.b
    @SuppressLint({"MissingPermission"})
    public void startLocationUpdates(b bVar) throws Throwable {
        Log.d("[GplLibraryWrapper]", "startLocationUpdates");
        FusedLocationProviderClient fusedLocationProviderClient = this.a;
        LocationRequest interval = LocationRequest.create().setInterval(this.f);
        int iOrdinal = bVar.ordinal();
        fusedLocationProviderClient.requestLocationUpdates(interval.setPriority(iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? 105 : 100 : 102 : 104), this.c, this.d);
    }

    @Override // com.yandex.metrica.gpllibrary.b
    public void stopLocationUpdates() throws Throwable {
        Log.d("[GplLibraryWrapper]", "stopLocationUpdates");
        this.a.removeLocationUpdates(this.c);
    }

    @Override // com.yandex.metrica.gpllibrary.b
    @SuppressLint({"MissingPermission"})
    public void updateLastKnownLocation() throws Throwable {
        Log.d("[GplLibraryWrapper]", "updateLastKnownLocation");
        this.a.getLastLocation().addOnSuccessListener(this.e, new GplOnSuccessListener(this.b));
    }

    a(C0281a c0281a, LocationListener locationListener, Looper looper, Executor executor, long j) throws Throwable {
        this.a = c0281a.a();
        this.b = locationListener;
        this.d = looper;
        this.e = executor;
        this.f = j;
        this.c = new GplLocationCallback(locationListener);
    }
}
