package sputnik.axmor.com.sputnik.ui.main.market.services.digital_keys_service.dialog;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class UpdateTempCodeDialog_MembersInjector implements MembersInjector<UpdateTempCodeDialog> {
    public static void injectFactory(UpdateTempCodeDialog updateTempCodeDialog, MultiViewModelFactory multiViewModelFactory) {
        updateTempCodeDialog.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(UpdateTempCodeDialog updateTempCodeDialog, LocalizationStorage localizationStorage) {
        updateTempCodeDialog.localizationScreen = localizationStorage;
    }
}
