package sputnik.axmor.com.sputnik.services.notification_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.services.notification_service.IPushProcessor;

/* compiled from: NotificationActionForegroundService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lsputnik/axmor/com/sputnik/services/notification_service/NotificationActionForegroundService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "p0", "Landroid/content/Intent;", "onStartCommand", "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "flags", "startId", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationActionForegroundService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent p0) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        IPushProcessor instance$default = IPushProcessor.Companion.getInstance$default(IPushProcessor.INSTANCE, this, null, 2, null);
        if (Intrinsics.areEqual(String.valueOf(intent != null ? intent.getAction() : null), "102")) {
            instance$default.cancel();
        }
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
}
