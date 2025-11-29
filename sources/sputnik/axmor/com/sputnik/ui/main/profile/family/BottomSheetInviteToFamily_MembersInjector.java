package sputnik.axmor.com.sputnik.ui.main.profile.family;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetInviteToFamily_MembersInjector implements MembersInjector<BottomSheetInviteToFamily> {
    public static void injectLocalizationStorage(BottomSheetInviteToFamily bottomSheetInviteToFamily, LocalizationStorage localizationStorage) {
        bottomSheetInviteToFamily.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetInviteToFamily bottomSheetInviteToFamily, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetInviteToFamily.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetInviteToFamily bottomSheetInviteToFamily, Analytics analytics) {
        bottomSheetInviteToFamily.analytics = analytics;
    }
}
