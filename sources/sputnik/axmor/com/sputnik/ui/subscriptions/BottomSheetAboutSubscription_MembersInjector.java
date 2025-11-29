package sputnik.axmor.com.sputnik.ui.subscriptions;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetAboutSubscription_MembersInjector implements MembersInjector<BottomSheetAboutSubscription> {
    public static void injectLocalizationStorage(BottomSheetAboutSubscription bottomSheetAboutSubscription, LocalizationStorage localizationStorage) {
        bottomSheetAboutSubscription.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetAboutSubscription bottomSheetAboutSubscription, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetAboutSubscription.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetAboutSubscription bottomSheetAboutSubscription, Analytics analytics) {
        bottomSheetAboutSubscription.analytics = analytics;
    }

    public static void injectLocalizationScreen(BottomSheetAboutSubscription bottomSheetAboutSubscription, LocalizationStorage localizationStorage) {
        bottomSheetAboutSubscription.localizationScreen = localizationStorage;
    }
}
