package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class EnterPhoneFragment_MembersInjector implements MembersInjector<EnterPhoneFragment> {
    public static void injectAnalytics(EnterPhoneFragment enterPhoneFragment, Analytics analytics) {
        enterPhoneFragment.analytics = analytics;
    }

    public static void injectLocalizationStorage(EnterPhoneFragment enterPhoneFragment, LocalizationStorage localizationStorage) {
        enterPhoneFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(EnterPhoneFragment enterPhoneFragment, MultiViewModelFactory multiViewModelFactory) {
        enterPhoneFragment.factory = multiViewModelFactory;
    }

    public static void injectCameraViewModelFactory(EnterPhoneFragment enterPhoneFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        enterPhoneFragment.cameraViewModelFactory = assistFactory;
    }
}
