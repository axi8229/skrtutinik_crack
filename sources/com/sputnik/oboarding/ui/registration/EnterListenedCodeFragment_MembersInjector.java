package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class EnterListenedCodeFragment_MembersInjector implements MembersInjector<EnterListenedCodeFragment> {
    public static void injectLocalizationScreen(EnterListenedCodeFragment enterListenedCodeFragment, LocalizationStorage localizationStorage) {
        enterListenedCodeFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(EnterListenedCodeFragment enterListenedCodeFragment, MultiViewModelFactory multiViewModelFactory) {
        enterListenedCodeFragment.factory = multiViewModelFactory;
    }

    public static void injectCallCodeFactoryBuilder(EnterListenedCodeFragment enterListenedCodeFragment, CallCodeViewModel.Factory.AssistFactory assistFactory) {
        enterListenedCodeFragment.callCodeFactoryBuilder = assistFactory;
    }

    public static void injectPrefManager(EnterListenedCodeFragment enterListenedCodeFragment, PrefManager prefManager) {
        enterListenedCodeFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(EnterListenedCodeFragment enterListenedCodeFragment, Analytics analytics) {
        enterListenedCodeFragment.analytics = analytics;
    }

    public static void injectCameraViewModelFactory(EnterListenedCodeFragment enterListenedCodeFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        enterListenedCodeFragment.cameraViewModelFactory = assistFactory;
    }
}
