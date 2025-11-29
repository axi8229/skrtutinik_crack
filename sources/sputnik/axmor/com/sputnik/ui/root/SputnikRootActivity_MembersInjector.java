package sputnik.axmor.com.sputnik.ui.root;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SputnikRootActivity_MembersInjector implements MembersInjector<SputnikRootActivity> {
    public static void injectLocalizationScreen(SputnikRootActivity sputnikRootActivity, LocalizationStorage localizationStorage) {
        sputnikRootActivity.localizationScreen = localizationStorage;
    }

    public static void injectFactory(SputnikRootActivity sputnikRootActivity, MultiViewModelFactory multiViewModelFactory) {
        sputnikRootActivity.factory = multiViewModelFactory;
    }

    public static void injectAnalytics(SputnikRootActivity sputnikRootActivity, Analytics analytics) {
        sputnikRootActivity.analytics = analytics;
    }
}
