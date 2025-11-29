package sputnik.axmor.com.sputnik.services.ble_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.firebase.crashlytics.ktx.FirebaseCrashlyticsKt;
import com.google.firebase.ktx.Firebase;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.sputnik.activationautomation.data.files.ILogger;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.utils.DateUtilsKt;
import com.sputnik.scancameraidentifiers.data.files.FileManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.extensions.ContextKt;
import sputnik.axmor.com.sputnik.utils.CommonUtilsKt;

/* compiled from: RebootBroadcastReceiver.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014²\u0006\f\u0010\u0013\u001a\u00020\u00128\nX\u008a\u0084\u0002"}, d2 = {"Lsputnik/axmor/com/sputnik/services/ble_service/RebootBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lcom/sputnik/data/local/PrefManager;", "preferences", "Lcom/sputnik/data/local/PrefManager;", "getPreferences", "()Lcom/sputnik/data/local/PrefManager;", "setPreferences", "(Lcom/sputnik/data/local/PrefManager;)V", "Lcom/sputnik/activationautomation/data/files/ILogger;", "fileManager", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RebootBroadcastReceiver extends BroadcastReceiver {
    public PrefManager preferences;

    public final PrefManager getPreferences() {
        PrefManager prefManager = this.preferences;
        if (prefManager != null) {
            return prefManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("preferences");
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ContextKt.getAppComponent(context).inject(this);
        if (Intrinsics.areEqual(intent.getAction(), "android.intent.action.BOOT_COMPLETED") || Intrinsics.areEqual(intent.getAction(), "android.intent.action.QUICKBOOT_POWERON") || Intrinsics.areEqual(intent.getAction(), "com.htc.intent.action.QUICKBOOT_POWERON")) {
            onReceive$lambda$0(LazyKt.lazy(new Function0<ILogger>() { // from class: sputnik.axmor.com.sputnik.services.ble_service.RebootBroadcastReceiver$onReceive$fileManager$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ILogger invoke() {
                    FileManager.Companion companion = FileManager.INSTANCE;
                    String absolutePath = context.getFilesDir().getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                    return FileManager.Companion.getInstance$default(companion, absolutePath, null, 2, null);
                }
            })).write(DateUtilsKt.convertMillisToTime(System.currentTimeMillis(), "yyyy.MM.dd HH:mm:ss.SSSS") + "\tBoot completed action received\n");
            Intent intent2 = new Intent(context, (Class<?>) BeaconTrackingService.class);
            intent2.putExtra("from_reboot", true);
            if (Intrinsics.areEqual(intent.getAction(), "android.intent.action.BOOT_COMPLETED") && Intrinsics.areEqual(getPreferences().getAppSettings().getBleSettings().getEnabled(), Boolean.TRUE)) {
                new Intent(context, (Class<?>) BeaconTrackingService.class);
                FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE).log("reboot-receiver:launch-ble");
                CommonUtilsKt.launchService(context, intent2);
            }
        }
    }

    private static final ILogger onReceive$lambda$0(Lazy<? extends ILogger> lazy) {
        return lazy.getValue();
    }
}
