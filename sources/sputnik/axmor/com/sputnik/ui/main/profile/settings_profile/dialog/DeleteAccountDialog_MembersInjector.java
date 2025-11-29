package sputnik.axmor.com.sputnik.ui.main.profile.settings_profile.dialog;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class DeleteAccountDialog_MembersInjector implements MembersInjector<DeleteAccountDialog> {
    public static void injectFactory(DeleteAccountDialog deleteAccountDialog, MultiViewModelFactory multiViewModelFactory) {
        deleteAccountDialog.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(DeleteAccountDialog deleteAccountDialog, LocalizationStorage localizationStorage) {
        deleteAccountDialog.localizationScreen = localizationStorage;
    }
}
