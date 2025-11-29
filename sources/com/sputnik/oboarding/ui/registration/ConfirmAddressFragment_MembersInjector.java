package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class ConfirmAddressFragment_MembersInjector implements MembersInjector<ConfirmAddressFragment> {
    public static void injectFactory(ConfirmAddressFragment confirmAddressFragment, MultiViewModelFactory multiViewModelFactory) {
        confirmAddressFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationStorage(ConfirmAddressFragment confirmAddressFragment, LocalizationStorage localizationStorage) {
        confirmAddressFragment.localizationStorage = localizationStorage;
    }

    public static void injectAnalytics(ConfirmAddressFragment confirmAddressFragment, Analytics analytics) {
        confirmAddressFragment.analytics = analytics;
    }

    public static void injectCamerasFactory(ConfirmAddressFragment confirmAddressFragment, AllCamerasViewModel.Factory.AssistFactory assistFactory) {
        confirmAddressFragment.camerasFactory = assistFactory;
    }
}
