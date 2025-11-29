package com.sputnik.common.extensions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sputnik.common.entities.notifications.PushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityExtensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"clearIntentExtras", "", "Landroid/app/Activity;", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActivityExtensionsKt {
    public static final void clearIntentExtras(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intent intent = activity.getIntent();
        if (intent != null) {
            intent.setData(null);
            intent.setAction(null);
            intent.putExtra(PushMessage.Arguments.deeplink.toString(), "");
            intent.putExtra(PushMessage.Arguments.id.toString(), "");
            intent.replaceExtras((Bundle) null);
        } else {
            intent = null;
        }
        activity.setIntent(intent);
    }
}
