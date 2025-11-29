package com.sputnik.oboarding.workmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.axmor.ash.toolset.service.impl.CompositeService$$ExternalSyntheticApiModelOutline3;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.l$$ExternalSyntheticApiModelOutline1;
import com.sputnik.oboarding.R$drawable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReminderRegistrationWork.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/sputnik/oboarding/workmanager/ReminderRegistrationWork;", "Landroidx/work/Worker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "sendNotification", "", RemoteMessageConst.NOTIFICATION, "Landroidx/core/app/NotificationCompat$Builder;", "Companion", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReminderRegistrationWork extends Worker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReminderRegistrationWork(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        String string = getInputData().getString("reminderRegistrationWork_title");
        if (string == null) {
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(resultFailure, "failure(...)");
            return resultFailure;
        }
        String string2 = getInputData().getString("reminderRegistrationWork_subtitle");
        if (string2 == null) {
            ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(resultFailure2, "failure(...)");
            return resultFailure2;
        }
        String string3 = getInputData().getString("reminderRegistrationWork_deeplink");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(string3));
        intent.addFlags(67108864);
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(getApplicationContext(), "reminderRegistrationWork_channel_01").setSmallIcon(R$drawable.ourhome).setContentTitle(string).setContentText(string2).setDefaults(-1).setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, intent, 67108864)).setAutoCancel(true);
        Intrinsics.checkNotNullExpressionValue(autoCancel, "setAutoCancel(...)");
        sendNotification(autoCancel);
        Log.e("START REMINDER", "SUCCESS");
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(resultSuccess, "success(...)");
        return resultSuccess;
    }

    /* compiled from: ReminderRegistrationWork.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/sputnik/oboarding/workmanager/ReminderRegistrationWork$Companion;", "", "()V", "NOTIFICATION_CHANNEL", "", "NOTIFICATION_DEEPLINK", "NOTIFICATION_ID", "NOTIFICATION_NAME", "NOTIFICATION_SUBTITLE", "NOTIFICATION_TITLE", "NOTIFICATION_WORK", "REMINDER_REGISTRATION_NAME", "cancelRegistrationReminderWork", "", "context", "Landroid/content/Context;", "closeNotification", "createRegistrationReminder", "Landroidx/work/Operation;", "inputData", "Landroidx/work/Data;", "onboarding_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Operation createRegistrationReminder(Context context, Data inputData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(inputData, "inputData");
            TimeUnit timeUnit = TimeUnit.DAYS;
            PeriodicWorkRequest periodicWorkRequestBuild = new PeriodicWorkRequest.Builder(ReminderRegistrationWork.class, 3L, timeUnit).setInitialDelay(3L, timeUnit).setInputData(inputData).addTag("javaClass").build();
            Intrinsics.checkNotNullExpressionValue(periodicWorkRequestBuild, "build(...)");
            Operation operationEnqueueUniquePeriodicWork = WorkManager.getInstance(context).enqueueUniquePeriodicWork("Напомнить о регистрации", ExistingPeriodicWorkPolicy.REPLACE, periodicWorkRequestBuild);
            Intrinsics.checkNotNullExpressionValue(operationEnqueueUniquePeriodicWork, "enqueueUniquePeriodicWork(...)");
            return operationEnqueueUniquePeriodicWork;
        }

        private final void closeNotification(Context context) {
            Object systemService = context.getSystemService(RemoteMessageConst.NOTIFICATION);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).cancel(-307848532);
        }

        public final void cancelRegistrationReminderWork(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WorkManager.getInstance(context).cancelAllWorkByTag("javaClass");
            closeNotification(context);
        }
    }

    private final void sendNotification(NotificationCompat.Builder notification) {
        Object systemService = getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        notification.setPriority(2);
        if (Build.VERSION.SDK_INT >= 26) {
            notification.setChannelId("reminderRegistrationWork_channel_01");
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(6).setContentType(4).build();
            l$$ExternalSyntheticApiModelOutline1.m();
            NotificationChannel notificationChannelM = CompositeService$$ExternalSyntheticApiModelOutline3.m("reminderRegistrationWork_channel_01", "Напомнить о регистрации", 4);
            notificationChannelM.enableLights(true);
            notificationChannelM.setLightColor(-16776961);
            notificationChannelM.enableVibration(true);
            notificationChannelM.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            notificationChannelM.setSound(defaultUri, audioAttributesBuild);
            notificationManager.createNotificationChannel(notificationChannelM);
        }
        notificationManager.notify(-307848532, notification.build());
    }
}
