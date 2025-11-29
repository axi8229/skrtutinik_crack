package com.sputnik.oboarding.ui.registration.ways.support;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.CallCodeViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class NeedHelpFragment_MembersInjector implements MembersInjector<NeedHelpFragment> {
    public static void injectCallCodeFactoryBuilder(NeedHelpFragment needHelpFragment, CallCodeViewModel.Factory.AssistFactory assistFactory) {
        needHelpFragment.callCodeFactoryBuilder = assistFactory;
    }

    public static void injectFactory(NeedHelpFragment needHelpFragment, MultiViewModelFactory multiViewModelFactory) {
        needHelpFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationStorage(NeedHelpFragment needHelpFragment, LocalizationStorage localizationStorage) {
        needHelpFragment.localizationStorage = localizationStorage;
    }

    public static void injectAnalytics(NeedHelpFragment needHelpFragment, Analytics analytics) {
        needHelpFragment.analytics = analytics;
    }

    public static void injectSupportManager(NeedHelpFragment needHelpFragment, ISupportManager iSupportManager) {
        needHelpFragment.supportManager = iSupportManager;
    }
}
