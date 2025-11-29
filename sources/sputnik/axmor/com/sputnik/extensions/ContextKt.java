package sputnik.axmor.com.sputnik.extensions;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.SputnikApp;
import sputnik.axmor.com.sputnik.di.AppComponent;

/* compiled from: Context.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"appComponent", "Lsputnik/axmor/com/sputnik/di/AppComponent;", "Landroid/content/Context;", "getAppComponent", "(Landroid/content/Context;)Lsputnik/axmor/com/sputnik/di/AppComponent;", "app_huaweiRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContextKt {
    public static final AppComponent getAppComponent(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof SputnikApp) {
            return ((SputnikApp) context).getAppComponent();
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return getAppComponent(applicationContext);
    }
}
