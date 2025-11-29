package com.sputnik.oboarding.ui.registration.ways.userSms;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class SendUserSmsFragment_MembersInjector implements MembersInjector<SendUserSmsFragment> {
    public static void injectCallCodeFactoryBuilder(SendUserSmsFragment sendUserSmsFragment, CallCodeViewModel.Factory.AssistFactory assistFactory) {
        sendUserSmsFragment.callCodeFactoryBuilder = assistFactory;
    }

    public static void injectFactory(SendUserSmsFragment sendUserSmsFragment, MultiViewModelFactory multiViewModelFactory) {
        sendUserSmsFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationStorage(SendUserSmsFragment sendUserSmsFragment, LocalizationStorage localizationStorage) {
        sendUserSmsFragment.localizationStorage = localizationStorage;
    }

    public static void injectAnalytics(SendUserSmsFragment sendUserSmsFragment, Analytics analytics) {
        sendUserSmsFragment.analytics = analytics;
    }
}
