package sputnik.axmor.com.sputnik.ui.yandex;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class YandexHomeFragment_MembersInjector implements MembersInjector<YandexHomeFragment> {
    public static void injectPrefManager(YandexHomeFragment yandexHomeFragment, PrefManager prefManager) {
        yandexHomeFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(YandexHomeFragment yandexHomeFragment, Analytics analytics) {
        yandexHomeFragment.analytics = analytics;
    }

    public static void injectLocalizationScreen(YandexHomeFragment yandexHomeFragment, LocalizationStorage localizationStorage) {
        yandexHomeFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(YandexHomeFragment yandexHomeFragment, MultiViewModelFactory multiViewModelFactory) {
        yandexHomeFragment.factory = multiViewModelFactory;
    }
}
