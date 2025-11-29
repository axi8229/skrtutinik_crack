package sputnik.axmor.com.sputnik.ui.main.profile.localization;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class LocalizationSplash_MembersInjector implements MembersInjector<LocalizationSplash> {
    public static void injectFactory(LocalizationSplash localizationSplash, MultiViewModelFactory multiViewModelFactory) {
        localizationSplash.factory = multiViewModelFactory;
    }

    public static void injectPrefManager(LocalizationSplash localizationSplash, PrefManager prefManager) {
        localizationSplash.prefManager = prefManager;
    }

    public static void injectLocalizationScreen(LocalizationSplash localizationSplash, LocalizationStorage localizationStorage) {
        localizationSplash.localizationScreen = localizationStorage;
    }
}
