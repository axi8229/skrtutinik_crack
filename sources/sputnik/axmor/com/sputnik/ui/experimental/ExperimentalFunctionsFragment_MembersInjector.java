package sputnik.axmor.com.sputnik.ui.experimental;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class ExperimentalFunctionsFragment_MembersInjector implements MembersInjector<ExperimentalFunctionsFragment> {
    public static void injectFactory(ExperimentalFunctionsFragment experimentalFunctionsFragment, MultiViewModelFactory multiViewModelFactory) {
        experimentalFunctionsFragment.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(ExperimentalFunctionsFragment experimentalFunctionsFragment, LocalizationStorage localizationStorage) {
        experimentalFunctionsFragment.localizationScreen = localizationStorage;
    }

    public static void injectPrefManager(ExperimentalFunctionsFragment experimentalFunctionsFragment, PrefManager prefManager) {
        experimentalFunctionsFragment.prefManager = prefManager;
    }
}
