package com.sputnik.service_payments.ui.blocking;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class BlockingPromiseBlockFragment_MembersInjector implements MembersInjector<BlockingPromiseBlockFragment> {
    public static void injectLocalizationStorage(BlockingPromiseBlockFragment blockingPromiseBlockFragment, LocalizationStorage localizationStorage) {
        blockingPromiseBlockFragment.localizationStorage = localizationStorage;
    }

    public static void injectFactory(BlockingPromiseBlockFragment blockingPromiseBlockFragment, MultiViewModelFactory multiViewModelFactory) {
        blockingPromiseBlockFragment.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(BlockingPromiseBlockFragment blockingPromiseBlockFragment, Analytics analytics) {
        blockingPromiseBlockFragment.analytics = analytics;
    }
}
