package sputnik.axmor.com.sputnik.ui.multi_address;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetMultiAddressAnnounce_MembersInjector implements MembersInjector<BottomSheetMultiAddressAnnounce> {
    public static void injectLocalizationStorage(BottomSheetMultiAddressAnnounce bottomSheetMultiAddressAnnounce, LocalizationStorage localizationStorage) {
        bottomSheetMultiAddressAnnounce.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetMultiAddressAnnounce bottomSheetMultiAddressAnnounce, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetMultiAddressAnnounce.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetMultiAddressAnnounce bottomSheetMultiAddressAnnounce, Analytics analytics) {
        bottomSheetMultiAddressAnnounce.analytics = analytics;
    }
}
