package sputnik.axmor.com.sputnik.ui.faq;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.support.ISupportManager;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class FaqFragment_MembersInjector implements MembersInjector<FaqFragment> {
    public static void injectPrefManager(FaqFragment faqFragment, PrefManager prefManager) {
        faqFragment.prefManager = prefManager;
    }

    public static void injectAnalytics(FaqFragment faqFragment, Analytics analytics) {
        faqFragment.analytics = analytics;
    }

    public static void injectLocalizationScreen(FaqFragment faqFragment, LocalizationStorage localizationStorage) {
        faqFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(FaqFragment faqFragment, MultiViewModelFactory multiViewModelFactory) {
        faqFragment.factory = multiViewModelFactory;
    }

    public static void injectSupportManager(FaqFragment faqFragment, ISupportManager iSupportManager) {
        faqFragment.supportManager = iSupportManager;
    }
}
