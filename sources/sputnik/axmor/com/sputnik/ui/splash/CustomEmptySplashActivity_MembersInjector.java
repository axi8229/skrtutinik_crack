package sputnik.axmor.com.sputnik.ui.splash;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class CustomEmptySplashActivity_MembersInjector implements MembersInjector<CustomEmptySplashActivity> {
    public static void injectLocalizationScreen(CustomEmptySplashActivity customEmptySplashActivity, LocalizationStorage localizationStorage) {
        customEmptySplashActivity.localizationScreen = localizationStorage;
    }

    public static void injectFactory(CustomEmptySplashActivity customEmptySplashActivity, MultiViewModelFactory multiViewModelFactory) {
        customEmptySplashActivity.factory = multiViewModelFactory;
    }

    public static void injectPrefManager(CustomEmptySplashActivity customEmptySplashActivity, PrefManager prefManager) {
        customEmptySplashActivity.prefManager = prefManager;
    }

    public static void injectAnalytics(CustomEmptySplashActivity customEmptySplashActivity, Analytics analytics) {
        customEmptySplashActivity.analytics = analytics;
    }
}
