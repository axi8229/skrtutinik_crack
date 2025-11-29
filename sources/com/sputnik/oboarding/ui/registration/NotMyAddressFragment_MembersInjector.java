package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class NotMyAddressFragment_MembersInjector implements MembersInjector<NotMyAddressFragment> {
    public static void injectLocalizationStorage(NotMyAddressFragment notMyAddressFragment, LocalizationStorage localizationStorage) {
        notMyAddressFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(NotMyAddressFragment notMyAddressFragment, MultiViewModelFactory multiViewModelFactory) {
        notMyAddressFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(NotMyAddressFragment notMyAddressFragment, Analytics analytics) {
        notMyAddressFragment.analytics = analytics;
    }

    public static void injectSupportManager(NotMyAddressFragment notMyAddressFragment, ISupportManager iSupportManager) {
        notMyAddressFragment.supportManager = iSupportManager;
    }
}
