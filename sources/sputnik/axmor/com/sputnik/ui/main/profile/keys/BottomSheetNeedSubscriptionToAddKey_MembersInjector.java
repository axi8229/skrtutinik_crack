package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetNeedSubscriptionToAddKey_MembersInjector implements MembersInjector<BottomSheetNeedSubscriptionToAddKey> {
    public static void injectLocalizationStorage(BottomSheetNeedSubscriptionToAddKey bottomSheetNeedSubscriptionToAddKey, LocalizationStorage localizationStorage) {
        bottomSheetNeedSubscriptionToAddKey.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetNeedSubscriptionToAddKey bottomSheetNeedSubscriptionToAddKey, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetNeedSubscriptionToAddKey.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetNeedSubscriptionToAddKey bottomSheetNeedSubscriptionToAddKey, Analytics analytics) {
        bottomSheetNeedSubscriptionToAddKey.analytics = analytics;
    }
}
