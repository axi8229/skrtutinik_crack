package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class EnterSmsCodeFragment_MembersInjector implements MembersInjector<EnterSmsCodeFragment> {
    public static void injectCallCodeFactoryBuilder(EnterSmsCodeFragment enterSmsCodeFragment, CallCodeViewModel.Factory.AssistFactory assistFactory) {
        enterSmsCodeFragment.callCodeFactoryBuilder = assistFactory;
    }

    public static void injectFactory(EnterSmsCodeFragment enterSmsCodeFragment, MultiViewModelFactory multiViewModelFactory) {
        enterSmsCodeFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationStorage(EnterSmsCodeFragment enterSmsCodeFragment, LocalizationStorage localizationStorage) {
        enterSmsCodeFragment.localizationStorage = localizationStorage;
    }

    public static void injectAnalytics(EnterSmsCodeFragment enterSmsCodeFragment, Analytics analytics) {
        enterSmsCodeFragment.analytics = analytics;
    }

    public static void injectCameraViewModelFactory(EnterSmsCodeFragment enterSmsCodeFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        enterSmsCodeFragment.cameraViewModelFactory = assistFactory;
    }
}
