package sputnik.axmor.com.sputnik.ui.our_home;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class OurHomeUpdateFragment_MembersInjector implements MembersInjector<OurHomeUpdateFragment> {
    public static void injectFactory(OurHomeUpdateFragment ourHomeUpdateFragment, MultiViewModelFactory multiViewModelFactory) {
        ourHomeUpdateFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(OurHomeUpdateFragment ourHomeUpdateFragment, LocalizationStorage localizationStorage) {
        ourHomeUpdateFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(OurHomeUpdateFragment ourHomeUpdateFragment, Analytics analytics) {
        ourHomeUpdateFragment.analytics = analytics;
    }

    public static void injectPrefManager(OurHomeUpdateFragment ourHomeUpdateFragment, PrefManager prefManager) {
        ourHomeUpdateFragment.prefManager = prefManager;
    }
}
