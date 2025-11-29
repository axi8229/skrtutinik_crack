package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class EnterNameFragment_MembersInjector implements MembersInjector<EnterNameFragment> {
    public static void injectLocalizationScreen(EnterNameFragment enterNameFragment, LocalizationStorage localizationStorage) {
        enterNameFragment.localizationScreen = localizationStorage;
    }

    public static void injectSettingsProfileViewModelFactory(EnterNameFragment enterNameFragment, SettingsProfileViewModel.Factory.AssistFactory assistFactory) {
        enterNameFragment.settingsProfileViewModelFactory = assistFactory;
    }

    public static void injectAnalytics(EnterNameFragment enterNameFragment, Analytics analytics) {
        enterNameFragment.analytics = analytics;
    }

    public static void injectFactory(EnterNameFragment enterNameFragment, MultiViewModelFactory multiViewModelFactory) {
        enterNameFragment.factory = multiViewModelFactory;
    }
}
