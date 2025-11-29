package com.sputnik.common.analytics;

import android.app.Application;
import com.sputnik.common.analytics.AnalyticsTracker;
import com.sputnik.domain.Constants;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppMetricaAnalyticsTracker.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/sputnik/common/analytics/AppMetricaAnalyticsTracker;", "Lcom/sputnik/common/analytics/AnalyticsTracker;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "trackEvent", "", "event", "Lcom/sputnik/common/analytics/AnalyticsTracker$Event;", "trackEventWithNewWay", "Lcom/sputnik/common/analytics/AnalyticsTracker$EventWithMap;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppMetricaAnalyticsTracker implements AnalyticsTracker {
    public AppMetricaAnalyticsTracker(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        YandexMetricaConfig.Builder builderNewConfigBuilder = YandexMetricaConfig.newConfigBuilder(Constants.INSTANCE.getYandexApiKey(false));
        Intrinsics.checkNotNullExpressionValue(builderNewConfigBuilder, "newConfigBuilder(...)");
        YandexMetrica.activate(application, builderNewConfigBuilder.build());
        YandexMetrica.enableActivityAutoTracking(application);
    }

    @Override // com.sputnik.common.analytics.AnalyticsTracker
    public void trackEvent(AnalyticsTracker.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        HashMap map = new HashMap();
        map.put(event.getName(), event.getValue());
        YandexMetrica.reportEvent(event.getCategory(), map);
    }

    @Override // com.sputnik.common.analytics.AnalyticsTracker
    public void trackEventWithNewWay(AnalyticsTracker.EventWithMap event) {
        Intrinsics.checkNotNullParameter(event, "event");
        YandexMetrica.reportEvent(event.getName(), event.getMap());
    }
}
