package sputnik.axmor.com.sputnik.ui.main.cameras.history;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetNoArchive_MembersInjector implements MembersInjector<BottomSheetNoArchive> {
    public static void injectLocalizationStorage(BottomSheetNoArchive bottomSheetNoArchive, LocalizationStorage localizationStorage) {
        bottomSheetNoArchive.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetNoArchive bottomSheetNoArchive, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetNoArchive.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetNoArchive bottomSheetNoArchive, Analytics analytics) {
        bottomSheetNoArchive.analytics = analytics;
    }

    public static void injectLocalizationScreen(BottomSheetNoArchive bottomSheetNoArchive, LocalizationStorage localizationStorage) {
        bottomSheetNoArchive.localizationScreen = localizationStorage;
    }
}
