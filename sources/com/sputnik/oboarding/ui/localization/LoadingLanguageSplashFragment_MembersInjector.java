package com.sputnik.oboarding.ui.localization;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class LoadingLanguageSplashFragment_MembersInjector implements MembersInjector<LoadingLanguageSplashFragment> {
    public static void injectPrefManager(LoadingLanguageSplashFragment loadingLanguageSplashFragment, PrefManager prefManager) {
        loadingLanguageSplashFragment.prefManager = prefManager;
    }

    public static void injectLocalizationStorage(LoadingLanguageSplashFragment loadingLanguageSplashFragment, LocalizationStorage localizationStorage) {
        loadingLanguageSplashFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(LoadingLanguageSplashFragment loadingLanguageSplashFragment, MultiViewModelFactory multiViewModelFactory) {
        loadingLanguageSplashFragment.factory = multiViewModelFactory;
    }
}
