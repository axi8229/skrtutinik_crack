package sputnik.axmor.com.sputnik.ui.main.market.services.fr_service.dialogs;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class FrRemoveDialog_MembersInjector implements MembersInjector<FrRemoveDialog> {
    public static void injectFactory(FrRemoveDialog frRemoveDialog, MultiViewModelFactory multiViewModelFactory) {
        frRemoveDialog.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(FrRemoveDialog frRemoveDialog, LocalizationStorage localizationStorage) {
        frRemoveDialog.localizationScreen = localizationStorage;
    }
}
