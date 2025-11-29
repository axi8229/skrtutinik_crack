package com.sputnik.oboarding.ui.localization;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class ChooseRegLanguageFragment_MembersInjector implements MembersInjector<ChooseRegLanguageFragment> {
    public static void injectFactory(ChooseRegLanguageFragment chooseRegLanguageFragment, MultiViewModelFactory multiViewModelFactory) {
        chooseRegLanguageFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationStorage(ChooseRegLanguageFragment chooseRegLanguageFragment, LocalizationStorage localizationStorage) {
        chooseRegLanguageFragment.localizationStorage = localizationStorage;
    }

    public static void injectAnalytics(ChooseRegLanguageFragment chooseRegLanguageFragment, Analytics analytics) {
        chooseRegLanguageFragment.analytics = analytics;
    }
}
