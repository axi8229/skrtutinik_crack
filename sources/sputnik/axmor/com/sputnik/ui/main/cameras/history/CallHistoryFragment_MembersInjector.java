package sputnik.axmor.com.sputnik.ui.main.cameras.history;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;
import sputnik.axmor.com.sputnik.ui.main.cameras.history.viewmodel.CallHistoryViewModel;

/* loaded from: classes5.dex */
public final class CallHistoryFragment_MembersInjector implements MembersInjector<CallHistoryFragment> {
    public static void injectLocalizationScreen(CallHistoryFragment callHistoryFragment, LocalizationStorage localizationStorage) {
        callHistoryFragment.localizationScreen = localizationStorage;
    }

    public static void injectCallHistoryFactory(CallHistoryFragment callHistoryFragment, CallHistoryViewModel.Factory.AssistFactory assistFactory) {
        callHistoryFragment.callHistoryFactory = assistFactory;
    }

    public static void injectFactory(CallHistoryFragment callHistoryFragment, MultiViewModelFactory multiViewModelFactory) {
        callHistoryFragment.factory = multiViewModelFactory;
    }

    public static void injectCamerasFactory(CallHistoryFragment callHistoryFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        callHistoryFragment.camerasFactory = assistFactory;
    }

    public static void injectAnalytics(CallHistoryFragment callHistoryFragment, Analytics analytics) {
        callHistoryFragment.analytics = analytics;
    }
}
