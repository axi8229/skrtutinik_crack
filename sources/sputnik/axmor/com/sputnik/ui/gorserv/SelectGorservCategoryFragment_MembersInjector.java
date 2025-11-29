package sputnik.axmor.com.sputnik.ui.gorserv;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SelectGorservCategoryFragment_MembersInjector implements MembersInjector<SelectGorservCategoryFragment> {
    public static void injectPrefManager(SelectGorservCategoryFragment selectGorservCategoryFragment, PrefManager prefManager) {
        selectGorservCategoryFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(SelectGorservCategoryFragment selectGorservCategoryFragment, Analytics analytics) {
        selectGorservCategoryFragment.analytics = analytics;
    }

    public static void injectLocalizationScreen(SelectGorservCategoryFragment selectGorservCategoryFragment, LocalizationStorage localizationStorage) {
        selectGorservCategoryFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(SelectGorservCategoryFragment selectGorservCategoryFragment, MultiViewModelFactory multiViewModelFactory) {
        selectGorservCategoryFragment.factory = multiViewModelFactory;
    }
}
