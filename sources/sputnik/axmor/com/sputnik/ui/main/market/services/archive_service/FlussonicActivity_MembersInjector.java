package sputnik.axmor.com.sputnik.ui.main.market.services.archive_service;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;
import sputnik.axmor.com.sputnik.services.download_service.DownloadService;

/* loaded from: classes5.dex */
public final class FlussonicActivity_MembersInjector implements MembersInjector<FlussonicActivity> {
    public static void injectAnalytics(FlussonicActivity flussonicActivity, Analytics analytics) {
        flussonicActivity.analytics = analytics;
    }

    public static void injectLocalizationScreen(FlussonicActivity flussonicActivity, LocalizationStorage localizationStorage) {
        flussonicActivity.localizationScreen = localizationStorage;
    }

    public static void injectDownloadServiceFactory(FlussonicActivity flussonicActivity, DownloadService.Factory factory) {
        flussonicActivity.downloadServiceFactory = factory;
    }

    public static void injectFactory(FlussonicActivity flussonicActivity, MultiViewModelFactory multiViewModelFactory) {
        flussonicActivity.factory = multiViewModelFactory;
    }
}
