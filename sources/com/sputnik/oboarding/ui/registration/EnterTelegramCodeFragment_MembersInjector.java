package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class EnterTelegramCodeFragment_MembersInjector implements MembersInjector<EnterTelegramCodeFragment> {
    public static void injectLocalizationScreen(EnterTelegramCodeFragment enterTelegramCodeFragment, LocalizationStorage localizationStorage) {
        enterTelegramCodeFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(EnterTelegramCodeFragment enterTelegramCodeFragment, MultiViewModelFactory multiViewModelFactory) {
        enterTelegramCodeFragment.factory = multiViewModelFactory;
    }

    public static void injectCallCodeFactoryBuilder(EnterTelegramCodeFragment enterTelegramCodeFragment, CallCodeViewModel.Factory.AssistFactory assistFactory) {
        enterTelegramCodeFragment.callCodeFactoryBuilder = assistFactory;
    }

    public static void injectPrefManager(EnterTelegramCodeFragment enterTelegramCodeFragment, PrefManager prefManager) {
        enterTelegramCodeFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(EnterTelegramCodeFragment enterTelegramCodeFragment, Analytics analytics) {
        enterTelegramCodeFragment.analytics = analytics;
    }

    public static void injectCameraViewModelFactory(EnterTelegramCodeFragment enterTelegramCodeFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        enterTelegramCodeFragment.cameraViewModelFactory = assistFactory;
    }
}
