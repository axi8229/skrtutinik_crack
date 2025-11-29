package sputnik.axmor.com.sputnik.ui.nointercom;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class SettingsAddress_MembersInjector implements MembersInjector<SettingsAddress> {
    public static void injectFactory(SettingsAddress settingsAddress, MultiViewModelFactory multiViewModelFactory) {
        settingsAddress.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(SettingsAddress settingsAddress, LocalizationStorage localizationStorage) {
        settingsAddress.localizationScreen = localizationStorage;
    }
}
