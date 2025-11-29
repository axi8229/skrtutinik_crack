package sputnik.axmor.com.sputnik.ui.main.market.subscription;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SubscriptionFragment_MembersInjector implements MembersInjector<SubscriptionFragment> {
    public static void injectFactory(SubscriptionFragment subscriptionFragment, MultiViewModelFactory multiViewModelFactory) {
        subscriptionFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(SubscriptionFragment subscriptionFragment, LocalizationStorage localizationStorage) {
        subscriptionFragment.localizationScreen = localizationStorage;
    }
}
