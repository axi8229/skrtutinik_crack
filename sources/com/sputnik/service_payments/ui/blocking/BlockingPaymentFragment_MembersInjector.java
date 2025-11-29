package com.sputnik.service_payments.ui.blocking;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class BlockingPaymentFragment_MembersInjector implements MembersInjector<BlockingPaymentFragment> {
    public static void injectLocalizationStorage(BlockingPaymentFragment blockingPaymentFragment, LocalizationStorage localizationStorage) {
        blockingPaymentFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BlockingPaymentFragment blockingPaymentFragment, MultiViewModelFactory multiViewModelFactory) {
        blockingPaymentFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BlockingPaymentFragment blockingPaymentFragment, Analytics analytics) {
        blockingPaymentFragment.analytics = analytics;
    }
}
