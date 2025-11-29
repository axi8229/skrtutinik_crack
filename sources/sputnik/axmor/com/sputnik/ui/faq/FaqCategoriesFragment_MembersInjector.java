package sputnik.axmor.com.sputnik.ui.faq;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class FaqCategoriesFragment_MembersInjector implements MembersInjector<FaqCategoriesFragment> {
    public static void injectPrefManager(FaqCategoriesFragment faqCategoriesFragment, PrefManager prefManager) {
        faqCategoriesFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(FaqCategoriesFragment faqCategoriesFragment, Analytics analytics) {
        faqCategoriesFragment.analytics = analytics;
    }

    public static void injectLocalizationScreen(FaqCategoriesFragment faqCategoriesFragment, LocalizationStorage localizationStorage) {
        faqCategoriesFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(FaqCategoriesFragment faqCategoriesFragment, MultiViewModelFactory multiViewModelFactory) {
        faqCategoriesFragment.factory = multiViewModelFactory;
    }

    public static void injectSupportManager(FaqCategoriesFragment faqCategoriesFragment, ISupportManager iSupportManager) {
        faqCategoriesFragment.supportManager = iSupportManager;
    }
}
