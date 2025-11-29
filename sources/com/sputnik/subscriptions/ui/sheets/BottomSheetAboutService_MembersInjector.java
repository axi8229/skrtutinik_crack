package com.sputnik.subscriptions.ui.sheets;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class BottomSheetAboutService_MembersInjector implements MembersInjector<BottomSheetAboutService> {
    public static void injectLocalizationStorage(BottomSheetAboutService bottomSheetAboutService, LocalizationStorage localizationStorage) {
        bottomSheetAboutService.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetAboutService bottomSheetAboutService, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetAboutService.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetAboutService bottomSheetAboutService, Analytics analytics) {
        bottomSheetAboutService.analytics = analytics;
    }
}
