package com.sputnik.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.google.android.gms.common.Scopes;
import com.sputnik.domain.utils.DateUtilsKt;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntentUtils.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0005\u001a\"\u0010\u000e\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003¨\u0006\u0011"}, d2 = {"sendFile", "", "path", "", "context", "Landroid/content/Context;", "shareText", "text", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "openBrowser", "Landroid/app/Activity;", "url", "openIgnoreBatteryOptimisationsSettings", "openSystemAppSettings", "sendEmail", Scopes.EMAIL, "subject", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IntentUtilsKt {
    public static final void shareText(Context context, String text, String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(title, "title");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", text);
        intent.setType("text/plain");
        context.startActivity(Intent.createChooser(intent, title));
    }

    public static final void sendEmail(Activity activity, String email, String subject, String text) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(text, "text");
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{email});
        intent.putExtra("android.intent.extra.SUBJECT", subject);
        intent.putExtra("android.intent.extra.TEXT", text);
        activity.startActivity(intent);
    }

    public static final void sendFile(String path, Context context) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(context, "context");
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName(), new File(path));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.putExtra("android.intent.extra.SUBJECT", DateUtilsKt.convertMillisToTime(System.currentTimeMillis(), "dd.MM.yyyy"));
        intent.addFlags(1);
        intent.addFlags(268435456);
        intent.setType("application/octet-stream");
        intent.addFlags(268435456);
        context.startActivity(Intent.createChooser(intent, "Choose an action"));
    }

    public static final void openBrowser(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void openIgnoreBatteryOptimisationsSettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        context.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
    }

    public static final void openSystemAppSettings(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", context.getPackageName(), null)));
    }
}
