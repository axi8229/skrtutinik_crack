package com.sputnik.service_payments.di;

import android.app.Application;
import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import kotlin.Metadata;

/* compiled from: ServicePaymentDeps.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/sputnik/service_payments/di/ServicePaymentDeps;", "", "analytics", "Lcom/sputnik/common/analytics/Analytics;", "getAnalytics", "()Lcom/sputnik/common/analytics/Analytics;", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "config", "Lcom/sputnik/data/IConfig;", "getConfig", "()Lcom/sputnik/data/IConfig;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "getLocalizationStorage", "()Lcom/sputnik/common/localization/LocalizationStorage;", "prefManager", "Lcom/sputnik/data/local/PrefManager;", "getPrefManager", "()Lcom/sputnik/data/local/PrefManager;", "service_payments_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ServicePaymentDeps {
    Analytics getAnalytics();

    Application getApplication();

    IConfig getConfig();

    LocalizationStorage getLocalizationStorage();

    PrefManager getPrefManager();
}
