package com.sputnik.oboarding.ui.registration.ways.userSms;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class WaitingUserSmsFragment_MembersInjector implements MembersInjector<WaitingUserSmsFragment> {
    public static void injectCallCodeFactoryBuilder(WaitingUserSmsFragment waitingUserSmsFragment, CallCodeViewModel.Factory.AssistFactory assistFactory) {
        waitingUserSmsFragment.callCodeFactoryBuilder = assistFactory;
    }

    public static void injectFactory(WaitingUserSmsFragment waitingUserSmsFragment, MultiViewModelFactory multiViewModelFactory) {
        waitingUserSmsFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationStorage(WaitingUserSmsFragment waitingUserSmsFragment, LocalizationStorage localizationStorage) {
        waitingUserSmsFragment.localizationStorage = localizationStorage;
    }

    public static void injectAnalytics(WaitingUserSmsFragment waitingUserSmsFragment, Analytics analytics) {
        waitingUserSmsFragment.analytics = analytics;
    }

    public static void injectCameraViewModelFactory(WaitingUserSmsFragment waitingUserSmsFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        waitingUserSmsFragment.cameraViewModelFactory = assistFactory;
    }
}
