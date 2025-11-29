package com.sputnik.oboarding.ui.registration;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class DeleteAccountBottomSheet_MembersInjector implements MembersInjector<DeleteAccountBottomSheet> {
    public static void injectFactory(DeleteAccountBottomSheet deleteAccountBottomSheet, MultiViewModelFactory multiViewModelFactory) {
        deleteAccountBottomSheet.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(DeleteAccountBottomSheet deleteAccountBottomSheet, LocalizationStorage localizationStorage) {
        deleteAccountBottomSheet.localizationScreen = localizationStorage;
    }
}
