package com.sputnik.oboarding.ui.localization;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class LocalizationStartBottomSheet_MembersInjector implements MembersInjector<LocalizationStartBottomSheet> {
    public static void injectLocalizationScreen(LocalizationStartBottomSheet localizationStartBottomSheet, LocalizationStorage localizationStorage) {
        localizationStartBottomSheet.localizationScreen = localizationStorage;
    }

    public static void injectFactory(LocalizationStartBottomSheet localizationStartBottomSheet, MultiViewModelFactory multiViewModelFactory) {
        localizationStartBottomSheet.factory = multiViewModelFactory;
    }
}
