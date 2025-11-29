package com.sputnik.oboarding.ui.onboarding;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class OnBoardingFragment_MembersInjector implements MembersInjector<OnBoardingFragment> {
    public static void injectLocalizationStorage(OnBoardingFragment onBoardingFragment, LocalizationStorage localizationStorage) {
        onBoardingFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(OnBoardingFragment onBoardingFragment, MultiViewModelFactory multiViewModelFactory) {
        onBoardingFragment.factory = multiViewModelFactory;
    }

    public static void injectPrefManager(OnBoardingFragment onBoardingFragment, PrefManager prefManager) {
        onBoardingFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(OnBoardingFragment onBoardingFragment, Analytics analytics) {
        onBoardingFragment.analytics = analytics;
    }
}
