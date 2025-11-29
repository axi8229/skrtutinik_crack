package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.GeofenceRequest;
import java.util.List;

/* loaded from: classes3.dex */
public interface o {
    Task<Void> a(PendingIntent pendingIntent);

    Task<Void> a(GeofenceRequest geofenceRequest, PendingIntent pendingIntent);

    Task<Void> a(List<String> list);
}
