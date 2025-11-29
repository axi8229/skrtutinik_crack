package sputnik.axmor.com.sputnik.ui.main.market.items;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ItemDetailsFragment_MembersInjector implements MembersInjector<ItemDetailsFragment> {
    public static void injectFactory(ItemDetailsFragment itemDetailsFragment, MultiViewModelFactory multiViewModelFactory) {
        itemDetailsFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(ItemDetailsFragment itemDetailsFragment, LocalizationStorage localizationStorage) {
        itemDetailsFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(ItemDetailsFragment itemDetailsFragment, Analytics analytics) {
        itemDetailsFragment.analytics = analytics;
    }
}
