package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.ActivityConversionRequest;

/* loaded from: classes3.dex */
public interface c {
    Task<Void> a(long j, PendingIntent pendingIntent);

    Task<Void> a(PendingIntent pendingIntent);

    Task<Void> a(ActivityConversionRequest activityConversionRequest, PendingIntent pendingIntent);

    Task<Void> b(PendingIntent pendingIntent);
}
