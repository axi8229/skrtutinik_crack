package com.sputnik.oboarding.ui.splash;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class FinishSplashFragment_MembersInjector implements MembersInjector<FinishSplashFragment> {
    public static void injectLocalizationStorage(FinishSplashFragment finishSplashFragment, LocalizationStorage localizationStorage) {
        finishSplashFragment.localizationStorage = localizationStorage;
    }

    public static void injectPrefManager(FinishSplashFragment finishSplashFragment, PrefManager prefManager) {
        finishSplashFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(FinishSplashFragment finishSplashFragment, Analytics analytics) {
        finishSplashFragment.analytics = analytics;
    }

    public static void injectFactory(FinishSplashFragment finishSplashFragment, MultiViewModelFactory multiViewModelFactory) {
        finishSplashFragment.factory = multiViewModelFactory;
    }
}
