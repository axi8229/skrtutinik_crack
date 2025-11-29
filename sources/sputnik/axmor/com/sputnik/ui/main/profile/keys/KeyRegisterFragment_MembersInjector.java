package sputnik.axmor.com.sputnik.ui.main.profile.keys;

import com.sputnik.common.analytics.Analytics;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class KeyRegisterFragment_MembersInjector implements MembersInjector<KeyRegisterFragment> {
    public static void injectLocalizationScreen(KeyRegisterFragment keyRegisterFragment, LocalizationStorage localizationStorage) {
        keyRegisterFragment.localizationScreen = localizationStorage;
    }

    public static void injectAnalytics(KeyRegisterFragment keyRegisterFragment, Analytics analytics) {
        keyRegisterFragment.analytics = analytics;
    }

    public static void injectFactory(KeyRegisterFragment keyRegisterFragment, MultiViewModelFactory multiViewModelFactory) {
        keyRegisterFragment.factory = multiViewModelFactory;
    }
}
