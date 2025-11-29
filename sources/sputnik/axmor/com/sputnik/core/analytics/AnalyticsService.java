package sputnik.axmor.com.sputnik.core.analytics;

import android.app.Application;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnalyticsService.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lsputnik/axmor/com/sputnik/core/analytics/AnalyticsService;", "", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "", "category", "action", "label", "", "send", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "initialize", "()V", "Landroid/app/Application;", "", "Lsputnik/axmor/com/sputnik/core/analytics/YandexAnalyticsModule;", "analyticsModules", "Ljava/util/List;", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnalyticsService {
    private final List<YandexAnalyticsModule> analyticsModules;
    private final Application application;

    public AnalyticsService(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.application = application;
        List<YandexAnalyticsModule> listListOf = CollectionsKt.listOf(new YandexAnalyticsModule());
        this.analyticsModules = listListOf;
        Iterator<T> it = listListOf.iterator();
        while (it.hasNext()) {
            ((YandexAnalyticsModule) it.next()).init(this.application);
        }
    }

    public static /* synthetic */ void send$default(AnalyticsService analyticsService, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        analyticsService.send(str, str2, str3);
    }

    public final void send(String category, String action, String label) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<T> it = this.analyticsModules.iterator();
        while (it.hasNext()) {
            ((YandexAnalyticsModule) it.next()).send(category, action, label);
        }
    }

    public final void initialize() {
        Iterator<T> it = this.analyticsModules.iterator();
        while (it.hasNext()) {
            ((YandexAnalyticsModule) it.next()).init(this.application);
        }
    }
}
