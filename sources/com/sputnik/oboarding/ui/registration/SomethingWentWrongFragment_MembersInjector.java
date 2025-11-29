package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class SomethingWentWrongFragment_MembersInjector implements MembersInjector<SomethingWentWrongFragment> {
    public static void injectFactory(SomethingWentWrongFragment somethingWentWrongFragment, MultiViewModelFactory multiViewModelFactory) {
        somethingWentWrongFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(SomethingWentWrongFragment somethingWentWrongFragment, Analytics analytics) {
        somethingWentWrongFragment.analytics = analytics;
    }

    public static void injectLocalizationStorage(SomethingWentWrongFragment somethingWentWrongFragment, LocalizationStorage localizationStorage) {
        somethingWentWrongFragment.localizationStorage = localizationStorage;
    }

    public static void injectSupportManager(SomethingWentWrongFragment somethingWentWrongFragment, ISupportManager iSupportManager) {
        somethingWentWrongFragment.supportManager = iSupportManager;
    }
}
