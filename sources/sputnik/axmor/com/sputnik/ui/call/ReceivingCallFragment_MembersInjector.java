package sputnik.axmor.com.sputnik.ui.call;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;
import sputnik.axmor.com.sputnik.ui.call.viewmodel.CallViewModel;

/* loaded from: classes5.dex */
public final class ReceivingCallFragment_MembersInjector implements MembersInjector<ReceivingCallFragment> {
    public static void injectLocalizationScreen(ReceivingCallFragment receivingCallFragment, LocalizationStorage localizationStorage) {
        receivingCallFragment.localizationScreen = localizationStorage;
    }

    public static void injectCamerasFactory(ReceivingCallFragment receivingCallFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        receivingCallFragment.camerasFactory = assistFactory;
    }

    public static void injectCallViewModelFactory(ReceivingCallFragment receivingCallFragment, CallViewModel.Factory.AssistFactory assistFactory) {
        receivingCallFragment.callViewModelFactory = assistFactory;
    }

    public static void injectAnalytics(ReceivingCallFragment receivingCallFragment, Analytics analytics) {
        receivingCallFragment.analytics = analytics;
    }

    public static void injectPrefManager(ReceivingCallFragment receivingCallFragment, PrefManager prefManager) {
        receivingCallFragment.prefManager = prefManager;
    }

    public static void injectFactory(ReceivingCallFragment receivingCallFragment, MultiViewModelFactory multiViewModelFactory) {
        receivingCallFragment.factory = multiViewModelFactory;
    }
}
