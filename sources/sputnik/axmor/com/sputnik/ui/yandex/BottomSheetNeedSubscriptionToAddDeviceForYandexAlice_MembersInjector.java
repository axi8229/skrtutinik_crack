package sputnik.axmor.com.sputnik.ui.yandex;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetNeedSubscriptionToAddDeviceForYandexAlice_MembersInjector implements MembersInjector<BottomSheetNeedSubscriptionToAddDeviceForYandexAlice> {
    public static void injectLocalizationStorage(BottomSheetNeedSubscriptionToAddDeviceForYandexAlice bottomSheetNeedSubscriptionToAddDeviceForYandexAlice, LocalizationStorage localizationStorage) {
        bottomSheetNeedSubscriptionToAddDeviceForYandexAlice.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetNeedSubscriptionToAddDeviceForYandexAlice bottomSheetNeedSubscriptionToAddDeviceForYandexAlice, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetNeedSubscriptionToAddDeviceForYandexAlice.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BottomSheetNeedSubscriptionToAddDeviceForYandexAlice bottomSheetNeedSubscriptionToAddDeviceForYandexAlice, Analytics analytics) {
        bottomSheetNeedSubscriptionToAddDeviceForYandexAlice.analytics = analytics;
    }
}
