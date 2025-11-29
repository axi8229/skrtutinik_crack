package sputnik.axmor.com.sputnik.ui.polls;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetRatePoll_MembersInjector implements MembersInjector<BottomSheetRatePoll> {
    public static void injectLocalizationStorage(BottomSheetRatePoll bottomSheetRatePoll, LocalizationStorage localizationStorage) {
        bottomSheetRatePoll.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetRatePoll bottomSheetRatePoll, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetRatePoll.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetRatePoll bottomSheetRatePoll, Analytics analytics) {
        bottomSheetRatePoll.analytics = analytics;
    }

    public static void injectLocalizationScreen(BottomSheetRatePoll bottomSheetRatePoll, LocalizationStorage localizationStorage) {
        bottomSheetRatePoll.localizationScreen = localizationStorage;
    }
}
