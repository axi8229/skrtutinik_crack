package sputnik.axmor.com.sputnik.ui.main.profile.family;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class FamilyListFragment_MembersInjector implements MembersInjector<FamilyListFragment> {
    public static void injectLocalizationScreen(FamilyListFragment familyListFragment, LocalizationStorage localizationStorage) {
        familyListFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(FamilyListFragment familyListFragment, Analytics analytics) {
        familyListFragment.analytics = analytics;
    }

    public static void injectFactory(FamilyListFragment familyListFragment, MultiViewModelFactory multiViewModelFactory) {
        familyListFragment.factory = multiViewModelFactory;
    }
}
