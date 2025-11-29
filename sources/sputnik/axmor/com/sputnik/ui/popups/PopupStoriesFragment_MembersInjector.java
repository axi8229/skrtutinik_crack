package sputnik.axmor.com.sputnik.ui.popups;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class PopupStoriesFragment_MembersInjector implements MembersInjector<PopupStoriesFragment> {
    public static void injectLocalizationStorage(PopupStoriesFragment popupStoriesFragment, LocalizationStorage localizationStorage) {
        popupStoriesFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(PopupStoriesFragment popupStoriesFragment, MultiViewModelFactory multiViewModelFactory) {
        popupStoriesFragment.factory = multiViewModelFactory;
    }

    public static void injectPrefManager(PopupStoriesFragment popupStoriesFragment, PrefManager prefManager) {
        popupStoriesFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(PopupStoriesFragment popupStoriesFragment, Analytics analytics) {
        popupStoriesFragment.analytics = analytics;
    }
}
