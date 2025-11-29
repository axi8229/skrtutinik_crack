package sputnik.axmor.com.sputnik.ui.alerts;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetUpdateRequired_MembersInjector implements MembersInjector<BottomSheetUpdateRequired> {
    public static void injectLocalizationStorage(BottomSheetUpdateRequired bottomSheetUpdateRequired, LocalizationStorage localizationStorage) {
        bottomSheetUpdateRequired.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetUpdateRequired bottomSheetUpdateRequired, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetUpdateRequired.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetUpdateRequired bottomSheetUpdateRequired, Analytics analytics) {
        bottomSheetUpdateRequired.analytics = analytics;
    }
}
