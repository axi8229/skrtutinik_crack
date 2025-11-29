package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class StartRegistrationFragment_MembersInjector implements MembersInjector<StartRegistrationFragment> {
    public static void injectLocalizationStorage(StartRegistrationFragment startRegistrationFragment, LocalizationStorage localizationStorage) {
        startRegistrationFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(StartRegistrationFragment startRegistrationFragment, MultiViewModelFactory multiViewModelFactory) {
        startRegistrationFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(StartRegistrationFragment startRegistrationFragment, Analytics analytics) {
        startRegistrationFragment.analytics = analytics;
    }

    public static void injectPrefManager(StartRegistrationFragment startRegistrationFragment, PrefManager prefManager) {
        startRegistrationFragment.prefManager = prefManager;
    }

    public static void injectCameraViewModelFactory(StartRegistrationFragment startRegistrationFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        startRegistrationFragment.cameraViewModelFactory = assistFactory;
    }
}
