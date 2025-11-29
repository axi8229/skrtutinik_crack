package sputnik.axmor.com.sputnik.ui.main.permissions;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetBackgroundWork_MembersInjector implements MembersInjector<BottomSheetBackgroundWork> {
    public static void injectLocalizationStorage(BottomSheetBackgroundWork bottomSheetBackgroundWork, LocalizationStorage localizationStorage) {
        bottomSheetBackgroundWork.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetBackgroundWork bottomSheetBackgroundWork, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetBackgroundWork.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetBackgroundWork bottomSheetBackgroundWork, Analytics analytics) {
        bottomSheetBackgroundWork.analytics = analytics;
    }
}
