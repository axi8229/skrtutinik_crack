package sputnik.axmor.com.sputnik.ui.main.help;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class AboutCompanyFragment_MembersInjector implements MembersInjector<AboutCompanyFragment> {
    public static void injectLocalizationScreen(AboutCompanyFragment aboutCompanyFragment, LocalizationStorage localizationStorage) {
        aboutCompanyFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(AboutCompanyFragment aboutCompanyFragment, MultiViewModelFactory multiViewModelFactory) {
        aboutCompanyFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(AboutCompanyFragment aboutCompanyFragment, Analytics analytics) {
        aboutCompanyFragment.analytics = analytics;
    }
}
