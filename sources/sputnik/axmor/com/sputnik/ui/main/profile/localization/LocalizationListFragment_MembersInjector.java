package sputnik.axmor.com.sputnik.ui.main.profile.localization;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class LocalizationListFragment_MembersInjector implements MembersInjector<LocalizationListFragment> {
    public static void injectLocalizationScreen(LocalizationListFragment localizationListFragment, LocalizationStorage localizationStorage) {
        localizationListFragment.localizationScreen = localizationStorage;
    }

    public static void injectFactory(LocalizationListFragment localizationListFragment, MultiViewModelFactory multiViewModelFactory) {
        localizationListFragment.factory = multiViewModelFactory;
    }
}
