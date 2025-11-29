package sputnik.axmor.com.sputnik.services.call_service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.sputnik.common.entities.call.CallActions;
import com.sputnik.common.utils.LogUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.core.analytics.AnalyticsService;
import sputnik.axmor.com.sputnik.ui.call.CallActivity;

/* compiled from: CallNotificationActionReceiver.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0014"}, d2 = {"Lsputnik/axmor/com/sputnik/services/call_service/CallNotificationActionReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "checkAppPermissions", "", "hasAudioPermissions", "hasReadPermissions", "hasWritePermissions", "onReceive", "", "context", "Landroid/content/Context;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "openCall", "performClickAction", "action", "", "receiveCall", "stopNotifying", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallNotificationActionReceiver extends BroadcastReceiver {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005f -> B:21:0x0062). Please report as a decompilation issue!!! */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ACTION_TYPE");
        if (stringExtra != null && stringExtra.length() > 0) {
            performClickAction(context, stringExtra, intent);
        }
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                Intent intent2 = new Intent(context, (Class<?>) CallNotificationService.class);
                intent2.putExtra("call_action", CallActions.hang_up.toString());
                context.startService(intent2);
            } else {
                Intent intent3 = new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                AnalyticsService.send$default(SputnikApp.INSTANCE.getAnalyticsService(), "push", "call_push", null, 4, null);
                context.sendBroadcast(intent3);
                context.stopService(new Intent(context, (Class<?>) CallNotificationService.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void performClickAction(Context context, String action, Intent intent) {
        if (StringsKt.equals(action, "RECEIVE_CALL", true)) {
            receiveCall(context, intent);
        } else if (StringsKt.equals(action, "DIALOG_CALL", true)) {
            openCall(context, intent);
            stopNotifying(context);
        } else {
            stopNotifying(context);
        }
    }

    private final void stopNotifying(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                Intent intent = new Intent(context, (Class<?>) CallNotificationService.class);
                intent.putExtra("call_action", CallActions.hang_up.toString());
                context.startService(intent);
            } else {
                context.stopService(new Intent(context, (Class<?>) CallNotificationService.class));
                context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void receiveCall(Context context, Intent intent) {
        Bundle extras;
        Bundle extras2;
        String string = null;
        String string2 = (intent == null || (extras2 = intent.getExtras()) == null) ? null : extras2.getString("sputnik.axmor.com.sputnik.global.call_id");
        if (intent != null && (extras = intent.getExtras()) != null) {
            string = extras.getString("sputnik.axmor.com.sputnik.global.uuid");
        }
        if (checkAppPermissions()) {
            Intent intent2 = new Intent(context, (Class<?>) CallActivity.class);
            intent2.putExtra("Call", "incoming");
            intent2.putExtra("sputnik.axmor.com.sputnik.global.call_id", string2);
            intent2.putExtra("sputnik.axmor.com.sputnik.global.uuid", string);
            intent2.putExtra("sputnik.axmor.com.sputnik.global.is_accepted", true);
            String string3 = intent2.toString();
            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
            LogUtilsKt.writeLog(string3);
            LogUtilsKt.writeLog(String.valueOf(intent2.getExtras()));
            intent2.addFlags(335544320);
            Log.e("Call", "incoming");
            SputnikApp.INSTANCE.getAnalyticsService().send("call", "show", AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
            context.startActivity(intent2);
            return;
        }
        Intent intent3 = new Intent(context, (Class<?>) CallActivity.class);
        intent3.addFlags(335544320);
        intent3.putExtra("CallFrom", "call from push");
        intent3.putExtra("sputnik.axmor.com.sputnik.global.call_id", string2);
        intent3.putExtra("sputnik.axmor.com.sputnik.global.uuid", string);
        intent3.putExtra("sputnik.axmor.com.sputnik.global.is_accepted", true);
        String string4 = intent3.toString();
        Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
        LogUtilsKt.writeLog(string4);
        LogUtilsKt.writeLog(String.valueOf(intent3.getExtras()));
        SputnikApp.INSTANCE.getAnalyticsService().send("call", "show", AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
        Log.e("CallFrom", "call from push");
        context.startActivity(intent3);
    }

    private final void openCall(Context context, Intent intent) {
        Bundle extras;
        Bundle extras2;
        String string = (intent == null || (extras2 = intent.getExtras()) == null) ? null : extras2.getString("sputnik.axmor.com.sputnik.global.call_id");
        String string2 = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("sputnik.axmor.com.sputnik.global.uuid");
        Intent intent2 = new Intent(context, (Class<?>) CallActivity.class);
        intent2.addFlags(335577088);
        intent2.putExtra("sputnik.axmor.com.sputnik.global.call_id", string);
        intent2.putExtra("sputnik.axmor.com.sputnik.global.uuid", string2);
        new ActivityNavigator(context).navigate(new ActivityNavigator(context).createDestination().setIntent(intent2), (Bundle) null, (NavOptions) null, (Navigator.Extras) null);
        SputnikApp.INSTANCE.getAnalyticsService().send("call", "show", "background");
        Log.e("CallFrom", "call from dialog");
    }

    private final boolean checkAppPermissions() {
        return hasReadPermissions() && hasWritePermissions() && hasAudioPermissions();
    }

    private final boolean hasAudioPermissions() {
        return ContextCompat.checkSelfPermission(SputnikApp.INSTANCE.applicationContext(), "android.permission.RECORD_AUDIO") == 0;
    }

    private final boolean hasReadPermissions() {
        return ContextCompat.checkSelfPermission(SputnikApp.INSTANCE.applicationContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    private final boolean hasWritePermissions() {
        return ContextCompat.checkSelfPermission(SputnikApp.INSTANCE.applicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
