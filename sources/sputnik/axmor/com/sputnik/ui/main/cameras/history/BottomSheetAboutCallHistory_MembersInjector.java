package sputnik.axmor.com.sputnik.ui.main.cameras.history;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetAboutCallHistory_MembersInjector implements MembersInjector<BottomSheetAboutCallHistory> {
    public static void injectLocalizationStorage(BottomSheetAboutCallHistory bottomSheetAboutCallHistory, LocalizationStorage localizationStorage) {
        bottomSheetAboutCallHistory.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetAboutCallHistory bottomSheetAboutCallHistory, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetAboutCallHistory.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetAboutCallHistory bottomSheetAboutCallHistory, Analytics analytics) {
        bottomSheetAboutCallHistory.analytics = analytics;
    }

    public static void injectLocalizationScreen(BottomSheetAboutCallHistory bottomSheetAboutCallHistory, LocalizationStorage localizationStorage) {
        bottomSheetAboutCallHistory.localizationScreen = localizationStorage;
    }
}
