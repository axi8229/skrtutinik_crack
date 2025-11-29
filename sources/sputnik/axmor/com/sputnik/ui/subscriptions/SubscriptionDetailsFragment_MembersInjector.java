package sputnik.axmor.com.sputnik.ui.subscriptions;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SubscriptionDetailsFragment_MembersInjector implements MembersInjector<SubscriptionDetailsFragment> {
    public static void injectFactory(SubscriptionDetailsFragment subscriptionDetailsFragment, MultiViewModelFactory multiViewModelFactory) {
        subscriptionDetailsFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(SubscriptionDetailsFragment subscriptionDetailsFragment, LocalizationStorage localizationStorage) {
        subscriptionDetailsFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(SubscriptionDetailsFragment subscriptionDetailsFragment, Analytics analytics) {
        subscriptionDetailsFragment.analytics = analytics;
    }
}
