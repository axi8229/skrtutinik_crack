package com.sputnik.service_payments.ui.payment_info_list;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class IntercomPaymentFragment_MembersInjector implements MembersInjector<IntercomPaymentFragment> {
    public static void injectLocalizationStorage(IntercomPaymentFragment intercomPaymentFragment, LocalizationStorage localizationStorage) {
        intercomPaymentFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(IntercomPaymentFragment intercomPaymentFragment, MultiViewModelFactory multiViewModelFactory) {
        intercomPaymentFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(IntercomPaymentFragment intercomPaymentFragment, Analytics analytics) {
        intercomPaymentFragment.analytics = analytics;
    }
}
