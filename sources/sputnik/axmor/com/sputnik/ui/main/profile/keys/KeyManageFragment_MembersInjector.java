package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class KeyManageFragment_MembersInjector implements MembersInjector<KeyManageFragment> {
    public static void injectLocalization(KeyManageFragment keyManageFragment, LocalizationStorage localizationStorage) {
        keyManageFragment.localization = localizationStorage;
    }

    public static void injectAnalytics(KeyManageFragment keyManageFragment, Analytics analytics) {
        keyManageFragment.analytics = analytics;
    }

    public static void injectFactory(KeyManageFragment keyManageFragment, MultiViewModelFactory multiViewModelFactory) {
        keyManageFragment.factory = multiViewModelFactory;
    }
}
