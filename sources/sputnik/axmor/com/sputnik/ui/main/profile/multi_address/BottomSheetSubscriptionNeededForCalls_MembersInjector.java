package sputnik.axmor.com.sputnik.ui.main.profile.multi_address;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class BottomSheetSubscriptionNeededForCalls_MembersInjector implements MembersInjector<BottomSheetSubscriptionNeededForCalls> {
    public static void injectLocalizationStorage(BottomSheetSubscriptionNeededForCalls bottomSheetSubscriptionNeededForCalls, LocalizationStorage localizationStorage) {
        bottomSheetSubscriptionNeededForCalls.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BottomSheetSubscriptionNeededForCalls bottomSheetSubscriptionNeededForCalls, MultiViewModelFactory multiViewModelFactory) {
        bottomSheetSubscriptionNeededForCalls.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(BottomSheetSubscriptionNeededForCalls bottomSheetSubscriptionNeededForCalls, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        bottomSheetSubscriptionNeededForCalls.cameraViewModelFactory = assistFactory;
    }

    public static void injectAnalytics(BottomSheetSubscriptionNeededForCalls bottomSheetSubscriptionNeededForCalls, Analytics analytics) {
        bottomSheetSubscriptionNeededForCalls.analytics = analytics;
    }
}
