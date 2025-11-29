package sputnik.axmor.com.sputnik.ui.polls;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetPollSuccess_MembersInjector implements MembersInjector<BottomSheetPollSuccess> {
    public static void injectLocalizationStorage(BottomSheetPollSuccess bottomSheetPollSuccess, LocalizationStorage localizationStorage) {
        bottomSheetPollSuccess.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetPollSuccess bottomSheetPollSuccess, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetPollSuccess.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetPollSuccess bottomSheetPollSuccess, Analytics analytics) {
        bottomSheetPollSuccess.analytics = analytics;
    }
}
