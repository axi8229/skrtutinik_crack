package sputnik.axmor.com.sputnik.ui.main.profile.card;

import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.common.viewmodels.MultiViewModelFactory;
import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class DeletePaymentMethodDialog_MembersInjector implements MembersInjector<DeletePaymentMethodDialog> {
    public static void injectFactory(DeletePaymentMethodDialog deletePaymentMethodDialog, MultiViewModelFactory multiViewModelFactory) {
        deletePaymentMethodDialog.factory = multiViewModelFactory;
    }

    public static void injectLocalizationScreen(DeletePaymentMethodDialog deletePaymentMethodDialog, LocalizationStorage localizationStorage) {
        deletePaymentMethodDialog.localizationScreen = localizationStorage;
    }
}
