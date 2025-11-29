package sputnik.axmor.com.sputnik.ui.main.profile.settings_profile;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import com.sputnik.common.viewmodels.SettingsProfileViewModel;
import com.sputnik.data.local.PrefManager;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SettingsProfileFragment_MembersInjector implements MembersInjector<SettingsProfileFragment> {
    public static void injectPrefManager(SettingsProfileFragment settingsProfileFragment, PrefManager prefManager) {
        settingsProfileFragment.prefManager = prefManager;
    }

    public static void injectLocalizationScreen(SettingsProfileFragment settingsProfileFragment, LocalizationStorage localizationStorage) {
        settingsProfileFragment.localizationScreen = localizationStorage;
    }

    public static void injectSettingsProfileFactoryBuilder(SettingsProfileFragment settingsProfileFragment, SettingsProfileViewModel.Factory.AssistFactory assistFactory) {
        settingsProfileFragment.settingsProfileFactoryBuilder = assistFactory;
    }

    public static void injectFactory(SettingsProfileFragment settingsProfileFragment, MultiViewModelFactory multiViewModelFactory) {
        settingsProfileFragment.factory = multiViewModelFactory;
    }
}
