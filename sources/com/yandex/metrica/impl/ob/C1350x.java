package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.LocationManager;
import java.util.Collections;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1350x {
    private final LocationManager a;

    public C1350x(Context context) {
        this((LocationManager) context.getSystemService("location"));
    }

    public List<String> a() {
        List<String> providers;
        LocationManager locationManager = this.a;
        List<String> listEmptyList = Collections.emptyList();
        if (locationManager != null) {
            try {
                providers = locationManager.getProviders(true);
            } catch (Throwable unused) {
            }
        } else {
            providers = null;
        }
        return providers == null ? listEmptyList : providers;
    }

    C1350x(LocationManager locationManager) {
        this.a = locationManager;
    }
}
