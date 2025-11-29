package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class KeysFragment_MembersInjector implements MembersInjector<KeysFragment> {
    public static void injectLocalization(KeysFragment keysFragment, LocalizationStorage localizationStorage) {
        keysFragment.localization = localizationStorage;
    }

    public static void injectAnalytics(KeysFragment keysFragment, Analytics analytics) {
        keysFragment.analytics = analytics;
    }

    public static void injectFactory(KeysFragment keysFragment, MultiViewModelFactory multiViewModelFactory) {
        keysFragment.factory = multiViewModelFactory;
    }
}
