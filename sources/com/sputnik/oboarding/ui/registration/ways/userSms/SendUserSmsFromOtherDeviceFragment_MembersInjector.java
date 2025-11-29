package com.sputnik.oboarding.ui.registration.ways.userSms;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class SendUserSmsFromOtherDeviceFragment_MembersInjector implements MembersInjector<SendUserSmsFromOtherDeviceFragment> {
    public static void injectCallCodeFactoryBuilder(SendUserSmsFromOtherDeviceFragment sendUserSmsFromOtherDeviceFragment, CallCodeViewModel.Factory.AssistFactory assistFactory) {
        sendUserSmsFromOtherDeviceFragment.callCodeFactoryBuilder = assistFactory;
    }

    public static void injectFactory(SendUserSmsFromOtherDeviceFragment sendUserSmsFromOtherDeviceFragment, MultiViewModelFactory multiViewModelFactory) {
        sendUserSmsFromOtherDeviceFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationStorage(SendUserSmsFromOtherDeviceFragment sendUserSmsFromOtherDeviceFragment, LocalizationStorage localizationStorage) {
        sendUserSmsFromOtherDeviceFragment.localizationStorage = localizationStorage;
    }

    public static void injectAnalytics(SendUserSmsFromOtherDeviceFragment sendUserSmsFromOtherDeviceFragment, Analytics analytics) {
        sendUserSmsFromOtherDeviceFragment.analytics = analytics;
    }
}
