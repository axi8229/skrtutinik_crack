package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class EnterCodeFragment_MembersInjector implements MembersInjector<EnterCodeFragment> {
    public static void injectLocalizationScreen(EnterCodeFragment enterCodeFragment, LocalizationStorage localizationStorage) {
        enterCodeFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(EnterCodeFragment enterCodeFragment, MultiViewModelFactory multiViewModelFactory) {
        enterCodeFragment.factory = multiViewModelFactory;
    }

    public static void injectCallCodeFactoryBuilder(EnterCodeFragment enterCodeFragment, CallCodeViewModel.Factory.AssistFactory assistFactory) {
        enterCodeFragment.callCodeFactoryBuilder = assistFactory;
    }

    public static void injectPrefManager(EnterCodeFragment enterCodeFragment, PrefManager prefManager) {
        enterCodeFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(EnterCodeFragment enterCodeFragment, Analytics analytics) {
        enterCodeFragment.analytics = analytics;
    }

    public static void injectCameraViewModelFactory(EnterCodeFragment enterCodeFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        enterCodeFragment.cameraViewModelFactory = assistFactory;
    }
}
