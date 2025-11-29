package sputnik.axmor.com.sputnik.ui.faq;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class FaqSubcategoriesFragment_MembersInjector implements MembersInjector<FaqSubcategoriesFragment> {
    public static void injectPrefManager(FaqSubcategoriesFragment faqSubcategoriesFragment, PrefManager prefManager) {
        faqSubcategoriesFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(FaqSubcategoriesFragment faqSubcategoriesFragment, Analytics analytics) {
        faqSubcategoriesFragment.analytics = analytics;
    }

    public static void injectFactory(FaqSubcategoriesFragment faqSubcategoriesFragment, MultiViewModelFactory multiViewModelFactory) {
        faqSubcategoriesFragment.factory = multiViewModelFactory;
    }

    public static void injectSupportManager(FaqSubcategoriesFragment faqSubcategoriesFragment, ISupportManager iSupportManager) {
        faqSubcategoriesFragment.supportManager = iSupportManager;
    }
}
