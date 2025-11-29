package sputnik.axmor.com.sputnik.ui.main.profile.localization;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class LocalizationBottomSheet_MembersInjector implements MembersInjector<LocalizationBottomSheet> {
    public static void injectLocalizationScreen(LocalizationBottomSheet localizationBottomSheet, LocalizationStorage localizationStorage) {
        localizationBottomSheet.localizationScreen = localizationStorage;
    }

    public static void injectFactory(LocalizationBottomSheet localizationBottomSheet, MultiViewModelFactory multiViewModelFactory) {
        localizationBottomSheet.factory = multiViewModelFactory;
    }
}
