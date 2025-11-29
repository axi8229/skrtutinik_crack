package sputnik.axmor.com.sputnik.ui.main.profile.family;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class FamilyInfoFragment_MembersInjector implements MembersInjector<FamilyInfoFragment> {
    public static void injectFactory(FamilyInfoFragment familyInfoFragment, MultiViewModelFactory multiViewModelFactory) {
        familyInfoFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(FamilyInfoFragment familyInfoFragment, LocalizationStorage localizationStorage) {
        familyInfoFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(FamilyInfoFragment familyInfoFragment, Analytics analytics) {
        familyInfoFragment.analytics = analytics;
    }
}
