package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class EnterFlatNumberFragment_MembersInjector implements MembersInjector<EnterFlatNumberFragment> {
    public static void injectLocalizationStorage(EnterFlatNumberFragment enterFlatNumberFragment, LocalizationStorage localizationStorage) {
        enterFlatNumberFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(EnterFlatNumberFragment enterFlatNumberFragment, MultiViewModelFactory multiViewModelFactory) {
        enterFlatNumberFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(EnterFlatNumberFragment enterFlatNumberFragment, Analytics analytics) {
        enterFlatNumberFragment.analytics = analytics;
    }
}
