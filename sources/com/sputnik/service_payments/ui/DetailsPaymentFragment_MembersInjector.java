package com.sputnik.service_payments.ui;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class DetailsPaymentFragment_MembersInjector implements MembersInjector<DetailsPaymentFragment> {
    public static void injectLocalizationStorage(DetailsPaymentFragment detailsPaymentFragment, LocalizationStorage localizationStorage) {
        detailsPaymentFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(DetailsPaymentFragment detailsPaymentFragment, MultiViewModelFactory multiViewModelFactory) {
        detailsPaymentFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(DetailsPaymentFragment detailsPaymentFragment, Analytics analytics) {
        detailsPaymentFragment.analytics = analytics;
    }
}
