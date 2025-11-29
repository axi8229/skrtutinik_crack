package sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class DeleteCodeDialog_MembersInjector implements MembersInjector<DeleteCodeDialog> {
    public static void injectFactory(DeleteCodeDialog deleteCodeDialog, MultiViewModelFactory multiViewModelFactory) {
        deleteCodeDialog.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(DeleteCodeDialog deleteCodeDialog, LocalizationStorage localizationStorage) {
        deleteCodeDialog.localizationScreen = localizationStorage;
    }
}
