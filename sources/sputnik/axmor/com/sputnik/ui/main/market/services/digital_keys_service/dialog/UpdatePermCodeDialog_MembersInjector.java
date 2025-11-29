package sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class UpdatePermCodeDialog_MembersInjector implements MembersInjector<UpdatePermCodeDialog> {
    public static void injectFactory(UpdatePermCodeDialog updatePermCodeDialog, MultiViewModelFactory multiViewModelFactory) {
        updatePermCodeDialog.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(UpdatePermCodeDialog updatePermCodeDialog, LocalizationStorage localizationStorage) {
        updatePermCodeDialog.localizationScreen = localizationStorage;
    }
}
